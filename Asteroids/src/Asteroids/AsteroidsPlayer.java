package Asteroids;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.LinkedList;

import Motor.JSpelObjekt;
import Motor.JSpelSpelare;

public class AsteroidsPlayer extends JSpelSpelare {

	public int poäng = 0;

	public AsteroidsPlayer(String starttyp, double startHastighet, Double startAcceleration, Double startPosition,
			Double startStorlek) {
		super(starttyp, startHastighet, startAcceleration, startPosition, startStorlek);
		// TODO Auto-generated constructor stub
		bKanKolidera = true;
	}

	@Override
	public void VidKollision(JSpelObjekt obj) {
		super.VidKollision(obj);
		if (obj.getClass() != this.getClass()) {
			Förgör();
			Motorn.GameOver();
		}
	}

	@Override
	public void Spacebar() {
		super.Spacebar();
		AsteroidsProjektil proj = (AsteroidsProjektil) Motorn.SpawnaObjekt(
				new AsteroidsProjektil(new Point2D.Double(position.x + (storlek.x / 2), position.y - 30)));
		proj.p = this;
	}

}
