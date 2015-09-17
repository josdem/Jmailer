package com.makingdevs.integration.mail;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.makingdevs.integration.MailService;
import com.makingdevs.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/mail-context.xml" })
@Ignore
public class TestMailService {

  @Autowired
  private MailService mailService;

  private String destEmail = "test@trama.mx";

  @Test
  public void testMail() throws MessagingException {
    User user = new User();
    user.setUserName("Jose");
    user.setEmail(destEmail);
    Map model = new HashMap();
    model.put("user", user);
    mailService.sendMailWithEngine(destEmail, model, "Mail con Template", "template.ftl");
  }
}
