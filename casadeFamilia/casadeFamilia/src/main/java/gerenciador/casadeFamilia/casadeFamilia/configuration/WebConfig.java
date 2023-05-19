/*
 * WebConfig.java
 * Copyright (c) UEG.
 *
 *
 *
 *
 */
package gerenciador.casadeFamilia.casadeFamilia.configuration;

import gerenciador.casadeFamilia.api.config.ApiWebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.filter.CorsFilter;

/**
 * Classe de configuração referente aos recursos Web MVC da aplicação.
 *
 * @author UEG
 */
@Configuration
public class WebConfig extends ApiWebConfig {

	/**
	 * Retorna a instância {@link MethodValidationPostProcessor}.
	 * 
	 * @return
	 */
	/*@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}*/

	@Override
	public CorsFilter corsFilter() {
		CorsFilter corsFilter = super.corsFilter();
		return corsFilter;
	}
}
