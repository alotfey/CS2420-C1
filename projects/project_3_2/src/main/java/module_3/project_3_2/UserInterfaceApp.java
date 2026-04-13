package module_3.project_3_2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UserInterfaceApp extends Application {

    private TextArea textArea;
    private BorderPane mainPane;

    @Override
    public void start(Stage stage) {
        // Step 1: Create the main layout
        mainPane = new BorderPane();
        mainPane.setStyle("-fx-padding: 10;");

        // Step 2: Create the text area
        textArea = new TextArea("Welcome to User Interface II\n");
        textArea.setFont(javafx.scene.text.Font.font("Monospaced", 14));
        textArea.setEditable(true);
        textArea.setWrapText(true);
        mainPane.setCenter(textArea);

        // Step 3: Create the menu bar
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");

        MenuItem dateTimeItem = new MenuItem("Show Date and Time");
        MenuItem saveItem     = new MenuItem("Save to log.txt");
        MenuItem colorItem    = new MenuItem("Change Background to Orange");
        MenuItem exitItem     = new MenuItem("Exit");

        menu.getItems().addAll(dateTimeItem, saveItem, colorItem, exitItem);
        menuBar.getMenus().add(menu);
        mainPane.setTop(menuBar);

        // Step 4 & 5: Show Date and Time
        dateTimeItem.setOnAction(e -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            textArea.setText("Current date and time: " + now.format(formatter) + "\n");
        });

        // Step 4 & 6: Save to log.txt
        saveItem.setOnAction(e -> {
            String content = textArea.getText();
            String filePath = System.getProperty("user.dir") + File.separator + "log.txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                bw.write(content);
            } catch (IOException ex) {
                textArea.appendText("Error saving file: " + ex.getMessage() + "\n");
            }
        });

        // Step 4 & 7: Change Background to Random Orange Hue
        colorItem.setOnAction(e -> {
            Random rand = new Random();
            int red   = 200 + rand.nextInt(56); // 200–255
            int green = 80  + rand.nextInt(86); // 80–165
            int blue  = rand.nextInt(31);       // 0–30
            String hex = String.format("#%02X%02X%02X", red, green, blue);
            mainPane.setStyle("-fx-padding: 10; -fx-background-color: " + hex + ";");
            textArea.appendText("Orange hue selected: RGB(" + red + ", " + green + ", " + blue + ")\n");
        });

        // Step 4 & 8: Exit
        exitItem.setOnAction(e -> Platform.exit());

        // Step 9: Show the stage
        Scene scene = new Scene(mainPane, 600, 400);
        stage.setTitle("User Interface II");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}