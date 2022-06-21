package com.mateus.os.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.os.domain.Cliente;
import com.mateus.os.domain.OrdemServico;
import com.mateus.os.domain.Tecnico;
import com.mateus.os.domain.enuns.Prioridade;
import com.mateus.os.domain.enuns.Status;
import com.mateus.os.dtos.OsDTO;
import com.mateus.os.repositories.OrdemServicoRepository;
import com.mateus.os.services.exceptions.ObjectNotFoundException;

@Service
public class OsService {

	@Autowired
	private OrdemServicoRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public OrdemServico findById(Integer id) {
		Optional<OrdemServico> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + OrdemServico.class.getName()));
	}
	
	public List<OrdemServico> findAll() {
		return repository.findAll();
	}

	public OrdemServico create(@Valid OsDTO obj) {
		return fromDTO(obj);

	}
	
	public OrdemServico update(@Valid OsDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}
	
	private OrdemServico fromDTO(OsDTO obj) {
		OrdemServico newObj = new OrdemServico();
		
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		newObj.setStatus(Status.toEnum(obj.getStatus()));
		
		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		newObj.setTecnico(tec);
		newObj.setCliente(cliente);
		
		if(newObj.getStatus().getCod().equals(2)) {
			newObj.setDataFechamento(LocalDateTime.now());
		}
		
		return repository.save(newObj);
	}

}
