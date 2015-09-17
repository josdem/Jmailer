package com.jos.dem.integration

import javax.jms.JMSException
import javax.jms.Message
import javax.jms.ObjectMessage
import javax.jms.Session
import javax.jms.Destination

import org.apache.commons.lang.builder.ToStringBuilder
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.core.MessageCreator
import org.springframework.stereotype.Service

import com.jos.dem.bean.mail.EmailBean

/**
 * @author josdem
 * @understands A class who knows how receive http GET requests and delegate to
 *              the MessageService
 */

@Service
class MessageService {

	@Autowired
	JmsTemplate template
	@Autowired
	Destination destination

	Log log = LogFactory.getLog(getClass())

	void message(final EmailBean bean) {
		log.info("CALLING Message")
		log.info("bean: " + ToStringBuilder.reflectionToString(bean))
		template.send(destination, new MessageCreator() {
					Message createMessage(Session session) throws JMSException {
						ObjectMessage message = session.createObjectMessage()
						message.setObject(bean)
						return message
					}
				})
	}
}
