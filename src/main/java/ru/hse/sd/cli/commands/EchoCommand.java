package main.java.ru.hse.sd.cli.commands;

import java.util.List;

import main.java.ru.hse.sd.cli.enums.ReturnCode;

/*
 * Implementation of Bash's echo command
 */
public class EchoCommand extends Command {
    private final List<String> args;

    /*
     * Constructor which takes arguments for echo command
     */
    public EchoCommand(List<String> args) {
        this.command = "echo";
        this.args = args;
    }

    /*
     * Execute echo command with arguments from constructor
     */
    @Override
    public ReturnCode execute() {
        if (args.isEmpty()) {
            outputStream = inputStream;
            return ReturnCode.SUCCESS;
        }
        outputStream = String.join(" ", args);
        return ReturnCode.SUCCESS;
    }
}