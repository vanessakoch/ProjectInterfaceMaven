package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXDecorator;
import br.edu.ifsc.controller.ControllerApp;
import br.edu.ifsc.strings.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VeiculoApp extends Application implements ControllerApp {
	
	private AnchorPane pane;
	private Panel panel;
	private TextField txtMotorista, txtMarca, txtModelo, txtPlaca, txtSeguro, txtApolice;
	private Button btnVoltar;
	private Label lblCadastro, lblMotorista, lblMarca, lblAno, lblModelo, lblPlaca, lblSeguro, lblApolice;
	private DatePicker dtFabricacao;
	private static Stage stage;
	private JFXButton btnOk;
	private JFXDecorator decorator;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		components();
		listeners();

		decorator = new JFXDecorator(stage, panel, false, false, true);
		Scene scene = new Scene(decorator, 800, 500);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().add("panel-primary");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		VeiculoApp.stage = stage;
		layout();

	}

	@Override
	public void layout() {
		lblCadastro.setLayoutX((pane.getWidth() - lblCadastro.getWidth()) / 2);
		lblCadastro.setLayoutY(10);
		lblMotorista.setLayoutX(60);
		lblMotorista.setLayoutY(80);
		lblMarca.setLayoutX(60);
		lblMarca.setLayoutY(140);
		lblAno.setLayoutX(60);
		lblAno.setLayoutY(200);
		lblPlaca.setLayoutX(400);
		lblPlaca.setLayoutY(200);
		lblModelo.setLayoutX(400);
		lblModelo.setLayoutY(140);
		lblSeguro.setLayoutX(60);
		lblSeguro.setLayoutY(260);
		lblApolice.setLayoutX(400);
		lblApolice.setLayoutY(260);

		txtMotorista.setLayoutX(205);
		txtMotorista.setLayoutY(75);
		txtMotorista.setMinWidth(480);
		txtMarca.setLayoutX(205);
		txtMarca.setLayoutY(135);

		txtModelo.setLayoutX(530);
		txtModelo.setLayoutY(135);
		txtPlaca.setLayoutX(530);
		txtPlaca.setLayoutY(195);
		txtSeguro.setLayoutX(205);
		txtSeguro.setLayoutY(255);
		txtApolice.setLayoutX(530);
		txtApolice.setLayoutY(255);

		btnOk.setLayoutX((pane.getWidth() - lblCadastro.getWidth()) / 2);
		btnOk.setLayoutY(320);
		btnVoltar.setLayoutX(60);
		btnVoltar.setLayoutY(10);
		btnVoltar.setMaxWidth(100);
		btnVoltar.setMinWidth(100);

		dtFabricacao.setLayoutX(205);
		dtFabricacao.setLayoutY(195);

	}

	public void components() {
		pane = new AnchorPane();
		panel = new Panel(Strings.lblTransportadora);
		txtMotorista = new TextField();
		txtMarca = new TextField();
		txtSeguro = new TextField();
		txtApolice = new TextField();
		txtModelo = new TextField();
		txtPlaca = new TextField();
		lblCadastro = new Label(Strings.lblCadastro);
		lblMotorista = new Label(Strings.lblMotorista);
		lblMarca = new Label(Strings.lblMarca);
		lblAno = new Label(Strings.lblAno);
		lblModelo = new Label(Strings.lblModelo);
		lblSeguro = new Label(Strings.lblSeguro);
		lblApolice = new Label(Strings.lblApolice);
		lblPlaca = new Label(Strings.lblPlaca);
		btnVoltar = new Button(Strings.btnVoltar);
		dtFabricacao = new DatePicker();
		lblCadastro.getStyleClass().setAll("strong");
		btnOk = new JFXButton(Strings.btnOk);

		pane.getChildren().addAll(lblCadastro, lblMotorista, lblMarca, lblAno, lblModelo, txtSeguro, txtApolice,
				lblSeguro, lblApolice, lblPlaca, btnOk, btnVoltar, txtMotorista, txtMarca, txtModelo, txtPlaca,
				dtFabricacao);
		btnOk.setButtonType(ButtonType.RAISED);
		btnOk.setStyle("-fx-background-color: #FAFAFA");
		btnOk.setTextFill(Color.BLUE);
		btnOk.setPrefSize(90, 40);
		panel.setBody(pane);

	}

	public void listeners() {

		btnVoltar.setOnAction(volta -> {
			try {
				new MenuApp().start(new Stage());
				VeiculoApp.stage.close();
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