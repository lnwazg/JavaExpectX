package com.nemo.javaexpect.shell.logger;

import com.nemo.javaexpect.shell.driver.DefaultShellDriver;

/**
 * Shell交互日志接口的默认实现方式
 * @author nan.li
 * @version 2017年5月17日
 */
public class DefaultShellLogger implements ShellLogger
{
    @Override
    public void log(String lineIntestCase, String id, String command, String shellOutput)
    {
        //日志开关起了作用
        if (!DefaultShellDriver.CONSOLE_LOG_SWITCH)
        {
            return;
        }
        if (shellOutput != null)
        {
            System.out.print(shellOutput);
        }
    }
}
