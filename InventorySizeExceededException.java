/**
 * This is an Exception class but with a Custom Name.
 * It is related to when the user adds an item to an inventory but there is no more space available.
 * 
 * @author Gervais Pierre
 * @version v3.0
 */
public class InventorySizeExceededException extends Exception
{
    public InventorySizeExceededException(String pErrorMessage){
        super(pErrorMessage);
    }
}
