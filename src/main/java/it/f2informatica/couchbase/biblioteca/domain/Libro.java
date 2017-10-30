package it.f2informatica.couchbase.biblioteca.domain;

public class Libro {

	private String titolo;
	private String autore;
	private String isbn;
	private String anno;
	private String editore;
	private String genere;
	private double prezzo;
	private int pagine;
	
	private Libro() {}
	
	public Libro(String titolo, String autore, String isbn, String anno, String editore, String genere, double prezzo,
			int pagine) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.isbn = isbn;
		this.anno = anno;
		this.editore = editore;
		this.genere = genere;
		this.prezzo = prezzo;
		this.pagine = pagine;
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
	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", autore=" + autore + ", isbn=" + isbn + ", anno=" + anno + ", editore="
				+ editore + ", genere=" + genere + ", prezzo=" + prezzo + ", pagine=" + pagine + "]";
	}
	
}
