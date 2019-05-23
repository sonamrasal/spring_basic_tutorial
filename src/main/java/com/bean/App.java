package com.bean.postProcess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/bean/postProcess/spring_postProcess.xml");
		// applicationContext.getBean(DemoBean.class);
	}
}
