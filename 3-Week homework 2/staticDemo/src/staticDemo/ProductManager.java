package staticDemo;

public class ProductManager {
	public void add(Product product) {
		
		if (ProductValidator.İsValid(product)) {
			System.out.println("Eklendi");
		} else {
			System.out.println("Ürün bilgileri geçersizdir.");
		}

		
	}
}
