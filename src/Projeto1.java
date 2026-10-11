import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Projeto1 {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n---------- MENU ----------");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar professor");
            System.out.println("3 - Listar pessoas");
            System.out.println("4 - Buscar por nome");
            System.out.println("0 - sair");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {

                    System.out.println("\n--- Cadastro de aluno ---");

                    System.out.println("Nome: ");
                    String nomeAluno = scanner.nextLine();

                    String cpfAluno = ValidadorUtil.lerCpf(scanner);
                    LocalDate dataNascimentoAluno =
                            ValidadorUtil.lerDataNascimento(scanner);
                    String matricula = ValidadorUtil.lerMatricula(scanner);

                    System.out.println("Nota 1: ");
                    double nota1 = scanner.nextDouble();

                    System.out.println("Nota 2: ");
                    double nota2 = scanner.nextDouble();

                    System.out.println("Nota 3: ");
                    double nota3 = scanner.nextDouble();

                    scanner.nextLine();

                    double[] notas = {nota1, nota2, nota3};

                    Aluno aluno = new Aluno(
                            nomeAluno,
                            cpfAluno,
                            dataNascimentoAluno,
                            matricula,
                            notas
                    );

                    pessoas.add(aluno);

                    System.out.println("Aluno cadastrado com sucesso.");
                    break;
                }

                case 2: {

                    System.out.println("\n--- Cadastro de professor ---");

                    System.out.println("Nome: ");
                    String nomeProfessor = scanner.nextLine();

                    String cpfProfessor = ValidadorUtil.lerCpf(scanner);
                    LocalDate dataNascimentoProfessor =
                            ValidadorUtil.lerDataNascimento(scanner);

                    System.out.println("Disciplina: ");
                    String disciplina = scanner.nextLine();

                    System.out.println("Titulação: ");
                    String titulacao = scanner.nextLine();

                    Professor professor = new Professor(
                            nomeProfessor,
                            cpfProfessor,
                            dataNascimentoProfessor,
                            disciplina,
                            titulacao
                    );

                    pessoas.add(professor);

                    System.out.println("Professor cadastrado com sucesso.");
                    break;
                }

                case 3:
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        System.out.println("\nPessoas cadastradas:");

                        for (Pessoa pessoa : pessoas) {
                            pessoa.exibirDados();
                            System.out.println("--------------------------");
                        }
                    }
                    break;

                case 4: {
                    System.out.println("Digite o nome para buscar: ");
                    String nomeBusca = scanner.nextLine();

                    boolean encontrado = false;

                    for (Pessoa pessoa : pessoas) {
                        String nomeCompleto = pessoa.getNome().trim();
                        String nomeBuscaFormatado = nomeBusca.trim();

                        String[] partesNome = nomeCompleto.split("\\s+");

                        if (partesNome.length > 0 && partesNome[0].equalsIgnoreCase(nomeBuscaFormatado)) {

                            System.out.println("Pessoa encontrada:");
                            pessoa.exibirDados();
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Nenhuma pessoa encontrada com esse nome.");
                    }
                    break;
                }

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

}
