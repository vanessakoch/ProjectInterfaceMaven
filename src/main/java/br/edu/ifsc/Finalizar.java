package br.edu.ifsc;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Finalizar extends Application {

	private AnchorPane pane;
	private Panel panel;
	private Button btnOk;
	private Label lblConcluir;
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
		stage.setTitle(Strings.appFinalizar);
		stage.setResizable(false);
		stage.show();
		layout();
		Finalizar.stage = stage;
	}

	private void layout() {
		lblConcluir.setLayoutX((pane.getWidth() - lblConcluir.getWidth()) / 2);
		lblConcluir.setLayoutY(20);
		btnOk.setLayoutX((pane.getWidth() - btnOk.getWidth()) / 2);
		btnOk.setLayoutY(70);
	}

	private void components() {
		pane = new AnchorPane();
		panel = new Panel(Strings.lblCerto);
		pane.setPrefSize(280, 120);
		lblConcluir = new Label(Strings.lblConcluir);
		btnOk = new Button(Strings.btnOk);
		lblConcluir.getStyleClass().setAll("lead");
		btnOk.getStyleClass().setAll("btn", "btn-primary");
		pane.getChildren().addAll(lblConcluir, btnOk);
		panel.setBody(pane);
	}

	private void listeners() {
		btnOk.setOnMouseClicked(e -> stage.close());
	}
}