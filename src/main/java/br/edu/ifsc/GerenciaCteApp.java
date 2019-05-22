package br.edu.ifsc;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import br.edu.ifsc.docs.*;
import br.edu.ifsc.strings.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GerenciaCteApp extends Application implements ControlaApp {
	private TableView<GerenciaCte> table;
	private TableColumn<GerenciaCte, String> id;
	private TableColumn<GerenciaCte, String> data;
	private TableColumn<GerenciaCte, String> remetente;
	private TableColumn<GerenciaCte, String> situacao;
	private TableColumn<GerenciaCte, String> valorNota;
	private Button btnVoltar;
	private Panel panel;
	private static Stage stage;

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		components();
		listeners();
		Scene scene = new Scene(panel, 1000, 500);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().add("panel-primary");
		Image appIcon = new Image(getClass().getResourceAsStream("truck.png"));
		stage.getIcons().add(appIcon);
		stage.setScene(scene);
		stage.setTitle(Strings.appGerenciaCte);
		stage.setResizable(true);
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

		btnVoltar = new Button(Strings.btnVoltar);
		btnVoltar.getStyleClass().addAll("btn", "btn-danger");
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