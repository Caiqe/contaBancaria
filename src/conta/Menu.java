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

		int opcao,numero,agencia,tipo,aniversario;
		String titular;
		float saldo, limite;

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

			try {
			opcao = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nDigite valores inteiros!" + Cores.TEXT_RESET);
				sc.nextLine();
				opcao=9;
			}
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
				System.out.println("Digite o número da agência: ");
				agencia = sc.nextInt();
				System.out.println("Digite o nome do Titular");
				sc.skip("\\R?");
				titular = sc.nextLine();
				
				do {
					System.out.println("Digite o tipo da conta (1-CC ou 2-CP): ");
					tipo = sc.nextInt();
				}while(tipo<1 && tipo>2);
				
				System.out.println("Digite o saldo da conta (R$): ");
				saldo = sc.nextFloat();
				
				switch(tipo) {
				case 1 ->{
					System.out.println("Digite o limete de Crédito (R$): ");
					limite = sc.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo,titular,saldo,limite));
					
				}
				case 2->{
					System.out.println("Digite o dia do Aniversário da conta: ");
					aniversario = sc.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia,tipo,titular,saldo,aniversario));
				}
					
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Listar todas as Contas \n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Consultar dados da conta - por número \n\n");
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Atualizar dados da Conta \n\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Apagar a Conta \n\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Saque \n\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Depósito \n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Transferência entre Contas \n\n");
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
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			System.in.read();
		}catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
