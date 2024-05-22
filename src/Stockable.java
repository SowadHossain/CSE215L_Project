import javax.naming.InsufficientResourcesException;

public interface Stockable {
    public void addStock(int num);
    public void removeStock(int num) throws InsufficientResourcesException, InsufficientStockException;
    public void editStock(int num);
}
