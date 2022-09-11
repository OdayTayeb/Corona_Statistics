package corona;

public class ShowTable {
    
    String Country_name ;
    long TotalCases , NewCases , TotalDeaths , NewDeaths , Population ;
    float Mortality , AttackRate ;

    public ShowTable(Country x) {
        this.Country_name=x.getName();
        this.TotalCases = x.getTotalCases();
        this.NewCases = x.getNewCases();
        this.TotalDeaths = x.getTotalDeaths();
        this.NewDeaths = x.getNewDeaths();
        this.Population = x.getPopulation();
        this.Mortality = x.getMortality();
        this.AttackRate = x.getAttackRate();
    }

    public String getCountry() {
        return Country_name;
    }

    public long getTotalCases() {
        return TotalCases;
    }

    public long getNewCases() {
        return NewCases;
    }

    public long getTotalDeaths() {
        return TotalDeaths;
    }

    public long getNewDeaths() {
        return NewDeaths;
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

    public void setCountry(String Country_name) {
        this.Country_name = Country_name;
    }

    public void setTotalCases(int TotalCases) {
        this.TotalCases = TotalCases;
    }

    public void setNewCases(int NewCases) {
        this.NewCases = NewCases;
    }

    public void setTotalDeaths(int TotalDeaths) {
        this.TotalDeaths = TotalDeaths;
    }

    public void setNewDeaths(int NewDeaths) {
        this.NewDeaths = NewDeaths;
    }

    public void setPopulation(int Population) {
        this.Population = Population;
    }

    public void setMortality(float Mortality) {
        this.Mortality = Mortality;
    }

    public void setAttackRate(float AttackRate) {
        this.AttackRate = AttackRate;
    }
}
