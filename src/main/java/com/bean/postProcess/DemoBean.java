package com.bean.postProcess;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DemoBean implements BeanPostProcessor/*, InitializingBean*/ {
	private String message;
	private int initializationSequenceCounter;

	public DemoBean() {
		initializationSequenceCounter++;
		System.out.println(initializationSequenceCounter
				+ ": In default constructor");
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		initializationSequenceCounter++;
		System.out.println(initializationSequenceCounter
				+ ": In post process before intialization");
		return null;
	}

	public Object postProcessAfterInitialization(Object bean, String name) {
		System.out.println(initializationSequenceCounter
				+ ": In post process after initialization");
		return null;
	}

	public void afterPropertiesSet() throws Exception {
		initializationSequenceCounter++;
		System.out.println(initializationSequenceCounter
				+ ": In after properties set method");
	}

	public void init() {
		initializationSequenceCounter++;
		System.out.println(initializationSequenceCounter + ": In init-method");
	}
}
