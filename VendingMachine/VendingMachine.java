public class VendingMachine {
    
    private Products[] slots; // at least 8
    private int productCount;
    private int[] startingStock;
    private int maxSlots;
    private Denominations currentDenom;

    public VendingMachine() {
        this.maxSlots = 10;
        this.productCount = 0;
        this.slots = new Products[maxSlots];
        this.startingStock = new int[10];
        this.currentDenom = new Denominations();
    }

    public boolean addToSlots(Products productAdded) {

        if(productCount < maxSlots){
            slots[productCount] = productAdded;
            productCount++;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean restockProduct(Products productRestocked, int restockAmount) {

        return true;
    }

    public Products[] getSlots() {
        return this.slots;
    }

    public int getProductCount() {
        return this.productCount;
    }

    public int[] getStartingStock() {
        return this.startingStock;
    }

    public int getMaxSlots() {
        return this.maxSlots;
    }

    public Denominations getCurrentDenom() {
        return this.currentDenom;
    }

}

