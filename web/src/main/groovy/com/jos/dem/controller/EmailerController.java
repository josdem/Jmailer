package com.jos.dem.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Properties;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jos.dem.bean.ErrorCode;
import com.jos.dem.command.MessageCommand;
import com.jos.dem.integration.MessageService;
import com.jos.dem.validator.CommandValidator;
import com.jos.dem.bean.MessageType;
import com.jos.dem.bean.mail.MessageBean;

/**
 * @author josdem
 * @understands A class who knows how to send emails using Json
 *
 */

@Controller
@RequestMapping("/emailer/*")
public class EmailerController {

	@Autowired
	private MessageService messageDispatcher;
	@Autowired
	private CommandValidator validator;
	@Autowired
	private Properties dynamic;

	private Log log = LogFactory.getLog(getClass());

	@RequestMapping(method = POST, value = "/message")
	@ResponseBody
	public ResponseEntity<String> message(@RequestBody String json){
		MessageCommand command = new Gson().fromJson(json, MessageCommand.class);
		log.info("Sending contact email: " + ToStringBuilder.reflectionToString(command));
		
		if(!validator.isValid(command)){
	    return new ResponseEntity<String>("Error: " + ErrorCode.VALIDATOR_ERROR.ordinal(), HttpStatus.BAD_REQUEST);
		}
		
		MessageBean bean = new MessageBean();
    bean.setEmail(command.getEmail());
    bean.setMessage(command.getMessage());
    bean.setType(MessageType.MESSAGE);
    messageDispatcher.message(bean);
    return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
}