package Asteroids;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import Motor.JSpelMotor;
import Motor.JSpelObjekt;
import Motor.JSpelSpelare;

@SuppressWarnings("serial")
public class Asteroids extends JSpelMotor implements ActionListener {

	AsteroidsPlayer Spelare = null;

	public Asteroids(String SpelNamn) {
		super(SpelNamn);
		// TODO Auto-generated constructor stub
	}

	public Asteroids(String SpelNamn, Color backgroundColor) {
		super(SpelNamn, backgroundColor);
		// TODO Auto-generated constructor stub
	}

	public Asteroids(String SpelNamn, Color backgroundColor, ArrayList<Component> komps) {
		super(SpelNamn, backgroundColor, komps);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		while(true) {
		Asteroids m = new Asteroids("Steroids", Color.BLACK);
		m.InitilizeGame();
		}
	}

	@Override
	public void GameOver() {
		super.GameOver();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		int highScore = 0;
		PrintWriter utFil = null;
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("AsteroidsHighScore.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (sc != null && sc.hasNextLine()) {
			highScore = Integer.parseInt(sc.nextLine());
			if (highScore < Spelare.poäng) {
				try {
					utFil = new PrintWriter(new File("AsteroidsHighScore.txt"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}		
				if(utFil!=null) {
					utFil.println(Spelare.poäng);
					System.out.println("NyttHighScore");
				}
				utFil.close();
			}

		}
		/*
		this.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("Exit");
		add(b1);
		b1.setSize(40, 200);
		b1.addActionListener(e->{
			System.exit(0);
		});
		JButton b2 = new JButton("Restart");
		add(b2);
		b2.addActionListener(e->{
			System.out.println("restart");
		});
		setBackground(Color.BLACK);
		 setVisible(true);
		
			repaint();
		*/
		
	}

	@Override
	public void GameStart() {
		super.GameStart();
		// Strärnor
		for (int i = 0; i < 50; i++) {
			SpawnaObjekt(new AsteroidsStjärnor(400 * Math.random() + 10,
					new Point2D.Double(Math.random() * getHeight(), Math.random() * getWidth()),
					new Point2D.Double(2.0, 2.0)));
		}

		// Spelare
		Spelare = (AsteroidsPlayer) SpawnaObjekt(
				new AsteroidsPlayer("C:/Users/simsjo2/Documents/Åk2/Programmering/Första/src/Asteroids/Skepp.png",
						200.0, new Point2D.Double(0, 0), new Point2D.Double(getWidth() / 2, getHeight() * .7),
						new Point2D.Double(60, 60)));
		// Stenar
		for (int i = 0; i < 15; i++) {
			double s = 25 + (Math.random() * 150);
			SpawnaObjekt(new AsteroidsRocks(100,
					new Point2D.Double((Math.random() * -500.0) - 300.0, Math.random() * getWidth()),
					new Point2D.Double(s, s)));
		}
	}

	@Override
	public void GameUpdate(double tid) {
		super.GameUpdate(tid);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
