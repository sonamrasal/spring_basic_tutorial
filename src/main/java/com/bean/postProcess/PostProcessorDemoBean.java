package com.bean.postProcess;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessorDemoBean implements BeanPostProcessor {
	private String message;
	private int initializationSequenceCounter;

	public PostProcessorDemoBean() {
		initializationSequenceCounter++;
		System.out.println(initializationSequenceCounter
				+ ": In default constructor of BeanPostProcessor");
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
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String name) {
		System.out.println(initializationSequenceCounter
				+ ": In post process after initialization");
		return bean;
	}

}
