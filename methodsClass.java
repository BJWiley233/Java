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
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;

 public class methodsClass  {
 
 // method used to combine the individual stat ArrayLists into a totalStats rating ArrayList
 public static void addTotalStats(ArrayList<Double> totalStats, int numPlayers) {
      int i = 0;
      for (i = 0; i < numPlayers; ++i) {
            totalStats.add(new Double(i));
      }
      return;
      }

 //method to find who the 5 highest stat's ratings are who should start
 public static void highestRatings (ArrayList<Double> totalStats, ArrayList<String> players, ArrayList<Double> points,
     ArrayList<Double> rebounds, ArrayList<Double> assists, ArrayList<Double> steals, ArrayList<Double> blocks) throws IOException {
     
     FileOutputStream fileByteStream = null; // File output stream
     PrintWriter outFS = null;               // Output stream

      // Try to open file
     fileByteStream = new FileOutputStream("StartingTeam.txt");
     outFS = new PrintWriter(fileByteStream); 
     
     System.out.println("The players with the highest ratings who should start are:");
     outFS.println("The players with the highest ratings who should start are:"); 
     
     // used for comparisons to find the higest, second highest, third highest, fourth highest, and fifth highest stats ratings
     // we use the highest stats rating to qualify these players first so even if a player scores alot but has not other stats
     // he will not make it to the starting team unless he has top five 
     String highestPlayer = "";
     String secondHighestPlayer = "";
     String thirdHighestPlayer = "";
     String fourthHighestPlayer = "";
     String fifthHighestPlayer = "";
     double Rating = 0.0;
     double highestRating = 0.0;
     double secondHighestRating = 0.0;
     double thirdHighestRating = 0.0;
     double fourthHighestRating = 0.0;
     double fifthHighestRating = 0.0;
     int i = 0;
   
   // Array Lists needed for starting team and also to find highest individual stats for each category
   ArrayList<String> startingPlayers = new ArrayList<String>();
   ArrayList<Double> startingPlayersPoints = new ArrayList<Double>();
   double startingPoints = 0.0;
   ArrayList<Double> startingPlayersRebounds = new ArrayList<Double>();
   double startingRebounds = 0.0;
   ArrayList<Double> startingPlayersAssists = new ArrayList<Double>();
   double startingAssists = 0.0;
   ArrayList<Double> startingPlayersSteals = new ArrayList<Double>();
   double startingSteals = 0.0;
   ArrayList<Double> startingPlayersBlocks = new ArrayList<Double>();
   double startingBlocks = 0.0;
     
     // first find the players with the highest ratings and then add their inviduals stats to the starting team individual stats ArrayLists
     
     for (i = 0; i < totalStats.size(); ++i){      
     
     // find player with highest stats rating
     if (totalStats.get(i) > highestRating) {
         highestRating = totalStats.get(i);
         highestPlayer = players.get(i);
         startingPoints = points.get(i);
         startingRebounds = rebounds.get(i);
         startingAssists = assists.get(i);
         startingSteals = steals.get(i);     
         startingBlocks = blocks.get(i);
      }
     } 
     // add that players's stats for individual stat comparison
     startingPlayers.add(highestPlayer);
     startingPlayersPoints.add(startingPoints);
     startingPlayersRebounds.add(startingRebounds);
     startingPlayersAssists.add(startingAssists);
     startingPlayersSteals.add(startingSteals);
     startingPlayersBlocks.add(startingBlocks);
     
     System.out.printf(highestPlayer + " with rating of %.1f\n", highestRating); 
     outFS.println(String.format(highestPlayer + " with rating of %.1f", highestRating)); // send to StartingTeam.txt
     
     // find player with second highest stats rating  
     for (i = 0; i < totalStats.size(); ++i){     
      if (highestRating > totalStats.get(i) && totalStats.get(i) > secondHighestRating) {
         secondHighestRating = totalStats.get(i);
         secondHighestPlayer = players.get(i);  
         startingPoints = points.get(i);
         startingRebounds = rebounds.get(i);
         startingAssists = assists.get(i);
         startingSteals = steals.get(i);     
         startingBlocks = blocks.get(i);      
      }
     } 
     // add that players's stats for individual stat comparison
     startingPlayers.add(secondHighestPlayer);
     startingPlayersPoints.add(startingPoints);
     startingPlayersRebounds.add(startingRebounds);
     startingPlayersAssists.add(startingAssists);
     startingPlayersSteals.add(startingSteals);
     startingPlayersBlocks.add(startingBlocks);
     
     System.out.printf(secondHighestPlayer + " with rating of %.1f\n", secondHighestRating); 
     outFS.println(String.format(secondHighestPlayer + " with rating of %.1f\n", secondHighestRating)); // send to StartingTeam.txt
      
     // find player with third highest stats rating 
     for (i = 0; i < totalStats.size(); ++i){     
      if (secondHighestRating > totalStats.get(i) && totalStats.get(i) > thirdHighestRating) {
         thirdHighestRating = totalStats.get(i);
         thirdHighestPlayer = players.get(i);   
         startingPoints = points.get(i);
         startingRebounds = rebounds.get(i);
         startingAssists = assists.get(i);
         startingSteals = steals.get(i);     
         startingBlocks = blocks.get(i);
      }
     } 
     // add that players's stats for individual stat comparison
     startingPlayers.add(thirdHighestPlayer);
     startingPlayersPoints.add(startingPoints);
     startingPlayersRebounds.add(startingRebounds);
     startingPlayersAssists.add(startingAssists);
     startingPlayersSteals.add(startingSteals);
     startingPlayersBlocks.add(startingBlocks);
     
     System.out.printf(thirdHighestPlayer + " with rating of %.1f\n", thirdHighestRating); 
     outFS.println(String.format(thirdHighestPlayer + " with rating of %.1f\n", thirdHighestRating)); // send to StartingTeam.txt
     
     // find player with fourth highest stats rating 
     for (i = 0; i < totalStats.size(); ++i){     
      if (thirdHighestRating > totalStats.get(i) && totalStats.get(i) > fourthHighestRating) {
         fourthHighestRating = totalStats.get(i);
         fourthHighestPlayer = players.get(i);   
         startingPoints = points.get(i);
         startingRebounds = rebounds.get(i);
         startingAssists = assists.get(i);
         startingSteals = steals.get(i);     
         startingBlocks = blocks.get(i);
      }
     } 
     // add that players's stats for individual stat comparison
     startingPlayers.add(fourthHighestPlayer);
     startingPlayersPoints.add(startingPoints);
     startingPlayersRebounds.add(startingRebounds);
     startingPlayersAssists.add(startingAssists);
     startingPlayersSteals.add(startingSteals);
     startingPlayersBlocks.add(startingBlocks);
     
     System.out.printf(fourthHighestPlayer + " with rating of %.1f\n", fourthHighestRating);
     outFS.println(String.format(fourthHighestPlayer + " with rating of %.1f\n", fourthHighestRating)); // send to StartingTeam.txt
     
     // find player with fifth highest stats rating 
     for (i = 0; i < totalStats.size(); ++i){     
      if (fourthHighestRating > totalStats.get(i) && totalStats.get(i) > fifthHighestRating) {
         fifthHighestRating = totalStats.get(i);
         fifthHighestPlayer = players.get(i);   
         startingPoints = points.get(i);
         startingRebounds = rebounds.get(i);
         startingAssists = assists.get(i);
         startingSteals = steals.get(i);     
         startingBlocks = blocks.get(i);
      }
     } 
     // add that players's stats for individual stat comparison
     startingPlayers.add(fifthHighestPlayer);
     startingPlayersPoints.add(startingPoints);
     startingPlayersRebounds.add(startingRebounds);
     startingPlayersAssists.add(startingAssists);
     startingPlayersSteals.add(startingSteals);
     startingPlayersBlocks.add(startingBlocks);
     
     System.out.printf(fifthHighestPlayer + " with rating of %.1f\n", fifthHighestRating);
     outFS.println(String.format(fifthHighestPlayer + " with rating of %.1f\n", fifthHighestRating));  // send to StartingTeam.txt
     
     System.out.println("Out of the starting players here is the position line up:");
     System.out.println("Starting Players " + startingPlayers + " Starting Points " + startingPlayersPoints +
      " Starting Rebounds " + startingPlayersRebounds + " Starting Assists " + startingPlayersAssists + 
      " Starting Steals " + startingPlayersSteals + " Starting Blocks " + startingPlayersBlocks);
    
    //Find starting player with highest points per game and label shooting guard  
     double maxPPG = 0;
     i = 0;
     String highestScorer = "";   
     for (i = 0; i < 3; ++i){ 
      if (startingPlayersPoints.get(i) > maxPPG) {
         maxPPG = startingPlayersPoints.get(i);
         highestScorer = startingPlayers.get(i);
      }
    }
    System.out.println(highestScorer + " has the highest PPG, " + maxPPG + ", and will start as shooting guard/guard 2.");
    outFS.println(highestScorer + " has the highest PPG, " + maxPPG + ", and will start as shooting guard/guard 2."); // send to StartingTeam.txt
  
    //Find starting player with highest rebounds per game and label power forward  
     double maxRPG = 0;
     i = 0;
     String highestRebounder = "";    
     for (i = 0; i < 5; ++i){
      if (startingPlayersRebounds.get(i) > maxRPG && startingPlayers.get(i) != highestScorer) {
         maxRPG = startingPlayersRebounds.get(i);
         highestRebounder = startingPlayers.get(i);
      }
    }
    System.out.println(highestRebounder + " has the highest RPG, " + maxRPG + ", and will start as power forward.");
    outFS.println(highestRebounder + " has the highest RPG, " + maxRPG + ", and will start as power forward."); // send to StartingTeam.txt
  
    //Find starting player with highest assists per game and label point guard  
     double maxAPG = 0;
     i = 0;
     String highestAssister = "";
     for (i = 0; i < 5; ++i){
      if (startingPlayersAssists.get(i) > maxAPG && startingPlayers.get(i) != highestScorer && startingPlayers.get(i) != highestRebounder) {
         maxAPG = startingPlayersAssists.get(i);
         highestAssister = startingPlayers.get(i);
      }
    }
    System.out.println(highestAssister + " has the highest APG, " + maxAPG + ", and will start as point guard.");
    outFS.println(highestAssister + " has the highest APG, " + maxAPG + ", and will start as point guard."); // send to StartingTeam.txt
  
   //Find starting player with highest steals per game and label tall guard/small forward  
     double maxSPG = 0;
     i = 0;
     String highestStealer = "";     
     for (i = 0; i < 5; ++i){
      if (startingPlayersSteals.get(i) > maxSPG && startingPlayers.get(i) != highestScorer && startingPlayers.get(i) != highestRebounder && startingPlayers.get(i) != highestAssister) {
         maxSPG = startingPlayersSteals.get(i);
         highestStealer = startingPlayers.get(i);
      }
    }
    System.out.println(highestStealer + " has the highest SPG, " + maxSPG + ", and will start as tall guard/small forward.");
    outFS.println(highestStealer + " has the highest SPG, " + maxSPG + ", and will start as tall guard/small forward."); // send to StartingTeam.txt
   
   //Find starting player with highest blocks per game and label center  
     double maxBPG = 0;
     i = 0;
     String highestBlocker = "";
     for (i = 0; i < 5; ++i){
      if (startingPlayersBlocks.get(i) > maxBPG && startingPlayers.get(i) != highestScorer && startingPlayers.get(i) != highestRebounder && startingPlayers.get(i) != highestAssister && startingPlayers.get(i) != highestStealer) {
         maxBPG = startingPlayersBlocks.get(i);
         highestBlocker = startingPlayers.get(i);
      }
    }
    System.out.println(highestBlocker + " has the highest BPG, " + maxBPG + ", and will start as center.");
    outFS.println(highestBlocker + " has the highest BPG, " + maxBPG + ", and will start as center."); // send to StartingTeam.txt
    outFS.flush(); // flush to file
} 
   
   
   // textFilePull and textFilePush methods to file SmallestDiffSoFar.txt which is used continuously to update
   // after each insideMethod classes methods.  If difference is smaller push and re-pull else just re-pull   
   
   public static void textFilePull (List<Double> array1, List<Double> array2) throws IOException {

   FileInputStream fileByteStream = null; // File input stream
   Scanner inFS = null; // Scanner object
 
   fileByteStream = new FileInputStream("SmallestDiffSoFar.txt"); // pulls from this file
   inFS = new Scanner(fileByteStream);
   int i = 0;
 
   i = 0;
   System.out.println("Array 1");
      while (i < array1.size()){
      array1.set(i, Double.parseDouble(inFS.nextLine()));
      System.out.print(array1.get(i) + " ");
      ++i;
      }  
   inFS.nextLine(); // used to remove the space after the last stat rating, blank pull 
   
   i = 0;
   System.out.println("");
   System.out.println("Array 2");
      while (i < array2.size()){
      array2.set(i, Double.parseDouble(inFS.nextLine()));
      System.out.print(array2.get(i) + " ");
      ++i;
      } 
   System.out.println("");
   
   return;
   }

   public static void textFilePush(List<Double> array1, List<Double> array2) throws IOException {

   FileOutputStream fileByteStreamOut = null; // File output stream
   PrintWriter outFS = null;               // Output stream
   int i = 0;
   double sumArray1 = 0;
   double sumArray2 = 0;

   fileByteStreamOut = new FileOutputStream("SmallestDiffSoFar.txt");
   outFS = new PrintWriter(fileByteStreamOut);
   
   // decided to use BufferedWriter here since it works better
   File file = new File("SmallestDiffSoFar.txt");
   FileWriter out = new FileWriter("SmallestDiffSoFar.txt", true);
   BufferedWriter bw = new BufferedWriter(new FileWriter("SmallestDiffSoFar.txt", true));
          
   i = 0;
   sumArray1 = 0.0;
         while (i < array1.size()) {
         bw.append(String.format("%.1f \n", array1.get(i)));
         sumArray1 += array1.get(i);
         ++i;
         } 
         bw.append("\r\n");

   i = 0;
   sumArray2 = 0.0;
         while (i < array2.size()) {
         bw.append(String.format("%.1f \n", array2.get(i)));
         sumArray2 += array2.get(i);
         ++i;
         }
         bw.append("\r\n");    
         bw.append("Sum Array 1:");
         bw.append(String.format("(%.1f)\n", sumArray1));
         bw.append("\r\n");
         bw.append("Sum Array 2:");
         bw.append(String.format("(%.1f)\n", sumArray2));  
         bw.flush();
         
         fileByteStreamOut.close(); // close() may throw IOException if fails
         
   return;
   }

   // final method to reprint the SmallestDiffSoFar to PracticeTeams file with names and stats and not just stats
   public static void textFilePullforPractice (List<String> players, List<Double> totalStats) throws IOException {
   
   // inputs from SmallestDiffSoFar which was continually update by insideMethods class
   FileInputStream fileByteStream = null; // File input stream
   Scanner inFS = null; // Scanner object
   fileByteStream = new FileInputStream("SmallestDiffSoFar.txt"); // pulls from this file
   inFS = new Scanner(fileByteStream);
   
   // compare above file with OriginalPlayers&Stats.txt file
   FileInputStream fileByteStream2 = null; // File input stream
   Scanner inOriginal = null; // Scanner object
   fileByteStream2 = new FileInputStream("OriginalPlayers&Stats.txt"); // pulls from this file
   inOriginal = new Scanner(fileByteStream2);
   
   // writes the FINAL RESULT and COMPLETES PROJECT!!!! Whoo hooo!!!!!!
   FileOutputStream fileByteStreamOut = null; // File output stream
   PrintWriter outFS = null;               // Output stream
   fileByteStreamOut = new FileOutputStream("PracticeTeams.txt");
   outFS = new PrintWriter(fileByteStreamOut);
   
   int i = 0;
   
   //ArrayList<Double> totalStatsDecimal = new ArrayList<Double>();
   ArrayList<Double> array1 = new ArrayList<Double>();  // sets 1 of 2 arrays from 
   ArrayList<Double> array2 = new ArrayList<Double>();
   ArrayList<String> practiceTeam1 = new ArrayList<String>();
   ArrayList<String> practiceTeam2 = new ArrayList<String>();
   
   System.out.println("Final Method");
   
   // pulls the OriginalPlayers&Stats.txt so we have comparison alignment confirmation
   for (int p = 0; p < players.size(); ++p) {
   players.set(p, inOriginal.nextLine());
   System.out.println(players.get(p));
   totalStats.set(p, Double.parseDouble(inOriginal.nextLine())); 
   roundOneDecimal(totalStats.get(p));
   System.out.println(totalStats.get(p));
   }
   
   i = 0;
  
   System.out.println("Array 1");
   
   // pulls in first team array from SmallestDiffSoFar.txt
   while (i < (totalStats.size()/2)){
   array1.add(i, inFS.nextDouble());
   System.out.print(array1.get(i) + " ");
      // gets comparison from OriginalPlayers&Stats.txt
      for(int k = 0; k < totalStats.size(); ++k){
         if (roundOneDecimal(totalStats.get(k)) == roundOneDecimal(array1.get(i))){
         System.out.println("Y ");
         practiceTeam1.add(players.get(k));
         players.add(players.get(k));
         players.remove(k);
         totalStats.add(totalStats.get(k));
         totalStats.remove(k);
         break;
         }
         else {
         System.out.print("N ");
         }
        }
      ++i;
      }  
   System.out.println("");
   
   // writes Practice Team 1
   System.out.println("Players on Practice Team 1 Include (stats rating to the right):");
   outFS.println("Players on Practice Team 1 Include (stats rating to the right):");
   for (i = 0; i <(totalStats.size()/2); ++i) {
   System.out.print(practiceTeam1.get(i) + " ");
   outFS.print(practiceTeam1.get(i) + " ");
   System.out.print(array1.get(i));
   outFS.print(array1.get(i));
   System.out.println("");
   outFS.println("");
   }
   
   // pulls in second team array from SmallestDiffSoFar.txt
   i = (totalStats.size()/2);
   System.out.println("");
   System.out.println("Array 2");
   
   int j = 0;
   while (i < totalStats.size()){
   array2.add(j, inFS.nextDouble());
   System.out.print(array2.get(j) + " ");
      // gets comparison from OriginalPlayers&Stats.txt
      for(int m = 0; m < totalStats.size(); ++m) {
      if (roundOneDecimal(totalStats.get(m)) == roundOneDecimal(array2.get(j))){
      System.out.println("Y ");
      practiceTeam2.add(players.get(m));
      players.add(players.get(m));
      players.remove(m);
      totalStats.add(totalStats.get(m));
      totalStats.remove(m);
      break;
      }
      else {
      System.out.print("N ");
      }
     }
   ++i;
   ++j;
   }   
   System.out.println("");
   outFS.println("");
   
   // writes Practice Team 2   
   System.out.println("Players on Practice Team 2 Include (stats rating to the right):");
   outFS.println("Players on Practice Team 2 Include (stats rating to the right):");
   for (i = 0; i <(players.size()/2); ++i) {
   System.out.print(practiceTeam2.get(i) + " ");
   outFS.print(practiceTeam2.get(i) + " ");
   System.out.print(array2.get(i));
   outFS.print(array2.get(i));
   System.out.println("");
   outFS.println("");
   }
   
   outFS.flush(); // flush to file
   fileByteStreamOut.close(); // close() may throw IOException if fails
   
   return;
   }
   
   // method for rounding double to only one decimal place else the final method for comparison to OriginalPlayers&Stats.txt
   // does not work
   public static double roundOneDecimal(double d) {
    double total = d;
    total = Math.round(total * 10);
    total = total/10;
    return total;
   }
}