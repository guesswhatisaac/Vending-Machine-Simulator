import javax.swing.JTextField;
import java.util.ArrayList;

public class ProgramModel {

    private VendingMachine vendingMachine;   
    private Products productList[];
    private int productIndex = 0;
    private Products productToBeSold;
    private Denominations userDenom = new Denominations();

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

    public String getPayDetails() {
        
        String formatted = "Item to be bought: " + productToBeSold.getName() + "\n\n";

        formatted += "[1000 Php]: (" + userDenom.getDenom(1000) + "x)\t\t";
        formatted += "[500 Php]: (" + userDenom.getDenom(500) + "x)\t\t";
        formatted += "[200 Php]: (" + userDenom.getDenom(200) + "x)\t\t";
        formatted += "[100 Php]: (" + userDenom.getDenom(100) + "x)\t\t";
        formatted += "[50 Php]: (" + userDenom.getDenom(50) + "x)\t\t\n";
        formatted += "[20 Php]: (" + userDenom.getDenom(20) + "x)\t\t";
        formatted += "[10 Php]: (" + userDenom.getDenom(10) + "x)\t\t";
        formatted += "[5 Php]: (" + userDenom.getDenom(5) + "x)\t\t";
        formatted += "[1 Php]: (" + userDenom.getDenom(1) + "x)\t\t\n\n";

        formatted += "Total: " + userDenom.getTotal() + " Php";

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

                if(i == 0 && ((cVal[0]-1) >= vendingMachine.getMaxSlots()) || ((cVal[0]-1) < 0)){ // out of bounds index
                    System.out.println("Product index out of bounds.");
                    ret = false;
                }
                else if(vendingMachine.getSlots()[cVal[0]-1] == null){
                    System.out.println("Product does not exist in slot.");
                    ret = false;
                }
                else if(cVal[i] < 0 && i != 0){ // restock amount & price cannot be negative
                    System.out.println("Negative restock amount and price not allowed.");
                    ret = false;
                }
                else if(i == 1 && (vendingMachine.getStockInSlots()[cVal[0]-1]+cVal[1] > vendingMachine.getMaxStock())){ 
                    // if restock amount+productSlotCount is greater than limit
                    System.out.println("Restock amount is greater than limit.");
                    ret = false;
                }
            }
            catch (NumberFormatException e){ // catch invalid inputs
                System.out.println("Input contains non-integer value.");
                ret = false;
            }
        }

        if(ret == false){
            return ret;
        }

        // restock and update price
        vendingMachine.restockProduct(cVal[0]-1, cVal[1]);
        vendingMachine.getSlots()[cVal[0]-1].updatePrice(cVal[2]);

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

    public Products getProductToBeSold(){
        return productToBeSold;
    }

    public void setProductToBeSold(Products productSelected){
        this.productToBeSold = productSelected;
    }

    public Denominations getUserDenom(){
        return userDenom;
    }

    public int transact(){

        int productToBeSoldIndex = 0;

        for(int i = 0; i < vendingMachine.getProductCount(); i++){
            if(vendingMachine.getSlots()[i].getName() == productToBeSold.getName()){
                productToBeSoldIndex = i;
            }
        }

        int userCash = userDenom.getTotal();
        int[] changeReturned = getVendingMachine().getChangeReturned();
        int productCost = vendingMachine.getSlots()[productToBeSoldIndex].getPrice();
        boolean isBought = false;

        if(userCash < productCost){ // not enough money
            return 0;
        }
        else if(userCash > productCost){
            if(getVendingMachine().produceChange(userCash-productCost) == (userCash-productCost)){
                isBought = true;

                System.out.println("Change Returned: ");
                for(int i = 0; i < changeReturned.length; i++){
                    if(changeReturned[i] != 0){
                        switch(i){
                            case 0: System.out.println("(" + changeReturned[i] + "x) " + " 1000 Peso Bill/s");
                                break;  
                            case 1: System.out.println("(" + changeReturned[i] + "x) " + " 500 Peso Bill/s");
                                break;   
                            case 2: System.out.println("(" + changeReturned[i] + "x) " + " 200 Peso Bill/s");
                                break;
                            case 3: System.out.println("(" + changeReturned[i] + "x) " + " 100 Peso Bill/s");
                                break;
                            case 4: System.out.println("(" + changeReturned[i] + "x) " + " 50 Peso Bill/s");
                                break;  
                            case 5: System.out.println("(" + changeReturned[i] + "x) " + " 20 Peso Bill/s");
                                break;
                            case 6: System.out.println("(" + changeReturned[i] + "x) " + " 10 Peso Bill/s");
                                break;
                            case 7: System.out.println("(" + changeReturned[i] + "x) " + " 5 Peso Bill/s");
                                break;
                            case 8: System.out.println("(" + changeReturned[i] + "x) " + " 1 Peso Bill/s");
                                break;
                        }
                    }
                }

            }
            else{
                return 1; // cannot produce change
            }
        }
        else if(userCash == productCost){
            isBought = true;
        }

        if(isBought == true){
            // reduce stock
            vendingMachine.reduceStock(productToBeSoldIndex);

            // add cash input of user to current denom of vm
            getVendingMachine().getCurrentDenom().updateDenom(userDenom.getDenom(1), 1);
            getVendingMachine().getCurrentDenom().updateDenom(userDenom.getDenom(5), 5);
            getVendingMachine().getCurrentDenom().updateDenom(userDenom.getDenom(10), 10);
            getVendingMachine().getCurrentDenom().updateDenom(userDenom.getDenom(20), 20);
            getVendingMachine().getCurrentDenom().updateDenom(userDenom.getDenom(50), 50);
            getVendingMachine().getCurrentDenom().updateDenom(userDenom.getDenom(100), 100);
            getVendingMachine().getCurrentDenom().updateDenom(userDenom.getDenom(200), 200);
            getVendingMachine().getCurrentDenom().updateDenom(userDenom.getDenom(500), 500);
            getVendingMachine().getCurrentDenom().updateDenom(userDenom.getDenom(1000), 1000);
        }

        return 2; // item bought successfully
    }

    public String generateReceipt() {

        String formatted = "Product Bought: " + productToBeSold.getName() + "\n\n";
        
        formatted += "Money Provided: " + userDenom.getTotal() + " Php \n\n";

        int[] change = vendingMachine.getChangeReturned();

        int total = 0;
        total += change[0] * 1000;
        total += change[1] * 500;
        total += change[2] * 200;
        total += change[3] * 100;
        total += change[4] * 50;
        total += change[5] * 20;
        total += change[6] * 10;
        total += change[7] * 5;
        total += change[8] * 1;

        formatted += "Change: " + total + " Php\n\n";

        vendingMachine.resetChange();
        return formatted;

    }

    public String getSummaryTransactions() {

        Products[] slots = vendingMachine.getSlots();
        Products[][] startingStock = vendingMachine.getStartingStock();
        Products[][] currentStock = vendingMachine.getCurrentStock();


        String formatted = "[Starting Inventory & Ending Inventory]\n\n";
        
        formatted += "_____________________\n\n";

        int currentStockCounter = 0;
        int startingStockCounter = 0;

        ArrayList<Integer> currentStockArr = new ArrayList<Integer>();
        ArrayList<Integer> startStockArr = new ArrayList<Integer>();

        for(int i = 0; i < vendingMachine.getProductCount(); i++){

            formatted += "Slot [" + (i+1) +"]: " + slots[i].getName() + "\n";
            
            startingStockCounter = 0;
            int j = 0;

            while(startingStock[i][j] != null){
                startingStockCounter++;
                j++;                
            }

            currentStockCounter = 0;
            j = 0;
            
            while(currentStock[i][j] != null){
                currentStockCounter++;
                j++;                
            }

            currentStockArr.add(currentStockCounter);
            startStockArr.add(startingStockCounter);

            formatted += "(" + startingStockCounter + "x) -> (" + currentStockCounter + "x)\n\n";
        }

        int moneyCollected = 0;

        for(int i = 0; i < vendingMachine.getProductCount(); i++){
            moneyCollected += (startStockArr.get(i) - currentStockArr.get(i)) * slots[i].getPrice();
        }

        formatted += "Cash Amount (since last restock) : " + moneyCollected + " Php";
        return formatted;
    }

}