package br.edu.ifsc;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import br.edu.ifsc.strings.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ErrorApp extends Application implements ControlaApp{
	private Panel panel;
	private AnchorPane pane;
	private String mensagem;
	private Label lblMsg;
	private Button btnOk;
	private static Stage stage;

	public ErrorApp(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public void start(Stage stage) throws Exception {
		components();
		listeners();
		Scene scene = new Scene(panel);
		stage.setScene(scene);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		stage.setResizable(false);
		stage.show();
		ErrorApp.stage = stage;
		layout();

	}

	public void layout() {
		lblMsg.setLayoutX(30);
		lblMsg.setLayoutY(35);
		btnOk.setLayoutX(200);
		btnOk.setLayoutY(30);
		lblMsg.getStyleClass().add("h4");
		btnOk.getStyleClass().addAll("btn", "btn-danger");
		panel.getStyleClass().add("panel-primary");
		Image appIcon = new Image(getClass().getResourceAsStream("erro.png"));
		stage.getIcons().add(appIcon);
	}

	public void components() {
		pane = new AnchorPane();
		panel = new Panel(Strings.lblErro);
		pane.setPrefSize(280, 100);
		lblMsg = new Label(mensagem);
		btnOk = new Button(Strings.btnOk);
		pane.getChildren().addAll(lblMsg, btnOk);
		panel.setBody(pane);
		
	}

	public void listeners() {
		btnOk.setOnAction(e -> stage.close());

	}
}