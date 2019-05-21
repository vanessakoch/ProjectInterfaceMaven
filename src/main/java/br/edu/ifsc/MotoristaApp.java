package br.edu.ifsc;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MotoristaApp extends Application {
	private AnchorPane pane;
	private Panel panel;
	private TextField txtNome, txtEndereco, txtCnh, txtCidade, txtPlaca;
	private Button btnOk, btnVoltar;
	private Label lblCadastro, lblNome, lblEndereco, lblCnh, lblCidade, lblValidade, lblNascimento, lblPlaca;
	private DatePicker dtValidade, dtNascimento;
	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		components();
		listeners();
		Scene scene = new Scene(panel);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().addAll("b", "panel-primary");
		Image appIcon = new Image(getClass().getResourceAsStream("truck.png"));
		stage.getIcons().add(appIcon);
		stage.setScene(scene);
		stage.setTitle(Strings.appMotorista);
		stage.setResizable(false);
		stage.show();
		layout();
		MotoristaApp.stage = stage;
	}

	private void layout() {
		lblCadastro.setLayoutX((pane.getWidth() - lblCadastro.getWidth()) / 2);
		lblCadastro.setLayoutY(10);
		lblNome.setLayoutX(60);
		lblNome.setLayoutY(80);
		lblEndereco.setLayoutX(60);
		lblEndereco.setLayoutY(140);
		lblCnh.setLayoutX(60);
		lblCnh.setLayoutY(200);
		lblValidade.setLayoutX(60);
		lblValidade.setLayoutY(260);
		lblNascimento.setLayoutX(400);
		lblNascimento.setLayoutY(260);
		lblPlaca.setLayoutX(400);
		lblPlaca.setLayoutY(200);
		lblCidade.setLayoutX(400);
		lblCidade.setLayoutY(140);

		txtNome.setLayoutX(205);
		txtNome.setLayoutY(75);
		txtNome.setMinWidth(480);
		txtEndereco.setLayoutX(205);
		txtEndereco.setLayoutY(135);
		txtCnh.setLayoutX(205);
		txtCnh.setLayoutY(195);
		txtCidade.setLayoutX(530);
		txtCidade.setLayoutY(135);
		txtPlaca.setLayoutX(530);
		txtPlaca.setLayoutY(195);

		btnOk.setLayoutX((pane.getWidth() - lblCadastro.getWidth()) / 2);
		btnOk.setLayoutY(320);
		btnVoltar.setLayoutX(60);
		btnVoltar.setLayoutY(10);
		btnVoltar.setMaxWidth(100);
		btnVoltar.setMinWidth(100);

		dtValidade.setLayoutX(205);
		dtValidade.setLayoutY(255);
		dtNascimento.setLayoutX(530);
		dtNascimento.setLayoutY(255);

	}

	private void components() {
		pane = new AnchorPane();
		panel = new Panel(Strings.lblTransportadora);
		pane.setPrefSize(800, 400);
		txtNome = new TextField();
		txtEndereco = new TextField();
		txtCnh = new TextField();
		txtCidade = new TextField();
		txtPlaca = new TextField();
		lblCadastro = new Label(Strings.lblCadastro);
		lblNome = new Label(Strings.lblNome);
		lblEndereco = new Label(Strings.lblEndereco);
		lblCnh = new Label(Strings.lblCnh);
		lblCidade = new Label(Strings.lblCidade);
		lblValidade = new Label(Strings.lblValidade);
		lblNascimento = new Label(Strings.lblNascimento);
		lblPlaca = new Label(Strings.lblPlaca);
		btnOk = new Button(Strings.btnOk);
		btnVoltar = new Button(Strings.btnVoltar);
		dtValidade = new DatePicker();
		dtNascimento = new DatePicker();
		lblCadastro.getStyleClass().setAll("strong");
		btnOk.getStyleClass().setAll("btn", "btn-primary");
		pane.getChildren().addAll(lblCadastro, lblNome, lblEndereco, lblCnh, lblCidade, lblValidade, lblNascimento,
				lblPlaca, btnOk, btnVoltar, txtNome, txtEndereco, txtCnh, txtCidade, txtPlaca, dtValidade,
				dtNascimento);
		panel.setBody(pane);
	}

	private void listeners() {
		btnVoltar.setOnAction(volta -> {
			try {
				new MenuApp().start(new Stage());
				MotoristaApp.stage.close();
			} catch (Exception volta1) {
				volta1.printStackTrace();
			}

		});

		btnOk.setOnMouseClicked(ok -> {
			try {
				new Finalizar().start(new Stage());
			} catch (Exception ok1) {
				ok1.printStackTrace();
			}
		});

	}

}
