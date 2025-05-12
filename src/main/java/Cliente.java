public class Cliente {
    private String nome;
    private String cpf;
    private String senha;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    public Cliente(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;

        this.contaCorrente = new ContaCorrente(this);
        this.contaPoupanca = new ContaPoupanca(this);
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
}
