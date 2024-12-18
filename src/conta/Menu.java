package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		while (true) {

			System.out.println(Cores.TEXT_ORANGE + Cores.ANSI_WHITE_BACKGROUND
					+ "***************************************************");
			System.out.println("                                                   ");
			System.out.println("              Banco Ytaú com Y                     ");
			System.out.println("                                                   ");
			System.out.println("***************************************************");
			System.out.println("                                                   ");
			System.out.println("         1 - Criar Conta.                          ");
			System.out.println("         2 - Listar todas as Contas.               ");
			System.out.println("         3 - Buscar Conta por Numero.              ");
			System.out.println("         4 - Atualizar Dados da Conta.             ");
			System.out.println("         5 - Apagar Conta.                         ");
			System.out.println("         6 - Sacar.                                ");
			System.out.println("         7 - Depositar.                            ");
			System.out.println("         8 - Tranferir valores entre Contas.       ");
			System.out.println("         9 - Sair.                                 ");
			System.out.println("                                                   ");
			System.out.println("***************************************************");
			System.out.println("Entre com a opção desejada:                        ");
			System.out.println("                                                   " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nYtaú com Y - Feito com você.");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
		        System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

		        System.out.println("Digite o Numero da Agência: ");
		        agencia = leia.nextInt();
		        System.out.println("Digite o Nome do Titular: ");
		        leia.skip("\\R");
		        titular = leia.nextLine();

		        do {
		            System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
		            tipo = leia.nextInt();
		        } while (tipo < 1 && tipo > 2);

		        System.out.println("Digite o Saldo da Conta (R$): ");
		        saldo = leia.nextFloat();

		        switch (tipo) {
		            case 1 -> {
		                System.out.println("Digite o Limite de Crédito (R$): ");
		                limite = leia.nextFloat();
		                contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
		            }
		            case 2 -> {
		                System.out.println("Digite o Dia do Aniversario da Conta: ");
		                aniversario = leia.nextInt();
		                contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		            }
		        }

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas \n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dado da Conta - por número \n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dado da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta !=null) {
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o número da agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					System.out.println("Digite o saldo da conta (R$): ");
					saldo = leia.nextFloat();
					
					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de crédito (R$): ");
						limite = leia.nextFloat();
						
					contas.atualizar(new ContaCorrente(numero,agencia,tipo,titular,saldo,limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = leia.nextInt();
						
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido");
					}
				}
				}else {
					System.out.println("A conta não foi encontrada!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = leia.nextFloat();
				}while(valor <- 0);
				
				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do depósito (R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				
				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
				
				System.out.println("Digite o número da conta de origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o valor da transferência (R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}

	}

		public static void sobre() {
			System.out.println("\n**********************************************************");
			System.out.println("Projeto Desenvolvido por: Rebeka Lima");
			System.out.println("Generation Brasil - rebekas@genstudents.org");
			System.out.println("https://github.com/RebekaLima");
			System.out.println("**********************************************************");
	}

		public static void keyPress() {

			try {

				System.out.println(Cores.TEXT_RESET + "\n\nPressione 'Enter' para Continuar...");
				System.in.read();

			} catch (IOException e) {

				System.out.println("Você pressionou uma tecla diferente de 'Enter'!");

		}

	}
}
