package com.bonadykov.serverstrategy;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrashController implements ErrorController{
	/**
	 * Error Handler
	 */
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
    	ExpressionParser parser = new SpelExpressionParser();
    	Expression exp = parser.parseExpression("'You were not supposed to see this'");
    	String message = (String) exp.getValue();
    	return message;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}