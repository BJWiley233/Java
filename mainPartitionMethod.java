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

public class mainPartitionMethod {

public static void mainTest(List<Double> totalStats) throws IOException {
         
Collections.sort(totalStats, Collections.reverseOrder());

System.out.println(totalStats);

List<Double> array1 = new ArrayList<Double>();
List<Double> array2 = new ArrayList<Double>();

        double currDiff = 0.0;
        double sumArray1 = 0.0;
        double sumArray2 = 0.0;
        int i = 0;
        int j = 0;
        double newDiff = 0.0;
        int totalArrayOptions = 0;

   if (totalStats.size() > 4) {       
   for (i = ((totalStats.size()/2)+1); i > 0; --i){
      totalArrayOptions += i;
      }
   System.out.println("Max " + totalArrayOptions + " Iterations.");
   } 
   else if (totalStats.size() == 4){
      totalArrayOptions = 3;
      }
   else {
   totalArrayOptions = 1;
   }
               
//Initialize the first break of arrays with the highest half in first array and lowest half in second array     
for (i = 0; i < (totalStats.size()/2); ++i) {
   array1.add(totalStats.get(i));
   System.out.print(array1.get(i) + " ");
   sumArray1 += array1.get(i); 
   }
System.out.println("(" + sumArray1 + ")");

for (i = (totalStats.size()/2); i < totalStats.size(); ++i) {
   array2.add(totalStats.get(i));
   System.out.print(array2.get(i-(totalStats.size()/2)) + " ");
   sumArray2 += (array2.get(i-(totalStats.size()/2)));
   }
System.out.println("(" + sumArray2 + ")");
currDiff = Math.abs(sumArray1 - sumArray2);
System.out.println("Initial Difference " + currDiff);

   for (j = 0; j < totalArrayOptions; ++j){
   System.out.println("Iteration " + (j+1));
   array2.add(array1.get(1));
   array1.remove(1);
   array1.add(array2.get(array2.size()-2));
   array2.remove(array2.get(array2.size()-2));
   sumArray1 = 0;
   sumArray2 = 0;
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      sumArray1 += array1.get(i);
      }
      System.out.print("(" + sumArray1 + ")");
      System.out.println("");
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      sumArray2 += array2.get(i); 
      }
      System.out.print("(" + sumArray2 + ")");
      System.out.println("");
      newDiff = Math.abs(sumArray1 - sumArray2);
      System.out.println("New Difference " + newDiff);
      
      if (newDiff < currDiff){
      currDiff = newDiff;
      System.out.println("Smallest Min Difference is " + currDiff);
      }
      else {
      currDiff = currDiff;
      System.out.println("Smallest min Difference is " + currDiff);
      } 
         
      if (newDiff > currDiff) {
      System.out.println("Need to Start Return Here!!!!!!!!!!!!!!!!!!!!");
      sumArray1 = 0;
      sumArray2 = 0;
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      sumArray1 += array1.get(i);
      }
      System.out.print("(" + sumArray1 + ")");
      System.out.println("");
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      sumArray2 += array2.get(i); 
      }
      System.out.print("(" + sumArray2 + ")");
      System.out.println("");
      System.out.println("                               Return back Here");
      array2.add(array1.get(array1.size()-1));
      array1.add(array2.get(array2.size()-2));
      array1.remove(array1.get(array1.size()-2));
      array2.remove(array2.get(array2.size()-2));
      sumArray1 = 0;
      sumArray2 = 0;
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      sumArray1 += array1.get(i);
      }
      System.out.print("(" + sumArray1 + ")");
      System.out.println("");
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      sumArray2 += array2.get(i); 
      }
      System.out.print("(" + sumArray2 + ")");
      System.out.println("");
      newDiff = Math.abs(sumArray1 - sumArray2);
      System.out.println("New Difference " + newDiff);
      break;  
    }
           
      System.out.println("SORTING");
      sumArray1 = 0;
      sumArray2 = 0;
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      sumArray1 += array1.get(i);
      }
      System.out.print("(" + sumArray1 + ")");
      System.out.println("");
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      sumArray2 += array2.get(i); 
      }
      System.out.print("(" + sumArray2 + ")");
      System.out.println("");
      newDiff = Math.abs(sumArray1 - sumArray2);
      System.out.println("New Difference " + newDiff);
         if (newDiff < currDiff){
         currDiff = newDiff;
         System.out.println("Smallest Min Difference is " + currDiff);
         }
         else {
         currDiff = currDiff;
         System.out.println("Smallest min Difference is " + currDiff);
         }
        //}
      
      sumArray1 = 0;
      sumArray2 = 0;
      
      if (sumArray1 < sumArray2){
      array1.add(array2.get((array2.size()-1)));
      array2.remove((array2.size()-1));
      array2.add(array1.get(array1.size()-3));
      array1.remove(array1.get(array1.size()-3));
      Collections.sort(array1, Collections.reverseOrder());
      Collections.sort(array2, Collections.reverseOrder());
      
      for (i = 0; i < array1.size(); ++i){
      System.out.print(array1.get(i) + " ");
      sumArray1 += array1.get(i);
      }
      System.out.print("(" + sumArray1 + ")");
      System.out.println("");
      for (i = 0; i < array2.size(); ++i){
      System.out.print(array2.get(i) + " ");
      sumArray2 += array2.get(i); 
      }
      
      System.out.println("(" + sumArray2 + ")");
      newDiff = Math.abs(sumArray1 - sumArray2);
      System.out.println("New Difference " + newDiff);
      if (newDiff < currDiff){
      currDiff = newDiff;
      System.out.println("Smallest Min Difference is " + currDiff);
      }
     }          
  }

methodsClass.textFilePush(array1, array2);

insideMethods.insideDiagonalR2LKeep(array1, array2);            
 return; 
 } 
 }