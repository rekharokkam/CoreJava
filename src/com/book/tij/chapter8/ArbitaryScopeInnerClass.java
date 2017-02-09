package com.book.tij.chapter8;

public class ArbitaryScopeInnerClass
{
	void getTrackingSlipId(boolean isTrack)
	{
		if (isTrack)
		{
			class TrackingSlip
			{
				private String id;
				TrackingSlip(String id)
				{
					this.id = id;
				}
				
				String getSlip ()
				{
					return id;
				}
			} //Arbitary class Definition ends here
			TrackingSlip trackingSlip = new TrackingSlip ("slip");
System.out.println("Tracking slip Id :: " + trackingSlip.getSlip());			
		}
		
//		TrackingSlip trackingSlip = new TrackingSlip ();//Out of scope
		
	}
	
	public static void main(String[] args)
	{
		new ArbitaryScopeInnerClass().getTrackingSlipId(true);
	}
}

