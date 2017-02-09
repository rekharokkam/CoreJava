/**This class retrieves the data values from the class ExcelReader and Sets the new 
 * Info Object ReportDataInfo.java
 */

package com.itreya.test1;

public class DataSetter
{
	/*
	public Object dataGetter()
	{
		
		ExcelReader reader = new ExcelReader();
		ArrayList result = (ArrayList)reader.excelResult();		
		HashMap allResults = new HashMap();	
		
		float fple = 0;
		float fcrs = 0;
		float fars = 0;
		float fsum = fple+fcrs+fars;
		
		
		for (java.util.Iterator it = result.iterator();it.hasNext();)
		{
			HashMap eachRow = (HashMap)it.next();
			String accidentyear = accidentYear((String)eachRow.get("ACCIDENTYEAR"));
			String registrationyear = regYear((String)eachRow.get("REGISTRATIONYEAR"));			
			float ple = 0;
			float crs = 0;
			float ars = 0;
			
			
			if (null==(String)eachRow.get("PLE"))
			{	
				ple = 0;				
			}
			else
			{
				ple = Float.parseFloat((String)eachRow.get("PLE"));
			}
			
			if (null==(String)eachRow.get("CRS"))
			{		
				crs = 0;				
			}
			else
			{
				crs = Float.parseFloat((String)eachRow.get("CRS"));
			}
			if (null==(String)eachRow.get("ARS"))
			{		
				ars = 0;				
			}
			else
			{
				ars = Float.parseFloat((String)eachRow.get("ARS"));
			}
			
			float sum = ple+crs+ars;			
			ReportDataInfo report;
			
			if (null!=(report = (ReportDataInfo)allResults.get(accidentyear)))
			{							
				
				fple = fple + ple;				
				fcrs = fcrs + crs;				
				fars = fars + ars;
				fsum = fsum + sum;
				
				ArrayList ples = report.getPLE();
				ples.add(new Float(fple));
				
				ArrayList crss = report.getCRS();
				crss.add(new Float(fcrs));
				
				ArrayList arss = report.getARS();
				arss.add(new Float(fars));
				
				ArrayList sums = report.getSUM();
				sums.add(new Float(fsum));
				
				ArrayList registration = report.getREGYEAR();
				registration.add(registrationyear);			
				
			}
			
			else
			{
				report = new ReportDataInfo();				
				ArrayList pleArr = new ArrayList();
				ArrayList crsArr = new ArrayList();
				ArrayList arsArr = new ArrayList();
				ArrayList sumArr = new ArrayList();
				ArrayList regyear = new ArrayList();		
				
				report.setACCYEAR(accidentyear);							
				regyear.add(registrationyear);						
				
				pleArr.add(new Float(ple));
				fple = ple;
				crsArr.add(new Float(crs));
				fcrs = crs;
				arsArr.add(new Float(ars));
				fars = ars;
				sumArr.add(new Float(sum));
				fsum = sum;
				
				report.setREGYEAR(regyear);
				report.setPLE(pleArr);
				report.setCRS(crsArr);
				report.setARS(arsArr);
				report.setSUM(sumArr);			
				
			}	
		
			allResults.put(accidentyear,report);				
		}	
		return allResults;		
	}
	
	public static void main (String args[])
	{
		DataSetter data = new DataSetter();
		data.displayResults();
	}
	
	public String accidentYear(String accident)
	{
		return (accident.substring(accident.length()-4));
	}
	
	public String regYear (String reg)
	{
		return (reg.substring(0,(reg.indexOf("."))));
	}
	*/
	/**this method is exclusively for printing the results and also to verify the 
	 * result
	 */
	
		/*
	public void displayResults()
	{
		HashMap reports = (HashMap)dataGetter();
		String accidentyears[] = new String[reports.size()];
		Set se = reports.keySet();				
		System.out.println("the length of the array is\t"+se.size());				
		for (java.util.Iterator it = se.iterator();it.hasNext();)
		{
			String accident = (String)it.next();
			System.out.println(accident);
			ReportDataInfo repo = (ReportDataInfo)reports.get(accident);
			System.out.println("PLE"+repo.getPLE());
			System.out.println("crs"+repo.getCRS());
			System.out.println("ars"+repo.getARS());
			System.out.println("sum"+repo.getSUM());
			System.out.println("registrationyear"+repo.getREGYEAR());
			
			System.out.println("\n\n");
			
		}
	}
		*/
}