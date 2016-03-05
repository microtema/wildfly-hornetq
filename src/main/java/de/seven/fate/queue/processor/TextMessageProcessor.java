package de.seven.fate.queue.processor;

import de.seven.fate.queue.MessageProcessor;
import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by Mario on 05.03.2016.
 */
@ApplicationScoped
public class TextMessageProcessor implements MessageProcessor<TextMessage> {

    private static final Logger logger = Logger.getLogger(TextMessageProcessor.class);


    public void process(TextMessage message) throws JMSException {

        logger.info("JMS-Text-Message: " + message.getText());
    }
}
