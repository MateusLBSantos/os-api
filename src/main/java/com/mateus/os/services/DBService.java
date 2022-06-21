package com.mateus.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.os.domain.Cliente;
import com.mateus.os.domain.OrdemServico;
import com.mateus.os.domain.Tecnico;
import com.mateus.os.domain.enuns.Prioridade;
import com.mateus.os.domain.enuns.Status;
import com.mateus.os.repositories.ClienteRepository;
import com.mateus.os.repositories.OrdemServicoRepository;
import com.mateus.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Mateus Santos", "579.988.260-10", "(69) 2556-2887");
		Tecnico t2 = new Tecnico(null, "João Santos", "496.612.613-42", "(37) 99988-7766");
		Cliente c1 = new Cliente(null, "Laisa Cunha Negris Filho", "035.417.787-76", "(38) 98264-8705");
		OrdemServico os1 = new OrdemServico(null, Prioridade.ALTA, "teste create Os", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1,t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		ordemServicoRepository.saveAll(Arrays.asList(os1));
	}

}
