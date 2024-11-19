package com.tunombre.modelos;


import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name= "canciones")
public class Canciones {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


private String titulo;


@ManyToOne
@JoinColumn(name= "id_artista")
private Artista artista;


private String album;


private String genero;


private String idioma;

@Column(updatable = false)
@Temporal(TemporalType.TIMESTAMP)
private LocalDateTime fecha_creacion;

@Temporal(TemporalType.TIMESTAMP)
private LocalDateTime fecha_actualizacion;

public Canciones(long id,String titulo, Artista artista, String album, String genero,String idioma,LocalDateTime fecha_creacion, LocalDateTime fecha_actualizacion) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.artista = artista;
	this.album = album;
	this.genero = genero;
	this.idioma = idioma;
	this.fecha_creacion = fecha_creacion;
	this.fecha_actualizacion = fecha_actualizacion;
}

public Canciones() {
    super();
    this.id = 0l;
    this.titulo = "";
    this.artista = new Artista();
    this.album = "";
    this.genero = "";
    this.idioma = "";
    this.fecha_creacion = LocalDateTime.now();
    this.fecha_actualizacion = LocalDateTime.now();
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public Artista getArtista() {
	return artista;
}

public void setArtista(Artista artista) {
	this.artista = artista;
}

public String getAlbum() {
	return album;
}

public void setAlbum(String album) {
	this.album = album;
}

public String getGenero() {
	return genero;
}

public void setGenero(String genero) {
	this.genero = genero;
}

public String getIdioma() {
	return idioma;
}

public void setIdioma(String idioma) {
	this.idioma = idioma;
}

public LocalDateTime getFecha_creacion() {
	return fecha_creacion;
}

public void setFecha_creacion(LocalDateTime fecha_creacion) {
	this.fecha_creacion = fecha_creacion;
}

public LocalDateTime getFecha_actualizacion() {
	return fecha_actualizacion;
}

public void setFecha_actualizacion(LocalDateTime fecha_actualizacion) {
	this.fecha_actualizacion = fecha_actualizacion;
}

@PrePersist
private void onCreate() {
    this.fecha_actualizacion = LocalDateTime.now();
    this.fecha_creacion = LocalDateTime.now();
}
@ PreUpdate
private void onUpdate() {
	this.fecha_actualizacion = LocalDateTime.now();
	
}

@Override
public String toString() {
	return "Canciones [id=" + id + ", titulo=" + titulo + ", artista=" + artista + ", album=" + album + ", genero="
			+ genero + ", idioma=" + idioma + ", fecha_creacion=" + fecha_creacion + ", fecha_actualizacion="
			+ fecha_actualizacion + "]";
}

}


