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
		Tecnico t2 = new Tecnico(null, "Carlos Macário Biango Sales", "496.612.613-42", "(37) 99988-7766");
		Tecnico t3 = new Tecnico(null, "Ryan Nobrega Pedroso Almeida", "758.597.117-60", "(37) 99988-7766");
		Tecnico t4 = new Tecnico(null, "Vinícius Magalhães Fundão Barsosa", "595.145.158-20", "(37) 99988-7766");
		Tecnico t5 = new Tecnico(null, "Aledio de Barros Camacho Cavalcanti", "595.145.158-20", "(37) 99988-7766");
		Tecnico t6 = new Tecnico(null, "Noah de Sá Camara Vasgestian", "597.424.361-77", "(37) 99988-7766");
		Tecnico t7 = new Tecnico(null, "Cassio Boelho Carmanin Cordeiro", "189.486.560-07", "(37) 99988-7766");
		Tecnico t8 = new Tecnico(null, "Emmanuel Cavalcante Alentejo Anastacio", "617.240.421-06", "(37) 99988-7766");
		Tecnico t9 = new Tecnico(null, "Nilo Paiva Assis Prata", "358.558.652-07", "(37) 99988-7766");
		Tecnico t10 = new Tecnico(null, "Nathan Frossard Calixto Ervano", "322.420.948-82", "(37) 99988-7766");
		Tecnico t11 = new Tecnico(null, "Jhonathan Silva Bonimo Amancio", "833.784.681-06", "(37) 99988-7766");
		Tecnico t12 = new Tecnico(null, "Geneval Alves Nogueira Livramento", "286.634.124-44", "(37) 99988-7766");
		Tecnico t13 = new Tecnico(null, "Araci Matos Werling Lyrio", "248.931.435-14", "(37) 99988-7766");
		
		Cliente c1 = new Cliente(null, "Laisa Cunha Negris Filho", "035.417.787-76", "(38) 98264-8705");
		Cliente c2 = new Cliente(null, "Matheus Rocha Andrade Antonio", "472.153.105-23", "(38) 98264-8705");
		Cliente c3 = new Cliente(null, "Sedenir Furtado Sampaio Leite", "480.407.645-05", "(38) 98264-8705");
		Cliente c4 = new Cliente(null, "Noah Bonimo Paulo Couto", "348.889.384-74", "(38) 98264-8705");
		Cliente c5 = new Cliente(null, "Luciana Vabo Velasco Mata", "067.764.021-83", "(38) 98264-8705");
		Cliente c6 = new Cliente(null, "Kaique Trindade Elias Carminatti", "322.298.041-11", "(38) 98264-8705");
		Cliente c7 = new Cliente(null, "Maria Cristina Gouveia Rios Nespoli", "319.610.660-84", "(38) 98264-8705");
		Cliente c8 = new Cliente(null, "Eliana de Carvalho Valente Guimarães", "477.853.805-62", "(38) 98264-8705");
		Cliente c9 = new Cliente(null, "Lucimberto Navega Sena Frossard", "571.226.205-30", "(38) 98264-8705");
		Cliente c10 = new Cliente(null, "Pedro Henrique Manhães Carminatti Moura", "964.551.962-44", "(38) 98264-8705");
		Cliente c11 = new Cliente(null, "Ian Vogas de Barros Bocafoli", "298.735.358-88", "(38) 98264-8705");
		
		
		OrdemServico os1 = new OrdemServico(null, Prioridade.ALTA, "teste create Os", Status.ANDAMENTO, t1, c1);
		OrdemServico os2 = new OrdemServico(null, Prioridade.BAIXA, "teste create Os", Status.ABERTO, t2, c2);
		OrdemServico os3 = new OrdemServico(null, Prioridade.BAIXA, "teste create Os", Status.ABERTO, t3, c3);
		OrdemServico os4 = new OrdemServico(null, Prioridade.ALTA, "teste create Os", Status.ABERTO, t4, c4);
		OrdemServico os5 = new OrdemServico(null, Prioridade.MEDIA, "teste create Os", Status.ANDAMENTO, t5, c5);
		OrdemServico os6 = new OrdemServico(null, Prioridade.MEDIA, "teste create Os", Status.ANDAMENTO, t6, c6);
		OrdemServico os7 = new OrdemServico(null, Prioridade.ALTA, "teste create Os", Status.ABERTO, t7, c7);
		OrdemServico os8 = new OrdemServico(null, Prioridade.BAIXA, "teste create Os", Status.ANDAMENTO, t8, c8);
		OrdemServico os9 = new OrdemServico(null, Prioridade.ALTA, "teste create Os", Status.ABERTO, t9, c9);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13));
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11));
		ordemServicoRepository.saveAll(Arrays.asList(os1,os2,os3,os4,os5,os6,os7,os8,os9));
	}

}
