package conta.model;

public class Conta {
	
	//Atributos = Variávies / private= modificadores de acesso
	
	//Todas as classe de "Conta" terão esses atributos
	
	private int numero; // 0
	private int agencia; // 1
	private int tipo; // 1
	private String titular; // João
	private float saldo; // 50f
	
	//Método especial - método construtor
	
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		
		
		//this => Classe Conta 
		//Conta.numero = atributo da classe
		//referesse ao atributo
		//numero = 6
		//this.numero = 6
		// Conta.numero = this.numero;
		
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	// Comportamentos/Métodos
	//Métodos de Acesso
	
	// Get -> Pegar
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular() {
		this.titular = titular;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
}
