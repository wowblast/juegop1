package com.raquet.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Pelota extends ImageView
{
	private boolean estado;
	private double angulo;
	private double radius;
	private double sentido;

	private double centerX;;
	private double centerY;
	private JugadorA ja;
	private JugadorA jb;
	private Jugador j1;
	private Jugador1 j2;
	private  Pane paneCancha;
	private int contador = 0;
	private int contador2=-1;
	private int score1;
	private int score2;
	
	public Pelota(double x, double y, double radio, double angulo)
	{

		Image image = new Image("/com/raquet/imagenes/disco.png");
	this.setImage(image);
		this.setX(x-radio);
		this.setY(y-radio);
		this.setFitWidth(radio*2);
		this.setFitHeight(radio*2);
		
		this.centerX= x;
		this.centerY = y;
		this.radius = radio;
		this.estado = false;
		this.angulo = angulo;
		this.sentido = 7;
	
	}
	
	

	public int getScore1() {
		return score1;
	}



	public int getScore2() {
		return score2;
	}



	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}



	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
	}


	public boolean getEstado() {
		return estado;
	}

	public double getCenterX() {
		return centerX;
	}

	public void setCenterX(double centerX) {
		this.setX(centerX-radius);
		this.centerX = centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	public void setCenterY(double centerY) {
		this.setY(centerY-radius);
		this.centerY = centerY;
	}

	public void changeEstado()
	{
		this.estado = ! this.estado;
	}
	
	public double getSentido() {
		return sentido;
	}



	public void setSentido(double sentido) {
		this.sentido = sentido;
	}



	public int getContador() {
		return contador;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	


	public void setContador(int contador) {
		this.contador = contador;
	}



	public void golpe(JugadorA ja,JugadorA jb)
	{
	
		
		
		
		
		if(ja.getBoundsInParent().intersects(this.getBoundsInParent()))
		{
			
			angulo=-angulo;
			
			contador=contador+1;
			contador2=contador2-1; 
			sentido =sentido+2;
		}
		if(jb.getBoundsInParent().intersects(this.getBoundsInParent()))
		{
			angulo=-angulo;
		
			contador2=contador2+1;
			contador=contador-1;

			sentido =sentido+2;
		}
	
	
	}
	
	public void mover(double ancho, double alto,JugadorA ja,JugadorA jb,Jugador j1,Jugador1 j2)
	{
	
		if (estado)
		{
			double x = this.getCenterX();
			double y = this.getCenterY();
			
				 	x+=sentido;
					
					y+=sentido*Math.tan(Math.toRadians(angulo));
					
		
			if (x-this.getRadius() <=0 || x+this.getRadius()>= ancho)
			{
				sentido = -sentido;
				angulo = -angulo;
				x+=sentido;
				y+=sentido*Math.tan(Math.toRadians(angulo));
			}
			else if (y-this.getRadius() <= 0 )
			{
				angulo = -angulo;
				x+=sentido;
				y+=sentido*Math.tan(Math.toRadians(angulo));
			}
			
			
					if(contador==2)
					{
						x=100;
						y=300;
						this.setCenterX(x);
						this.setCenterY(y);
						
						System.out.println("entro");
						estado=false;
						contador2=0;
						contador=0;
						score2=score2+1;
						sentido=7;
						ja.setX(200);
						ja.setY(600);
						j1.setCenterX(200);
						j1.setCenterY(600);
						jb.setX(40);
						jb.setY(320);
						j2.setX(40);
						j2.setY(320);
							
						
						x+=sentido;
						y+=sentido*Math.tan(Math.toRadians(angulo));
					}
					if(contador2==2)
					{
						x=100;
						y=300;
						this.setCenterX(x);
						this.setCenterY(y);
						
						System.out.println("entro");
						estado=false;
						contador=0;
						contador2=0;
						score1=score1+1;
						sentido=7;
						jb.setX(200);
						jb.setY(600);
						j2.setX(200);
						j2.setY(600);
						ja.setX(40);
						ja.setY(320);
						j1.setCenterX(40);
						j1.setCenterY(320);
						
						
						x+=sentido;
						y+=sentido*Math.tan(Math.toRadians(angulo));
					}
					 if( y+this.getRadius() >= alto)
					{	
						x=100;
						y=300;
						this.setAngulo(-50);
						if(contador==1){
							
							this.setCenterX(x);
							this.setCenterY(y);
							
							System.out.println("entro");
							estado=false;
							contador=1;
							contador2=0;
							score1=score1+1;
							sentido=7;
							jb.setX(200);
							jb.setY(600);
							j2.setX(200);
							j2.setY(600);
							ja.setX(40);
							ja.setY(320);
							j1.setCenterX(40);
							j1.setCenterY(320);
							
							
							x+=sentido;
							y+=sentido*Math.tan(Math.toRadians(angulo));

						}
						if(contador2==1)
						{
							
							this.setCenterX(x);
							this.setCenterY(y);
							
							System.out.println("entro");
							estado=false;
							contador2=1;
							contador=0;
					
							score2=score2+1;
							sentido=7;
							ja.setX(200);
							ja.setY(600);
							j1.setCenterX(200);
							j1.setCenterY(600);
							jb.setX(40);
							jb.setY(320);
							j2.setX(40);
							j2.setY(320);
							
							
							x+=sentido;
							y+=sentido*Math.tan(Math.toRadians(angulo));
						}
				}

			this.setCenterX(x);
			this.setCenterY(y); 
		}
	}
}

