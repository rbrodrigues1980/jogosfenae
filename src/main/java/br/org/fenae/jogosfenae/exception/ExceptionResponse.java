package br.org.fenae.jogosfenae.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ExceptionResponse {

    private Date timeStamp;
    private String message;
    private String details;
}
