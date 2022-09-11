package corona;

import java.awt.Color;
import static java.awt.Color.red;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class FirstGUI implements Initializable{
    
    private static URLHandler handler;
    @FXML
    private TextField txt;

    @FXML
    private Button GetData;

    @FXML
    private Text WaitingText;

    @FXML
    private Button showInTable;

    @FXML
    private Button showInLineChart;

    @FXML
    private Button showInBarChart;

    @FXML
    private ImageView TableImage;

    @FXML
    private ImageView BarImage;

    @FXML
    private ImageView LineImage;

    @FXML
    private Text LineMessage;

    @FXML
    private Button CasesButton;

    @FXML
    private Button DeathsButton;
    
    @FXML
    private Text LineMessage1;

    @FXML
    private Button CasesButton1;

    @FXML
    private Button DeathsButton1;
    
        
    public void GetText(ActionEvent ae){
       GetData.setDisable(true);
       GetData.setVisible(false);
       WaitingText.setText("We Are Collecting Information Please Wait...");
       String s = txt.getText() ;
       txt.setDisable(true);
       
       handler = new URLHandler(s,WaitingText,showInTable,showInLineChart,showInBarChart,BarImage,TableImage,LineImage);
       
       
       Thread T=new Thread(handler);
       T.start();
       
        
    }   
    
    public void ShowDataInBarChart()
    {
        
        DeathsButton1.setVisible(true);
        DeathsButton1.setDisable(false);
        
        CasesButton1.setVisible(true);
        CasesButton1.setDisable(false);
        
        LineMessage1.setVisible(true);
    }
    
    public void ShowDataInTable()
    {
        try {
            FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("ThirdGUI.fxml"));
            Parent P=(Parent) fxmlloader.load();
            Stage stage=new Stage();
            stage.setTitle("Corona Stats In Table");
            stage.setScene(new Scene(P));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FirstGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ShowDataInLineChart()
    {
        DeathsButton.setVisible(true);
        DeathsButton.setDisable(false);
        
        CasesButton.setVisible(true);
        CasesButton.setDisable(false);
        
        LineMessage.setVisible(true);
    }
    
    public static URLHandler Get_Handler()
    {
        return handler;
    }
    
    public void CasesClicked()
    {
        try {
            FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("SecondGUI.fxml"));
            Parent P=(Parent) fxmlloader.load();
            Stage stage=new Stage();
            stage.setTitle("Corona Cases Stats In Line Chart");
            stage.setScene(new Scene(P));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FirstGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CasesClicked1()
    {
        try {
            FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("FifthGUI.fxml"));
            Parent P=(Parent) fxmlloader.load();
            Stage stage=new Stage();
            stage.setTitle("Corona Cases Stats In Bar Chart");
            stage.setScene(new Scene(P));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FirstGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeathsClicked()
    {
        try {
            FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("FourthGUI.fxml"));
            Parent P=(Parent) fxmlloader.load();
            Stage stage=new Stage();
            stage.setTitle("Corona Deaths Stats In Line Chart");
            stage.setScene(new Scene(P));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FirstGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeathsClicked1()
    {
        try {
            FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("SixthGUI.fxml"));
            Parent P=(Parent) fxmlloader.load();
            Stage stage=new Stage();
            stage.setTitle("Corona Deaths Stats In Bar Chart");
            stage.setScene(new Scene(P));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FirstGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initialize(URL location, ResourceBundle resources) {
        showInTable.setDisable(true);
        showInTable.setVisible(false);
        
        showInLineChart.setDisable(true);
        showInLineChart.setVisible(false);
        
        showInBarChart.setDisable(true);
        showInBarChart.setVisible(false);
        
        BarImage.setVisible(false);
        TableImage.setVisible(false);
        LineImage.setVisible(false);
        BarImage.setDisable(true);
        TableImage.setDisable(true);
        LineImage.setDisable(true);
    }
    
    
}
