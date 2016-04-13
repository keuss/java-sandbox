package com.cgi.test.pool.TestObjectPool;


/**
 * Parser for parsing xml documents.
 * 
 * @author abhishek
 *
 * @param <E>
 * @param <T>
 */
public class XmlParser<E, T> implements Parser<E, T> {
    private Exception exception;

    public void parse(E elementToBeParsed, T result) throws Exception {
        try {
            System.out.println("[" + Thread.currentThread().getName()+ "]: Parser Instance:" + this);
            // Do some real parsing stuff.
            
        } catch(Exception e) {
            this.exception = e;
            e.printStackTrace(System.err);
            throw e;
        }
    }

    public boolean isValid() {
        return this.exception == null;
    }

    public void reset() {
        this.exception = null;
    }

}