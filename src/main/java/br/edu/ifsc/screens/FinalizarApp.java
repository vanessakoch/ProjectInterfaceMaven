package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXButton.ButtonType;

import br.edu.ifsc.function.FunctionApp;
import br.edu.ifsc.strings.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FinalizarApp extends Application implements FunctionApp {

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
		Scene scene = new Scene(decorator, 270, 190);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().addAll("b", "panel-primary");
		stage.setScene(scene);
		stage.show();
		FinalizarApp.stage = stage;
		layout();

	}

	public void layout() {
		lblConcluir.setLayoutX((pane.getWidth() - lblConcluir.getWidth()) / 2);
		lblConcluir.setLayoutY(5);
		btnOk.setLayoutX(70);
		btnOk.setLayoutY(45);
		btnOk.setButtonType(ButtonType.RAISED);
		btnOk.setStyle("-fx-background-color: #FAFAFA");
		btnOk.setTextFill(Color.BLUE);
		btnOk.setPrefSize(80, 30);
	}

	public void components() {
		pane = new AnchorPane();
		panel = new Panel(Strings.lblCerto);
		lblConcluir = new Label(Strings.lblConcluir);
		lblConcluir.setFont(Font.font(13));
		btnOk = new JFXButton(Strings.btnOk);
		pane.getChildren().addAll(lblConcluir, btnOk);
		panel.setBody(pane);
	}

	public void listeners() {
		btnOk.setOnMouseClicked(e -> stage.close());
	}

}