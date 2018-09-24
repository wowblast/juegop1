package com.raquet.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Jugador1  extends ImageView{
	private double centerX;
	private double centerY;
	
	public Jugador1(double centerX, double centerY) {
		super();
		this.centerX = centerX;
		this.centerY = centerY;
		
		Image image = new Image("/com/raquet/imagenes/arthas2.jpg");
		this.setImage(image);
			this.setX(centerX);
			this.setY(centerY);
			this.setFitWidth(80);
			this.setFitHeight(50);
			
	}
	public double getCenterX() {
		return centerX;
	}
	public double getCenterY() {
		return centerY;
	}
	
	
	
}

	