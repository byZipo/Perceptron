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

