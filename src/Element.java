//Matthew Hinton
//3/16/2017
//CS III H 6th
/**
 * Represents an Element and the information associated with it.
 * 
 */
public class Element {
    public static final String GAS = "Gas";
    public static final String LIQUID = "Liquid";
    public static final String SOLID = "Solid";
    public static final String SYNTHETIC = "Synthetic";
    public static final String ALKALI_METALS = "Alkali Metals";
    public static final String ALKALINE_EARTH_METALS = "Alkaline Earth Metals";
    public static final String TRANSITONAL_METALS = "Transitional Metals";
  //  public static final String OTHER_METALS = "other metals";
   // public static final String NONMETALS = "nonmetals";
    public static final String NOBLE_GASES = "Noble Gases";
    public static final String HYDROGEN = "Hydrogen";
    public static final String POLYATOMIC_NONMETAL = "Polyatomic Nonmetal";
    public static final String LANTANIDE_SERIES = "Lanthanide Series";
    public static final String POST_TRANSITION_METAL = "Post-Transition Metal";
    public static final String DIATOMIC_NONMETAL = "Diatomic Nonmetal";
    public static final String ACTINIDE = "Actinide Series";
    public static final String METALLOID = "Metalloid";
    public static final String UNKNOWN = "Unknown";
    
     
    private String name,symbol,electronConfiguration,type,state;
    private int atomicNumber,protons,neutrons;
    private double atomicMass;    

    /**
     * Creates an Element Object that stores data about the Element
     * @param name the name of the Element
     * @param symbol the symbol of the Element
     * @param electronConfiguration the Electron Configuration of the Element
     * @param type the type of the Element
     * @param protons the amount of protons of the Element
     * @param state the state of the Element
     */
	public Element(String name, String symbol, String electronConfiguration, 
				String type,int protons,String state) {
		this.name = name;
		this.symbol = symbol;
		this.electronConfiguration = electronConfiguration;
		this.type = type;
		this.atomicNumber = this.protons=this.neutrons=protons;
		if(protons==1)neutrons=0;
		this.atomicMass = protons+neutrons;
		this.state=state;
	}
	

	/**
	 * gets the name of the Element
	 * @return name the name of the Element
	 */
	public String getName() {
		return (this.name); 
	}
	/**
	 * gets the symbol of the Element
	 * @return symbol the Element's symbol
	 */
	public String getSymbol() {
		return (this.symbol); 
	}
	/**
	 * gets the Electron COnfiguration of the Element
	 * @return electron Configuration the configuration of the Electrons.
	 */
	public String getElectronConfiguration() {
		return (this.electronConfiguration); 
	}
	/**
	 * gets the type of the Element
	 * @return type the Element's type
	 */
	public String getType() {
		return (this.type); 
	}
	/**
	 * gets the protons of the ELement
	 * @return protons the protons 
	 */
	public int getProtons() {
		return (this.protons); 
	}
	/**
	 * gets the neutrons of the ELement
	 * @return neutrons the protons 
	 */
	public int getNeutrons()
	{
		return this.neutrons;
	}
	/**
	 * gets the state of the Element
	 * @return state the state of the Element
	 */
	public String getState() {
		return (this.state); 
	}
}
