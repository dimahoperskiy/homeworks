package com.hw.homeworks.hw5;

public class UndoCommand implements Command {

    StrBld strBld;

    public UndoCommand(StrBld strBld) {
        this.strBld = strBld;
    }

    @Override
    public void execute() {
        strBld.undo();
    }

    @Override
    public void setArg(Object o) {}

    @Override
    public void setArg(Object o1, Object o2) {}
}
