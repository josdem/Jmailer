package com.jos.dem.messengine;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.jms.ObjectMessage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jos.dem.messengine.JmsMessageListener;
import com.jos.dem.bean.MessageType;
import com.jos.dem.bean.mail.MessageBean;
import com.jos.dem.service.NotificationService;

public class TestMessageConsumer {

	@InjectMocks
	private JmsMessageListener messageConsumer = new JmsMessageListener();

	@Mock
	private ObjectMessage message;
	@Mock
	private MessageBean simpleBean;
	@Mock
	private NotificationService notificationService;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReceiveMessage() throws Exception {
		when(simpleBean.getType()).thenReturn(MessageType.MESSAGE);
		when(message.getObject()).thenReturn(simpleBean);

		messageConsumer.onMessage(message);

		verify(notificationService).sendNotification(simpleBean);
	}

}
