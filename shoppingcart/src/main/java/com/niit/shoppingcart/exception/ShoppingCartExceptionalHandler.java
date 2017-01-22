package com.niit.shoppingcart.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ShoppingCartExceptionalHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartExceptionalHandler.class);
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request,Exception e){
	logger.error("SQL Exception Occured:: URL="+ request.getRequestURI());
	ModelAndView mv = new ModelAndView("forward:/error");
	mv.addObject("message", "It seems one of the table OR few fieldsdoes not exist"+ "See the logger for more information");
	mv.addObject("errorMessage", e.getMessage());
	return mv;

}
	@ExceptionHandler(CannotCreateTransactionException.class)
	public ModelAndView dbServerNotStarted(HttpServletRequest request,Exception e){
	logger.error("SQL Exception Occured:: URL="+ request.getRequestURI());
	ModelAndView mv = new ModelAndView("forward:/error");
	mv.addObject("message", "It seems Database server not started");
	mv.addObject("errorMessage", e.getMessage());
	return mv;
}
	
	@ExceptionHandler(QuerySyntaxException.class)
	public ModelAndView handleQuerySyntaxException(HttpServletRequest request,Exception e){
	logger.error("Query Syntax Exception Occured:: URL="+ request.getRequestURI());
	ModelAndView mv = new ModelAndView("forward:/error");
	mv.addObject("message", "It seems one of the query is not proper. See the logger for more info");
	mv.addObject("errorMessage", e.getMessage());
	return mv;
}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView noHandlerException(HttpServletRequest request,Exception e){
	logger.error("NoHandlerException Occured:: URL="+ request.getRequestURI());
	ModelAndView mv = new ModelAndView("forward:/error");
	mv.addObject("message", "No handler found.Invalid URL See the logger for more info");
	mv.addObject("errorMessage", e.getMessage());
	return mv;
}
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(HttpServletRequest request,Exception e){
	logger.error("IOException handler executed");
	ModelAndView mv = new ModelAndView("forward:/error");
	mv.addObject("message", "Not able to connect to server.Please contact administration");
	mv.addObject("errorMessage", e.getMessage());
	return mv;
}
}