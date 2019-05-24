package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import br.edu.ifsc.function.Function;
import br.edu.ifsc.strings.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ManifestoApp extends Application implements Function {

	private AnchorPane pane;
	private Panel panel;
	private TextField txtChaveMdfe, txtCod, txtVeiculo, txtRS, txtPlaca, txtMotorista, txtUFC, txtUFD, txtCTE;
	private JFXButton btnOk, btnVoltar, btnXml, btnVisualizar, btnImprimir;
	private Label lblChaveMdfe, lblCod, lblVeiculo, lblRS, lblDtSaida, lblDtEmissao, lblDtChegada, lblPlaca,
			lblMotorista, lblUFC, lblUFD, lblCte, lblManifesto;
	private DatePicker dtSaida, dtChegada, dtEmissao;
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
		Scene scene = new Scene(decorator, 860, 500);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().addAll("b", "panel-primary");
		stage.setScene(scene);
		stage.show();
		ManifestoApp.stage = stage;
		layout();

	}

	public void layout() {
		panel.setStyle("-fx-background-color: #ECEFF1;");
		txtChaveMdfe.setLayoutX(200);
		txtChaveMdfe.setLayoutY(65);
		txtChaveMdfe.setPrefWidth(390);
		txtCod.setLayoutX(690);
		txtCod.setLayoutY(20);
		txtCod.setPrefWidth(50);
		txtCTE.setLayoutX(200);
		txtCTE.setLayoutY(105);
		txtVeiculo.setLayoutX(200);
		txtVeiculo.setLayoutY(145);
		txtPlaca.setLayoutX(200);
		txtPlaca.setLayoutY(185);

		dtSaida.setLayoutX(200);
		dtSaida.setLayoutY(265);
		dtChegada.setLayoutX(590);
		dtChegada.setLayoutY(265);
		dtEmissao.setLayoutX(200);
		dtEmissao.setLayoutY(225);

		txtRS.setLayoutX(590);
		txtRS.setLayoutY(105);
		txtMotorista.setLayoutX(590);
		txtMotorista.setLayoutY(145);
		txtUFC.setLayoutX(590);
		txtUFC.setLayoutY(185);
		txtUFD.setLayoutX(590);
		txtUFD.setLayoutY(225);

		lblChaveMdfe.setLayoutX(70);
		lblChaveMdfe.setLayoutY(70);
		lblCod.setLayoutX(600);
		lblCod.setLayoutY(25);
		lblVeiculo.setLayoutX(70);
		lblVeiculo.setLayoutY(150);
		lblPlaca.setLayoutX(70);
		lblPlaca.setLayoutY(190);
		lblDtEmissao.setLayoutX(70);
		lblDtEmissao.setLayoutY(230);
		lblDtSaida.setLayoutX(70);
		lblDtSaida.setLayoutY(270);
		lblCte.setLayoutX(70);
		lblCte.setLayoutY(110);
		lblManifesto.setLayoutX(210);
		lblManifesto.setLayoutY(0);
		lblRS.setLayoutX(450);
		lblRS.setLayoutY(110);
		lblMotorista.setLayoutX(450);
		lblMotorista.setLayoutY(150);
		lblUFC.setLayoutX(450);
		lblUFC.setLayoutY(190);
		lblUFD.setLayoutX(450);
		lblUFD.setLayoutY(230);
		lblDtChegada.setLayoutX(450);
		lblDtChegada.setLayoutY(270);

		btnOk.setLayoutX(360);
		btnOk.setLayoutY(330);
		btnVoltar.setLayoutX(70);
		btnVoltar.setLayoutY(10);
		btnVoltar.setMaxWidth(100);
		btnVoltar.setMinWidth(100);
		btnXml.setLayoutX(640);
		btnXml.setLayoutY(60);
		btnVisualizar.setLayoutX(70);
		btnVisualizar.setLayoutY(340);
		btnImprimir.setLayoutX(200);
		btnImprimir.setLayoutY(340);

		btnOk.setButtonType(ButtonType.RAISED);
		btnOk.setStyle("-fx-background-color: #3F51B5; -fx-cursor: hand");
		btnOk.setTextFill(Color.WHITE);
		btnOk.setPrefSize(100, 40);
		lblManifesto.setFont(Font.font(12));
		lblManifesto.getStyleClass().setAll("strong");

		btnVoltar.setButtonType(ButtonType.RAISED);
		btnVoltar.setStyle("-fx-background-color: #FAFAFA; -fx-cursor: hand");
		btnVoltar.setTextFill(Color.BLUE);
		btnVoltar.setPrefSize(80, 30);

		btnXml.setButtonType(ButtonType.RAISED);
		btnXml.setStyle("-fx-background-color: #FAFAFA; -fx-cursor: hand");
		btnXml.setTextFill(Color.BLUE);
		btnXml.setPrefSize(100, 20);

		btnVisualizar.setButtonType(ButtonType.RAISED);
		btnVisualizar.setStyle("-fx-background-color: #FAFAFA; -fx-cursor: hand");
		btnVisualizar.setTextFill(Color.BLUE);
		btnVisualizar.setPrefSize(110, 20);

		btnImprimir.setButtonType(ButtonType.RAISED);
		btnImprimir.setStyle("-fx-background-color: #FAFAFA; -fx-cursor: hand");
		btnImprimir.setTextFill(Color.BLUE);
		btnImprimir.setPrefSize(110, 20);
	}

	public void components() {
		pane = new AnchorPane();
		txtPlaca = new TextField();
		txtChaveMdfe = new TextField();
		txtCod = new TextField();
		txtVeiculo = new TextField();
		txtPlaca = new TextField();
		txtMotorista = new TextField();
		txtUFC = new TextField();
		txtUFD = new TextField();
		txtCTE = new TextField();
		txtRS = new TextField();
		panel = new Panel(Strings.lblTransportadora);
		lblChaveMdfe = new Label(Strings.lblChaveMdfe);
		lblCod = new Label(Strings.lblCodMDF);
		lblVeiculo = new Label(Strings.lblVeiculo);
		lblRS = new Label(Strings.lblRS);
		lblDtSaida = new Label(Strings.lblDtSaida);
		lblDtChegada = new Label(Strings.lblDtChegada);
		lblDtEmissao = new Label(Strings.lblDtEmissao);
		lblMotorista = new Label(Strings.lblMotorista);
		lblUFC = new Label(Strings.lblUFC);
		lblUFD = new Label(Strings.lblUFD);
		lblCte = new Label(Strings.lblCte);
		lblPlaca = new Label(Strings.lblPlaca);
		lblManifesto = new Label(Strings.lblManifesto);
		btnOk = new JFXButton(Strings.btnOk);
		btnVoltar = new JFXButton(Strings.btnVoltar);
		btnXml = new JFXButton(Strings.btnXml);
		btnVisualizar = new JFXButton(Strings.btnVisMdf);
		btnImprimir = new JFXButton(Strings.btnImpMdf);
		dtChegada = new DatePicker();
		dtSaida = new DatePicker();
		dtEmissao = new DatePicker();

		pane.getChildren().addAll(txtChaveMdfe, txtCod, txtVeiculo, txtRS, txtPlaca, txtMotorista, txtUFC, txtUFD,
				txtCTE, btnVoltar, btnOk, lblChaveMdfe, lblCod, lblVeiculo, lblRS, lblDtSaida, lblDtChegada,
				lblDtEmissao, lblPlaca, lblMotorista, lblUFC, lblUFD, lblCte, dtSaida, dtChegada, dtEmissao,
				lblManifesto, btnXml, btnVisualizar, btnImprimir);
		panel.setBody(pane);
	}

	public void listeners() {
		btnVoltar.setOnAction(volta -> {
			try {
				new MenuApp().start(new Stage());
				ManifestoApp.stage.close();
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
