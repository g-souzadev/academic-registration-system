public class Aluno extends Pessoa{
    private String matricula;
    private double[] notas;

    public Aluno(){
        super();
    }

    public Aluno(String nome, String cpf, String dataNascimento,
                 String matricula, double[] notas){
        super(nome, cpf, dataNascimento);
        this.matricula = matricula;
        this.notas = notas;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public double[] getNotas(){
        return notas;
    }

    public void setNotas(double[] notas){
        this.notas = notas;
    }
}