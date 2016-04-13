package com.cgi.batch.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cgi.batch.beans.Personne;

/**
 * Le writer du batch qui va ecrire les donnees en BDD via JDBC
 * @author trainee
 *
 */
//@Transactional (propagation=Propagation.REQUIRED, rollbackFor=Exception.class) => no needed
public class PersonJdbcWriter implements ItemWriter<Personne> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonJdbcWriter.class);

	private JdbcTemplate jdbcTemplate;

	private static final String REQUEST_INSERT_PERSONNE = "insert into PERSONNE (id,nom,prenom,civilite) values (?,?,?,?)";
	private static final String REQUEST_UPDATE_PERSONNE = "update PERSONNE set nom=?, prenom=?, civilite=? where id=?";
	private static final String REQUEST_INSERT_ADRESSE = "insert into ADRESSE (id,city) values (?,?)";


	public void write(List<? extends Personne> items) throws DefaultBatchException {

		if(items != null) {
			LOGGER.info("Call for process with items : {}", items.toString());
		} else {
			LOGGER.warn("items is null");
		}
		// le writer est appelé dès que le reader a lu deux élements (commit 2)=> sexy ! (la liste peut être de 0,1 ou 2 max)
		for (Personne personne : items) {
			final Object object [] = {personne.getNom(),personne.getPrenom(), personne.getCivilite(),personne.getId()};

			// test transaction
			if(personne.getId() == 4) {
				//throw new DefaultBatchException("Error for personne 4 !");
			}
			//on tente un update (un peut bourin ! GGA)
			int nbLigne = jdbcTemplate.update(REQUEST_UPDATE_PERSONNE, object);
			LOGGER.info("Update done for personne id {}", personne.getId());

			final Object objectAdresse [] = {personne.getId(),"Adresse"};
			jdbcTemplate.update(REQUEST_INSERT_ADRESSE, objectAdresse);
			LOGGER.info("Insert done for adresse id {}", personne.getId());

			//si le nombre de ligne mise a jour vaut 0, on fait un insert
			if (nbLigne == 0) {
				final Object object2 [] = {personne.getId(),personne.getNom(),personne.getPrenom(), personne.getCivilite()};
				jdbcTemplate.update(REQUEST_INSERT_PERSONNE, object2);
				LOGGER.info("Insert done for personne id {}", personne.getId());
			}	else {
				LOGGER.info("Nothing to insert !");
			}
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



}
