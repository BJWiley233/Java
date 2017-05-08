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

public class insideMethods {

public static void insideDiagonalR2LKeep(List<Double> array1, List<Double> array2) throws IOException { 

   double part1Sum = 0.0;
   double part2Sum = 0.0;
   int i = 0;
   int j = 0;
   double newDiff = 0.0;
   double currDiff = 0.0;
   boolean notZero = true;
   boolean isLarger = true;
   
   System.out.println("Right 2 Left Diagonal Keep");
   
   for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
      
   for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      currDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("Current Smallest Difference from last method " + currDiff);
   
      //Collections.sort(array1, Collections.reverseOrder());
      //Collections.sort(array2, Collections.reverseOrder());
   
   for (j = 0; j < (array1.size()-2); ++j) {
         array1.add(array2.get(array2.size()-(j+1)));
         array2.add(array1.get(array1.size()-(j+3)));
         array1.remove(array1.get(array1.size()-(j+3)));
         array2.remove(array2.get(array2.size()-(j+2)));
         part1Sum = 0;
         part2Sum = 0;
   
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      newDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("New Difference " + newDiff);
      
      if (newDiff == 0){
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      notZero = false;
      break;
      }
      else if (newDiff >= currDiff){
      currDiff = currDiff;
      System.out.println("Smallest min Difference " + currDiff);
      }
      else {
      currDiff = newDiff;
      System.out.println("Smallest min Difference " + currDiff);
      //Collections.sort(array1, Collections.reverseOrder());
      //Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      part1Sum = 0;
      part2Sum = 0;
      
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      }
     }

     if (newDiff >= currDiff && currDiff != 0){
     isLarger = false;
     System.out.println("                                   Inside Method 1 R2L Keep. We need to refresh array back and try next method");
     
     methodsClass.textFilePull(array1, array2); 
     insideDiagonalL2RKeep(array1, array2);
     }
    else {
     }
    return;
 } 
 
public static void insideDiagonalL2RKeep(List<Double> array1, List<Double> array2)throws IOException {
 
   double part1Sum = 0.0;
   double part2Sum = 0.0;
   int i = 0;
   //int j = 0;
   double newDiff = 0.0;
   double currDiff = 0.0;
   boolean notZero = true;
   boolean isLarger = true;
   
   System.out.println("Left 2 Right Diagonal Keep");
   
   Collections.sort(array1, Collections.reverseOrder());
   Collections.sort(array2, Collections.reverseOrder());
   
   for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
      
   for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      currDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("Current Smallest Difference from last method " + currDiff);
   
   for (int k = 0; k < (array1.size()-2); ++k) {
         array1.add(array2.get(0));
         array2.add(array1.get(1));
         array1.remove(array1.get(1));
         array2.remove(array2.get(0));
         part1Sum = 0;
         part2Sum = 0;
   
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      newDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("New Difference " + newDiff);
      
      if (newDiff == 0){
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      notZero = false;
      break;
      }
      else if (newDiff >= currDiff){
      currDiff = currDiff;
      System.out.println("Smallest min Difference " + currDiff);
      }
      else {
      currDiff = newDiff;
      System.out.println("Smallest min Difference " + currDiff);
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      part1Sum = 0;
      part2Sum = 0;
      
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      }
     }

     if (newDiff >= currDiff && currDiff != 0){
     isLarger = false;
     System.out.println("                                         Inside Method 2 L2R Keep. We need to refresh array back and try next method");
 
     methodsClass.textFilePull(array1, array2); 
     insideTop2BottomKeep(array1, array2);
     }
      
    return;
 } 


public static void insideTop2BottomKeep(List<Double> array1, List<Double> array2) throws IOException {
   
   double part1Sum = 0.0;
   double part2Sum = 0.0;
   int i = 0; 
   double newDiff = 0.0;
   double currDiff = 0.0;
   boolean notZero = true;
   boolean isLarger = true;

   System.out.println("Top and Bottom Keep");
   
   Collections.sort(array1, Collections.reverseOrder());
   Collections.sort(array2, Collections.reverseOrder());

   for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
      
   for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      currDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("Current Smallest Difference from last method " + currDiff);
   
     
   
   for (int k = 0; k < (array1.size()-1); ++k) {
         array1.add(array2.get(1));
         array2.add(array1.get(1));
         array1.remove(array1.get(1));
         array2.remove(array2.get(1));
         part1Sum = 0;
         part2Sum = 0;
   
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      newDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("New Difference " + newDiff);
      
      if (newDiff == 0){
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      break;
      }
      else if (newDiff > currDiff){
      currDiff = currDiff;
      System.out.println("Smallest min Difference " + currDiff);
      }
      else {
      currDiff = newDiff;
      System.out.println("Smallest min Difference " + currDiff);
      methodsClass.textFilePush(array1, array2); // write newest smallest difference arrays to textfile
      part1Sum = 0;
      part2Sum = 0;
      
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      }
     }
     
     if (newDiff >= currDiff && currDiff != 0){
     System.out.println("                 Inside Method 3 T&B Keep. We need to refresh array back and try next method");
     
     methodsClass.textFilePull(array1, array2); 
     insideDiagonalR2LOneAtATime(array1, array2);
     }
 
    return;
 } 
   
public static void insideDiagonalR2LOneAtATime(List<Double> array1, List<Double> array2) throws IOException {
   
   double part1Sum = 0.0;
   double part2Sum = 0.0;
   int i = 0;
   int j = 0;
   double newDiff = 0.0;
   double currDiff = 0.0;
   boolean notZero = true;
   boolean isLarger = true;

   System.out.println("Right to Left One at a Time");
   
   Collections.sort(array1, Collections.reverseOrder());
   Collections.sort(array2, Collections.reverseOrder());

   for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
      
   for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      currDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("Current Smallest Difference from last method " + currDiff);
   
    for (j = 0; j < (array1.size()-2); ++j) {
         array1.add(array2.get(array2.size()-(j+1)));
         array2.add(array1.get(array1.size()-(j+3)));
         array1.remove(array1.get(array1.size()-(j+3)));
         array2.remove(array2.get(array2.size()-(j+2)));
         part1Sum = 0;
         part2Sum = 0;
   
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      newDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("New Difference " + newDiff);
      
      if (newDiff == 0){
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      break;
      }
      else if (newDiff >= currDiff){
      currDiff = currDiff;
      methodsClass.textFilePull(array1, array2); //re-pull
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());      
      System.out.println("Smallest min Difference " + currDiff);
      }
      else {
      currDiff = newDiff;
      System.out.println("Smallest min Difference " + currDiff);
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      part1Sum = 0;
      part2Sum = 0;
      
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      }
     }
  
     if (newDiff >= currDiff && currDiff != 0){
     System.out.println("                                   Inside Method 4 R2L OAAT Just 1 Diagonal. We need to refresh array back and try next method");
 
     methodsClass.textFilePull(array1, array2);    
     insideDiagonalL2ROneAtATime(array1, array2);
   }
     else{
     }

    return;
 }
 
 
 public static void insideDiagonalL2ROneAtATime(List<Double> array1, List<Double> array2)throws IOException {
 
   double part1Sum = 0.0;
   double part2Sum = 0.0;
   int i = 0;
   int j = 0;
   double newDiff = 0.0;
   double currDiff = 0.0;
   boolean notZero = true;
   boolean isLarger = true;
   
   System.out.println("Left 2 Right Diagonal One at a Time");
   
   Collections.sort(array1, Collections.reverseOrder());
   Collections.sort(array2, Collections.reverseOrder());

   for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
      
   for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      currDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("Current Smallest Difference from last method " + currDiff);
   
    for (j = 0; j < (array1.size()-1); ++j) {
         array1.add(array2.get(j+0));
         array2.add(array1.get(j+1));
         array1.remove(array1.get(j+1));
         array2.remove(array2.get(j+0));
         part1Sum = 0;
         part2Sum = 0;
   
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      newDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("New Difference " + newDiff);
      
      if (newDiff == 0){
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      break;
      }
      else if (newDiff >= currDiff){
      currDiff = currDiff;
      methodsClass.textFilePull(array1, array2); //re-pull
      //Collections.sort(array1, Collections.reverseOrder());
      //Collections.sort(array2, Collections.reverseOrder());      
      System.out.println("Smallest min Difference " + currDiff);
      }
      else {
      currDiff = newDiff;
      System.out.println("Smallest min Difference " + currDiff);
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      part1Sum = 0;
      part2Sum = 0;
      
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      }
     }

      if (newDiff >= currDiff && currDiff != 0){
      System.out.println("                   Inside Method 5 L2R OAAT Just 1 Diagonal. We need to refresh array back and try next method");
 
      methodsClass.textFilePull(array1, array2);    
      insideTop2BottomOneAtATime(array1, array2);
      }
      
    return;
 } 

public static void insideTop2BottomOneAtATime(List<Double> array1, List<Double> array2) throws IOException {
   
   double part1Sum = 0.0;
   double part2Sum = 0.0;
   int i = 0;
   int j = 0;
   double newDiff = 0.0;
   double currDiff = 0.0;
   boolean notZero = true;
   boolean isLarger = true;

   System.out.println("Top and Bottom Keep");
   
   Collections.sort(array1, Collections.reverseOrder());
   Collections.sort(array2, Collections.reverseOrder());

   for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
      
   for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      currDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("Current Smallest Difference from last method " + currDiff);
   
     
   
   for (int k = 0; k < (array1.size()-1); ++k) {
         array1.add(array2.get(j+1));
         array2.add(array1.get(j+1));
         array1.remove(array1.get(j+1));
         array2.remove(array2.get(j+1));
         part1Sum = 0;
         part2Sum = 0;
   
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      newDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("New Difference " + newDiff);
      
      if (newDiff == 0){
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      break;
      }
      else if (newDiff > currDiff){
      currDiff = currDiff;
      methodsClass.textFilePull(array1, array2);
      System.out.println("Smallest min Difference " + currDiff);
      }
      else {
      currDiff = newDiff;
      System.out.println("Smallest min Difference " + currDiff);
      methodsClass.textFilePush(array1, array2); // write newest smallest difference arrays to textfile
      part1Sum = 0;
      part2Sum = 0;
      
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      }
     }
     
     if (newDiff >= currDiff && currDiff != 0){
     System.out.println("                 Inside Method 6 Top&Bottom OAAT. We need to refresh array back and try next method.");
     
     methodsClass.textFilePull(array1, array2); 
     insideDiagonalL2ROneAtATimeAllPossibleSwitches(array1, array2);
     }
     
    
    return;
 } 
 
public static void insideDiagonalL2ROneAtATimeAllPossibleSwitches(List<Double> array1, List<Double> array2) throws IOException {
   
   double part1Sum = 0.0;
   double part2Sum = 0.0;
   int i = 0;
   int j = 0;
   double newDiff = 0.0;
   double currDiff = 0.0;
   boolean notZero = true;
   boolean isLarger = true;

   System.out.println("Left to Right One at a Time all possible options");
   
   Collections.sort(array1, Collections.reverseOrder());
   Collections.sort(array2, Collections.reverseOrder());

   for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
      
      
   for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      currDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("Current Smallest Difference from last method " + currDiff);
   
    int k = 0;
    j = 0;
    while (k < array1.size()-2){
    for (j = 0; j < (array1.size()-2); ++j) {
         array1.add(array2.get(j));
         array2.add(array1.get(k+1));
         array1.remove(array1.get(k+1));
         array2.remove(array2.get(j));
         part1Sum = 0;
         part2Sum = 0;
   
   
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      newDiff = Math.abs(part1Sum - part2Sum);
      newDiff = methodsClass.roundOneDecimal(newDiff);
      System.out.println("New Difference " + newDiff);
      
      if (newDiff == 0.0) {
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      break;
      }
      else if (newDiff >= currDiff){
      currDiff = currDiff;
      methodsClass.textFilePull(array1, array2); //re-pull
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());      
      System.out.println("Smallest min Difference " + currDiff);
      }
      else {
      currDiff = newDiff;
      System.out.println("Smallest min Difference " + currDiff);
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      part1Sum = 0;
      part2Sum = 0;
      
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      }
     }
     if (newDiff == 0.0){
     break;
     }
     ++k;
     ++j;
    }
  
     if (newDiff >= currDiff && currDiff != 0.0){
     System.out.println("                                   Inside Method 7 L2R OAAT for all possible switches. We need to refresh array back and try next method");
     
     methodsClass.textFilePull(array1, array2);
     insideDiagonalR2LOneAtATimeAllPossibleSwitches(array1, array2);   
     
   }
     else{
     }

    return;
 }

 
public static void insideDiagonalR2LOneAtATimeAllPossibleSwitches(List<Double> array1, List<Double> array2) throws IOException {
   
   double part1Sum = 0.0;
   double part2Sum = 0.0;
   int i = 0;
   int j = 0;
   double newDiff = 0.0;
   double currDiff = 0.0;
   boolean notZero = true;
   boolean isLarger = true;

   System.out.println("Right to Left One at a Time all possible options");
   
   Collections.sort(array1, Collections.reverseOrder());
   Collections.sort(array2, Collections.reverseOrder());

   for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
      
      
   for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      currDiff = Math.abs(part1Sum - part2Sum);
      System.out.println("Current Smallest Difference from last method " + currDiff);
   
    int k = 0;
    j = 0;
    while (k < array1.size()-2){
    for (j = 0; j < (array1.size()-2); ++j) {
         array1.add(array2.get(array2.size()-(k+1)));
         array2.add(array1.get(array1.size()-(j+3)));
         array1.remove(array1.get(array1.size()-(j+3)));
         array2.remove(array2.get(array2.size()-(k+2)));
         part1Sum = 0;
         part2Sum = 0;
   
   
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      
      newDiff = Math.abs(part1Sum - part2Sum);
      newDiff = methodsClass.roundOneDecimal(newDiff);
      System.out.println("New Difference " + newDiff);
      
      if (newDiff == 0.0) {
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      break;
      }
      else if (newDiff >= currDiff){
      currDiff = currDiff;
      methodsClass.textFilePull(array1, array2); //re-pull
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());      
      System.out.println("Smallest min Difference " + currDiff);
      }
      else {
      currDiff = newDiff;
      System.out.println("Smallest min Difference " + currDiff);
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      methodsClass.textFilePush(array1, array2); //write newest smallest difference arrays to textfile
      part1Sum = 0;
      part2Sum = 0;
      
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      part1Sum += array1.get(i);
      }
      System.out.println("(" + part1Sum + ")");
     
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      part2Sum += array2.get(i); 
      }
      System.out.println("(" + part2Sum + ")");
      }
     }
     if (newDiff == 0.0){
     break;
     }
     ++k;
     ++j;
    }
  
     if (newDiff >= currDiff && currDiff != 0.0){
     System.out.println("                                   Last Method R2L OAAT for all possible switches. We need to refresh array back and try next method");
     
     methodsClass.textFilePull(array1, array2);    
     
   }
     else{
     }

    return;
 }

}
