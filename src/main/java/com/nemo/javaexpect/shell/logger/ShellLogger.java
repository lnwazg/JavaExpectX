package com.nemo.javaexpect.shell.logger;

/**
 * shell交互日志接口
 * @author Canhua Li
 */
public interface ShellLogger
{
    /**
     * 记录执行结果
     * @param lineIntestCase 执行的命令
     * @param id	 Shell的UID
     * @param command 当前调用的参数
     * @param shellOutput shell的输出
     */
    void log(String lineIntestCase, String id, String command, String shellOutput);
}
