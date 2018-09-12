package com.nemo.javaexpect.shell.driver;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 一个包含输入输出流的远程连接
 *
 */
public interface Connection
{
    public void close();
    
    public OutputStream getOutputStream();
    
    public InputStream getInputStream();
    
    boolean isActive();
}
