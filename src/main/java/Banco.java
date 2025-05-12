import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Cliente> clientes = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente autenticar(String cpf, String senha) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf) && c.getSenha().equals(senha)) {
                System.out.println("Autenticação bem-sucedida!");
                return c;
            }
        }
        return null;
    }

    public Cliente buscarConta(String cpf){
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
