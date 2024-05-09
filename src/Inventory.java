import java.util.ArrayList;

public class Inventory {
    private ArrayList<StockableProduct> arrayList;

    public Inventory(){

    }
    public void addItems(StockableProduct product){
        arrayList.add(product);
    }
    public void removeItem(int productID){
        for (int i = 0; i < arrayList.size(); i++)
        {
            //getProductid and remove from the list
            int id = 0;
            if(productID == id)
                arrayList.remove(i);

        }

    }
    public Product getItem(int productID){
        for (StockableProduct p : arrayList){
            int id = 0;
            //get id for the current item of the list
            if(productID == id){
                //decremetn the number of items stocked with romoveStock method
                return new Product();
            }
        }
        return null;
    }
    public void addProductStock(int productID, int numberOfNewStock){
        for (StockableProduct p : arrayList){
            int id = 0;
            //get id for the current item of the list
            if(productID == id){
                //add number of stocks
            }
        }
    }
    public void sortByPrice(){

    }
    public void sortByAvailableStock(){

    }



}
