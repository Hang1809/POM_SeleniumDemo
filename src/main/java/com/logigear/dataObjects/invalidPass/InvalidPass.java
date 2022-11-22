package com.logigear.dataObjects.invalidPass;

public class InvalidPass {
    private int id;
    private String invalidPass;
    public int getId() {return id;}

    public String getInvalidPass() {
        return invalidPass;
    }

    public InvalidPass() {}
    public InvalidPass(String record) {
        String[] invalidDataPass = record.split(",");
        this.id= Integer.parseInt(invalidDataPass[0]);
        this.invalidPass = invalidDataPass[1];
    }
}
