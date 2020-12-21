package br.com.jeffcorp.dashcard.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.jeffcorp.dashcard.model.AgenteFinanceiro;

public interface AgenteFinanceiroDAO extends CrudRepository<AgenteFinanceiro, Integer> {
	public ArrayList<AgenteFinanceiro> findAllByOrderByVolumeDesc();
}
	

