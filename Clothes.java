import java.time.LocalDate;

enum Size {
	XS, S, M, L, XL
}

public class Clothes extends Product {
	private Size size;
	private String color;

	public Clothes(String name, String brand, float price, Size size, String color) {
		super(name, brand, price);
		this.size = size;
		this.color = color;
	}

	
	@Override
	public float calculateDiscount(LocalDate dateOfPurchase) {
		if (!Helper.isWeekend()) {
			setDiscountInPercentage(10);
			return getPrice() * 0.1f;
		}
		return 0;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void basicInformation(LocalDate dateOfPurchase, float amount) {
		System.out.println(getName() + " - " + getBrand() + " - " + getSize() + " - " + getColor());
		System.out.println(amount + " x " + "$" + getPrice() + " = $" + getTwodecimalformat().format(amount * getPrice()));
		if (calculateDiscount(dateOfPurchase) > 0) {
			System.out.println("#discount " + getDiscountInPercentage() + "%" + "-$" + getTwodecimalformat().format(calculateDiscount(dateOfPurchase) * amount));
		}
	}

}
