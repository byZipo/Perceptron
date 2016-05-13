package percep;
/*
	Cette classe implémente un classifieur multi-classe un-contre-tous 
	à partir d'un ensemble de classifieurs binaires de type Perceptron.
*/
class UnContreTous {

	int Nclasses;	// Nombre de catégories
	int dim;		// dimension des données
	
	Perceptron[] classifieurs; 	// tableau de classifieurs binaires
	
	
	// Constructeur : instancie les Nb_classes classifieurs binaires
	public UnContreTous(int Nb_classes, int dimension) {
		Nclasses = Nb_classes;
		dim = dimension;
		classifieurs = new Perceptron[Nclasses];
		for (int j = 0; j < Nclasses; j++) {
			classifieurs[j] = new Perceptron(dimension);
		}
	
	}
	
	
	/*
		Apprentissage de l'ensemble des classifieurs binaires
		
		Chaque classifieur doit apprendre à séparer une classe de toutes les autres
	*/
	public void apprend(double[][] X, int[] Y, int m, int Nepochs) {
	
		for (int j=0; j<Nclasses; j++) {
			classifieurs[j].apprend(X,Y,m,Nepochs,j+1);
		}
	
	}
		
	/*
		Prédiction de l'étiquette d'un exemple x
	*/
	public int pred(double[] x) {

		int etiquette = 0;

		// ...

		return etiquette;
	}
	
	
	
	/*
		Apprentissage de l'ensemble des classifieurs binaires
		pour la procédure Leave-One-Out (LOO)
	*/
	public void apprendLOO(double[][] X, int[] Y, int m, int Nepochs, int indiceLOO) {
	
		for (int j=0; j<Nclasses; j++) {
			classifieurs[j].apprendLOO(X,Y,m,Nepochs,j+1, indiceLOO);
		}
	
	}
		
}

