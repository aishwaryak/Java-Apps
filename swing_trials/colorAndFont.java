import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;

class colorAndFont
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
		setTitle("Colors and Fonts");
		setSize(800,600);
		setLocation(100,100);
	
		MyPanel p = new MyPanel();
		//add(p);

		MyComponent com = new MyComponent();
		com.setBackground(Color.BLUE);  //sets the color that is used for drawing on the component
		add(com);
		//add(p);
	}
}	

class MyPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

	//coloring text	
		g2d.setPaint(Color.RED);
		g2d.drawString("Example",75,100); 

	//filling a shape with color - eg1
		g2d.setPaint(new Color(0,0,0));
		Rectangle2D r1 = new Rectangle2D.Double(150,150,200,100);
		g2d.fill(r1);
	//eg 2
		Color c = new Color(180,0,0);
		g2d.setPaint(c);
		Ellipse2D e = new Ellipse2D.Double(350,350,50,30); 
		g2d.fill(e);
		g2d.drawString("Hello",410,410);

	//brightening the colour
		g2d.setPaint(c.brighter().brighter().brighter()); //can be used to highlight text
		g2d.drawString("Hello",450,450);


	}
}

class MyComponent extends Component
{
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
	//setting font
		Font eg = new Font("SansSerif",Font.BOLD+Font.ITALIC,20);
		g2d.setFont(eg);
	//coloring text	
		g2d.setPaint(Color.BLUE); //over-written by setBackground()
		g2d.drawString("Component",75,100); 
	}
}

