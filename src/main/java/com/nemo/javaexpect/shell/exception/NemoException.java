package com.nemo.javaexpect.shell.exception;

/**
 * Shell业务异常
 * @author nan.li
 * @version 2017年5月17日
 */
public class NemoException extends RuntimeException
{
    private static final long serialVersionUID = -9064638317538055952L;
    
    public NemoException(String string)
    {
        super(string);
    }
}
