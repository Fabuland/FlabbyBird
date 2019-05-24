package proyectito;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FlappyBird extends JFrame {

	JPanel panelP;
	Timer time;
	JLabel pipe1, pipe2;

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

		pipe1 = new JLabel();
		pipe1.setIcon(new ImageIcon("src\\pics\\pipe1.png"));
		pipe1.setBounds(526, 300, 100, 450);
		panelP.add(pipe1);
		
		pipe2 = new JLabel();
		pipe2.setIcon(new ImageIcon("src\\pics\\pipe2.png"));
		pipe2.setBounds(526, 0, 100, 200);
		panelP.add(pipe2);

		empezarJuego();
	}

	public void crearColumnas() {

	}

	public void empezarJuego() {
		time = new Timer(10, null);
		ActionListener listener = new ActionListener() {
			int movimPipe1 = pipe1.getX();
			int movimPipe2 = pipe2.getX();
			int posInicial = 626;

			public void actionPerformed(ActionEvent e) {
				movimPipe1 -= 2;
				pipe1.setBounds(movimPipe1, 300, 100, 450);
				movimPipe2 -= 2;
				pipe2.setBounds(movimPipe2, 0, 100, 200);
				
				if(movimPipe1 == -100) {
					movimPipe1 = posInicial;
					movimPipe2 = posInicial;
				}
				System.out.println(movimPipe1);

			}

		};
		time.addActionListener(listener);
		time.start();
	}

}
