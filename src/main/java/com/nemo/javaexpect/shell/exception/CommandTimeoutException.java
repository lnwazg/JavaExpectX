package com.nemo.javaexpect.shell.exception;

/**
 * 业务超时异常
 * @author nan.li
 * @version 2017年5月17日
 */
public class CommandTimeoutException extends NemoException
{
    private static final long serialVersionUID = -5931241291266067540L;
    
    public CommandTimeoutException(String string)
    {
        super(string);
    }
}
