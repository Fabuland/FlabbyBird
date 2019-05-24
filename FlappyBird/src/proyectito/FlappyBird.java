package proyectito;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FlappyBird extends JFrame {

	JPanel panelP;
	Timer timePuls, timeSolt, timePipes;
	JLabel pipeUp1, pipeDown1, pipeUp2, pipeDown2, pipeUp3, pipeDown3, suelo, bird;
	JButton pulsar;
	int contPulsar;

	public FlappyBird() {
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setSize(anchoPantalla / 3, (alturaPantalla * 2) / 3);
		setLocation(anchoPantalla / 3, alturaPantalla / 6);
		setTitle("Flabby bird");
		// Image icono = miPantalla.getImage("src\\pic\\masterball.png");
		// setIconImage(icono);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panelP = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File("src\\pics\\backgroundflabby.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				g.drawImage(img, 0, 0, null);
			}
		};
		panelP.setBounds(0, 0, anchoPantalla / 3, (alturaPantalla * 2) / 3);
		panelP.setVisible(true);
		panelP.setLayout(null);
		getContentPane().add(panelP);
		
		bird = new JLabel();
		bird.setIcon(new ImageIcon("src\\pics\\bird.png"));
		bird.setBounds(200, 240, 60, 42);
		panelP.add(bird);
		
		suelo = new JLabel();
		suelo.setIcon(new ImageIcon("src\\pics\\suelo.png"));
		suelo.setBounds(0, 549, 626, 133);
		panelP.add(suelo);

		pipeUp1 = new JLabel();
		pipeUp1.setIcon(new ImageIcon("src\\pics\\pipe1.png"));
		pipeUp1.setBounds(626, 300, 100, 450);
		panelP.add(pipeUp1);
		
		pipeDown1 = new JLabel();
		pipeDown1.setIcon(new ImageIcon("src\\pics\\pipe2.png"));
		pipeDown1.setBounds(626, -200, 100, 450);
		panelP.add(pipeDown1);
		
		pipeUp2 = new JLabel();
		pipeUp2.setIcon(new ImageIcon("src\\pics\\pipe1.png"));
		pipeUp2.setBounds(626, 300, 100, 450);
		panelP.add(pipeUp2);
		
		pipeDown2 = new JLabel();
		pipeDown2.setIcon(new ImageIcon("src\\pics\\pipe2.png"));
		pipeDown2.setBounds(626, -200, 100, 450);
		panelP.add(pipeDown2);
		
		pipeUp3 = new JLabel();
		pipeUp3.setIcon(new ImageIcon("src\\pics\\pipe1.png"));
		pipeUp3.setBounds(626, 300, 100, 450);
		panelP.add(pipeUp3);
		
		pipeDown3 = new JLabel();
		pipeDown3.setIcon(new ImageIcon("src\\pics\\pipe2.png"));
		pipeDown3.setBounds(626, -200, 100, 450);
		panelP.add(pipeDown3);
		
		pulsar = new JButton();
		pulsar.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				posBirdPulsar();
				if(pulsar.getModel().isArmed()) {
					contPulsar++;
				}
				if(contPulsar >= 2)
				timeSolt.stop();
			}

			public void mouseReleased(MouseEvent e) {
				timePuls.stop();
				posBirdSoltar();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		pulsar.setBounds(0, 0, 626, 682);
		pulsar.setOpaque(false);
		pulsar.setContentAreaFilled(false);
		pulsar.setBorderPainted(false);
		panelP.add(pulsar);

		empezarJuego();
	}

	public void crearColumnas() {

	}

	public void empezarJuego() {
		timePipes = new Timer(10, null);
		ActionListener listener = new ActionListener() {
			int posInicial = 626;
			int movimPipeUp1 = posInicial;
			int movimPipeDown1 = posInicial;
			int movimPipeUp2 = posInicial + 300;
			int movimPipeDown2 = posInicial + 300;
			int movimPipeUp3 = posInicial + 600;
			int movimPipeDown3 = posInicial + 600;
			int yPipe1 = crearYPipesRandom();
			int yPipe2 = crearYPipesRandom();
			int yPipe3 = crearYPipesRandom();
			
			public void actionPerformed(ActionEvent e) {
				
				movimPipeUp1 -= 2;
				pipeUp1.setBounds(movimPipeUp1, yPipe1, 100, 450);
				movimPipeDown1 -= 2;
				pipeDown1.setBounds(movimPipeDown1, (yPipe1-550), 100, 450);
				
				if(movimPipeUp1 == -300) {
					movimPipeUp1 = posInicial;
					movimPipeDown1 = posInicial;
					yPipe1 = crearYPipesRandom();
				}
				
				movimPipeUp2 -= 2;
				pipeUp2.setBounds(movimPipeUp2, yPipe2, 100, 450);
				movimPipeDown2 -= 2;
				pipeDown2.setBounds(movimPipeDown2, (yPipe2-550), 100, 450);
				
				if(movimPipeUp2 == -300) {
					movimPipeUp2 = posInicial;
					movimPipeDown2 = posInicial;
					 yPipe2 = crearYPipesRandom();
				}
				
				movimPipeUp3 -= 2;
				pipeUp3.setBounds(movimPipeUp3, yPipe3, 100, 450);
				movimPipeDown3 -= 2;
				pipeDown3.setBounds(movimPipeDown3, (yPipe3-550), 100, 450);
				
				if(movimPipeUp3 == -300) {
					movimPipeUp3 = posInicial;
					movimPipeDown3 = posInicial;
					yPipe3 = crearYPipesRandom();
				}
			}

		};
		timePipes.addActionListener(listener);
		timePipes.start();
	}
	
	public int crearYPipesRandom() {
		int y1 = 100;
		int y2 = 476;
 		int random = (int)Math.floor(Math.random()*(y1-(y2+1))+(y2));
		
		return random;
	}
	
	public void posBirdPulsar(){
		timePuls = new Timer(20, null);
		ActionListener listener = new ActionListener() {
			int posBirdUp = bird.getY();
			public void actionPerformed(ActionEvent e) {
				posBirdUp -= 5;
				bird.setBounds(200, posBirdUp, 60, 42);;
			}

		};
		timePuls.addActionListener(listener);
		timePuls.start();
	}
	
	public void posBirdSoltar(){
		timeSolt = new Timer(20, null);
		ActionListener listener = new ActionListener() {
			int posBirdDown = bird.getY();
			public void actionPerformed(ActionEvent e) {
				posBirdDown += 5;
				bird.setBounds(200, posBirdDown, 60, 42);;
			}

		};
		timeSolt.addActionListener(listener);
		timeSolt.start();
	}

}
