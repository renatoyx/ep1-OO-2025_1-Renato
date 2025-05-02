import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Principal {
    @FXML
    private Button mdAluno;

    @FXML
    private Button mdAvaliacao;

    @FXML
    private Button mdDisciplina;

    @FXML
    private Label labelDoBotao;

    @FXML
    private TextField txtNome;

    @FXML
    private void modoAluno() {
        System.out.println("Modo Aluno clicado!");
        labelDoBotao.setText("Você clicou no modo aluno" + txtNome.getText());
    }

    @FXML
    private void modoAvaliacao() {
        System.out.println("Modo Avaliação clicado!");
        labelDoBotao.setText("Você clicou no modo Avaliacao");
    }

    @FXML
    private void modoDisciplina() {
        System.out.println("Modo Disciplina clicado!");
        labelDoBotao.setText("Você clicou no modo Disciplina");
    }


}
