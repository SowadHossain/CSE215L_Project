package project;


	public class Music extends StockableProduct{
	    
	    private String artistName;

	    public Music( int productId, String name, double price, int yearPublished, String genre, double discount, int numberOfItemsStocked, String artistName) {
	        super( productId,  name,  price,  genre,  yearPublished,  discount,  numberOfItemsStocked);
	        this.artistName = artistName ;
	    }

	    public String getName() {
	        return this.artistName;
	    }

	    public void setName(String artistName) {
	        this.artistName = artistName;
	    }

	    
	    public String toString() {
	        return "Music [artistName = " + artistName + "]";
	    }

	    
	    public String getInfo() {
	        String string = "Name: " + super.getName();
	        string += "\nProduct Id: " + super.getProductId();
	        string += "\nYear Published: " + super.getYearPublished();
	        string += "\nGenre: " + super.getGenre();
	        string += "\nDiscount: " + super.getDiscount();
	        string += "\nPrice: " + super.getPrice();
	        string += "\nArtist's Name: " + getName();
	        string += "\n";

	        return string;
	    }
	}

