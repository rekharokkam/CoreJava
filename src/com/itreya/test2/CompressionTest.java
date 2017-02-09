package com.itreya.test2;

import java.util.zip.Deflater;
import java.util.ArrayList;

public class CompressionTest
{
	public static void main (String args[])
	{
		String toBeCompressed = "If you use the -find [file] option, Ant will search for a build file first in the current directory, then in the parent directory, and so on, until either a build file is found or the root of the filesystem has been reached. By default, it will look for a build file called build.xml. To have it search for a build file other than build.xml, specify a file argument. Note: If you include any other flags or arguments on the command line after the -find flag, you must include the file argument for the -find flag, even if the name of the build file you want to find is build.xml."
								+ "Options tat affect the amount of logging output by Ant are: -quiet, which instructs Ant to print less information to the console; -verbose, which causes Ant to print additional information to the console; and -debug, which causes Ant to print considerably more additional information."
								+ "A target also has the ability to perform its execution if (or unless) a property has been set. This allows, for example, better control on the building process depending on the state of the system (java version, OS, command-line property defines, etc.). To make a target sense this property, you should add the if (or unless) attribute with the name of the property tat the target should react to. For example:"
								+ "A target can depend on other targets. You might have a target for compiling, for example, and a target for creating a distributable. You can only build a distributable when you have compiled first, so the distribute target depends on the compile target. Ant resolves these dependencies."
								+ "Unless you're spending a lot of time blocked, waiting for I/O operations to complete, a program tat uses multiple concurrent threads will often run slower than an equivalent single-threaded program, although it will often be better organized than the equivalent single-thread version. A program tat uses multiple threads running in parallel on multiple processors will run much faster."
								+ "Though Java permits threading to be implemented entirely in the VM, at least in theory, this approach would preclude any parallelism in your application. If no operating-system-level threads were used, the OS would look at the VM instance as a single-threaded application, which would most likely be scheduled to a single processor. The net result would be tat no two Java threads running under the same VM instance would ever run in parallel, even if you had multiple CPUs and your VM was the only active process. Two instances of the VM running separate applications could run in parallel, of course, but I want to do better than tat. To get parallelism, the VM must map Java threads through to OS threads; so, you can't afford to ignore the differences between the various threading models if platform independence is important."
								+ "NT's paucity of priority levels is a problem if you want to use priority to control scheduling. Things are made even more complicated by the fact tat priority levels aren't fixed. NT provides a mechanism called priority boosting, which you can turn off with a C system call, but not from Java. When priority boosting is enabled, NT boosts a thread's priority by an indeterminate amount for an indeterminate amount of time every time it executes certain I/O-related system calls. In practice, this means tat a thread's priority level could be higher than you think because tat thread happened to perform an I/O operation at an awkward time."
								+ "The point of the priority boosting is to prevent threads tat are doing background processing from impacting the apparent responsiveness of UI-heavy tasks. Other operating systems have more-sophisticated algorithms tat typically lower the priority of background processes. The downside of this scheme, particularly when implemented on a per-thread rather than a per-process level, is tat it's very difficult to use priority to determine when a particular thread will run."
								+ "In Solaris, as is the case in all Unix systems, processes have priority as well as threads. The threads of high-priority processes can't be interrupted by the threads of low-priority processes. Moreover, the priority level of a given process can be limited by a system administrator so tat a user process won't interrupt critical OS processes. NT supports none of this. An NT process is just an address space. It has no priority per se, and is not scheduled. The system schedules threads; then, if a given thread is running under a process tat isn't in memory, the process is swapped in. NT thread priorities fall into various priority classes, tat are distributed across a continuum of actual priorities. The system looks like this: "
								+ "The columns are actual priority levels, only 22 of which must be shared by all applications. (The others are used by NT itself.) The rows are priority classes. The threads running in a process pegged at the idle priority class are running at levels 1 through 6 and 15, depending on their assigned logical priority level. The threads of a process pegged as normal priority class will run at levels 1, 6 through 10, or 15 if the process doesn't have the input focus. If it does have the input focus, the threads run at levels 1, 7 through 11, or 15. This means tat a high-priority thread of an idle priority class process can preempt a low-priority thread of a normal priority class process, but only if tat process is running in the background. Notice tat a process running in the high priority class only has six priority levels available to it. The other classes have seven."; 

		

	
		byte eachByte [] = toBeCompressed.getBytes();
		
		System.out.println ("BEFORE COMPRESSION = " + eachByte.length);
		
		byte output [] = new byte[1024];
		
		Deflater deflater = new Deflater ();
		deflater.setLevel(Deflater.DEFAULT_COMPRESSION);
		deflater.setInput(eachByte);
		deflater.finish ();
		
		int totalCompression = deflater.deflate(output);
		System.out.println ("TOTALLY COMPRESSED BYTES = " + deflater.getTotalOut());
		
	}
}