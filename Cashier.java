import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Cashier {
	private static final DecimalFormat twoDecimalFormat = new DecimalFormat("0.00");
	private LocalDateTime dateOfPurchase;

	public Cashier(LocalDateTime dateOfPurchase) {
		this.setDateOfPurchase(dateOfPurchase);
	}

	public LocalDateTime getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public float subTotal(Cart cart) {
		float sum = 0;
		for (Map.Entry<Product, Float> cartItem : cart.getProducts().entrySet()) {
			sum += cartItem.getKey().getPrice() * cartItem.getValue();
		}

		return sum;
	}

	public float sumDiscount(Cart cart, LocalDate dateOfPurchase) {
		float sum = 0;
		for (Map.Entry<Product, Float> cartItem : cart.getProducts().entrySet()) {
			sum += cartItem.getKey().calculateDiscount(dateOfPurchase) * cartItem.getValue();
		}

		return sum;
	}

	public void printReceipt(Cart cart, LocalDate dateOfPurchase) {
		LocalDateTime dateAndTimeOfPurchase = LocalDateTime.of(2021, Month.JUNE, 14, 12, 34, 56);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = dateAndTimeOfPurchase.format(formatter);

		System.out.println("Date: " + formatDateTime + "\n");
		System.out.println("---Products---");
		System.out.println("\n");
		for (Map.Entry<Product, Float> cartItem : cart.getProducts().entrySet()) {
			Product product = cartItem.getKey();
			product.basicInformation(dateOfPurchase, cartItem.getValue());
			System.out.println("\n");
		}
		System.out.println("-----------------------------------------");
		System.out.println("SUBTOTAL: $" + twoDecimalFormat.format(subTotal(cart)));
		System.out.println("DISCOUNT: -$" + twoDecimalFormat.format(sumDiscount(cart, dateOfPurchase)) + "\n");
		System.out.println("TOTAL: $" + twoDecimalFormat.format((subTotal(cart) - sumDiscount(cart, dateOfPurchase))));

	}

}
