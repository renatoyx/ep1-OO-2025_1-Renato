import java.util.Scanner;

public class Main {

    static Gerenciador gerenciador = new Gerenciador();
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        gerenciador.carregarAlunos();
        gerenciador.carregarDisciplinas();

        int opcao;

        do {
            System.out.println("\n====== SISTEMA ACADÊMICO FCTE ======");
            System.out.println("1. Modo Aluno");
            System.out.println("2. Modo Disciplina/Turma");
            System.out.println("3. Modo Avaliação/Frequência");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    modoAluno();
                    break;
                case 2:
                    modoDisciplina();
                    break;
                case 3:
                    //modoAvaliacao();
                    break;
                case 0:
                    gerenciador.salvarAlunos();
                    gerenciador.salvarDisciplinas();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        entrada.close();
    }

    public static void modoAluno() {
        int opcao;

        do {
            System.out.println("\n-- MENU ALUNO --");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Matricular em Disciplina");
            System.out.println("4. Trancar Disciplina");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    gerenciador.cadastrarAluno(entrada);
                    break;
                case 2:
                    gerenciador.listarAlunos();
                    break;
                case 3:
                    gerenciador.matricularAlunoEmDisciplina(entrada);
                    break;
                case 4:
                    System.out.println("Funcionalidade ainda não implementada.");
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void modoDisciplina() {
        int opcao;

        do {
            System.out.println("\n-- MENU DISCIPLINA/TURMA --");
            System.out.println("1. Cadastrar Disciplina");
            System.out.println("2. Listar Disciplinas");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    gerenciador.cadastrarDisciplina(entrada);
                    break;
                case 2:
                    gerenciador.listarDisciplinas();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

}