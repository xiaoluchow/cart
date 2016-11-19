package com.xiaolu.common.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.rmi.registry.Registry;

import com.xiaolu.common.ServiceType;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RemoteService {
	ServiceType serviceType();
	String serviceName();
	int port() default Registry.REGISTRY_PORT;
	Class<?> serviceInterfaces();
}
