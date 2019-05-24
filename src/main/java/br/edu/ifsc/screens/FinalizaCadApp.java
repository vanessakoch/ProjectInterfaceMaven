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

public class FinalizaCadApp extends Application implements Function {

	private AnchorPane pane;
	private Panel panel;
	private JFXButton btnOk;
	private Label lblConcluir;
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
		Scene scene = new Scene(decorator, 310, 145);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().addAll("b", "panel-primary");
		stage.setScene(scene);
		stage.show();
		FinalizaCadApp.stage = stage;
		layout();

	}

	public void layout() {
		lblConcluir.setLayoutX(20);
		lblConcluir.setLayoutY(10);
		lblConcluir.setFont(Font.font(12));
		lblConcluir.setStyle("-fx-text-fill: #1A237E;");
		btnOk.setLayoutX(90);
		btnOk.setLayoutY(40);
		btnOk.setButtonType(ButtonType.RAISED);
		btnOk.setStyle("-fx-background-color: #3F51B5; -fx-cursor: hand");
		btnOk.setTextFill(Color.WHITE);
		btnOk.setPrefSize(80, 30);
	}

	public void components() {
		pane = new AnchorPane();
		panel = new Panel();
		lblConcluir = new Label(Strings.lblConcluir);
		btnOk = new JFXButton(Strings.btnOk);
		pane.getChildren().addAll(lblConcluir, btnOk);
		panel.setBody(pane);
	}

	public void listeners() {
	
		btnOk.setOnMouseClicked(e -> stage.close());
	}

}
