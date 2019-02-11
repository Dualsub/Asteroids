package Motor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JSpelMotor extends JFrame {

	
	boolean bFortsätt = true;

	protected ArrayList<Component> Komponenter = new ArrayList<Component>();
	
	private double fpsRäknare = 101;
	
	protected LinkedList<JSpelObjekt> Objekt = new LinkedList<JSpelObjekt>();
	String SpelNamn = "SpeletsNamn";
	double dt = 1;
	int x = 0;
	private BufferStrategy bufferStrategy = null;
	private Graphics bufferGraphics = null;
	
	public JSpelMotor(String SpelNamn, Color backgroundColor, ArrayList<Component> komps) {

		this.SpelNamn = SpelNamn;
		setSize(1200, 675);
		setMinimumSize(new Dimension(400, 225));
		for (Component komp : komps) {
			add(komp);
			komp.setPreferredSize(new Dimension(1000, 200));
			komp.setBackground(Color.WHITE);
			
		}
		setFocusable(true);
		setVisible(true);
		this.setBackground(backgroundColor);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JSpelMotor(String SpelNamn, Color backgroundColor) {

		
		this.SpelNamn = SpelNamn;
		setSize(1200, 675);
		setMinimumSize(new Dimension(400, 225));
		setFocusable(true);
		setVisible(true);
		this.setBackground(backgroundColor);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JSpelMotor(String SpelNamn) {

		this.SpelNamn = SpelNamn;
		setSize(1200, 675);
		setMinimumSize(new Dimension(400, 225));
		setFocusable(true);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void InitilizeGame() {
		
		long t1 = System.currentTimeMillis();
		
		GameStart();
		
		bFortsätt = true;
		
		while(bFortsätt) {
			
			t1 = System.currentTimeMillis();
			
			GameUpdate(dt);
			
			Draw();
			
			BufferTillSkärm();
			
			long t2 = System.currentTimeMillis();
			dt = (t2-t1)*0.001;	
			
		}
		
	}	
	
	public void BufferTillSkärm() {
		
		bufferStrategy.show();
		
		Toolkit.getDefaultToolkit().sync();
		
	}
	
	public void GameOver() {
		bFortsätt = false;
	}
	
	private void Draw() {
		
		if(bufferStrategy == null) {
			this.createBufferStrategy(2);
			bufferStrategy = this.getBufferStrategy();
			bufferGraphics = bufferStrategy.getDrawGraphics();
		}
		
		
		bufferGraphics = bufferStrategy.getDrawGraphics();
		try {
			bufferGraphics.clearRect(0, 0, getWidth(), getHeight());

			Graphics g = bufferGraphics;
			
			for (int i = 0; i < Objekt.size(); i++) {
				
				if (Objekt.get(i) == null)
					return;
				
				JSpelObjekt obj = Objekt.get(i); 
				obj.Draw(g, getWidth(), getHeight());
				
				}
				

			
				g.finalize();
			}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			bufferGraphics.dispose();
		}
		
	}
	
	public JSpelObjekt SpawnaObjekt(JSpelObjekt Obj) {
		Objekt.add(Obj);
		Obj.SetMotorn(this);
		return Obj;
	}
	
	public void GameStart() {
		

		
	}
	
	public void GameUpdate(double tid) {
		
		if(fpsRäknare < 0.2) {
			fpsRäknare += tid;
		}else {
		String s = String.valueOf((int)(1.0/(tid)));
		this.setTitle(SpelNamn+"  FPS: "+s);
		fpsRäknare = 0.0;
		}
		for (int i = 0; i < Objekt.size(); i++) {
			
			JSpelObjekt obj = Objekt.get(i); 
			obj.Rörelse(tid);
			obj.Update(tid, getWidth(), getHeight());
			if(obj.bKanKolidera) {
			
			for (int j = 0; j < Objekt.size(); j++) {
				
				JSpelObjekt otherObj = Objekt.get(j);
			
				if(i!=j&&otherObj.bKanKolidera) {
			
					if(((obj.position.x < (otherObj.position.x+otherObj.storlek.x))&&((obj.position.x+obj.storlek.x)> otherObj.position.x))&&((obj.position.y < (otherObj.position.y+otherObj.storlek.y))&&((obj.position.y+obj.storlek.y)> otherObj.position.y))) {
					
						obj.VidKollision(otherObj);
						otherObj.VidKollision(obj);
						
					}
				
				}
					
				
			
		}
			}
			
			}
		
	}
	
}
