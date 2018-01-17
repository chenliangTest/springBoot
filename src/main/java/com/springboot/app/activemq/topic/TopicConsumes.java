package com.springboot.app.activemq.topic;

import org.apache.activemq.spring.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicConsumes {

    private static final String url = "tcp://localhost:61616";

    private static final String topicName = "topic-test";


    public static void main(String[] args) {

        //1. 创建工厂ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

        //2. 创建连接
        Connection connection = null;
        try {
            //2. 创建连接
            connection = connectionFactory.createConnection();

            //3. 启动连接
            connection.start();

            //4. 创建会话
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //5. 创建目标
            Destination destination = session.createTopic(topicName);

            //6. 创建消费者
            MessageConsumer messageConsumer = session.createConsumer(destination);

            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;

                    try {
                        System.out.println("消费者："+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            //9. 关闭连接
            //connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
