/**this class gives the best way of reading data from huge files
 * copied from the url
 * http://builder.com.com/utils/sidebar.jhtml?id=u00220020613sge01.htm&index=2
 * 
 * for the related article refer to
 * http://builder.com.com/article.jhtml?id=u00220020613sge01.htm&page=1&vf=tt
 */


 
 
/**  
 * Reads a file storing intermediate data into a list. Fast method.   
 * @param file the file to be read  
 * @return a file data 
 
   
public byte[] read2list(String file) throws Exception 
{ 
	
	InputStream in = null;     
	byte[] buf             = null; // output buffer    
	int    bufLen          = 20000*1024;     
	try
	{
		
        in = new BufferedInputStream(new FileInputStream(file));     
		buf = new byte[bufLen];   
		byte[] tmp = null;   
		int len    = 0;   
		List data  = new ArrayList(24); // keeps peaces of data     

		while((len = in.read(buf,0,bufLen)) != -1)
		{     
			tmp = new byte[len];      
			System.arraycopy(buf,0,tmp,0,len); // still need to do copy        
			data.add(tmp);         
		}  

        This part is optional. This method could return a List data for further processing, etc.    

	    len = 0;  
        if (data.size() == 1) 
			return (byte[]) data.get(0);       

		for (int i=0;i<data.size();i++) 
			len += ((byte[]) data.get(i)).length;   

	    buf = new byte[len]; // final output buffer      
		len = 0;         
		for (int i=0;i<data.size();i++)
		{ // fill with data      
		    tmp = (byte[]) data.get(i);           
			System.arraycopy(tmp,0,buf,len,tmp.length);    
			len += tmp.length;         
		}      
	}

	finally
	{         
		if (in != null) 
		try
		{
			in.close();
		}
		catch (Exception e)
		{
			
		}      
	}      
	return buf;   
} 

//Another way of efficiently writting data to output
OutputStream destination;
//...

if( (temporary_file.export_buffer_and_close(destination)) == null )
{   
    InputStream in     = new FileInputStream("file.tmp");
    byte[]      buffer = new byte[1024];
    int         got    = 0;
    while( (got = in.read(buffer)) > 0 )
        destination.write( buffer, 0, got );
    in.close();
}
*/

