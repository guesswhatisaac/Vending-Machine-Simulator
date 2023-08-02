import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramController {
    private ProgramModel model;
    private ProgramView view;

    public ProgramController(ProgramView view, ProgramModel model) {
        this.model = model;
        this.view = view;

        view.mainMenu();

        // MAIN MENU --------------------------

        view.setCreateVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Moving to Create VM Menu...");
                view.createMenu();
            }
        });

        view.setTestVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Moving to Test VM Menu...");
    
                if(model.getVendingMachine() == null){
                    System.out.println("Vending Machine not found.");
                    view.setFeedback("Vending Machine not found.");
                }
                else{
                    view.testMenu();
                }

            }
        });

        view.setExitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting Program...");
                System.exit(0);
            }
        });

        view.setRegularVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Creating Regular VM...");
        
                if(model.getVendingMachine() == null){
                    System.out.println("Regular Vending Machine Created!");   
                    view.setFeedback("Regular Vending Machine Created!");
                }
                else{
                    System.out.println("Regular Vending Machine Created! Old VM is dispensed.");
                    view.setFeedback("Regular Vending Machine Created! Old VM is dispensed.");
                }
                model.createRegularVM();

            }
        });

        view.setSpecialVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Creating Special VM...");

                if(model.getVendingMachine() == null){
                    System.out.println("Special Vending Machine Created!");   
                    view.setFeedback("Special Vending Machine Created");
                }
                else{
                    System.out.println("Special Vending Machine Created! Old VM is dispensed.");
                    view.setFeedback("Special Vending Machine Created! Old VM is dispensed.");
                }
                model.createSpecialVM();   
            }
        });
        
        view.setReturnToMainBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Returning to Main Menu...");
                view.mainMenu();
            }
        });

        // TEST MENU ---------------------

        model.initializeProducts();

        view.setMaintenanceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Moving to Maintenance Menu...");
                view.setMachineDetails(model.getMachineDetails());
                view.maintenanceMenu();   
            }
        });

        view.setModifyProductsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Moving to Modify Products Menu...");
                view.modifyProductsMenu();
            }
        });
        
        view.setUpdateProductBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(model.updateVendingProduct(view.getModifyTF())){
                    view.setMachineDetails(model.getMachineDetails());
                    view.modifyProductsMenu();
                    System.out.println("Products modified succesfully!");
                    view.setFeedback("Products modified succesfully!");
                }
                else{
                    System.out.println("Products modification unsuccessful. Invalid input detected.");
                    view.setFeedback("Products modification unsuccessful. Invalid input detected.");
                }
            }
        });

        view.setCollectPaymentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Moving to Collect Payment Menu...");
                view.setMachineDetails(model.getDenomDetails());
                view.collectMoneyMenu();
            }
        });

        view.setCollectMoneyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.getVendingMachine().getCurrentDenom().collectMoney();
                view.setMachineDetails(model.getDenomDetails());
                view.collectMoneyMenu();
                System.out.println("Money collected.");
                view.setFeedback("Money collected.");
                
            }
        });

        view.setReplenishMoneyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Moving to Replenish Money Menu...");
                view.setMachineDetails(model.getDenomDetails());
                view.replenishMoneyMenu();
            }
        });

        view.setUpdateDenomBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(model.updateVendingDenom(view.getDenomTF())){
                    view.setMachineDetails(model.getDenomDetails());
                    view.replenishMoneyMenu();
                    view.setFeedback("Denominations updated.");
                    System.out.println("Denominations updated.");
                }
                else{
                    view.replenishMoneyMenu();
                    view.setFeedback("Invalid input exists in text field.");
                    System.out.println("Invalid input exists in text field.");
                }
            }
        });

        view.setTransactionSummaryBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Moving to Transaction Summary Menu...");
                view.setSummaryTransactions(model.getSummaryTransactions());
                view.transactionSummaryMenu();
            }
        });

        view.setAddToSlotsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Moving to Add to Slots Menu...");
                view.addToSlotsMenu(model.getProductList(), model.getProductIndex());
                view.setMachineDetails(model.getMachineDetails());
            }
        });

        view.setPrevBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(model.getProductIndex() != 0){
                    model.updateProductIndex(-1);
                    view.setMachineDetails(model.getMachineDetails());
                    view.addToSlotsMenu(model.getProductList(), model.getProductIndex());
                }
                else{
                    System.out.println("No products left in the previous index.");
                    view.setFeedback("No products left in the previous index.");
                }
            }
        });

        view.setNextBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if((model.getProductIndex()+1) < model.getProductList().length){
                    model.updateProductIndex(1);
                    view.setMachineDetails(model.getMachineDetails());
                    view.addToSlotsMenu(model.getProductList(), model.getProductIndex());
                }
                else{
                    System.out.println("No products left in the following index.");
                    view.setFeedback("No products left in the following index.");
                }
                
            }
        });

        view.setAddBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(model.addProduct(model.getProductList()[model.getProductIndex()]) == 0){
                    String productName = model.getProductList()[model.getProductIndex()].getName();
                    System.out.println( productName + " to the vending machine!");
                    view.setFeedback( productName + " added to the vending machine!");  
                    view.setMachineDetails(model.getMachineDetails());
                    view.addToSlotsMenu(model.getProductList(), model.getProductIndex());
                }
                else if(model.addProduct(model.getProductList()[model.getProductIndex()]) == 1){
                    System.out.println("Product added already.");
                    view.setFeedback("Product added already.");  
                }
                else if((model.addProduct(model.getProductList()[model.getProductIndex()]) == 2 )){
                    System.out.println("No more slots left.");
                    view.setFeedback("No more slots left.");  
                }

            }
        });
        
        view.setReturnToMaintenanceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                view.setMachineDetails(model.getMachineDetails());
                view.maintenanceMenu();
            }
        });

        view.setTestFeaturesBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Moving to Test Menu...");
                view.testFeaturesMenu(model.getVendingMachine());
            }
        });

        
        view.setProduct1BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                productButton(0);
            }
        });

        view.setProduct2BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                productButton(1);
            }
        });

        view.setProduct3BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                productButton(2);
            }
        });        

        view.setProduct4BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                productButton(3);
            }
        });

        view.setProduct5BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                productButton(4);
            }
        });

        view.setProduct6BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                productButton(5);
            }
        });

        view.setProduct7BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                productButton(6);
            }
        });

        view.setProduct8BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                productButton(7);
            }
        });

        view.setProduct9BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                productButton(8);
            }
        });

        view.setProduct10BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                productButton(9);
            }
        });

        view.setC1000PayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.getUserDenom().updateDenom(1, 1000);
                view.setPayDetails(model.getPayDetails());
                view.payMenu(model.getVendingMachine());
            }
        });

        view.setC500PayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.getUserDenom().updateDenom(1, 500);
                view.setPayDetails(model.getPayDetails());
                view.payMenu(model.getVendingMachine());
            }
        });

        view.setC200PayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.getUserDenom().updateDenom(1, 200);
                view.setPayDetails(model.getPayDetails());
                view.payMenu(model.getVendingMachine());
            }
        });

        view.setC100PayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.getUserDenom().updateDenom(1, 100);
                view.setPayDetails(model.getPayDetails());
                view.payMenu(model.getVendingMachine());
            }
        });

        view.setC50PayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.getUserDenom().updateDenom(1, 50);
                view.setPayDetails(model.getPayDetails());
                view.payMenu(model.getVendingMachine());
            }
        });

        view.setC20PayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.getUserDenom().updateDenom(1, 20);
                view.setPayDetails(model.getPayDetails());
                view.payMenu(model.getVendingMachine());
            }
        });

        view.setC10PayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.getUserDenom().updateDenom(1, 10);
                view.setPayDetails(model.getPayDetails());
                view.payMenu(model.getVendingMachine());
            }
        });

        view.setC5PayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.getUserDenom().updateDenom(1, 5);
                view.setPayDetails(model.getPayDetails());
                view.payMenu(model.getVendingMachine());
            }
        });

        view.setC1PayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.getUserDenom().updateDenom(1, 1);
                view.setPayDetails(model.getPayDetails());
                view.payMenu(model.getVendingMachine());
            }
        });

        view.setPayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                int result = model.transact();

                if(result == 2){
                    System.out.println("Product purchased successfully.");
                    view.setPayDetails(model.getPayDetails());
                    view.recieptMenu(model.generateReceipt());
                }
                else if(result == 1){
                    System.out.println("Vending Machine cannot produce change.");
                    view.setFeedback("Vending Machine cannot produce change.");  
                }
                else if(result == 0){
                    System.out.println("Not enough money to purchase item.");
                    view.setFeedback("Not enough money to purchase item.");  
                }
            }
        });

        view.setReturnToTransactBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Returning to Transact Menu...");
                view.testFeaturesMenu(model.getVendingMachine());
            }
        });

        view.setReturnToTestBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Returning to Test Menu...");
                view.testMenu();
            }
        });
    }

    public void productButton(int buttonVal){
        if(model.getVendingMachine().getSlots()[buttonVal] != null && model.getVendingMachine().getStockInSlots()[buttonVal] != 0){
            model.setProductToBeSold(model.getVendingMachine().getSlots()[buttonVal]);
            model.getUserDenom().collectMoney();
            view.setPayDetails(model.getPayDetails());
            view.payMenu(model.getVendingMachine());
        }
        else if(model.getVendingMachine().getSlots()[buttonVal] != null && model.getVendingMachine().getStockInSlots()[buttonVal] == 0){
            System.out.println("No stock left.");
            view.setFeedback("No stock left.");  
        }
        else{
            System.out.println("Empty Slot.");
            view.setFeedback("Empty Slot.");  
        }
    }

}
