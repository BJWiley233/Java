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

public class SplitTeamsArrayList  {

public static void main(String[] args) throws IOException  {
int i = 0;
int NUM_PLAYERS = 0;
String playerName = "";
ArrayList<String> players = new ArrayList<String>();
double Points = 0.0;
ArrayList<Double> points = new ArrayList<Double>();
double Rebounds = 0.0;
ArrayList<Double> rebounds = new ArrayList<Double>();
double Assists = 0.0;
ArrayList<Double> assists = new ArrayList<Double>();
double Steals = 0.0;
ArrayList<Double> steals = new ArrayList<Double>();
double Blocks = 0.0;
ArrayList<Double> blocks = new ArrayList<Double>();

   FileInputStream fileByteStream = null; // File input stream
   Scanner inFS = null; // Scanner object
 
   fileByteStream = new FileInputStream("TotalStatsFile.txt"); // pulls from this file
   inFS = new Scanner(fileByteStream);
  


   //This will input based on text file with number of total players
   
   System.out.print("Enter total amount of players.  There must be a positive, even amount of players: ");
   NUM_PLAYERS = Integer.parseInt(inFS.nextLine());
      while (NUM_PLAYERS < 0 | NUM_PLAYERS % 2 != 0) {
      System.out.print("You entered a negative or odd number.  Please enter a positive, even amount: ");
      NUM_PLAYERS = inFS.nextInt();
     }
   
   final int NUM_ELEMENTS = NUM_PLAYERS; //iniliazes to use for creating total size of ArrayLists
   System.out.println("You have entered " + NUM_ELEMENTS + " players.");  
   
   //loop to input Player names and individual per game stats and add to ArrayLists
   for (i=0; i < NUM_ELEMENTS; ++i) {
       
      System.out.println("Enter Player " + (i+1) +  "'s first and last name: ");
      playerName = inFS.nextLine(); //pulls player name
      methodsClass.addPlayer(players, playerName); //uses addPlayer Method from methodsClass class to add to players ArrayList
      
      System.out.println("Enter Player " + (i+1) + "'s Points Per Game (Stats rating of .5 per point): ");
      Points = Double.parseDouble(inFS.nextLine());//pulls points
       while (Points < 0.0) {
         System.out.print("Invalid input!  Please enter amount equal to or greater than 0 for PPG: ");
      }
         methodsClass.addPPG(points, Points); //uses addPPG Method from methodsClass class to add to PPG ArrayList
         
      System.out.println("Enter Player " + (i+1) + "'s Rebounds Per Game (Stats rating of 1.0 per rebound): ");
      Rebounds = Double.parseDouble(inFS.nextLine()); //pulls rebounds
       while (Rebounds < 0.0) {
         System.out.print("Invalid input!  Please enter amount equal to or greater than 0 for RPG: ");
      }
         methodsClass.addRPG(rebounds, Rebounds); //uses addRPG Method from methodsClass class to add to RPG ArrayList
      
      System.out.println("Enter Player " + (i+1) + "'s Assists Per Game (Stats rating of 1.0 per assist): ");
      Assists = Double.parseDouble(inFS.nextLine()); //pulls assists
       while (Assists < 0.0) {
         System.out.print("Invalid input!  Please enter amount equal to or greater than 0 for RPG: ");
      }
         methodsClass.addAPG(assists, Assists); //uses addAPG Method from methodsClass class to add to APG ArrayList
         
      System.out.println("Enter Player " + (i+1) + "'s Steals Per Game (Stats rating of 3.0 per steal): ");
      Steals = Double.parseDouble(inFS.nextLine());  //pulls steals
       while (Steals < 0.0) {
         System.out.print("Invalid input!  Please enter amount equal to or greater than 0 for SPG: ");
      }
         methodsClass.addSPG(steals, Steals); //uses addSPG Method from methodsClass class to add to SPG ArrayList
      
      System.out.println("Enter Player " + (i+1) + "'s Blocks Per Game (Stats rating of 5.0 per block): ");
      Blocks = Double.parseDouble(inFS.nextLine());//pulls blocks
       while (Blocks < 0.0) {
         System.out.print("Invalid input!  Please enter amount equal to or greater than 0 for BPG: ");
      }
         methodsClass.addBPG(blocks, Blocks); //uses addBPG Method from methodsClass class to add to BPG ArrayList
   }
   
   ArrayList<Double> totalStats = new ArrayList<Double>();
   methodsClass.addTotalStats(totalStats, NUM_ELEMENTS); //Calls addTotalsStats method to add elements to the totalStats ArrayList. Equals "NUM_ELEMENTS".
      
   System.out.println(totalStats.size());  // This is just test to make sure call works.
              
     for (i = 0; i < NUM_ELEMENTS; ++i) {
      totalStats.set(i, new Double(points.get(i)*.5 + rebounds.get(i)*1.0 + assists.get(i)*1.0 + steals.get(i)*3.0 + blocks.get(i)*5.0));
   }

     for (i = 0; i < NUM_ELEMENTS; ++i){   
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



