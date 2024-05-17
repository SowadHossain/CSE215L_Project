import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.ToDoubleFunction;

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
            int id = Integer.parseInt(arrayList.get(i).getProductId());
            if(productID == id) {
                arrayList.remove(i);
            }
        }
    }
    public Product getItem(int productID){
        for (StockableProduct p : arrayList){
            int id = Integer.parseInt(p.getProductId());
            if(productID == id){
                p.removeStock(1);
                return p;
            }
        }
        return null;
    }
    public void addProductStock(int productID, int numberOfNewStock){
        for (StockableProduct p : arrayList){
            int id = Integer.parseInt(p.getProductId());
            if(productID == id){
                p.addStock(numberOfNewStock);
            }
        }
    }

    //    public class CustomComparator implements Comparator<StockableProduct> {
//        @Override
//        public int compare(StockableProduct o1, StockableProduct o2) {
//            return o1.getPrice().comparingDouble(o2.getPrice());
//        }
//    }
    public void sortByPrice(){
        //Collection.sort(arrayList,Comparator.comparingDouble(StockableProduct::getPrice));
        //arrayList.sort((a,b) -> a.getPrice().compare(b.getPrice()));
        //using bubble sort
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if(arrayList.get(j).getPrice() > arrayList.get(j+1).getPrice()){
                    StockableProduct temp = arrayList.get(j);
                    arrayList.set(j,arrayList.get(j+1));
                    arrayList.set(j+1,temp);
                }

            }
        }
    }
    public void sortByAvailableStock(){
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if(arrayList.get(j).getNumberOfItemsInStock() < arrayList.get(j+1).getNumberOfItemsInStock()){
                    StockableProduct temp = arrayList.get(j);
                    arrayList.set(j,arrayList.get(j+1));
                    arrayList.set(j+1,temp);
                }
            }
        }

    }



}
