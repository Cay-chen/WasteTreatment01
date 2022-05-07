package com.waste.treatment.bean;

public class Success {
    private boolean IsSuccess;
    private String ErrorMsg;
    private String Content;


    @Override
    public String toString() {
        return "Success{" +
                "IsSuccess='" + IsSuccess + '\'' +
                ", ErrorMsg='" + ErrorMsg + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }

    public boolean getIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
         IsSuccess =isSuccess;
    }

    public String getErrorMsg() {
        return ErrorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        ErrorMsg = errorMsg;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
