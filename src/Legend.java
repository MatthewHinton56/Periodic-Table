//Matthew Hinton
//3/16/2017
//CS III H 6th
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * The Legend for the Periodic Table.
 */
public class Legend extends JFrame {

	/**
	 * Constructs a legend for the Periodic Table, giving descriptions to all the colors.
	 * 
	 */
	public Legend()
	{
		setTitle("Legend");
		setLayout(new GridLayout(1,2));
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(4,1));
		JPanel temp;
		JComponent tempC;
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.BLACK);
		temp.add(tempC);
		temp.add(new JLabel("Solid"));
		left.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.BLUE);
		temp.add(tempC);
		temp.add(new JLabel("Liquid"));
		left.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.RED);
		temp.add(tempC);
		temp.add(new JLabel("Gas"));
		left.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.WHITE);
		temp.add(tempC);
		temp.add(new JLabel("Unknown"));
		left.add(temp);
		add(left);
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(11,1));
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.GREEN);
		temp.add(tempC);
		temp.add(new JLabel("Hydrogen"));
		right.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.ORANGE);
		temp.add(tempC);
		temp.add(new JLabel("Transitional Metal"));
		right.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.LIGHT_GRAY);
		temp.add(tempC);
		temp.add(new JLabel("Polyatomic Nonmetal"));
		right.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.GRAY);
		temp.add(tempC);
		temp.add(new JLabel("Lantanide Series"));
		right.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.YELLOW);
		temp.add(tempC);
		temp.add(new JLabel("Alkali Metals"));
		right.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.BLUE);
		temp.add(tempC);
		temp.add(new JLabel("Post Transition Metal"));
		right.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.WHITE);
		temp.add(tempC);
		temp.add(new JLabel("Diatomic Nonmetal"));
		right.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.DARK_GRAY);
		temp.add(tempC);
		temp.add(new JLabel("Actinide Series"));
		right.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.MAGENTA);
		temp.add(tempC);
		temp.add(new JLabel("Alkaline Earth Metals"));
		right.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.RED);
		temp.add(tempC);
		temp.add(new JLabel("Metalloid"));
		right.add(temp);
		temp = new JPanel();
		tempC = new JPanel();
		tempC.setBackground(Color.CYAN);
		temp.add(tempC);
		temp.add(new JLabel("Noble Gases"));
		right.add(temp);
		add(right);
		setSize(300,300);
		setVisible(true);
	   	BufferedImage atom = null;
	   	try {
	   		 atom = ImageIO.read(getClass().getResource("/img/atom.png"));
	   	} catch (IOException e) {
	   		// TODO Auto-generated catch block
	   		e.printStackTrace();
	   	}
	   	    	this.setIconImage(atom);
	   	    
		
	}
}
