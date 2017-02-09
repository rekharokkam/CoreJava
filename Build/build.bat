@set JDK_HOME=D:\Java\jdk1.4
@set ANT_JARS=D:\Testing\JavaTesting\Build\libs
@set old_classpath=%classpath%
@set classpath=%ANT_JARS%\ant.jar;%JDK_HOME%\lib\tools.jar;%ANT_JARS%\optional.jar;%ANT_JARS%\xerces.jar
@rem java org.apache.tools.ant.Main -buildfile buildTest.xml -projecthelp
@echo %classpath%
@java org.apache.tools.ant.Main -buildfile buildTest.xml %1
@set classpath=%old_classpath%
