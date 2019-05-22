package spring_basic_tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.di.Employee;
import com.initDestroy.DefaultInitDestroyDemo;
import com.initDestroy.HelloWorld;

public class App {
	public static void main(String[] args) {
		// requires spring-context dependency
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/di/spring_di.xml");
		/*
		 * this requires single employee bean to be defined in beans.xml - if
		 * multiple, below call throws exception
		 */
		// Employee employee = applicationContext.getBean(Employee.class);
		Employee employee = (Employee) applicationContext
				.getBean("maleEmployee");
		System.out.println(employee.getName());
		employee = (Employee) applicationContext.getBean("femaleEmployee");
		System.out.println(employee.getName());

		/*
		 * Singleton scope - returns the same bean each time Prototype score -
		 * returns a new object instance every time (this is valid for an application context)
		 * Instantiate new application context - singleton bean will be different from the earlier
		 * application context
		 */
		applicationContext = new ClassPathXmlApplicationContext(
				"com/scope/spring_scope.xml");
		ApplicationContext anotherApplicationContext = new ClassPathXmlApplicationContext(
				"com/scope/spring_scope.xml");
		System.out.println("Singleton bean scope: ");		
		employee = (Employee) applicationContext.getBean("singletonBean");
		System.out.println("Employee: " + employee);
		Employee anotherEmployee = (Employee) applicationContext.getBean("singletonBean");
		System.out.println("Another employee: " + anotherEmployee);
		//this produces a different bean than above
		employee = (Employee) anotherApplicationContext.getBean("singletonBean");
		System.out.println("Singleton bean from another application context: " + employee);
		System.out.println("Prototype bean scope: ");
		employee = (Employee) applicationContext.getBean("prototypeBean");
		System.out.println("Employee: " + employee);
		anotherEmployee = (Employee) applicationContext.getBean("prototypeBean");
		System.out.println("Another employee: " + anotherEmployee);
		anotherApplicationContext = null;
		
		System.out.println("Local init and destroy on bean");
		applicationContext = new ClassPathXmlApplicationContext("com/initDestroy/spring_init_destroy.xml");
		employee = applicationContext.getBean(Employee.class);
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
		DefaultInitDestroyDemo demoBean = (DefaultInitDestroyDemo) applicationContext.getBean("demoBean");
	}
}
