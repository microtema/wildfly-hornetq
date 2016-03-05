package de.seven.fate.queue.client;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by Mario on 05.03.2016.
 */
@Startup
@Singleton
public class MessageBeanSender {

    private static final Logger logger = Logger.getLogger(MessageBeanSender.class);

    @PostConstruct
    private void init() {


        try {
            InitialContext initialContext = new InitialContext();

            //get configured factory:
            QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) initialContext.lookup("java:/jboss/exported/jms/RemoteConnectionFactory");

            //get configured queue:
            Queue queue = (Queue) initialContext.lookup("java:/jms/queue/ExpiryQueue");


            //create connection:
            //set user with [guest] Role
            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection("mtema", "secret");
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueSender queueSender = queueSession.createSender(queue);

            //Sent Message:
            TextMessage textMessage = queueSession.createTextMessage();
            textMessage.setText("Go for it...");

            queueSender.send(textMessage);

            //close streams:
            queueSender.close();
            queueSession.close();
            queueConnection.close();

            //Done.
            logger.info("Message has been sent and should found in Server-log!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
