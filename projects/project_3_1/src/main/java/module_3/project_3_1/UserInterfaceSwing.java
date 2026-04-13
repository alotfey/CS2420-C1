/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package module_3.project_3_1;

/**
 *
 * @author lotfey
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UserInterfaceSwing {

    private final JFrame frame;
    private JTextArea textArea;
    private JPanel mainPanel;
    private final JMenuItem colorItem;

    public UserInterfaceSwing() {
        // Create the main frame
        frame = new JFrame("User Interface I");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create the main panel and text area
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textArea = new JTextArea("Welcome to User Interface I\n");
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        frame.setContentPane(mainPanel);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Menu");

        JMenuItem dateTimeItem = new JMenuItem("Show Date and Time");
        JMenuItem saveItem = new JMenuItem("Save to log.txt");
        colorItem = new JMenuItem("Change Background to Green");
        JMenuItem exitItem = new JMenuItem("Exit");

        optionsMenu.add(dateTimeItem);
        optionsMenu.add(saveItem);
        optionsMenu.add(colorItem);
        optionsMenu.add(exitItem);
        menuBar.add(optionsMenu);
        frame.setJMenuBar(menuBar);

        // Show Date and Time
        dateTimeItem.addActionListener(e -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatted = now.format(formatter);
            textArea.setText("Current date and time: " + formatted + "\n");
        });

        // Save to log.txt
        saveItem.addActionListener(e -> {
            String content = textArea.getText();
            String filePath = System.getProperty("user.dir") + File.separator + "log.txt";
            try (FileWriter fw = new FileWriter(filePath);
                 BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(content);
            } catch (IOException ex) {
                textArea.append("Error saving file: " + ex.getMessage() + "\n");
            }
        });

        // Change Background to Random Green Hue
        colorItem.addActionListener(e -> {
            Random rand = new Random();
            int red   = rand.nextInt(81);        // 0–80
            int green = 120 + rand.nextInt(136); // 120–255
            int blue  = rand.nextInt(81);        // 0–80
            Color greenColor = new Color(red, green, blue);
            mainPanel.setBackground(greenColor);
            mainPanel.revalidate();
            mainPanel.repaint();
            textArea.append("Green hue selected: RGB(" + red + ", " + green + ", " + blue + ")\n");
        });

        // Exit
        exitItem.addActionListener(e -> System.exit(0));

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserInterfaceSwing::new);
    }
}
