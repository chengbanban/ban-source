package com.bill99.ian.midware.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQPublisher {

	// Create a ConnectionFactory，创建连接工厂
	private ActiveMQConnectionFactory connectionFactory;
	
	// Create a Connection，创建连接
	private Connection connection;
	
	private String brokerURL = "tcp://127.0.0.1:61616";
	
	// Create a Session//创建会话
	private Session session;
	
	// Create a MessageProducer from the Session to the Topic or Queue,创建消息生产者
	private MessageProducer producer;
	
	// Create the destination (Topic or Queue)
	private Destination destination;
	
	//queue名称
	private String queueName = "activemq.queue.test1";
	
	//topic名称
	//private String topicName = "";
	
	/**
	 * 生产者/发布者
	 * @throws JMSException
	 */
	public ActiveMQPublisher() throws JMSException {
		try {
			connectionFactory = new ActiveMQConnectionFactory(brokerURL);  
			connection = connectionFactory.createConnection();
        	connection.start();  
        } catch (JMSException jmse) {
        	if (connection!=null) {
        		connection.close();
        	}
        	throw jmse;
        }  
	}
	
	public void sendMessage(String args) throws JMSException {
		try {
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); //指定ACK_Mode签收确认模式为自动确认
	        destination = session.createQueue(queueName);//创建消息目标(点对点模型队列)
	        //destination = session.createTopic(topicName);//创建消息目标(订阅主题)
	        producer = session.createProducer(destination);
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//指定传输模式-非持久性消息
	        // Create a messages，创建消息
	        String text = "Hello world! From: " + Thread.currentThread().getName() + args + " : " + this.hashCode();
	        TextMessage message = session.createTextMessage(text);//创建文本消息
	        // Tell the producer to send the message
	        System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
	        producer.send(message);//发送消息
		} catch (JMSException jmse) {
			if (producer!=null) {
        		producer.close();
        	}
        	if (session!=null) {
        		session.close();
        	}
        	throw jmse;
		}
	}
	
	public void close() throws JMSException {
		if (producer!=null) {
    		producer.close();
    	}
    	if (session!=null) {
    		session.close();
    	}
    	if (connection!=null) {
    		connection.close();
    	}
	}

	public static void main(String[] args) throws JMSException {
		ActiveMQPublisher publisher = new ActiveMQPublisher();
		publisher.sendMessage("-activeMQ publisher");
		publisher.close();
	}
}
