package com.raquetcontroller.control;











import java.io.File;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

import com.raquet.entity.Jugador;
import com.raquet.entity.Jugador1;
import com.raquet.entity.JugadorA;
import com.raquet.entity.Pelota;
import com.raquet.entity.PequeñoPublico;
import com.raquet.entity.Publico;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
public class Controlador {
	@FXML
	private Pane paneCancha;
	@FXML
	private Pane ima;
	private PequeñoPublico ken;
	private Pelota pelota;
	private Publico up;
	private Publico minion;
	private AnimationTimerPelota timerPelota;
	private JugadorA ja;
	private JugadorA jb;
	private Jugador j1;
	private Jugador1 j2;
	
	MediaPlayer player;
	 MediaPlayer player2;
	 MediaPlayer lichpoder;
	 MediaPlayer arthaspoder;
	 MediaPlayer lichloser;
	 MediaPlayer arthasloser;
	

	public Controlador(){
		
	}
	@FXML
	public void initialize()
	{
		
		System.out.println("danilo");	
		Rectangle clip = new Rectangle(0, 0, 0, 0);
		clip.widthProperty().bind(paneCancha.widthProperty());
		clip.heightProperty().bind(paneCancha.heightProperty());
		paneCancha.setClip(clip);
		Rectangle clip1 = new Rectangle(0, 0, 0, 0);
		clip1.widthProperty().bind(ima.widthProperty());
		clip1.heightProperty().bind(ima.heightProperty());
		ima.setClip(clip1);
		String ima1="/com/raquet/imagenes/aplausos.gif";
		String ima2="/com/raquet/imagenes/ken.gif";
		String ima3="/com/raquet/imagenes/minion.gif";
		up= new Publico(-50,0,ima1);
		minion= new Publico(-50,400,ima3);
		ken = new PequeñoPublico(20,160,ima2);
		ima.getChildren().addAll(up,minion,ken);
		// la linea de saque
		Rectangle rec = new Rectangle(0,250,454,5);
		Rectangle rec1 = new Rectangle(0,350,454,5);
		Rectangle rec2 = new Rectangle(0,450,30,5);
		Rectangle rec21 = new Rectangle(50,450,30,5);
		Rectangle rec22 = new Rectangle(100,450,30,5);
		Rectangle rec23 = new Rectangle(150,450,30,5);
		Rectangle rec24 = new Rectangle(200,450,30,5);
		Rectangle rec25 = new Rectangle(250,450,30,5);
		Rectangle rec26 = new Rectangle(300,450,30,5);
		Rectangle rec27 = new Rectangle(350,450,30,5);
		Rectangle rec277 = new Rectangle(400,450,30,5);
		Rectangle rec28 = new Rectangle(50,250,5,100);
		Rectangle rec29 = new Rectangle(400,250,5,100);
		Rectangle ghost = new Rectangle(300,312,22,(0.2));
		Rectangle ghost2 = new Rectangle(315,280,(0.2),32);
		ghost.setFill(Color.BROWN);
		paneCancha.getChildren().addAll(rec,rec1,rec2,rec21,rec22,rec23,rec24,rec25,rec26,rec27,rec29,rec28,rec277,ghost,ghost2);
		pelota = new Pelota(100.0, 300.0, 10.0, 50);
		
		
		//paneCancha.getChildren().add(pelota2);
		
		jb= new JugadorA(200,600);
		j2=new Jugador1(200,600);
		j1= new Jugador(40,320);
		ja = new JugadorA(40,320);
		paneCancha.getChildren().add(j1);
		paneCancha.getChildren().add(j2);
		paneCancha.getChildren().add(ja);
		paneCancha.getChildren().add(jb);
		paneCancha.getChildren().add(pelota);
	
		timerPelota = new AnimationTimerPelota(paneCancha, pelota,ja,jb,j1,j2);
		
		timerPelota.start();
		
		Media media = null;
		Media media2=null;
		Media arthaspower=null;
		Media lichpower=null;
		Media arthaslose=null;
		Media lichlose=null;
		try {
		  media = new Media(getClass().getResource("/com/raquet/music/mop.mp3").toURI().toString());
		  media2 = new Media(getClass().getResource("/com/raquet/music/fire.mp3").toURI().toString());
		  arthaspower = new Media(getClass().getResource("/com/raquet/music/arthaspoder.mp3").toURI().toString());
		  lichpower = new Media(getClass().getResource("/com/raquet/music/lichpoder.mp3").toURI().toString());
		  arthaslose = new Media(getClass().getResource("/com/raquet/music/arthasperdio.mp3").toURI().toString());
		  lichlose = new Media(getClass().getResource("/com/raquet/music/lichperdio.mp3").toURI().toString());
		} catch (URISyntaxException e) {
		  e.printStackTrace();
		} 
	
	       player = new MediaPlayer(media); 
	      player2 = new MediaPlayer(media2); 
	      lichpoder = new MediaPlayer(lichpower);
	 	 arthaspoder = new MediaPlayer(arthaspower);
	 	  lichloser= new MediaPlayer(lichlose);
	 	  arthasloser= new MediaPlayer(arthaslose);
	 	
	      
	      player.play();
	      
	  
	

	
	}
	@FXML
    private Label marca1;
	@FXML
    private Label marca2;
	@FXML
    private Label ganador;

	
	
	@FXML
	public void botonSalir()
	{
		System.out.println("botonSalir pressed.");
		System.exit(0);
		
	}

	
	@FXML
	public void keyMoveHandler(KeyEvent teclas) {
		double x;
		double y;
		double x1;
		double y1;

			
		marca1.setText(""+pelota.getScore1());
		marca2.setText(""+pelota.getScore2());
		if(pelota.getScore1()>=10||pelota.getScore2()>10)
		{
			player.stop();
			player2.play();
		

		}
		if(pelota.getScore1()==15)
		{	player2.stop();
			lichloser.play();
			JOptionPane.showMessageDialog(null,"Felicidades Jugador 1, Jugador 2 este juego es demasiado para ti >:v" );
			System.exit(0);
		}
		if(pelota.getScore2()==15)
		{	player2.stop();
			arthasloser.play();
			JOptionPane.showMessageDialog(null,"Felicidades Jugador 2, Jugador 1 este juego es demasiado para ti >:v" );
			System.exit(0);
		}
		x = j1.getCenterX();
		y = j1.getCenterY();
		x = ja.getX();
		y = ja.getY();
		x1=jb.getX();
		y1=jb.getY();
		
	
		if(pelota.getEstado()==false)
		{
			switch (teclas.getCode()) {
			case ENTER:
				
				pelota.setEstado(true);
			default:
				break;
				
				
			}
		}
		if(pelota.getEstado()==true)
		{
		switch (teclas.getCode()) {
		
		
		case NUMPAD8:
		
			if (y > 0)
				y -= 35;
			break;
		case NUMPAD5:
	
			if (y +50 <= paneCancha.getHeight())
				y += 35;
			break;
		case NUMPAD4:
		
			if (x > 0)
				x -= 35;
			break;
		case NUMPAD6:

			if ((x + 80) <=paneCancha.getWidth())
				x += 35;
			break;
		case W:
			if (y1 > 0)
				y1 -= 35;
			break;
		case S:
			if (y1 +50 <= paneCancha.getHeight())
				y1 += 35;
			break;
		case A:
			if (x1 > 0)
				x1 -= 35;
			break;
		case D:
			if ((x1 + 80) <=paneCancha.getWidth())
				x1 += 35;
			break;
		case ADD:
			
			
			if(pelota.getScore1()%4==0&&pelota.getScore1()!=0)
			{
				lichpoder.stop();
				arthaspoder.play();
				pelota.setSentido(-(pelota.getSentido()));	
			}
						
			break;
		case V:
			
			if(pelota.getScore2()%4==0&&pelota.getScore2()!=0)
			{
				arthaspoder.stop();
				
				lichpoder.play();
				pelota.setSentido(2);
	
			}
				
			break;
			
		
		default:
			break;
		}
		j1.setX(x);
		j1.setY(y);
		ja.setX(x);
		ja.setY(y);
		jb.setX(x1);
		jb.setY(y1);
		j2.setX(x1);
		j2.setY(y1);
	}
		
	}
}
