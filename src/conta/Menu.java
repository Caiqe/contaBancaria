package conta;

import java.util.Scanner;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		// Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Mariana", 15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();

		// Teste da Conta Poupanca
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Victor", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

		Scanner sc = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ " _________________________________________________________ ");
			System.out.println("|                                                         |");
			System.out.println("|                  AQUELE BANCO ROXINHO                   |");
			System.out.println("|                                                         |");
			System.out.println("|=========================================================|" + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "|                                                         |");
			System.out.println("|        [1]  -  Criar Conta                              |");
			System.out.println("|        [2]  -  Listar todas as Contas                   |");
			System.out.println("|        [3]  -  Buscar Conta por Número                  |");
			System.out.println("|        [4]  -  Atualizar Dados da Conta                 |");
			System.out.println("|        [5]  -  Apagar Conta                             |");
			System.out.println("|        [6]  -  Sacar                                    |");
			System.out.println("|        [7]  -  Depositar                                |");
			System.out.println("|        [8]  -  Transferir valores entre Contas          |");
			System.out.println("|        [0]  -  Sair                                     |");
			System.out.println("|                                                         |");
			System.out.println("|_________________________________________________________|");
			System.out.println(" Entre com a opção desejada:                               ");
			System.out.println("                                                           " + Cores.TEXT_RESET);

			opcao = sc.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND 
						+ "                                                  ");
				System.out.println(" AQUELE BANCO ROXINHO - O seu Futuro começa aqui! ");
				sobre();
				sc.close();
				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Criar Conta \n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Listar todas as Contas \n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Consultar dados da conta - por número \n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Atualizar dados da Conta \n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Apagar a Conta \n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Saque \n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Depósito \n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Transferência entre Contas \n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Opção inválida!\n" + Cores.TEXT_RESET);
				break;

			}

		}

	}

	public static void sobre() {
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "   ________________________________________       ");
		System.out.println("  | Projeto Desenvolvido por: Caique Gomes |      ");
		System.out.println("  | Contato - cttcaiquegomes@gmail.com     |      ");
		System.out.println("  | GitHub  - https://github.com/Caiqe     |      ");
		System.out.println("  |________________________________________|      ");
		System.out.println("                                                  ");
	}
}
