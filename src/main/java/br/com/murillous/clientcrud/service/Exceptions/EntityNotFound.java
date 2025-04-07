package br.com.murillous.clientcrud.service.Exceptions;

public class EntityNotFound extends  RuntimeException{
    public EntityNotFound(String msg){
        super(msg);
    }
}
