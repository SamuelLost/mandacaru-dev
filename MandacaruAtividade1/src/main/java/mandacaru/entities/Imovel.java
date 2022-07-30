package mandacaru.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Samuel Henrique - samuelhenriqec@alu.ufc.br
 * 
 * Classe para representar o Imóvel
 */
@Entity(name = "imoveis")
public class Imovel {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "endereco")
	private String endereco;
	@Column(name = "bairro")
	private String bairro;
	@Column(name = "numero")
	private int numero;
	@Column(name = "metrosQuadrados")
	private double metrosQuadrados;
	@Column(name = "metrosConstruidos")
	private double metrosConstruidos;
	@Column(name = "quartos")
	private int quartos;
	@Column(name = "banheiros")
	private int banheiros;
	@Column(name = "garagem")
	private int garagem;
	@Column(name = "preco")
	private double preco;
	
	public Imovel() {
		super();
	}

	public Imovel(int id, String titulo, String endereco, String bairro, int numero, double metrosQuadrados,
			double metrosConstruidos, int quartos, int banheiros, int garagem, double preco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.endereco = endereco;
		this.bairro = bairro;
		this.numero = numero;
		this.metrosQuadrados = metrosQuadrados;
		this.metrosConstruidos = metrosConstruidos;
		this.quartos = quartos;
		this.banheiros = banheiros;
		this.garagem = garagem;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getMetrosQuadrados() {
		return metrosQuadrados;
	}

	public void setMetrosQuadrados(double metrosQuadrados) {
		this.metrosQuadrados = metrosQuadrados;
	}

	public double getMetrosConstruidos() {
		return metrosConstruidos;
	}

	public void setMetrosConstruidos(double metrosConstruidos) {
		this.metrosConstruidos = metrosConstruidos;
	}

	public int getQuartos() {
		return quartos;
	}

	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

	public int getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(int banheiros) {
		this.banheiros = banheiros;
	}

	public int getGaragem() {
		return garagem;
	}

	public void setGaragem(int garagem) {
		this.garagem = garagem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
