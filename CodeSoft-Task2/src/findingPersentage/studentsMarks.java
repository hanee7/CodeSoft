package findingPersentage;

import java.util.Scanner;

public class studentsMarks {
	
	    public static void main(String[] args) {
	    	
	        Scanner s= new Scanner(System.in);

	        System.out.print("Enter the total number of subjects: ");
	        int noOfSubj = s.nextInt();

	        System.out.print("Enter the max marks");
	        double maxMarks = s.nextDouble();

	        double[] marks = new double[noOfSubj];
	        double totalMarks = 0;

	        for (int i = 0; i < noOfSubj; i++) {
	            System.out.print("Enter marks of subject " + (i + 1) + ": ");
	            marks[i] = s.nextDouble();
	            totalMarks += marks[i]; 
	        }
	        double averageMarks = totalMarks / noOfSubj;
	        double percentage=(totalMarks/maxMarks)*100;

	        System.out.println("Total Marks: " + totalMarks);
	        System.out.println("Average Marks: " + averageMarks);
	        System.out.println("Percentage: " + percentage + "%");

	        s.close();
	    }
	}