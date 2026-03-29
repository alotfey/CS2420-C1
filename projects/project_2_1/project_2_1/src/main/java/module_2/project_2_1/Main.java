/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package module_2.project_2_1;

/**
 *
 * @author lotfey
 */
public class Main {
    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            new BankAccountGUI().setVisible(true);
        });
    }
}