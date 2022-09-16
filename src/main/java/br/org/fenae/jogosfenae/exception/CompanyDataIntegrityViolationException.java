package br.org.fenae.jogosfenae.exception;

import org.springframework.dao.NonTransientDataAccessException;

public class CompanyDataIntegrityViolationException extends RuntimeException{

    public CompanyDataIntegrityViolationException(String message) {
        super(message);
    }
}