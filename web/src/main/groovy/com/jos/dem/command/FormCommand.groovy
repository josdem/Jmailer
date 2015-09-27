package com.jos.dem.command

import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.SafeHtml

class FormCommand implements Command {

	@Email
	@NotNull
	String emailContact

	@SafeHtml
	String name

	@SafeHtml
	String message
}
