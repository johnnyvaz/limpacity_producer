package br.com.limpacity.producer.producer;

public interface ProducerColeta<T> {

    void executeSolicitacao(T message);


}

