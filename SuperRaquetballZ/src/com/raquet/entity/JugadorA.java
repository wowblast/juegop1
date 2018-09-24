package com.raquet.entity;

import javafx.scene.shape.Rectangle;

public class JugadorA extends Rectangle {
private double x;
private double y;
private boolean estadoj;
public JugadorA(double x, double y) {
	super();
	this.x = x;
	this.y=y;
	estadoj=true;
	if(estadoj==true)
	{

		this.y = y;
		this.setX(x);
		this.setY(y);
		this.setWidth(80);
		this.setHeight(4);
	}
	
	
	
	
	
}

public void setEstadoj(boolean estadoj) {
	this.estadoj = estadoj;
}

public boolean isEstadoj() {
	return estadoj;
}


}


