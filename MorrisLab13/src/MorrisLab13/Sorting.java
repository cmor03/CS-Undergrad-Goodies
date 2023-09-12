package MorrisLab13;

public class Sorting {
	
	public static int selectionSort(int[] a){
		int unsortedness = 0;
		
		for (int i = 0; i < a.length - 1; i++)  
        {  
			//slot tracker
            int slot = i;  
            
            //loops through all higher slot elements in the array
            for (int j = i + 1; j < a.length; j++){  
            	
            	//tries to find if the slot index 
                if (a[j] < a[slot]){  
                    slot = j;//searching for lowest index  
                    
                }  
            } 
            unsortedness += slot-i;
            
            int temp = a[slot];   
            a[slot] = a[i];  
            a[i] = temp;  
        }  
		
		return unsortedness;
	}

}
