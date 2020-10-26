package com.hw.homeworks.hw5;


import java.util.Stack;

public class StrBld {

    StringBuilder stringBuilder;
    Stack<Command> stack = new Stack<>();

    public StrBld(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }



    public void delete(int start, int end) {
        String deletedString = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);

        Command command = new Command() {
            @Override
            public void execute() {
                stringBuilder.insert(start, deletedString);
            }
            @Override
            public void setArg(Object o) {}
            @Override
            public void setArg(Object o1, Object o2) {}
        };
        stack.add(command);
    }

    public void append(String del) {
        int len = stringBuilder.length();
        stringBuilder.append(del);
        Command command = new Command() {
            @Override
            public void execute() {
                stringBuilder.delete(len, stringBuilder.length());
            }
            @Override
            public void setArg(Object o) { }

            @Override
            public void setArg(Object o1, Object o2) {}
        };
        stack.add(command);
    }


    public void undo(){
        if (!stack.isEmpty()){
            stack.pop().execute();
        }
    }
}
