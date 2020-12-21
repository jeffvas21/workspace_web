package br.com.jeffcorp.dashcard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jeffcorp.dashcard.dao.AgenteFinanceiroDAO;
import br.com.jeffcorp.dashcard.model.AgenteFinanceiro;

@RestController
@CrossOrigin("*")
public class AgenteFinanceiroController {

	@Autowired
	AgenteFinanceiroDAO dao;

	@GetMapping("/agentes")
	public ArrayList<AgenteFinanceiro> recuperarTodos() {
		ArrayList<AgenteFinanceiro> lista;
		lista = dao.findAllByOrderByVolumeDesc();
		return lista;
	}
	
}
