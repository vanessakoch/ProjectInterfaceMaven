package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXDecorator;
import br.edu.ifsc.controller.ControllerApp;
import br.edu.ifsc.strings.Strings;
import br.edu.ifsc.util.GerenciaCte;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class GerenciaCteApp extends Application implements ControllerApp {
	
	private TableView<GerenciaCte> table;
	private TableColumn<GerenciaCte, String> id;
	private TableColumn<GerenciaCte, String> data;
	private TableColumn<GerenciaCte, String> remetente;
	private TableColumn<GerenciaCte, String> situacao;
	private TableColumn<GerenciaCte, String> valorNota;
	private JFXButton btnVoltar;
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
		Scene scene = new Scene(decorator, 1000, 550);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().add("panel-primary");
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
		btnVoltar.setLayoutX(60);
		btnVoltar.setLayoutY(10);
		btnVoltar.setMaxWidth(100);
		btnVoltar.setMinWidth(100);

	}

	public void components() {
		panel = new Panel();
		table = new TableView<>();
		id = new TableColumn<>(Strings.lblCte);
		data = new TableColumn<>(Strings.lblData);
		remetente = new TableColumn<>(Strings.lblRemetente);
		situacao = new TableColumn<>(Strings.situacao);
		valorNota = new TableColumn<>(Strings.valorNota);

		table.getColumns().add(id);
		table.getColumns().add(data);
		table.getColumns().add(remetente);
		table.getColumns().add(situacao);
		table.getColumns().add(valorNota);

		btnVoltar = new JFXButton(Strings.btnVoltar);
		btnVoltar.setButtonType(ButtonType.RAISED);
		btnVoltar.setStyle("-fx-background-color: #3949AB");
		btnVoltar.setPrefSize(90, 40);
		panel.setBody(table);
		panel.setHeading(btnVoltar);
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