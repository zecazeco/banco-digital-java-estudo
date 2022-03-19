import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String escolha = "";
		boolean exit = false;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("===============================================");
		System.out.println("=== Bem Vindo ao Sistema de Bancos Digitais ===");
		System.out.println("===============================================");
		
		System.out.println("=== Cadastro do Banco ===");
		System.out.print("Digite um nome para o banco: ");
		escolha = entrada.nextLine();
	
		Banco banco1 = new Banco();
		banco1.setNome(escolha);
		
		System.out.println("Cadastro do banco realizado com sucesso: " + banco1.getNome());

		try {
			do {
				System.out.println("================================================");
				System.out.println("O que você gostaria de fazer agora?");
				System.out.println("0 - Sair");
				System.out.println("1 - Cadastrar cliente");
				System.out.println("2 - Listar clientes do banco");
				System.out.println("3 - Informações do banco");
				System.out.println("4 - Listar contas do banco");				
				System.out.println("5 - Transferencia entre contas");
				System.out.println("6 - Depositar em uma conta");
				System.out.println("7 - Sacar de uma conta");
				System.out.println("8 - Extrato de uma conta");

				escolha = entrada.nextLine();
				switch (escolha) {
					case "0":
						System.out.println("================================================");
						System.out.println("=== Sistema encerrado ===");
						System.out.println("=== Obrigado pela visita ===");
						System.out.println("================================================");
						exit = true;
						break;
					case "1":
						System.out.println("================================================");
						System.out.println("=== Cadastro de Clientes ===");
						System.out.print("Digite um nome para o cliente: ");
						escolha = entrada.nextLine();
					
						Cliente cliente1 = new Cliente();
						cliente1.setNome(escolha);
						
						Conta cc1 = new ContaCorrente(cliente1);
						Conta cp1 = new ContaPoupanca(cliente1);
						banco1.setConta(cc1);
						banco1.setConta(cp1);
						banco1.setCliente(cliente1);
						
						System.out.println("Cadastro do cliente realizado com sucesso: " + cliente1.getNome());
						
						cc1.imprimirExtrato();
						cp1.imprimirExtrato();	
						
						System.out.println("================================================");
						break;
					case "2":
						System.out.println("================================================");
						System.out.println("=== Lista de clientes do banco ===");
						banco1.imprimirClientes();
						System.out.println("================================================");
						break;
					case "3":
						System.out.println("================================================");
						System.out.println("=== Informaçoes do banco ===");
						System.out.println("Nome: " + banco1.getNome());
						System.out.println("================================================");
						break;
					case "4":
						System.out.println("================================================");
						System.out.println("=== Lista de contas do banco ===");
						banco1.imprimirContas();
						System.out.println("================================================");
						break;
					case "5":
						System.out.println("================================================");
						System.out.println("=== Transferencia entre contas ===");
						System.out.println("Conta de origem (numero):");
						int idxOrigem = Integer.parseInt(entrada.nextLine()) - 1;
						System.out.println("Conta de destino (numero):");
						int idxDestino = Integer.parseInt(entrada.nextLine()) - 1;
						System.out.println("Valor:");
						double valorTransferencia = Double.parseDouble(entrada.nextLine());
						
						List<Conta> contas = banco1.getContas();
						Conta contaOrigem = contas.get(idxOrigem);
						Conta contaDestino = contas.get(idxDestino);
						contaOrigem.transferir(valorTransferencia, contaDestino);
						
						contaOrigem.imprimirInfosComuns();
						contaDestino.imprimirInfosComuns();
						System.out.println("================================================");
						break;
					case "6":
						System.out.println("================================================");
						System.out.println("=== Depositar em uma conta ===");
						System.out.println("Conta para deposito (numero):");
						int idxContaDeposito = Integer.parseInt(entrada.nextLine()) - 1;
						System.out.println("Valor:");
						double valorDeposito = Double.parseDouble(entrada.nextLine());	
						Conta contaDeposito = banco1.getContas().get(idxContaDeposito);	
						contaDeposito.depositar(valorDeposito);
						contaDeposito.imprimirInfosComuns();
						System.out.println("================================================");
						break;
					case "7":
						System.out.println("================================================");
						System.out.println("=== Sacar de uma conta ===");
						System.out.println("Conta para saque (numero):");
						int idxContaSaque = Integer.parseInt(entrada.nextLine()) - 1;
						System.out.println("Valor:");
						double valorSaque = Double.parseDouble(entrada.nextLine());	
						Conta contaSaque = banco1.getContas().get(idxContaSaque);	
						contaSaque.sacar(valorSaque);
						contaSaque.imprimirInfosComuns();
						System.out.println("================================================");
						break;
					case "8":
						System.out.println("================================================");
						System.out.println("=== Extrato de uma conta ===");
						System.out.println("Conta para saque (numero):");
						int idxContaExtrato = Integer.parseInt(entrada.nextLine()) - 1;
						Conta contaExtrato = banco1.getContas().get(idxContaExtrato);	
						contaExtrato.imprimirInfosComuns();
						System.out.println("================================================");
						break;
					default:
						break;				
				}
			} while(!exit);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			entrada.close();
			
		}

	}

}
