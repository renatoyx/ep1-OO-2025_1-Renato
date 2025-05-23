import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Gerenciador gerenciador = new Gerenciador();

        int opcao;

        do {
            System.out.println("\n====== SISTEMA ACADÊMICO FCTE ======");
            System.out.println("1. Modo Aluno");
            System.out.println("2. Modo Disciplina/Turma");
            System.out.println("3. Modo Avaliação/Frequência");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    modoAluno(entrada);
                    break;
                case 2:
                    modoDisciplina(entrada);
                    break;
                case 3:
                    modoAvaliacao(entrada);
                    break;
                case 0:
                    System.out.println("Saindo... Dados serão salvos.");
                    // aqui você pode chamar a função de salvar em arquivo
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        entrada.close();
    }

    public static void modoAluno(Scanner sc) {
        int opcao;
        Gerenciador gerenciador = new Gerenciador();
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("\n-- MENU ALUNO --");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Matricular em Disciplina");
            System.out.println("4. Trancar Disciplina");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1:
                    gerenciador.cadastrarAluno(entrada);
                    break;
                case 2:
                    gerenciador.listarAlunos();
                    break;
                // etc.
            }
        } while (opcao != 0);
    }

    public static void modoDisciplina(Scanner sc) {
        System.out.println("\n-- MODO DISCIPLINA/TURMA --");
        // Aqui você implementa menu do modo disciplina
    }

    public static void modoAvaliacao(Scanner sc) {
        System.out.println("\n-- MODO AVALIAÇÃO/FREQUÊNCIA --");
        // Aqui você implementa menu do modo avaliação
    }
}
