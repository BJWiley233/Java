import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

public class PlayerInterfaceLoopOutputArea extends JPanel {
   
   
   
    /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   public static Container addComponentsToPane(Container pane) throws IOException {
      // Used to specify GUI component layout
      // Labels for Total Players, each player and their PPG, RBG, ABG, SPG, BPG
   JLabel TotalPlayersLabel;
   JLabel TototalPlayersUpdateComment;
   JLabel outputLabel;
   JLabel [] LabelPlayers = {new JLabel("Player1"), new JLabel("Player2"), new JLabel("Player3"), new JLabel("Player4"), new JLabel("Player5"), new JLabel("Player6"), new JLabel("Player7"), new JLabel("Player8"), new JLabel("Player9"), new JLabel("Player10")};
   JLabel [] LabelPoints = {new JLabel("Player1"), new JLabel("Player2"), new JLabel("Player3"), new JLabel("Player4"), new JLabel("Player5"), new JLabel("Player6"), new JLabel("Player7"), new JLabel("Player8"), new JLabel("Player9"), new JLabel("Player10")};
   JLabel [] LabelRebounds = {new JLabel("Player1"), new JLabel("Player2"), new JLabel("Player3"), new JLabel("Player4"), new JLabel("Player5"), new JLabel("Player6"), new JLabel("Player7"), new JLabel("Player8"), new JLabel("Player9"), new JLabel("Player10")};
   JLabel [] LabelAssists = {new JLabel("Player1"), new JLabel("Player2"), new JLabel("Player3"), new JLabel("Player4"), new JLabel("Player5"), new JLabel("Player6"), new JLabel("Player7"), new JLabel("Player8"), new JLabel("Player9"), new JLabel("Player10")};
   JLabel [] LabelSteals = {new JLabel("Player1"), new JLabel("Player2"), new JLabel("Player3"), new JLabel("Player4"), new JLabel("Player5"), new JLabel("Player6"), new JLabel("Player7"), new JLabel("Player8"), new JLabel("Player9"), new JLabel("Player10")};
   JLabel [] LabelBlocks = {new JLabel("Player1"), new JLabel("Player2"), new JLabel("Player3"), new JLabel("Player4"), new JLabel("Player5"), new JLabel("Player6"), new JLabel("Player7"), new JLabel("Player8"), new JLabel("Player9"), new JLabel("Player10")};
      // JTextFields for Total Players, each player and their PPG, RBG, ABG, SPG, BPG
   JTextField TotalPlayers;
   JTextField [] Players = {new JTextField("Player1"), new JTextField("Player2"), new JTextField("Player3"), new JTextField("Player4"), new JTextField("Player5"), new JTextField("Player6"), new JTextField("Player7"), new JTextField("Player8"), new JTextField("Player9"), new JTextField("Player10")};
   JTextField [] Points = {new JTextField("Player1"), new JTextField("Player2"), new JTextField("Player3"), new JTextField("Player4"), new JTextField("Player5"), new JTextField("Player6"), new JTextField("Player7"), new JTextField("Player8"), new JTextField("Player9"), new JTextField("Player10")};
   JTextField [] Rebounds = {new JTextField("Player1"), new JTextField("Player2"), new JTextField("Player3"), new JTextField("Player4"), new JTextField("Player5"), new JTextField("Player6"), new JTextField("Player7"), new JTextField("Player8"), new JTextField("Player9"), new JTextField("Player10")};
   JTextField [] Assists = {new JTextField("Player1"), new JTextField("Player2"), new JTextField("Player3"), new JTextField("Player4"), new JTextField("Player5"), new JTextField("Player6"), new JTextField("Player7"), new JTextField("Player8"), new JTextField("Player9"), new JTextField("Player10")};
   JTextField [] Steals = {new JTextField("Player1"), new JTextField("Player2"), new JTextField("Player3"), new JTextField("Player4"), new JTextField("Player5"), new JTextField("Player6"), new JTextField("Player7"), new JTextField("Player8"), new JTextField("Player9"), new JTextField("Player10")};
   JTextField [] Blocks = {new JTextField("Player1"), new JTextField("Player2"), new JTextField("Player3"), new JTextField("Player4"), new JTextField("Player5"), new JTextField("Player6"), new JTextField("Player7"), new JTextField("Player8"), new JTextField("Player9"), new JTextField("Player10")};
   JButton calcButton; // final calculate button must be hit each time there are updates to the number of players or players
   int i = 0;  //loop variable for intstantiating parameters for JLabels, JTextFields, and GridBag Layout
   int totalNumPlayers = 10; // just using 10 for now.  User can change if there is more.  You can enter less than 10 w/o changing
   
      GridBagConstraints layoutConst = null;
      calcButton = new JButton("Calculate");

      // Don't need to put the Number of Players JLabel and JTextField creation in Loop
      TotalPlayersLabel = new JLabel("Total Players:");   
      TototalPlayersUpdateComment = new JLabel ("(ALWAYS UPDATE AND RECALCULATE WHEN CHANGING PLAYER QUANITY!)");
      TototalPlayersUpdateComment.setFont(new Font("Dialog", Font.ITALIC, 9));
      TotalPlayers = new JTextField(5);
      TotalPlayers.setEditable(true);
      TotalPlayers.setText("0");
      
      // Set the type of layout for the JPanel Container
      pane.setLayout(new GridBagLayout());
      
      // Layout contraint for Number of Players
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      layoutConst.insets = new Insets(3, 5, 0, 280);
      pane.add(TotalPlayersLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.weightx = 1;
      layoutConst.gridy = 1;
      layoutConst.insets = new Insets(0, 5, 20, 10);
      pane.add(TototalPlayersUpdateComment, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      layoutConst.insets = new Insets(3, 0, 0, 100);
      pane.add(TotalPlayers, layoutConst);

      // Set JLabels
      for (i = 0; i < totalNumPlayers; ++i) {      
      LabelPlayers[i] = new JLabel("Player " + (i+1) + " Name (First and Last):");
      LabelPoints[i] = new JLabel ("Points per Game:");
      LabelRebounds[i]= new JLabel ("Rebounds per Game:");
      LabelAssists[i]= new JLabel ("Assists per Game:");
      LabelSteals[i]= new JLabel ("Steals per Game:");
      LabelBlocks[i] = new JLabel ("Blocks per Game:");
      }
   
      // Set JTextFields
      for (i = 0; i < totalNumPlayers; ++i) {      
      Players[i] = new JTextField(15);
      Players[i].setEditable(true);
      Players[i].setText("");
      Points[i] = new JTextField(5);
      Points[i].setEditable(true);
      Points[i].setText("0");
      Rebounds[i] = new JTextField(5);
      Rebounds[i].setEditable(true);
      Rebounds[i].setText("0");
      Assists[i] = new JTextField(5);
      Assists[i].setEditable(true);
      Assists[i].setText("0");
      Steals[i] = new JTextField(5);
      Steals[i].setEditable(true);
      Steals[i].setText("0");
      Blocks[i] = new JTextField(5);
      Blocks[i].setEditable(true);
      Blocks[i].setText("0"); 
      //Blocks[i].addActionListener(this);     
      }  
         
      // Use loop to determine a GridBagLayout contraints for where the Labels and TextFields go for all 10 players
      int j = 1;
      for (i = 0; i < totalNumPlayers; ++i) {
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = (i*6) + 2;
      layoutConst.insets = new Insets(2, 3, 2, 50);
      pane.add(LabelPlayers[i], layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = (i*6) + 2;
      layoutConst.insets = new Insets(2, 8, 2, 0);
      pane.add(Players[i], layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = (i*6) + 3;
      layoutConst.insets = new Insets(2, 0, 2, 90);
      pane.add(LabelPoints[i], layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = (i*6) + 3;
      layoutConst.insets = new Insets(2, 0, 2, 0);
      pane.add(Points[i], layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = (i*6) + 4;
      layoutConst.insets = new Insets(2, 0, 2, 69);
      pane.add(LabelRebounds[i], layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = (i*6) + 4;
      layoutConst.insets = new Insets(2, 0, 2, 0);
      pane.add(Rebounds[i], layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = (i*6) + 5;
      layoutConst.insets = new Insets(2, 0, 2, 81);
      pane.add(LabelAssists[i], layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = (i*6) + 5;
      layoutConst.insets = new Insets(2, 0, 2, 0);
      pane.add(Assists[i], layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = (i*6) + 6;
      layoutConst.insets = new Insets(2, 0, 2, 90);
      pane.add(LabelSteals[i], layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = (i*6) + 6;
      layoutConst.insets = new Insets(2, 0, 2, 0);
      pane.add(Steals[i], layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = (i*6) + 7;
      layoutConst.insets = new Insets(2, 0, 2, 85);
      pane.add(LabelBlocks[i], layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = (i*6)+ 7;
      layoutConst.insets = new Insets(2, 0, 2, 0);
      pane.add(Blocks[i], layoutConst);
      j = j+6;
    }
    
      // set layout contraints for Calculate button, output label and output Area.
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 2;
      layoutConst.gridy = j+1;
      layoutConst.insets = new Insets(15, 0, 20, 30);
      pane.add(calcButton, layoutConst);
      
      outputLabel = new JLabel("Practice Teams Output:");
      JTextArea outputArea;
      outputArea = new JTextArea(10, 15);
      JScrollPane scrollPaneOutput = new JScrollPane(outputArea);
      
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = j+2;
      layoutConst.insets = new Insets(15, 0, 20, 200);
      pane.add(outputLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = j+3;
      layoutConst.gridwidth = 4; // 4 cells wide
      pane.add(scrollPaneOutput, layoutConst);
   
   // Add action listener to Calculate button, runs the methodsClass, mainPartitionMethod, and insideMethods classes.  Also copies the final
   // textFilePullforPractice method in because Java is unable to append the outputArea with a void method.
   calcButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent event)  {
   
      outputArea.setText("");  // clears outputArea text
      int i = 0; // loop variable
      // ArrayLists to add TextField entries to after parsing
      ArrayList<String> arrayPlayers = new ArrayList<String>();
      ArrayList<Double> arrayPoints = new ArrayList<Double>();
      ArrayList<Double> arrayRebounds = new ArrayList<Double>();
      ArrayList<Double> arrayAssists = new ArrayList<Double>();
      ArrayList<Double> arraySteals = new ArrayList<Double>();
      ArrayList<Double> arrayBlocks = new ArrayList<Double>();
      ArrayList<Double> totalStats = new ArrayList<Double>();
      
      // Strings that take the TextField entries and then are parsed as double to arrays above
      String userInput = "";
      double points = 0.0;
      double rebounds = 0.0;
      double assists = 0.0;
      double steals = 0.0;
      double blocks = 0.0;
      int totalNumPlayers = 0;    
      
      userInput = TotalPlayers.getText();
      // Convert from String to an integer
      totalNumPlayers = Integer.parseInt(userInput);
      System.out.println(totalNumPlayers);
      
      // interates through number of players to input names and individual stats and add them to the ArrayLists
      for (i = 0; i < totalNumPlayers; ++i){
      userInput = Players[i].getText();
      arrayPlayers.add(userInput);
      userInput = Points[i].getText();
      points = Double.parseDouble(userInput);
      arrayPoints.add(points);
      userInput = Rebounds[i].getText();
      rebounds = Double.parseDouble(userInput);
      arrayRebounds.add(rebounds);
      userInput = Assists[i].getText();
      assists = Double.parseDouble(userInput);
      arrayAssists.add(assists);
      userInput = Steals[i].getText();
      steals = Double.parseDouble(userInput);
      arraySteals.add(steals);
      userInput = Blocks[i].getText();
      blocks = Double.parseDouble(userInput);
      arrayBlocks.add(blocks);
      }
      
      // just a print statement to confirm Arrays lists are filled
      for (i = 0; i < totalNumPlayers; ++i) {
      System.out.println(arrayPlayers.get(i));
      System.out.println(arrayPoints.get(i));
      System.out.println(arrayRebounds.get(i));
      System.out.println(arrayAssists.get(i));
      System.out.println(arraySteals.get(i));
      System.out.println(arrayBlocks.get(i));
   }
   
   // Calls addTotalsStats method from methodsClass to add elements to the totalStats ArrayList. Equals "totalNumPlayers"
   methodsClass.addTotalStats(totalStats, totalNumPlayers);
   
   // sets total stats ArrayList with the weighted values from all the individual stats
   for (i = 0; i < totalNumPlayers; ++i) {
      totalStats.set(i, new Double(arrayPoints.get(i)*.5 + arrayRebounds.get(i)*1.0 + arrayAssists.get(i)*1.0 + arraySteals.get(i)*3.0 + arrayBlocks.get(i)*5.0));
   }
   
   // just prints out total stats rating and individual stats for each player
   for (i = 0; i < totalNumPlayers; ++i){   
      System.out.printf("The stats summary for Player " + (i+1) + " " + arrayPlayers.get(i) + " is " + arrayPoints.get(i) + " PPG, " + 
      arrayRebounds.get(i) + " RPG, " +  arrayAssists.get(i) + " APG, " + arraySteals.get(i) + " SPG, " + arrayBlocks.get(i) + " BPG, and a Total Stats Rating of %.1f.\n" 
      , totalStats.get(i));
   }
   
   // used to run method in methodsClass for determining starting team, this method in methodsClass writes to StartingTeam.txt
   try {
   methodsClass.highestRatings(totalStats, arrayPlayers, arrayPoints, arrayRebounds, arrayAssists, arraySteals, arrayBlocks);  
   }
   catch (Exception excpt) {
            // Prints the error message passed by throw statement
            System.out.println(excpt.getMessage());
            System.out.println("Cannot perform 287");
         }
    
    // write the total stats rating for each player to file to use for confirmation that final two text files have correct alignment 
    FileOutputStream fileByteStreamOut = null; // File output stream
    PrintWriter outFS = null;               // Output stream
    try {
    fileByteStreamOut = new FileOutputStream("OriginalPlayers&Stats.txt");
    }
    catch (Exception excpt) {
            // Prints the error message passed by throw statement
            System.out.println(excpt.getMessage());
            System.out.println("Cannot perform");
         }
    outFS = new PrintWriter(fileByteStreamOut);
     
    // loop to write the totalStats rating for each player to the alignment file above
    for (i = 0; i < totalStats.size(); ++i) {
         outFS.println(arrayPlayers.get(i));
         outFS.printf("%.1f\r\n", totalStats.get(i));
         
         }  
    outFS.flush(); // flush to file 
     
    System.out.println(" ");
    
    // run the mainPartitionMethod in separate class which from there runs the seperate insideMethods class 
    try {
    mainPartitionMethod.mainTest(totalStats);
    }
    catch (Exception excpt) {
            // Prints the error message passed by throw statement
            System.out.println(excpt.getMessage());
            System.out.println("Cannot perform");
         }
     
     // after all methods are complete push the smallest difference of arrays to PracticeTeams.txt
     try {
     methodsClass.textFilePullforPractice(arrayPlayers, totalStats);
     }
     catch (Exception excpt) {
            // Prints the error message passed by throw statement
            System.out.println(excpt.getMessage());
            System.out.println("Cannot perform");
         }
      
   
   // As indicated before the Action Listener we need to rewrite the final method from methodsClass.textFilePullforPractice because it is
   // void and you cannot apend the outputArea with it directly.  Lines 364-468 here do exactly this.   
   FileInputStream fileByteStream = null; // File input stream
   Scanner inFS = null; // Scanner object
   try {
   fileByteStream = new FileInputStream("SmallestDiffSoFar.txt"); // pulls from this file
   } catch (Exception excpt) {
            // Prints the error message passed by throw statement
            System.out.println(excpt.getMessage());
            System.out.println("Cannot compute");
         }
   inFS = new Scanner(fileByteStream);
   
   FileInputStream fileByteStream2 = null; // File input stream
   Scanner inOriginal = null; // Scanner object
   try {
   fileByteStream2 = new FileInputStream("OriginalPlayers&Stats.txt"); // pulls from this file
   } catch (Exception excpt) {
            // Prints the error message passed by throw statement
            System.out.println(excpt.getMessage());
            System.out.println("Cannot compute");
         }

   inOriginal = new Scanner(fileByteStream2);
 
   int b = 0;
   
   // ArrayList<Double> totalStatsDecimal = new ArrayList<Double>();
   ArrayList<Double> array1 = new ArrayList<Double>();
   ArrayList<Double> array2 = new ArrayList<Double>();
   ArrayList<String> practiceTeam1 = new ArrayList<String>();
   ArrayList<String> practiceTeam2 = new ArrayList<String>();
   
   System.out.println("Final Method");
   
   for (int p = 0; p < arrayPlayers.size(); ++p) {
   arrayPlayers.set(p, inOriginal.nextLine());
   System.out.println(arrayPlayers.get(p));
   totalStats.set(p, Double.parseDouble(inOriginal.nextLine())); 
   methodsClass.roundOneDecimal(totalStats.get(p));
   System.out.println(totalStats.get(p));
   }
   
   b = 0;
   System.out.println("Array 1");
   
   while (b < (totalStats.size()/2)){
   array1.add(b, inFS.nextDouble());
   System.out.print(array1.get(b) + " ");
      for(int k = 0; k < totalStats.size(); ++k){
         if (methodsClass.roundOneDecimal(totalStats.get(k)) == methodsClass.roundOneDecimal(array1.get(b))){
         System.out.println("Y ");
         practiceTeam1.add(arrayPlayers.get(k));
         arrayPlayers.add(arrayPlayers.get(k));
         arrayPlayers.remove(k);
         totalStats.add(totalStats.get(k));
         totalStats.remove(k);
         break;
         }
         else {
         System.out.print("N ");
         }
        }
      ++b;
      }
       
   System.out.println("");
   outputArea.append("Players on Practice Team 1 Include (stats rating to the right):\n");
   for (b = 0; b <(totalStats.size()/2); ++b) {
   outputArea.append(practiceTeam1.get(b) + " ");
   outputArea.append(String.valueOf(array1.get(b)));
   outputArea.append("\n");
   }  
   
   b = (totalStats.size()/2);
   outputArea.append("\n");
   System.out.println("Array 2");
   
   int j = 0;
   while (b < totalStats.size()){
   array2.add(j, inFS.nextDouble());
   System.out.print(array2.get(j) + " ");
      for(int m = 0; m < totalStats.size(); ++m) {
      if (methodsClass.roundOneDecimal(totalStats.get(m)) == methodsClass.roundOneDecimal(array2.get(j))){
      System.out.println("Y ");
      practiceTeam2.add(arrayPlayers.get(m));
      arrayPlayers.add(arrayPlayers.get(m));
      arrayPlayers.remove(m);
      totalStats.add(totalStats.get(m));
      totalStats.remove(m);
      break;
      }
      else {
      System.out.print("N ");
      }
     }
   ++b;
   ++j;
   }
   
   System.out.println("");
   outputArea.append("Players on Practice Team 2 Include (stats rating to the right):\n");
   for (b = 0; b <(arrayPlayers.size()/2); ++b) {
   outputArea.append(practiceTeam2.get(b) + " ");
   outputArea.append(String.valueOf(array2.get(b)));
   outputArea.append("\n");
   }
   }});
 
   return pane;
}

   private static void createAndShowGUI() throws IOException {
        //Create and set up the window.
        JPanel container = new JPanel();
        JFrame frame = new JFrame("Plater Stats Entry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        JScrollPane jsp = new JScrollPane(addComponentsToPane(container));
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.getVerticalScrollBar().setUnitIncrement(25);
        frame.add(jsp);
        
        
        // jsp.setPreferredSize(new Dimension(450, 110));
        
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    } 
   
   // Main
   public static void main(String[] args) throws IOException  {
    
      createAndShowGUI();        
   
      return;
   }
}