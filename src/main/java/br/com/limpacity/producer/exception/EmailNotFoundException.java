package br.com.limpacity.producer.exception;

public class EmailNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -992179346136943635L;

    public EmailNotFoundException(){
        super(" E-mail Não encontrado");
    }
}
