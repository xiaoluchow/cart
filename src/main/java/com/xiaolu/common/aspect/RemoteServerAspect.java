package com.xiaolu.common.aspect;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.xiaolu.common.RMIServiceFactoryStrategy;
import com.xiaolu.common.ServiceContext;
import com.xiaolu.common.ServiceType;
import com.xiaolu.common.anotation.RemoteService;

@Component
public class RemoteServerAspect implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		RemoteService remoteServerAnotation = bean.getClass().getAnnotation(RemoteService.class);
		if(remoteServerAnotation != null){
			System.out.println("remote server bean name is "+beanName);
			if(remoteServerAnotation.serviceType().equals(ServiceType.RMI)){
				ServiceContext context = new ServiceContext();
				context.setStrategy(new RMIServiceFactoryStrategy());
				System.out.println("rmi service created successfully...");
				return context.instantiationServiceBean(bean);
			}
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}
}
