import javax.swing.JTextField;
import java.util.ArrayList;

public class ProgramModel {

    private RegularVM vm1 = new RegularVM();   
    private SpecialVM vm2 = new SpecialVM();
    private int activeVM = 0;
    private Products productList[];
    private Products custom[];
    private Products required[];
    private ArrayList<Products> addedCakeToppings;
    private int productIndex = 0;
    private Products productToBeSold;
    private Denominations userDenom = new Denominations();

    // MAIN MENU -------------------

    /**
     * Creates a new instance of the standard vending machine, sets it as the active vending machine, and initializes the product array.
     */
    public void createRegularVM() {
        this.vm1 = new RegularVM();
        activeVM = 1;
        productIndex = 0;
        initializeProducts();
    }

    /**
     * Creates a new instance of the special vending machine, sets it as the active vending machine, and initializes the product array.
     */
    public void createSpecialVM() {
        this.vm2 = new SpecialVM();
        addedCakeToppings = new ArrayList<Products>();
        activeVM = 2;
        productIndex = 0;
        initializeProducts();
    }

    /**
     * Getter for the currently active vending machine object
     * @return the active vending machine if any, null if no active vending machine.
     */
    public VendingMachine getVendingMachine() {
        switch(activeVM){
            case 1:
            return vm1;
            case 2:
            return vm2;
            default:
            return null;
        }
    }

    // MAINTENANCE & TEST FEATURES -------------

    /**
     * Initializes list  of preset products depending on which vending machine is currently active.
     */
    public void initializeProducts() {
        Products Strawberry = new Products("Strawberry",  8.64f, 25);
        Products Blueberries = new Products("Blueberries",  80f, 150);
        Products Chocolate_Bar = new Products("Chocolate Bar",  556f, 90);
        Products Oreos = new Products("Oreos",  160f, 35);
        Products Ice_Cream_Can = new Products("Ice Cream Can",  1500f, 350);
        Products Cherries = new Products("Cherries",  50f, 50);
        Products Mangoes = new Products("Mangoes",  150f, 350);

        Products Can_of_Sprinkles = new Products("Can of Sprinkles",  418f, 100);
        Products Can_of_Frosting = new Products("Can of Frosting",  418f, 165);
        Products Cream_Cheese = new Products("Cream Cheese",  350f, 50);

        Products Sugar = new Products("Sugar (1 cup)",  773f, 40);
        Products Butter = new Products("Butter (1 cup)", 1627, 100);
        Products Eggs = new Products("Eggs (2 pcs)", 156, 20);
        Products Flour = new Products("Flour (2 cups)", 910, 20);
        Products Baking_Powder = new Products("Baking Powder (2 tsp)", 4, 18);
        Products Milk = new Products("Milk", 103, 10);

        switch(activeVM){
            case 1:
            productList = new Products[]{Strawberry, Blueberries, Chocolate_Bar, Sugar, Oreos, Can_of_Frosting,
                                    Ice_Cream_Can, Cherries, Can_of_Sprinkles, Mangoes, Cream_Cheese};
            break;
            case 2:
            productList = new Products[]{Strawberry, Blueberries, Chocolate_Bar, Oreos, Ice_Cream_Can, Cherries, Mangoes, 
                                        Can_of_Sprinkles, Can_of_Frosting, Cream_Cheese,
                                        Sugar, Butter, Eggs, Flour, Baking_Powder, Milk};
            break;
        }
        
    }
 
    /**
     * Getter for the active vending machine number
     * @return 1 if standard is active, 2 if special is active.
     */
    public int getActiveVM(){
        return activeVM;
    }

    /**
     * Initializes the custom and required arrays for custom cake related processes.
     */
    public void initializeCake(){
        custom = new Products[10];
        required = new Products[6];
        int i;
        int j=0;

        for(i=0;i<10;i++){
            custom[j] = productList[i];
            j++;
        }

        j=0;
        for(i=10;i<16;i++){
            required[j] = productList[i];
            j++;
        }
    }

    /**
     * Returns a string containing the current machine details, including products available and current cash balance.
     * @return string containing cash balance and products currently in vending machine.
     */
    public String getMachineDetails() {
        
        String formatted;
        int productCount;

        switch(activeVM){
            case 1:
            formatted = "Balance: " + vm1.getCurrentDenom().getTotal() + " Php\n";
            formatted += "_____________________\n\n";

            productCount = vm1.getProductCount();

            if(productCount == 0){
                formatted += "No products in the vending machine.\n\n\n\n";
            }
            else{
                Products[] slots = vm1.getSlots();
                int[] stockInSlots = vm1.getStockInSlots();

                for(int i = 0; i < productCount; i++){
                    formatted += "Slot [" + (i+1) +"] : " + slots[i].getName() + " (" + stockInSlots[i] + "x) | " + 
                                slots[i].getPrice() + " Php | " + slots[i].getCalories() + " cal\n";
                }
            }
            return formatted;
            case 2:
            formatted = "Balance: " + vm2.getCurrentDenom().getTotal() + " Php\n";
            formatted += "_____________________\n\n";

            productCount = vm2.getProductCount();

            if(productCount == 0){
                formatted += "No products in the vending machine.\n\n\n\n";
            }
            else{
                Products[] slots = vm2.getSlots();
                int[] stockInSlots = vm2.getStockInSlots();

                for(int i = 0; i < productCount; i++){
                    formatted += "Slot [" + (i+1) +"] : " + slots[i].getName() + " (" + stockInSlots[i] + "x) | " + 
                                slots[i].getPrice() + " Php | " + slots[i].getCalories() + " cal\n";
                }
            }
            return formatted;
            default:
            return "null";
        }
    }

    /**
     * Returns a string containing payment details, including the purchased item and total amount user has input.
     * @return string containing payment details.
     */
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

    /**
     * Returns a string containing the denominations currently in the vending machine
     * @return string containing denominations
     */
    public String getDenomDetails() {

        String formatted;
        Denominations denom;
        
        switch(activeVM){
            case 1:
            formatted = "Balance: " + vm1.getCurrentDenom().getTotal() + " Php\n";
            formatted += "_____________________\n\n";

            denom = vm1.getCurrentDenom();
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
            case 2:
            formatted = "Balance: " + vm2.getCurrentDenom().getTotal() + " Php\n";
            formatted += "_____________________\n\n";

            denom = vm2.getCurrentDenom();
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
            default:
            return "null";
        }
    }

    /**
     * Updates the value of all denominations in the vending machine
     * @param tfArr An array containing the values each denomination is to be incremented by
     * @return true if successful, false if error encountered
     */
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

        switch(activeVM){
            case 1:
            vm1.getCurrentDenom().updateDenom(cCount[0], 1000);
            vm1.getCurrentDenom().updateDenom(cCount[1], 500);
            vm1.getCurrentDenom().updateDenom(cCount[2], 200);
            vm1.getCurrentDenom().updateDenom(cCount[3], 100);
            vm1.getCurrentDenom().updateDenom(cCount[4], 50);
            vm1.getCurrentDenom().updateDenom(cCount[5], 20);
            vm1.getCurrentDenom().updateDenom(cCount[6], 10);
            vm1.getCurrentDenom().updateDenom(cCount[7], 5);
            vm1.getCurrentDenom().updateDenom(cCount[8], 1);
            break;
            case 2:
            vm2.getCurrentDenom().updateDenom(cCount[0], 1000);
            vm2.getCurrentDenom().updateDenom(cCount[1], 500);
            vm2.getCurrentDenom().updateDenom(cCount[2], 200);
            vm2.getCurrentDenom().updateDenom(cCount[3], 100);
            vm2.getCurrentDenom().updateDenom(cCount[4], 50);
            vm2.getCurrentDenom().updateDenom(cCount[5], 20);
            vm2.getCurrentDenom().updateDenom(cCount[6], 10);
            vm2.getCurrentDenom().updateDenom(cCount[7], 5);
            vm2.getCurrentDenom().updateDenom(cCount[8], 1);
            break;
        }

        return ret;
    }

    /**
     * Updates the chosen products information, such as stock and price
     * @param tfArr represents the slots of the vending machine containing the products
     * @return true if successful, false if error encountered.
     */
    public boolean updateVendingProduct(JTextField[] tfArr){
        
        int[] cVal = new int[3];
        boolean ret = true;
        
        switch(activeVM){
            case 1:
            for(int i = 0; i < tfArr.length && ret != false; i++){
                try{
                    cVal[i] = Integer.parseInt(tfArr[i].getText());

                    if(i == 0 && ((cVal[0]-1) >= vm1.getMaxSlots()) || ((cVal[0]-1) < 0)){ // out of bounds index
                        System.out.println("Product index out of bounds.");
                        ret = false;
                    }
                    else if(vm1.getSlots()[cVal[0]-1] == null){
                        System.out.println("Product does not exist in slot.");
                        ret = false;
                    }
                    else if(cVal[i] < 0 && i != 0){ // restock amount & price cannot be negative
                        System.out.println("Negative restock amount and price not allowed.");
                        ret = false;
                    }
                    else if(i == 1 && (vm1.getStockInSlots()[cVal[0]-1]+cVal[1] > vm2.getMaxStock())){ 
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
            break;
            case 2:
            for(int i = 0; i < tfArr.length && ret != false; i++){
                try{
                    cVal[i] = Integer.parseInt(tfArr[i].getText());

                    if(i == 0 && ((cVal[0]-1) >= vm2.getMaxSlots()) || ((cVal[0]-1) < 0)){ // out of bounds index
                        System.out.println("Product index out of bounds.");
                        ret = false;
                    }
                    else if(vm2.getSlots()[cVal[0]-1] == null){
                        System.out.println("Product does not exist in slot.");
                        ret = false;
                    }
                    else if(cVal[i] < 0 && i != 0){ // restock amount & price cannot be negative
                        System.out.println("Negative restock amount and price not allowed.");
                        ret = false;
                    }
                    else if(i == 1 && (vm2.getStockInSlots()[cVal[0]-1]+cVal[1] > vm2.getMaxStock())){ 
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
            break;
        }

        if(ret == false){
            return ret;
        }

        // restock and update price
        switch(activeVM){
            case 1:
            vm1.restockProduct(cVal[0]-1, cVal[1]);
            vm1.getSlots()[cVal[0]-1].updatePrice(cVal[2]);
            break;
            case 2:
            vm2.restockProduct(cVal[0]-1, cVal[1]);
            vm2.getSlots()[cVal[0]-1].updatePrice(cVal[2]);
            break;
        }

        return ret;
    }

    /**
     * Getter for the product list array
     * @return product list array
     */
    public Products[] getProductList() {
        return this.productList;
    }

    /**
     * Updates the currenttly viewed product index
     * @param value
     * @return
     */
    public boolean updateProductIndex(int value) {
        
        int current = productIndex + value;

        switch(activeVM){
            case 1:
            if (current < 0 || current > productList.length){
                return false;
            }
            else{
                productIndex += value;
                return true;
            }
            case 2:
            if (current < 0 || current > productList.length){
                return false;
            }
            else{
                productIndex += value;
                return true;
            }
            default:
            return false;
        }
    }

    public int getProductIndex() {
        return this.productIndex;
    }

    public int addProduct(Products product) {

        int ret = 0;

        switch(activeVM){
            case 1:
                if(vm1.addToSlots(product) == 0){
                ret = 0;
            }
            else if(vm1.addToSlots(product) == 1){
                    ret = 1;
            }
            else if(vm1.addToSlots(product) == 2){
                ret = 2;
            }
            break;
            case 2:
                if(vm2.addToSlots(product) == 0){
                ret = 0;
            }
            else if(vm2.addToSlots(product) == 1){
                    ret = 1;
            }
            else if(vm2.addToSlots(product) == 2){
                ret = 2;
            }
            break;
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
        int userCash = 0;;
        int[] changeReturned = new int[9];
        int productCost = 0;
        boolean isBought = false;;

        switch(activeVM){
            case 1:
            for(int i = 0; i < vm1.getProductCount(); i++){
                if(vm1.getSlots()[i].getName() == productToBeSold.getName()){
                    productToBeSoldIndex = i;
                }
            }

            userCash = userDenom.getTotal();
            changeReturned = getVendingMachine().getChangeReturned();
            productCost = vm1.getSlots()[productToBeSoldIndex].getPrice();
            isBought = false;
            break;
            case 2:
            for(int i = 0; i < vm2.getProductCount(); i++){
                if(vm2.getSlots()[i].getName() == productToBeSold.getName()){
                    productToBeSoldIndex = i;
                }
            }

            userCash = userDenom.getTotal();
            changeReturned = getVendingMachine().getChangeReturned();
            productCost = vm2.getSlots()[productToBeSoldIndex].getPrice();
            isBought = false;
            break;
        }

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
            switch(activeVM){
                case 1:
                vm1.reduceStock(productToBeSoldIndex);
                break;
                case 2:
                vm2.reduceStock(productToBeSoldIndex);
                break;
            }

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

        int[] change = new int[9];

        switch(activeVM){
            case 1:
            change = vm1.getChangeReturned().clone();
            break;
            case 2:
            change = vm2.getChangeReturned().clone();
            break;
        }

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

        switch(activeVM){
            case 1:
            vm1.resetChange();
            break;
            case 2:
            vm2.resetChange();
            break;
        }

        return formatted;

    }

    public String getSummaryTransactions() {

        Products[] slots = new Products[vm1.getMaxSlots()];
        Products[][] startingStock = new Products[vm1.getSlots().length][vm1.getMaxStock()];
        Products[][] currentStock = new Products[vm1.getSlots().length][vm1.getMaxStock()];

        switch(activeVM){
            case 1:
            slots = vm1.getSlots().clone();

            startingStock = vm1.getStartingStock().clone();
            for(int i = 0; i < startingStock.length; i++){
                startingStock[i] = vm1.getStartingStock()[i].clone();
            }

            currentStock = vm1.getCurrentStock().clone();
            for(int i = 0; i < currentStock.length; i++){
                currentStock[i] = vm1.getCurrentStock()[i].clone();
            }
            break;
            case 2:
            slots = vm2.getSlots().clone();

            startingStock = vm2.getStartingStock().clone();
            for(int i = 0; i < startingStock.length; i++){
                startingStock[i] = vm2.getStartingStock()[i].clone();
            }

            currentStock = vm2.getCurrentStock().clone();
            for(int i = 0; i < currentStock.length; i++){
                currentStock[i] = vm2.getCurrentStock()[i].clone();
            }
            break;
        }

        String formatted = "[Starting Inventory & Ending Inventory]\n\n";
        
        formatted += "_____________________\n\n";

        int currentStockCounter = 0;
        int startingStockCounter = 0;

        ArrayList<Integer> currentStockArr = new ArrayList<Integer>();
        ArrayList<Integer> startStockArr = new ArrayList<Integer>();

        switch(activeVM){
            case 1:
            for(int i = 0; i < vm1.getProductCount(); i++){

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
            break;
            case 2:
            for(int i = 0; i < vm2.getProductCount(); i++){

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
            break;
        }

        int moneyCollected = 0;

        switch(activeVM){
            case 1:
            for(int i = 0; i < vm1.getProductCount(); i++){
                moneyCollected += (startStockArr.get(i) - currentStockArr.get(i)) * slots[i].getPrice();
            }
            case 2:
            for(int i = 0; i < vm2.getProductCount(); i++){
                moneyCollected += (startStockArr.get(i) - currentStockArr.get(i)) * slots[i].getPrice();
            }

        }

        formatted += "Cash Amount (since last restock) : " + moneyCollected + " Php";
        return formatted;
    }

    public String toppingList(){
        String formatted = "List of Toppings Added:\n\n";

        for(int i = 0; i < addedCakeToppings.size(); i++){
            formatted += (i+1) + ".) " + addedCakeToppings.get(i).getName() + "\n";
        }

        return formatted;
    }

    public boolean addToCakeToppings(Products productAdded){

        boolean ret = true;

        for(int i = 0; i < addedCakeToppings.size(); i++){
            if(addedCakeToppings.get(i) == productAdded){
                ret = false;
            }
        }

        if(ret == true){
            addedCakeToppings.add(productAdded);
        }

        return ret;
    }


    public void removeAllToppings() {
        for(int i = 0; i < addedCakeToppings.size(); i++){
            addedCakeToppings.remove(i);
        }
    }
}