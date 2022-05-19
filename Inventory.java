import java.util.ArrayList;

/**
 * [Inventory Class].
 * This class defines what an inventory is inside of the game. Each object created from this class will be its own individual existance.
 * This class should be implemented as an attribute inside of another class that would require an inventory in which it can store items.
 *
 * @author Gervais Pierre
 * @version v3.0
 */
public class Inventory
{
    //Attributes
    private ArrayList<Item> aItemList;  //List of all items inside of the inventory.
    private int aTotalPrice;            //Total price of all items inside of the inventory.
    private int aTotalVolume;           //Total volume of all items inside of the inventory.
    private int aMaxVolume;             //Max volume the inventory can hold.
    
    
    //Constructors
    /**
     * Constructor used to create an instance (object) of an inventory.
     * @param int MaxVolume : Volume limit for the inventory.
     */
    public Inventory(final int pMaxVolume){
        this.aItemList = new ArrayList<Item>();
        this.setTotalPrice(0);
        this.setTotalVolume(0);
        this.setMaxVolume(pMaxVolume);
    }   //Inventory()
    
    //Set Functions
    /**
     * Private functions used to change the inventory's total price.
     * @param int TotalPrice : Total price of all current items being stored inside of the inventory.
     */
    private void setTotalPrice(final int pTotalPrice){
        this.aTotalPrice = pTotalPrice;
    }   //setTotalPrice()
    
    /**
     * Private functions used to change the inventory's total price.
     * @param int TotalVolume : Total space of all current items being stored inside of the inventory.
     */
    private void setTotalVolume(final int pTotalVolume){
        this.aTotalVolume = pTotalVolume;
    }   //setTotalVolume()
    
    /**
     * Private functions used to change the inventory's max volume.
     * @param int MaxVolume : Volume limit for the inventory.
     */
    private void setMaxVolume(final int pMaxVolume){
        this.aMaxVolume = pMaxVolume;
    }   //setMaxVolume()
    
    //Get Functions
    /**
     * Fetches an item that is stored inside of the inventory. (Note if there is no matching item it'll return a null value).
     * @param String ItemName : The name of the item that you are looking for inside of the inventory.
     * @return Item Item || null : The item object that you are looking for that had a matching name with the inserted parameter. Will return null if no match is found.
     */
    public Item getItem(final String pItemName){
        for (Item vElement : this.aItemList){
            if(vElement.getName().toLowerCase().equals(pItemName.toLowerCase())){
                return vElement;
            }
        }
        return null;
    }   //getItem()
    
    /**
     * Fetches the total price of all items currently stored inside of the inventory.
     * @return Int TotalPrice : Total price of all items stored inside the inventory.
     */
    public int getTotalPrice(){
        return this.aTotalPrice;
    }   //getTotalPrice()
    
    /**
     * Fetches the total volume of all items currently stored inside of the inventory.
     * @return Int TotalVolume : Total volume of all items stored inside the inventory.
     */
    public int getTotalVolume(){
        return this.aTotalVolume;
    }   //getTotalVolume()
    
    /**
     * Fetches the max volume of all items currently stored inside of the inventory.
     * @return Int MaxVolume : Volume limit of the inventory.
     */
    private int getMaxVolume(){
        return this.aMaxVolume;
    }   //getMaxVolume()
    
    
    //Custom Functions
    /**
     * Used to check if an item is inside the inventory by name.
     * @return boolean : True if the item is inside of the inventory. False if the item is not inside of the inventory.
     */
    private boolean hasItem(final String pItemName){
        return this.getItem(pItemName) != null;
    }   //hasItem()
    
    /**
     * Used to check if an item can fit inside the inventory.
     * @return boolean : True if the item can fit inside the inventory. False if the item cannot fit inside the inventory.
     */
    private boolean hasEnoughSpace(final Item pItem){
        return this.getMaxVolume() >= this.getTotalVolume() + pItem.getVolume();
    }
    
    /**
     * Used to add an item to the inventory. (Note : will also update total price and volume).
     * @param Item Item : Item that should be added to the inventory.
     * @throw InventorySizeExceededException : Thrown if item cannot fit inside the inventory.
     */
    public void addItem(final Item pItem) throws InventorySizeExceededException{
        if(this.hasEnoughSpace(pItem)){
            this.aItemList.add(pItem);
            this.setTotalPrice(this.getTotalPrice() + pItem.getPrice());
            this.setTotalVolume(this.getTotalVolume() + pItem.getVolume());
        }else{
            throw new InventorySizeExceededException("Not enough space in Inventory to add stated Item : " + pItem.getName() + ".");
        }
    }   //addItem()
    
    /**
     * Used to remove an item from the inventory. (Note : will also update total price and volume).
     * @param Item Item : Item that should be removed from the inventory.
     * @throw InventoryItemDoesNotExistException : Thrown if item does not exist inside inventory and thus cannot be removed.
     */
    public void removeItem(final Item pItem) throws InventoryItemDoesNotExistException{
        if(this.hasItem(pItem.getName())){
            this.setTotalPrice(this.getTotalPrice() - pItem.getPrice());
            this.setTotalVolume(this.getTotalVolume() - pItem.getVolume());
            this.aItemList.remove(pItem);
        }else{
            throw new InventoryItemDoesNotExistException("Stated Item : \"" + pItem.getName() + "\" does not exist inside inventory. Thus cannot be removed.");
        }
    }   //removeItem()
    
    /**
     * Used to give a list of all items inside of the inventory.
     * @return String ItemList : A list in the form of a string listing all items inside the inventory as well as their price and volume.
     */
    public String getInventoryItemList(){
        String vOutput = "";
        for (Item vElement : this.aItemList){
            if (vOutput != ""){
                vOutput += "\n";
            }
            int vPrice = vElement.getPrice();
            vOutput += "- " + vElement.getName() + ", " + vPrice + " credit";
            if (vPrice != 1){
                vOutput += "s";
            }
            vOutput += ", " + vElement.getVolume() + " L.";
        }
        return vOutput;
    }   //getInventoryItemList()
    
    
    //Override Functions
    /**
     * Used to produce a String in which all information of the inventory will be displayed on.
     * @return String LongDescription : A peice of text used to describe all aspects of the inventory. This will include its Total Price, Total Volume and list of all items currently stored inside of it.
     */
    @Override public String toString(){
        int vTotalPrice = this.getTotalPrice();
        String vOutput = "Total Price : " + vTotalPrice + " credit";
        if (vTotalPrice != 1){
            vOutput += "s";
        }
        vOutput += "." + "\n" + "Total Volume : " + this.getTotalVolume() + " L." + "\n" + "Max Volume : " + this.getMaxVolume() + "\n";
        if (this.aItemList.size() > 1){
            vOutput += "Item : " +  this.getInventoryItemList().substring(2) + ".";
        }else{
            vOutput += "\n" + "All Items :" + "\n" + this.getInventoryItemList();
        }
        return vOutput;
    }
}
