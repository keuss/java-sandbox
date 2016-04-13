package com.test;


public class StringTest {

	public StringTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//StringBuilder
		StringBuilder currentArgs = new StringBuilder("Going to call method: ");
		currentArgs.append("[fdsfgqb  vcfgfdfgjuyj hjhgjhjhjdy jyhhjyh yjyhjyhrghfjuhjghgb b ggfdgfdfg").append("[gfdfgjuyj hjhgjhjhjdy jyhhjyh yjyhjyhrghfjuhjgh");
		System.out.println(currentArgs.toString());
		
		StringBuilder currentArgs2 = new StringBuilder();
		System.out.println("currentArgs2["+currentArgs2+"]");
		if("".equals(currentArgs2.toString())) {
			System.out.println("vide1");
		}
		if(currentArgs2.length() == 0) {
			System.out.println("vide2");
		}
		
		
		//String contains
		String label = "Déclenchement d'un processus Distribution pour le dossier 20141020121241";
		String [] confLabelTab = {"NOM","PRENOM","AGE "}; 
		System.out.println("#"+confLabelTab.toString());
		String confLabel = "Traitement de la tâche Renseigner Informations Dossier avec la prise de décision Dossier complété";
		String confLabel2 = "Déclenchement d'un processus [type sous-dossier] pour le dossier [numéro de dossier]";
		
		
		//Levenshtein
		Levenshtein levenshtein = new Levenshtein();
		System.out.println(levenshtein.compare("George", "Georde"));
		System.out.println(levenshtein.compare("George", "George"));
		System.out.println(levenshtein.compare(label, confLabel));
		System.out.println(levenshtein.compare(label, confLabel2));
		
		String [] lineData = "Dépôt de la tâche [TaskName] dans la corbeille [QueueName]=>cd".split("=>");
		System.out.println(lineData.length);
		
		
		//StringBuilder replace
		StringBuilder str = new StringBuilder("Java Util Package");
	    System.out.println("string = " + str);
	    
	    // replace substring from index 5 to index 9
	    str.replace(5, 9, "Lanvgfghghgftgghkgjhgfkjhgkfjdhgdjhgvvvg#");
	    // prints the StringBuilder after replacing
	    System.out.println("After replacing: " + str);
	    
	    String toto = "test <code<>".replaceFirst("<code>", null);
		
	}
	

}
