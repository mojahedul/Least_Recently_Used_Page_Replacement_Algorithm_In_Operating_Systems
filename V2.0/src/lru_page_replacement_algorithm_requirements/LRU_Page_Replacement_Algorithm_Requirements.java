package lru_page_replacement_algorithm_requirements;

import java.util.Arrays;
import java.util.LinkedList;

public class LRU_Page_Replacement_Algorithm_Requirements {

	int page_Hit = 0;
	int free_FramesNumber;
	String[] reference_StringArray;
	
	LinkedList<String> list_ReferenceContainer = new LinkedList<String>();
	LinkedList<String> list_OutputContainer = new LinkedList<String>();
	LinkedList<String> list_RemovedElementsContainer = new LinkedList<String>();
	
	
	//Constructor
	public LRU_Page_Replacement_Algorithm_Requirements( int a, String[] b )
	{
		free_FramesNumber = a;
		reference_StringArray = b;
	
	} //Constructor ends;
	
	
	
	


	@SuppressWarnings("unused")
	public void LRU_Output_Calculation()
	{
		boolean status_FirstlyFrameInitializing = true;
		boolean status_OutputContainer = false;
		String[] OutputContainer = new String[free_FramesNumber];
		
//		System.out.println("\nInside Output Calc.");
		
		//Initializing list_ReferenceContainer with input reference strings;
		for(int i = 0; i < reference_StringArray.length; i++ )
		{
			
			list_ReferenceContainer.addLast( reference_StringArray[i] );
//			OutputContainer[i] = reference_StringArray[i];
			
		}
//		System.out.println("LRC1:: " + list_ReferenceContainer);
		
//		System.out.println("reference_StringArray: " + reference_StringArray.length);
		System.out.println();
		System.out.println("Outputs for Least Recently Used page replacement algorithm:");
		System.out.println("----------------------------------------------------------\n");
		
		for( int i = 0; i < free_FramesNumber; i++ )
		{
			OutputContainer[i] = "";
		}
			
		
		
		//-------------------------------
		int count = 0;
		while( status_FirstlyFrameInitializing == true )
		{
			count = 0;
//			String temp; // = list_ReferenceContainer.getFirst();
			
//			OutputContainer[0] = temp;
//			list_ReferenceContainer.removeFirst();
			
			if(count == free_FramesNumber || list_ReferenceContainer.size() == 0)
			{
				break;
			}
			
			for( int i = 0; i < free_FramesNumber; i++ )
			{
				int match = 0;
				int i_Value = i;
				
				
				String temp = list_ReferenceContainer.getFirst();
				list_RemovedElementsContainer.addFirst(list_ReferenceContainer.getFirst() );
				
				for( int j = 0; j < free_FramesNumber; j++ )
				{
				
					if( OutputContainer[j].equals(temp) )
					{
						match = 888;
						i_Value = i;
						++page_Hit;
						list_ReferenceContainer.removeFirst();
						System.out.print("No change. = ");
						for( int k = 0; k < free_FramesNumber; k++ )
						{
							if( k < (free_FramesNumber-1) )
							{
								System.out.print( OutputContainer[k] + "--" );
							}
							else
							{
								System.out.print( OutputContainer[k] + "" );
							}
							
						}
						System.out.println();
						
						
						Initializer(i, OutputContainer);
						
						break;
					}
				} //End of for( int j = 0; j < free_FramesNumber; j++ );
				
				if(match != 888)
				{
					OutputContainer[i_Value] = temp;
					list_ReferenceContainer.removeFirst();
					
//					System.out.println("Inside !888 ");
					for( int k = 0; k < free_FramesNumber; k++ )
					{
						if( k < (free_FramesNumber-1) )
						{
							System.out.print( OutputContainer[k] + "--" );
						}
						else
						{
							System.out.print( OutputContainer[k] + "" );
						}
						
					}
					System.out.println();
				}
				
				if( list_ReferenceContainer.size() == 0 )
				{
					break;
				}
				
			}
			
			for(int j = 0; j < free_FramesNumber; j++)
			{
				status_FirstlyFrameInitializing = OutputContainer[j].isEmpty();
				
				if( status_FirstlyFrameInitializing == false )
				{
					++count;
				}
				
				if(count == free_FramesNumber)
				{
					break;
				}
				
				else
				{
					status_FirstlyFrameInitializing = true;
				}
			}
			
//			System.out.print("Test:: ");
//			for( int i = 0; i < free_FramesNumber; i++ )
//			{
//				System.out.print(i + ": " + OutputContainer[i] + "  ");
//			}
//			System.out.println();
		} //End of While();
		//---------------------------------------------
		
		
		
		
		while( list_ReferenceContainer.size()  != 0 )
		{
			
			for( int i = 0; i < free_FramesNumber; i++ )
			{
				
				int count_Elements = 0;
				int match = 0;
				int size = free_FramesNumber;
				String temp_1 = list_ReferenceContainer.getFirst();
				
				for( int j = 0; j < free_FramesNumber; j++ )
				{
				
					if( OutputContainer[j].equals(temp_1) )
					{
						match = 999;
						++page_Hit;
//						list_RemovedElementsContainer.removeLast();
						list_RemovedElementsContainer.addFirst(list_ReferenceContainer.getFirst() );
						list_ReferenceContainer.removeFirst();
						
						System.out.print("No change.. = ");
//						System.out.println(list_RemovedElementsContainer );
//						System.out.println("LRC: " + list_ReferenceContainer );

						for( int k = 0; k < free_FramesNumber; k++ )
						{
							if( k < (free_FramesNumber-1) )
							{
								System.out.print( OutputContainer[k] + "--" );
							}
							else
							{
								System.out.print( OutputContainer[k] + "" );
							}
							
						}
						System.out.println();
						
						if( list_ReferenceContainer.size() > 0 )
						{
							int index_OfList_ReferenceContainer = Index_FixerForNextInput( OutputContainer );
							Dispatcher(index_OfList_ReferenceContainer, OutputContainer);
						}
						
						
						
						
//						if( index_OfList_ReferenceContainer == 777 )
//						{
//							break;
//						}
						
						
						break;
					}
				} //End of for( int j = 0; j < free_FramesNumber; j++ );
			
					
					
				
				//This block executess when all upper conditions are false
				//Scope which only executes when the free frame is fully occupied by elements, not < free frame size;
				if(match != 999)
				{
//					System.out.println("Inside else():" );
					
					int match2 = 0;
//					int size = free_FramesNumber;
					String temp = list_ReferenceContainer.getFirst();
					boolean status_ListRemovedElementsContainer = false;
					boolean advance = false;
			
					LinkedList<Integer> list_NextElementsContainer = new LinkedList<Integer>();
			
					
					for( int j = 0; j < free_FramesNumber; j++ )
					{
					
						if( OutputContainer[j].equals(temp) )      //temp = list_ReferenceContainer.getFirst();
						{
							match2 = 666;
							++page_Hit;
							
							for( int k = 0; k < (free_FramesNumber -1); k++ )
							{
								if( list_RemovedElementsContainer.get(k).equals(temp) )
								{
									status_ListRemovedElementsContainer = false;
									advance = true;
//									list_RemovedElementsContainer.addFirst(list_ReferenceContainer.getFirst() );
									break;
								}
								
								else
								{
									status_ListRemovedElementsContainer = true;
								}
							}
							
							if(status_ListRemovedElementsContainer == true)
							{
								list_RemovedElementsContainer.addFirst(list_ReferenceContainer.getFirst() );
							}
							
							
//							list_RemovedElementsContainer.removeLast();
							list_RemovedElementsContainer.addFirst(list_ReferenceContainer.getFirst() );
							list_ReferenceContainer.removeFirst();
							
							
//							System.out.println("list_RemovedElementsContainer:: " + list_RemovedElementsContainer);
						}
					} //End of for( int j = 0; j < free_FramesNumber; j++ );
						
						
				
				
					//--------------------------------------------------------	
					if(match2 != 666)
					{
						
						String temp3 = "";
						int temp4 =  list_ReferenceContainer.size();
						int temp5 = reference_StringArray.length - temp4;
						int index = 0;
						boolean stat = false;
						int a = 0;
						String backup_Element = "";
						
						
						for(int l = 0; l < free_FramesNumber; l++)
						{
							temp3 = OutputContainer[l];
							int temp6 = list_RemovedElementsContainer.indexOf(temp3);
							
							if( temp6 > 0 )
							{
								list_NextElementsContainer.add(temp6);
							}
							
							else if(temp6 < 0)
							{
								System.out.println("Error: 401");
							}
							
//							System.out.println(list_NextElementsContainer);
							
						} //End of for(int l = 0; l < free_FramesNumber; l++);
						
						
					
						int length_ListContainer = list_NextElementsContainer.size();
						int[] array_NextElementsIndexContainer = new int[length_ListContainer];
					
						
						
						for(int l = 0; l < length_ListContainer; l++ )
						{
							array_NextElementsIndexContainer[l] = list_NextElementsContainer.getFirst();
							list_NextElementsContainer.removeFirst();
						}
						
//						System.out.println(next_MatchingElementsIndex.length + ": List Cont. leng.: " + length_ListContainer);
						
						
						//Sorting the indexes to take the first element of first index.
						Arrays.sort(array_NextElementsIndexContainer);
						String current_Element = "";// = list_ReferenceContainer.get( next_MatchingElementsIndex[length_ListContainer-1] );
						int index_OfList_ReferenceContainer = 0;
						
//					
						
						
						if( array_NextElementsIndexContainer.length <= 0 )
						{
							current_Element = list_RemovedElementsContainer.getFirst();
//							System.out.println(array_NextElementsIndexContainer.length + " :Inside <= 0 Error: 402");
						}
						
						else if( array_NextElementsIndexContainer.length > 0  && advance == true)
						{
							int b = length_ListContainer; //list_NextElementsContainer.size() - 1;
							current_Element = list_RemovedElementsContainer.get( array_NextElementsIndexContainer[b] );
//							System.out.println(next_MatchingElementsIndex.length + " :Inside > 0");
						}
						
						else if( array_NextElementsIndexContainer.length > 0  && advance != true)
						{
							int b = length_ListContainer -1; //list_NextElementsContainer.size() - 1;
							current_Element = list_RemovedElementsContainer.get( array_NextElementsIndexContainer[b] );
//							System.out.println(next_MatchingElementsIndex.length + " :Inside > 0");
						}
						
						
//						System.out.println(":Current element: " + current_Element);
						
//						if( array_NextElementsIndexContainer.length < free_FramesNumber )
//						{
//							current_Element = backup_Element;
//						}
						
						//Saving the index for the element that resides into the queue to replace with newer one
						for( int k = 0; k < free_FramesNumber; k++ )
						{
							if( OutputContainer[k].equals(current_Element) )
							{
								index_OfList_ReferenceContainer = k;
								break;
							}
								
						} //Saving the index for the element that resides into the queue to replace with newer one;
							
						
							//Saving the element into the output array by replacing the older ones
							OutputContainer[index_OfList_ReferenceContainer] = list_ReferenceContainer.getFirst();
//							list_RemovedElementsContainer.removeLast();
							list_RemovedElementsContainer.addFirst( list_ReferenceContainer.getFirst() );
							list_ReferenceContainer.removeFirst();
							
//							System.out.println("list_RemovedElementsContainer::: " + list_RemovedElementsContainer);
							
							//Printing the corresponding outputs
//							System.out.print("OutputContainer[i]:: ");
							for( int k = 0; k < free_FramesNumber; k++ )
							{
								if( k < (free_FramesNumber-1) )
								{
									System.out.print( OutputContainer[k] + "--" );
								}
								else
								{
									System.out.print( OutputContainer[k] + "" );
								}
								
							}
							System.out.println();
//								Print_Output();
							//Printing the corresponding outputs;
						

						
						
					} //End of if(match != 999) condition which executes only with non-redundant values;
					
					
				} //End of else() scope which only executes when the free frame is fully occupied by elements, not < free frame size;
				
				
				if( list_ReferenceContainer.size() == 0 )
				{
					break;
				}
				
			} //End of for( int i = 0; i < free_FramesNumber; i++ );
			
			

			
			
			if( list_ReferenceContainer.size() == 0 )
			{
				break;
			}
			
		} //End while( list_ReferenceContainer.size()  != 0 );
		
		
		Double percent = ( ( (double) reference_StringArray.length - page_Hit) / reference_StringArray.length) * 100;
		System.out.println();
		System.out.println();
		System.out.println("Reference string length: " + reference_StringArray.length );
		System.out.println("Page hit: " + page_Hit);
		System.out.println("Page fault number = Total page number - Page hit number");
		System.out.println("Page fault number = " + (reference_StringArray.length - page_Hit) );
//		System.out.println("Page fault rate = " + percent + "%" );
		System.out.printf("Page fault rate = %.2f", percent );
		System.out.printf(" %%\n");
		System.out.println();

		
	} //End void FIFO_Output_Calculation() Method;
	//--------------------------------------
	
	
	
	
	//---------------------------------------------------
	int Index_FixerForNextInput(String[] OutputContainer)
	{
		String temp3 = "";
		int temp4 =  list_ReferenceContainer.size();
		int temp5 = reference_StringArray.length - temp4;
		int index = 0;
		boolean stat = false;
		boolean advance = false;
		int a = 0;
		String backup_Element = "";
		
		LinkedList<Integer> list_NextElementsContainer = new LinkedList<Integer>();
		
		for(int l = 0; l < free_FramesNumber; l++)
		{
			temp3 = OutputContainer[l];
			int temp6 = list_RemovedElementsContainer.indexOf(temp3);
			
			if( temp6 > 0 )
			{
				list_NextElementsContainer.add(temp6);
			}
			
			else if(temp6 < 0)
			{
//				System.out.println("Error: 402");
				//It returns -1 if not finds any match;
			}
			
//			System.out.println(list_NextElementsContainer);
			
		} //End of for(int l = 0; l < free_FramesNumber; l++);
		

		
		
		int length_ListContainer = list_NextElementsContainer.size();
		int[] array_NextElementsIndexContainer = new int[length_ListContainer];
	
		
		
		for(int l = 0; l < length_ListContainer; l++ )
		{
			array_NextElementsIndexContainer[l] = list_NextElementsContainer.getFirst();
			list_NextElementsContainer.removeFirst();
		}
		
//		System.out.println(next_MatchingElementsIndex.length + ": List Cont. leng.: " + length_ListContainer);
		
		
		//Sorting the indexes to take the first element of first index.
		Arrays.sort(array_NextElementsIndexContainer);
		String current_Element = "";// = list_ReferenceContainer.get( next_MatchingElementsIndex[length_ListContainer-1] );
		int index_OfList_ReferenceContainer = 0;
		
//	
		
		
		if( array_NextElementsIndexContainer.length <= 0 )
		{
			current_Element = list_RemovedElementsContainer.getFirst();
//			System.out.println(array_NextElementsIndexContainer.length + " :Inside <= 0 Error: 402");
		}
		
		else if( array_NextElementsIndexContainer.length > 0  && advance == true)
		{
			int b = length_ListContainer; //list_NextElementsContainer.size() - 1;
			current_Element = list_RemovedElementsContainer.get( array_NextElementsIndexContainer[b] );
//			System.out.println(next_MatchingElementsIndex.length + " :Inside > 0");
		}
		
		else if( array_NextElementsIndexContainer.length > 0  && advance != true)
		{
			int b = length_ListContainer -1; //list_NextElementsContainer.size() - 1;
			current_Element = list_RemovedElementsContainer.get( array_NextElementsIndexContainer[b] );
//			System.out.println(next_MatchingElementsIndex.length + " :Inside > 0");
		}
		
		
//		System.out.println(":Current element: " + current_Element);
		
//		if( array_NextElementsIndexContainer.length < free_FramesNumber )
//		{
//			current_Element = backup_Element;
//		}
		
		//Saving the index for the element that resides into the queue to replace with newer one
		for( int k = 0; k < free_FramesNumber; k++ )
		{
			if( OutputContainer[k].equals(current_Element) )
			{
				index_OfList_ReferenceContainer = k;
				break;
			}
				
		} //Saving the index for the element that resides into the queue to replace with newer one;
	
		return index_OfList_ReferenceContainer;
	
	} //End of int Index_FixerForNextInput(String[] OutputContainer);
	
	//-------------------------------------------------------------------
	
	
	
	

	//------------------------------
	void Dispatcher( int i, String[] OutputContainer)
	{
//		System.out.println("Inside Dispatcher +Size: " +list_ReferenceContainer.size() +": "  + list_RemovedElementsContainer );
//		System.out.println("Inside Dispatcher + " + i);

		String temp = "";
		int flag = 0;

		if( list_ReferenceContainer.size() == 0 )
		{
			return;
		}
		
		temp = list_ReferenceContainer.getFirst();
		
		
		
		for( int j = 0; j < free_FramesNumber; j++ )
		{
			if( OutputContainer[j].equals(temp) )
			{
				list_RemovedElementsContainer.addFirst( list_ReferenceContainer.getFirst() );
				list_ReferenceContainer.removeFirst();
				
				++page_Hit;
				System.out.print("No change... = ");
				for( int k = 0; k < free_FramesNumber; k++ )
				{
					if( k < (free_FramesNumber-1) )
					{
						System.out.print( OutputContainer[k] + "--" );
					}
					else
					{
						System.out.print( OutputContainer[k] + "" );
					}
					
				}
				System.out.println();
				
				int index_Value = Index_FixerForNextInput(  OutputContainer );
				
				Dispatcher(index_Value, OutputContainer);
//				System.out.println("Dispatcher: "+i+" Val: "+OutputContainer[j]);
				flag = 999;
				break;
			}
		}
			
		if( list_ReferenceContainer.size() == 0 )
		{
			return;
		}
			
		if(flag != 999)
		{
			OutputContainer[i] = list_ReferenceContainer.getFirst();
//			System.out.println("Bottom-Dispatcher: "+i+" Under Outp. Container: "+OutputContainer[i]);
//			System.out.println("Inside Dispatcher2+ " + list_RemovedElementsContainer );
			list_RemovedElementsContainer.addFirst( list_ReferenceContainer.getFirst() );
			list_ReferenceContainer.removeFirst();
			
			
			for( int k = 0; k < free_FramesNumber; k++ )
			{
				if( k < (free_FramesNumber-1) )
				{
					System.out.print( OutputContainer[k] + "--" );
				}
				else
				{
					System.out.print( OutputContainer[k] + "" );
				}
				
			}
			System.out.println();
		}
		
		
		
		return;
		
		
	} //End of void Dispatcher( int i, String[] OutputContainer);
	
	//----------------------------------------

	
	
	
	
	
	//------------------------------
	void Initializer( int i, String[] OutputContainer)
	{
//		System.out.println("Inside Dispatcher +Size: " +list_ReferenceContainer.size() +": "  + list_RemovedElementsContainer );
//		System.out.println("Inside Dispatcher + " + i);

		String temp = "";
		int flag = 0;

		if( list_ReferenceContainer.size() == 0 )
		{
			return;
		}
		
		temp = list_ReferenceContainer.getFirst();
		
		
		
		for( int j = 0; j < free_FramesNumber; j++ )
		{
			if( OutputContainer[j].equals(temp) )
			{
				list_RemovedElementsContainer.addFirst( list_ReferenceContainer.getFirst() );
				list_ReferenceContainer.removeFirst();
				
				++page_Hit;
				System.out.print("No change.. = ");
				for( int k = 0; k < free_FramesNumber; k++ )
				{
					if( k < (free_FramesNumber-1) )
					{
						System.out.print( OutputContainer[k] + "--" );
					}
					else
					{
						System.out.print( OutputContainer[k] + "" );
					}
					
				}
				System.out.println();
				
				
//				int index_Value = Index_FixerForNextInput(  OutputContainer );
				
				Initializer(i, OutputContainer);
//				System.out.println("Dispatcher: "+i+" Val: "+OutputContainer[j]);
				flag = 999;
				break;
			}
		}
			
		if( list_ReferenceContainer.size() == 0 )
		{
			return;
		}
			
		if(flag != 999)
		{
			OutputContainer[i] = list_ReferenceContainer.getFirst();
//			System.out.println("Bottom-Dispatcher: "+i+" Under Outp. Container: "+OutputContainer[i]);
//			System.out.println("Inside Dispatcher2+ " + list_RemovedElementsContainer );
			list_RemovedElementsContainer.addFirst( list_ReferenceContainer.getFirst() );
			list_ReferenceContainer.removeFirst();
			
			
			for( int k = 0; k < free_FramesNumber; k++ )
			{
				if( k < (free_FramesNumber-1) )
				{
					System.out.print( OutputContainer[k] + "--" );
				}
				else
				{
					System.out.print( OutputContainer[k] + "" );
				}
				
			}
			System.out.println();
		}
		
		
		
		return;
		
		
	} //End of void Dispatcher( int i, String[] OutputContainer);
	
	
	
	
} //End of public class LRU_Page_Replacement_Algorithm_Requirements;
