//Matthew Hinton
//3/16/2017
//CS III H 6th
 /*
 *
 * @author 
 * @version 1.00 2017/2/28
 */
 import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
/**
 *Creates JPanel to function within the periodic table.
 */
public class ElementGUI extends JPanel{
    
    Element e;
    JPanel top,bottom;
    JLabel symbol; 
    JLabel name;  
    Color c;
    /**
     * Creates a new instance of ElementGUI which displays the element in the Periodic table.
     */
    public ElementGUI(Element e) {
    	this.e=e;
    	if(e!=null)
    	{
    	setLayout(new BorderLayout());
    	symbol = new JLabel(e.getSymbol());
    	top= new JPanel();
    	top.setLayout(new BorderLayout());
    	top.add(new JLabel(""+e.getProtons()),BorderLayout.EAST);
    	top.setBackground(c);
    	//System.out.println(PeriodicMenu.stateColorB);
    	if(PeriodicMenu.typeColorB){
    	switch(e.getType())
    	{
    		case Element.HYDROGEN:c=(Color.GREEN);break;
   			case Element.TRANSITONAL_METALS:c=(Color.ORANGE);break;
    		case Element.POLYATOMIC_NONMETAL:c=(Color.LIGHT_GRAY);break;
    		case Element.LANTANIDE_SERIES:c=(Color.GRAY);break;
    		case Element.ALKALI_METALS:c=(Color.YELLOW);break;
    		case Element.POST_TRANSITION_METAL:c=(Color.BLUE);break;
    		case Element.DIATOMIC_NONMETAL:c=(Color.WHITE);break;
    		case Element.ACTINIDE:c=(Color.DARK_GRAY);break;
    		case Element.ALKALINE_EARTH_METALS:c=(Color.MAGENTA);break;
    		case Element.METALLOID:c=(Color.RED);break;
    		case Element.NOBLE_GASES:c=(Color.CYAN);break;
    	}}
    	else c= Color.WHITE;
    	symbol.setFont(new Font("Arial", Font.BOLD, 32));
    	if(PeriodicMenu.stateColorB){
    	switch(e.getState())
    	{
    	case "Gas":symbol.setForeground(Color.RED);break;
    	case "Liquid":symbol.setForeground(Color.BLUE);break;
    	case "Solid":symbol.setForeground(Color.BLACK);break;
    	case "Unknown":symbol.setForeground(Color.WHITE);break;
    	}}
    	else
    	symbol.setForeground(Color.BLACK);
    	add(top,BorderLayout.NORTH);
    	//add(new JLabel(e.getName()+"\n"+e.getAtomicMass()),BorderLayout.SOUTH);
    	//add(new JLabel(""),BorderLayout.WEST);
    	//JPanel center = new JPanel();
    	setBackground(c);
    	 bottom = new JPanel();
    	bottom.setBackground(c);
    	bottom.setLayout(new GridLayout(2,1));
    	name = new JLabel(""+e.getName());
    	name.setBackground(c);
    	name.setFont(new Font("Arial", Font.PLAIN, 10));
    	bottom.add(name);
    	bottom.add(new JLabel(""+(e.getProtons()+e.getNeutrons())));
    	//center.setLayout(new GridLayout(1,3));
    	//center.add(new JLabel());
    //	center.add(symbol);
    //	center.add(new JLabel());
    
    	add(new JLabel(),BorderLayout.EAST);
    	add(new JLabel("  "),BorderLayout.WEST);
    	add(bottom,BorderLayout.SOUTH);
    	add(symbol,BorderLayout.CENTER);
    	    	setBorder(BorderFactory.createLineBorder(Color.black));
    	}
    	this.setPreferredSize(new Dimension(40,50));
    	//setVisible(true);

    }
    /**
     * Gets the Element contained with the ElementGUI
     * @return e the element contained.
     */
    public Element getE()	
    {
    	return e;
    }
    /**
     * refreshes the screen when a boolean is detected to be changed.
     */
    public void refresh()
    {
    	if(PeriodicMenu.typeColorB){
        	switch(e.getType())
        	{
        		case Element.HYDROGEN:c=(Color.GREEN);break;
       			case Element.TRANSITONAL_METALS:c=(Color.ORANGE);break;
        		case Element.POLYATOMIC_NONMETAL:c=(Color.LIGHT_GRAY);break;
        		case Element.LANTANIDE_SERIES:c=(Color.GRAY);break;
        		case Element.ALKALI_METALS:c=(Color.YELLOW);break;
        		case Element.POST_TRANSITION_METAL:c=(Color.BLUE);break;
        		case Element.DIATOMIC_NONMETAL:c=(Color.WHITE);break;
        		case Element.ACTINIDE:c=(Color.DARK_GRAY);break;
        		case Element.ALKALINE_EARTH_METALS:c=(Color.MAGENTA);break;
        		case Element.METALLOID:c=(Color.RED);break;
        		case Element.NOBLE_GASES:c=(Color.CYAN);break;
        	}}
        	else c= Color.WHITE;
        	symbol.setFont(new Font("Arial", Font.BOLD, 32));
        	if(PeriodicMenu.stateColorB){
        	switch(e.getState())
        	{
        	case "Gas":symbol.setForeground(Color.RED);break;
        	case "Liquid":symbol.setForeground(Color.BLUE);break;
        	case "Solid":symbol.setForeground(Color.BLACK);break;
        	case "Unknown":symbol.setForeground(Color.WHITE);break;
        	}}
        	else
        	symbol.setForeground(Color.BLACK);
        	setBackground(c);
        	name.setBackground(c);	
        	bottom.setBackground(c);
    }
}
