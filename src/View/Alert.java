package View;

public class Alert extends javafx.scene.control.Alert{

    public Alert(javafx.scene.control.Alert.AlertType alertType, String title, String description){
        super(alertType);
        this.setTitle(title);
        this.setHeaderText(description);
    }

}
