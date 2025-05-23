import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciador {
    List<Aluno> listaAlunos = new ArrayList<>();

    public void cadastrarAluno(Scanner sc) {
        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();
        System.out.println("Digite a matricula do aluno: ");
        String matricula = sc.nextLine();
        System.out.println("Digite o curso do aluno: ");
        String curso = sc.nextLine();

        for (Aluno aluno : listaAlunos) {
            if (aluno.getMatricula().equals(matricula)) {
                System.out.println("Matrícula duplicada.");
                return;
            }
        }

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setMatricula(matricula);
        aluno.setCurso(curso);

        listaAlunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void listarAlunos() {
        System.out.println("Lista de alunos: ");
        for (Aluno aluno : listaAlunos) {
            System.out.println(aluno);
        }
    }
}
