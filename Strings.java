public class Strings
{
    private double tension;//tension = how tight the strings are strung;
    private String material;
    private int gauge;//gauge = thickness;
    private boolean stringIsStrung;
    private double stringLength;
    public Strings(double tension, String material, int gauge)
    {
        this.tension = tension;
        this.material = material;
        this.gauge = gauge;
        stringIsStrung = true;
    }
    public String toString()
    {
        String output = new String();
        output = "Strings\nTension: " + tension + "\nMaterial: " + material + "\nGauge: " + gauge;
        return output;
    }
    public double TensionLoss(int numHits)
    {
        tension = tension - Math.log(numHits*.004+1);
        return tension;
    }//this method models the loss of tension on the strings as you hit a certain number of times
    
    //most of the following are getters and setters
    public void setTension(double tension)
    {
        this.tension = tension;
    }
    public double getTension()
    {
        return tension;
    }
    public String getMaterial()
    {
        return material;
    }
    public int getGauge()
    {
        return gauge;
    }
    public void setStringLength(double stringLength)
    {
        this.stringLength = stringLength;
    }
    public double getStringLength()
    {
        return stringLength;
    }
    public void setStringIsStrung(boolean isStrung)
    {
        stringIsStrung = isStrung;
    }
    public boolean getStringIsStrung()
    {
        return stringIsStrung;
    }
    public String inputString()
    {
        if (stringIsStrung == false && tension == 0)
        {
            stringIsStrung = true;
            return "Completed stringing: string ";
        }
        else 
        {
            return "Already strung";
        }
    }//this method strings (puts strings in) one slot (a slot is one row or column for the strings)
    //they can only string a racquet if it is cut (stringIsStrung==false) and the strings are broken (tension==0)
    
}