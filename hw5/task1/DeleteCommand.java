package com.hw.homeworks.hw5.task1;

public class DeleteCommand implements Command{

    StrBld strBld;
    int start;
    int end;

    public DeleteCommand(StrBld strBld) {
        this.strBld = strBld;
    }


    @Override
    public void execute() {
        strBld.delete(start, end);
    }

    @Override
    public void setArg(Object o) {}

    @Override
    public void setArg(Object o1, Object o2) {
        start = (int)o1;
        end = (int)o2;
    }


}
