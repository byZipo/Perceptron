package percep;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class perceptron2D {
	
	static Graph graph;
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Perceptron 2D");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
	
		graph = new Graph();
	
		f.add("Center",graph);
		f.setVisible(true);
	

	}
	
	/*
		Fonction exécutée à l'appui sur ESPACE
		
		Les points tracés à la souris sur l'interface graphique
		sont récupérés dans X,Y,m (base d'apprentissage)
	*/
	public static void my_main(double[][] X, int[] Y, int m) {
	
		int i;
		int Nepochs = 1;
		
		// Création d'une instance de Perceptron
		Perceptron mPerceptron = new Perceptron(2);
		
		// Réalise l'apprentissage
		int epochs = mPerceptron.apprend(X, Y, m, Nepochs);
		
		
		int sommeErreurs = 0;
		for(i=0;i<1000;i++){
			double[] toto = X[i];
			int classe = mPerceptron.conversionYi(Y[i]);
			int prediction = mPerceptron.pred(toto);
			if(prediction !=classe){
				sommeErreurs++;
				System.out.println("EXEMPLE :"+i+" classe : "+classe+" prediction : "+prediction+" --> ERREUR");
			}else
				System.out.println("EXEMPLE :"+i+" classe : "+classe+" prediction : "+prediction);
			
		}
		System.out.println("NB ERREURS :"+sommeErreurs);
		double Remp = (double)((double)sommeErreurs/(double)1000);
		System.out.println("RISQUE EMPIRIQUE : "+Remp);
		System.out.println("TAUX DE BONNE RECONNAISSANCE : "+(double)(1-Remp)*100+"%");
		/*
			Prédiction et calcul de l'erreur d'apprentissage... 
		*/

		// ... 


		/*
			Tracé de l'hyperplan de séparation 
			avec la fonction
			
			graph.droite(a, b, couleur);
			
			qui trace la droite d'équation y = ax + b dans le plan (x,y).
		*/

		// ... 
		
		
	
	}
 	    
}

