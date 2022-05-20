import java.util.HashMap;

/**
 * [Room Class].
 * This class defines what a room is inside of the game. Each object created from this class will be its own individual existance.
 * However two rooms with the same name should not be created for it could cause some complications, since the names will be used by the player to distinguish each room.
 *
 * @author Gervais Pierre
 * @version v3.0
 */
public class Room
{
    //Attributes
    private String aName;
    private HashMap<String ,Room> aExits;
    private Inventory aInventory;
    private String aImageURL;
    
    
    //Constructors
    /**
     * Constructor used to create an instance (object) of a room.
     * @param String Name : The name by which the user will distinguish the room.
     * @param int RoomInventoryMaxVolume : The maximum limit in volume that the room's inventory can hold.
     * @param String ImageURL : The URL link associated to the room that will be displayed to the user.
     */
    public Room(final String pName, final int pRoomInventoryMaxVolume, final String pImageURL){
        this.aName = pName;
        this.aExits = new HashMap<String ,Room>();
        this.aInventory = new Inventory(pRoomInventoryMaxVolume);
        this.aImageURL = pImageURL;
    }
    
    
    //Set Functions
    /**
     * Used after creating all the rooms in order to assign room to room connections.
     * @param String Direction : Defines the direction of the exit. (Note : using an already existing direction "should" overwrite the previous one).
     * @param Room Room : The room the exit will connect to.
     */
    public void setExit(final String pDirection, final Room pRoom){
        this.getExits().put(pDirection, pRoom);
    }
    
    
    //Get Functions
    /**
     * Fetches the name of the room.
     * @return String Name : The name of the room in question.
     */
    public String getName(){
        return this.aName;
    }
    
    /**
     * Fetches the HashMap (keyed list) of all exits that the room has.
     * @return HashMap Exits : Keyed list of all exits that the room has.
     */
    private HashMap getExits(){
        return this.aExits;
    }
    
    /**
     * Fetches a specific exit based on the direction. (Note will return null if the direction does not exist).
     * @param String Direction : The key used to fetch a specific exit in the list.
     * @return Room ExitRoom : The room in which the specified exit will lead to.
     */
    public Room getExit(String pDirection){
        return this.aExits.get(pDirection);
    }
    
    /**
     * Fetches the room's inventory.
     * @return Inventory RoomInventory : The room's inventory.
     */
    public Inventory getInventory(){
        return this.aInventory;
    }
    
    /**
     * Fetches the room's associated image URL link.
     * @return String ImageURL : The rooms URL link to it's associated image.
     */
    public String getImageURL(){
        return this.aImageURL;
    }
}
