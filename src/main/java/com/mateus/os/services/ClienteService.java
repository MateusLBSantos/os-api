package com.mateus.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.os.domain.Cliente;
import com.mateus.os.domain.Pessoa;
import com.mateus.os.dtos.ClienteDTO;
import com.mateus.os.repositories.ClienteRepository;
import com.mateus.os.repositories.PessoaRepository;
import com.mateus.os.services.exceptions.DataIntegratyViolationException;
import com.mateus.os.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados");
		}
		return clienteRepository.save(new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}


	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente clienteAntigo = findById(id);
		
		if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados");
		}
		
		clienteAntigo.setNome(objDTO.getNome());
		clienteAntigo.setCpf(objDTO.getCpf());
		clienteAntigo.setTelefone(objDTO.getTelefone());
		
		return clienteRepository.save(clienteAntigo);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		
		if(obj.getList().size() > 0) {
			throw new DataIntegratyViolationException("Cliente possui Ordens de Serviço, não pode ser Deletado!");
		}
		
		clienteRepository.deleteById(id);
		
	}
	private Pessoa findByCPF(ClienteDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		
		if(obj != null) {
			return obj;
		}
		return null;
	}
}
