import java.util.HashMap;

public class Room
{
    //Attributes
    private String aName;
    private HashMap<String ,Room> aExits;
    private Inventory aInventory;
    private String aDescription;
    
    public Room(final String pName, final int pRoomInventoryMaxVolume, final String pDescription){
        this.aName = pName;
        this.aExits = new HashMap<String ,Room>();
        this.aInventory = new Inventory(pRoomInventoryMaxVolume);
        this.aDescription = pDescription;
    }
}
