import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
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
    JButton returnToMaintenanceBtn = new JButton("Return to Maintenance");

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


    public ProgramView() {
        this.mainFrame = new JFrame("Vending Machine Simulator");
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(700, 700);
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

        productInfo.setText(productList[productIndex].getName() + " \n " +
                            productList[productIndex].getCalories() + " \n " +
                            productList[productIndex].getPrice());

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

    public void testFeaturesMenu(){

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

    // MISC ---------------------

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

}
