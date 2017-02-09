package com.book.tij5.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTask
{
	public static void main(String[] args)
	{
		List<Future<String>> results = new ArrayList<Future<String>> ();
		ExecutorService exec = Executors.newCachedThreadPool();
		
		//add results into the arraylist
		for (int i = 0; i < 5; i++)
		{
			results.add(exec.submit(new TaskWithResult (i)));
		}
		
		//retrieve added
		for (Future<String> fs : results)
		{
			try
			{
System.out.println(fs.get());				
			}
			catch (InterruptedException interruptedException)
			{
interruptedException.printStackTrace(System.err);				
			}
			catch (ExecutionException executionException)
			{
executionException.printStackTrace(System.err);				
			}
		}
	}
}

class TaskWithResult implements Callable<String>
{
	private int id;
	
	TaskWithResult (int id)
	{
		this.id = id;
	}
	
	public String call ()
	{
		return "result of TaskWithResult - " + id;
	}
}