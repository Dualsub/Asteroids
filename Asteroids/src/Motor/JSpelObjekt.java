package Motor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class JSpelObjekt implements ImageObserver {

	protected boolean bKanKolidera = false;
	
	protected Point2D.Double hastighet;
	protected Point2D.Double acceleration;

	protected String typ;
	public Point2D.Double position;
	protected Point2D.Double storlek;
	protected BufferedImage img;

	protected JSpelMotor Motorn = null;

	public void SetMotorn(JSpelMotor NyMotor) {
		Motorn = NyMotor;
	}

	public JSpelObjekt(String starttyp, Point2D.Double startHastighet, Point2D.Double startAcceleration,
			Point2D.Double startPosition, Point2D.Double startStorlek) {

		typ = starttyp;
		hastighet = startHastighet;
		position = startPosition;
		storlek = startStorlek;
		acceleration = startAcceleration;

		if (typ.contains("C:"))
			;
		{
			try {
				img = ImageIO.read(new File(typ));
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}

	public void VidKollision(JSpelObjekt obj) {

	}

	public void Rörelse(double deltaTid) {

		hastighet.x += (acceleration.x * deltaTid);
		hastighet.y += (acceleration.y * deltaTid);

		if ((hastighet.x != 0.0) || (hastighet.y != 0.0)) {

			double x = position.x;
			double y = position.y;

			position.setLocation(((hastighet.x * deltaTid) + x), ((hastighet.y * deltaTid) + y));

		}
	}

	public void Draw(Graphics g, int sWidth, int sHeight) {

		if (g == null)
			return;

		switch (typ) {
		case "Kub":
			g.fillRect((int) (position.x), (int) (position.y), (int) storlek.x, (int) storlek.y);
			break;
		case "Oval":
			g.fillOval((int) (position.x), (int) (position.y), (int) storlek.x, (int) storlek.y);
			g.setColor(Color.WHITE);
			break;
		default:
			if (img != null)
				g.drawImage(img, (int) (position.x + .5), (int) (position.y + .5), (int) (storlek.x + .5),
						(int) (storlek.y + .5), this);
			break;
		}

	}

	public void Förgör() {
		Motorn.Objekt.remove(this);
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}


	public void Update(double tid, int width, int height) {
		// TODO Auto-generated method stub
		
	}
}
