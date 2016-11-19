package com.xiaolu.common;

import java.rmi.RemoteException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.xiaolu.common.anotation.RemoteService;

public class RMIServiceFactoryStrategy implements ServiceFactoryStrategy{

	@Override
	public InitializingBean instantiationService(Object bean) {
		RemoteService remoteServerAnotation = bean.getClass().getAnnotation(RemoteService.class);
		String serviceName = remoteServerAnotation.serviceName();
		int port = remoteServerAnotation.port();
		Class<?> interfaces = remoteServerAnotation.serviceInterfaces();
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setRegistryPort(port);
		rmiServiceExporter.setServiceName(serviceName);
		rmiServiceExporter.setService(bean);
		rmiServiceExporter.setServiceInterface(interfaces);
		try {
			rmiServiceExporter.afterPropertiesSet();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return rmiServiceExporter;
	}

}
