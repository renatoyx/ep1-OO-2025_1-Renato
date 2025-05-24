import java.util.ArrayList;
import java.util.List;

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


    @Override
    public String toString() {
        return nome + " - " + matricula + " - " + curso;
    }

    List<Disciplina> disciplinasMatriculadas = new ArrayList<>();

    public void matricularEmDisciplina(Disciplina disciplina) {
        if (disciplinasMatriculadas.contains(disciplina)) {
            System.out.println("Aluno já está matriculado nessa disciplina.");
            return;
        }

        disciplinasMatriculadas.add(disciplina);
        System.out.println("Aluno matriculado na disciplina: " + disciplina.getNome());
    }


}
