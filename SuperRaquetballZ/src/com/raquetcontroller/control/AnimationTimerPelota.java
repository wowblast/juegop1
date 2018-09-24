package com.raquetcontroller.control;





import com.raquet.entity.Jugador;
import com.raquet.entity.Jugador1;
import com.raquet.entity.JugadorA;
import com.raquet.entity.Pelota;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class AnimationTimerPelota extends AnimationTimer
{
	private Pane paneCancha;
	private Pelota pelota;
	;
	private JugadorA ja;
	private JugadorA jb;
	private Jugador1 j2;
	private Jugador j1;
	public AnimationTimerPelota (Pane paneCancha, Pelota pelota,JugadorA ja,JugadorA jb,Jugador j1,Jugador1 j2)
	{
		this.paneCancha = paneCancha;
		this.pelota = pelota;

		this.ja=ja;
		this.jb=jb;
		this.j1=j1;
		this.j2=j2;
	}

	@Override
	public void handle(long arg0)
	{
		pelota.mover(paneCancha.getWidth(), paneCancha.getHeight(),ja,jb,j1,j2);
		pelota.golpe(ja,jb);
		
		
		
		
	}

}
