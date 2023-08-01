import java.util.ArrayList;

public class Denominations { 

    private int c1000;
    private int c500;
    private int c200;
    private int c100;
    private int c50;
    private int c20;
    private int c10;
    private int c5;
    private int c1;

    /**
     * Constructs a new instance of the Denominations class with default values.
     */
    public Denominations() {
        this.c1000 = 0;
        this.c500 = 0;
        this.c200 = 0;
        this.c100 = 0;
        this.c50 = 0;
        this.c20 = 0;
        this.c10 = 0;
        this.c5 = 0;
        this.c1 = 0;
    }

    /**
     * Updates the denominations based on the provided ArrayList of denomination values.
     *
     * @param denoms the ArrayList of denomination values to update
     */
    public void updateDenom(ArrayList<Integer> denoms){

        for(int i = 0; i < denoms.size(); i++){
            switch(denoms.get(i)){
                case 1: c1++;
                    break;
                case 2: c5++;
                    break;
                case 3: c10++;
                    break;
                case 4: c20++;
                    break;
                case 5: c50++;
                    break;
                case 6: c100++;
                    break;
                case 7: c200++;
                    break;
                case 8: c500++;
                    break;
                case 9: c1000++;
                    break;
            }
        }

    }

    /**
     * Updates the specified denomination with the given count.
     *
     * @param count the count to update the denomination with
     * @param denomAmount the amount of the denomination to update
     */
    public void updateDenom(int count, int denomAmount){

        switch(denomAmount){
            case 1000: this.c1000 += count;
                break;
            case 500: this.c500 += count;
                break;
            case 200: this.c200 += count;
                break;
            case 100: this.c100 += count;
                break;
            case 50: this.c50 += count;
                break;
            case 20: this.c20 += count;
                break;
            case 10: this.c10 += count;
                break;
            case 5: this.c5 += count;
                break;
            case 1: this.c1 += count;
                break;
        }

    }

    /**
     * Retrieves the count of the specified denomination.
     *
     * @param denomAmount the amount of the denomination to retrieve the count for
     * 
     * @return the count of the specified denomination
     */
    public int getDenom(int denomAmount){
        
        int denomCount = 0;
        switch(denomAmount){
            case 1000: denomCount = this.c1000;
                break;
            case 500: denomCount = this.c500;
                break;
            case 200: denomCount = this.c200;
                break;
            case 100: denomCount = this.c100;
                break;
            case 50: denomCount = this.c50;
                break;
            case 20: denomCount = this.c20;
                break;
            case 10: denomCount = this.c10;
                break;
            case 5: denomCount = this.c5;
                break;
            case 1: denomCount = this.c1;
                break;
        }
        return denomCount;

    }

    /**
     * Calculates and retrieves the total amount of currency represented by the denominations.
     *
     * @return the total amount of currency
     */
    public int getTotal(){

        int total = 0;

        total += getDenom(1000) * 1000;
        total += getDenom(500) * 500;
        total += getDenom(200) * 200;
        total += getDenom(100) * 100;
        total += getDenom(50) * 50;
        total += getDenom(20) * 20;
        total += getDenom(10) * 10;
        total += getDenom(5) * 5;
        total += getDenom(1) * 1;

        return total;

    }

    /**
     * Collects all the money from the denominations then sets the value to 0 for each.
     *
     * @return the total amount of money collected
     */
    public int collectMoney() { 

        int cash = 0;

        cash += getDenom(1000) * 1000;
        updateDenom(-(this.c1000), 1000);
        
        cash += getDenom(500) * 500;
        updateDenom(-(this.c500), 500);

        cash += getDenom(200) * 200;
        updateDenom(-(this.c200), 200);

        cash += getDenom(100) * 100;
        updateDenom(-(this.c100), 100);

        cash += getDenom(50) * 50;
        updateDenom(-(this.c50), 50);

        cash += getDenom(20) * 20;
        updateDenom(-(this.c20), 20);

        cash += getDenom(10) * 10;
        updateDenom(-(this.c10), 10);

        cash += getDenom(5) * 5;
        updateDenom(-(this.c5), 5);

        cash += getDenom(1) * 1;
        updateDenom(-(this.c1), 1);

        return cash;
    }

    /**
     * Prints the count of each denomination.
     */
    public void printDenom() {

        System.out.println("1000 Pesos : " + "x" + this.c1000);
        System.out.println("500 Pesos : " + "x" + this.c500);
        System.out.println("200 Pesos : " + "x" + this.c200);
        System.out.println("100 Pesos : " + "x" + this.c100);
        System.out.println("50 Pesos : " + "x" + this.c50);
        System.out.println("20 Pesos : " + "x" + this.c20);
        System.out.println("10 Pesos : " + "x" + this.c10);
        System.out.println("5 Pesos : " + "x" + this.c5);
        System.out.println("1 Peso : " + "x" + this.c1);
    }

}