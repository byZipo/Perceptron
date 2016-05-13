package percep;
import java.util.Random;

class Perceptron {
	
	double[] theta;	// vecteur des poids
	double theta0;	// paramètre de biais
	int dim;		// dimension des données

	private Random random;	// générateur de nombres aléatoires
	
	// Constructeur
	public Perceptron(int dimension) {
		dim = dimension;
		theta = new double[dim];
 		random = new Random();		
	}
	
	// Initialisation aléatoire des poids
	private void 	 {
		for ( int k=0;k<dim;k++)
			theta[k] = random.nextGaussian();
		
		theta0 = random.nextGaussian();
	}
	
	// Fonction de prédiction
	public int pred(double[] x) {

		int etiquette = 0;
		int somme = 0;
		for(int i=0; i<x.length;i++) {
			somme += theta[i]*x[i];
		}
		etiquette = (somme>theta0?1:-1);	
		return etiquette;
	}
	
	// Apprentissage
	public int apprend(double[][] X, int[] Y, int m, int Nepochs) {
	
		int epochs=0;	// nombre d'epochs réalisées (voir question 3)
	
		// ...
		
		return epochs;		
	}
	
	
	
	
	
	/////////////////////////////////////////////
	// Fonctions pour le mode un-contre-tous   //
	//  (pour Exercice 4)                      //
	/////////////////////////////////////////////
	
	/* 
		Pour un apprentissage en UN CONTRE TOUS
		on passe un paramètre supplémentaire à la fonction apprend() : 
		la classe que l'on souhaite associer aux exemples positifs.
		
		L'aglorithme doit donc apprendre à séparer la classe donnée en paramètre 
		de toutes les autres.
	*/
	public int apprend(double[][] X, int[] Y, int m, int Nepochs, int classe) {
		int epochs = 0; 
		
		// ...
		
		
		return epochs;		
	}
	
	/*
		Fonction de prédiction retournant un score (valeur réelle)
	*/
	public double pred_reelle(double[] x) {

		double f = 0;
		
		// ...
		
		
		return f;
	}
	
	
	///////////////////////////////////////////////////////
	// Fonctions pour la procédure Leave-One-Out (LOO)   //
	//  (pour Exercice 4.3)                              //
	///////////////////////////////////////////////////////

	public int apprendLOO(double[][] X, int[] Y, int m, int Nepochs, int classe, int indiceLOO) {
		int epochs = 0; 
		
		/*
		 ... Recopiez ici le corps de la fonction
		 
		 public int apprend(double[][] X, int[] Y, int m, int Nepochs, int classe)
		
		 et modifiez-le pour exclure l'exemple d'indice 'indiceLOO' de l'apprentissage
		
			(un simple if( i != indiceLOO ) {...} devrait faire l'affaire)
		*/
		
		// ... 
		
		
		return epochs;		
	}


}
