//Matthew Hinton
//3/16/2017
//CS III H 6th
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * Constructs the the menu bar for the Periodic frame. Used to provide functionality.
 */
public class PeriodicMenu extends JMenuBar implements ItemListener, ActionListener{
	public static boolean stateColorB,typeColorB,disableTypingB;
	JMenu help,option,general;
	JMenuItem legend,helpI,exit;
	JCheckBoxMenuItem stateColor,typeColor,disableTyping;
	JFrame frame;
	/**
	 *Constructs the menu bar for the Periodic Table.
	 *@param frame the frame that creates it. 
	 */
	public PeriodicMenu(JFrame frame)
	{this.frame=frame;
		stateColorB=true;
				typeColorB=true;
						disableTypingB=true;
		general = new JMenu("General");
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		general.add(exit);
		legend = new JMenuItem("Legend");
		legend.addActionListener(this);
		general.add(legend);
		this.add(general);
		option = new JMenu("Options");
		stateColor = new JCheckBoxMenuItem("State Color");
		stateColor.setSelected(true);
		stateColor.addItemListener(this);
		option.add(stateColor);
		typeColor = new JCheckBoxMenuItem("Type Color");
		typeColor.setSelected(true);
		typeColor.addItemListener(this);
		option.add(typeColor);
		disableTyping = new JCheckBoxMenuItem("Disable Typing");
		disableTyping.setSelected(true);
		disableTyping.addItemListener(this);
		option.add(disableTyping);
		this.add(option);
		help = new JMenu("Help");
		helpI=new JMenuItem("Help");
		helpI.addActionListener(this);
		help.add(helpI);
		this.add(help);
	   	    
	}

	/**
	 * Tracks the button presses that occur in the menu bar.
	 * @param arg0 the action event that was triggered.
	 */
	public void actionPerformed(ActionEvent arg0) {
		JMenuItem mi = (JMenuItem)arg0.getSource();
		if(mi.getText().equals("Exit"))System.exit(0);
		if(mi.getText().equals("Legend"))new Legend();
		if(mi.getText().equals("Help"))new Help();
	}

	/**
	 * Tracks the check box presses that occur in the menu bar.
	 * @param arg0 the item event that was triggered.
	 */
	public void itemStateChanged(ItemEvent arg0) {
		JCheckBoxMenuItem checkbox = (JCheckBoxMenuItem)arg0.getSource();
		if(checkbox.getText().equals("State Color"))
		{
			stateColorB=checkbox.isSelected();
			
		}
		if(checkbox.getText().equals("Type Color"))
		{
			typeColorB=checkbox.isSelected();
		}
		if(checkbox.getText().equals("Disable Typing"))
		{
			disableTypingB=checkbox.isSelected();
		}
		for(ElementGUI e:((Periodic_Table)frame).getElementGUIS())if(e.getE()!=null)e.refresh();
		for(ElementGUI e:((Periodic_Table)frame).getCardGUIS())if(e.getE()!=null)e.refresh();
	}
}
