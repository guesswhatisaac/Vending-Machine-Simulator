import javax.swing.JTextField;

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
        
        String formatted = "Balance: " + vendingMachine.getCurrentDenom().getTotal() + " Php\n";
        formatted += "_____________________\n\n";

        int productCount = vendingMachine.getProductCount();

        if(productCount == 0){
            formatted += "No products in the vending machine.\n\n\n\n";
        }
        else{
            Products[] slots = vendingMachine.getSlots();
            int[] stockInSlots = vendingMachine.getStockInSlots();

            for(int i = 0; i < productCount; i++){
                formatted += "Slot [" + (i+1) +"] : " + slots[i].getName() + " (" + stockInSlots[i] + "x) | " + 
                            slots[i].getPrice() + " Php | " + slots[i].getCalories() + " cal\n";
            }
        }

        return formatted;
    }

    public String getDenomDetails() {

        String formatted = "Balance: " + vendingMachine.getCurrentDenom().getTotal() + " Php\n";
        formatted += "_____________________\n\n";

        Denominations denom = vendingMachine.getCurrentDenom();
        formatted += "1000 Php | ( " + denom.getDenom(1000) + "x )\n";
        formatted += "500 Php | ( " + denom.getDenom(500) + "x )\n";
        formatted += "200 Php | ( " + denom.getDenom(200) + "x )\n";
        formatted += "100 Php | ( " + denom.getDenom(100) + "x )\n";                 
        formatted += "50 Php | ( " + denom.getDenom(50) + "x )\n";
        formatted += "20 Php | ( " + denom.getDenom(20) + "x )\n";  
        formatted += "10 Php | ( " + denom.getDenom(10) + "x )\n";
        formatted += "5 Php | ( " + denom.getDenom(5) + "x )\n";  
        formatted += "1 Php | ( " + denom.getDenom(1) + "x )\n";
        
        return formatted;
    }

    public boolean updateVendingDenom(JTextField[] tfArr){

        int[] cCount = new int[9];
        boolean ret = true;
        for(int i = 0; i < tfArr.length && ret != false; i++){
            try{
                cCount[i] = Integer.parseInt(tfArr[i].getText());
                if(cCount[i] < 0){ // no negatives
                    ret = false;
                }
            }
            catch (NumberFormatException e){
                ret = false;
            }
        }

        if(ret == false){
            return ret;
        }

        vendingMachine.getCurrentDenom().updateDenom(cCount[0], 1000);
        vendingMachine.getCurrentDenom().updateDenom(cCount[1], 500);
        vendingMachine.getCurrentDenom().updateDenom(cCount[2], 200);
        vendingMachine.getCurrentDenom().updateDenom(cCount[3], 100);
        vendingMachine.getCurrentDenom().updateDenom(cCount[4], 50);
        vendingMachine.getCurrentDenom().updateDenom(cCount[5], 20);
        vendingMachine.getCurrentDenom().updateDenom(cCount[6], 10);
        vendingMachine.getCurrentDenom().updateDenom(cCount[7], 5);
        vendingMachine.getCurrentDenom().updateDenom(cCount[8], 1);

        return ret;
    }

    public boolean updateVendingProduct(JTextField[] tfArr){
        
        int[] cVal = new int[3];
        boolean ret = true;
        for(int i = 0; i < tfArr.length && ret != false; i++){
            try{
                cVal[i] = Integer.parseInt(tfArr[i].getText());
                if(cVal[i] < 0 && i != 0){ // restock amount & price cannot be negative
                    ret = false;
                }
            }
            catch (NumberFormatException e){
                ret = false;
            }
        }

        if(ret == false){
            return ret;
        }

        //cVal[0] = index of product
            // check if there is product in that index, else return false
        //cVal[1] = restock amount.... note to clone the object
            // check if restock amount is more than the stock for that slot
        //cVal[2] = updatedPrice
        return ret;
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

    public int addProduct(Products product) {

        int ret = 0;
        if(vendingMachine.addToSlots(product) == 0){
            ret = 0;
        }
        else if(vendingMachine.addToSlots(product) == 1){
            ret = 1;
        }
        else if(vendingMachine.addToSlots(product) == 2){
            ret = 2;
        }

        return ret;
        
    }

}
