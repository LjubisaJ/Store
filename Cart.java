import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

	Map<Product, Float> products;

	public Cart() {
		this.products = new LinkedHashMap<Product,Float>();

	}
	public Cart(Map<Product, Float> products) {
		this.products = products;
	}

	public void add(Product product, float amount) {
		products.put(product, amount);
	}

	public void remove(Product product) {
		products.remove(product);
	}
	

	public Map<Product, Float> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Float> products) {
		this.products = products;
	}
	
}
