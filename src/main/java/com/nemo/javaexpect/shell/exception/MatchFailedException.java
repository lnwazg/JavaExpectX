package com.nemo.javaexpect.shell.exception;

/**
 * 匹配失败异常
 * @author nan.li
 * @version 2017年5月17日
 */
public class MatchFailedException extends NemoException
{
    private static final long serialVersionUID = -2828713474884919604L;
    
    public MatchFailedException(String string)
    {
        super(string);
    }
}
