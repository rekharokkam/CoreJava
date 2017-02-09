package com.fic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OrderSort 
{
	List populateOrderDetails ()
	{
		List orders = new ArrayList(3);
		int[] transactionIds = {1, 2, 3};
		String[] loanPurposes = {"two", "three", null};
		Date[] createdDates = {null, new Date(), null};
		
		for (int i = 0; i < 3; i++) 
		{
			orders.add(new UIOrderDTO(
					new UILoanDTO(createdDates[i], loanPurposes[i]), transactionIds[i]));
		}
		return orders;
	}
	
	List sortObjs (List toBeSorted, int sortOrder)
	{
		UILoanDTO loanDTO1 = null;
		UILoanDTO loanDTO2 = null;
		UIOrderDTO tempOrder = null; 
		UIOrderDTO[] orders = (UIOrderDTO[])toBeSorted.toArray(new UIOrderDTO[0]);
		
		for (int counter = 0; counter < (3 - 1); counter ++)
		{
			loanDTO1 = orders[counter].getLoanDTO();
			loanDTO2 = orders[counter + 1].getLoanDTO();
			
			boolean isSwap = false;
			
			if (sortOrder == 1)//Asc
			{
				if (null != loanDTO1.getCreatedDate() && null != loanDTO2.getCreatedDate())
				{
					if (loanDTO1.getCreatedDate().compareTo(loanDTO2.getCreatedDate()) > 0) 
					{
						isSwap = true;
					}
				}
				
				else if (null == loanDTO2.getCreatedDate())
				{
					isSwap = true;
				}
			}

			if (sortOrder == 2)//Asc
			{
				if (null != loanDTO1.getCreatedDate() && null != loanDTO2.getCreatedDate())
				{
					if (loanDTO1.getCreatedDate().compareTo(loanDTO2.getCreatedDate()) < 0)
					{
						isSwap = true;
					}
				}
				
				else if (null == loanDTO1.getCreatedDate())
				{
					isSwap = true;
				}
			}
			
			if (isSwap)
			{
				
System.out.println("\nisSwap : true");
System.out.println("first Obj : " + orders[counter]);
System.out.println("second Obj : " + orders[counter + 1] + "\n");
				tempOrder = orders[counter + 1];
				orders[counter + 1] = orders[counter];
				orders[counter] = tempOrder;
				
System.out.println("\nSwapping done : true");
System.out.println("first Obj : " + orders[counter]);
System.out.println("second Obj : " + orders[counter + 1] + "\n");
				
			}
		}
		return Arrays.asList(orders);
	}
	
	public static void main(String[] args) 
	{
		OrderSort orderSort = new OrderSort();
		List unSOrtedList = orderSort.populateOrderDetails();
		
System.out.println("BEFORE SORTING");		
		
for (int i = 0; i < unSOrtedList.size(); i++) 
{
System.out.println(unSOrtedList.get(i));	
}

		List sortedOrders = orderSort.sortObjs(unSOrtedList, 1);
		
System.out.println("\n\nAFTER SORTING");		
		
for (int i = 0; i < sortedOrders.size(); i++) 
{
System.out.println(sortedOrders.get(i));	
}


	}
}

class UIOrderDTO
{
	private UILoanDTO loanDTO;
	private long transactionId;
	
	public UIOrderDTO(UILoanDTO uiLoanDTO, long transactionId)
	{
		this.loanDTO = uiLoanDTO;
		this.transactionId = transactionId;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer ();
		sb.append("TRANSACTION ID : ").append(transactionId);
		sb.append("\n\tLoan Details ::: ").append(loanDTO);
		return sb.toString();  
	}
	
	public UILoanDTO getLoanDTO()
	{
		return loanDTO;
	}
}

class UILoanDTO
{
	private Date createdDate;
	private String loanPurpose;
	
	public UILoanDTO(Date createdDate, String loanPurpose)
	{
		this.loanPurpose = loanPurpose;
		this.createdDate = createdDate;
	}	
	
	public Date getCreatedDate()
	{
		return createdDate;
	}
	
	public String toString ()
	{
		return "Loan Purpose : " + loanPurpose + " , created Date : " + createdDate;
	}
}