package com.jos.dem.messengine

import static com.jos.dem.bean.MessageType.*
import groovy.transform.AutoClone

import javax.jms.JMSException
import javax.jms.Message
import javax.jms.MessageListener
import javax.jms.ObjectMessage

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.makingdevs.integration.MailService
import com.jos.dem.bean.mail.EmailBean
import com.jos.dem.service.NotificationService

@Service
class JmsMessageListener implements MessageListener {

  @Autowired
  NotificationService notificationService

	Log log = LogFactory.getLog(getClass())

	def void onMessage(Message message) {
		log.info("MESSAGE RECEIVED")
		try {
      Object messageBean = ((ObjectMessage) message).getObject()
      notificationService.sendNotification(messageBean)
		} catch (JMSException jmse) {
			log.error(jmse, jmse)
		}
	}

}
