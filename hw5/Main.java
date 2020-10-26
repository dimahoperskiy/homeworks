package com.hw.homeworks.hw5;

public class Main {

    public static void main(String[] args) {

		StringBuilder stringBuilder = new StringBuilder("Oh my god what am I doing?");

	    StrBld strBld = new StrBld(stringBuilder);

	    Invoker invoker = new Invoker(
	            new DeleteCommand(strBld),
	            new UndoCommand(strBld),
				new AppendCommand(strBld)
        );

		System.out.println(strBld.getStringBuilder());

	    invoker.deleteRecord(5, 9);
		System.out.println(strBld.getStringBuilder());

		invoker.appendRecord("omg wtf");
		System.out.println(strBld.getStringBuilder());

		invoker.undoRecord();
		System.out.println(strBld.getStringBuilder());

		invoker.undoRecord();
		System.out.println(strBld.getStringBuilder());



    }

}
