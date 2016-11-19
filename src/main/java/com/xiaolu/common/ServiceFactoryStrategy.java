package com.xiaolu.common;

import org.springframework.beans.factory.InitializingBean;

public interface ServiceFactoryStrategy {
	public InitializingBean instantiationService(Object obj);
}
