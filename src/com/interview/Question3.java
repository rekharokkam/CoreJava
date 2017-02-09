package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Question3
{
	/*
	 * Problem 3
	 * Write a method which takes a non-empty array of integers.  
	 * The method should return true if there is a way to split the array so that the sum of the numbers on one side of the split equals the sum of the numbers on the other side. 
	 */
	
	static boolean isArraySplittable (int[] intArr)
	{
		if (intArr.length == 1)
		{
			return false;
		}
		if (intArr.length == 2)
		{
			if (intArr[0] != intArr[1])
			{
				return false;
			}
		}		
		
		List<Integer> inputList = new ArrayList<Integer>(intArr.length);
		for(int eachIntElement : intArr)
		{
			inputList.add(eachIntElement);
		}
		
		Collections.sort(inputList);

		LinkedList<Integer> rightHandSideList = new LinkedList<Integer>();
		LinkedList<Integer> leftHandSideList = new LinkedList<Integer>(inputList);
				
		Integer removedElement = leftHandSideList.remove(leftHandSideList.size() - 1 );
		rightHandSideList.add(removedElement);

		StringBuilder isArraySpittableForAdding = new StringBuilder();

		doCalculation (leftHandSideList, rightHandSideList, 1, intArr.length, isArraySpittableForAdding, 0, intArr.length);		
		
		return (isArraySpittableForAdding.toString().equals("") ? false : true);
	}
	
	private static void doCalculation(LinkedList<Integer> leftHandList, LinkedList<Integer> rightHandList, 
			int currentRepeat, int maxRepeat, StringBuilder isArrayEligible, int removePosition, int arrayLength)
	{
		if (currentRepeat > maxRepeat)
		{
			return;
		}		
		
		int leftHandSideListSum = sumList(leftHandList);
		int rightHandSideListSum = sumList (rightHandList);
		
		if (rightHandSideListSum < leftHandSideListSum)
		{
			removePosition = (removePosition == leftHandList.size()) ? (removePosition -1) : removePosition;
			Integer leftHandSideElement = leftHandList.remove(removePosition);
			rightHandList.addFirst(leftHandSideElement);
			doCalculation (leftHandList, rightHandList, ++currentRepeat, maxRepeat, isArrayEligible, removePosition, arrayLength);
		}
		else if (rightHandSideListSum > leftHandSideListSum)
		{
			boolean isEnteredLoop = false;
			while (rightHandList.size() > 1)
			{
				Integer firstElement = rightHandList.removeFirst();
				leftHandList.addFirst(firstElement);
				removePosition ++;
				isEnteredLoop = true;
			}
			if (isEnteredLoop)
			{
				doCalculation (leftHandList, rightHandList, currentRepeat, maxRepeat, isArrayEligible, removePosition, arrayLength);
			}
		}
		else if (rightHandSideListSum == leftHandSideListSum)
		{
			isArrayEligible.append("true");
		}				
	}
	
	private static int sumList(List<Integer> inputList)
	{
		int sum = 0;
		for (int eachListElement : inputList)
		{
			sum += eachListElement;
		}
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		/*
		 * {1, 4, 7, 2, 2, 4}
		 * {2, 3, 7, 6, 2}
		 * {5, 7, 9, 10, 11, 20}
		 * {2,2,8}
		 */
		
System.out.println(" Is Array Splittable : " + isArraySplittable(new int[] {2, 2}));
	}

}
