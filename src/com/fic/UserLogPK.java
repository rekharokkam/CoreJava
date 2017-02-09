package com.fic;

import java.io.Serializable;

public class UserLogPK implements Serializable
{
	private static final long serialVersionUID = 280944268755253130L;
	private int _hashCode = Integer.MIN_VALUE;
	
	public String userId;
	public String companyId;
	public long accessCounter;
	public String loanNickName;

	public UserLogPK() {}

	public static long getSerialVersionUID()
	{
		return serialVersionUID;
	}

	public long getAccessCounter()
	{
		return accessCounter;
	}

	public void setAccessCounter(long accessCounter)
	{
		this.accessCounter = accessCounter;
	}

	public String getCompanyId()
	{
		return companyId;
	}

	public void setCompanyId(String companyId)
	{
		this.companyId = companyId;
	}

	public String getLoanNickName()
	{
		return loanNickName;
	}

	public void setLoanNickName(String loanNickName)
	{
		this.loanNickName = loanNickName;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public int hashCode()
	{
		if( _hashCode == Integer.MIN_VALUE )
		{
			if (isStringValid(this.getUserId()))
			{
				_hashCode += this.getUserId().hashCode();
			}
		}
		return _hashCode;
	}
	
	public boolean equals (Object toBeCompared)
	{
		if (toBeCompared instanceof UserLogPK)
		{
			UserLogPK userLogPK = (UserLogPK)toBeCompared;
			if ( 
					( isStringValid(this.getUserId()) && isStringValid(userLogPK.getUserId()) && userLogPK.getUserId().equals(this.getUserId())) &&
					(isStringValid(this.getCompanyId()) && isStringValid(userLogPK.getCompanyId()) && userLogPK.getCompanyId().equals(this.getCompanyId())) &&
					(this.getAccessCounter() == userLogPK.getAccessCounter()) &&
					(isStringValid(this.getLoanNickName()) && isStringValid(userLogPK.getLoanNickName()) && userLogPK.getLoanNickName().equals(this.getLoanNickName()))
				)
			{
				return true;	
			}
		}
		return false;
	}
	
	private static boolean isStringValid (String toBeChecked)
	{
		if (null == toBeChecked || toBeChecked.trim().equals(""))
		{
			return false;
		}
		return true;
	}
}
