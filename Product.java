package labProject;

public class Product {

	  private String name;
	  private String productId;
	  private double price;
	  private String genre; 
	  private int yearPublished;
	  private double discount;

	  public Product(String name, String productId, double price, String genre, int yearPublished, double discount) {
	    this.name = name;
	    this.productId = productId;
	    this.price = price;
	    this.genre = genre;
	    this.yearPublished = yearPublished;
	    this.discount = discount;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getProductId() {
	    return productId;
	  }

	  public void setProductId(String productId) {
	    this.productId = productId;
	  }

	  public double getPrice() {
	    return price;
	  }

	  public void setPrice(double price) {
	    this.price = price;
	  }

	  public String getGenre() {
	    return genre;
	  }

	  public void setGenre(String genre) {
	    this.genre = genre;
	  }

	  public int getYearPublished() {
	    return yearPublished;
	  }

	  public void setYearPublished(int yearPublished) {
	    this.yearPublished = yearPublished;
	  }

	  public double getDiscount() {
	    return discount;
	  }

	  public void setDiscount(double discount) {
	    this.discount = discount;
	  }

	  public String getInfo() {
	    // This method can be customized to return product information in a specific format
	    StringBuilder info = new StringBuilder();
	    info.append("Name: ").append(name).append("\n");
	    info.append("Product ID: ").append(productId).append("\n");
	    info.append("Price: $").append(String.format("%.2f", price)).append("\n");
	    info.append("Genre: ").append(genre).append("\n");
	    info.append("Year Published: ").append(yearPublished).append("\n");
	    return info.toString();
	  }

	  public double calculateFinalPrice() {
	    // This method is used to calculate the final price after applying discount
	    return price * (1 - discount);
	  }
	}
