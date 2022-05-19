/**
 * [Item Class].
 * This class defines what an item is inside of the game. Each object created from this class will be its own individual existance.
 * However two items with the same name should not be created for it could cause some complications, since the player will refer to all items by their names.
 * 
 * @author Gervais Pierre
 * @version v3.0
 */
public class Item
{
    //Attributes
    private String aName;           //Name of the item.
    private int aPrice;             //Price of the item.
    private int aVolume;            //Volume of the item.
    private String aDescription;    //Description of the item.
    
    
    //Constructors
    /**
     * Constructor used to create an instance (object) of an item.
     * @param String Name : Name that the item will have.
     * @param int Price : Price that the item will have.
     * @param int Volume : Amount of volume the item will have.
     * @param String Description : A short description for the item to help understand what it is or it's potential use.
     */
    public Item(final String pName, final int pPrice, final int pVolume, final String pDescription){
        this.aName = pName;
        this.aPrice = pPrice;
        this.aVolume = pVolume;
        this.aDescription = pDescription;
    }   //Item()
    
    
    //Get Functions
    /**
     * Fetches the name of the item.
     * @return String Name : The name by which the item is called and refered to.
     */
    public String getName(){
        return this.aName;
    }   //getName()
    
    /**
     * Fetches the price of the item.
     * @return int Price : The value of the item that will be defined in credits.
     */
    public int getPrice(){
        return this.aPrice;
    }   //getPrice()
    
    /**
     * Fetches the volume of the item.
     * @return int Volume : The amount of space defined in Liters [L] that the item will take up in the inventory. (Note : Not all inventories have limited Space).
     */
    public int getVolume(){
        return this.aVolume;
    }   //getVolume()
    
    /**
     * Fetches the description of the item.
     * @return String Description : A short peice of text used to describe the item and its potential uses.
     */
    public String getDescription(){
        return this.aDescription;
    }   //getDescription()
    
    
    //Override Functions
    /**
     * Used to produce a String in which all information of the item will be displayed on.
     * @return String LongDescription : A peice of text used to describe all aspects of the item. This will include its Description, Price and Volume.
     */
    @Override public String toString(){
        int vPrice = this.getPrice();
        String vOutput = "Name : " + this.getName() + "\n" + "Price : " + vPrice + " credit";
        if (vPrice != 1){
            vOutput += "s";
        }
        vOutput += "\n" + "Volume : " + this.getVolume() + " L." + "\n" + "Description : " + this.getDescription();
        return vOutput;
    }   //toString()
}   