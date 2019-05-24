package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;

import br.edu.ifsc.function.FunctionApp;
import br.edu.ifsc.strings.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MotoristaApp extends Application implements FunctionApp {
	
	private AnchorPane pane;
	private Panel panel;
	private TextField txtNome, txtEndereco, txtCnh, txtCidade, txtPlaca;
	private Button btnVoltar;
	private JFXButton btnOk;
	private Label lblCadastro, lblNome, lblEndereco, lblCnh, lblCidade, lblValidade, lblNascimento, lblPlaca;
	private DatePicker dtValidade, dtNascimento;
	private static Stage stage;
	private JFXDecorator decorator;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		components();
		listeners();
		decorator = new JFXDecorator(stage, panel, false, false, true);
		Scene scene = new Scene(decorator, 830, 500);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().addAll("b", "panel-primary");
		stage.setScene(scene);
		stage.show();
		MotoristaApp.stage = stage;
		layout();

	}

	public void layout() {
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
		decorator.setCustomMaximize(true);
		btnOk.setButtonType(ButtonType.RAISED);
		btnOk.setStyle("-fx-background-color: #FAFAFA");
		btnOk.setTextFill(Color.BLUE);
		btnOk.setPrefSize(90, 40);
		lblCadastro.getStyleClass().setAll("strong");
		lblCadastro.setFont(Font.font(14));
		
	}

	public void components() {
		pane = new AnchorPane();
		txtNome = new TextField();
		txtEndereco = new TextField();
		txtCnh = new TextField();
		txtCidade = new TextField();
		txtPlaca = new TextField();
		panel = new Panel(Strings.lblTransportadora);
		lblCadastro = new Label(Strings.lblCadM);
		lblNome = new Label(Strings.lblNome);
		lblEndereco = new Label(Strings.lblEndereco);
		lblCnh = new Label(Strings.lblCnh);
		lblCidade = new Label(Strings.lblCidade);
		lblValidade = new Label(Strings.lblValidade);
		lblNascimento = new Label(Strings.lblNascimento);
		lblPlaca = new Label(Strings.lblPlaca);
		btnOk = new JFXButton(Strings.btnOk);
		btnVoltar = new Button(Strings.btnVoltar);
		dtValidade = new DatePicker();
		dtNascimento = new DatePicker();

		pane.getChildren().addAll(lblCadastro, lblNome, lblEndereco, lblCnh, lblCidade, lblValidade, lblNascimento,
				lblPlaca, btnOk, btnVoltar, txtNome, txtEndereco, txtCnh, txtCidade, txtPlaca, dtValidade,
				dtNascimento);
		panel.setBody(pane);
	}

	public void listeners() {
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
				new FinalizarApp().start(new Stage());
			} catch (Exception ok1) {
				ok1.printStackTrace();
			}
		});

	}

}
