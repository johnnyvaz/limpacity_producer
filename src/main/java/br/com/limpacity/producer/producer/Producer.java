package br.com.limpacity.producer.producer;

public interface Producer<T> {

    void execute(T message);

}

