package com.cgi.batch.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.cgi.batch.beans.Personne;

/**
 * Processor du batch, qui va implementer les  règles de gestion
 * @author trainee
 *
 */
public class PersonProcessor implements ItemProcessor<Personne, Personne>{

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonProcessor.class);
	
	public Personne process(final Personne personneInput) throws Exception {
		
		if(personneInput != null) {
			LOGGER.info("Call for process with personne : {}", personneInput);
		} else {
			LOGGER.warn("personneInput is null");
		}
		//si la civilite a la valeur M sla personne sera ecrite en base sinon on la  rejette
		if ("M".equals(personneInput.getCivilite())) {
			LOGGER.info("need to store personneInput : {}", personneInput);
			return personneInput;
		} else {
			return null;
		}
	}
	
	

}
