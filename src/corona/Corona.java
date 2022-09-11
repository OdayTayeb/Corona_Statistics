package corona;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Corona extends Application {
    
    Stage s ;
    @Override
    public void start(Stage primaryStage) {    
        try {
            Parent first = FXMLLoader.load(getClass().getResource("FirstGUI.fxml")) ;

            Scene URL = new Scene(first);
            primaryStage.setScene(URL);
            primaryStage.show();
            s = primaryStage ;
            primaryStage.setTitle("Corona Pandemic Data Visualization ");
        } catch (IOException ex) {
            Logger.getLogger(FirstGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
