package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXDecorator;
import br.edu.ifsc.function.Function;
import br.edu.ifsc.strings.Strings;
import br.edu.ifsc.util.GerenciaCte;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GerenciaCteApp extends Application implements Function {

	private TableView<GerenciaCte> table;
	private TableColumn<GerenciaCte, String> id;
	private TableColumn<GerenciaCte, String> data;
	private TableColumn<GerenciaCte, String> remetente;
	private TableColumn<GerenciaCte, String> situacao;
	private TableColumn<GerenciaCte, String> valorNota;
	private JFXButton btnVoltar;
	private Label lblTitCte;
	private Panel panel;
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
		Scene scene = new Scene(decorator, 1150, 550);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().addAll("b", "panel-primary");
		stage.setScene(scene);
		stage.show();
		GerenciaCteApp.stage = stage;
		layout();

	}

	public void layout() {
		id.setMinWidth(200);
		data.setMinWidth(200);
		remetente.setMinWidth(200);
		situacao.setMinWidth(200);
		valorNota.setMinWidth(200);
		
		btnVoltar.setMaxWidth(100);
		btnVoltar.setMinWidth(100);
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
		id = new TableColumn<>(Strings.lblCte);
		data = new TableColumn<>(Strings.lblData);
		remetente = new TableColumn<>(Strings.lblRemetente);
		situacao = new TableColumn<>(Strings.situacao);
		valorNota = new TableColumn<>(Strings.valorNota);
		lblTitCte = new Label(Strings.lblTitCte);
		table.getColumns().add(id);
		table.getColumns().add(data);
		table.getColumns().add(remetente);
		table.getColumns().add(situacao);
		table.getColumns().add(valorNota);
		btnVoltar = new JFXButton(Strings.btnVoltar);
		panel.setLeft(btnVoltar);
		panel.setBody(table);
		panel.setHeading(lblTitCte);
	}

	public void listeners() {
		btnVoltar.setOnAction(volta -> {
			try {
				new MenuApp().start(new Stage());
				GerenciaCteApp.stage.close();
			} catch (Exception volta1) {
				volta1.printStackTrace();
			}
		});
	}
}