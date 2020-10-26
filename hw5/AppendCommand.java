package com.hw.homeworks.hw5;

public class AppendCommand implements Command{
    StrBld strBld;
    String app;

    public AppendCommand(StrBld strBld) {
        this.strBld = strBld;
    }


    @Override
    public void execute() {
        strBld.append(app);

    }

    @Override
    public void setArg(Object o) {
        app = (String)o;
    }

    @Override
    public void setArg(Object o1, Object o2) {}
}
