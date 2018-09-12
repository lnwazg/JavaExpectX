package com.nemo.javaexpect.shell.exception;

/**
 * 远程连接异常
 */
public class ConnectionException extends NemoException
{
    private static final long serialVersionUID = -73516638907418988L;
    
    public ConnectionException(String string)
    {
        super(string);
    }
}
