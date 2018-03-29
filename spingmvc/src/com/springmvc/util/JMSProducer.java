package com.springmvc.util;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 消息的生产者（发送者）
 * 
 * @author ZhaoYong
 *
 */
public class JMSProducer {

	// 默认连接用户名
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	// 默认连接密码
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	// 默认连接地址
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	// 发送的消息数量
	private static final int SENDNUM = 10;
	// 连接工厂
	private static ConnectionFactory connectionFactory;
	// 连接
	private static Connection connection = null;
	// 会话 接受或者发送消息的线程
	private static Session session;
	// 消息的目的地
	private static Destination destination;
	// 消息生产者
	private static MessageProducer messageProducer = null;
	public void sendMessage(String messageQueue,String[]pdcerMessage) throws Exception {
		
		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD,
				JMSProducer.BROKEURL);
		try {
			// 通过连接工厂获取连接
			connection = connectionFactory.createConnection();
			// 启动连接
			connection.start();
			// 创建session
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			// 创建一个名称为messageQueue的消息队列
			destination = session.createQueue(messageQueue);
			// 创建消息生产者
			messageProducer = session.createProducer(destination);
			 //设置不持久化  
			messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			// 发送消息
			sendMessage(session, messageProducer,pdcerMessage);
			session.commit();
		} 
		catch (Exception e) 
		{
			throw e;
		} 
		finally
		{
			if (connection != null) 
			{
					connection.close();
			}
		}
	}

	/**
	 * 发送消息
	 * 
	 * @param session
	 * @param messageProducer
	 *            消息生产者
	 * @throws Exception
	 */
	public static void sendMessage(Session session,
			MessageProducer messageProducer,String...pdcerMessage) throws Exception {
		    for(int index = 0;index < pdcerMessage.length; index++) 
		    {
		    	// 创建一条文本消息
				TextMessage message = session.createTextMessage(pdcerMessage[index]);
				// 通过消息生产者发出消息
				messageProducer.send(message);
		    }
	}
     public static void main(String[] args) throws Exception {
		JMSProducer producer = new JMSProducer();
		String[]meStrings = new String[] {"生产者",
				"不定式","测试"
		};
		producer.sendMessage("topic",meStrings);
	}
}