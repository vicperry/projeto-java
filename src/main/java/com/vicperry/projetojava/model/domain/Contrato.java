package com.vicperry.projetojava.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TContrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricaoEvento;
	private String dataEvento;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name= "idContratante")
	private Contratante contratante;
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idArtista")
	private List<Artista> artistas;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	public Contrato() {
	}

	public Contrato(Integer id, String descricaoEvento, String dataEvento, Contratante contratante,
			List<Artista> artistas, Usuario usuario) {
		this.id = id;
		this.descricaoEvento = descricaoEvento;
		this.dataEvento = dataEvento;
		this.contratante = contratante;
		this.artistas = artistas;
		this.usuario = usuario;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricaoEvento() {
		return descricaoEvento;
	}
	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}
	public String getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}
	public Contratante getContratante() {
		return contratante;
	}
	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}
	public List<Artista> getArtistas() {
		return artistas;
	}
	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Contrato [id=");
	    sb.append(id);
	    sb.append(", descricaoEvento=");
	    sb.append(descricaoEvento);
	    sb.append(", dataEvento=");
	    sb.append(dataEvento);
	    sb.append(", contratante=");
	    sb.append(contratante);
	    sb.append(", artistas=");
	    sb.append(artistas);
	    sb.append(", usuario=");
	    sb.append(usuario);
	    sb.append("]");
	    return sb.toString();
	}	

}
