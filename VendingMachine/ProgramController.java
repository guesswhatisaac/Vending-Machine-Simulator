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
                if(/*view.getModifyTF()*/){
                    // product is modified successfully
                }
                else{
                    // product in that index does not exist
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
                System.out.println("TODO");
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
                view.testFeaturesMenu();
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

}
