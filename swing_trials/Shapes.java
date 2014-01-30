import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class Shapes
{
	public static void main(String []args)
	{
		MyFrame f = new MyFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

class MyFrame extends JFrame
{
	public MyFrame()
	{
		setTitle("2D Shapes");
		setSize(400,400);
		setLocation(200,200);
		
		MyPanel p = new MyPanel();
		add(p);
	}
}	

class MyPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		//rectangle
		Rectangle2D r2d = new Rectangle2D.Double(100,100,200,150);
		g2d.draw(r2d);
		
		//rectangle with float values
		Rectangle2D r = new Rectangle2D.Float(350.5F,350.5F,20F,10F);
		g2d.draw(r);

		//ellipse
		Ellipse2D e2d = new Ellipse2D.Double();
		e2d.setFrame(r2d);
		g2d.draw(e2d);

		//line - diagonal of the rectangle
		double topX = r2d.getMinX();
		double topY = r2d.getMinY();
		double width = r2d.getWidth();
		double height = r2d.getHeight();

		Line2D l2d = new Line2D.Double(topX,topY,topX+width,topY+height);
		g2d.draw(l2d);
		
		//circle - with the same centre as that of the rectangle and radius 150
		double centerX = r2d.getCenterX();
		double centerY = r2d.getCenterY();
		double radius = 150;
		
		Ellipse2D circle2d = new Ellipse2D.Double();
		circle2d.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
		g2d.draw(circle2d); 
	}
}

