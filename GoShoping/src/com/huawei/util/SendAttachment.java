package com.huawei.util;
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
	private String MailHost; // 邮件服务器
	private String UserName; // 用户名
	private String PassWord; // 用户密码
	private MimeMessage mimeMsg; // MIME邮件对象
	private Session session; // 邮件会话对象
	private Properties props; // 系统属性
	private Multipart mp; // Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象
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
		System.out.println("设置系统属性：mail.smtp.host = " + hostName);
		if (props == null) 
		{ // 获得系统属性对象
			props = System.getProperties();
		}
		props.put("mail.smtp.host", hostName); // 设置SMTP主机 hostName="smtp.163.com";
		props.put("mail.smtp.port", "587");
		// 此处填写你的账号
		props.put("mail.user", "834162364@qq.com");
		// 此处的密码就是前面说的16位STMP口令
		props.put("mail.password", "ivyelwftblplbcij");
		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
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
			System.out.println("准备获取邮件会话对象！");
			// session = Session.getDefaultInstance(props, null); //获得邮件会话对象
			session = Session.getInstance(props, null);
		}
		catch (Exception e)
		{
			System.err.println("获取邮件会话对象时发生错误！" + e);
			return false;
		}
		System.out.println("准备创建MIME邮件对象！");
		try
		{
			mimeMsg = new MimeMessage(session); // 创建MIME邮件对象
			mp = new MimeMultipart();
			return true;
		} 
		catch (Exception e)
		{
			System.err.println("创建MIME邮件对象失败！" + e);
			return false;
		}
	}
	public void setNeedAuth(boolean need)
	{
		System.out.println("设置smtp身份认证：mail.smtp.auth = " + need);
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
	 * 设置用户名和密码
	 *
	 * @param String
	 *            name 用户名
	 *
	 * @param String
	 *            pass 密码
	 *
	 */
	public void setNamePass(String name, String pass)
	{
		UserName = name;
		PassWord = pass;
	}
	/**
	 * 设置邮件主题
	 *
	 * @param String
	 *            mailsubject 邮件主题
	 * 
	 * @return boolean
	 */
	public boolean setSubject(String mailSubject)
	{
		System.out.println("设置邮件主题！");
		try 
		{
			mimeMsg.setSubject(mailSubject);
			return true;
		} 
		catch (Exception e)
		{
			System.err.println("设置邮件主题发生错误！");
			return false;
		}
	}
	/**
	 * 邮件主体
	 *
	 * @param String
	 *            mailbody 邮件主体
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
			System.err.println("设置邮件正文时发生错误！" + e);
			return false;
		}
	}
	/**
	 * 添加附件
	 *
	 * @param String
	 *            filename 文件名
	 * 
	 * @return boolean
	 */
	public boolean addFileAffix(String filename)
	{
		System.out.println("增加邮件附件：" + filename);
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
			System.err.println("增加邮件附件：" + filename + "发生错误！" + e);
			return false;
		}
	}
	/**
	 * 发件人邮箱
	 *
	 * @param String
	 *            from 发件人邮箱
	 * 
	 * @return boolean
	 */
	public boolean setFrom(String from)
	{
		System.out.println("设置发信人！");
		try 
		{
			mimeMsg.setFrom(new InternetAddress(from)); // 设置发信人
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}
	/**
	 * 收件人
	 *
	 * @param String
	 *            to 收件人邮箱
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
	 * 抄送邮件
	 *
	 * @param String
	 *            抄送地址
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
	 * 发送邮件
	 * 
	 */
	public boolean sendout() 
	{
		try 
		{
			mimeMsg.setContent(mp);
			mimeMsg.saveChanges();
			System.out.println("正在发送邮件....");
			// mailSession = Session.getInstance(props, null);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect((String) props.get("mail.smtp.host"), UserName, PassWord);
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			// transport.send(mimeMsg);
			System.out.println("发送邮件成功！");
			transport.close();
			return true;
		} 
		catch (Exception e)
		{
			System.err.println("邮件发送失败！" + e);
			return false;
		}
	}
	/**
	 * Just do it as this
	 */
	public static void main(String[] args)
	{
		String mailbody = "<meta http-equiv=Content-Type content=text/html;charset=utf-8>"
				+ "<div align=center>邮件正文内容</div>" + "<a href='http://www.baidu.com/'>百度aaaaaaaaaaaaaashabi</a>";
		SendAttachment themail = new SendAttachment("smtp.qq.com");
		themail.setNeedAuth(true);
		if (themail.setSubject("邮件主题") == false)
			return;
		if (themail.setBody(mailbody) == false)
			return;
		if (themail.setTo("834162364@qq.com") == false)
			return;
		// 以上是收件人处理
		if (themail.setFrom("834162364@qq.com") == false)
			return;
		// 发送附件
		// if(themail.addFileAffix("d:\\工作日志20100524.xls") == false) return;
		themail.setNamePass("834261263@qq.com", "ivyelwftblplbcij");
		if (themail.sendout() == false)
			return;
	}
}