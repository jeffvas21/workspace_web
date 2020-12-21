package br.com.jeffcorp.dashcard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* nesta classe, vamos criar uma estrutura "equivalente" à estrutura
 * da tabela, porém com as nossas nomenclaturas e nosso estilo de escrita
 * 
 * o segredo, agora, é fazer esse "de-para" da nossa classe para a tabela
 */

@Entity // quando usamos @Entity indicamos que a classe é armazenável em BD
@Table(name = "tbl_usuario") // a anotacao @Table permite especificar o nome da tabela
public class Usuario {
	@Id // indica que é chave-primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id;

	@Column(name = "nome_usuario", length = 100, nullable = false)
	private String nome;

	@Column(name = "email_usuario", length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(name = "racf_usuario", length = 7, nullable = false, unique = true) 
	private String racf;

    @Column(name = "senha_usuario", length = 50, nullable = false)
	private String senha;

    @Column(name = "link_foto", length = 255)
	private String linkFoto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
    
}