package de.seven.fate.queue.processor;

import de.seven.fate.queue.MessageProcessor;
import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.jms.JMSException;
import javax.jms.StreamMessage;

/**
 * Created by Mario on 05.03.2016.
 */
@ApplicationScoped
public class StreamMessageProcessor implements MessageProcessor<StreamMessage> {

    private static final Logger logger = Logger.getLogger(StreamMessageProcessor.class);


    public void process(StreamMessage message) throws JMSException{

       logger.info("JMS-Stream-Message: " + message.getPropertyNames());
    }
}
