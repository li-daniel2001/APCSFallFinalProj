import java.util.*;
public class TennisRacquet
{
    //instance variables which use double, int, and boolean;
    private String brand;
    private String modelName;
    private double weight;//in ounces
    private double length;//in inches
    private double stiffness;
    //use of array
    private int[] stringPattern;
    //us of ArrayLists
    private ArrayList<Strings> stringsMain;//definition - main is the vertical colums on strings
    private ArrayList<Strings> stringsCross;//definition - cross is the horizonatal rows of strings
    private boolean isStrung;
    private boolean isIntact;
    private boolean isGripped;
    private double rub;//a measure of how much strings rub which eventually determine when they break
    private double gripWear;//measuring how much you wear down the grip
    //zero arg
    public TennisRacquet()
    {
        brand = "Wilson";
        modelName = "Prostaff";
        weight = 11.1;
        stiffness = 65;
        length = 27;
        isStrung = true;
        isIntact = true;
        isGripped = true;
        stringPattern = new int[2];
        stringPattern[0] = 16;
        stringPattern[1] = 19;
    }
    //multi arg
    public TennisRacquet(String brand, String modelName, double weight, double stiffness, double length,
    int stringPatternMain, int stringPatternCross, Strings strings, Strings strings1)
    {
        this.brand = brand;
        this.modelName = modelName;
        this.weight = weight;
        this.stiffness = stiffness;
        this.length = length;
        isStrung = true;
        isIntact = true;
        isGripped = true;
        stringPattern = new int[2];
        stringPattern[0] = stringPatternMain; //number of columns
        stringPattern[1] = stringPatternCross; // number of rows
        stringsMain = new ArrayList<Strings>();
        stringsCross = new ArrayList<Strings>();
        
        //the following creates the proper number of strings for the mains and crosses 
        //use of for loop
        for (int i = 0; i < stringPattern[0]; i++)
        {
            //this one is for the mains
            stringsMain.add(new Strings(strings.getTension(), strings.getMaterial(), strings.getGauge())); 
            
        }
        
        
        for (int i = 0; i < stringPattern[1]; i++)
        {
            //this one is for the crosses
            stringsCross.add(new Strings(strings1.getTension(), strings1.getMaterial(), strings1.getGauge()));

        }
    }
    //toString
    public String toString()
    {
        String output = new String();
        output = "Racquet: " + brand.toUpperCase() + " " + modelName.toUpperCase() + 
        "\nWeight: " + weight + "\nLength: " + length + "\nStiffness: " + stiffness + 
        "\nString Pattern: " + stringPattern[0] + "x" + stringPattern[1] + "\n";
        
        return output;
    }
    //most of the following are processor methods
    //the following few methods also show arrays and arraylists being traversed and accessed
    public void settingStringLengths()
    {
        for (int i = 0; i < stringPattern[0]; i++)
        {
            stringsMain.get(i).setStringLength(-0.05*((i+1)-(stringPattern[0]/2+0.5))*((i+1)-(stringPattern[0]/2+0.5))+15); 
        }
        for (int i = 0; i < stringPattern[1]; i++)
        {
            stringsCross.get(i).setStringLength(-0.05*((i+1)-(stringPattern[1]/2+0.5))*((i+1)-(stringPattern[1]/2+0.5))+13); 
        }
    }//this method sets length of strings at different positions (e.g. the strings near the center are longer)
    public ArrayList<Double> getStringLengthsMain()
    {
        ArrayList<Double> main = new ArrayList<Double>();

        for (int i = 0; i < stringPattern[0]; i++)
        {
            main.add(stringsMain.get(i).getStringLength()); 
        }
        
        return main;
    }//this one get the length of main strings
    
    public ArrayList<Double> getStringLengthsCross()
    {
        
        ArrayList<Double> cross = new ArrayList<Double>();
        
        for (int i = 0; i < stringPattern[1]; i++)
        {
            cross.add(stringsCross.get(i).getStringLength()); 
        }
        return cross;
    }//this one get the length of cross strings
    
    //this method uses for each loop to access max
    public int racquetShape()
    {
        int max = 0;
        //use of for each loop
        for (int x : stringPattern)
        {
            if (x>max)
            {
                max = x;
            }
        }
        return max;
    }//we're trying to compare the number of strings on the cross and main
    
    public String findRacquetShape()
    {
        //1st use of relational operator and 1st use of if-else statement
        if (racquetShape() == stringPattern[0])
        {
            return "There are more strings on the main";
        }
        else 
        {
            return "There are more strings on the cross";
        }
    }//this tells you whether there are more strings on cross or main

    public double findRecommendedTension()
    {
        return stiffness*.95;
    }//this determines the recommended tension for the strings with the given stiffness measure

    public String checkLength()
    {
        //2nd use of relational operators, 2nd use of if-else statement with throw error
        //qst use of logical operator
        //use of throw error
        if (length == 27)
        {
            return "You have an adult length racquet.";
        }
        else if (length == 28 || length == 28)
        {
            return "You have an extended length racquet.";
        }
        else if (length >= 19)
        {
            return "You have a junior length racquet.";
        }
        else
        {
            throw new IllegalArgumentException("There are no racquets with your given length");
        }
    }//determing the classification of the racquet based on length

    public String checkWeight()
    {
        //2nd use of logical operator
        if (weight >= 7 && weight < 9.4)
        {
            return "You have a light racquet.";
        }
        else if (weight <= 10.9)
        {
            return "You have a midweightracquet.";
        }
        else if (weight <= 12.6)
        {
            return "You have a heavy racquet.";
        }
        else
        {
            throw new IllegalArgumentException("There aren no racquets with your given weight.");
        }
    }//determing the classification of the weight of the racquet

    public String famousPlayers()
    {
        String player = "You use the same brand as ";
        //use of switch statement
        switch (brand.toLowerCase())
        {
            case "wilson":
            player += "Federer.";
            break;
            case "babolat":
            player += "Nadal.";
            break;
            case "head":
            player += "Djokovic.";
            break;
            case "yonex":
            player += "Wawrinka.";
            break;
            case "dunlop":
            player += "Nishikori.";
            break;
            case "vokl":
            player += "Berdych.";
            break;
            default:
            player += "nobody. That's a lame brand.";
        }
        return player;
    }//finding famous players who use the same brand of racquet

    public String newGrip()
    {
        isGripped = true;
        return "Racket gripped.";
    }//this method "puts on a new grip" after the old grip has been worn down
    
    //the following two are overloaded methods
    public String hit(int numHits)
    {
        //use of Math.pow()
        gripWear = Math.pow(1.1, numHits*.004);
        if (gripWear > 22)
        {
            gripWear = 0;
            isGripped = false;
            return "Your grip is worn off";
        }
        else
        {
            return "";
        }
    }//this models the wearing down of the grip based on the number of hits

    public double hit(Strings strings, int numHits)
    {
        double indexOfRub = 0;
        double rubModel = 0;
        //1st use of String method - equalsIgnoreCase
        if (strings.getMaterial().equalsIgnoreCase("polyester"))
        {
            indexOfRub = 1.08;
        }
        else if (strings.getMaterial().equalsIgnoreCase("multifilament"))
        {
            indexOfRub = 1.1;
        }
        else if (strings.getMaterial().equalsIgnoreCase("synethetic gut"))
        {
            indexOfRub = 1.12;
        }
        else if (strings.getMaterial().equalsIgnoreCase("polyester"))
        {
            indexOfRub = 1.14;
        }
        else
        {
            throw new IllegalArgumentException("Error. Try Again.");
        }
        rubModel = Math.pow(indexOfRub, numHits*0.004);
        if (strings.getGauge() == 15)
        {
            rubModel = rubModel;
        }
        else if (strings.getGauge() == 16)
        {
            rubModel = rubModel * 1.02;
        }
        else if (strings.getGauge() == 17)
        {
            rubModel = rubModel * 1.04;
        }
        else if (strings.getGauge() == 18)
        {
            rubModel = rubModel * 1.06;
        }
        else
        {
            throw new IllegalArgumentException("Error. Try Again.");
        }
        return rubModel;
    }//this models how much the strings rubs based on the number of hits, gauge of string, and material

    public String topspinGroundstroke(Strings strings, int numHits)
    {
        rub = rub + hit(strings, numHits);
        if (rub > 22)
        {
            rub = 0;
            strings.setTension(0);
            return "You have broken your strings";
        }
        else 
        {
            return "You have hit " + numHits + " groundstrokes.";
        }
    }//this method along with the next 3 distinguishes the amount of rub based on different strokes
    //if the value exceeds a certain index (22), the strings break and lose all their tension
    //otherwise you can continue hitting
    //this one is for topspin shots
    
    //lots of other methods - more than 3
    public String slice(Strings strings, int numHits)
    {
        rub = rub + 0.96*hit(strings, numHits);
        if (rub > 22)
        {
            rub = 0;
            strings.setTension(0);
            return "You have broken your strings";
        }
        else 
        {
            return "You have hit " + numHits + " slices.";
        }
    }//this one models rub for slices (underspin)

    public String volley(Strings strings, int numHits)
    {
        rub = rub + 0.98*hit(strings, numHits);
        if (rub > 22)
        {
            rub = 0;
            strings.setTension(0);
            return "You have broken your strings";
        }
        else 
        {
            return "You have hit " + numHits + " volleys.";
        }
    }//this one models rub for volleys (shots at the net)

    public String serve(Strings strings, int numHits)
    {
        rub = rub + 1.02*hit(strings, numHits);
        if (rub > 22)
        {
            rub = 0;
            strings.setTension(0);
            return "You have broken your strings";
        }
        else 
        {
            return "You have hit " + numHits + " serves.";
        }
    }//this one models rub for serves

    public String locationOfHit()
    {
        ArrayList<Integer> location= new ArrayList<Integer>();
        //use of Math.random() and casting
        location.add(((int)(Math.random()*(stringsMain.size())))+1);
        location.add(((int)(Math.random()*(stringsCross.size())))+1);
        return "Location of hit: (" + location.get(0) + ", " + location.get(1) + ")\n";
    }//this method tells you which intersection of the strings the ball hits
    
    public String smashRacquet()
    {
        isIntact = false;
        return "Your racquet has been demolished";
    }//smashing - destroying racquet
    
    public String newRacquet()
    {
        isIntact = true;
        return "New racquet obtained";
    }//replacing with new racquet

    public void cutStrings()
    {
        //use of nested loop
        for (int i = 0; i < stringPattern.length; i++)
        {
            for (int j = 0; j < stringPattern[i]; j++)
            {
                if (i==0)
                {
                    stringsMain.get(j).setStringIsStrung(false);
                }
                if (i==1)
                {
                    stringsCross.get(j).setStringIsStrung(false);
                }
            }
        }
        
    }//this method imitates the cutting of strings after your strings break and you want a restring

    public String stringEntireRacquet()
    {
        String stringing = "";
        Scanner input = new Scanner(System.in);
        //use of scanner - there's more in driver
        for (int i = 0; i < stringsMain.size(); i++)
        {
            stringsMain.get(i).inputString();
            stringing += stringsMain.get(i).inputString();
            stringing += (i+1) + ".\n";
            
            System.out.println("Main string " + (i+1) + " complete. Continue? Enter yes or no");
            String response = input.nextLine();
            if (response.equalsIgnoreCase("no"))
            {
                System.out.println("You don't have a choice. You must continue");
            }
        }
        
        while (stringsMain.get(stringsMain.size() - 1).getStringIsStrung() == true &&
        stringsCross.get(0).getStringIsStrung() == false)
        {
            System.out.println("Main strings completed.\n");
        }
        
        for (int i = 0; i < stringsCross.size(); i++)
        {
            stringsCross.get(i).inputString();
            stringing += stringsCross.get(i).inputString();
            stringing += (i+1) + ".\n";
            
            System.out.println("Cross string " + (i+1) + " complete. Continue? Enter yes or no");
            String response = input.nextLine();
            if (response.equalsIgnoreCase("no"))
            {
                System.out.println("\nYou don't have a choice. You must continue");
            }
        }
        
        while (stringsCross.get(stringsCross.size() - 1).getStringIsStrung() == true)
        {
            System.out.println("Entire racquet completed.\n");
        }
        
        return "Racquet stringing complete";
    }//this method, based off the inputString method in the Strings class, strings (puts in new strings) the entire racquet
    //it goes one string at a time, and asks for approval at every step
    
    public boolean getIsStrung()
    {
        return isStrung;
    }
    
    public void gripCap()
    {
        //use of substring method = 2nd use of String method
        //3rd use of String method - toUpperCase
        String brandName = brand.substring(0,1).toUpperCase();
        System.out.println("The cap of the racquet looks like this:");
        System.out.println("-------");
        System.out.println("|     |");
        System.out.println("|  "+brandName+"  |");
        System.out.println("|     |");
        System.out.println("-------");
    }//this is a *not very good* diagram of what the cap (or handle end) of the racquet looks like 
    //it's based on the brand's first letter
}