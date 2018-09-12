package com.nemo.javaexpect.shell;

import java.util.regex.Pattern;

/**
 * 命令执行的结果对象
 * @author nan.li
 * @version 2017年5月17日
 */
public interface CommandResult
{
    /**
     * 获取命令执行结果的完整输出
     * @author nan.li
     * @return
     */
    public String getCommandResult();
    
    /**
     * 获取命令执行结果的纯输出（不包含当前执行的命令以及下一个命令提示符）
     * @author nan.li
     * @return
     */
    public String getPureCommandResult();
    
    /**
     * 获取命令
     * @author nan.li
     * @return
     */
    public String getCommand();
    
    /**
     * 获取退出码
     * @author nan.li
     * @return
     */
    public int getExitCode();
    
    /**
     * 断言结果是与给定正则式匹配的 
     * @param	期望的正则式
     * @throws NullPointerException 如果给定的正则式为null {@code null}.
     * @throw NemoException 如果未匹配成功	
     */
    public CommandResult requireText(String expected);
    
    /**
     * 断言结果是与给定正则式匹配的 
     * @param 期望的正则式
     * @throws NullPointerException 如果给定的正则式为null {@code null}.
     * @throw NemoException 如果未匹配成功	
     */
    public CommandResult requireText(Pattern pattern);
    
    /**
     * 断言结果与给定的编码匹配 
     * @param 匹配的编码
     * @throw NemoException 未匹配成功	
     */
    public CommandResult requireExitCode(int expected);
}