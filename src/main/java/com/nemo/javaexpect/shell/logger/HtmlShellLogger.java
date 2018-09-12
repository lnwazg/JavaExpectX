package com.nemo.javaexpect.shell.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.nemo.javaexpect.shell.driver.DefaultShellDriver;

/**
 * Html类型的日志记录器
 * @author nan.li
 * @version 2017年5月17日
 */
public class HtmlShellLogger implements ShellLogger
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
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time = df.format(date);
            String out = String.format("<shell><time>%s</time><lineInCase>%s</lineInCase><shellID>%s</shellID>" +
                "<shellCommand>%s</shellCommand><shellOutput>%s</shellOutput></shell>",
                time,
                lineIntestCase,
                id,
                command,
                shellOutput);
            System.out.println(out);
        }
    }
}
