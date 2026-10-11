import java.util.ArrayList;
import java.util.Scanner;

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

                    System.out.println("CPF: ");
                    String cpfAluno = scanner.nextLine();

                    System.out.println("Data de nascimento: ");
                    String dataNascimentoAluno = scanner.nextLine();

                    System.out.println("Matrícula: ");
                    String matricula = scanner.nextLine();

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

                    System.out.println("CPF: ");
                    String cpfProfessor = scanner.nextLine();

                    System.out.println("Data de Nascimento: ");
                    String dataNascimentoProfessor = scanner.nextLine();

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

                        for (Pessoa pessoa : pessoas){
                            System.out.println("Nome: " + pessoa.getNome());
                            System.out.println("CPF: " + pessoa.getCpf());
                            System.out.println("Data de Nascimento: " + pessoa.getDataNascimento());

                            if (pessoa instanceof Aluno){
                                Aluno aluno = (Aluno) pessoa;

                                System.out.println("Tipo: Aluno");
                                System.out.println("Matrícula: " + aluno.getMatricula());
                            } else if (pessoa instanceof Professor) {
                                Professor professor = (Professor) pessoa;

                                System.out.println("Tipo: Professor");
                                System.out.println("Disciplina: " + professor.getDisciplina());
                                System.out.println("Titulacao: " + professor.getTitulacao());
                            }

                            System.out.println("--------------------------");
                        }
                    }
                    break;

                case 4:{
                    System.out.println("Digite o nome para buscar: ");
                    String nomeBusca = scanner.nextLine();

                    boolean encontrado = false;

                    for (Pessoa pessoa : pessoas){
                        if(pessoa.getNome().equalsIgnoreCase(nomeBusca)){
                            System.out.println("Pessoa encontrada:");
                            System.out.println("Nome: " + pessoa.getNome());
                            System.out.println("CPF; " + pessoa.getCpf());
                            System.out.println("Data de nascimento: " + pessoa.getDataNascimento());

                            if (pessoa instanceof Aluno){
                                Aluno aluno = (Aluno) pessoa;
                                System.out.println("Tipo: Aluno");
                                System.out.println("Matrícula: " + aluno.getMatricula());
                            } else if (pessoa instanceof Professor) {
                                Professor professor = (Professor) pessoa;
                                System.out.println("Tipo: Professor");
                                System.out.println("Disciplina: " + professor.getDisciplina());
                                System.out.println("Titulação: " + professor.getTitulacao());
                            }
                            encontrado = true;
                        }
                    }

                    if (!encontrado){
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
