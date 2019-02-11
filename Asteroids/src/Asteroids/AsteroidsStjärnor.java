package Asteroids;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import Motor.JSpelObjekt;

public class AsteroidsStjärnor extends JSpelObjekt {

	public AsteroidsStjärnor(double startHastighet, Double startPosition, Double startStorlek ) {
		super("Oval", new Point2D.Double(0.0, startHastighet), new Point2D.Double(0.0, 0.0), startPosition, startStorlek);
		// TODO Auto-generated constructor stub
		bKanKolidera = false;
	}

	@Override
	public void Update(double tid, int width, int height) {
	
		if(position.y > height) {
			position.y = (Math.random()*-500.0)-300.0;
			position.x = (Math.random()*width);
		}
		
	}
	
}
