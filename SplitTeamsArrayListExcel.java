import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class SplitTeamsArrayListExcel  {

public static void main(String[] args) throws IOException  {
int i = 0;

String firstLine = "";
String line = "";
String playerName = "";
ArrayList<String> players = new ArrayList<String>();
String pointsXL = "";
double Points = 0.0;
ArrayList<Double> points = new ArrayList<Double>();
String reboundsXL = "";
double Rebounds = 0.0;
ArrayList<Double> rebounds = new ArrayList<Double>();
String assistsXL = "";
double Assists = 0.0;
ArrayList<Double> assists = new ArrayList<Double>();
String stealsXL = "";
double Steals = 0.0;
ArrayList<Double> steals = new ArrayList<Double>();
String blocksXL = "";
double Blocks = 0.0;
ArrayList<Double> blocks = new ArrayList<Double>();

   // input from csv using BufferedReader
   String myFilePath = "TotalStatsTest.csv";
   
   try {
   BufferedReader br = new BufferedReader(new FileReader(new File(myFilePath)));     
        // read and skip first line with column labels
        br.readLine();
        
        while ((line = br.readLine()) != null) { 

         if (line.contains(",")) {
                    // do line by line parsing here
                    line = line.trim();
                    // split the line
                    String[] parts = line.split("[,]");
                    // parse out the names and individual stats as strings
                    playerName = parts[0].trim();
                    pointsXL = parts[1].trim();
                    reboundsXL = parts[2].trim();
                    assistsXL = parts[3].trim();
                    stealsXL = parts[4].trim();
                    blocksXL = parts[5].trim();
                    
      System.out.println("Enter Player " + (i+1) +  "'s first and last name: ");
      System.out.println(playerName);
      methodsClass.addPlayer(players, playerName); // uses addPlayer Method from methodsClass class to add to players ArrayList
      
      System.out.println("Enter Player " + (i+1) + "'s Points Per Game (Stats rating of .5 per point): ");
      System.out.println(pointsXL);
      Points = Double.parseDouble(pointsXL); // parses points as double
       while (Points < 0.0) {
         System.out.print("Invalid input!  Please enter amount equal to or greater than 0 for PPG: ");
      }
         methodsClass.addPPG(points, Points); // uses addPPG Method from methodsClass class to add to PPG ArrayList
         
      System.out.println("Enter Player " + (i+1) + "'s Rebounds Per Game (Stats rating of 1.0 per rebound): ");
      System.out.println(reboundsXL);
      Rebounds = Double.parseDouble(reboundsXL); // parses rebounds as double
       while (Rebounds < 0.0) {
         System.out.print("Invalid input!  Please enter amount equal to or greater than 0 for RPG: ");
      }
         methodsClass.addRPG(rebounds, Rebounds); // uses addRPG Method from methodsClass class to add to RPG ArrayList
      
      System.out.println("Enter Player " + (i+1) + "'s Assists Per Game (Stats rating of 1.0 per assist): "); 
      System.out.println(assistsXL);
      Assists = Double.parseDouble(assistsXL); // parses assists as double
       while (Assists < 0.0) {
         System.out.print("Invalid input!  Please enter amount equal to or greater than 0 for RPG: ");
      }
         methodsClass.addAPG(assists, Assists); // uses addAPG Method from methodsClass class to add to APG ArrayList
         
      System.out.println("Enter Player " + (i+1) + "'s Steals Per Game (Stats rating of 3.0 per steal): ");
      System.out.println(stealsXL); 
      Steals = Double.parseDouble(stealsXL); // parses steals as double
       while (Steals < 0.0) {
         System.out.print("Invalid input!  Please enter amount equal to or greater than 0 for SPG: ");
         //Steals = input.nextDouble();
      }
         methodsClass.addSPG(steals, Steals); // uses addSPG Method from methodsClass class to add to SPG ArrayList
      
      System.out.println("Enter Player " + (i+1) + "'s Blocks Per Game (Stats rating of 5.0 per block): ");
      System.out.println(blocksXL);
      Blocks = Double.parseDouble(blocksXL); // parses blocks as double
       while (Blocks < 0.0) {
         System.out.print("Invalid input!  Please enter amount equal to or greater than 0 for BPG: ");
      }
         methodsClass.addBPG(blocks, Blocks); // uses addBPG Method from methodsClass class to add to BPG ArrayList
         
         ++i;  // just used to confirm printing
   }
   } 
   br.close(); // Do not forget to close the scanner
   }    
   catch (Exception e) {
            System.out.println("There was an issue parsing the file.");
        }
       
   int NUM_PLAYERS = players.size();  // used to run loop for total stats rating
   ArrayList<Double> totalStats = new ArrayList<Double>();
   methodsClass.addTotalStats(totalStats, NUM_PLAYERS); // Calls addTotalsStats method to add elements to the totalStats ArrayList. Equals "NUM_ELEMENTS".
      
   System.out.println(totalStats.size());  // This is just test to make sure call works.
     
     // runs the loop to set the values in the totalStats ArrayList of element         
     for (i = 0; i < NUM_PLAYERS; ++i) {
      totalStats.set(i, new Double(points.get(i)*.5 + rebounds.get(i)*1.0 + assists.get(i)*1.0 + steals.get(i)*3.0 + blocks.get(i)*5.0));
   }
     
     // prints everything
     for (i = 0; i < NUM_PLAYERS; ++i) {   
      System.out.printf("The stats summary for Player " + (i+1) + " " + players.get(i) + " is " + points.get(i) + " PPG, " + 
      rebounds.get(i) + " RPG, " +  assists.get(i) + " APG, " + steals.get(i) + " SPG, " + blocks.get(i) + " BPG, and a Total Stats Rating of %.1f.\n" 
      , totalStats.get(i));
   }
   
     // used to run method for determining starting team, this method in methodsClass writes to StartingTeam.txt
     methodsClass.highestRatings(totalStats, players, points, rebounds, assists, steals, blocks);  
     
     // write the total stats rating for each player to file to use for confirmation that final two text files have correct alignment
     FileOutputStream fileByteStreamOut = null; // File output stream
     PrintWriter outFS = null;               // Output stream
     fileByteStreamOut = new FileOutputStream("OriginalPlayers&Stats.txt");
     outFS = new PrintWriter(fileByteStreamOut);
     
     for (i = 0; i < totalStats.size(); ++i) {
         outFS.println(players.get(i));
         outFS.printf("%.1f\r\n", totalStats.get(i));
         
         }  
     outFS.flush();
     
     System.out.println(" ");
     
     // run the mainPartitionMethod in separate class which from there runs the seperate insideMethods class
     mainPartitionMethod.mainTest(totalStats);
         
     // after all methods are complete push the smallest difference of arrays to PracticeTeams.txt
     methodsClass.textFilePullforPractice(players, totalStats);

return;

  }     
}     



