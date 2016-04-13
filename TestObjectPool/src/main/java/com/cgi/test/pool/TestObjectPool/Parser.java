package com.cgi.test.pool.TestObjectPool;

/**
 * Abstract definition of Parser.
 * 
 * @author abhishek
 *
 */
public interface Parser<E, T> {

    /**
     * Parse the element E and set the result back into target object T.
     * 
     * @param elementToBeParsed
     * @param result
     * @throws Exception
     */
    public void parse(E elementToBeParsed, T result) throws Exception;
    
    
    /**
     * Tells whether this parser is valid or not. This will ensure the we
     * will never be using an invalid/corrupt parser.
     * 
     * @return
     */
    public boolean isValid();
    
    
    /**
     * Reset parser state back to the original, so that it will be as
     * good as new parser.
     * 
     */
    public void reset();
}