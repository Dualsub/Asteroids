package Asteroids;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import Motor.JSpelObjekt;

public class AsteroidsRocks extends JSpelObjekt {

	private double liv = 100;
	private boolean bSkaFörstöras = false;

	public AsteroidsRocks(double startHastighet, Double startPosition, Double startStorlek) {
		super("C:/Users/simsjo2/Documents/Åk2/Programmering/Första/src/Asteroids/Sten.png",
				new Point2D.Double(0.0, startHastighet), new Point2D.Double(0.0, 0.0), startPosition, startStorlek);
		// TODO Auto-generated constructor stub
		bKanKolidera = true;
	}

	@Override
	public void Update(double tid, int width, int height) {

		if (position.y > height || bSkaFörstöras) {
			position.y = (Math.random() * -500.0) - 300.0;
			position.x = (Math.random() * width);
			bSkaFörstöras = false;
			liv = 100;
		}

	}

	@Override
	public void VidKollision(JSpelObjekt obj) {
		super.VidKollision(obj);
		if (obj.getClass() != this.getClass()) {
			if (liv <= 0) {
				bSkaFörstöras = true;
			} else {
				liv -= 34.0;
			}
		}
	}
}
