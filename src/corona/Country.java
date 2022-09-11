package corona;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Country {
    private String name="";
    private ArrayList <Stats> stats;
    private long NewCases = 0 ;
    private long TotalCases = 0 ;
    private long NewDeaths = 0 ;
    private long TotalDeaths = 0 ;
    private long Population = 0 ;
    private float Mortality = 0;
    private float AttackRate = 0;

    public Country(String name,long Population,Stats s) {
        this.name = name;
        this.Population = Population;
        stats=new ArrayList<Stats>();
        Update(s);
    }
    
    public void Update(Stats s)
    {
        Stats x=new Stats();
        x.setDay(s.getDay());
        x.setMonth(s.getMonth());
        x.setYear(s.getYear());
        x.setCases(s.getCases());
        x.setDeaths(s.getDeaths());
        stats.add(x);
        LocalDateTime now = LocalDateTime.now();
        int nowday=now.getDayOfMonth();
        int nowmonth=now.getMonthValue();
        int nowyear=now.getYear();
        if (s.getDay()==nowday&&s.getMonth()==nowmonth&&s.getYear()==nowyear)
        {
            NewCases = s.getCases();
            NewDeaths = s.getDeaths();
        }
        TotalCases+=s.getCases();
        TotalDeaths+=s.getDeaths();
        if (TotalCases!=0)
            Mortality=(float)TotalDeaths/TotalCases;
        if (Population!=0)
            AttackRate=(float)TotalCases/Population;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Stats> getStats() {
        return stats;
    }

    public long getNewCases() {
        return NewCases;
    }

    public long getTotalCases() {
        return TotalCases;
    }

    public long getNewDeaths() {
        return NewDeaths;
    }

    public long getTotalDeaths() {
        return TotalDeaths;
    }

    public long getPopulation() {
        return Population;
    }

    public float getMortality() {
        return Mortality;
    }

    public float getAttackRate() {
        return AttackRate;
    }
    
    public String toString()
    {
        String res="";
        res+="name="+name+"\n";
        res+="new cases="+NewCases+"\n";
        res+="Total Cases="+TotalCases+"\n";
        res+="new death="+NewDeaths+"\n";
        res+="Total deaths="+TotalDeaths+"\n";
        res+="population="+Population+"\n";
        res+="mortality="+Mortality+"\n";
        res+="attack rate="+AttackRate+"\n";
        res+=stats;
        return res;
    }
}
