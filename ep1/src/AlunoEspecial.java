public class AlunoEspecial extends Aluno {

    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public boolean podeReceberNota() {
        return false;
    }

    @Override
    public String toString() {
        return getNome() + " (Especial) - " + getMatricula() + " - " + getCurso();
    }
}
