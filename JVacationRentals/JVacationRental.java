import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JVacationRental extends JFrame implements ActionListener {
    private JRadioButton parksideButton, poolsideButton, lakesideButton;
    private JRadioButton oneBedroomButton, twoBedroomsButton, threeBedroomsButton;
    private JCheckBox mealsCheckBox;
    private JButton calculateButton;

    private JLabel resultLabel;

    public JVacationRental() {
        setTitle("Lambert's Vacation Rentals");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        
        parksideButton = new JRadioButton("Parkside - $600 per week");
        poolsideButton = new JRadioButton("Poolside - $750 per week");
        lakesideButton = new JRadioButton("Lakeside - $825 per week");

        
        oneBedroomButton = new JRadioButton("One Bedroom - Base Price");
        twoBedroomsButton = new JRadioButton("Two Bedrooms - Add $75 per week");
        threeBedroomsButton = new JRadioButton("Three Bedrooms - Add $150 per week");

        
        mealsCheckBox = new JCheckBox("Meals Included - Add $200 per week");

       
        calculateButton = new JButton("Calculate Total");
        calculateButton.addActionListener(this);

        
        resultLabel = new JLabel();

        
        ButtonGroup locationGroup = new ButtonGroup();
        locationGroup.add(parksideButton);
        locationGroup.add(poolsideButton);
        locationGroup.add(lakesideButton);

        ButtonGroup bedroomGroup = new ButtonGroup();
        bedroomGroup.add(oneBedroomButton);
        bedroomGroup.add(twoBedroomsButton);
        bedroomGroup.add(threeBedroomsButton);

        
        add(new JLabel("Select Location:"));
        add(parksideButton);
        add(poolsideButton);
        add(lakesideButton);

        add(new JLabel("Select Number of Bedrooms:"));
        add(oneBedroomButton);
        add(twoBedroomsButton);
        add(threeBedroomsButton);

        add(mealsCheckBox);
        add(calculateButton);
        add(resultLabel);

        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        int basePrice = 0;

        if (parksideButton.isSelected()) {
            basePrice += 600;
        } else if (poolsideButton.isSelected()) {
            basePrice += 750;
        } else if (lakesideButton.isSelected()) {
            basePrice += 825;
        }

        if (twoBedroomsButton.isSelected()) {
            basePrice += 75;
        } else if (threeBedroomsButton.isSelected()) {
            basePrice += 150;
        }

        if (mealsCheckBox.isSelected()) {
            basePrice += 200;
        }

        
        resultLabel.setText("Total Cost: $" + basePrice + " per week");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JVacationRental());
    }
}
