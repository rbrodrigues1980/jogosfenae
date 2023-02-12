package br.org.fenae.jogosfenae.exception;

public class ParticipantNotFoundException extends RuntimeException{

    public ParticipantNotFoundException(String message){
        super(message);
    }
}
