package Asteroids;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import Motor.JSpelObjekt;

public class AsteroidsRocks extends JSpelObjekt {

	private double liv = 100;
	private boolean bSkaF�rst�ras = false;

	public AsteroidsRocks(double startHastighet, Double startPosition, Double startStorlek) {
		super("C:/Users/simsjo2/Documents/�k2/Programmering/F�rsta/src/Asteroids/Sten.png",
				new Point2D.Double(0.0, startHastighet), new Point2D.Double(0.0, 0.0), startPosition, startStorlek);
		// TODO Auto-generated constructor stub
		bKanKolidera = true;
	}

	@Override
	public void Update(double tid, int width, int height) {

		if (position.y > height || bSkaF�rst�ras) {
			position.y = (Math.random() * -500.0) - 300.0;
			position.x = (Math.random() * width);
			bSkaF�rst�ras = false;
			liv = 100;
		}

	}

	@Override
	public void VidKollision(JSpelObjekt obj) {
		super.VidKollision(obj);
		if (obj.getClass() != this.getClass()) {
			if (liv <= 0) {
				bSkaF�rst�ras = true;
			} else {
				liv -= 34.0;
			}
		}
	}
}
