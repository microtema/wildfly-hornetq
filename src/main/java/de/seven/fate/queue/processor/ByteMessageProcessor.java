package de.seven.fate.queue.processor;

import de.seven.fate.queue.MessageProcessor;
import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.jms.BytesMessage;
import javax.jms.JMSException;

/**
 * Created by Mario on 05.03.2016.
 */
@ApplicationScoped
public class ByteMessageProcessor implements MessageProcessor<BytesMessage> {

    private static final Logger logger = Logger.getLogger(ByteMessageProcessor.class);


    public void process(BytesMessage message) throws JMSException {
        logger.info("JMS-Bytes-Message: " + message.getPropertyNames());
    }
}
