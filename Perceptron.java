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
	private void init() {
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
	
	double[] additionVecteurs(double[] a, double[] b){
		if(a.length != b.length){
			System.out.println("ERREUR LES VECTEURS N'ONT PAS LA MEME TAILLE");
		}
		double[] res = new double[a.length];
		for(int i=0; i<a.length; i++){
			res[i] = a[i] + b[i];
		}
		return res;
	}
	
	double[] multiplicationVecteurParEntier(int a, double[] b){
		double[] res = new double[b.length];
		for (int i = 0; i < b.length; i++) {
			res[i] = b[i]*a;
		}
		return res;
	}
	
	int conversionYi(int yi){
		return (2*yi-1);
	}
	
	// Apprentissage
	public int apprend(double[][] X, int[] Y, int m, int Nepochs) {
	
		int epochs=Nepochs;	// nombre d'epochs réalisées (voir question 3)
		boolean asConverge = false;
		init();
		double[] thetaSave = theta;
		double thetaZeroSave = theta0;
		double crit = Integer.MAX_VALUE;
		while(crit>0.000006 && epochs>0){
			for (int i = 0; i < m; i++) {
				if (pred(X[i]) != Y[i]) {
					int yConv = conversionYi(Y[i]);
					double[] res = multiplicationVecteurParEntier(yConv, X[i]);
					theta = additionVecteurs(theta, res);
					theta0 = (double) (theta0 - (double) (yConv));
				}
				
			}
			double cmpDroite =(double)((double)(theta0 - thetaZeroSave)*(double)(theta0 - thetaZeroSave));
			double[] sousTheta = soustractionVecteurs(theta, thetaSave);
			double norme = normeVecteur(sousTheta);
			double cmpGauche = (double)(norme*norme);
			crit = (double)(cmpDroite + cmpGauche);
			epochs--;
		}
		return epochs;		
	}
	
	
	double normeVecteur(double[] a){
		double res = 0;
		for (int i = 0; i < a.length; i++) {
			res += a[i]*a[i];
		}
		res = (double)(Math.sqrt(res));
		return res;
	}
	
	
	
	double[] soustractionVecteurs(double[] a, double[] b){
		double[] res = new double[a.length];
		for(int i= 0; i < a.length; i++){
			res[i] = a[i] - b[i];
		}
		return res;
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
