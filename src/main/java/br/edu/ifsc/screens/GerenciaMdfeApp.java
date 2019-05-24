package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXDecorator;
import br.edu.ifsc.function.Function;
import br.edu.ifsc.strings.Strings;
import br.edu.ifsc.util.GerenciaMdfe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GerenciaMdfeApp extends Application implements Function {

	private TableView<GerenciaMdfe> table;
	private TableColumn<GerenciaMdfe, String> numero;
	private TableColumn<GerenciaMdfe, String> emissao;
	private TableColumn<GerenciaMdfe, String> chaveAcesso;
	private TableColumn<GerenciaMdfe, String> veiculo;
	private TableColumn<GerenciaMdfe, String> situacao;
	private JFXButton btnVoltar;
	private Panel panel;
	private Label lblTitulo;
	private JFXDecorator decorator;
	private static Stage stage;

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		components();
		listeners();
		decorator = new JFXDecorator(stage, panel);
		decorator.setCustomMaximize(true);
		Scene scene = new Scene(decorator, 1110, 550);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().addAll("b", "panel-primary");
		stage.setScene(scene);
		stage.show();
		GerenciaMdfeApp.stage = stage;
		layout();

	}

	public void layout() {
		numero.setMinWidth(200);
		emissao.setMinWidth(200);
		veiculo.setMinWidth(200);
		chaveAcesso.setMinWidth(200);
		situacao.setMinWidth(200);
		lblTitulo.setLayoutX(50);
		lblTitulo.setLayoutY(40);
		btnVoltar.setLayoutX(60);
		btnVoltar.setLayoutY(10);
		
		btnVoltar.setButtonType(ButtonType.RAISED);
		btnVoltar.setStyle("-fx-background-color: #FAFAFA; -fx-cursor: hand");
		btnVoltar.setTextFill(Color.BLUE);
		btnVoltar.setPrefSize(80, 30);

		panel.setStyle("-fx-background-color: #ECEFF1");
		table.setStyle("-fx-background-color: #FAFAFA");

	}

	public void components() {
		panel = new Panel();
		table = new TableView<>();
		numero = new TableColumn<>(Strings.lblCodMDF);
		emissao = new TableColumn<>(Strings.lblData);
		chaveAcesso = new TableColumn<>(Strings.lblChaveMdfe);
		situacao = new TableColumn<>(Strings.situacao);
		veiculo = new TableColumn<>(Strings.lblPlaca);
		lblTitulo = new Label(Strings.lblTitMdfe);
		table.getColumns().add(numero);
		table.getColumns().add(emissao);
		table.getColumns().add(chaveAcesso);
		table.getColumns().add(situacao);
		table.getColumns().add(veiculo);
		btnVoltar = new JFXButton(Strings.btnVoltar);
		panel.setBody(table);
		panel.setLeft(btnVoltar);
		panel.setHeading(lblTitulo);
	}

	public void listeners() {
		btnVoltar.setOnAction(volta -> {
			try {
				new MenuApp().start(new Stage());
				GerenciaMdfeApp.stage.close();
			} catch (Exception volta1) {
				volta1.printStackTrace();
			}
		});
	}
}