import java.time.LocalDate;

public class Professor extends Pessoa{
    private String disciplina;
    private String titulacao;

    public Professor(){
        super();
    }

    public Professor(String nome, String cpf, LocalDate dataNascimento,
                     String disciplina, String titulacao){
        super(nome, cpf, dataNascimento);
        this.disciplina = disciplina;
        this.titulacao = titulacao;
    }

    public String getDisciplina(){
        return disciplina;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }

    public String getTitulacao(){
        return titulacao;
    }

    public void setTitulacao(String titulacao){
        this.titulacao = titulacao;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo: Professor");
        System.out.println("Disciplina: " + disciplina);
        System.out.println("Titulação: " + titulacao);
    }
}
