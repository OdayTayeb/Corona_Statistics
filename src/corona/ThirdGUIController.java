package corona;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ThirdGUIController implements Initializable {
    
    private URLHandler handler;
    private ArrayList<Country> Data;
    Stage s ;
    @FXML
    TableView < ShowTable > table ;
    @FXML
    TableColumn < ShowTable , String > Country ;
    @FXML
    TableColumn < ShowTable , Integer > TotalCases ;
    @FXML
    TableColumn < ShowTable , Integer > NewCases ;
    @FXML
    TableColumn < ShowTable , Integer > TotalDeaths ;
    @FXML
    TableColumn < ShowTable , Integer > NewDeaths ;
    @FXML
    TableColumn < ShowTable , Integer > Population ;
    @FXML
    TableColumn < ShowTable , Float > Mortality ;
    @FXML
    TableColumn < ShowTable , Float > AttackRate ;
    @FXML
    ScrollBar sc ;

    ObservableList < ShowTable > list = FXCollections.observableArrayList() ;
    
    public void Translate(){
        sc.valueProperty().addListener(event -> {
            table.setTranslateY(-1 * sc.getValue());
        }); 
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler=FirstGUI.Get_Handler();
        Data=new ArrayList<Country>();
        fill_data();
        System.out.println("sd") ;
        Country.setCellValueFactory(new PropertyValueFactory < ShowTable , String > ("Country") ) ;
        TotalCases.setCellValueFactory(new PropertyValueFactory < ShowTable , Integer > ("TotalCases") ) ;
        NewCases.setCellValueFactory(new PropertyValueFactory < ShowTable , Integer > ("NewCases") ) ;
        TotalDeaths.setCellValueFactory(new PropertyValueFactory < ShowTable , Integer > ("TotalDeaths") ) ;
        NewDeaths.setCellValueFactory(new PropertyValueFactory < ShowTable , Integer > ("NewDeaths") ) ;
        Population.setCellValueFactory(new PropertyValueFactory < ShowTable , Integer > ("Population") ) ;
        Mortality.setCellValueFactory(new PropertyValueFactory < ShowTable , Float > ("Mortality") ) ;
        AttackRate.setCellValueFactory(new PropertyValueFactory < ShowTable , Float > ("AttackRate") ) ;
        for (Country x:Data)
            list.add(new ShowTable(x)) ;
        table.setItems(list) ;          
    }       
    
    void fill_data()
    {
       for ( Country x: handler.getAfrica().get_country() )
           Data.add(x);
       for ( Country x: handler.getAmerica().get_country() )
           Data.add(x);
       for ( Country x: handler.getAsia().get_country() )
           Data.add(x);
       for ( Country x: handler.getEurope().get_country() )
           Data.add(x);
       for ( Country x: handler.getOceania().get_country() )
           Data.add(x);
    }
    
}
