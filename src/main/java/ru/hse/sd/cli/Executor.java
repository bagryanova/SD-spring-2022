package ru.hse.sd.cli;

import java.util.LinkedList;
import java.util.List;

import ru.hse.sd.cli.enums.ReturnCode;
import ru.hse.sd.cli.commands.*;

/**
 * Class that do the main flow
 */
public class Executor {
    /**
     * Field with ability to save information about parameters
     * (It will be helpful in the next step)
     */
    private final Memory memory = new Memory();

    private ReturnCode doCommand(List<String> args_with_com) {
        if (args_with_com.isEmpty()) {
            return ReturnCode.SUCCESS;
        }
        Command command;
        List<String> args = args_with_com.subList(1, args_with_com.size());
        switch (args_with_com.get(0)) {
            case Command.CAT:
                command = new CatCommand(args, System.in, System.out);
                break;
            case Command.ECHO:
                command = new EchoCommand(args, System.in, System.out);
                break;
            case Command.EXIT:
                command = new ExitCommand();
                System.exit(0);
                break;
            case Command.PWD:
                command = new PwdCommand(System.in, System.out);
                break;
            case Command.WC:
                command = new WcCommand(args, System.in, System.out);
                break;
            default:
                command = new OtherCommand(args_with_com.get(0), args, System.in, System.out, memory.getAll());
                break;
        }
        return command.execute();
    }

    /**
     * Method receives input that was written in the console
     * and pushes through the main flow
     *
     * @param input String from the console
     */
    public void execute(String input) {
        var parser = new Parser();
        List<List<RawArg>> raw_commands = parser.parse(input);
        for (List<RawArg> command: raw_commands) {
            List<String> args = new LinkedList<>();
            for (RawArg arg: command) {
                String word = arg.prepareArg(this.memory);
                if (!word.isEmpty()) {
                    args.add(word);
                }
            }
            doCommand(args);
        }
    }
}