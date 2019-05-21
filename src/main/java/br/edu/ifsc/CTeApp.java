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

public class CTeApp extends Application {

	private AnchorPane pane;
	private Panel panel;
	private Label lblCte, lblEmitente, lblDestinario, lblRemetente, lblChave, lblCidadeE, lblCnpjE, lblCidadeR,
			lblCnpjR, lblCidadeD, lblCnpjD, lblCfop, lblProduto, lblPeso, lblSaida, lblVencimento, lblData,
			lblValorCarga, lblSeguro, lblApolice, lblFrete, lblPedagio, lblCiot, lblTotalReceber, lblTotalFrete;
	private Button btnFinalizar, btnPesquisar, btnXml, btnVisualizar, btnImprimir, btnVoltar;
	private TextField txtCte, txtEmissor, txtRemetente, txtDestinario, txtChave, txtCidadeE, txtCnpjE, txtCidadeR,
			txtCnpjR, txtCidadeD, txtCnpjD, txtCfop, txtProduto, txtPeso, txtValorCarga, txtSeguro, txtApolice,
			txtFrete, txtPedagio, txtCiot, txtTotalReceber, txtTotalFrete;
	private DatePicker dtData, dtSaida, dtVencimento;
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
		panel.getStyleClass().addAll("b","panel-primary");
		Image appIcon = new Image(getClass().getResourceAsStream("truck.png"));
		stage.getIcons().add(appIcon);
		stage.setScene(scene);
		stage.setTitle(Strings.appConhecimento);
		stage.setResizable(false);
		stage.show();
		layout();
		CTeApp.stage = stage;
	}

	private void layout() {
		// labels
		lblChave.setLayoutX(355);
		lblChave.setLayoutY(50);
		lblCte.setLayoutY(110);
		lblCte.setLayoutX(30);
		lblEmitente.setLayoutY(140);
		lblEmitente.setLayoutX(30);
		lblRemetente.setLayoutY(170);
		lblRemetente.setLayoutX(30);
		lblDestinario.setLayoutY(200);
		lblDestinario.setLayoutX(30);
		lblCfop.setLayoutY(250);
		lblCfop.setLayoutX(30);
		lblProduto.setLayoutY(280);
		lblProduto.setLayoutX(30);
		lblPeso.setLayoutY(280);
		lblPeso.setLayoutX(260);
		lblValorCarga.setLayoutY(280);
		lblValorCarga.setLayoutX(520);
		lblSeguro.setLayoutY(310);
		lblSeguro.setLayoutX(30);
		lblApolice.setLayoutY(310);
		lblApolice.setLayoutX(260);
		lblFrete.setLayoutX(30);
		lblFrete.setLayoutY(340);
		lblPedagio.setLayoutX(30);
		lblPedagio.setLayoutY(370);
		lblCiot.setLayoutX(30);
		lblCiot.setLayoutY(400);
		lblCidadeE.setLayoutX(260);
		lblCidadeE.setLayoutY(140);
		lblCidadeR.setLayoutX(260);
		lblCidadeR.setLayoutY(170);
		lblCidadeD.setLayoutX(260);
		lblCidadeD.setLayoutY(200);
		lblCnpjE.setLayoutX(520);
		lblCnpjE.setLayoutY(140);
		lblCnpjR.setLayoutX(520);
		lblCnpjR.setLayoutY(170);
		lblCnpjD.setLayoutX(520);
		lblCnpjD.setLayoutY(200);
		lblTotalReceber.setLayoutX((pane.getWidth() - lblTotalReceber.getWidth()) / 2);
		lblTotalReceber.setLayoutY(480);
		lblTotalFrete.setLayoutX((pane.getWidth() - lblTotalFrete.getWidth()) / 2);
		lblTotalFrete.setLayoutY(400);
		lblSaida.setLayoutX(645);
		lblSaida.setLayoutY(350);
		lblVencimento.setLayoutX(630);
		lblVencimento.setLayoutY(410);
		lblData.setLayoutX(640);
		lblData.setLayoutY(470);

		// buttons
		btnFinalizar.setLayoutX(35);
		btnFinalizar.setLayoutY(545);
		btnFinalizar.setMaxWidth(100);
		btnFinalizar.setMinWidth(100);
		btnImprimir.setLayoutX(140);
		btnImprimir.setLayoutY(550);
		btnVisualizar.setLayoutX(240);
		btnVisualizar.setLayoutY(550);
		btnPesquisar.setLayoutX(665);
		btnPesquisar.setLayoutY(30);
		btnXml.setLayoutY(70);
		btnXml.setLayoutX(665);
		btnVoltar.setLayoutX(30);
		btnVoltar.setLayoutY(30);
		btnVoltar.setMaxWidth(100);
		btnVoltar.setMinWidth(100);
		btnFinalizar.getStyleClass().addAll("btn", "btn-danger");

		// txtFields
		txtChave.setLayoutX(180);
		txtChave.setLayoutY(70);
		txtChave.setMaxWidth(450);
		txtChave.setMinWidth(450);
		txtCte.setLayoutX(95);
		txtCte.setLayoutY(105);
		txtCte.setMaxWidth(50);
		txtEmissor.setLayoutX(95);
		txtEmissor.setLayoutY(135);
		txtRemetente.setLayoutX(95);
		txtRemetente.setLayoutY(165);
		txtDestinario.setLayoutX(95);
		txtDestinario.setLayoutY(195);
		txtCfop.setLayoutX(95);
		txtCfop.setLayoutY(245);
		txtProduto.setLayoutX(95);
		txtProduto.setLayoutY(275);
		txtSeguro.setLayoutX(95);
		txtSeguro.setLayoutY(305);
		txtFrete.setLayoutX(95);
		txtFrete.setLayoutY(335);
		txtPedagio.setLayoutX(95);
		txtPedagio.setLayoutY(365);
		txtCiot.setLayoutX(95);
		txtCiot.setLayoutY(395);
		txtCidadeE.setLayoutX(355);
		txtCidadeE.setLayoutY(135);
		txtCidadeR.setLayoutX(355);
		txtCidadeR.setLayoutY(165);
		txtCidadeD.setLayoutX(355);
		txtCidadeD.setLayoutY(195);
		txtPeso.setLayoutX(355);
		txtPeso.setLayoutY(275);
		txtApolice.setLayoutX(355);
		txtApolice.setLayoutY(305);
		txtCnpjE.setLayoutX(610);
		txtCnpjE.setLayoutY(135);
		txtCnpjR.setLayoutX(610);
		txtCnpjR.setLayoutY(165);
		txtCnpjD.setLayoutX(610);
		txtCnpjD.setLayoutY(195);
		txtValorCarga.setLayoutX(610);
		txtValorCarga.setLayoutY(275);
		txtTotalFrete.setLayoutX(350);
		txtTotalFrete.setLayoutY(420);
		txtTotalFrete.setMaxWidth(120);
		txtTotalReceber.setLayoutX(350);
		txtTotalReceber.setLayoutY(500);
		txtTotalReceber.setMaxWidth(120);

		// date
		dtSaida.setLayoutX(595);
		dtSaida.setLayoutY(370);
		dtVencimento.setLayoutX(595);
		dtVencimento.setLayoutY(430);
		dtData.setLayoutX(595);
		dtData.setLayoutY(490);

	}

	private void components() {
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		lblCte = new Label(Strings.lblCte);
		lblEmitente = new Label(Strings.lblEmitente);
		lblRemetente = new Label(Strings.lblRemetente);
		lblDestinario = new Label(Strings.lblDestinario);
		lblChave = new Label(Strings.lblChave);
		lblCidadeE = new Label(Strings.lblCidadeE);
		lblCnpjE = new Label(Strings.lblCnpjE);
		lblCidadeR = new Label(Strings.lblCidadeR);
		lblCnpjR = new Label(Strings.lblCnpjR);
		lblCidadeD = new Label(Strings.lblCidadeD);
		lblCnpjD = new Label(Strings.lblCnpjD);
		lblCfop = new Label(Strings.lblCfop);
		lblProduto = new Label(Strings.lblProduto);
		lblPeso = new Label(Strings.lblPeso);
		lblValorCarga = new Label(Strings.lblValorCarga);
		lblSeguro = new Label(Strings.lblSeguro);
		lblApolice = new Label(Strings.lblApolice);
		lblFrete = new Label(Strings.lblFrete);
		lblPedagio = new Label(Strings.lblPedagio);
		lblCiot = new Label(Strings.lblCiot);
		lblTotalReceber = new Label(Strings.lblTotalReceber);
		lblTotalFrete = new Label(Strings.lblTotalFrete);
		lblSaida = new Label(Strings.lblSaida);
		lblVencimento = new Label(Strings.lblVencimento);
		lblData = new Label(Strings.lblData);

		// btn
		btnFinalizar = new Button(Strings.btnFinalizar);
		btnPesquisar = new Button(Strings.btnPesquisar);
		btnXml = new Button(Strings.btnXml);
		btnVisualizar = new Button(Strings.btnVisualizar);
		btnImprimir = new Button(Strings.btnImprimir);
		btnVoltar = new Button(Strings.btnVoltar);

		// txtFields
		txtCte = new TextField();
		txtEmissor = new TextField();
		txtRemetente = new TextField();
		txtDestinario = new TextField();
		txtChave = new TextField();
		txtCidadeE = new TextField();
		txtCnpjE = new TextField();
		txtCidadeR = new TextField();
		txtCnpjR = new TextField();
		txtCidadeD = new TextField();
		txtCnpjD = new TextField();
		txtCfop = new TextField();
		txtProduto = new TextField();
		txtPeso = new TextField();
		txtValorCarga = new TextField();
		txtSeguro = new TextField();
		txtApolice = new TextField();
		txtFrete = new TextField();
		txtPedagio = new TextField();
		txtCiot = new TextField();
		txtTotalReceber = new TextField();
		txtTotalFrete = new TextField();

		// date
		dtData = new DatePicker();
		dtVencimento = new DatePicker();
		dtSaida = new DatePicker();

		panel = new Panel(Strings.lblTransportadora);

		pane.getChildren().addAll(lblCte, lblEmitente, lblRemetente, lblDestinario, lblChave, lblCidadeE, lblCnpjE,
				lblCidadeR, lblCnpjR, lblCidadeD, lblCnpjD, lblCfop, lblProduto, lblPeso, lblValorCarga, lblSeguro,
				lblApolice, lblFrete, lblPedagio, lblCiot, lblTotalReceber, lblTotalFrete, btnFinalizar, btnPesquisar,
				btnXml, btnVisualizar, btnImprimir, btnVoltar, txtCte, txtEmissor, txtRemetente, txtDestinario,
				txtChave, txtCidadeE, txtCnpjE, txtCidadeR, txtCnpjR, txtCidadeD, txtCnpjD, txtCfop, txtProduto,
				txtPeso, txtValorCarga, txtSeguro, txtApolice, txtFrete, txtPedagio, txtCiot, txtTotalReceber,
				txtTotalFrete, lblSaida, lblVencimento, lblData, dtData, dtSaida, dtVencimento);
		panel.setBody(pane);
	}

	private void listeners() {
		btnVoltar.setOnAction(volta -> {
			try {
				new MenuApp().start(new Stage());
				CTeApp.stage.close();
			} catch (Exception volta1) {
				volta1.printStackTrace();
			}

		});

		btnFinalizar.setOnMouseClicked(finaliza -> {
			try {
				new Finalizar().start(new Stage());
			} catch (Exception finaliza1) {
				finaliza1.printStackTrace();
			}
		});

	}

}
