package com.hs.ioc;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class IocDemoApplication {

	public static void main(String[] args) {
		/*SpringApplication.run(IocDemoApplication.class, args);*/

		BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		DefaultResourceLoader loader = new DefaultResourceLoader();
		Resource resource = loader.getResource("config.xml");
		reader.loadBeanDefinitions(resource);

		ThreadLocal

	}

}
