package corona;

import java.util.Comparator;

public class Stats {
    private int day = 0;
    private int month = 0 ;
    private int year = 0 ;
    private long Cases = 0 ;
    private long Deaths = 0 ;

    public Stats(){
        
    }
    public Stats(int d,int m,int y,long c,long de)
    {
       day=d;
       month=m;
       year=y;
       Cases=c;
       Deaths=de;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCases(long Cases) {
        this.Cases = Cases;
    }

    public void setDeaths(long Deaths) {
        this.Deaths = Deaths;
    }
    
    public void add(long addToCases,long addToDeaths)
    {
        Cases+=addToCases;
        Deaths+=addToDeaths;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public long getCases() {
        return Cases;
    }

    public long getDeaths() {
        return Deaths;
    }
    
    public String toString()
    {
        String res="";
        res+=day+" "+month+" "+year+" "+Cases+" "+Deaths+"\n";
        return res;
    }
    
}

