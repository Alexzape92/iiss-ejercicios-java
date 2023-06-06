import java.util.Optional;

public class Product {
	
	private int code;
	private String name;
	private String category;
	private double weight;
	private double height;
	
	public Product(int code, String name, String category, double weight, double height) {
		assert code >= 0 : "Code must be positive";
		this.code = code;
		
        Optional<String> optName = Optional.ofNullable(name);
        Optional<String> optCategory = Optional.ofNullable(category);
        assert optName.isPresent() : "Name must be present";
        this.name = optName.get();
        assert optCategory.isPresent() : "Category must be present";
        this.category = optCategory.get();
		
        assert weight >= 0 : "Weight must be positive";
		this.weight = weight;

        assert height >= 0 : "Height must be positive";
		this.height = height;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setName(String name) {
        Optional<String> optName = Optional.ofNullable(name);
        assert optName.isPresent() : "Name must be present";
		this.name = optName.get();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCategory(String category) {
        Optional<String> optCategory = Optional.ofNullable(category);
        assert optCategory.isPresent() : "Category must be present";
		this.category = optCategory.get();
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setWeight(double weight) {
        assert weight >= 0 : "Weight must be positive";
		this.weight = weight;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setHeight(double height) {
        assert height >= 0 : "Height must be positive";
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
}