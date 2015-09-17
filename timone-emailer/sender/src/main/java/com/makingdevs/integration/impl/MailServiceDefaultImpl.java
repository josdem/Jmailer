package com.makingdevs.integration.impl;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.makingdevs.integration.MailService;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service("mailService")
public class MailServiceDefaultImpl implements MailService {

  @SuppressWarnings("unused")
  private static final Log log = LogFactory.getLog(MailServiceDefaultImpl.class);

  @Autowired
  private Configuration configuration;
  @Autowired
  private JavaMailSender javaMailSender;
  
  private String sender = "noreply@trama.mx";
  
  public void sendMailWithEngine(final String email, final Map model, final String subject, final String template) {
    MimeMessagePreparator preparator = new MimeMessagePreparator() {
      public void prepare(MimeMessage mimeMessage) throws Exception {
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
        Template myTemplate = configuration.getTemplate(template);
        message.setTo(email);
        message.setFrom(sender);
        message.setSubject(subject);
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(myTemplate, model);
        message.setText(text, true);
      }
    };
    this.javaMailSender.send(preparator);
  }

}
