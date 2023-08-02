public class VendingMachine {
    
    private Products[] slots; // at least 8
    private int maxStock;
    private int[] stockInSlots;
    private Products[][] startingStock;
    private int productCount;
    private int maxSlots;
    private Denominations currentDenom;

    public VendingMachine() {
        this.maxSlots = 10;
        this.slots = new Products[maxSlots];
        this.maxStock = 15;
        this.productCount = 0;
        this.stockInSlots = new int[maxSlots];
        this.startingStock = new Products[maxSlots][maxStock];
        this.currentDenom = new Denominations();
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
            System.out.println(i);
            Products productClone = slots[productSlotIndex];
            startingStock[productSlotIndex][stockInSlots[productSlotIndex]] = productClone;
            stockInSlots[productSlotIndex]++;
        }

        return true;
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

}

