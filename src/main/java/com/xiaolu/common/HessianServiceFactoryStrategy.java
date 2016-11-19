package com.xiaolu.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.xiaolu.common.anotation.RemoteService;

public class HessianServiceFactoryStrategy implements ServiceFactoryStrategy {

	@Override
	public InitializingBean instantiationService(Object obj) {
		RemoteService remoteServerAnotation = obj.getClass().getAnnotation(
				RemoteService.class);
		HessianServiceExporter hessianServiceExporter = new HessianServiceExporter();
		hessianServiceExporter.setServiceInterface(remoteServerAnotation
				.serviceInterfaces());
		hessianServiceExporter.setService(obj);
		hessianServiceExporter.afterPropertiesSet();
		return hessianServiceExporter;
	}

}
