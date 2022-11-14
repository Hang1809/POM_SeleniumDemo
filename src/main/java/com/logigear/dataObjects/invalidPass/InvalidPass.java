package com.logigear.dataObjects.invalidPass;

public class InvalidPass {
    private int id;
    private String invalidPass;

    public int getId() {
        return id;
    }

    public InvalidPass() {
    }

    public InvalidPass(String record) {
        String[] invalidDataPass = record.split(",");
        this.invalidPass = invalidDataPass[1];
    }
}
