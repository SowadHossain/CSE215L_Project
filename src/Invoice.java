
	import java.text.SimpleDateFormat;
	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.Objects;
	import java.time.LocalDateTime;
	
	public class Invoice {
	    private ArrayList<Product> items;
	    private ArrayList<Product> cart;
	    private LocalDateTime date;

	    public Invoice(ArrayList<Product> items){
	    	this.items = items;
	    	this.date = LocalDateTime.now();
	    }
/*	    
		public String getLocalDateTime (){
	        LocalDate localDate = LocalDate.now();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return dateFormat.format(localDate);
	    }
*/
	    public void addProduct(Product product){
	        items.add(product);                        // cart to items
	    }
	    public void removeProduct(Product product){
	        items.remove(product);                     // cart to items
	    }
	    private double calculatePriceWithoutDiscount(){
	        double totalPrice = 0;
	        for (Product o : items){                   // cart to items
	            totalPrice += o.getPrice();
	        }
	        return totalPrice;
	    }
	    public boolean isFullHouseDiscountAvailable(){

	        return true;
	    }
	    private double calculateDiscountedPrice(){
	        double discountedPrice = 0,fullHousediscountPrice = 0;
	        double priceWithoutDiscount = calculatePriceWithoutDiscount();
	        for (Product o : items){                                         //cart to items
	            discountedPrice += o.getPrice() - o.getDiscount()*o.getPrice()/100;
	        }
	        if(isFullHouseDiscountAvailable()){
	            fullHousediscountPrice = priceWithoutDiscount - 50*priceWithoutDiscount/100;
	            if(fullHousediscountPrice < discountedPrice)
	                return fullHousediscountPrice;
	        }
	        return discountedPrice;
	    }

	    public String getInvoice(){
	        String bill = "";
	        //bill += "Date - " + getLocalDateTime();
	        for (Product p : items){                      // cart to items
	            bill += "\nName: " + p.getName() +", Price: " + p.getPrice();
	        }
	        bill += "\nTotal Price : " + calculatePriceWithoutDiscount();
	        bill += "\nPrice after discount: " + calculateDiscountedPrice();
	        return bill;
	    }
	}

