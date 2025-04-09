package com.valtech.assignment.loanmanagementclient.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.assignment.loanmanagement.webservices.LoanServiceWS;


@Configuration
public class WebServiceClientConfig {

	@Bean
	public LoanServiceWS createMovieService() {
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(LoanServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.jaws.training.valtech.com/","LoanServiceImplBean"));
		proxy.setAddress("http://localhost:8080/services/loanService");
		return proxy.create(LoanServiceWS.class);
	}
}
