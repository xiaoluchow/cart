package com.xiaolu.common;

import org.springframework.beans.factory.InitializingBean;

public class ServiceContext {
	
	private ServiceFactoryStrategy strategy;


	public void setStrategy(ServiceFactoryStrategy strategy) {
		this.strategy = strategy;
	}
	
	public InitializingBean instantiationServiceBean(Object bean){
		return strategy.instantiationService(bean);
	}
}
