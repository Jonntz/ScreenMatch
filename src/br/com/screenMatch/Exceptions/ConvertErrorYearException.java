package br.com.screenMatch.Exceptions;

public class ConvertErrorYearException extends RuntimeException{
    private String message;
    public ConvertErrorYearException(String message){
        this.message = message;
    }

    @Override
    public String getMessage () {
        return this.message;
    }
}
