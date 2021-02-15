import java.util.*;
/**
 * Coding Exercise
 * @author Shruti Panchal
 *
 */
public class finishLoading {	
	
	public static int FinishLoadTime(String[] containerTags, int M) {
		/**
		 * Edge case: when the container tags can be placed anyways, as the wait time is 0.
		 */
		if(M == 0)
			return containerTags.length;
		/**
		 * creating a hashMap that keeps the track of the frequency of each containerTags as a string - integer pairs.
		 */
		HashMap<String, Integer> map = new HashMap();
		for(int i = 0 ; i < containerTags.length ; i++) {
			map.put(containerTags[i], map.getOrDefault(containerTags[i],0)+1);
		}
		
		//keeps track of the Value of the container that is listed the most in the container tags
		int maxVal = Integer.MIN_VALUE;
		
		//keeps track of the container tag, as a key, that is associated with the maximum value of the tags
		String maxKey = " ";
		
		
		for(Map.Entry<String, Integer> e: map.entrySet()) {
			if(maxVal <= e.getValue()) {
				maxVal = e.getValue();
				maxKey = e.getKey();
			}
			//System.out.println("key: "+ e.getKey()+" --> value: "+e.getValue() );
				
		}
		
		int CountOfMax = 0;
		//counts the number of those tags that have the maximum number of occurences.
		for(Map.Entry<String, Integer> e: map.entrySet()) {
			if(maxVal == e.getValue()) {
				CountOfMax++;
			}
		}
		
	//	System.out.println(maxKey);

		int counterIndex = 0;
	
		int index = 0;
		
		int lastIndexBeforeLastIncrement = 0;
		
		/**
		 * iterating over until the maximum number of occurences of the resp tag
		 */
		while(counterIndex < maxVal) {
			
			//keeping track of the index
			lastIndexBeforeLastIncrement = index;
			
			//incrementing the counterIndex for the loop
			counterIndex++;
			
			//incrementing the index of the tag where the next same tag would come.
			index += M+1;
			
		}
		
		//return the number of time units that the container crane will take to finish off loading.
		return lastIndexBeforeLastIncrement+ CountOfMax;
	}
	

	public static void main(String[] args) {
		
		
		/**
		 * Testing with the already given test cases.
		 * 
		 */
		
		String[] arr1 = {"Fish","Fish","Fish","Coal","Coal","Coal"};
		int m1 = 2;
		System.out.println("\nThe least number of unit time between M same container types: "+ FinishLoadTime(arr1,m1));
			
		String[] arr2 = {"Fish","Fish","Fish","Coal","Coal","Coal"};
		int m2 = 0;
		System.out.println("\nThe least number of unit time between M same container types: "+ FinishLoadTime(arr2,m2));
		
		String[] arr3 = {"Fish","Fish","Fish","Fish","Fish","Fish","Coal","Toy","Desk","Eggs","Clothes","Gold"};
		int m3 = 2;
		System.out.println("\nThe least number of unit time between M same container types: "+ FinishLoadTime(arr3,m3));
		
		
		

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of container tages to load: ");
		int N = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter the container tags: ");
		String containers[] = new String[N];
		
		for(int i = 0 ; i < N ; i++) {
			String s = scan.next();
			containers[i] = s;
		}
		
		System.out.println("Enter the time interval after which containerTages can be used again: ");
		int M = scan.nextInt();	
		
//		String[] containerTags = {"Fish","Fish","Coal","Coal","Coal","rabbit","rabbit","rabbit","koala","koala"};
//		int M = 3;
		System.out.println("\nThe least number of unit time between M same container types: "+ FinishLoadTime(containers,M));

	}

}
