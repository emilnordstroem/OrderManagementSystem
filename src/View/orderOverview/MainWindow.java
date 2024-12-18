package View.orderOverview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Order Management System");
        BorderPane pane = new BorderPane();
        this.innerContents(pane);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void innerContents(BorderPane pane){
        TabPane tabPane = new TabPane();
        this.innerTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void innerTabPane(TabPane tabPane){
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); // Not possible to close tabs

        Tab tabOrderOverview = new Tab("order"); // Application overview
        tabPane.getTabs().add(tabOrderOverview);
        tabOrderOverview.setContent(new OrderOverviewPane());

        Tab tabCustomerOverview = new Tab("customer"); // Application overview
        tabPane.getTabs().add(tabCustomerOverview);
        tabCustomerOverview.setContent(new CustomerOverviewPane());
    }
}
