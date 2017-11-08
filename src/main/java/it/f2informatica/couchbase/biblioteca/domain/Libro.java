package it.f2informatica.couchbase.biblioteca.domain;

import java.io.Serializable;


public class Libro implements Serializable {

	private String titolo;
	private String autore;
	private String isbn;
	private String anno;
	private String editore;
	private String genere;
	private double prezzo;
	private int pagine;
	private String type;
	private String copertina;

	public Libro() {

	}

	public Libro(String titolo, String autore, String isbn, String anno, String editore, String genere, double prezzo,
			int pagine, String type, String copertina) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.isbn = isbn;
		this.anno = anno;
		this.editore = editore;
		this.genere = genere;
		this.prezzo = prezzo;
		this.pagine = pagine;
		this.type = type;
		this.copertina = copertina;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}

	public void setType(String tipo) {
		this.type = tipo;
	}

	public String getType() {
		return type;
	}

	public void setCopertina(String immagine) {
		this.copertina = immagine;
	}

	public String getCopertina() {
		return copertina;
	}

	@Override
	public String toString() {
		return "{\"titolo\":\"" + titolo + "\",\"autore\":\"" + autore + "\",\"isbn\":\"" + isbn + "\",\"anno\":\""
				+ anno + "\",\"editore\":\"" + editore + "\",\"genere\":\"" + genere + "\",\"prezzo\":\"" + prezzo
				+ "\",\"pagine\":\"" + pagine + "\",\"type\":\"" + type + "\",\"copertina\":\"" + copertina + "\"}";
	}

}
