package com.cgi.batch.spring;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Classe qui va lancer le batch
 * @author trainee
 *
 */
public class BatchPersonne {

	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchPersonne.class);

	public static void main (String [] args) throws Exception {

		LOGGER.info("Lancement du batch ... at " + new Date());

		ClassPathXmlApplicationContext cpt = new ClassPathXmlApplicationContext("applicationContext.xml");
		cpt.start();
		JobLauncher jobLauncher = (JobLauncher) cpt.getBean("jobLauncher");
		Job job = (Job) cpt.getBean("importPersonnes");
		
		JobExecution jobExecution = null;
		// sans params TODO => c'est déjà dans le xml
		// possibilité de contruire les paramètre avec un JobParametersBuilder ou même en ligne de commande (CommandLineJobRunner)
		JobParameters parameter = new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
		jobExecution = jobLauncher.run(job, parameter);

		LOGGER.info("Fin du batch ... at " + new Date());
		
		LOGGER.info("##### JobExecution : " + jobExecution.toString());	
		LOGGER.info("##### Exit Status : " + jobExecution.getStatus());
		LOGGER.info("##### Failure Exceptions : " + jobExecution.getAllFailureExceptions());

	}

}
