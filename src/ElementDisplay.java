//Matthew Hinton
//3/16/2017
//CS III H 6th
 import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

/**
 * The ElementDisplay that pops up when the Element is selected in the main.
 *
 */
public class ElementDisplay extends JFrame  implements ActionListener{

	
	JButton leftButton,rightButton;
	ArrayList<Element> elements;
	JPanel center;
	CardLayout centerC;
	int index;
	/**
	 * Creates an elementDisplay to be displayed in the separate frame.
	 * @param elementName the element's name.
	 */
    public ElementDisplay(String elementName) {
    	setLayout(new BorderLayout());
    
    	
    	leftButton = new JButton("<=");
    	rightButton = new JButton("=>");
    	JPanel bottom = new JPanel();
    	bottom.setLayout(new GridLayout(1,2));
    	bottom.add(leftButton);
    	bottom.add(rightButton);
    	leftButton.addActionListener(this);
    	rightButton.addActionListener(this);
    	add(bottom,BorderLayout.SOUTH);
    	center = new JPanel();
    	centerC = new CardLayout();
    
    //	System.out.println (e.getName());
    	center.setLayout(centerC);
    		addElements();
    	for(int i = 0;i<elements.size();i++)if(elements.get(i).getName().equals(elementName))index=i;
    	Element e = elements.get(index);
    	CardLayout cl = (CardLayout)(center.getLayout());
    	cl.show(center, e.getName());
    	add(center);
    	setSize(600,300);
    	setVisible(true);
       	BufferedImage atom = null;
       	try {
       		 atom = ImageIO.read(getClass().getResource("/img/atom.png"));
       	} catch (IOException io) {
       		// TODO Auto-generated catch block
       		io.printStackTrace();
       	}
       	    	this.setIconImage(atom);
       	    }
    	
    
    public void actionPerformed(ActionEvent a)
    {
    	JButton button = (JButton)a.getSource();
    	if(button.getText().equals("<="))index--;
    	else index++;
    	if(index==-1)index=elements.size()-1;
    	if(index==elements.size())index=0;
    	Element e = elements.get(index);
    	CardLayout cl = (CardLayout)(center.getLayout());
    	cl.show(center, e.getName());
    }
    public void addElements()
    {
    elements = new ArrayList<Element>();
   	  elements.add(Elements.HYDROGEN); 
 	elements.add(Elements.HELIUM); 
 	elements.add(Elements.LITHIUM); 
	elements.add(Elements.BERYLLIUM); 
	elements.add(Elements.BORON); 
	 elements.add(Elements.CARBON);
	 elements.add(Elements.NITROGEN); 
	elements.add(Elements.OXYGEN); 
	elements.add(Elements.FLOURINE); 
 	elements.add(Elements.NEON);
	elements.add(Elements.SODIUM);
	elements.add(Elements.MAGNESIUM); 
	 elements.add(Elements.ALUMINIUM); 
	elements.add(Elements.SILICON); 
	 elements.add(Elements.PHOSPHORUS); 
	elements.add(Elements.SULFUR); 
	elements.add(Elements.CHLORINE);
	elements.add(Elements.ARGON);
	elements.add(Elements.POTASSIUM);
	elements.add(Elements.CALCIUM);
	elements.add(Elements.SCANDIUM);
	elements.add(Elements.TITANIUM); 
	elements.add(Elements.VANADIUM); 
	elements.add(Elements.CHROMIUM); 
	elements.add(Elements.MANGANESE); 
	elements.add(Elements.IRON); 
	elements.add(Elements.COBALT); 
	elements.add(Elements.NICKEL);
	elements.add(Elements.COPPER);
	elements.add(Elements.ZINC);
	elements.add(Elements.GALLIUM);
	elements.add(Elements.GERMANIUM);
	elements.add(Elements.ARSENIC); 
	elements.add(Elements.SELENIUM);
	elements.add(Elements.BROMINE); 
	elements.add(Elements.KRYPTON); 
	elements.add(Elements.RUBIDIUM);
	elements.add(Elements.STRONTIUM);
	elements.add(Elements.YTTRIUM);
	elements.add(Elements.ZIRCONIUM);
	elements.add(Elements.NIOBIUM);
	elements.add(Elements.MOLYBDENUM);
	elements.add(Elements.TECHNETIUM);
	elements.add(Elements.RUTHENIUM);
	elements.add(Elements.RHODIUM);
	elements.add(Elements.PALLADIUM);
	elements.add(Elements.SILVER);
	elements.add(Elements.CADMIUM);
	elements.add(Elements.INDIUM);
	elements.add(Elements.TIN);
	elements.add(Elements.ANTIMONY);
	elements.add(Elements.TELLURIUM);
	elements.add(Elements.IODINE);
	elements.add(Elements.XENON);
	elements.add(Elements.CAESIUM);
	elements.add(Elements.BARIUM);
	elements.add(Elements.LANTHANUM);
	elements.add(Elements.CERIUM);
	elements.add(Elements.PRASEODYMIUM);
	elements.add(Elements.NEODYMIUM);
	elements.add(Elements.PROMETHIUM);
	elements.add(Elements.SAMARIUM);
	elements.add(Elements.EUROPIUM);
	elements.add(Elements.GADOLINIUM);
	elements.add(Elements.TERBIUM);
	elements.add(Elements.DYSPROSIUM);
	elements.add(Elements.HOLMIUM);
	elements.add(Elements.ERBIUM);
	elements.add(Elements.THULIUM);
	elements.add(Elements.YTTERBIUM);
	elements.add(Elements.LUTETIUM);
	
	elements.add(Elements.HAFNIUM);
	elements.add(Elements.TANTALUM);
	elements.add(Elements.TUNGSTEN);
	elements.add(Elements.RHENIUM);
	elements.add(Elements.OSMIUM);
	elements.add(Elements.IRIDIUM);
	elements.add(Elements.PLATINUM);
	elements.add(Elements.GOLD);
	elements.add(Elements.MERCURY);
	elements.add(Elements.THALLIUM);
	elements.add(Elements.LEAD);
	elements.add(Elements.BISMUTH);
	elements.add(Elements.POLONIUM);
	elements.add(Elements.ASTATINE);
	elements.add(Elements.RADON);

	elements.add(Elements.FRANCIUM);
	elements.add(Elements.RADIUM);
	elements.add(Elements.ACTINIUM);
	elements.add(Elements.THORIUM);
	elements.add(Elements.PROTRACTINIUM);
	elements.add(Elements.URANIUM);
	elements.add(Elements.NEPTUNIUM);
	elements.add(Elements.PLUTOIUM);
	elements.add(Elements.AMERICIUM);
	elements.add(Elements.CURIUM);
	elements.add(Elements.BERKELIUM);
	elements.add(Elements.CALIFORNIUM);
	elements.add(Elements.EINSTEINIUM);
	elements.add(Elements.FERMIUM);
	elements.add(Elements.MENDELEVIUM);
	elements.add(Elements.NOBELIUM);
	elements.add(Elements.LAWRENCIUM);
	
	elements.add(Elements.RUTHERFORDIUM);
	elements.add(Elements.DUBNIUM);
	elements.add(Elements.SEABORGIUM);
	elements.add(Elements.BOHRIUM);
	elements.add(Elements.HASSIUM);
	elements.add(Elements.MEITNERIUM);
	elements.add(Elements.DARMSTADTIUM);
	elements.add(Elements.ROENTGENIUM);
	elements.add(Elements.COPERNICIUM);
	elements.add(Elements.NIHONIUM);
	elements.add(Elements.FLEROVIUM);
	elements.add(Elements.MOSCOVIUM);
	elements.add(Elements.LIVERMORIUM);
	elements.add(Elements.TENNESSINE);
	elements.add(Elements.OGANESSON);
	for(Element e:elements)
	{
		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,2));
		panel.add(new JLabel(e.getName()));
		panel.add(new JLabel(e.getSymbol()));
		panel.add(new JLabel(e.getType()));
		panel.add(new JLabel(e.getState()));
		panel.add(new JLabel("Atomic Number: "+e.getProtons()));
		panel.add(new JLabel("Protons: "+e.getProtons()));
		panel.add(new JLabel("Neutrons: "+e.getNeutrons()));
		panel.add(new JLabel("Atomic Mass: "+e.getProtons()+e.getNeutrons()));
		outerPanel.add(new JLabel(e.getElectronConfiguration()),BorderLayout.SOUTH);
		outerPanel.add(panel);
		center.add(outerPanel,e.getName());
	}
    }
    
    
}