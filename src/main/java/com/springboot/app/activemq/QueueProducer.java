package com.springboot.app.activemq;

import org.apache.activemq.spring.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ClassName: QueueProducer
 * @Description:队列消息模式
 * @author: chenliang
 * @date: 2018/1/2 下午3:49
 */
public class QueueProducer {

    private static final String url = "tcp://localhost:61616";

    private static final String queueName = "queue-test";


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
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

            //5. 创建目标
            Destination destination = session.createQueue(queueName);

            //6. 创建生产者
            MessageProducer messageProducer = session.createProducer(destination);

            for (int i = 0; i < 50; i++) {
                //7. 创建消息
                TextMessage textMessage = session.createTextMessage("test"+i);
                messageProducer.send(textMessage);

                System.out.println("生产者："+textMessage.getText());
            }

            //9. 关闭连接
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }



    }

}
