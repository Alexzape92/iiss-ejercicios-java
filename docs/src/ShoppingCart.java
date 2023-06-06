import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	
	Map<Product, Integer> shoppingCart;
	
	public ShoppingCart() {
		shoppingCart = new HashMap<Product, Integer>();
	}
	
	public void addProduct(Product product, int number) {
		assert number > 0 : "Number must be greater than 0";
		if(shoppingCart.keySet().stream().filter(element -> element.getCode() == product.getCode()).count() == 0) {
			shoppingCart.put(product, number);
		}
	}
	
	public Product removeProduct(Product product) {
        assert shoppingCart.containsKey(product) : "Product must be in the shopping cart";

		shoppingCart.remove(product);
		return product;
	}
	
	public void printShoppingCartContent() {
		System.out.println("The shopping cart content is: ");
		
		for(Product product: shoppingCart.keySet()) {
			System.out.println(product.getCode() + " - " + product.getName() + " : " + shoppingCart.get(product));
		}
		
	}
}