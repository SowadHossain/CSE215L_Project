package project;

	import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.Iterator;
	import java.util.Iterator; // Must

	public class Inventory implements Iterable<StockableProduct>{
	    private ArrayList<StockableProduct> items = new ArrayList<StockableProduct>();

	    
	    public Inventory() {}
	    
	 // Implementing Iterator
	        
	    public Inventory(ArrayList<StockableProduct> items){
	        this.items = items;
	    }
	   
	    public Iterator<StockableProduct> iterator() {
	        return this.items.iterator();
	    } 

		public void addItems(StockableProduct product){
	        items.add(product);
	    }
	    public void removeItem(int productID){
	        for (int i = 0; i < items.size(); i++)
	        {
	            int id = items.get(i).getProductId();
	            if(productID == id) {
	                items.remove(i);
	            }
	        }
	    }
	    public Product getItem(int productID){
	    	Product product = null;                 // new
	        for (StockableProduct p : items){
	            int id = p.getProductId();
	            if(productID == id){
	                try {
	                    p.removeStock(1);
	                }catch (Exception e){
	                    e.printStackTrace();
	                }
	                return p;
	            }
	        }
	        return null;
	    }
	    public void addProductStock(int productID, int numberOfNewStock){
	        for (StockableProduct p : items){
	            int id = p.getProductId();
	            if(productID == id){
	                p.addStock(numberOfNewStock);
	            }
	        }
	    }


	    public void sortByPrice(){ /////// changed
	    	
	    	
	    	
	    	for (int i = 0; i < items.size() - 1; i++) {
	            for (int j = i + 1; j < items.size(); j++) {
	                if (items.get(i).getPrice() > items.get(j).getPrice()) {
	                    Product temp = items.get(i);
	                    items.set(i, items.get(j));
	                    items.set(j, (StockableProduct) temp);
	                }
	            }
	        } 		    	
	    }
	    
	    
	    public void sortByAvailableStock(){
	        for (int i = 0; i < items.size(); i++) {
	            for (int j = 0; j < items.size(); j++) {
	                if(items.get(j).getNumberOfItemsInStock() < items.get(j+1).getNumberOfItemsInStock()){
	                    StockableProduct temp = items.get(j);
	                    items.set(j,items.get(j+1));
	                    items.set(j+1,temp);
	                }
	            }
	        }

	    }
	   
	}

