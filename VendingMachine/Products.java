/**
 * Represents a product with its stock, name, calories, and price.
 */
public class Products {
    
    // NOTE: IF OBJECT SOLD, IT MUST BE DESTROYED. NO USE FOR STOCK VARIABLE
    private String name;
    private float calories;
    private int price; // change to float when centavos are implemented

    /**
     * Constructs a new instance of the Products class with the specified stock, name, calories, and price.
     *
     * @param name the name of the product
     * @param calories the number of calories in the product
     * @param price the price of the product
     */
    public Products(String name, float calories, int price){
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return the name of the product
     */
    public String getName(){
        return this.name;
    }

    /**
     * Retrieves the number of calories in the product.
     *
     * @return the number of calories in the product
     */
    public float getCalories(){
        return this.calories;
    }

    /**
     * Retrieves the price of the product.
     *
     * @return the price of the product
     */
    public int getPrice(){
        return this.price;
    }
    
    /**
     * Updates the price of the product.
     *
     * @param updatedPrice the new price of the product
     */
    public void updatePrice(int updatedPrice){
        this.price = updatedPrice;
    }
}