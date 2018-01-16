package com.huawei.test;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.*;
import javax.swing.JFileChooser;
import javax.media.*;
import javax.media.control.*;
import javax.media.protocol.*;
import javax.media.format.VideoFormat;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.event.*;
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel centerPanel;

    private JLabel fileLabel;

    private JToolBar mainToolBar;

    private JLabel messageLabel;

    private JPanel northPanel;

    private JButton recordButton;

    private JPanel southPanel;

    private CamDataSource dataSource;

    private DataSource camSource;

    private DataSource recordCamSource;

    private DataSink dataSink;

    private Processor processor;

    private Processor recordProcessor;

    private CamStateHelper playhelper;

    private JFileChooser movieChooser;

    public MainFrame(CamDataSource dataSource) {
        this.dataSource = dataSource;

        this.dataSource.setParent(this);

        camSource = dataSource.cloneCamSource();

        initComponents();

        try
        {
            processor = Manager.createProcessor(camSource);
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, 

              "Exception creating processor: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        catch (NoProcessorException e)
        {
            JOptionPane.showMessageDialog(this, 

               "Exception creating processor: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        playhelper = new CamStateHelper(processor);
        if(!playhelper.configure(10000))
        {
            JOptionPane.showMessageDialog(this, 

               "cannot configure processor", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        checkIncoding(processor.getTrackControls());
        processor.setContentDescriptor(null);
        if(!playhelper.realize(10000))
        {
            JOptionPane.showMessageDialog(this, 

               "cannot realize processor", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        setJPEGQuality(processor, 1.0f);
        processor.start();
        processor.getVisualComponent().setBackground(Color.gray);
        centerPanel.add(processor.getVisualComponent(), BorderLayout.CENTER);//视频面板
        centerPanel.add(processor.getControlPanelComponent(), BorderLayout.SOUTH);//视频控制面板
    }
    //界面初始化
    private void initComponents() 
    {
        northPanel = new JPanel();
        messageLabel = new JLabel();
        southPanel = new JPanel();
        mainToolBar = new JToolBar();
        recordButton = new JButton();
        fileLabel = new JLabel();
        centerPanel = new JPanel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("本地视频");
        addWindowListener(new java.awt.event.WindowAdapter() 
        {
            public void windowClosing(WindowEvent evt) 
            {
                formWindowClosing(evt);
            }
        });
        northPanel.setLayout(new BorderLayout());
        messageLabel.setText("状态：");
        northPanel.add(messageLabel, BorderLayout.SOUTH);
        getContentPane().add(northPanel, BorderLayout.NORTH);
        southPanel.setLayout(new BorderLayout());
        recordButton.setText("录制");
        recordButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt) 
            {
                recordButtonActionPerformed(evt);
            }

        });
        mainToolBar.add(recordButton);
        fileLabel.setText("文件:");
        mainToolBar.add(fileLabel);
        southPanel.add(mainToolBar, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        centerPanel.setLayout(new BorderLayout());
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        pack();
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt)
    {
     processor.close();
    }
    //录制当前视频
    private void recordButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(recordButton.getText().equals("录制"))
        {
            fileLabel.setText("文件:");
            if (movieChooser == null) movieChooser = new JFileChooser();
            movieChooser.setDialogType(JFileChooser.SAVE_DIALOG);
            //Add a custom file filter and disable the default
            //(Accept All) file filter.
            movieChooser.addChoosableFileFilter(new MOVFilter());
            movieChooser.setAcceptAllFileFilterUsed(false);
            movieChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int returnVal = movieChooser.showDialog(this, "录制");
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                File file = movieChooser.getSelectedFile();
                if(!file.getName().endsWith(".mov") &&!file.getName().endsWith(".MOV")) 
                	file = new File(file.toString() + ".mov");
                recordToFile(file);
                fileLabel.setText("文件:" + file.toString());
                recordButton.setText("停止");
            }
        }
        else
        {
            stopRecording();
            recordButton.setText("录制");
        }
    }
    void setJPEGQuality(Player p, float val)
    {
        Control cs[] = p.getControls();
        QualityControl qc = null;
        VideoFormat jpegFmt = new VideoFormat(VideoFormat.JPEG);
        // Loop through the controls to find the Quality control for
        // the JPEG encoder.
        for (int i = 0; i < cs.length; i++) 
        {
            if (cs[i] instanceof QualityControl && cs[i] instanceof Owned)
            {
                Object owner = ((Owned)cs[i]).getOwner();
                // Check to see if the owner is a Codec.
                // Then check for the output format.
                if (owner instanceof Codec)
                {
                    Format fmts[] = ((Codec)owner).getSupportedOutputFormats(null);
                    for (int j = 0; j < fmts.length; j++) 
                    {
                        if (fmts[j].matches(jpegFmt))
                        {
                            qc = (QualityControl)cs[i];
                            qc.setQuality(val);
                            break;
                        }
                    }
                }
                if (qc != null) break;
            }
        }
    }
    public void checkIncoding(TrackControl track[])
    {
        for (int i = 0; i < track.length; i++)
        {
            Format format = track[i].getFormat();
            if (track[i].isEnabled() && format instanceof VideoFormat) 
            {
                Dimension size = ((VideoFormat)format).getSize();
                float frameRate = ((VideoFormat)format).getFrameRate();
                int w = (size.width % 8 == 0 ? size.width :(int)(size.width / 8) * 8);
                int h = (size.height % 8 == 0 ? size.height :(int)(size.height / 8) * 8);
                VideoFormat jpegFormat = new VideoFormat(
                   VideoFormat.JPEG_RTP, new Dimension(w, h), Format.NOT_SPECIFIED, Format.byteArray, frameRate);
                messageLabel.setText("状态: 视频将以" + jpegFormat.toString()+"播放");
            }
        }
    }
    public void recordToFile(File file)
    {
        URL movieUrl = null;
        MediaLocator dest = null;
        try
        {
            movieUrl = file.toURL();
            dest = new MediaLocator(movieUrl);
        }
        catch(MalformedURLException e)
        {
        	e.printStackTrace();
        }
        recordCamSource = dataSource.cloneCamSource();
        try
        {
            recordProcessor = Manager.createProcessor(recordCamSource);
        }
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(this, 
               "Exception creating record processor: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        catch (NoProcessorException e) 
        {
            JOptionPane.showMessageDialog(this, 
               "Exception creating record processor: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        playhelper = new CamStateHelper(recordProcessor);
        if(!playhelper.configure(10000))
        {
            JOptionPane.showMessageDialog(this, 
               "cannot configure record processor", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        VideoFormat vfmt = new VideoFormat(VideoFormat.CINEPAK);
        (recordProcessor.getTrackControls())[0].setFormat(vfmt);
        (recordProcessor.getTrackControls())[0].setEnabled(true);
        recordProcessor.setContentDescriptor(new FileTypeDescriptor(FileTypeDescriptor.QUICKTIME));
        Control control = recordProcessor.getControl("javax.media.control.FrameRateControl");
        if ( control != null && control instanceof javax.media.control.FrameRateControl )
           ((javax.media.control.FrameRateControl)control).setFrameRate(15.0f);
        if(!playhelper.realize(10000))
        {
            JOptionPane.showMessageDialog(this, 
               "cannot realize processor", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try 
        {
            if(recordProcessor.getDataOutput()==null)
            {
                JOptionPane.showMessageDialog(this, 
                   "No Data Output", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            dataSink = Manager.createDataSink(recordProcessor.getDataOutput(), dest);
            recordProcessor.start();
            dataSink.open();
            dataSink.start();
        } 
        catch (NoDataSinkException ex)
        {
            JOptionPane.showMessageDialog(this, 
               "No DataSink " + ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(this, 
               "IOException " + ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void stopRecording()
    {
        try
        {
            recordProcessor.close();
            dataSink.stop();
            dataSink.close();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, 
               "cannot stop recording " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}