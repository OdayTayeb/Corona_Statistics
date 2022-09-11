package corona;

import java.awt.Scrollbar;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ScrollBar;

public class SecondGUIController implements Initializable {

    private ArrayList<Country> Data;
    private URLHandler handler;
    @FXML
    private LineChart<?, ?> LineChartCases;

    @FXML
    private CategoryAxis xCases;

    @FXML
    private NumberAxis yCases;
    
    @FXML
    private ScrollBar sc;
    
    @FXML
    private ScrollBar sc1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Data = new ArrayList<>();
        handler=FirstGUI.Get_Handler();
        fill_data();
        LocalDateTime now = LocalDateTime.now();
        int nowday=now.getDayOfMonth();
        int nowmonth=now.getMonthValue();
        int nowyear=now.getYear();
        XYChart.Series ser=new XYChart.Series();
        
        ser.getData().add(new XYChart.Data("31/12/2019",0));
        for (int i=1;i<=nowmonth;i++)
        {
            int mx;
            if (i<=7)
            {
                if (i%2==0&&i!=2)
                    mx=30;
                else if (i==2)
                    mx=29;
                else mx=31;
            }
            else 
            {
                if (i%2==0)
                    mx=31;
                else mx=30;
            }
            for (int j=1;j<=mx;j++)
            {
                ser.getData().add(new XYChart.Data(j+"/"+i+"/"+nowyear,0));           
            }
        }
        LineChartCases.getData().add(ser);
        for (Country x:Data)
            AddToCasesChart(x);
            
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
    
    void AddToCasesChart(Country x)
    {
        
        XYChart.Series ser=new XYChart.Series();
        for (Stats y:x.getStats())
            if (y.getCases()!=0)
                ser.getData().add(new XYChart.Data(y.getDay()+"/"+y.getMonth()+"/"+y.getYear(),y.getCases()));
        ser.setName(x.getName());
            
        LineChartCases.getData().add(ser);
    }
    public void Translate(){
        sc.valueProperty().addListener(event -> {
            LineChartCases.setTranslateY(-1 * sc.getValue());
        }); 
    }
    public void Translate1(){
        sc1.valueProperty().addListener(event -> {
            LineChartCases.setTranslateX(-1 * sc1.getValue());
        }); 
    }
    
}
