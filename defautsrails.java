package percep;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class defautsrails {
	
	double[][] X;
	int Y[];
	int dim;
	int m;
	
	public static void main(String[] args) {
	
		// Charge la base de données dans l'objet 'base'
		defautsrails base = new defautsrails();
		
		int i;
		int Nepochs = 100;
					
		// Crée un classifieur multi-classe UnContreTous 
		// pour 4 catégories en dimension 96 : 
		UnContreTous monClassifieur = new UnContreTous(4,base.dim);
		
		// Apprentissage multi-classe : 
		monClassifieur.apprend(base.X,base.Y,base.m,Nepochs);
		
		// Calcul de l'erreur d'apprentissage
		// de chaque classifieur binaire : 
		
		// ... 
		
		
		// Calcul de l'erreur d'apprentissage
		// du classifieur multi-classe
		
		// ... 
	
	}
	
	
	
	
	
	// Charge la base de données de defauts de rails
	// (140 exemples en dimension 96)
	public defautsrails() {
		m = 140;
		dim = 96;
		load_base("defautsrails.dat"); 
	
	}
		
	// Chargement d'une base
	void load_base(String filename) {
		int i,j,r;
		double label;
	
		X = new double[m][dim];
		Y = new int[m];

		File file = new File(filename);
		Scanner scanner = null;	 	
 		try{
 			scanner = new Scanner(file);
 		}
 		catch(Exception e) {
			System.out.println("File " + filename + " not found."); 
			System.exit(0);
 		}
		
		i = 0;
		
		try {
			while (scanner.hasNext()) {
				for(j=0;j<dim;j++) {
					X[i][j] = scanner.nextFloat();
				}
				Y[i] = (int)scanner.nextFloat();
				i++;	
			}
			scanner.close();
		
		} catch (Exception e) {
			System.out.println("error reading data file." + scanner);
		}
	
		System.out.println("Nombre d'exemples chargés : " + i);
	}
}

