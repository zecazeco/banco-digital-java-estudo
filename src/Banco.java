import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas = new ArrayList<Conta>();
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setConta(Conta conta) {
		this.contas.add(conta);
	}	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void imprimirContas() {
		for (int i = 0; i < this.contas.size(); i++) {
			System.out.println(
					this.contas.get(i).getNumero()
					+ " - "
					+ this.contas.get(i).cliente.getNome()
					+ " - "
					+ this.contas.get(i).getTipo()
			);
		}
	}
	
	public void imprimirClientes() {
		for (int i = 0; i < this.clientes.size(); i++) {
			System.out.println(this.clientes.get(i).getNome());
		}
	}	
}
