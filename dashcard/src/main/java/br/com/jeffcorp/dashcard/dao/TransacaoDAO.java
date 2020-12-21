package br.com.jeffcorp.dashcard.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.jeffcorp.dashcard.dto.ConsolidadoStatus;
import br.com.jeffcorp.dashcard.model.AgenteFinanceiro;
import br.com.jeffcorp.dashcard.model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer>{
	
	public ArrayList<Transacao> findAllByAgente(AgenteFinanceiro agente);
	
	@Query("SELECT new br.com.jeffcorp.dashcard.dto.ConsolidadoStatus(t.agente.nome, t.agente.volume, t.status, count(t.status))"
			+ " FROM Transacao t WHERE t.agente.id=:idAgente GROUP BY t.status")
	public ArrayList<ConsolidadoStatus> recuperarStatus(@Param("idAgente") int idAgente);

    public ArrayList<Transacao> findAllByStatus(Transacao status);
	@Query("SELECT new br.com.jeffcorp.dashcard.dto.ConsolidadoStatus(t.agente.nome, t.agente.volume, t.status, count(t.status))"
			+ " FROM Transacao t WHERE t.status.status=:idStatus GROUP BY t.agente.nome")
	public ArrayList<ConsolidadoStatus> listarStatus(@Param("idStatus") int idStatus);

	
}