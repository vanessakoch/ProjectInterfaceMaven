package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXButton.ButtonType;
import br.edu.ifsc.function.Function;
import br.edu.ifsc.strings.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ErrorApp extends Application implements Function {

	private Panel panel;
	private AnchorPane pane;
	private String mensagem;
	private Label lblMsg;
	private JFXButton btnOk;
	private static Stage stage;
	private JFXDecorator decorator;

	public ErrorApp(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public void start(Stage stage) throws Exception {
		components();
		listeners();
		decorator = new JFXDecorator(stage, panel, false, false, true);
		Scene scene = new Scene(decorator, 300, 180);
		stage.setScene(scene);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		stage.show();
		ErrorApp.stage = stage;
		layout();

	}

	public void layout() {
		lblMsg.setLayoutX(25);
		lblMsg.setLayoutY(20);
		btnOk.setLayoutX(165);
		btnOk.setLayoutY(15);
		panel.setStyle("-fx-background-color: #ECEFF1;");
		panel.getStyleClass().addAll("b", "panel-danger");
		lblMsg.setStyle("-fx-text-fill: #D34336;");
		lblMsg.setFont(Font.font(13));
		lblMsg.setTextFill(Color.RED);
		btnOk.setButtonType(ButtonType.RAISED);
		btnOk.setStyle("-fx-background-color: #B71C1C; -fx-cursor: hand");
		btnOk.setTextFill(Color.WHITE);
		btnOk.setPrefSize(80, 30);
	}

	public void components() {
		pane = new AnchorPane();
		panel = new Panel(Strings.lblErro);
		lblMsg = new Label(mensagem.toUpperCase());
		btnOk = new JFXButton(Strings.btnOk);
		pane.getChildren().addAll(lblMsg, btnOk);
		panel.setBody(pane);

	}

	public void listeners() {
		btnOk.setOnMouseClicked(e -> stage.close());
	}
}