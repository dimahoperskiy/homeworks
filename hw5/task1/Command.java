package com.hw.homeworks.hw5.task1;

public interface Command {
    void execute();
    void setArg(Object o);
    void setArg(Object o1, Object o2);

}
