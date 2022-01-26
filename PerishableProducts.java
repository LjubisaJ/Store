import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PerishableProducts extends Product {
	private LocalDate expirationDate;

	public PerishableProducts(String name, String brand, float price, LocalDate expirationDate) {
		super(name, brand, price);
		this.expirationDate = expirationDate;
	}

	@Override
	public float calculateDiscount(LocalDate dateOfPurchase) {
		long daysUntilExpiration = dateOfPurchase.until(this.expirationDate, ChronoUnit.DAYS);
		
		if (dateOfPurchase.compareTo(expirationDate) == 0) {
			setDiscountInPercentage(50);
			return getPrice() * 0.5f;
		} 
		
		else if (daysUntilExpiration < 5) {
			setDiscountInPercentage(10);
			return getPrice() * 0.1f;
		} 
		
		else
			return 0;
	}
	
	

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setLocalDate(LocalDate s_expirationDate) {
		expirationDate = s_expirationDate;
	}

	@Override
	public void basicInformation(LocalDate dateOfPurchase, float amount) {
		System.out.println(getName() + " - " + getBrand());
		System.out.println(amount + " x " + "$" + getPrice() + " = $" + getTwodecimalformat().format((amount * getPrice())));
		if (calculateDiscount(dateOfPurchase) > 0) {
			System.out.println("#discount " + getDiscountInPercentage() + "%" + "-$" + getTwodecimalformat().format(calculateDiscount(dateOfPurchase) * amount));
		}
	}

}
