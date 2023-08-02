import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class ProgramView {

	private JFrame mainFrame;

    // misc components
    JLabel feedback = new JLabel("");
    JButton returnToMainBtn = new JButton("Return");
    JButton returnToTestBtn = new JButton("Return");
    JButton returnToMaintenanceBtn = new JButton("Return");
    JButton returnToTransactBtn = new JButton("Return");

    // main menu components
    JLabel title = new JLabel("");
    JButton createVM = new JButton("Create Vending Machine");
    JButton testVM = new JButton("Test Vending Machine");
    JButton exit = new JButton("Exit");

    // create VM components
    JButton regularVM = new JButton("Regular Vending Machine");
    JButton specialVM = new JButton("Special Vending Machine");

    // test VM components
    JButton testFeatures = new JButton("Test Features");
    JButton maintenance = new JButton("Maintenance");
    
    // maintenance components
    JTextArea machineDetails = new JTextArea("");
    JButton modifyProducts = new JButton("Modify Products");
    JButton collectPayment = new JButton("Collect Payment");
    JButton replenishMoney = new JButton("Replenish Money");
    JButton transactionSummary = new JButton("Transaction Summary");
    JButton addToSlots = new JButton("Add to Slots");

    JLabel productInfo = new JLabel("");
    JButton prev = new JButton("Previous");
    JButton next = new JButton("Next");
    JButton add = new JButton("Add"); 

    JTextField c1000tf = new JTextField();
    JTextField c500tf = new JTextField();
    JTextField c200tf = new JTextField();
    JTextField c100tf = new JTextField();
    JTextField c50tf = new JTextField();
    JTextField c20tf = new JTextField();
    JTextField c10tf = new JTextField();
    JTextField c5tf = new JTextField();
    JTextField c1tf = new JTextField();

    JLabel c1000l = new JLabel("1000 Php");
    JLabel c500l = new JLabel("500 Php");
    JLabel c200l = new JLabel("200 Php");
    JLabel c100l = new JLabel("100 Php");
    JLabel c50l = new JLabel("50 Php");
    JLabel c20l = new JLabel("20 Php");
    JLabel c10l = new JLabel("10 Php");
    JLabel c5l = new JLabel("5 Php");
    JLabel c1l = new JLabel("1 Php");

    JButton updateDenom = new JButton("Update");
    JButton collectMoney = new JButton("Collect Money");

    JTextField slotTf = new JTextField();
    JTextField restockAmountTf = new JTextField();
    JTextField updatedPriceTf = new JTextField();

    JLabel slotLbl = new JLabel("Modify Slot");
    JLabel restockAmountLbl = new JLabel("Restock Amount");
    JLabel updatedPriceLbl = new JLabel("Updated Price");

    JButton updateProduct = new JButton("Update");

    JButton product1 = new JButton("[1]: Empty");
    JButton product2 = new JButton("[2]: Empty");
    JButton product3 = new JButton("[3]: Empty");
    JButton product4 = new JButton("[4]: Empty");
    JButton product5 = new JButton("[5]: Empty");
    JButton product6 = new JButton("[6]: Empty");
    JButton product7 = new JButton("[7]: Empty");
    JButton product8 = new JButton("[8]: Empty");
    JButton product9 = new JButton("[9]: Empty");
    JButton product10 = new JButton("[10]: Empty");

    JLabel product1Lbl = new JLabel("(0x)");
    JLabel product2Lbl = new JLabel("(0x)");    
    JLabel product3Lbl = new JLabel("(0x)");
    JLabel product4Lbl = new JLabel("(0x)");
    JLabel product5Lbl = new JLabel("(0x)");
    JLabel product6Lbl = new JLabel("(0x)");
    JLabel product7Lbl = new JLabel("(0x)");
    JLabel product8Lbl = new JLabel("(0x)");
    JLabel product9Lbl = new JLabel("(0x)");
    JLabel product10Lbl = new JLabel("(0x)");

    JButton c1000Pay = new JButton("1000 Php");
    JButton c500Pay = new JButton("500 Php");
    JButton c200Pay = new JButton("200 Php");
    JButton c100Pay = new JButton("100 Php");
    JButton c50Pay = new JButton("50 Php");
    JButton c20Pay = new JButton("20 Php");
    JButton c10Pay = new JButton("10 Php");
    JButton c5Pay = new JButton("5 Php");
    JButton c1Pay = new JButton("1 Php");

    JButton pay = new JButton("Pay");
    JTextArea payArea = new JTextArea();

    JTextArea reciept = new JTextArea();

    JTextArea summaryTransactions = new JTextArea();

    public ProgramView() {
        this.mainFrame = new JFrame("Vending Machine Simulator");
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(1000, 850);
        this.mainFrame.setVisible(true);
    }

    // MAIN MENU --------------------------

    public void mainMenu() {

        refreshFrame();

        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(0, 1, 7, 7));

        JPanel panel3 = new JPanel();


        // add components to panel
        title = new JLabel("Vending Machine Simulator");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        panel1.add(title);
        panel2.add(createVM);
        panel2.add(testVM);
        panel2.add(exit);       
        panel3.add(feedback);
        
        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.CENTER);
        mainFrame.add(panel3, BorderLayout.SOUTH);

    }

    public void createMenu(){

        refreshFrame();

        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(0, 1, 7, 7));
        
        JPanel panel3 = new JPanel();

        // add components to panel
        title = new JLabel("Create Vending Machine");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        panel1.add(title);
        panel2.add(regularVM);
        panel2.add(specialVM);
        panel2.add(returnToMainBtn);        
        panel3.add(feedback);
        
        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.CENTER);
        mainFrame.add(panel3, BorderLayout.SOUTH);

    }

    // TEST VM MENU ----------------------------

    public void testMenu(){

        refreshFrame();

        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(0, 1, 7, 7));
        
        JPanel panel3 = new JPanel();

        // add components to panel
        title = new JLabel("Test Vending Machine");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        panel1.add(title);
        panel2.add(testFeatures);
        panel2.add(maintenance);
        panel2.add(returnToMainBtn);        
        panel3.add(feedback);
        
        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.CENTER);
        mainFrame.add(panel3, BorderLayout.SOUTH);

    }

    public void maintenanceMenu(){

        refreshFrame();

        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(0, 2, 7, 7));
        
        JPanel panel3 = new JPanel();

        JPanel panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel4.setLayout(new GridBagLayout()); 

        // add components to panel
        title = new JLabel("Maintenance Menu");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        panel1.add(title);
        panel2.add(modifyProducts);
        panel2.add(collectPayment);
        panel2.add(replenishMoney);
        panel2.add(transactionSummary);
        panel2.add(addToSlots);
        panel2.add(returnToTestBtn);        
        panel3.add(feedback);
        panel4.add(machineDetails);

        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.gray);
        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.EAST);
        mainFrame.add(panel3, BorderLayout.SOUTH);
        mainFrame.add(panel4);

    }

    public void addToSlotsMenu(Products[] productList, int productIndex) {
        
        refreshFrame();

        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(0, 1, 7, 7));
        panel2.setPreferredSize(new Dimension(330, 100));
        
        JPanel panel3 = new JPanel();

        JPanel panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel4.setLayout(new GridBagLayout()); 

        JPanel panel5 = new JPanel(); 
        panel5.setPreferredSize(new Dimension(150, 150));

        // add components to panel
        title = new JLabel("Maintenance Menu");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        productInfo.setText(productList[productIndex].getName() + " | " +
                             productList[productIndex].getPrice() + " Php | " + 
                            "( " + productList[productIndex].getCalories() + "cal )");

        productInfo.setFont(new Font("Arial", Font.BOLD, 15));

        panel1.add(title);
        panel2.add(productInfo);
        panel5.add(prev);
        panel5.add(add);
        panel5.add(next);
        panel5.add(returnToMaintenanceBtn);    
        panel2.add(panel5, BorderLayout.SOUTH);
        panel3.add(feedback);
        panel4.add(machineDetails);

        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.gray);
        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.EAST);
        mainFrame.add(panel3, BorderLayout.SOUTH);
        mainFrame.add(panel4);

    }

    public void replenishMoneyMenu(){
        
        refreshFrame();
        refreshDenomTF();
 
        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(0, 2, 7, 7));
        panel2.setPreferredSize(new Dimension(330, 100));
        
        JPanel panel3 = new JPanel();

        JPanel panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel4.setLayout(new GridBagLayout()); 

        JPanel panel5 = new JPanel(); 
        panel5.setLayout(new GridLayout(2, 3, 7, 7));
        panel5.setSize(new Dimension(300, 150));

        // add components to panel
        title = new JLabel("Maintenance Menu");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        panel1.add(title);

        panel2.add(c1000tf);
        panel2.add(c1000l);
        panel2.add(c500tf);
        panel2.add(c500l);
        panel2.add(c200tf);
        panel2.add(c200l);
        panel2.add(c100tf);
        panel2.add(c100l);
        panel2.add(c50tf);
        panel2.add(c50l);
        panel2.add(c20tf);
        panel2.add(c20l);
        panel2.add(c10tf);
        panel2.add(c10l);
        panel2.add(c5tf);
        panel2.add(c5l);
        panel2.add(c1tf);
        panel2.add(c1l);

        panel5.add(updateDenom);
        panel5.add(returnToMaintenanceBtn);
        panel2.add(panel5);

        panel3.add(feedback);
        panel4.add(machineDetails);

        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.gray);
        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.EAST);
        mainFrame.add(panel3, BorderLayout.SOUTH);
        mainFrame.add(panel4);

    }

    public void collectMoneyMenu(){
        
        refreshFrame();
 
        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(0, 1, 7, 7));
        panel2.setPreferredSize(new Dimension(330, 100));
        
        JPanel panel3 = new JPanel();

        JPanel panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel4.setLayout(new GridBagLayout()); 

        JPanel panel5 = new JPanel(); 
        panel5.setLayout(new GridLayout(2, 3, 7, 7));
        panel5.setSize(new Dimension(300, 150));

        // add components to panel
        title = new JLabel("Maintenance Menu");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        panel1.add(title);
        panel5.add(returnToMaintenanceBtn);    
        
        panel5.add(collectMoney);
        panel5.add(returnToMaintenanceBtn);
        panel2.add(panel5);

        panel3.add(feedback);
        panel4.add(machineDetails);

        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.gray);
        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.EAST);
        mainFrame.add(panel3, BorderLayout.SOUTH);
        mainFrame.add(panel4);

    }

    public void modifyProductsMenu(){
     
        refreshFrame();
        refreshModifyTF();
 
        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(0, 2, 7, 7));
        panel2.setPreferredSize(new Dimension(330, 100));
        
        JPanel panel3 = new JPanel();

        JPanel panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel4.setLayout(new GridBagLayout()); 

        JPanel panel5 = new JPanel(); 
        panel5.setLayout(new GridLayout(2, 3, 7, 7));
        panel5.setSize(new Dimension(300, 150));

        // add components to panel
        title = new JLabel("Maintenance Menu");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        panel1.add(title);

        panel2.add(slotTf);
        panel2.add(slotLbl);
        panel2.add(restockAmountTf);
        panel2.add(restockAmountLbl);
        panel2.add(updatedPriceTf);
        panel2.add(updatedPriceLbl);
        
        panel5.add(updateProduct);
        panel5.add(returnToMaintenanceBtn);
        panel2.add(panel5);

        panel3.add(feedback);
        panel4.add(machineDetails);

        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.gray);
        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.EAST);
        mainFrame.add(panel3, BorderLayout.SOUTH);
        mainFrame.add(panel4);

    }

    public void testFeaturesMenu(VendingMachine vm){
        
        refreshFrame();

        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        // panels for product buttons buttons
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(2, 5, 7, 7));
        
        JPanel panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel4.setLayout(new GridLayout(2, 5, 7, 7));

        JPanel panel5 = new JPanel();
        panel5.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel5.setLayout(new GridLayout(1, 0, 7, 7));

        // container for panel 2 4 and 5
        JPanel panel6 = new JPanel();
        panel6.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel6.setLayout(new GridLayout(3, 1, 7, 7));

        // panel for error messages
        JPanel panel3 = new JPanel();

        // add components to panel
        title = new JLabel("Transact Menu");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        // initialize product_button names & label
        switch(vm.getProductCount()){
            case 10: 
                product10.setText("[10]: " + vm.getSlots()[9].getName());
                product10Lbl.setText("(" + vm.getStockInSlots()[9] + "x) " + vm.getSlots()[9].getCalories() + " cal");
            case 9:
                product9.setText("[9]: " + vm.getSlots()[8].getName());
                product9Lbl.setText("(" + vm.getStockInSlots()[8] + "x) " + vm.getSlots()[8].getCalories() + " cal");
            case 8:
                product8.setText("[8]: " + vm.getSlots()[7].getName());
                product8Lbl.setText("(" + vm.getStockInSlots()[7] + "x) " + vm.getSlots()[7].getCalories() + " cal");
            case 7:
                product7.setText("[7]: " + vm.getSlots()[6].getName());
                product7Lbl.setText("(" + vm.getStockInSlots()[6] + "x) " + vm.getSlots()[6].getCalories() + " cal");
            case 6:
                product6.setText("[6]: " + vm.getSlots()[5].getName());
                product6Lbl.setText("(" + vm.getStockInSlots()[5] + "x) " + vm.getSlots()[5].getCalories() + " cal");
            case 5:
                product5.setText("[5]: " + vm.getSlots()[4].getName());
                product5Lbl.setText("(" + vm.getStockInSlots()[4] + "x) " + vm.getSlots()[4].getCalories() + " cal");
            case 4:
                product4.setText("[4]: " + vm.getSlots()[3].getName());
                product4Lbl.setText("(" + vm.getStockInSlots()[3] + "x) " + vm.getSlots()[3].getCalories() + " cal");
            case 3:
                product3.setText("[3]: " + vm.getSlots()[2].getName());
                product3Lbl.setText("(" + vm.getStockInSlots()[2] + "x) " + vm.getSlots()[2].getCalories() + " cal");
            case 2:
                product2.setText("[2]: " + vm.getSlots()[1].getName());
                product2Lbl.setText("(" + vm.getStockInSlots()[1] + "x) " + vm.getSlots()[1].getCalories() + " cal");
            case 1:
                product1.setText("[1]: " + vm.getSlots()[0].getName());
                product1Lbl.setText("(" + vm.getStockInSlots()[0] + "x) " + vm.getSlots()[0].getCalories() + " cal");
                break;
            case 0:
                System.out.println("No products in the vending machine.");
        }

        panel1.add(title);

        panel2.add(product1Lbl);
        panel2.add(product2Lbl);
        panel2.add(product3Lbl);
        panel2.add(product4Lbl);
        panel2.add(product5Lbl);
        panel2.add(product1);
        panel2.add(product2);
        panel2.add(product3);
        panel2.add(product4);
        panel2.add(product5);

        panel4.add(product6Lbl);
        panel4.add(product7Lbl);
        panel4.add(product8Lbl);
        panel4.add(product9Lbl);
        panel4.add(product10Lbl);
        panel4.add(product6);
        panel4.add(product7);
        panel4.add(product8);
        panel4.add(product9);
        panel4.add(product10);

        panel5.add(returnToTestBtn);        
        panel3.add(feedback);

        panel2.setPreferredSize(new Dimension(100, 150));
        panel4.setPreferredSize(new Dimension(100, 150));

        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);

        panel2.setBackground(Color.lightGray);
        panel4.setBackground(Color.lightGray);

        panel6.add(panel2);
        panel6.add(panel4);
        panel6.add(panel5);

        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel6, BorderLayout.CENTER);
        mainFrame.add(panel3, BorderLayout.SOUTH);
    }

    public void payMenu(VendingMachine vm){
        
        refreshFrame();

        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        // panels for product buttons buttons
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(2, 5, 7, 7));

        JPanel panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel4.setLayout(new GridLayout(1, 0, 7, 7));

        JPanel panel5 = new JPanel();
        panel5.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel5.setLayout(new GridLayout(1, 0, 7, 7));

        // container for panel 2 4 and 5
        JPanel panel6 = new JPanel();
        panel6.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel6.setLayout(new GridLayout(3, 1, 7, 7));

        // panel for error messages
        JPanel panel3 = new JPanel();

        // add components to panel
        title = new JLabel("Payment Menu");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        // initialize product_button names & label

        panel1.add(title);

        panel2.add(c1000Pay);
        panel2.add(c500Pay);
        panel2.add(c200Pay);
        panel2.add(c100Pay);
        panel2.add(c50Pay);
        panel2.add(c20Pay);
        panel2.add(c10Pay);
        panel2.add(c5Pay);
        panel2.add(c1Pay);

        panel4.add(payArea);
        panel5.add(pay);
        panel5.add(returnToTransactBtn);        
        panel3.add(feedback);

        panel2.setPreferredSize(new Dimension(300, 300));

        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.lightGray);

        panel6.add(panel2);
        panel6.add(panel4);
        panel6.add(panel5);

        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel6, BorderLayout.CENTER);
        mainFrame.add(panel3, BorderLayout.SOUTH);
    }

    public void recieptMenu(String formattedReceipt) {

        refreshFrame();

        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(2, 0, 7, 7));
        
        JPanel panel3 = new JPanel();

        // add components to panel
        title = new JLabel("Reciept");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        reciept.setText(formattedReceipt);
        panel1.add(title);
        panel2.add(reciept);
        panel2.add(returnToTestBtn);        
        panel3.add(feedback);

        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.CENTER);
        mainFrame.add(panel3, BorderLayout.SOUTH);
    }

    public void transactionSummaryMenu() {
        
        refreshFrame();
 
        // create panel
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        panel1.setLayout(new BorderLayout(0, 1)); 
    
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setLayout(new GridLayout(0, 1, 7, 7));
        panel2.setPreferredSize(new Dimension(330, 100));
        
        JPanel panel3 = new JPanel();

        JPanel panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel4.setLayout(new GridBagLayout()); 

        JPanel panel5 = new JPanel(); 
        panel5.setLayout(new GridLayout(2, 3, 7, 7));
        panel5.setSize(new Dimension(300, 150));

        // add components to panel
        title = new JLabel("Maintenance Menu");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        panel1.add(title);
        panel5.add(returnToMaintenanceBtn);
        panel2.add(panel5);
        panel3.add(feedback);
        panel4.add(summaryTransactions);

        //add components
        panel1.setBackground(Color.darkGray);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.gray);
        mainFrame.add(panel1, BorderLayout.NORTH);
        mainFrame.add(panel2, BorderLayout.EAST);
        mainFrame.add(panel3, BorderLayout.SOUTH);
        mainFrame.add(panel4);

    }


    // BUTTON LISTENERS --------------------------

	public void setCreateVMBtnListener(ActionListener actionListener) {
		this.createVM.addActionListener(actionListener);
	}
    
	public void setTestVMBtnListener(ActionListener actionListener) {
		this.testVM.addActionListener(actionListener);
	}

    public void setExitBtnListener(ActionListener actionListener) {
		this.exit.addActionListener(actionListener);
	}

    public void setRegularVMBtnListener(ActionListener actionListener) {
		this.regularVM.addActionListener(actionListener);
	}

    public void setSpecialVMBtnListener(ActionListener actionListener) {
		this.specialVM.addActionListener(actionListener);
    }

    public void setReturnToMainBtnListener(ActionListener actionListener) {
		this.returnToMainBtn.addActionListener(actionListener);
	}

    public void setTestFeaturesBtnListener(ActionListener actionListener) {
		this.testFeatures.addActionListener(actionListener);
    }

    public void setMaintenanceListener(ActionListener actionListener) {
		this.maintenance.addActionListener(actionListener);
	}

    public void setReturnToTestBtnListener(ActionListener actionListener) {
		this.returnToTestBtn.addActionListener(actionListener);
	}
    
    public void setModifyProductsBtnListener(ActionListener actionListener) {
		this.modifyProducts.addActionListener(actionListener);
	}

    public void setCollectPaymentListener(ActionListener actionListener) {
		this.collectPayment.addActionListener(actionListener);
	}
    
    public void setReplenishMoneyListener(ActionListener actionListener) {
		this.replenishMoney.addActionListener(actionListener);
	}

    public void setTransactionSummaryBtnListener(ActionListener actionListener) {
		this.transactionSummary.addActionListener(actionListener);
	}

    public void setAddToSlotsBtnListener(ActionListener actionListener) {
		this.addToSlots.addActionListener(actionListener);
	}

    public void setReturnToMaintenanceBtnListener(ActionListener actionListener) {
		this.returnToMaintenanceBtn.addActionListener(actionListener);
	}

    public void setPrevBtnListener(ActionListener actionListener) {
		this.prev.addActionListener(actionListener);
	}

    public void setNextBtnListener(ActionListener actionListener) {
		this.next.addActionListener(actionListener);
	}

    public void setAddBtnListener(ActionListener actionListener) {
		this.add.addActionListener(actionListener);
	}

    public void setUpdateDenomBtnListener(ActionListener actionListener) {
		this.updateDenom.addActionListener(actionListener);
	}

    public void setCollectMoneyBtnListener(ActionListener actionListener) {
		this.collectMoney.addActionListener(actionListener);
	}

    public void setUpdateProductBtnListener(ActionListener actionListener) {
		this.updateProduct.addActionListener(actionListener);
	}

    public void setProduct1BtnListener(ActionListener actionListener) {
		this.product1.addActionListener(actionListener);
	}

    public void setProduct2BtnListener(ActionListener actionListener) {
		this.product2.addActionListener(actionListener);
	}

    public void setProduct3BtnListener(ActionListener actionListener) {
		this.product3.addActionListener(actionListener);
	}    

    public void setProduct4BtnListener(ActionListener actionListener) {
		this.product4.addActionListener(actionListener);
	}

    public void setProduct5BtnListener(ActionListener actionListener) {
		this.product5.addActionListener(actionListener);
	}

    public void setProduct6BtnListener(ActionListener actionListener) {
		this.product6.addActionListener(actionListener);
	}

    public void setProduct7BtnListener(ActionListener actionListener) {
		this.product7.addActionListener(actionListener);
	}

    public void setProduct8BtnListener(ActionListener actionListener) {
		this.product8.addActionListener(actionListener);
	}

    public void setProduct9BtnListener(ActionListener actionListener) {
		this.product9.addActionListener(actionListener);
	}

    public void setProduct10BtnListener(ActionListener actionListener) {
		this.product10.addActionListener(actionListener);
	}

    public void setReturnToTransactBtnListener(ActionListener actionListener) {
		this.returnToTransactBtn.addActionListener(actionListener);
	}

    public void setC1000PayBtnListener(ActionListener actionListener) {
		this.c1000Pay.addActionListener(actionListener);
	}

    public void setC500PayBtnListener(ActionListener actionListener) {
		this.c500Pay.addActionListener(actionListener);
	}

    public void setC200PayBtnListener(ActionListener actionListener) {
		this.c200Pay.addActionListener(actionListener);
	}

    public void setC100PayBtnListener(ActionListener actionListener) {
		this.c100Pay.addActionListener(actionListener);
	}

    public void setC50PayBtnListener(ActionListener actionListener) {
		this.c50Pay.addActionListener(actionListener);
	}

    public void setC20PayBtnListener(ActionListener actionListener) {
		this.c20Pay.addActionListener(actionListener);
	}

    public void setC10PayBtnListener(ActionListener actionListener) {
		this.c10Pay.addActionListener(actionListener);
	}

    public void setC5PayBtnListener(ActionListener actionListener) {
		this.c5Pay.addActionListener(actionListener);
	}

    public void setC1PayBtnListener(ActionListener actionListener) {
		this.c1Pay.addActionListener(actionListener);
	}

    public void setPayBtnListener(ActionListener actionListener) {
		this.pay.addActionListener(actionListener);
	}

    // MISC ---------------------

    public void setPayDetails(String formatted) {
        payArea.setText(formatted);
    }

    public JTextField[] getDenomTF() {
        
        JTextField[] arr = new JTextField[9];

        arr[0] = c1000tf;
        arr[1] = c500tf;
        arr[2] = c200tf;
        arr[3] = c100tf;
        arr[4] = c50tf;
        arr[5] = c20tf;
        arr[6] = c10tf;
        arr[7] = c5tf;
        arr[8] = c1tf;

        return arr;
    }

    public JTextField[] getModifyTF() {

        JTextField[] arr = new JTextField[3];

        arr[0] = slotTf;
        arr[1] = restockAmountTf;
        arr[2] = updatedPriceTf;
        
        return arr;
    }

    public void refreshModifyTF() {
        slotTf.setText("");
        restockAmountTf.setText("");
        updatedPriceTf.setText("");
    }

    public void refreshDenomTF() {
        c1000tf.setText("0");
        c500tf.setText("0");
        c200tf.setText("0");
        c100tf.setText("0");
        c50tf.setText("0");
        c20tf.setText("0");
        c10tf.setText("0");
        c5tf.setText("0");
        c1tf.setText("0");
    }

    public void setFeedback(String responseMsg){
        this.feedback.setText(responseMsg);
        // dynamically updates frame
        SwingUtilities.updateComponentTreeUI(mainFrame);
    }

    private void refreshFrame() {
        this.feedback.setText("");
        SwingUtilities.updateComponentTreeUI(mainFrame);
        mainFrame.getContentPane().removeAll();
        mainFrame.repaint();
    }

    public void setMachineDetails(String formatted) {
        machineDetails = new JTextArea(formatted);
    }

    public void setSummaryTransactions(String formatted) {
        summaryTransactions.setText(formatted);
    }
}
