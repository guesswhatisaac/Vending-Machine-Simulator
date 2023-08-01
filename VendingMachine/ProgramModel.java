public class ProgramModel {

    private VendingMachine vendingMachine;   
    private Products productList[];
    private int productIndex = 0;

    // MAIN MENU -------------------

    public void createRegularVM() {
        RegularVM regularVM = new RegularVM();
        this.vendingMachine = regularVM;
    }

    public void createSpecialVM() {
        SpecialVM specialVM = new SpecialVM();
        this.vendingMachine = specialVM;
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    // MAINTENANCE & TEST FEATURES -------------

    public void initializeProducts() {
        Products Strawberry = new Products("Strawberry",  8.64f, 25);
        Products Blueberries = new Products("Blueberries",  80f, 150);
        Products Chocolate_Bar = new Products("Chocolate Bar",  556f, 90);
        Products Sugar = new Products("Sugar (100 Grams)",  387f, 120);
        Products Oreos = new Products("Oreos",  160f, 35);
        Products Can_of_Frosting = new Products("Can of Frosting",  418f, 165);
        Products Ice_Cream_Can = new Products("Ice Cream Can",  1500f, 350);
        Products Cherries = new Products("Cherries",  50f, 50);
        Products Can_of_Sprinkles = new Products("Can of Sprinkles",  418f, 100);
        Products Mangoes = new Products("Mangoes",  150f, 350);
        Products Cream_Cheese = new Products("Cream Cheese",  350f, 50);

        productList = new Products[]{Strawberry, Blueberries, Chocolate_Bar, Sugar, Oreos, Can_of_Frosting,
                                    Ice_Cream_Can, Cherries, Can_of_Sprinkles, Mangoes, Cream_Cheese};
    }
 
    public String getMachineDetails() {
        
        String formatted = "Balance: ";

        int cash = vendingMachine.getCurrentDenom().getTotal();
        formatted += cash + "\n" + "_____________________\n";

        int productCount = vendingMachine.getProductCount();

        if(productCount == 0){
            formatted += "No products in the vending machine.\n\n\n\n";
        }
        else{
            Products[] slots = vendingMachine.getSlots();

            for(int i = 0; i < productCount; i++){
                formatted += slots[i].getName() + " || " + slots[i].getPrice() + " || "
                           + slots[i].getCalories() + "\n";
            }
        }

        return formatted;
    }

    public Products[] getProductList() {
        return this.productList;
    }

    public boolean updateProductIndex(int value) {
        
        int current = productIndex + value;
        if (current < 0 || current > vendingMachine.getMaxSlots()){
            return false;
        }
        else{
            productIndex += value;
            return true;
        }
    }

    public int getProductIndex() {
        return this.productIndex;
    }

    public boolean addProduct(Products product) {
        if(vendingMachine.addToSlots(product)){
            return true;
        }
        else{
            return false;
        }
    }

}
