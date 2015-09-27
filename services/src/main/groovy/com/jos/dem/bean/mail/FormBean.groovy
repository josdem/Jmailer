package com.jos.dem.bean.mail

import org.hibernate.validator.constraints.SafeHtml

import com.jos.dem.bean.MessageType

class FormBean implements EmailBean {
	String email
	String emailContact
	String name
	String message
	MessageType type
}
