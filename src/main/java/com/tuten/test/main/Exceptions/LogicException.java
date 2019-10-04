package com.tuten.test.main.Exceptions;

/**
 * @author Manuel Pimentel
 * @version 1.0
 * @description
 * @since 2019-10-02
 */

public class LogicException extends Exception
{
    public LogicException(String message)
    {
        super(message);
    }

    public LogicException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public LogicException(Throwable cause)
    {
        super(cause);
    }
}
