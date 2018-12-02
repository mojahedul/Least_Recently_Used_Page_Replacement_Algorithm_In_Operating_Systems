package lru_page_replacement_algorithm;

import java.util.Scanner;

import lru_page_replacement_algorithm_requirements.LRU_Page_Replacement_Algorithm_Requirements;

public class LRU_Page_Replacement_Algorithm {

	public static void main(String[] args)
	{
		
		int free_FramesNumber;
		String reference_String;
		String[] reference_StringArray;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter reference string (separating with space): ");
		reference_String = input.nextLine();
		
		System.out.print("Enter free frames number: ");
		free_FramesNumber = input.nextInt();
		
		System.out.println("\nYou entered:");
		System.out.println(free_FramesNumber);
		System.out.println(reference_String);
		
		reference_StringArray = reference_String.split(" ");
		
		LRU_Page_Replacement_Algorithm_Requirements obj_LRU = new LRU_Page_Replacement_Algorithm_Requirements(free_FramesNumber, reference_StringArray);
		obj_LRU.LRU_Output_Calculation();
		
	} //End of Main() Method;
	
	
} //End of public class LRU_Page_Replacement_Algorithm;
