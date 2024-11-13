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

		ContaController contas = new ContaController();
		Scanner sc = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		while (true) {

			menu();

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nDigite valores inteiros!" + Cores.TEXT_RESET);
				sc.nextLine();
				opcao = 9;
			}
			if (opcao == 0) {

				sobre();
				sc.close();
				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Criar Conta \n\n"
						+ Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Digite o número da agência: ");
				agencia = sc.nextInt();
				System.out.println("Digite o nome do Titular");
				sc.skip("\\R?");
				titular = sc.nextLine();

				do {
					System.out.println("Digite o tipo da conta (1-CC ou 2-CP): ");
					tipo = sc.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da conta (R$): ");
				saldo = sc.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limete de Crédito (R$): ");
					limite = sc.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));

				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversário da conta: ");
					aniversario = sc.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}

				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
						+ "Listar todas as Contas \n\n" + Cores.TEXT_RESET + Cores.TEXT_WHITE_BOLD_BRIGHT);
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
						+ "Consultar dados da conta - por número \n\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Digite o número da conta: ");
				numero = sc.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
						+ "Atualizar dados da Conta \n\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Digite o número da conta: ");
				numero = sc.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					tipo = buscaConta.getTipo();

					System.out.println("Digite o número da Agência: ");
					agencia = sc.nextInt();
					System.out.println("Digite o nome do titular: ");
					sc.skip("\\R");
					titular = sc.nextLine();

					System.out.println("Digite o saldo da conta (R$): ");
					saldo = sc.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite de Crédito (R$): ");
						limite = sc.nextFloat();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = sc.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválida!");
					}
					}
				} else {
					System.out.println("A conta não foi encontrada!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Apagar a Conta \n\n"
						+ Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Digite o núemro da conta: ");
				numero = sc.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(
						Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Saque \n\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Digite o número da Conta: ");
				numero = sc.nextInt();

				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = sc.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Depósito \n\n"
						+ Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Digite o número da conta: ");
				numero = sc.nextInt();

				do {
					System.out.println("Digite o valor do depósito (R$): ");
					valor = sc.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
						+ "Transferência entre Contas \n\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Digite o número da conta de origem: ");
				numero = sc.nextInt();
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = sc.nextInt();

				do {
					System.out.println("Digite o valor da tranferência: ");
					valor = sc.nextFloat();
				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Opção inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;

			}

		}

	}

	public static void sobre() {
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "                                                  ");
		System.out.println(" AQUELE BANCO ROXINHO - O seu Futuro começa aqui! " + Cores.TEXT_RESET);
		System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "   ________________________________________       ");
		System.out.println("  | Projeto Desenvolvido por: Caique Gomes |      ");
		System.out.println("  | Contato - cttcaiquegomes@gmail.com     |      ");
		System.out.println("  | GitHub  - https://github.com/Caiqe     |      ");
		System.out.println("  |________________________________________|      ");
		System.out.println("                                                  ");
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_YELLOW + "\n\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

	public static void menu() {
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ " _________________________________________________________ ");
		System.out.println("|                                                         |");
		System.out.println("|                  AQUELE BANCO ROXINHO                   |");
		System.out.println("|                                                         |");
		System.out.println("|=========================================================|" + Cores.TEXT_RESET);
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + "|                                                         |");
		System.out.println("|        " + Cores.TEXT_PURPLE_BOLD_BRIGHT + "[1]  -  " + Cores.TEXT_WHITE_BOLD_BRIGHT
				+ "Criar Conta                              |");
		System.out.println("|        " + Cores.TEXT_PURPLE_BOLD_BRIGHT + "[2]  -  " + Cores.TEXT_WHITE_BOLD_BRIGHT
				+ "Listar todas as Contas                   |");
		System.out.println("|        " + Cores.TEXT_PURPLE_BOLD_BRIGHT + "[3]  -  " + Cores.TEXT_WHITE_BOLD_BRIGHT
				+ "Buscar Conta por Número                  |");
		System.out.println("|        " + Cores.TEXT_PURPLE_BOLD_BRIGHT + "[4]  -  " + Cores.TEXT_WHITE_BOLD_BRIGHT
				+ "Atualizar Dados da Conta                 |");
		System.out.println("|        " + Cores.TEXT_PURPLE_BOLD_BRIGHT + "[5]  -  " + Cores.TEXT_WHITE_BOLD_BRIGHT
				+ "Apagar Conta                             |");
		System.out.println("|        " + Cores.TEXT_PURPLE_BOLD_BRIGHT + "[6]  -  " + Cores.TEXT_WHITE_BOLD_BRIGHT
				+ "Sacar                                    |");
		System.out.println("|        " + Cores.TEXT_PURPLE_BOLD_BRIGHT + "[7]  -  " + Cores.TEXT_WHITE_BOLD_BRIGHT
				+ "Depositar                                |");
		System.out.println("|        " + Cores.TEXT_PURPLE_BOLD_BRIGHT + "[8]  -  " + Cores.TEXT_WHITE_BOLD_BRIGHT
				+ "Transferir valores entre Contas          |");
		System.out.println("|        " + Cores.TEXT_RED_BOLD + "[0]  -  Sair" + Cores.TEXT_WHITE_BOLD_BRIGHT
				+ "                                     |");
		System.out.println("|                                                         |");
		System.out.println("|_________________________________________________________|");
		System.out.println(" Entre com a opção desejada:                               ");
		System.out.println("                                                           " + Cores.TEXT_RESET);
	}
}
