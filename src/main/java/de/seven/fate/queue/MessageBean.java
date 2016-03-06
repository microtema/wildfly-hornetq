package de.seven.fate.queue;

import de.seven.fate.queue.processor.*;
import org.apache.log4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.jms.*;

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
@ApplicationScoped
public class MessageBean implements MessageListener {

    private static final Logger logger = Logger.getLogger(MessageBean.class);

    @Inject
    private ByteMessageProcessor bytesMessageProcessor;

    @Inject
    private MapMessageProcessor mapMessageProcessor;

    @Inject
    private ObjectMessageProcessor objectMessageProcessor;

    @Inject
    private StreamMessageProcessor streamMessageProcessor;

    @Inject
    private TextMessageProcessor textMessageProcessor;


    public void onMessage(Message message) {

        try {

            logger.info("process JMSMessage: " + message.getJMSMessageID());

            MessageProcessor messageProcessor = getMessageProcessor(message);

            messageProcessor.process(message);

        } catch (JMSException e) {
            logger.warn("unable to process jms message" + message, e);
        }
    }


    private MessageProcessor getMessageProcessor(Message message) {
        assert message != null;

        if (message instanceof BytesMessage) {
            return bytesMessageProcessor;
        }

        if (message instanceof MapMessage) {
            return mapMessageProcessor;
        }

        if (message instanceof ObjectMessage) {
            return objectMessageProcessor;
        }

        if (message instanceof StreamMessage) {
            return streamMessageProcessor;
        }

        if (message instanceof TextMessage) {
            return textMessageProcessor;
        }

        throw new IllegalArgumentException("Unable to find MessageProcessor with message: <" + message.getClass() + ">");
    }

}
