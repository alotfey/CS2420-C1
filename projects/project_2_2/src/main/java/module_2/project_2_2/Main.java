/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package module_2.project_2_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author lotfey
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Age Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setSize(600, 250);
            frame.setLocationRelativeTo(null);

            // Main panel with padding
            JPanel mainPanel = new JPanel(new GridLayout(5, 1, 10, 10));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

            // Input row: month, day, year
            JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
            inputPanel.add(new JLabel("Birth Date:"));

            JTextField monthField = new JTextField(3);
            JTextField dayField = new JTextField(3);
            JTextField yearField = new JTextField(5);

            monthField.setToolTipText("Month (1-12)");
            dayField.setToolTipText("Day (1-31)");
            yearField.setToolTipText("Year (e.g. 2000)");

            inputPanel.add(new JLabel("Month:"));
            inputPanel.add(monthField);
            inputPanel.add(new JLabel("Day:"));
            inputPanel.add(dayField);
            inputPanel.add(new JLabel("Year:"));
            inputPanel.add(yearField);

            // Result panel
            JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel resultLabel = new JLabel("Your age will appear here.");
            resultPanel.add(resultLabel);

            // Button
            JButton calculateButton = new JButton("Calculate Age");

            // ActionListener
            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int month = Integer.parseInt(monthField.getText().trim());
                        int day = Integer.parseInt(dayField.getText().trim());
                        int year = Integer.parseInt(yearField.getText().trim());

                        LocalDate birthDate = LocalDate.of(year, month, day);
                        LocalDate today = LocalDate.now();

                        if (birthDate.isAfter(today)) {
                            resultLabel.setText("Birth date cannot be in the future.");
                            return;
                        }

                        int age = Period.between(birthDate, today).getYears();
                        resultLabel.setText("You are " + age + " years old.");
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Please enter valid numbers for month, day, and year.");
                    } catch (Exception ex) {
                        resultLabel.setText("Invalid date. Please check your input.");
                    }
                }
            });

            // Add components to main panel
            mainPanel.add(new JLabel("Enter your birth date:", SwingConstants.CENTER));
            mainPanel.add(inputPanel);
            mainPanel.add(calculateButton);
            mainPanel.add(resultPanel);
            // Add main panel to frame
            frame.add(mainPanel);
            // Make frame visible
            frame.setVisible(true);
        });
    }
}
