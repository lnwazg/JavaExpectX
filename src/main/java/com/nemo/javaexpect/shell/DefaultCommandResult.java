package com.nemo.javaexpect.shell;

import java.util.regex.Pattern;

import com.nemo.javaexpect.shell.exception.NemoException;

public class DefaultCommandResult implements CommandResult
{
    String command;
    
    String commandResult;
    
    Integer exitCode;
    
    public DefaultCommandResult(String command, int exitCode)
    {
        this.exitCode = new Integer(exitCode);
        this.command = command;
    }
    
    public DefaultCommandResult(String command, String result)
    {
        this.commandResult = result;
        this.command = command;
    }
    
    @Override
    public String getCommandResult()
    {
        return commandResult;
    }
    
    @Override
    public String getPureCommandResult()
    {
        return decode(getCommandResult());
    }
    
    private static String decode(String fullResult)
    {
        //必须保证fullResult非空，才能进行处理
        if (fullResult != null && fullResult.length() > 0)
        {
            //必须保证结果至少含有3行（第一行是命令自身，最后一行是新的一条命令提示符）
            if (fullResult.split("\n").length >= 3)
            {
                String[] arrays = fullResult.split("\n");
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i < arrays.length - 1; i++)
                {
                    stringBuilder.append(arrays[i]).append("\n");
                }
                //去除最后一个换行符
                return stringBuilder.substring(0, stringBuilder.length() - 1);
            }
        }
        return null;
    }
    
    @Override
    public String getCommand()
    {
        return command;
    }
    
    @Override
    public int getExitCode()
    {
        if (exitCode == null)
        {
            throw new NemoException("exitCode is null");
        }
        return exitCode.intValue();
    }
    
    @Override
    public CommandResult requireText(String expected)
    {
        if (expected == null)
        {
            throw new NullPointerException();
        }
        Pattern p = Pattern.compile(expected);
        if (!p.matcher(commandResult).find())
        {
            String.format("Expected value: %s, actual value: %s",
                expected,
                commandResult);
        }
        return this;
    }
    
    @Override
    public CommandResult requireText(Pattern pattern)
    {
        if (pattern == null)
        {
            throw new NullPointerException();
        }
        if (!pattern.matcher(commandResult).find())
        {
            String.format("Expected value: %s, actual value: %s",
                pattern.pattern(),
                commandResult);
        }
        return this;
    }
    
    @Override
    public CommandResult requireExitCode(int expected)
    {
        int actual = getExitCode();
        if (actual != expected)
        {
            throw new NemoException(String.format(
                "Expected value: %d, actual value: %d", expected, actual));
        }
        return this;
    }
    
}
