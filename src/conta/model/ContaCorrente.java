package conta.model;

public class ContaCorrente extends Conta { //extends => herança/herda
	
	private float limite;
	
	//sepranado o atributo da variavel
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo); //Invocando o método Construtor Conta
		this.limite = limite; // this => nome da Classe
		
	}
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = 5000.0f;
	}
	// Métodos de Acesso
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
}
