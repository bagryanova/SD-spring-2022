package ru.hse.sd.commands;

import ru.hse.sd.enums.ReturnCode;


public class ExitCommand extends Command {
  @Override
  public ReturnCode execute() {
    return ReturnCode.SUCCESS;
  };
}