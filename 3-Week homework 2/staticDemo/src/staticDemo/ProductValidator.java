package staticDemo;

public class ProductValidator {
	
	static {
		System.out.println("Static yapıcı blaok çalıştı");
	}
	
	public ProductValidator() {
		System.out.println("Yapıcı blok çalıştı");
	}
	public static boolean İsValid(Product product) {
		if (product.price > 0 && ! product.name.isEmpty()) {
			return true;

		} else {
			return false;

		}
	}
	public void bişey() {
		
	}
	
	//aşağıdaki inner class'dır
	//public static class BaşkaBirClass{
	//	public static void Sil() {
			
	//}
	
}
