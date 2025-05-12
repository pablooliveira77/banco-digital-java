import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Digital");
        Cliente cliente1 = new Cliente("João", "12345678900", "senha123");
        Cliente cliente2 = new Cliente("Maria", "98765432100", "senha456");

        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o CPF do cliente:");
            String cpf = scanner.nextLine();
            System.out.println("Digite a senha do cliente:");
            String senha = scanner.nextLine();

            // Autenticação
            Cliente clienteLogado = banco.autenticar(cpf, senha);
            if (clienteLogado != null) {
                System.out.println("Olá: " + clienteLogado.getNome());
                // Conta cc = new ContaCorrente(clienteLogado);
                // Conta cp = new ContaPoupanca(clienteLogado);
                Conta cc = clienteLogado.getContaCorrente();
                Conta cp = clienteLogado.getContaPoupanca();
                cc.depositar(1500); // Valores que venham do banco de dados
                cp.depositar(500); // Valores que venham do banco de dados
                while (true) {
                    System.out.println("Qual serviço deseja acessar: 1 - Conta Corrente, 2 - Conta Poupança, 0 - Sair");
                    int opcao = scanner.nextInt();
                    if (opcao == 0) {
                        System.out.println("Saindo...");
                        break;
                    }
                    switch (opcao) {
                        case 1:
                            System.out.println();
                            cc.imprimirExtrato();
                            executarOperacao(cc, scanner, banco);
                            break;
                        case 2:
                            System.out.println();
                            cp.imprimirExtrato();
                            executarOperacao(cp, scanner, banco);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                }
            } else {
                System.out.println("Falha na autenticação.");
            }
        }

    }

    public static void executarOperacao(Conta conta, Scanner scanner, Banco banco) {
        System.out.println("Qual operação deseja realizar: 1 - Depositar, 2 - Sacar, 3 - Transferir");
        int operacao = scanner.nextInt();

        System.out.println("Digite o valor:");
        double valor = scanner.nextDouble();

        switch (operacao) {
            case 1:
                conta.depositar(valor);
                break;
            case 2:
                conta.sacar(valor);
                break;
            case 3:
                System.out.println("Informe o CPF do destinatário:");
                String cpfDestinatario = scanner.next();
                Cliente destinatario = banco.buscarConta(cpfDestinatario);
                if (destinatario != null) {
                    System.out.println(destinatario.getNome());
                    conta.transferir(valor, destinatario.getContaCorrente());
                } else {
                    System.out.println("Destinatário não encontrado.");
                }

            default:
                break;
        }

        System.out.println("Operação realizada com sucesso!");
        conta.imprimirExtrato();

    }
}
