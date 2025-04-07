package br.com.murillous.clientcrud.service;

import br.com.murillous.clientcrud.dtos.ClientDTO;
import br.com.murillous.clientcrud.entities.Client;
import br.com.murillous.clientcrud.repositories.ClientRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional
    public ClientDTO findById(Long id){
        Client entity = repository.findById(id).get();

        return new ClientDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDTOtoEntity(dto,entity);
        entity = repository.save(entity);

        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id,ClientDTO dto){
        Client entity = repository.getReferenceById(id);
        copyDTOtoEntity(dto,entity);

        entity = repository.save(entity);

        return new ClientDTO(entity);
    }

    private void copyDTOtoEntity(ClientDTO dto, Client entity){
        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setChildren(dto.getChildren());
    }
}
