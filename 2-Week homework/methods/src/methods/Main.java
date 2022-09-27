package methods;

public class Main {

	public static void main(String[] args) {
	sayiBulmaca();
	}
	
public static void sayiBulmaca() {
	int[] sayılar = new int[] {1,2,5,7,9,0};
	int aranacak = 5;
	boolean varMi= false;
	
	for(int sayi : sayılar) {
		if(sayi==aranacak) {
			varMi = true;
			break;
		}
	}
	String mesaj="";
   if(varMi) {
	   mesaj="sayı mevcuttur:"+aranacak;
	  mesajVer(mesaj);
   }else {
	   mesajVer("sayı mevcut değildir:"+aranacak);
   }
}

public static void mesajVer(String mesaj) {
	 System.out.println(mesaj);
}
}
