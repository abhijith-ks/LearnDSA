package io.abhijith.challenges.string;

import java.util.ArrayList;

public class JustifyTextWithPadding {

	public void findSolution(String[] list, int length) {
		
		ArrayList<String> tempArr = new ArrayList<>();
		
		int count = 0;
		int listLength = 0;
		
		for(int i = 0; i < list.length; i++) {
			
			listLength += list[i].length();
			count += list[i].length() + 1;
			
			if(count <= length && i+1 != list.length) {
				
				tempArr.add(list[i]);
				
			} else {
				if(i+1 != list.length) {
					count -= list[i].length();
					listLength -= list[i].length();
					count = count-1;
				} else {
					tempArr.add(list[i]);
				}
				int spaceCount = length - listLength;
				int tempArrSize = tempArr.size();
				String result = ""; 
				
				int reduceVarTempArrSize = tempArrSize;
				
				for(int k = 0;k<tempArrSize;k++) {
					result += tempArr.get(k);
					reduceVarTempArrSize = (reduceVarTempArrSize - 1 == 0) ? 1 : reduceVarTempArrSize-1;
					int tempSpaceVal = spaceCount / reduceVarTempArrSize;
					
					if(spaceCount % (reduceVarTempArrSize) != 0) {
						tempSpaceVal++;
					} 
					for(int j = 0; j < tempSpaceVal; j++) {
						result += "#";
						spaceCount--;
					}
					
				}
				System.out.println(result);
				if(i+1 != list.length) {
					tempArr.clear();
					listLength = 0;
					count = 0;
					i--;
				}
			}
			
		}
		
		
	}
	
}
