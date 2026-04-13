module module_3.project_3_2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens module_3.project_3_2 to javafx.fxml;
    exports module_3.project_3_2;
}
