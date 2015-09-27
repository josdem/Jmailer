package com.jos.dem.bean.mail

import org.hibernate.validator.constraints.SafeHtml

import com.jos.dem.bean.MessageType

class FormBean implements FormBean {
	String emailSender
  String emailReceiver
  String name
	String message
	MessageType type
}
