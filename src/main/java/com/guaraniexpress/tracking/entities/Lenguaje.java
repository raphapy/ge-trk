package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lenguaje database table.
 * 
 */
@Entity
@Table(name="lenguaje")
@NamedQuery(name="Lenguaje.findAll", query="SELECT l FROM Lenguaje l")
public class Lenguaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lenguaje")
	private int idLenguaje;

	private String codigo;

	private String nombre;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="lenguajeBean")
	private List<Usuario> usuarios;

	public Lenguaje() {
	}

	public int getIdLenguaje() {
		return this.idLenguaje;
	}

	public void setIdLenguaje(int idLenguaje) {
		this.idLenguaje = idLenguaje;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setLenguajeBean(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setLenguajeBean(null);

		return usuario;
	}

}