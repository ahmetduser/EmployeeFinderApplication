package javafxapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchEmployeeMain extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchEmployeeFXML.fxml"));

        final Scene SCENE = new Scene(root);
        primaryStage.setTitle("Search Employee");
        primaryStage.setScene(SCENE);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
