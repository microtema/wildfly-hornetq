package de.seven.fate.queue;

import de.seven.fate.queue.processor.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.inject.Inject;
import javax.jms.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by Mario on 06.03.2016.
 */
@RunWith(PowerMockRunner.class)
public class MessageBeanTest {

    @InjectMocks
    MessageBean sut;

    @Mock
    ByteMessageProcessor bytesMessageProcessor;

    @Mock
    MapMessageProcessor mapMessageProcessor;

    @Mock
    ObjectMessageProcessor objectMessageProcessor;

    @Mock
    StreamMessageProcessor streamMessageProcessor;

    @Mock
    TextMessageProcessor textMessageProcessor;

    @Mock
    Message message;

    @Mock
    TextMessage textMessage;

    @Mock
    BytesMessage bytesMessage;

    @Mock
    StreamMessage streamMessage;

    @Mock
    ObjectMessage objectMessage;

    @Mock
    MapMessage mapMessage;


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() throws Exception {
        sut.onMessage(message);
    }

    @Test
    public void shouldProcessTextMessage() throws Exception {

        sut.onMessage(textMessage);

        verify(textMessageProcessor, times(1)).process(textMessage);
    }

    @Test
    public void shouldProcessBytesMessage() throws Exception {

        sut.onMessage(bytesMessage);

        verify(bytesMessageProcessor, times(1)).process(bytesMessage);
    }

    @Test
    public void shouldProcessStreamMessage() throws Exception {

        sut.onMessage(streamMessage);

        verify(streamMessageProcessor, times(1)).process(streamMessage);
    }

    @Test
    public void shouldProcessObjectMessage() throws Exception {

        sut.onMessage(objectMessage);

        verify(objectMessageProcessor, times(1)).process(objectMessage);
    }

    @Test
    public void shouldProcessMapMessage() throws Exception {

        sut.onMessage(mapMessage);

        verify(mapMessageProcessor, times(1)).process(mapMessage);
    }
}