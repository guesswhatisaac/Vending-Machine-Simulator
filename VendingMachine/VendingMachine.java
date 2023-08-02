public class VendingMachine {
    
    private Products[] slots; // at least 8
    private int maxStock;
    private int[] stockInSlots;
    private Products[][] startingStock;
    private Products[][] currentStock;
    private int productCount;
    private int maxSlots;
    private Denominations currentDenom;
    private int[] changeReturned;

    public VendingMachine() {
        this.maxSlots = 10;
        this.slots = new Products[maxSlots];
        this.maxStock = 15;
        this.productCount = 0;
        this.stockInSlots = new int[maxSlots];
        this.startingStock = new Products[maxSlots][maxStock];
        this.currentStock = new Products[maxSlots][maxStock];
        this.currentDenom = new Denominations();
        this.changeReturned = new int[9];
    }

    public int addToSlots(Products productAdded) {

        boolean isAdded = false;
        
        // check if product is added already.
        for(int i = 0; i < productCount; i++){
            if(productAdded.getName() == slots[i].getName()){
                isAdded = true;
            }
        }
        
        if(productCount < maxSlots && !isAdded){
            slots[productCount] = productAdded;
            stockInSlots[productCount] = 0;
            productCount++;
            return 0;
        }
        else if(isAdded == true){
            return 1;
        }
        else{
            return 2;
        }
    }

    public int[] getStockInSlots() {
        return stockInSlots;
    }

    public boolean restockProduct(int productSlotIndex, int restockAmount) {

        // if restock amount + stock in product index is greater than max stock, return false
        if(restockAmount + stockInSlots[productSlotIndex] > maxStock){ 
            return false;
        }

        for(int i = 0; i < restockAmount; i++){
            Products productClone = slots[productSlotIndex];
            currentStock[productSlotIndex][stockInSlots[productSlotIndex]] = productClone;
            stockInSlots[productSlotIndex]++;
            
        }

        startingStock = currentStock.clone();
        for(int i = 0; i < startingStock.length; i++){
            startingStock[i] = startingStock[i].clone();
        }
        
        return true;
    }

    public void reduceStock(int productSoldIndex) {
        currentStock[productSoldIndex][stockInSlots[productSoldIndex]-1] = null;
        stockInSlots[productSoldIndex]--;
    }

    public Products[] getSlots() {
        return this.slots;
    }

    public int getProductCount() {
        return this.productCount;
    }

    public int getMaxSlots() {
        return this.maxSlots;
    }

    public Denominations getCurrentDenom() {
        return this.currentDenom;
    }

    public int getMaxStock(){
        return this.maxStock;
    }

    public int produceChange(int changeAmount){

        int changeProduced = 0, denomIndex = 0;
        int denom[] = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
        int denomCounter[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        // create temporary currentDenom tracker
        int tempDenom[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        tempDenom[0] = currentDenom.getDenom(1000);
        tempDenom[1] = currentDenom.getDenom(500);
        tempDenom[2] = currentDenom.getDenom(200);
        tempDenom[3] = currentDenom.getDenom(100);
        tempDenom[4] = currentDenom.getDenom(50);
        tempDenom[5] = currentDenom.getDenom(20);
        tempDenom[6] = currentDenom.getDenom(10);
        tempDenom[7] = currentDenom.getDenom(5);
        tempDenom[8] = currentDenom.getDenom(1);

        while((denomIndex != denom.length) && (changeAmount != changeProduced)){

            // check if denom+changeProduced is less than changeAmount
            while((denom[denomIndex]+changeProduced <= changeAmount) && (tempDenom[denomIndex] > 0)){
                if(changeAmount == changeProduced){
                    break;
                }
                else{
                    changeProduced += denom[denomIndex]; 
                    denomCounter[denomIndex]++;   
                    tempDenom[denomIndex]--;
                }
            }
            denomIndex++;
        }

        if(changeProduced == changeAmount){

            this.changeReturned = denomCounter;

            // decrement currentDenom by denomCounter
            for(int i = 0; i < denomCounter.length; i++){
                switch(i){
                    case 8: currentDenom.updateDenom(-1*denomCounter[i], 1);
                        break; 
                    case 7: currentDenom.updateDenom(-1*denomCounter[i], 5);
                        break;
                    case 6: currentDenom.updateDenom(-1*denomCounter[i], 10);
                        break; 
                    case 5: currentDenom.updateDenom(-1*denomCounter[i], 20);
                        break;
                    case 4: currentDenom.updateDenom(-1*denomCounter[i], 50);
                        break; 
                    case 3: currentDenom.updateDenom(-1*denomCounter[i], 100);
                        break;
                    case 2: currentDenom.updateDenom(-1*denomCounter[i], 200);
                        break; 
                    case 1: currentDenom.updateDenom(-1*denomCounter[i], 500);
                        break;
                    case 0: currentDenom.updateDenom(-1*denomCounter[i], 1000);
                        break; 
                }
            }

            return changeProduced;
        }

        return 0; // if change is not produced

    }

    public int[] getChangeReturned() {
        return this.changeReturned;
    }

    public void resetChange() {
        int reset[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        changeReturned = reset;
    }

    public Products[][] getStartingStock(){
        return this.startingStock;
    }

    public Products[][] getCurrentStock(){
        return this.currentStock;
    }

    public void debug(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 15; j++){
                if(startingStock[i][j] == null){
                    System.out.print("F ");
                }
                else{
                    System.out.print("T ");
                }
            }
            System.out.println();
        }

        System.out.println("==========");

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 15; j++){
                if(currentStock[i][j] == null){
                    System.out.print("F ");
                }
                else{
                    System.out.print("T ");
                }
            }
            System.out.println();
        }

    }
}



