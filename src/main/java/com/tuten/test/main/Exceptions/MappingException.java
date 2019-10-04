package com.tuten.test.main.Exceptions;

/**
 * @author Manuel Pimentel
 * @version 1.0
 * @description
 * @since 2019-10-02
 */

public class MappingException extends Exception
{
    public MappingException(String message)
    {
        super(message);
    }

    public MappingException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
