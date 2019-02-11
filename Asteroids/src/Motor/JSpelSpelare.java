package Motor;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;


public class JSpelSpelare extends JSpelObjekt implements KeyListener {

	double maxHastighet;
	
	public JSpelSpelare(String starttyp, double hastighet, Point2D.Double startAcceleration, Point2D.Double startPosition,
			Double startStorlek) {
		super(starttyp,new Point2D.Double(0,0), startAcceleration, startPosition, startStorlek);
		// TODO Auto-generated constructor stub
		this.maxHastighet = hastighet;
	}

	@Override
	public void keyPressed(KeyEvent k) {
		
		
		
		if(k.getKeyCode() == KeyEvent.VK_SPACE) {
		Spacebar();
		}
		if(k.getKeyCode() == KeyEvent.VK_UP) {
		Up();
		}
		if(k.getKeyCode() == KeyEvent.VK_DOWN) {
		Down();
		}
		if(k.getKeyCode() == KeyEvent.VK_LEFT) {
		Left();
		}
		if(k.getKeyCode() == KeyEvent.VK_RIGHT) {
		Right();
		}
	}

	public void Up() {
		hastighet.y = -maxHastighet;
	}
	public void Right() {
		hastighet.x = maxHastighet;
	}
	public void Left() {
		hastighet.x = -maxHastighet;
	}
	public void Down() {
		hastighet.y = maxHastighet;
	}
	public void Spacebar() {
	System.out.println(3);
	}
	
	@Override
	public void SetMotorn(JSpelMotor NyMotor) {
		super.SetMotorn(NyMotor);
		Motorn.addKeyListener(this);
		Motorn.setFocusable(true);
	}
	
	@Override
	public void keyReleased(KeyEvent k) {
		
		if(k.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("hej");
		hastighet.y = 0;
		}
		if(k.getKeyCode() == KeyEvent.VK_DOWN) {
		hastighet.y = 0;
		}
		if(k.getKeyCode() == KeyEvent.VK_LEFT) {
		hastighet.x = 0;
		}
		if(k.getKeyCode() == KeyEvent.VK_RIGHT) {
		hastighet.x = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent k) {

	
		}
	
	
}	

