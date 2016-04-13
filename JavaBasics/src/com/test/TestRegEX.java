package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegEX {

	public static void main(String[] args) {

		//String pattern1 = "Envoi d'un règlement en validation pour le bénéficiaire\\s(.*)\\sd'un montant de\\s(.*)";
		//Dépôt de la tâche (.*) dans la corbeille (.*)
		String pattern1 = "Dépôt de la tâche (.*) dans la corbeille (.*)";
		Pattern p = Pattern.compile(pattern1);
		Matcher m = p.matcher("Dépôt de la tâche Besoin contrôle PSF dossier dans la corbeille Production Succession 1");


		if (m.find()) {
			System.out.println("["+m.group(1)+"]");
			System.out.println("["+m.group(2)+"]");
		}
	}
}
