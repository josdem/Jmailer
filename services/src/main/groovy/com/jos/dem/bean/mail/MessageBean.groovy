package com.jos.dem.bean.mail

import org.hibernate.validator.constraints.SafeHtml

import com.jos.dem.bean.MessageType

class MessageBean implements EmailBean {
	String email
	String message
	MessageType type
}
