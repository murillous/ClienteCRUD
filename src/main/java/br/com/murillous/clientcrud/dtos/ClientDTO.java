package br.com.murillous.clientcrud.dtos;

import br.com.murillous.clientcrud.entities.Client;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.grammars.hql.HqlParser;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class ClientDTO {

    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Size(min = 11, max = 11, message = "CPF must have 11 digits")
    private String cpf;

    @PositiveOrZero(message = "Income must be positive")
    private Double income;

    @PastOrPresent(message = "Date of birth cannot be in the future")
    private LocalDate birthDate;

    @PositiveOrZero(message = "Number of children cannot be negative")
    private Integer children;

    public ClientDTO(Client entity){
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }


}
