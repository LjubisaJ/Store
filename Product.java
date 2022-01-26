import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class Product {
	private static final DecimalFormat twoDecimalFormat = new DecimalFormat("0.00");
	private String name;
	private String brand;
	private float price;
	private int discountInPercentage;
	private float discount;
	
	public Product(String name, String brand, float price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		discount=0;
		discountInPercentage=0;
	}

	public abstract void basicInformation(LocalDate dateofPurchase, float amount);
	public abstract float calculateDiscount(LocalDate dateOfPurchase);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDiscountInPercentage() {
		return discountInPercentage;
	}

	public void setDiscountInPercentage(int discountInPercentage) {
		this.discountInPercentage = discountInPercentage;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public static DecimalFormat getTwodecimalformat() {
		return twoDecimalFormat;
	}
	
}
