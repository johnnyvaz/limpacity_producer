package br.com.limpacity.producer.producer;

public interface ProducerEmail<T> {

    void executeNotifica(T message);

}

