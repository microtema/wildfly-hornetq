package de.seven.fate.queue;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * Created by Mario on 05.03.2016.
 */
public interface MessageProcessor<M extends Message> {

    void process(M message) throws JMSException;
}
