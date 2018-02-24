import java.util.*;
//class composition - driver
public class TennisRacquetDriver
{
    public static void main (String[] args)
    {
        String play = "yes";

        while (play.equalsIgnoreCase("yes"))
        {
            Scanner input = new Scanner (System.in);
            Scanner input1 = new Scanner (System.in);
            Scanner input2 = new Scanner(System.in);
            System.out.println("Let's create a tennis racquet");
            
            //asking for input for most of the criteria where it is human-determined
            System.out.println("Enter the brand(Wilson, Babolat...): ");
            String brand = input.nextLine();
            System.out.println("Enter the model(Prostaff, Aero Pure...): ");
            String model = input.nextLine();
            System.out.println("Enter the weight in ounces: ");
            double weight = input.nextDouble();
            System.out.println("Enter the length in inches: ");
            double length = input.nextDouble();
            System.out.println("Enter the stiffness measure(a number between 60 and 75): ");
            double stiffness = input.nextDouble();
            System.out.println("Enter the number of strings on the mains: ");
            int mainPattern = input.nextInt();
            System.out.println("Enter the number of strings on the cross: ");
            int crossPattern = input.nextInt();

            System.out.println("Now to the strings - Main strings first");
            System.out.println("Enter the desired tension: ");
            double desiredTension = input.nextDouble();
            System.out.println("Enter the material-polyester, multifilament, synthetic gut, natural gut:");
            String material = input1.nextLine();
            System.out.println("Enter the gauge - 15, 16, 17, 18: ");
            int gauge = input1.nextInt();

            //making strings object - for main
            Strings strings = new Strings(desiredTension, material, gauge);

            System.out.println("Now cross strings");
            System.out.println("Enter the desired tension: ");
            double desiredTension1 = input1.nextDouble();
            System.out.println("Enter the material-polyester, multifilament, synthetic gut, natural gut:");
            String material1 = input2.nextLine();
            System.out.println("Enter the gauge - 15, 16, 17, 18: ");
            int gauge1 = input2.nextInt();
            //making strings object - for cross
            Strings strings1 = new Strings(desiredTension1, material1, gauge1);
            //making the racquet object with the strings
            TennisRacquet racquet = new TennisRacquet(brand, model, weight, stiffness, length, mainPattern,
                    crossPattern, strings, strings1);
            double newTension;
            double newTension1;
            //this makes sure that the inputted tension is within a certain range of the recommended
            //otherwise it may not be suitable for the racquet
            //use of dowhile loop
            do 
            {
                System.out.println("Check to see if your desired tension is out of the recommended range");
                System.out.println("The recommended range is stiffness*0.95 +/- 10");
                System.out.println("If this message shows again, at least one of you tensions is a poor choice. Enter desired tension on main");
                newTension = input.nextDouble();
                System.out.println("Enter desired tension on cross");
                newTension1 = input.nextDouble();
            }
            while (newTension < (racquet.findRecommendedTension() - 10) || 
            newTension > (racquet.findRecommendedTension() + 10) || 
            newTension1 < (racquet.findRecommendedTension() - 10) || 
            newTension1 > (racquet.findRecommendedTension() + 10));
            //new strings with the modified tension
            Strings stringsNew = new Strings(newTension, material, gauge);
            Strings strings1New = new Strings(newTension, material1, gauge1);
            System.out.println(racquet);
            racquet.gripCap();
            System.out.print("Main: ");
            System.out.println(stringsNew);
            System.out.print("Cross: ");
            System.out.println(strings1New);
            System.out.println(racquet.checkLength());
            System.out.println(racquet.checkWeight());
            System.out.println(racquet.famousPlayers());
            System.out.println(racquet.findRacquetShape());
            //the above give the basic information of the racquet
            
            //below we are modeling actually hitting balls
            System.out.println("\n\nLet's play: We'll start off with a serve");
            System.out.println(racquet.serve(stringsNew, 1));
            Scanner input3 = new Scanner(System.in);
            System.out.println("What shot do you want to hit next? Enter topspin groundstroke, slice, or volley");
            String nextShot = input3.nextLine();
            if (nextShot.equalsIgnoreCase("topspin groundstroke"))
            {
                System.out.println(racquet.topspinGroundstroke(stringsNew, 1));
            }
            else if (nextShot.equalsIgnoreCase("slice"))
            {
                System.out.println(racquet.slice(stringsNew, 1));
            }
            else if (nextShot.equalsIgnoreCase("volley"))
            {
                System.out.println(racquet.volley(stringsNew, 1));
            }
            System.out.print("(main, cross) - " + racquet.locationOfHit());
            System.out.println("How many more of each of the shots would you like to hit? Enter a number 1-10");
            System.out.println("Topspin: ");
            int topspin = input3.nextInt();
            System.out.println("Slice: ");
            int slice = input3.nextInt();
            System.out.println("Volley: ");
            int volley = input3.nextInt();
            System.out.println(racquet.topspinGroundstroke(stringsNew, topspin));
            System.out.println(racquet.slice(stringsNew, slice));
            System.out.println(racquet.volley(stringsNew, volley));

            System.out.println("You are working very hard on your game and you practice at least 1000000 more serves");
            System.out.println("How many serves? Enter a number at least 1000000 and less than 2147483647");
            int practiceServes = input3.nextInt();
            System.out.println(racquet.serve(stringsNew, 1000000));
            System.out.println(racquet.hit(1000000));
            //after a large number of hits, the strings will break and the grip will wear down
            System.out.println("It looks like we need new strings and a new grip");
            Scanner input4 = new Scanner(System.in);
            System.out.println("Would you like a restring and regrip. Enter yes if you're not stupid");
            String fix = input4.nextLine();
            System.out.println(racquet.newGrip());
            racquet.cutStrings();
            System.out.println(racquet.stringEntireRacquet());
            //use of the methods that model putting in new strings and putting on a new grip
            System.out.println("Unfortunately you keep on losing and you get mad");
            System.out.println("Do you want to unleash your anger my smashing the racquet? Enter yes");
            String smash = input4.nextLine();
            System.out.println(racquet.smashRacquet());
            System.out.println("Get a new racquet? Enter yes");
            String obtain = input4.nextLine();
            System.out.println(racquet.newRacquet());
            //destroying the racquet and replacing it
            System.out.println("Play again? Enter yes or no");
            play = input4.nextLine();
            //will keep on looping the game if they enter yes
        }
    }

}