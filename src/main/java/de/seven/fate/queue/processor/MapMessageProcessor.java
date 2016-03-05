package de.seven.fate.queue.processor;

import de.seven.fate.queue.MessageProcessor;
import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.jms.JMSException;
import javax.jms.MapMessage;

/**
 * Created by Mario on 05.03.2016.
 */
@ApplicationScoped
public class MapMessageProcessor implements MessageProcessor<MapMessage> {

    private static final Logger logger = Logger.getLogger(MapMessageProcessor.class);


    public void process(MapMessage message) throws JMSException {

        logger.info("JMS-Map-Message: " + message.getMapNames());
    }
}
