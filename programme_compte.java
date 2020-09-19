package compte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class programme_compte
{
	
	public static int recherche_code_fichier_txt(String nom_fichier, String code) 
	{
		int i=0;
		String ligne = new String();
		
		try
		{
		    File f = new File (nom_fichier);
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		 
		    try
		    {
		    	do
		    	{
		            ligne = br.readLine();//code

		            if ( ligne != null && ligne.equals(code) )
		            {
		            	br.close();
					    fr.close();
		            	return i;
		            }
		            while( !(ligne.equals("fin")) )
		            {
			            ligne = br.readLine();//fin
		            }
		            ligne = br.readLine();//\n
		            
		            i++;
		    	}while(ligne != null);

		        br.close();
		        fr.close();
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Compte initialise_compte(String nom_fichier, int indice) 
	{
		int i=0;
		int j=0;

		String ligne = new String();
		
		String code = new String();
		String nom_du_proprietaire = new String();
		String prenom_du_proprietaire = new String();
		String type_de_compte = new String();
		int argent = 0;
		int argent_max = 0;
		int argent_min = 0;
		String[] beneficiaires = new String[10];
		
		for(i=0; i<beneficiaires.length; i++)
	    {
	    	beneficiaires[i] = new String();
	    }
		
		i = 0;
		
		try
		{
		    File f = new File (nom_fichier);
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		 
		    try
		    {
		    	while(i < indice)
		    	{
		            while( !(ligne.equals("fin")) )
		            {
			            ligne = br.readLine();//fin
		            }
		            ligne = br.readLine();//\n
		            
		            i++;
		    	}
		    	code = br.readLine();
		    	nom_du_proprietaire = br.readLine();
		    	prenom_du_proprietaire = br.readLine();
		    	type_de_compte = br.readLine();
		    	argent = Integer.parseInt(br.readLine());
		    	argent_max = Integer.parseInt(br.readLine());
		    	argent_min = Integer.parseInt(br.readLine());
		    	
		    	do
	            {
		            ligne = br.readLine();
		            if(!(ligne.equals("fin")))
		            {
			            beneficiaires[j] = ligne;
		            }
		            j++;
	            }while( !(ligne.equals("fin")) );

		    	
		        br.close();
		        fr.close();
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		
		
		Compte compte = new Compte(code, 
				nom_du_proprietaire, 
				prenom_du_proprietaire, 
				type_de_compte, 
				argent, 
				argent_max, 
				argent_min, 
				beneficiaires);

		return compte;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void afficher_compte(Compte compte) 
	{
		int i=0;

        System.out.println ("Code                     : " + compte.code);
        System.out.println ("Nom du proprietaire      : " + compte.nom_du_proprietaire);
        System.out.println ("Prenom du proprietaire   : " + compte.prenom_du_proprietaire);
        System.out.println ("Type de compte           : " + compte.type_de_compte);
        System.out.println ("Argent                   : " + compte.argent);
        System.out.println ("Argent max               : " + compte.argent_max);
        System.out.println ("Argent min               : " + compte.argent_min);
        
        System.out.println ();
        for(i=0; i<compte.beneficiaires.length && !(compte.beneficiaires[i].equals("")) ; i++)
        {
            System.out.println ("Beneficiaire[" + i + "]          :" + compte.beneficiaires[i]);
        }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void ajouter_argent_compte(String nom_fichier, int indice, int montant) 
	{
		int i=0;

		String ligne = new String();
		
		try
		{
		    File f = new File (nom_fichier);
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		    
		    try
		    {
		    	File fichier_tempo = new File("fichier_tempo.txt");
		    	BufferedWriter writer = new BufferedWriter(new FileWriter(fichier_tempo));

			   	while(i < indice)
			   	{
			   		while( !(ligne.equals("fin")) )
			   		{
			   			ligne = br.readLine();//fin
				            
				    	writer.write(ligne + '\n');
			   		}
			        ligne = br.readLine();//\n
			            
			  		writer.write('\n');
			            
			  		i++;
			    }
			    	
		    	writer.write(br.readLine() + '\n');//code
		   		writer.write(br.readLine() + '\n');//nom
		   		writer.write(br.readLine() + '\n');//prenom
		   		writer.write(br.readLine() + '\n');//type de compte
		    	writer.write( String.valueOf(Integer.parseInt(br.readLine()) + montant) + '\n');//argent
		    		
		    	while(ligne != null)
		    	{
			        ligne = br.readLine();
				        
			        if(ligne != null)
			        {
				        writer.write(ligne + '\n');
			        }
		    	}
		    	
		    	fichier_tempo.renameTo(f);

		    	writer.close();
		        br.close();
		        fr.close();
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void ajouter_compte_fichier(String nom_fichier, Compte compte) 
	{
		String ligne = new String();

		try
		{
		    File f = new File (nom_fichier);
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		    
		    try
		    {
		    	File fichier_tempo = new File("fichier_tempo.txt");
		    	BufferedWriter writer = new BufferedWriter(new FileWriter(fichier_tempo));

		    	writer.write(compte.code + '\n');
		    	writer.write(compte.nom_du_proprietaire + '\n');
		    	writer.write(compte.prenom_du_proprietaire + '\n');
		    	writer.write(compte.type_de_compte + '\n');
		    	writer.write(String.valueOf(compte.argent) + '\n');
		    	writer.write(String.valueOf(compte.argent_max) + '\n');
		    	writer.write(String.valueOf(compte.argent_min) + '\n');
		    	writer.write("fin" + "\n\n");

		    	while(ligne != null)
		    	{
			        ligne = br.readLine();
				        
			        if(ligne != null)
			        {
				        writer.write(ligne + '\n');
			        }
		    	}
		    	
		    	fichier_tempo.renameTo(f);
		    	
		    	writer.close();
		        br.close();
		        fr.close();
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void supprimer_compte_fichier(String nom_fichier, int indice) 
	{
		int i=0; 
		
		String ligne = new String();

		try
		{
		    File f = new File (nom_fichier);
		    FileReader fr = new FileReader (f);
		    BufferedReader br = new BufferedReader (fr);
		    
		    try
		    {
		    	File fichier_tempo = new File("fichier_tempo.txt");
		    	BufferedWriter writer = new BufferedWriter(new FileWriter(fichier_tempo));


		    	while(i < indice)
			   	{
			   		while( !(ligne.equals("fin")) )
			   		{
			   			ligne = br.readLine();//fin
				            
				    	writer.write(ligne + '\n');
			   		}
			        ligne = br.readLine();//\n
			            
			  		writer.write('\n');
			            
			  		i++;
			    }
		    	
		        ligne = br.readLine();
		        
		        while( !(ligne.equals("fin")) )
		        {
			        ligne = br.readLine();
			    }
		    	
		        ligne = br.readLine();
		        
		    	while(ligne != null)
		    	{
			        ligne = br.readLine();
				        
			        if(ligne != null)
			        {
				        writer.write(ligne + '\n');
			        }
		    	}
		    	
		    	fichier_tempo.renameTo(f);
		    	
		    	writer.close();
		        br.close();
		        fr.close();
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String nom_fichier = new String("fichier_comptes.txt");
		Compte compte = new Compte();
		int i=0;
		int montant = 0;

		int fin_programme = 0;
		
		int menu_entrer_compte = 1;
		String code = new String();
		int code_valide = 0;
		int indice_compte = 0;

		int menu_compte = 0;
		int choix_menu_compte = 0;
		int choix_menu_compte_valide = 0;
		
		int information_compte = 0;

		int versement = 0;
		
		int retrait = 0;
		
		int virement = 0;
		int indice_beneficiaire = 0;
		String memo_code = new String();

		int ajouter_compte = 0;
		Compte nouveau_compte = new Compte();

		
		
		while( fin_programme == 0 )
		{
			
			
			
			if( menu_entrer_compte == 1 )
			{
				code_valide = 0;
				
				while( code_valide == 0 )
				{
					System.out.print("\nEntrez votre code : ");
					code = sc.nextLine();
					
					indice_compte = recherche_code_fichier_txt(nom_fichier, code);

					if ( indice_compte != -1)
					{
						code_valide = 1;
					}
					else
					{
						System.out.println("Nous n'avons pas trouvé le compte : " + code);
					}
				}
				
				compte = initialise_compte(nom_fichier, indice_compte);
				


				System.out.println("\n\n\nBonjour " + compte.prenom_du_proprietaire + "!");
				
				menu_entrer_compte = 0;
				menu_compte = 1;
			}
			
			
			
			
			
			if( menu_compte == 1 )
			{
				choix_menu_compte_valide = 0;
				
				while( choix_menu_compte_valide == 0 )
				{

					System.out.println("\n\n\nMENU\n");
									
					System.out.println("1 : Changer de compte");
					System.out.println("2 : Information sur votre compte");
					System.out.println("3 : Versement d'argent");
					System.out.println("4 : Retrait");
					System.out.println("5 : Virement");
					System.out.println("6 : Ajouter un nouveau compte");
					System.out.println("7 : Supprimer votre compte");

					System.out.print("\nEntrez votre choix : ");
					choix_menu_compte = sc.nextInt();
					
					
					switch(choix_menu_compte) 
					{
						case 1:
							menu_entrer_compte = 1;
							choix_menu_compte_valide = 1;
							menu_compte = 0;
							code = sc.nextLine(); // pour vider le buffer
							break;
							
						case 2:
							information_compte = 1;
							choix_menu_compte_valide = 1;
							menu_compte = 0;
							break;
					  
						case 3:
							versement = 1;
							choix_menu_compte_valide = 1;
							menu_compte = 0;
							break;	
							
						case 4:
							retrait = 1;
							choix_menu_compte_valide = 1;
							menu_compte = 0;
							break;	
							
						case 5:
							virement = 1;
							choix_menu_compte_valide = 1;
							menu_compte = 0;
							break;	
							
						case 6:
							ajouter_compte = 1;
							choix_menu_compte_valide = 1;
							menu_compte = 0;
							code = sc.nextLine(); // pour vider le buffer
							break;	
							
						case 7:
							System.out.println("\nEtes vous sur de vouloir supprimer votre compte");
							System.out.println("1 : non\n2 : oui");
							
							System.out.print("\nEntrez votre choix : ");
							choix_menu_compte = sc.nextInt();
							
							if (choix_menu_compte == 2)
							{
								supprimer_compte_fichier(nom_fichier, recherche_code_fichier_txt(nom_fichier, compte.code));
								
								menu_compte = 0;
								menu_entrer_compte = 1;
								choix_menu_compte_valide = 1;
								code = sc.nextLine(); // pour vider le buffer
							}
							break;	
							
					  default:
						  System.out.print("Le choix " + choix_menu_compte + " n'est pas valide\n");
					}
				}
			}
				
				
				
				
				if (information_compte == 1)
				{
					System.out.println("\n\n\nINFORMATION\n");

					afficher_compte(compte);
					
					information_compte = 0;
					menu_compte = 1;
				}
				
				
				
				
				
				if (versement == 1)
				{
					System.out.print("\n\nVERSEMENT\n\n");

					System.out.print("Entrez le montant que vous souhaitez deposer sur votre compte : ");
					montant = sc.nextInt();
					
					if(montant < 0)
					{
						System.out.print("\nVersement impossible car le montant entré est négatif.");
					}
					
					else if( (compte.type_de_compte).equals("épargne") && (compte.argent + montant > compte.argent_max) )
					{
						System.out.print("\nVersement impossible en raison d'un depassement de votre limite maximum d'argent.");
					}
					
					else
					{
						ajouter_argent_compte(nom_fichier, recherche_code_fichier_txt(nom_fichier, code), montant );
						System.out.print("\nVersement effectué !");
						
						compte = initialise_compte(nom_fichier, recherche_code_fichier_txt(nom_fichier, code));
					}
					
					versement = 0;
					menu_compte = 1;
				}
				
				
				
				
				
				
				
				if (retrait == 1)
				{
					System.out.print("\n\nRETRAIT\n\n");

					System.out.print("Entrez le montant que vous souhaitez retirer de votre compte : ");
					montant = sc.nextInt();
					
					if(montant < 0)
					{
						System.out.print("\nRetrait impossible car le montant entré est négatif.");
					}
					
					else if(((compte.type_de_compte).equals("épargne") && (compte.argent - montant < 0)) || 
							((compte.type_de_compte).equals("courant") && (compte.argent - montant < compte.argent_min)) )
					{
						System.out.print("\nRetrait impossible en raison d'un depassement de votre limite minimum d'argent.");
					}
					
					else
					{
						ajouter_argent_compte(nom_fichier, recherche_code_fichier_txt(nom_fichier, code), -montant );
						System.out.print("\nVersement effectué !");
						
						compte = initialise_compte(nom_fichier, recherche_code_fichier_txt(nom_fichier, code));
					}
					
					retrait = 0;
					menu_compte = 1;
				}
				
				
				
				
				
				
				
				if (virement == 1)
				{
					System.out.print("\n\nVIREMENT\n\n");

					if(compte.beneficiaires[0].equals(""))
					{
			            System.out.println ( "Vous n'avez aucun beneficiaire enregistré.\n" );
					}
					else
					{
						System.out.print("Beneficiaires :\n");

						for(i=0; i<compte.beneficiaires.length && !(compte.beneficiaires[i].equals("")) ; i++)
				        {
				            System.out.println ( (i+1) + " : " + compte.beneficiaires[i]);
				        }
						
						System.out.print("\nEntrez l'indice du compte beneficiaire : ");
						indice_beneficiaire = sc.nextInt();
						indice_beneficiaire--;
						
						if (indice_beneficiaire < 0 ||
							indice_beneficiaire > 9 ||
							compte.beneficiaires[indice_beneficiaire].equals("") )
						{
							System.out.print("L'indice entré est incorrect");
						}
						
						else
						{
							System.out.println("\n\nVous avez choisi le beneficiaire " + (indice_beneficiaire+1) + " : " + compte.beneficiaires[indice_beneficiaire] );
					
							System.out.print("\nEntrez le montant du virement : ");
							montant = sc.nextInt();

							if(montant < 0)
							{
								System.out.print("\nVirement impossible car le montant entré est négatif.");
							}
							
							else if(((compte.type_de_compte).equals("épargne") && (compte.argent - montant < 0)) || 
									((compte.type_de_compte).equals("courant") && (compte.argent - montant < compte.argent_min)) )
							{
								System.out.print("\nVirment impossible en raison d'un depassement de votre limite minimum d'argent.");
							}
							
							else
							{
								memo_code = compte.code;
								
								compte = initialise_compte(nom_fichier, recherche_code_fichier_txt(nom_fichier, compte.beneficiaires[indice_beneficiaire]));
								
								if( (compte.type_de_compte).equals("épargne") && (compte.argent + montant > compte.argent_max) )
								{
									System.out.print("\nVirement impossible en raison d'un depassement de la limite maximum d'argent chez le compte beneficiaire.");
								}
								else
								{
									ajouter_argent_compte(nom_fichier, recherche_code_fichier_txt(nom_fichier, compte.code), montant );
									ajouter_argent_compte(nom_fichier, recherche_code_fichier_txt(nom_fichier, memo_code), -montant );

									System.out.print("\nVirement éffectué !");
								}
								compte = initialise_compte(nom_fichier, recherche_code_fichier_txt(nom_fichier, memo_code));
							}
						}
					}
					virement = 0;
					menu_compte = 1;
				}
				
				
				
				
				
				
		
				
				if (ajouter_compte == 1)
				{
					System.out.print("\n\nAJOUTER UN NOUVEAU COMPTE\n\n");

					
					System.out.print("Entrez un code : ");
					nouveau_compte.code = sc.nextLine();
					
					System.out.print("Entrez le nom du proprietaire : ");
					nouveau_compte.nom_du_proprietaire = sc.nextLine();
					
					System.out.print("Entrez un prenom du proprietaire : ");
					nouveau_compte.prenom_du_proprietaire = sc.nextLine();
					
					System.out.print("Entrez un type de compte : ");
					nouveau_compte.type_de_compte = sc.nextLine();
					
					nouveau_compte.argent = 0;
					
					if ( nouveau_compte.type_de_compte.equals("épargne") )
					{
						System.out.print("Entrez une limite max : ");
						nouveau_compte.argent_max = sc.nextInt();
					}
					else if ( nouveau_compte.type_de_compte.equals("courant") )
					{
						System.out.print("Entrez une limite min : ");
						nouveau_compte.argent_min = sc.nextInt();
					}
					
					ajouter_compte_fichier(nom_fichier, nouveau_compte);
					
					System.out.print("\nCompte ajouté !");

					ajouter_compte = 0;
					menu_compte = 1;
			}
		}
	}
}
