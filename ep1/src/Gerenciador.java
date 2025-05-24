import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Gerenciador {
    List<Aluno> listaAlunos = new ArrayList<>();
    List<Disciplina> listaDisciplinas = new ArrayList<>();

    public void cadastrarAluno(Scanner sc) {
        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();
        System.out.println("Digite a matricula do aluno: ");
        String matricula = sc.nextLine();

        for (Aluno aluno : listaAlunos) {
            if (aluno.getMatricula().equals(matricula)) {
                System.out.println("Matrícula duplicada.");
                return;
            }
        }

        System.out.println("Digite o curso do aluno: ");
        String curso = sc.nextLine();

        System.out.println("O aluno é especial? (s/n): ");
        String resposta = sc.nextLine();

        Aluno aluno;

        if (resposta.equals("s")) {
            aluno = new AlunoEspecial(nome, matricula, curso);
        } else {
            aluno = new Aluno(nome, matricula, curso);
        }

        listaAlunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void listarAlunos() {

        System.out.println("\n--- Lista de Alunos ---");
        for (Aluno aluno : listaAlunos) {
            if (aluno instanceof AlunoEspecial) {
                System.out.println(aluno + " - Aluno Especial");
            } else {
                System.out.println(aluno + " - Aluno Normal");
            }
        }
    }

    public void cadastrarDisciplina(Scanner sc) {
        System.out.println("Digite o nome da disciplina: ");
        String nome = sc.nextLine();
        System.out.println("Digite o código da disciplina: ");
        String codigo = sc.nextLine();
        System.out.println("Digite a carga horária: ");
        int carga = sc.nextInt(); sc.nextLine();

        Disciplina disciplina = new Disciplina(nome, codigo, carga);
        listaDisciplinas.add(disciplina);
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    public void matricularAlunoEmDisciplina(Scanner sc) {
        System.out.println("Digite a matrícula do aluno: ");
        String matricula = sc.nextLine();

        Aluno aluno = null;

        for (Aluno a : listaAlunos) {
            if (a.getMatricula().equals(matricula)) {
                aluno = a;
                break;
            }
        }

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Lista de disciplinas:");
        for (int i = 0; i < listaDisciplinas.size(); i++) {
            System.out.println((i + 1) + ". " + listaDisciplinas.get(i));
        }

        System.out.println("Escolha o número da disciplina para matrícula: ");
        int opcao = sc.nextInt(); sc.nextLine();

        if (opcao < 1 || opcao > listaDisciplinas.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Disciplina disciplinaSelecionada = listaDisciplinas.get(opcao - 1);
        aluno.matricularEmDisciplina(disciplinaSelecionada);
    }

    public void listarDisciplinas() {
        if (listaDisciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        System.out.println("\n--- Lista de Disciplinas ---");
        for (Disciplina disciplina : listaDisciplinas) {
            System.out.println(disciplina);
        }
    }

    public void salvarAlunos() {
        try (FileWriter writer = new FileWriter("alunos.csv")) {
            for (Aluno aluno : listaAlunos) {
                String tipo = (aluno instanceof AlunoEspecial) ? "Especial" : "Normal";
                writer.append(aluno.getNome()).append(",");
                writer.append(aluno.getMatricula()).append(",");
                writer.append(aluno.getCurso()).append(",");
                writer.append(tipo).append("\n");
            }
            System.out.println("Alunos salvos com sucesso em alunos.csv!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar alunos: " + e.getMessage());
        }
    }


    public void carregarAlunos() {
        listaAlunos.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("alunos.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                String matricula = partes[1];
                String curso = partes[2];
                String tipo = partes[3];

                Aluno aluno;
                if (tipo.equalsIgnoreCase("Especial")) {
                    aluno = new AlunoEspecial(nome, matricula, curso);
                } else {
                    aluno = new Aluno(nome, matricula, curso);
                }

                listaAlunos.add(aluno);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar alunos: " + e.getMessage());
        }
    }

    public void salvarDisciplinas() {
        try (FileWriter writer = new FileWriter("disciplinas.csv")) {
            for (Disciplina disciplina : listaDisciplinas) {
                writer.append(disciplina.getNome()).append(",");
                writer.append(disciplina.getCodigo()).append(",");
                writer.append(String.valueOf(disciplina.getCargaHoraria())).append("\n");
            }
            System.out.println("Disciplinas salvas com sucesso em disciplinas.csv!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar disciplinas: " + e.getMessage());
        }
    }

    public void carregarDisciplinas() {
        listaDisciplinas.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("disciplinas.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                String codigo = partes[1];
                int cargaHoraria = Integer.parseInt(partes[2]);

                Disciplina disciplina = new Disciplina(nome, codigo, cargaHoraria);
                listaDisciplinas.add(disciplina);
            }
            System.out.println("Disciplinas carregadas com sucesso de disciplinas.csv!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar disciplinas: " + e.getMessage());
        }
    }


}
