package com.ueg.progIII.service;

import com.ueg.progIII.model.Cliente;
import com.ueg.progIII.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Cliente incluir(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente remover(String cpf){
        Optional<Cliente> clienteOptional = obterClienteSeExiste(cpf);

        if(clienteOptional.isEmpty()){
            throw new IllegalAccessError("Cpf "+ cpf +" não cadastrado");
        }

        Cliente cliente = clienteOptional.get();
        clienteRepository.delete(cliente);

        return cliente;
    }

    private Optional<Cliente> obterClienteSeExiste(String cpf) {
        return clienteRepository.findById(cpf);
    }

    public Cliente alterar(Cliente cliente, String cpf){
       Optional<Cliente> clienteOptional = obterClienteSeExiste(cpf);

       if(clienteOptional.isEmpty()){
           throw new IllegalAccessError("Cpf "+ cpf +" não cadastrado");
       }

       Cliente clienteBD = clienteOptional.get();

       clienteBD.setPrimeiroNome(cliente.getPrimeiroNome());
       clienteBD.setSobreNome(cliente.getSobreNome());
       clienteBD.setEndereco(cliente.getEndereco());
       clienteBD.setDataNascimento(cliente.getDataNascimento());
       clienteBD.setTelefone(cliente.getTelefone());

       return clienteBD;

    }
}
