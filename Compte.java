package compte;

public class Compte 
{
	String code;
	String nom_du_proprietaire;
	String prenom_du_proprietaire;
	String type_de_compte;
	int argent;
	int argent_max;
	int argent_min;
	String[] beneficiaires = new String[10];
	
	public Compte()
	{	
	    code = new String();
	    nom_du_proprietaire = new String();
	    prenom_du_proprietaire = new String();
	    type_de_compte = new String();
	    argent = 0;
	    argent_max = 0;
	    argent_min = 0;
	    
	    for(int i=0; i<beneficiaires.length; i++)
	    {
	    	beneficiaires[i] = new String();
	    }
	} 
	
	public Compte(String code_2, 
			String nom_du_proprietaire_2, 
			String prenom_du_proprietaire_2, 
			String type_de_compte_2, 
			int argent_2, 
			int argent_max_2, 
			int argent_min_2, 
			String[] beneficiaires_2
			)
	{
		code = code_2;
	    nom_du_proprietaire = nom_du_proprietaire_2;
	    prenom_du_proprietaire = prenom_du_proprietaire_2;
	    type_de_compte = type_de_compte_2;
	    argent = argent_2;
	    argent_max = argent_max_2;
	    argent_min = argent_min_2; 
	    
	    for(int i=0; i<beneficiaires.length; i++)
	    {
	    	beneficiaires[i] = beneficiaires_2[i];
	    }
	}    
}
