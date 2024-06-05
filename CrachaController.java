import javafx.stage.Stage;
import javafx.event.Event;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class CrachaController {
    CrachaView view;
    Stage stage;
    CrachaFuncionário crachá;
    public TextField textFieldNome;
    public TextField textFieldCargo;
    public TextField textFieldID;
    public Label labelValidação;
    public Label labelHoras;

    public CrachaController() {
        this.stage = new Stage();
        this.view = new CrachaView();
        this.view.setController(this);
    }

    public void iniciar() throws Exception {
        this.view.start(this.stage);
        this.stage.show();
    }

    public void botaoCadastrarClicado(Event e) {
        try {
            String nome = textFieldNome.getText();
            String cargo = textFieldCargo.getText();
            int id = Integer.parseInt(textFieldID.getText());
            this.crachá = new CrachaFuncionário(nome, cargo, id);
            if (this.crachá.isValido()) {
                this.labelValidação.setText("Crachá válido");
            } else {
                this.labelValidação.setText("Crachá inválido");
            }
        } catch (NumberFormatException exception) {
            labelValidação.setText("Dados de entrada incompletos ou inválidos");
        }
    }

    public void botaoRegistrarEntradaClicado(Event e) {
        if (crachá != null && crachá.isValido()) {
            crachá.registrarEntrada();
            labelHoras.setText("Entrada registrada");
        } else {
            labelHoras.setText("Crachá inválido para entrada");
        }
    }

    public void botaoRegistrarSaidaClicado(Event e) {
        if (crachá != null && crachá.isValido()) {
            crachá.registrarSaida();
            long horas = crachá.calcularHorasNoEstabelecimento();
            labelHoras.setText("Horas no estabelecimento: " + horas);
        } else {
            labelHoras.setText("Crachá inválido para saída");
        }
    }

    public void botaoLimparClicado(Event e) {
        textFieldNome.setText("");
        textFieldCargo.setText("");
        textFieldID.setText("");
        labelValidação.setText("");
        labelHoras.setText("");
    }
}
