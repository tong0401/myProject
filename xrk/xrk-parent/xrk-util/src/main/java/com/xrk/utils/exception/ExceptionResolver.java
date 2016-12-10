package com.xrk.utils.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;


@Component
public class ExceptionResolver extends AbstractHandlerExceptionResolver {
	final Logger log = LoggerFactory.getLogger(ExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		
		ModelAndView view = new ModelAndView("jsonView");
		if(ex instanceof GMException){
			String subCode = ((GMException) ex).getSubCode();
			view.addObject("error", true);
			view.addObject("errorCode", GMSOAException.ISV);
			view.addObject("subCode", subCode);
			view.addObject("errorMsg", ex.getMessage());
			return view;
		}  else if (ex instanceof HttpSessionRequiredException) {
			view.addObject("error", true);
			view.addObject("errorCode", GMSOAException.ISV);
			view.addObject("subCode", GMSOAExceptionConstant.UPAL_NEED_SESSION_EXCEPTION);
			view.addObject("errorMsg", GMSOAExceptionConstant.UPAL_NEED_SESSION_EXCEPTION_MESSAGE);
			return view;
		} else if (ex instanceof MissingServletRequestParameterException) {
			view.addObject("error", true);
			view.addObject("errorCode", GMSOAException.ISV);
			view.addObject("subCode", GMSOAExceptionConstant.UPAL_PARAM_REQUIRED_EXCEPTION);
			view.addObject("errorMsg", ex.getMessage());
			return view;
		} else {
			view.addObject("error", true);
			view.addObject("errorCode", GMSOAException.ISP);
			view.addObject("subCode",GMSOAExceptionConstant.UPAL_UNKNOWN_EXCEPTION);
			view.addObject("errorMsg",ex.getMessage());
			log.error("", ex);
			return view;
		}
	}
}