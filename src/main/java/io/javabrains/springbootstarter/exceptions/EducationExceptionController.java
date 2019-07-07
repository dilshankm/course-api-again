package io.javabrains.springbootstarter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.javabrains.springbootstarter.topic.exceptions.TopicNotFoundException;

@ControllerAdvice
public class EducationExceptionController {
	
	@ExceptionHandler(TopicNotFoundException.class)
	public ResponseEntity<Object> topicNotFoundException(TopicNotFoundException exception){
		return new ResponseEntity<>("Topic not found.",HttpStatus.NOT_FOUND);
	}
	
	
}
