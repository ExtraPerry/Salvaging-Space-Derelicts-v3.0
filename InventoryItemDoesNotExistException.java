/**
 * This is an Exception class but with a Custom Name.
 * It is related to when the user removes an item from an inventory but the item does not exist inside the inventory.
 */
public class InventoryItemDoesNotExistException extends Exception
{
    public InventoryItemDoesNotExistException(String pErrorMessage){
        super(pErrorMessage);
    }
}
