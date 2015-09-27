package com.jos.dem.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.google.gson.Gson;
import com.jos.dem.bean.ErrorCode;
import com.jos.dem.bean.MessageType;
import com.jos.dem.bean.mail.FormBean;
import com.jos.dem.command.FormCommand;
import com.jos.dem.integration.MessageService;
import com.jos.dem.validator.CommandValidator;
import javax.validation.Valid;

/**
 * @author josdem
 * @understands A class who knows how to send emails using http post
 *
 */

@Controller
@RequestMapping("/form/*")
public class FormController {

	@Autowired
	private MessageService messageDispatcher;
	@Autowired
	private CommandValidator validator;

	private Log log = LogFactory.getLog(getClass());

	@RequestMapping(method = POST,  value = "/contact")
	ModelAndView message(@Valid FormCommand command) {
		log.info("Sending contact email: " + ToStringBuilder.reflectionToString(command));

    ModelAndView modelAndView = new ModelAndView();
		FormBean bean = new FormBean();
		bean.setEmail(command.getEmail());
		bean.setEmailContact(command.getEmailContact());
		bean.setName(command.getName());
		bean.setMessage(command.getMessage());
		bean.setType(MessageType.FORM);
		messageDispatcher.message(bean);
		return modelAndView;
	}

}
