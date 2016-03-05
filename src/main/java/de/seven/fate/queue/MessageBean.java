package de.seven.fate.queue;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Connects to the JMS queue of the HornetQ server.
 * Created by Mario on 05.03.2016.
 */
@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/ExpiryQueue")
        }
)
@Startup
@ApplicationScoped
public class MessageBean implements MessageListener {

    private static final Logger logger = Logger.getLogger(MessageBean.class);

    public void onMessage(Message message) {
        logger.debug("get message from jms: " + message);

        System.out.println("#########################################################");
        System.out.println("#########################################################");
        System.out.println("#########################################################");
        System.out.println("Start JMS");
        System.out.println("#########################################################");
        System.out.println("#########################################################");
        System.out.println("#########################################################");
    }

}
