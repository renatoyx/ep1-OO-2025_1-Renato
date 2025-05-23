public class Aluno {
    private String nome;
    private String matricula;
    private String curso;

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public Aluno() {

    }

    public boolean podeReceberNota() {
        return true;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return nome + " - " + matricula + " - " + curso;
    }
}
