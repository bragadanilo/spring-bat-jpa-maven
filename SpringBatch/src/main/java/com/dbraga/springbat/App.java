package com.dbraga.springbat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dbraga.springbat.service.UserService;


public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
    	// loading the definitions from the given XML file
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 
		UserService service = (UserService) context.getBean("helloWorldService");
		String message = service.sayHello();
		System.out.println(message);
		
		try {
			System.out.println("Size before transaction: "+service.size());
			service.transactionWithError();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("Size after transaction: "+service.size());
		}
		
    }
}
