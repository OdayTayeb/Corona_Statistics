package corona;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class ExtractedData {
    private ArrayList <Country> country;
    private ArrayList <Stats> stats;
    
    public ExtractedData()
    {
        country=new ArrayList<>();
        stats=new ArrayList<>();
    }

    public ArrayList<Stats> getStats() {
        return stats;
    }
    
    void Update(Stats s,String c,long p)
    {
        boolean exist=false;
        for (Country x:country){
            if (x.getName().equals(c))
            {
                exist=true;
                x.Update(s);
                break;
            }
        }
        if (!exist) 
            country.add(new Country(c,p,s));
        exist=false;
        for (Stats y:stats)
        { 
            if (s.getYear()==y.getYear()&&s.getMonth()==y.getMonth()&&s.getDay()==y.getDay())
            {
                y.add(s.getCases(), s.getDeaths());
                exist=true;
                break;
            }
        }
        if (!exist) stats.add(new Stats(s.getDay(),s.getMonth(),s.getYear(),s.getCases(),s.getDeaths()));
    }
    
    public String toString()
    {
        String res="";
        for (Stats x:stats)
            res+=x;
        return res;
    }
    
    public ArrayList<Country> get_country()
    {
        return country;
    }
}
