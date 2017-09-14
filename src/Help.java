//Matthew Hinton
//3/16/2017
//CS III H 6th
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * The help screen displayed by the Table. Used to explain the functionality.
 */
public class Help extends JFrame {
	/**
	 * Constructs the help GUI frame.
	 * 
	 */
	public Help()
	{
		setTitle("Help");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,1));
		panel.add(new JLabel("Welcome to the Periodic table of Elements. Within the GUI is general information making up our universe, this application ahs many functions that can be used."));
		panel.add(new JLabel("The Mouse serves mutiple functions. It can be used to mouse over the elements to display more information. By clicking the elements, a more detailed screen pops up."));
		panel.add(new JLabel("The keyboard can serve mutiple functions, pressing escape on the main screen exits the application. By typing the letters of the symbol, and pressing enter, the detailed screen will pop up. By pressing delete or backspace, the current entry is cleared."));
		panel.add(new JLabel("The Periodic Table uses colors to distinguish traits, the colors explained in the legend panel, accessible from the menu bar. Options can also be selected from the menu bar."));
		add(panel);
		setSize(1600,500);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
