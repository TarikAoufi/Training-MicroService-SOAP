package org.sid.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

/**
 * Classe de configuration de contexte 
 * pour déployer le serveur JAX-WS
 * 
 */
@Configuration 
public class MyConfig {
	
	/**
	 * Permet d'exporter et d'exposer un WS basé sur 
	 * le protocole SOAP (Simple Object Access Control)
	 * en utilisant un serveur JAX-WS qui démarre 
	 * sur l'url en paramètre.
	 * 
	 */
	@Bean
	public SimpleJaxWsServiceExporter getJWS( ) {
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://0.0.0.0:8383/service/");
		return exporter;
	}
	
}
