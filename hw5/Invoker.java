package com.hw.homeworks.hw5;

public class Invoker {

    Command delete;
    Command undo;
    Command append;



    public Invoker(Command delete, Command undo, Command append) {
        this.delete = delete;
        this.undo = undo;
        this.append = append;
    }

    public void deleteRecord(int start, int end) {
        delete.setArg(start, end);
        delete.execute();
    }

    public void appendRecord(String app) {
        append.setArg(app);
        append.execute();
    }

    public void undoRecord() {
        undo.execute();
    }
}
