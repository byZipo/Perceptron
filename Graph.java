package percep;
/*
	Fonctions pour graphique 2D
*/

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

public class Graph extends Component implements MouseListener,MouseWheelListener,KeyListener {

	public static int mMAX = 10000;

	private int[][] Points;
	private Color[] PointsColor;
	private int nPoints;
	
	private int[][] Droites;
	private Color[] DroitesColor;
	private int nDroites;
	
	public double[][] X;
	public int[] Y;
	public int m;
	
	private int Width;
	private int Height;
	public double scaleX;
	public double scaleY;
	
	private Random random;
	private double sigma; 
	
	public Graph() {
		 X = new double[mMAX][2];
		 Y = new int[mMAX];
 		 m = 0;

		 Points = new int[mMAX][2];
 		 PointsColor = new Color[mMAX];
 		 nPoints = 0;
 		
		 Droites = new int[100][4];
 		 DroitesColor = new Color[100];
 		 nDroites = 0;
 		 	 
 		 scaleX = 0.05;
 		 scaleY = 0.05;
 		 
 		 random = new Random();
 		 sigma = 0;
 		 
 		 addMouseListener(this);
 		 addMouseWheelListener(this);
  		 addKeyListener(this);
  		 this.setFocusable(true); 
  		 this.requestFocus();
 		 
	}
	
	public void clear() {
		m=0;
		nPoints=0;
		nDroites = 0;
		repaint();
	}
	public void clearPlotOnly() {
		nPoints=0;
		nDroites=0;
		repaint();
	}
	public void tracePoint(int x, int y, Color color) {
		
		Points[nPoints][0] = x;
		Points[nPoints][1] = y;		
		PointsColor[nPoints] = color;
		nPoints++;
		
		repaint();
	}
	
	public void droite(double a, double b, int c) {

		Droites[nDroites][0] = 0;
		Droites[nDroites][1] = (Height/2)  - (int)((a * scaleX * (- Width/2) + b)/scaleY);
		Droites[nDroites][2] =  Width;
		Droites[nDroites][3] = (Height/2)  - (int)( (a * scaleX * (Width/2) + b)/scaleY);
		DroitesColor[nDroites] = couleur(c);
		nDroites++;		
		repaint();
		
	}
	private Color couleur(int label) {
		Color color;
		switch (label) {
			case 0:
				color = Color.BLUE;
				break;
			case 1:
				color = Color.RED;
				break;
			case 2:
				color = Color.GREEN;
				break;
			case 3:
				color = Color.YELLOW;
				break;
			default:
				color = Color.BLACK;
				break;
		}
		return color;
	}
	private void addPointWindowCoord(int x, int y, int label) {
		X[m][0] = (x - Width/2) * scaleX;
		X[m][1] = (-y + Height/2) * scaleY;
		Y[m] = label;
		m++;
		tracePoint(x, y, couleur(label));
	}
	public void addPoint(double x, double y, int label) {
		X[m][0] = x;
		X[m][1] = y;
		Y[m] = label;
		m++;
		
		tracePoint(Width/2 + (int)(x / scaleX), Height/2- (int)(y/scaleY), couleur(label));
	}
	
	
    public void mousePressed(MouseEvent e){
        
        
        if (m<mMAX-1) {
		int i;
		if( e.isShiftDown()) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(sigma > 0.) {
					for(i=0;i<10;i++) {
						addPointWindowCoord(e.getX() + (int)( sigma * random.nextGaussian()/scaleX), e.getY() + (int)(sigma*random.nextGaussian() / scaleY),2);
					}
				}
				else
					addPointWindowCoord(e.getX(), e.getY(),2);
			}
			else if(e.getButton() == MouseEvent.BUTTON3) {
				if(sigma > 0.) {
					for(i=0;i<10;i++) {
						addPointWindowCoord(e.getX() + (int)( sigma * random.nextGaussian()/scaleX), e.getY() + (int)(sigma*random.nextGaussian() / scaleY),3);
					}
				}
				else
					addPointWindowCoord(e.getX(), e.getY(),3);

			}
		}
		else {
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(sigma > 0.) {
					for(i=0;i<10;i++) {
						addPointWindowCoord(e.getX() + (int)( sigma * random.nextGaussian()/scaleX), e.getY() + (int)(sigma*random.nextGaussian() / scaleY),0);
					}
				}
				else
					addPointWindowCoord(e.getX(), e.getY(),0);
			}
			else if (e.getButton() == MouseEvent.BUTTON3) {
				if(sigma > 0.) {
					for(i=0;i<10;i++) {
						addPointWindowCoord(e.getX() + (int)( sigma * random.nextGaussian()/scaleX), e.getY() + (int)(sigma*random.nextGaussian() / scaleY),1);
					}
				}
				else
					addPointWindowCoord(e.getX(), e.getY(),1);

			}
		}
	    }
	    System.out.println("Coordonnées ( " + ( e.getX()  - Width/2) * scaleX + " , " + (- e.getY() + Height/2 ) * scaleY + " )");
	}
	
    public void mouseReleased(MouseEvent e){}
	public void mouseMoved(MouseEvent e){ }
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseClicked(MouseEvent e){
		// Does not fire on fast double click
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		int scroll = e.getWheelRotation();
		sigma -= 0.1 * scroll;
		if (sigma < 0.)
			sigma = 0;
		System.out.println("Variance = " + sigma*sigma + ", Ecart-type = " + sigma);
	}
	
	public void keyPressed(KeyEvent e) {
		double[] xt = new double[2];
		int yp = 1;
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_Q:
			System.exit(0);

			break;
		case KeyEvent.VK_DELETE:
			clear();
			System.out.println("Mémoire effacée. ");
			break;
		case KeyEvent.VK_SPACE:

			perceptron2D.my_main(X,Y,m);
			break;

		default:
			break;
		}
	}
	public void keyReleased(KeyEvent e) {	}
	public void keyTyped(KeyEvent e) {}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension size = getSize();
		Composite origComposite;
		origComposite = g2.getComposite();
 		 Width = getWidth();
 		 Height = getHeight();

		// Background
		g.setColor(Color.WHITE);
	        g2.fillRect(00, 00, size.width, size.height);
        
        	// Axes
		g.setColor(Color.BLACK);
        	g2.drawLine(0,size.height/2,size.width,size.height/2);
        	g2.drawLine(size.width/2,0,size.width/2,size.height);

        	// Points
        	int i;        	
        	for(i = 0; i < nPoints; i++) {
			g.setColor(PointsColor[i]);
			g2.fill(new Ellipse2D.Float(Points[i][0] - 5,Points[i][1] - 5, 10, 10));
			//g2.fillRect(Points[i][0],Points[i][1], 10, 10); // rectangle
        	}
        	
        	// Droites
        	for(i = 0; i < nDroites; i++) {
			g.setColor(DroitesColor[i]);
			g2.drawLine(Droites[i][0],Droites[i][1], Droites[i][2],Droites[i][3]);
        	}
        
	}   

}
