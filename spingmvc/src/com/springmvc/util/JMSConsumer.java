package com.springmvc.util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 消息的消费者（接受者）
 * 
 * @author liang
 *
 */
public class JMSConsumer {
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;// 默认连接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;// 默认连接密码
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;// 默认连接地址
	private static ConnectionFactory connectionFactory;// 连接工厂
	private static Connection connection = null;// 连接
	private static Session session;// 会话 接受或者发送消息的线程
	private static Destination destination;// 消息的目的地
	private static MessageConsumer messageConsumer;// 消息的消费者
	private String bufferString = "";
	private String message = "";
	ExecutorService service = Executors.newCachedThreadPool();
	public String receiveMessage() throws Exception {
		final StringBuffer buffer = new StringBuffer();
		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD,
				JMSConsumer.BROKEURL);
	
			// 通过连接工厂获取连接
			connection = connectionFactory.createConnection();
			// 启动连接
			connection.start();
			// 创建session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// 创建一个连接HelloWorld的消息队列
			destination = session.createQueue("topic");
			// 创建消息消费者
			messageConsumer = session.createConsumer(destination);
//			异步接收/事件驱动接收
//			同步接收/阻塞式接收
//			while (true)
//			{    
//           获取下一个消息。这个调用可能导致一段时间的阻塞，直到超时或者有新的消息产生。超时则返回null。
//				TextMessage textMessage = (TextMessage) messageConsumer.receive(1000);
//				TextMessage textMessage = (TextMessage) messageConsumer.receiveNoWait();
//				if (textMessage != null) 
//				{   
//					buffer.append(textMessage.getText() + "\r\n");
//				} 
//				else 
//				{
//					break;
//				}
//			}
			Future<String> result = service.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					messageConsumer.setMessageListener(new MessageListener() {
						@Override
						public void onMessage(Message arg0) {
							try {
								message = ((TextMessage)arg0).getText();
								buffer.append(message);	
							} 
							catch (JMSException e) 
							{
								e.printStackTrace();
							}
						}
					});
					return message;
				}
			});
		  return result.get();
	}
	public static void main(String[] args) throws Exception {
		JMSConsumer consumer = new JMSConsumer();
		String message = consumer.receiveMessage();
		System.out.println(message);
		
	}
	
}