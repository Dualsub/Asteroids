package Asteroids;

import java.awt.geom.Point2D;
import Motor.JSpelObjekt;

public class AsteroidsProjektil extends JSpelObjekt {

	AsteroidsPlayer p;
	
	public AsteroidsProjektil(Point2D.Double StartPosition) {
		super("Oval", new Point2D.Double(0.0, -1000.0), new Point2D.Double(0.0, 0.0), StartPosition, new Point2D.Double(10.0, 10.0));
	bKanKolidera = true;
	}

	@Override
	public void VidKollision(JSpelObjekt obj) {
		super.VidKollision(obj);
		Förgör();
		p.poäng++;
	}
	@Override
	public void Update(double tid, int width, int height) {
	
		if(position.y > height) {
			Förgör();
		}
	}
}
