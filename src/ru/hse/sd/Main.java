package ru.hse.sd;

import java.util.List;

import ru.hse.sd.commands.CatCommand;
import ru.hse.sd.commands.EchoCommand;
import ru.hse.sd.enums.ReturnCode;

public class Main {

    public static void main(String[] args) {
        EchoCommand echo = new EchoCommand(List.of("hello"));
        ReturnCode code = echo.execute();
        String stream = echo.getOutputStream();
        System.out.println(stream);

        CatCommand cat = new CatCommand(List.of(".gitignore"));
        code = cat.execute();
        stream = cat.getOutputStream();
        System.out.println(stream);
    }

}