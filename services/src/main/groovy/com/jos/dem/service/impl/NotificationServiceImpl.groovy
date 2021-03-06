package com.jos.dem.service.impl

import org.apache.commons.lang.builder.ToStringBuilder
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

import com.jos.dem.integration.MailService
import com.jos.dem.service.NotificationService
import com.jos.dem.bean.mail.EmailBean

@Service
class NotificationServiceImpl implements NotificationService {

  @Autowired
  @Qualifier("emailProperties")
  Properties emailProperties
  @Autowired
  MailService mailService

  private Log log = LogFactory.getLog(getClass())

  @Override
  void sendNotification(EmailBean messageBean) {
		log.info "messageBean: ${messageBean.dump()}" 
    def (subject, templateName) = obtainSubjectAndResourceToSendNotification(messageBean)
    def data = [subject:subject, templateName:templateName, bean:messageBean]
    sendNotificationWithData(data)
  }

  private def obtainSubjectAndResourceToSendNotification(EmailBean messageBean){
    String templateKey = "${messageBean.type.toString()}_PATH"
    String subjectKey = "${messageBean.type.toString()}_SUBJECT"

    String templateName = emailProperties.getProperty(templateKey)
    String subject = emailProperties.getProperty(subjectKey)

    log.info("Sending email with subject: " + subject)

    [subject, templateName]
  }

  private void sendNotificationWithData(emailData){
    String templateName = emailData.templateName
    def bean = emailData.bean
    String subject = emailData.subject
    mailService.sendMailWithEngine(bean.email, bean.properties, subject, templateName)
  }
}
