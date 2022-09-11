package corona;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.util.Pair;
import java.util.Date;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class URLHandler implements Runnable {
    
    private ImageView BarImage;
    private ImageView TableImage;
    private ImageView LineImage;
    private Button showInBarChart;
    private Button showInLineChart;
    private Text WaitingText;
    private Button showInTable;
    private String url_string="";
    private URL url;
    private ExtractedData Asia;
    private ExtractedData Europe;
    private ExtractedData Africa;
    private ExtractedData America;
    private ExtractedData Oceania;
    // for one record
    private Stats cur;
    private String countryName="";
    private long Population = 0;
    private String Continent = "";
    
    public URLHandler(String url_string,Text x,Button y,Button z,Button w,ImageView im1,ImageView im2,ImageView im3)
    {
        this.url_string=url_string;
         Asia = new ExtractedData();
         Europe = new ExtractedData();
         Africa= new ExtractedData();
         America= new ExtractedData();
         Oceania= new ExtractedData();
         cur=new Stats();
         WaitingText =x;
         showInTable = y;
         showInLineChart =z;
         showInBarChart=w;
         BarImage=im1;
         TableImage=im2;
         LineImage=im3;
         
    }
    
    public void func()
    {
        try {
            url=new URL(url_string);
            try
            {
                System.out.print("Start\n");
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String inputLine="";
                while((inputLine = in.readLine()) != null) {
                    Pair <String,String> Info = Get_Info(inputLine);
                    FillRecord(Info);
                    if (Info.getKey().equals("continentExp")) { 
                        StoreData();
                    }
                }
                System.out.print("End\n");
            } catch (IOException ioe) {
                System.out.print("File Exception\n");
                WaitingText.setText("Failed , Error in Opening File");
                return;
            }
            
        } 
        catch (MalformedURLException ex) {
            System.out.print("URL Exception\n");
            WaitingText.setText("Failed , URL Error");
            return;
        }
        WaitingText.setText("Data Collection Finished Successfully !!");
        showInTable.setDisable(false);
        showInTable.setVisible(true);
        showInLineChart.setDisable(false);
        showInLineChart.setVisible(true);
        showInBarChart.setDisable(false);
        showInBarChart.setVisible(true);
        
        BarImage.setVisible(true);
        TableImage.setVisible(true);
        LineImage.setVisible(true);
        BarImage.setDisable(false);
        TableImage.setDisable(false);
        LineImage.setDisable(false);
    }
    
    public Pair <String,String> Get_Info(String line)
    {
        int b=0,i;
        for (i=0;i<line.length();i++)
            if (line.charAt(i)=='<')
                b++;
        if (b==1) return new Pair("?","?");
        
        String first="",second="";
        for (i=0;i<line.length();i++)
        {
            if (line.charAt(i)=='<')
            {
                i++;
                while (line.charAt(i)!='>')
                {
                    first+=line.charAt(i);
                    i++;
                }
                break;
            }
        }
        i++;
        while (line.charAt(i)!='<')
        {
            second+=line.charAt(i);
            i++;
        }
        if (first.equals("")||second.equals("")) return new Pair("?","?");
        return new Pair(first,second);
    }
    
    void FillRecord(Pair <String,String> Info)
    {
        String first=Info.getKey(),second=Info.getValue();
        if (first.equals("day"))
            cur.setDay(Integer.parseInt(second));
        if (first.equals("month"))
            cur.setMonth(Integer.parseInt(second));
        if (first.equals("year"))
            cur.setYear(Integer.parseInt(second));
        if (first.equals("cases"))
            cur.setCases(Math.abs(Integer.parseInt(second)));
        if (first.equals("deaths"))
            cur.setDeaths(Math.abs(Integer.parseInt(second)));
        if (first.equals("countriesAndTerritories"))
            countryName=second;
        if (first.equals("popData2018"))
            Population=Integer.parseInt(second);
        if (first.equals("continentExp"))
            Continent=second;
    }
    
    void StoreData()
    {
        if (Continent.equals("Asia"))
            Asia.Update(cur,countryName,Population);
        
        if (Continent.equals("Africa"))
            Africa.Update(cur,countryName,Population);
        
        if (Continent.equals("Europe"))
            Europe.Update(cur,countryName,Population);
        
        if (Continent.equals("America"))
            America.Update(cur,countryName,Population);
        
        if (Continent.equals("Oceania"))
            Oceania.Update(cur,countryName,Population);
        
    }
    
    public void show()
    {
        System.out.print(Asia);
    }

    public ExtractedData getAsia() {
        return Asia;
    }

    public ExtractedData getEurope() {
        return Europe;
    }

    public ExtractedData getAfrica() {
        return Africa;
    }

    public ExtractedData getAmerica() {
        return America;
    }

    public ExtractedData getOceania() {
        return Oceania;
    }
    
    public void run()
    {
        func();
    }
    
}
