package com.qianfeng.test;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

/*public class TopicTest {

    @Test
    public void testQueue() throws JMSException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://47.100.31.218:61616");

        //获取连接
        Connection connection = connectionFactory.createConnection();

        //开启连接
        connection.start();
        //获取会话
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //同过会话创建quene
        Topic topic = session.createTopic("myFirstTopic");
        //获得生产者
        MessageProducer producer = session.createProducer(topic);

        //获得消息
        Message message = session.createTextMessage("hello,mytopic!");
        //发送消息
        producer.send(message);

        //释放资源
        producer.close();
        session.close();
        connection.close();
    }

    @Test
    public void testReceive() throws JMSException, IOException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://47.100.31.218:61616");

        //获取连接
        Connection connection = connectionFactory.createConnection();

        //开启连接
        connection.start();
        //获取会话
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //同过会话创建quene
        Topic topic = session.createTopic("myFirstTopic");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(topic);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println(text);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        //释放资源
        consumer.close();
        session.close();
        connection.close();
    }
}*/
