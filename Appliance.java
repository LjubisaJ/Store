import java.time.LocalDate;

public class Appliance extends Product {
	private String model;
	private float weight;
	private LocalDate productionDate;

	public Appliance(String name, String brand, float price, String model, float weight, LocalDate productionDate) {
		super(name, brand, price);
		this.model = model;
		this.weight = weight;
		this.productionDate = productionDate;
	}

	

	@Override
	public float calculateDiscount(LocalDate dateOfPurchase) {
		if (Helper.isWeekend() && getPrice() > 999) {
			return getPrice() * 0.05f;
		}
		return 0;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public LocalDate getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}

	@Override
	public void basicInformation(LocalDate dateOfPurchase, float amount) {
		System.out.println(getName() + " - " + getBrand() + " - " + getModel());
		System.out.println(amount + " x " + "$" + getPrice() + " = $" + getTwodecimalformat().format(amount * getPrice()));
		if (calculateDiscount(dateOfPurchase) > 0) {
			System.out.println("#discount " + getDiscountInPercentage() + "%" + "-$" + getTwodecimalformat().format(calculateDiscount(dateOfPurchase) * amount));
		}
	}

}
