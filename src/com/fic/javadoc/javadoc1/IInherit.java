package com.fic.javadoc.javadoc1;

/**
 * This is the inheriting interface.
 * 
 * @author brekha
 * @version 1.0
 */
public interface IInherit extends ISuper
{
    /**
     * This method is just overriden from parent interface
     * 
     * @param bIInherit parameter of IInherit
     * @return bIInherit String
     */
    public String test(int bIInherit);
}
