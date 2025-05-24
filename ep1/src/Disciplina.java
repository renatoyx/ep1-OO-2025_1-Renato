public class Disciplina {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Disciplina(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }
    public Disciplina() {

    }

    public String getNome() {
        return nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return nome + " - " + codigo + " - " + cargaHoraria + "h";
    }
}
