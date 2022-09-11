package corona;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;

public class FifthGUIController implements Initializable{
    @FXML
    private BarChart<?, ?> bc;
    @FXML
    private CategoryAxis y;
    @FXML
    private NumberAxis x;
    @FXML
    ScrollBar scx ;
    @FXML
    ScrollBar scy ;
    
    public void Translatex(){
        scx.valueProperty().addListener(event -> {
            bc.setTranslateX(-1 * scx.getValue());
        }); 
    }
    public void Translatey(){
        scy.valueProperty().addListener(event -> {
            bc.setTranslateY(-1 * scy.getValue());
        }); 
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        URLHandler handler = FirstGUI.Get_Handler() ;
        
        ExtractedData Asia = handler.getAsia() ;
        ExtractedData Europe = handler.getEurope() ;
        ExtractedData Africa = handler.getAfrica() ;
        ExtractedData America = handler.getAmerica() ;
        ExtractedData Oceania = handler.getOceania() ;
        
        ArrayList <Stats> SAsia = Asia.getStats() ;
        ArrayList <Stats> SEurope = Europe.getStats() ;
        ArrayList <Stats> SAfrica = Africa.getStats() ;
        ArrayList <Stats> SAmerica = America.getStats() ;
        ArrayList <Stats> SOceania = Oceania.getStats() ;
        
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
        
        bc.getData().add(ser);
        
        XYChart.Series asia = new XYChart.Series() ;
        asia.setName("Asia") ; 
        XYChart.Series europe = new XYChart.Series() ;
        europe.setName("Europe") ;
        XYChart.Series africa = new XYChart.Series() ;
        africa.setName("Africa") ;
        XYChart.Series america = new XYChart.Series() ;
        america.setName("America") ;        
        XYChart.Series oceania = new XYChart.Series() ;
        oceania.setName("Oceania") ;
        
        for(Stats x : SAsia){
            int day = x.getDay() ;
            int  month = x.getMonth() ;
            int year = x.getYear() ;
            long cases = x.getCases() ;  
            asia.getData().add(new XYChart.Data(day + "/" + month + "/" + year ,cases)) ;
        }
        for(Stats x : SEurope){
            int day = x.getDay() ;
            int  month = x.getMonth() ;
            int year = x.getYear() ;
            long cases = x.getCases() ;
            europe.getData().add(new XYChart.Data(day + "/" + month + "/" + year ,cases)) ;
        }
        for(Stats x : SAfrica){
            int day = x.getDay() ;
            int  month = x.getMonth() ;
            int year = x.getYear() ;
            long cases = x.getCases() ;  
            africa.getData().add(new XYChart.Data(day + "/" + month + "/" + year ,cases)) ;
        }
        for(Stats x : SAmerica){
            int day = x.getDay() ;
            int  month = x.getMonth() ;
            int year = x.getYear() ;
            long cases = x.getCases() ;  
            america.getData().add(new XYChart.Data(day + "/" + month + "/" + year ,cases)) ;
        }
        for(Stats x : SOceania){
            int day = x.getDay() ;
            int  month = x.getMonth() ;
            int year = x.getYear() ;
            long cases = x.getCases() ;  
            oceania.getData().add(new XYChart.Data(day + "/" + month + "/" + year ,cases)) ;
        }
          
        bc.getData().addAll(asia , america , oceania , africa , europe) ;
    }
}
