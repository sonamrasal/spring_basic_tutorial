package com.initDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HelloWorld implements InitializingBean, DisposableBean {

	public void destroy() throws Exception {
		System.out.println("HelloWorld: Same as destory-method attribute of <bean>");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("HelloWorld: afterPropertiesSet: Same as init-method attribute of <bean>");
	}

}
