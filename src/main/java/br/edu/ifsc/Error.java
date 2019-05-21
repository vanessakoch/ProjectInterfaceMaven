package br.edu.ifsc;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Error extends Application {
	private String mensagem;

	public Error(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		Panel panel = new Panel(Strings.lblErro);
		pane.setPrefSize(260, 100);

		Scene scene = new Scene(panel);
		stage.setScene(scene);

		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().add("panel-primary");
		Image appIcon = new Image(getClass().getResourceAsStream("erro.png"));
		stage.getIcons().add(appIcon);

		Label lblMsg = new Label(mensagem);
		Button btnOk = new Button(Strings.btnOk);

		lblMsg.setLayoutX(50);
		lblMsg.setLayoutY(35);
		btnOk.setLayoutX(220);
		btnOk.setLayoutY(30);
		lblMsg.getStyleClass().add("h4");
		btnOk.getStyleClass().addAll("btn", "btn-danger");
		pane.getChildren().addAll(lblMsg, btnOk);
		panel.setBody(pane);

		btnOk.setOnMouseClicked(e -> stage.close());

		stage.show();
	}
}