import entidades.PlanoFunerario;
import repositorios.RepositorioPlanoFunerario;
import servicos.ServicoPlanoFunerario;
import interfaces.IRepositorio;
import interfaces.IServico;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IRepositorio repositorio = new RepositorioPlanoFunerario();
        IServico servico = new ServicoPlanoFunerario(repositorio);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Cadastro de Planos Funerários ---");
            System.out.println("1. Cadastrar Plano");
            System.out.println("2. Listar Planos");
            System.out.println("3. Atualizar Plano");
            System.out.println("4. Remover Último Plano");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Titular: ");
                    String titular = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Plano: ");
                    String plano = scanner.nextLine();
                    
                    servico.cadastrarPlano(new PlanoFunerario(titular, cpf, plano));
                    System.out.println("Plano cadastrado com sucesso!");
                    break;

                case 2:
                    List<PlanoFunerario> planos = servico.listarPlanos();
                    if (planos.isEmpty()) {
                        System.out.println("Nenhum plano cadastrado.");
                    } else {
                        planos.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("CPF do plano a ser atualizado: ");
                    String cpfAntigo = scanner.nextLine();
                    System.out.print("Novo Titular: ");
                    String novoTitular = scanner.nextLine();
                    System.out.print("Novo Plano: ");
                    String novoPlano = scanner.nextLine();
                    
                    PlanoFunerario planoAntigo = new PlanoFunerario("", cpfAntigo, "");
                    PlanoFunerario planoNovo = new PlanoFunerario(novoTitular, cpfAntigo, novoPlano);
                    
                    PlanoFunerario atualizado = servico.atualizarPlano(planoAntigo, planoNovo);
                    if (atualizado != null) {
                        System.out.println("Plano atualizado com sucesso!");
                    } else {
                        System.out.println("CPF não encontrado.");
                    }
                    break;

                case 4:
                    servico.excluirPlano();
                    System.out.println("Último plano removido.");
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

