package com.raquet.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Publico extends ImageView {
	private double centerX;
	private double centerY;
	private String imagen;
	public Publico(double centerX, double centerY,String ima) {
		super();
		this.centerX = centerX;
		this.centerY = centerY;
		this.imagen=ima;
		
		Image image = new Image(imagen);
		this.setImage(image);
			this.setRotate(90);
			this.setX(centerX);
			this.setY(centerY);
			this.setFitWidth(300);
			this.setFitHeight(200);
			
	}
}
