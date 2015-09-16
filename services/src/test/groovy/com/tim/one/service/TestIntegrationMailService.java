package com.tim.one.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tim.one.bean.MessageType;
import com.tim.one.bean.mail.MessageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/mail-context.xml", "classpath:/services-test-appctx.xml"})
public class TestIntegrationMailService {

  @Autowired
  private NotificationService notificationService;

  private String email = "test@trama.mx";
  private String message = "message";

  @Test
  public void shouldSendMessage() throws Exception {
    MessageBean bean = setBeanExpectations();
    bean.setType(MessageType.MESSAGE);

    notificationService.sendNotification(bean);
  }
  
  private MessageBean setBeanExpectations() {
  	MessageBean bean = new MessageBean();
    bean.setEmail(email);
    bean.setMessage(message);
    return bean;
  }
}
