package br.com.murillous.clientcrud.dtos;

import br.com.murillous.clientcrud.entities.Client;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.grammars.hql.HqlParser;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class ClientDTO {

    private Long id;

    private String name;

    @Size(min = 11, max = 11, message = "cpf deve ter 11 dígitos")
    private String cpf;

    @PositiveOrZero(message = "income should be positive")
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
