package project;


	public class Game extends StockableProduct{
	
	    private String developer;

	    public Game(int productId, String name, double price, int yearPublished, String genre, double discount, int numberOfItemsStocked, String developer) {
	        super( productId,  name,  price,  genre,  yearPublished,  discount,  numberOfItemsStocked);
	        this.developer = developer;
	    }

	    public String getDeveloper() {
	        return this.developer;
	    }

	    public void setDeveloper(String developer) {
	        this.developer = developer;
	    }

	    
	    public String toString() {
	        return "Game[ developer = " + developer + "]";
	    }


	    public String getInfo() {
	        String string = "Name: " + super.getName();
	        string += "\nProduct Id: " + super.getProductId();
	        string += "\nYear Published: " + super.getYearPublished();
	        string += "\nGenre: " + super.getGenre();
	        string += "\nDiscount: " + super.getDiscount();
	        string += "\nPrice: " + super.getPrice();
	        string += "\nDeveloper's Name: " + getDeveloper();
	        string += "\n";

	        return string;
	    }
	}

