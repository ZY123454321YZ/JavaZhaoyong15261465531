package com.huawei;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * @author zwx472565
 * 
 */
public class MainSearcher extends JFrame {
	private static MainSearcher cpx;
	private JPanel contentPane;
	private JTextField fileField;
	private JTextField searchTextField;
	private JTextField replaceTextField;
	private File file;
	private final Object object = new Object();
	private static ExecutorService ThreadPool = Executors.newCachedThreadPool();

	public MainSearcher getInstance() {
		synchronized (object) {
			if (cpx == null) {
				return new MainSearcher();
			}
			return cpx;
		}
	}

	public MainSearcher() {
		setTitle("zwx472565");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 91));
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 81, 0, 0, 66, 0 };
		gbl_panel.rowHeights = new int[] { 23, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton button = new JButton("\u9009\u62E9\u6587\u4EF6");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTHWEST;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel.add(button, gbc_button);

		fileField = new JTextField();
		fileField.setEditable(false);
		GridBagConstraints gbc_fileField = new GridBagConstraints();
		gbc_fileField.gridwidth = 3;
		gbc_fileField.insets = new Insets(0, 0, 5, 0);
		gbc_fileField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fileField.gridx = 1;
		gbc_fileField.gridy = 0;
		panel.add(fileField, gbc_fileField);
		fileField.setColumns(10);

		JLabel label = new JLabel("\u641C\u7D22\u6587\u672C\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);

		searchTextField = new JTextField();
		GridBagConstraints gbc_searchTextField = new GridBagConstraints();
		gbc_searchTextField.gridwidth = 3;
		gbc_searchTextField.insets = new Insets(0, 0, 5, 0);
		gbc_searchTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchTextField.gridx = 1;
		gbc_searchTextField.gridy = 1;
		panel.add(searchTextField, gbc_searchTextField);
		searchTextField.setColumns(10);

		JLabel label_1 = new JLabel("\u66FF\u6362\u4E3A\uFF1A");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		panel.add(label_1, gbc_label_1);

		replaceTextField = new JTextField();
		GridBagConstraints gbc_replaceTextField = new GridBagConstraints();
		gbc_replaceTextField.gridwidth = 3;
		gbc_replaceTextField.insets = new Insets(0, 0, 5, 0);
		gbc_replaceTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_replaceTextField.gridx = 1;
		gbc_replaceTextField.gridy = 2;
		panel.add(replaceTextField, gbc_replaceTextField);
		replaceTextField.setColumns(10);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);

		JButton replaceButton = new JButton("\u66FF\u6362");
		replaceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_replaceButton_actionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(replaceButton);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainSearcher frame = new MainSearcher();
		frame.setVisible(true);
	}

	/**
	 * 选择文件按钮事件处理方法
	 *
	 * @param e
	 */
	protected void do_button_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();// 创建文件选择器
		// // 设置文件扩展名过滤器
		chooser.setFileFilter(new FileNameExtensionFilter("txt", "sql"));
		// 设置文件选择模式
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		// 显示文件打开对话框
		int option = chooser.showOpenDialog(this);
		// 确定用户按下打开按钮，而非取消按钮
		if (option != JFileChooser.APPROVE_OPTION)
			return;
		// 获取用户选择的文件对象
		file = chooser.getSelectedFile();
		// 显示文件信息到文本框
		fileField.setText(file.toString());
	}

	/**
	 * 替换按钮的事件处理方法 更改文件编码格式
	 * 
	 * @baseDIR 文件父路径，通过这个路径更新目录下所有文件
	 * @fileName 需要更改的文件类型
	 * @char1 原编码格式，原文件中的需要被替换的字符
	 * @char2 更改后的编码格式，更改后的字符
	 * @param paramert
	 * @throws IOException
	 * @throws InterruptedException
	 */

	protected void do_replaceButton_actionPerformed(ActionEvent event) throws Exception {
		String baseDIR = file.getAbsolutePath();
		// "F:\\tihuan";
		String fileName = "*.sql";
		String char1 = searchTextField.getText().trim();
		String char2 = replaceTextField.getText().trim();
		List resultList = new ArrayList();
		FileSearcher.findFiles(baseDIR, fileName, resultList, char1, char2);
		if (resultList.size() == 0) {
			System.out.println("No File Fount.");
		}
	}

}
