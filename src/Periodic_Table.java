//Matthew Hinton
//3/16/2017
//CS III H 6th


import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.font.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
/**
 * The Periodic table class is the main frame and displays the table. The table can transfer be between a legend, help, and indiviudal data. 
 */
public class Periodic_Table extends JFrame implements MouseListener, KeyListener {


    JPanel elements,bottomDisplay,topDisplay;
      ElementDisplay display;  
      String selection;
      ArrayList<ElementGUI> elementsGUI,cardGUIS;
      ArrayList<Element> elementsE;
      JTextField field;
      Clip clip;
    /**
     * Creates a new instance the periodic table and constructs the base frame.
     */
    public Periodic_Table() {
    	this.setJMenuBar(new PeriodicMenu(this));
    	display = null;
    	selection="";
    	setLayout(new BorderLayout());
    //	bottomDisplay.add((new JLabel("Hello")));
    	elements = new JPanel();
    	elements.setLayout(new GridLayout(7,32));
    	//elements.setPreferredSize(new Dimension(1874,730));
    	//for(int i = 0;i<(32*7);i++)elements.add(new ElementGUI(Elements.HYDROGEN));
    	bottomDisplay = new JPanel();
    	    	bottomDisplay.setPreferredSize(new Dimension(1874,100));
    	bottomDisplay.setLayout(new CardLayout());
    	bottomDisplay.add(new JPanel(),"blank");
    	topDisplay = new JPanel();
    	topDisplay.setLayout(new GridLayout(1,2));
    	JLabel title = new JLabel("Periodic Table");
    	title.setFont(new Font("Arial",Font.BOLD,64));
    	topDisplay.add(title);
    	field= new JTextField();
    	field.setOpaque(false);
    	field.setFont(new Font("Arial",Font.BOLD,26));
    	field.setText("Entry:" + selection);
    	 field.setEditable(false);
    	 topDisplay.addKeyListener(this);
    	topDisplay.add(field);
    	topDisplay.setPreferredSize(new Dimension(1874,100));
    	add(topDisplay,BorderLayout.NORTH);
   		CardLayout cl = (CardLayout)(bottomDisplay.getLayout());
    	cl.show(bottomDisplay, "blank");
    	add(bottomDisplay,BorderLayout.SOUTH);
 		createElements();
    	add(elements);
    	//this.pack();
    	addMouseListener(this);
    	addKeyListener(this);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(1874,770);
    	setVisible(true);
    	this.requestFocusInWindow();
    	this.setFocusable(true);
    	BufferedImage atom = null;
    	   try {
    	          Clip clip = AudioSystem.getClip();
    	          AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/img/click.wav"));
    	          clip.open(inputStream);
    	          clip.start(); 
    	        } catch (Exception e) {
    	          System.err.println(e.getMessage());}
try {
	 atom = ImageIO.read(getClass().getResource("/img/atom.png"));
} catch (IOException io) {
	// TODO Auto-generated catch block
	io.printStackTrace();
}
    	this.setIconImage(atom);
    }
    
    /**
     * Runs the program.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Periodic_Table();
    }
    /**
     * 
     * Returns an Arraylist of the ElementGUI objects contained within the periodic table.
     * @return
     */
    public ArrayList<ElementGUI> getElementGUIS()
    {
    	return elementsGUI;
    }
    /**
     * 
     * Returns an Arraylist of the ElementGUI objects contained within the Card Layout.
     * @return cardGUIS the guis in the card layout.
     */
    public ArrayList<ElementGUI> getCardGUIS()
    {
    	return cardGUIS;
    }

   // Do-nothing methods that are part of the MouseListener Interface
   public void mouseReleased(MouseEvent event) {}
   public void mousePressed(MouseEvent event){}
   /**
    * listen for the mouse clicking on the elementGUIS. Causes an ElementDisplay to be created.
    * @param event the click event
    * 
    */
   public void mouseClicked(MouseEvent event) {
   	Component c =event.getComponent();
   if(c instanceof ElementGUI ){
   
   ElementGUI e = (ElementGUI)c;
   	if(e.getE()!=null)
   	{if(display!=null)display.dispose();    	 	
	display=new ElementDisplay(e.getE().getName());
   	}
   }
   	
   	
   	}
   /**
    * listens for the mouse entering the ELementGUIs. Switches the bottom frame to the element moused over.
    * @param event the click event
    */
   public void mouseEntered(MouseEvent event) {
   Component c =event.getComponent();
   if(c instanceof ElementGUI ){
   
   ElementGUI e = (ElementGUI)c;
   	if(e.getE()!=null)
   	{    	 	  	   try {
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/sound/click.wav"));
        clip.open(inputStream);
        clip.start(); 
      } catch (Exception io) {
        System.err.println(io.getMessage());}
   		//	bottomDisplay.removeAll();
   	//	bottomDisplay.setPreferredSize(new Dimension(1874,100));
    //	bottomDisplay.setLayout(new GridLayout(1,5));
   		
   		//System.out.println (e.getE().getName());  
   		//e.refresh();
   		CardLayout cl = (CardLayout)(bottomDisplay.getLayout());
    	cl.show(bottomDisplay, e.getE().getName());
   	}
   }
   	}
   /**
    * listens for the mouse exiting the ElementGUIs, and sets the bottom display to blank.
    * @param event the mouse clicking event.
    * 
    */
   public void mouseExited(MouseEvent event) {
	   
  		CardLayout cl = (CardLayout)(bottomDisplay.getLayout());
   	cl.show(bottomDisplay, "blank");
   }
   
   public void keyPressed(KeyEvent k){}
   /**
    *Tracks when the key on the keyboard is released and provides  functionality based on click.
    *@param k the keypressed
    *
    */
   public void keyReleased(KeyEvent k){
	  // System.out.println("hello");
	   char c = k.getKeyChar();
	   if(Character.isAlphabetic(c)&&PeriodicMenu.disableTypingB)selection+=c+"";
	   if(k.getKeyCode()==KeyEvent.VK_BACK_SPACE)selection="";
	   if(k.getKeyCode()==KeyEvent.VK_ENTER)
	   {
		   boolean correct = false;
		   Element ee = null;
		  // System.out.println(selection);
		   for(Element e:elementsE){if(e.getSymbol().equalsIgnoreCase(selection)){correct=true;ee=e;}}
		   if(correct)
		   {
			   if(display!=null)display.dispose();    	 	
				display=new ElementDisplay(ee.getName());
				selection="";
		   }
		   else
		   {
			   selection="";
		   }
	   }
	   if(k.getKeyCode()==KeyEvent.VK_ESCAPE)System.exit(0);
	   field.setText("Entry:" + selection);
   }
   public void keyTyped(KeyEvent k){}
   
   /**
    * Fills the frame with Elements.
    */
    
   public void createElements()
   {
   		//elements.addMouseListener(this);
   		 elementsGUI = new ArrayList<ElementGUI>();
   		cardGUIS = new ArrayList<ElementGUI>();
   		elementsE = new ArrayList<Element>();
   	  	elementsGUI.add(new ElementGUI(Elements.HYDROGEN)); 
   	  	for(int i = 0;i<30;i++)elementsGUI.add(new ElementGUI(null));
 		elementsGUI.add(new ElementGUI(Elements.HELIUM)); 
 		elementsGUI.add(new ElementGUI(Elements.LITHIUM)); 
		elementsGUI.add(new ElementGUI(Elements.BERYLLIUM)); 
		for(int i = 0;i<24;i++)elementsGUI.add(new ElementGUI(null));
		elementsGUI.add(new ElementGUI(Elements.BORON)); 
	 	elementsGUI.add(new ElementGUI(Elements.CARBON));
	 	elementsGUI.add(new ElementGUI(Elements.NITROGEN)); 
		elementsGUI.add(new ElementGUI(Elements.OXYGEN)); 
		elementsGUI.add(new ElementGUI(Elements.FLOURINE)); 
 		elementsGUI.add(new ElementGUI(Elements.NEON));
		elementsGUI.add(new ElementGUI(Elements.SODIUM));
		elementsGUI.add(new ElementGUI(Elements.MAGNESIUM)); 
			 		for(int i = 0;i<24;i++)elementsGUI.add(new ElementGUI(null)); 	
	 	elementsGUI.add(new ElementGUI(Elements.ALUMINIUM)); 
		elementsGUI.add(new ElementGUI(Elements.SILICON)); 
	 	elementsGUI.add(new ElementGUI(Elements.PHOSPHORUS)); 
		elementsGUI.add(new ElementGUI(Elements.SULFUR)); 
		elementsGUI.add(new ElementGUI(Elements.CHLORINE));
		elementsGUI.add(new ElementGUI(Elements.ARGON));
		elementsGUI.add(new ElementGUI(Elements.POTASSIUM));
	elementsGUI.add(new ElementGUI(Elements.CALCIUM));
	elementsGUI.add(new ElementGUI(Elements.SCANDIUM));
	for(int i = 0;i<(14);i++)elementsGUI.add(new ElementGUI(null));
	elementsGUI.add(new ElementGUI(Elements.TITANIUM)); 
	elementsGUI.add(new ElementGUI(Elements.VANADIUM)); 
	elementsGUI.add(new ElementGUI(Elements.CHROMIUM)); 
	elementsGUI.add(new ElementGUI(Elements.MANGANESE)); 
	elementsGUI.add(new ElementGUI(Elements.IRON)); 
	elementsGUI.add(new ElementGUI(Elements.COBALT)); 
	elementsGUI.add(new ElementGUI(Elements.NICKEL));
	elementsGUI.add(new ElementGUI(Elements.COPPER));
	elementsGUI.add(new ElementGUI(Elements.ZINC));
	elementsGUI.add(new ElementGUI(Elements.GALLIUM));
	elementsGUI.add(new ElementGUI(Elements.GERMANIUM));
	elementsGUI.add(new ElementGUI(Elements.ARSENIC)); 
	elementsGUI.add(new ElementGUI(Elements.SELENIUM));
	elementsGUI.add(new ElementGUI(Elements.BROMINE)); 
	elementsGUI.add(new ElementGUI(Elements.KRYPTON)); 
	elementsGUI.add(new ElementGUI(Elements.RUBIDIUM));
	elementsGUI.add(new ElementGUI(Elements.STRONTIUM));
	elementsGUI.add(new ElementGUI(Elements.YTTRIUM));
	for(int i = 0;i<(14);i++)elementsGUI.add(new ElementGUI(null));
	elementsGUI.add(new ElementGUI(Elements.ZIRCONIUM));
	elementsGUI.add(new ElementGUI(Elements.NIOBIUM));
	elementsGUI.add(new ElementGUI(Elements.MOLYBDENUM));
	elementsGUI.add(new ElementGUI(Elements.TECHNETIUM));
	elementsGUI.add(new ElementGUI(Elements.RUTHENIUM));
	elementsGUI.add(new ElementGUI(Elements.RHODIUM));
	elementsGUI.add(new ElementGUI(Elements.PALLADIUM));
	elementsGUI.add(new ElementGUI(Elements.SILVER));
	elementsGUI.add(new ElementGUI(Elements.CADMIUM));
	elementsGUI.add(new ElementGUI(Elements.INDIUM));
	elementsGUI.add(new ElementGUI(Elements.TIN));
	elementsGUI.add(new ElementGUI(Elements.ANTIMONY));
	elementsGUI.add(new ElementGUI(Elements.TELLURIUM));
	elementsGUI.add(new ElementGUI(Elements.IODINE));
	elementsGUI.add(new ElementGUI(Elements.XENON));
	elementsGUI.add(new ElementGUI(Elements.CAESIUM));
	elementsGUI.add(new ElementGUI(Elements.BARIUM));
	elementsGUI.add(new ElementGUI(Elements.LANTHANUM));
	elementsGUI.add(new ElementGUI(Elements.CERIUM));
	elementsGUI.add(new ElementGUI(Elements.PRASEODYMIUM));
	elementsGUI.add(new ElementGUI(Elements.NEODYMIUM));
	elementsGUI.add(new ElementGUI(Elements.PROMETHIUM));
	elementsGUI.add(new ElementGUI(Elements.SAMARIUM));
	elementsGUI.add(new ElementGUI(Elements.EUROPIUM));
	elementsGUI.add(new ElementGUI(Elements.GADOLINIUM));
	elementsGUI.add(new ElementGUI(Elements.TERBIUM));
	elementsGUI.add(new ElementGUI(Elements.DYSPROSIUM));
	elementsGUI.add(new ElementGUI(Elements.HOLMIUM));
	elementsGUI.add(new ElementGUI(Elements.ERBIUM));
	elementsGUI.add(new ElementGUI(Elements.THULIUM));
	elementsGUI.add(new ElementGUI(Elements.YTTERBIUM));
	elementsGUI.add(new ElementGUI(Elements.LUTETIUM));
	
	elementsGUI.add(new ElementGUI(Elements.HAFNIUM));
	elementsGUI.add(new ElementGUI(Elements.TANTALUM));
	elementsGUI.add(new ElementGUI(Elements.TUNGSTEN));
	elementsGUI.add(new ElementGUI(Elements.RHENIUM));
	elementsGUI.add(new ElementGUI(Elements.OSMIUM));
	elementsGUI.add(new ElementGUI(Elements.IRIDIUM));
	elementsGUI.add(new ElementGUI(Elements.PLATINUM));
	elementsGUI.add(new ElementGUI(Elements.GOLD));
	elementsGUI.add(new ElementGUI(Elements.MERCURY));
	elementsGUI.add(new ElementGUI(Elements.THALLIUM));
	elementsGUI.add(new ElementGUI(Elements.LEAD));
	elementsGUI.add(new ElementGUI(Elements.BISMUTH));
	elementsGUI.add(new ElementGUI(Elements.POLONIUM));
	elementsGUI.add(new ElementGUI(Elements.ASTATINE));
	elementsGUI.add(new ElementGUI(Elements.RADON));

	elementsGUI.add(new ElementGUI(Elements.FRANCIUM));
	elementsGUI.add(new ElementGUI(Elements.RADIUM));
	elementsGUI.add(new ElementGUI(Elements.ACTINIUM));
	elementsGUI.add(new ElementGUI(Elements.THORIUM));
	elementsGUI.add(new ElementGUI(Elements.PROTRACTINIUM));
	elementsGUI.add(new ElementGUI(Elements.URANIUM));
	elementsGUI.add(new ElementGUI(Elements.NEPTUNIUM));
	elementsGUI.add(new ElementGUI(Elements.PLUTOIUM));
	elementsGUI.add(new ElementGUI(Elements.AMERICIUM));
	elementsGUI.add(new ElementGUI(Elements.CURIUM));
	elementsGUI.add(new ElementGUI(Elements.BERKELIUM));
	elementsGUI.add(new ElementGUI(Elements.CALIFORNIUM));
	elementsGUI.add(new ElementGUI(Elements.EINSTEINIUM));
	elementsGUI.add(new ElementGUI(Elements.FERMIUM));
	elementsGUI.add(new ElementGUI(Elements.MENDELEVIUM));
	elementsGUI.add(new ElementGUI(Elements.NOBELIUM));
	elementsGUI.add(new ElementGUI(Elements.LAWRENCIUM));
	
	elementsGUI.add(new ElementGUI(Elements.RUTHERFORDIUM));
	elementsGUI.add(new ElementGUI(Elements.DUBNIUM));
	elementsGUI.add(new ElementGUI(Elements.SEABORGIUM));
	elementsGUI.add(new ElementGUI(Elements.BOHRIUM));
	elementsGUI.add(new ElementGUI(Elements.HASSIUM));
	elementsGUI.add(new ElementGUI(Elements.MEITNERIUM));
	elementsGUI.add(new ElementGUI(Elements.DARMSTADTIUM));
	elementsGUI.add(new ElementGUI(Elements.ROENTGENIUM));
	elementsGUI.add(new ElementGUI(Elements.COPERNICIUM));
	elementsGUI.add(new ElementGUI(Elements.NIHONIUM));
	elementsGUI.add(new ElementGUI(Elements.FLEROVIUM));
	elementsGUI.add(new ElementGUI(Elements.MOSCOVIUM));
	elementsGUI.add(new ElementGUI(Elements.LIVERMORIUM));
	elementsGUI.add(new ElementGUI(Elements.TENNESSINE));
	elementsGUI.add(new ElementGUI(Elements.OGANESSON));
		for(ElementGUI e:elementsGUI )
		{
			e.addMouseListener(this);
			elements.add(e);
			if(e.getE()!=null)elementsE.add(e.getE());
			if(e.getE()!=null)
			{
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(1,5));
			ElementGUI temp = new ElementGUI(e.getE());
			cardGUIS.add(temp);
			p.add(temp);
			p.add(new JLabel(e.getE().getName()));
   			p.add(new JLabel(e.getE().getProtons()+""));
   			p.add(new JLabel(e.getE().getElectronConfiguration()));
   			p.add(new JLabel(e.getE().getType()));
   			p.getComponent(1).setFont(new Font("Arial", Font.PLAIN, 20));
   			p.getComponent(2).setFont(new Font("Arial", Font.PLAIN, 20));
   			p.getComponent(3).setFont(new Font("Arial", Font.PLAIN, 14));
   			p.getComponent(4).setFont(new Font("Arial", Font.PLAIN, 20));
   			bottomDisplay.add(p,e.getE().getName());
			}	
		}
		
		

   }	
}
