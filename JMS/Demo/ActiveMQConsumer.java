package com.ban.test.message;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Jms消费者/订阅者
 * @author haipeng.cheng
 * 接收和处理消息的方法有两种，分为同步和异步的，一般同步的方式我们是通过MessageConsumer.receive()方法来处理接收到的消息。而异步的方法则是通过注册一个MessageListener的方法，使用MessageConsumer.setMessageListener()。
 *
 */
public class ActiveMQConsumer implements ExceptionListener {

	// Create a ConnectionFactory，创建连接工厂
	private ActiveMQConnectionFactory connectionFactory;
	
	private String brokerURL = "tcp://127.0.0.1:61616";
	
	// Create a Connection，创建连接
	private Connection connection;
	
	// Create a Session//创建会话
	private Session session;
	
	// Create a MessageConsumer from the Session to the Topic or Queue,创建消息消费者
	private MessageConsumer consumer;
	
	// Create the destination (Topic or Queue)
	private Destination destination;
	
	//queue名称
	private String queueName = "activemq.queue.test1";
	
	//topic名称
	//private String topicName = "topic_test";
	
	public ActiveMQConsumer() throws JMSException {
		try {
			// Create a ConnectionFactory，创建连接工厂
			connectionFactory = new ActiveMQConnectionFactory(brokerURL);
			// Create a Connection，创建连接
			connection = connectionFactory.createConnection();
			connection.start();//打开连接
			connection.setExceptionListener(this);//指定连接使用的异常监听器
			// Create a Session，创建会话
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); //指定ACK_Mode签收确认模式为自动确认
			// Create the destination (Topic or Queue)
			destination = session.createQueue(queueName);//创建消息目标(点对点模型队列)
			//destination = session.createTopic(topicName);//创建消息目标(订阅主题)
			// Create a MessageConsumer from the Session to the Topic or Queue//创建消息消费者
			consumer = session.createConsumer(destination);
			//consumer.setMessageListener(new ActiveMQListener());//异步方式获取message
			// Wait for a message-同步方式获取message
			Message message = consumer.receive(1000);//接收1000毫秒内到达的消息，如果没有收到此方法将阻塞等待直到指定超时时间
			while (null!=message) {
				if (message instanceof TextMessage) {//判断消息类型是否为文本消息
					TextMessage textMessage = (TextMessage) message;
					String text = textMessage.getText();
					System.out.println("Received: " + text);
				} else {
					System.out.println("Received: " + message);
				}
				message = consumer.receive(1000);
			}
		} catch (JMSException jmse) {
			close();
			throw jmse;
		}
	}

	@Override
	public void onException(JMSException arg0) {
		// TODO Auto-generated method stub
	}

	public void close() throws JMSException {
		if (consumer!=null) {
			consumer.close();
    	}
    	if (session!=null) {
    		session.close();
    	}
    	if (connection!=null) {
    		connection.close();
    	}
	}
	
	public static void main(String[] args) throws JMSException {
		ActiveMQConsumer consumer = new ActiveMQConsumer();
		//consumer.close();
	}
}
