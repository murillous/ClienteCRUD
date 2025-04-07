package br.com.murillous.clientcrud.dtos;

import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends CustomError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String message, String path ){
        super(timestamp, status, message, path);
    }

    public void addError(String field, String error){
        errors.add(new FieldMessage(field,error));
    }
}
