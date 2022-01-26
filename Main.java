import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;


public class Main {
	public static void main(String[] args) {
		LocalDateTime dateAndTimeOfPurchase = LocalDateTime.of(2021, Month.JUNE, 14, 12, 34, 56);
		LocalDate dateOfPurchase = LocalDate.of(2021, Month.JUNE, 14);
		Product food= new Food("apples", "brandA", 1.50f , LocalDate.of(2021, Month.JUNE, 14));
		Product beverages= new Beverages("milk", "BrandM", 0.99f, LocalDate.of(2022, Month.FEBRUARY, 2));
		Product clothes= new Clothes("T-Shirt", "BrandT", 15.99f, Size.M, "violet");
		Product appliance= new Appliance("laptop", "BrandL", 2345, "ModelL", 1.125f, LocalDate.of(2021, Month.MARCH, 3));
		Cart cart = new Cart();
		Cashier cashier = new Cashier(dateAndTimeOfPurchase);
		cart.add(food, 2.45f);
		cart.add(beverages, 3);
		cart.add(clothes, 2);
		cart.add(appliance, 1);
		cashier.printReceipt(cart, dateOfPurchase);
	}
}
