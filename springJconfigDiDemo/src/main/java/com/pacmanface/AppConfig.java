package com.pacmanface;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig{

	@Bean("service")
	public IService getIService(){
		return new IServiceImpl();
	}
	
	@Bean("client")
	public IClient getIClient(IService service){
		return new IClientImpl(service);
	}
}
