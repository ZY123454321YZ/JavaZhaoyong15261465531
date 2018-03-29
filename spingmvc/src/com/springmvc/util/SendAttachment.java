package com.springmvc.util;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendAttachment {
	private String MailHost; // �ʼ�������
	private String UserName; // �û���
	private String PassWord; // �û�����
	private MimeMessage mimeMsg; // MIME�ʼ�����
	private Session session; // �ʼ��Ự����
	private Properties props; // ϵͳ����
	private Multipart mp; // Multipart����,�ʼ�����,����,���������ݾ���ӵ����к�������MimeMessage����
	private Session mailSession;
	public SendAttachment()
	{
	}
	public SendAttachment(String smtp) 
	{
		MailHost = "smtp.qq.com";
		setSmtpHost(smtp);
		createMimeMessage();
	}
	/**
	 * @param hostName
	 *            String
	 */
	public void setSmtpHost(String hostName) 
	{
		System.out.println("����ϵͳ���ԣ�mail.smtp.host = " + hostName);
		if (props == null) 
		{ // ���ϵͳ���Զ���
			props = System.getProperties();
		}
		props.put("mail.smtp.host", hostName); // ����SMTP���� hostName="smtp.163.com";
		props.put("mail.smtp.port", "587");
		// �˴���д����˺�
		props.put("mail.user", "834162364@qq.com");
		// �˴����������ǰ��˵��16λSTMP����
		props.put("mail.password", "ivyelwftblplbcij");
		// ������Ȩ��Ϣ�����ڽ���SMTP���������֤
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// �û���������
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		mailSession = Session.getInstance(props, authenticator);
	}
	public boolean createMimeMessage() 
	{
		try
		{
			System.out.println("׼����ȡ�ʼ��Ự����");
			// session = Session.getDefaultInstance(props, null); //����ʼ��Ự����
			session = Session.getInstance(props, null);
		}
		catch (Exception e)
		{
			System.err.println("��ȡ�ʼ��Ự����ʱ��������" + e);
			return false;
		}
		System.out.println("׼������MIME�ʼ�����");
		try
		{
			mimeMsg = new MimeMessage(session); // ����MIME�ʼ�����
			mp = new MimeMultipart();
			return true;
		} 
		catch (Exception e)
		{
			System.err.println("����MIME�ʼ�����ʧ�ܣ�" + e);
			return false;
		}
	}
	public void setNeedAuth(boolean need)
	{
		System.out.println("����smtp�����֤��mail.smtp.auth = " + need);
		if (props == null)
		{
			props = System.getProperties();
		}
		if (need) 
		{
			props.put("mail.smtp.auth", "true");
		} 
		else 
		{
			props.put("mail.smtp.auth", "false");
		}
	}
	/**
	 * �����û���������
	 *
	 * @param String
	 *            name �û���
	 *
	 * @param String
	 *            pass ����
	 *
	 */
	public void setNamePass(String name, String pass)
	{
		UserName = name;
		PassWord = pass;
	}
	/**
	 * �����ʼ�����
	 *
	 * @param String
	 *            mailsubject �ʼ�����
	 * 
	 * @return boolean
	 */
	public boolean setSubject(String mailSubject)
	{
		System.out.println("�����ʼ����⣡");
		try 
		{
			mimeMsg.setSubject(mailSubject);
			return true;
		} 
		catch (Exception e)
		{
			System.err.println("�����ʼ����ⷢ������");
			return false;
		}
	}
	/**
	 * �ʼ�����
	 *
	 * @param String
	 *            mailbody �ʼ�����
	 * 
	 * @return boolean
	 */
	public boolean setBody(String mailBody)
	{
		try 
		{
			BodyPart bp = new MimeBodyPart();
			bp.setContent("<meta http-equiv=Content-Type content=text/html;charset=gb2312>" + mailBody,
					"text/html;charset=GB2312");
			mp.addBodyPart(bp);
			return true;
		} 
		catch (Exception e)
		{
			System.err.println("�����ʼ�����ʱ��������" + e);
			return false;
		}
	}
	/**
	 * ��Ӹ���
	 *
	 * @param String
	 *            filename �ļ���
	 * 
	 * @return boolean
	 */
	public boolean addFileAffix(String filename)
	{
		System.out.println("�����ʼ�������" + filename);
		try 
		{
			BodyPart bp = new MimeBodyPart();
			FileDataSource fileds = new FileDataSource(filename);
			bp.setDataHandler(new DataHandler(fileds));
			bp.setFileName(fileds.getName());
			mp.addBodyPart(bp);
			return true;
		} 
		catch (Exception e) 
		{
			System.err.println("�����ʼ�������" + filename + "��������" + e);
			return false;
		}
	}
	/**
	 * ����������
	 *
	 * @param String
	 *            from ����������
	 * 
	 * @return boolean
	 */
	public boolean setFrom(String from)
	{
		System.out.println("���÷����ˣ�");
		try 
		{
			mimeMsg.setFrom(new InternetAddress(from)); // ���÷�����
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}
	/**
	 * �ռ���
	 *
	 * @param String
	 *            to �ռ�������
	 * 
	 * @return boolean
	 */
	public boolean setTo(String to) 
	{
		if (to == null)
			return false;
		try 
		{
			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}
	/**
	 * �����ʼ�
	 *
	 * @param String
	 *            ���͵�ַ
	 * 
	 * @return boolean
	 */
	// public boolean setCopyTo(String copyto){
	// if(copyto == null)return false;
	// try{
	// imeMsg.setRecipients(Message.RecipientType.CC,
	// (Address[])InternetAddress.parse(copyto));
	// return true;
	// }catch(Exception e){
	// return false;
	// }
	// }
	/**
	 *
	 * �����ʼ�
	 * 
	 */
	public boolean sendout() 
	{
		try 
		{
			mimeMsg.setContent(mp);
			mimeMsg.saveChanges();
			System.out.println("���ڷ����ʼ�....");
			// mailSession = Session.getInstance(props, null);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect((String) props.get("mail.smtp.host"), UserName, PassWord);
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			// transport.send(mimeMsg);
			System.out.println("�����ʼ��ɹ���");
			transport.close();
			return true;
		} 
		catch (Exception e)
		{
			System.err.println("�ʼ�����ʧ�ܣ�" + e);
			return false;
		}
	}
	/**
	 * Just do it as this
	 */
	public static void main(String[] args)
	{
		String mailbody = "<meta http-equiv=Content-Type content=text/html;charset=utf-8>"
				+ "<div align=center>�ʼ���������</div>" + "<a href='http://www.baidu.com/'>�ٶ�aaaaaaaaaaaaaashabi</a>";
		SendAttachment themail = new SendAttachment("smtp.qq.com");
		themail.setNeedAuth(true);
		if (themail.setSubject("�ʼ�����") == false)
			return;
		if (themail.setBody(mailbody) == false)
			return;
		if (themail.setTo("834162364@qq.com") == false)
			return;
		// �������ռ��˴���
		if (themail.setFrom("834162364@qq.com") == false)
			return;
		// ���͸���
		// if(themail.addFileAffix("d:\\������־20100524.xls") == false) return;
		themail.setNamePass("834261263@qq.com", "ivyelwftblplbcij");
		if (themail.sendout() == false)
			return;
	}
}