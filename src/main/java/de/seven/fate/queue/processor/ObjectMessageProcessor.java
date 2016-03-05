package de.seven.fate.queue.processor;

import de.seven.fate.queue.MessageProcessor;
import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * Created by Mario on 05.03.2016.
 */
@ApplicationScoped
public class ObjectMessageProcessor implements MessageProcessor<ObjectMessage> {

    private static final Logger logger = Logger.getLogger(ObjectMessageProcessor.class);


    public void process(ObjectMessage message) throws JMSException{

        logger.info("JMS-Object-Message: " + message.getObject());
    }
}
