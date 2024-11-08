package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		//Teste da Classe conta
		Conta c1 = new Conta(1,123,1,"Adriana",10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		Scanner sc = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*******************************************************");
			System.out.println("                                                       ");
			System.out.println("                BANCO DO BRAZIL COM Z                  ");
			System.out.println("                                                       ");
			System.out.println("*******************************************************");
			System.out.println("                                                       ");
			System.out.println("          1 - Criar Conta                              ");
			System.out.println("          2 - Listar todas as Contas                   ");
			System.out.println("          3 - Buscar Conta por Número                  ");
			System.out.println("          4 - Atualizar Dados da Conta                 ");
			System.out.println("          5 - Apagar Conta                             ");
			System.out.println("          6 - Sacar                                    ");
			System.out.println("          7 - Depositar                                ");
			System.out.println("          8 - Transferir valores entre Contas          ");
			System.out.println("          9 - Sair                                     ");
			System.out.println("                                                       ");
			System.out.println("*******************************************************");
			System.out.println("Entre com a opção desejada:                            ");
			System.out.println("                                                       " + Cores.TEXT_RESET);

			opcao = sc.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				sc.close();
				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta \n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas \n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da conta - por número \n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta \n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta \n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque \n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito \n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas \n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida!\n" + Cores.TEXT_RESET);
				break;

			}

		}

	}
	public static void sobre() {
		System.out.println("\n*******************************************************");
		System.out.println("Projeto Desenvolvido por: Caique Gomes");
		System.out.println("Contato - cttcaiquegomes@gmail.com");
		System.out.println("GitHub  - https://github.com/Caiqe");
	}
}
