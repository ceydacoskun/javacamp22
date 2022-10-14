package classesWithAttributes;

public class Product {
	
	public Product (int id, String name, String description, double price, int stockAmount, String renk) {
		System.out.println("Yapıcı blok çalıştı");
		this.id = id;
		this.renk = renk;
		this.name = name;
		this.price = price;
		this.description = description;
		this.stockAmount = stockAmount;
	}
	
	
	public Product() {
		
	}
	
	
	// aşağıdakilere attribute veya field denir.
	private int id;
	String name;
	String description;
	double price;
	int stockAmount;
	String renk;
	String kod;

	// getter
	public int getId() {
		return id;

	}

	// setter
	public void setId(int id) {
		this.id = id;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desscription) {
		this.description = desscription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}
//kodu kullanıcının yazmasını engellemek;
	public String getKod() {
		return this.name.substring(0,1)+id;
	}

	

}