/**
* The BlueCrabHealthCalculator program implements an application that displays a window allowing a user
* to input blue crab attributes to determine whether it is healthy or unhealthy.
*
* @author Lincoln Powell
* @version 1.0
* @since 2/18/2018 
*/

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;

public class BlueCrabHealthCalculator extends JFrame {
    private JPanel jpDatePanel, jpColorScaleScoreSliderPanel, jpWeightPanel, jpLengthPanel, jpButtonPanel;
    private JLabel jlMonth, jlDay, jlColorScaleScore, jlWeight, jlLength;
    private JComboBox jcbMonths, jcbDays, jcbWeight, jcbLength;
    private JSlider jsColorScaleScore;
    private JButton jbCalculate;
    
    // Window width and height.
    private final int WINDOW_WIDTH = 465, WINDOW_HEIGHT = 240;
    
    // Holds the values that will be displayed in the jcbMonths combo box.
    private final Integer[] MONTHS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

    // Holds the values that will be displayed in the jcbDays combo box.
    private final Integer[] DAYS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                                     17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };

    // Holds the values that will be displayed in the jcbWeight combo box.
    private final String[] WEIGHT = { "<=8", "9", "10", ">10" };

    // Holds the values that will be displayed in the jcbLength combo box.
    private final String[] LENGTH = { "<=5", ">5" };
    
    /**
     * Constructor
     */
    public BlueCrabHealthCalculator() {
        // Set the title.
        setTitle("Blue Crab Health Calculator");
        
        // Set the preferred size of the window.
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        
        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Disable window resizing.
        setResizable(false);
        
        // Add a FlowLayout manager to the content pane.
        setLayout(new GridLayout(5, 0));
        
        // Build the panels.
        buildDatePanel();
        buildColorScaleScoreSliderPanel();
        buildWeightPanel();
        buildLengthPanel();
        buildButtonPanel();
        
        // Add the panels to the content pane.
        add(jpDatePanel);
        add(jpColorScaleScoreSliderPanel);
        add(jpWeightPanel);
        add(jpLengthPanel);
        add(jpButtonPanel);
        
        // Pack and display the window.
        pack();
        setVisible(true);
        
        // Specify where the window is created on screen.
        setLocationRelativeTo(null);
    }
    
    /**
     * The buildDatePanel method adds the month and day labels and combo boxes to a panel.
     */
    private void buildDatePanel() {
        // Create a panel to hold the date labels and combo boxes.
        jpDatePanel = new JPanel();
        
        // Create the labels.
        jlMonth = new JLabel("Month:");
        jlDay = new JLabel("Day:");
        
        // Create the combo boxes.
        jcbMonths = new JComboBox(MONTHS);
        jcbDays = new JComboBox(DAYS);
        
        // Get the current date and set month and day combo boxes to current date.
        LocalDate currentDate = LocalDate.now();
        jcbMonths.setSelectedItem(currentDate.getMonthValue());
        jcbDays.setSelectedItem(currentDate.getDayOfMonth());
        
        // Add a FlowLayout manager to the content pane.
        jpDatePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 7));
        
        // Add the components to the panel.
        jpDatePanel.add(jlMonth);
        jpDatePanel.add(jcbMonths);
        jpDatePanel.add(jlDay);
        jpDatePanel.add(jcbDays);
    }
    
    /**
     * The buildColorScaleScoreSliderPanel method adds the color scale score label and slider to a panel.
     */
    private void buildColorScaleScoreSliderPanel() {
        // Create a panel to hold the color scale score label and slider.
        jpColorScaleScoreSliderPanel = new JPanel();
        
        // Create the label.
        jlColorScaleScore = new JLabel("Color Scale Score:");
        
        // Create the slider.
        jsColorScaleScore = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        jsColorScaleScore.setMajorTickSpacing(1);
        jsColorScaleScore.setMinorTickSpacing(1);
        jsColorScaleScore.setPaintTicks(true);
        jsColorScaleScore.setPaintLabels(true);
        
        // Add a FlowLayout manager to the content pane.
        jpColorScaleScoreSliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        
        // Add the components to the panel.
        jpColorScaleScoreSliderPanel.add(jlColorScaleScore);
        jpColorScaleScoreSliderPanel.add(jsColorScaleScore);
    }
    
    /**
     * The buildWeightPanel method adds the weight label and combo box to a panel.
     */
    private void buildWeightPanel() {
        // Create a panel to hold the weight and length labels and text fields.
        jpWeightPanel = new JPanel();
        
        // Create the labels and combo box.
        jlWeight = new JLabel("Weight:");
        jcbWeight = new JComboBox(WEIGHT);
        
        // Add a FlowLayout manager to the content pane.
        jpWeightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 7));
        
        // Add the components to the panel.
        jpWeightPanel.add(jlWeight);
        jpWeightPanel.add(jcbWeight);
    }
    
    /**
     * The buildLengthPanel method adds the length label and combo box to a panel.
     */
    private void buildLengthPanel() {
        // Create a panel to hold the weight and length labels and text fields.
        jpLengthPanel = new JPanel();
        
        // Create the labels and combo box.
        jlLength = new JLabel("Length:");
        jcbLength = new JComboBox(LENGTH);
        
        // Add a FlowLayout manager to the content pane.
        jpLengthPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        
        // Add the components to the panel.
        jpLengthPanel.add(jlLength);
        jpLengthPanel.add(jcbLength);
    }
    
    /**
     * The buildButtonPanel method adds the calculate button to a panel.
     */
    private void buildButtonPanel() {
        // Create a panel to hold the calculate button.
        jpButtonPanel = new JPanel();
        
        // Create the calculate button.
        jbCalculate = new JButton("Calculate");
        
        // Add an action listener to the calculate button.
        jbCalculate.addActionListener(new CalculateButtonListener());
        
        // Add a FlowLayout manager to the content pane.
        jpButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        // Add the calculate button to the panel.
        jpButtonPanel.add(jbCalculate);
    }
    
    private class CalculateButtonListener implements ActionListener {
        /**
         * The actionPerformed method executes when the user clicks on the Calculate button.
         * @param e The event object.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean errorsFound = false;
            int month, day, colorScaleScore;
            String weight, length;
            
            month = (int) jcbMonths.getSelectedItem();
            day = (int) jcbDays.getSelectedItem();
            weight = jcbWeight.getSelectedItem().toString();
            length = jcbLength.getSelectedItem().toString();
            colorScaleScore = jsColorScaleScore.getValue();
            
            if (!errorsFound) {
                if (colorScaleScore > 7)
                    JOptionPane.showMessageDialog(null, "The blue crab is healthy.", "Healthy", JOptionPane.PLAIN_MESSAGE);
                else if (">10".equals(weight) && month >= 7 && day > 15)
                    JOptionPane.showMessageDialog(null, "The blue crab is healthy.", "Healthy", JOptionPane.PLAIN_MESSAGE);
                else if (">5".equals(length))
                    JOptionPane.showMessageDialog(null, "The blue crab is healthy.", "Healthy", JOptionPane.PLAIN_MESSAGE);
                else if (colorScaleScore > 5 &&
                        ("9".equals(weight) || "10".equals(weight) || ">10".equals(weight)) &&
                        ">5".equals(length))
                    JOptionPane.showMessageDialog(null, "The blue crab is healthy.", "Healthy", JOptionPane.PLAIN_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "The blue crab is unhealthy.", "Unhealthy", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    /**
     * The main method creates an instance of the BlueCrabHealthCalculator
     * class, which causes it to display its window.
     * @param args 
     */
    public static void main(String[] args) {
        new BlueCrabHealthCalculator();
    }
}