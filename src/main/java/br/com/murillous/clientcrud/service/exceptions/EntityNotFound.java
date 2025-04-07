package br.com.murillous.clientcrud.service.exceptions;

public class EntityNotFound extends  RuntimeException{
    public EntityNotFound(String msg){
        super(msg);
    }
}
