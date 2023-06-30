package com.example.siliconvalley_prvtd_lmtd.exception;

public enum ErrorCodes {

    CODE_601("SAVING MOMENT ERROR"),CODE_602("DATA NOT EXISTS"),CODE_603("WHILE SAVING MOMENT ERROR"),
    CODE_604("WRONG PARAMETER"),CODE_607("deletion failed"),CODE_625("All record uptodate");


    private ErrorCodes(String message){
        this.message = message;
    }

    public String message;

    public String getMessage() {
        return message;
    }


}
