package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXDecorator;

import br.edu.ifsc.controller.ControllerApp;
import br.edu.ifsc.strings.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginApp extends Application implements ControllerApp {

	private AnchorPane pane;
	private Panel panel;
	private TextField txtLogin;
	private PasswordField txtSenha;
	private JFXButton btnEntrar;
	private Label lblLogin;
	private JFXDecorator decorator;
	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		components();
		listeners();

		decorator = new JFXDecorator(stage, panel, false, false, true);
		Scene scene = new Scene(decorator, 500, 400);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().addAll("b", "panel-primary");
		stage.setScene(scene);
		stage.show();
		LoginApp.stage = stage;
		layout();

	}

	public void layout() {
		lblLogin.setLayoutX((pane.getWidth() - lblLogin.getWidth()) / 2);
		lblLogin.setLayoutY(30);
		txtLogin.setLayoutX((pane.getWidth() - txtLogin.getWidth()) / 2);
		txtLogin.setLayoutY(90);
		txtSenha.setLayoutX((pane.getWidth() - txtSenha.getWidth()) / 2);
		txtSenha.setLayoutY(130);
		btnEntrar.setLayoutX((pane.getWidth() - btnEntrar.getWidth()) / 2);
		btnEntrar.setLayoutY(190);

	}

	public void components() {
		pane = new AnchorPane();
		panel = new Panel(Strings.lblTransportadora);
		txtLogin = new TextField();
		txtSenha = new PasswordField();
		lblLogin = new Label(Strings.lblLogin);
		txtLogin.setPromptText(Strings.txtLogin);
		txtSenha.setPromptText(Strings.txtSenha);
		btnEntrar = new JFXButton(Strings.btnEntrar);
		lblLogin.setFont(Font.font(14));
		btnEntrar.setButtonType(ButtonType.RAISED);
		btnEntrar.setStyle("-fx-background-color: #B71C1C");
		btnEntrar.setTextFill(Color.WHITE);
		btnEntrar.setPrefSize(100, 40);
		pane.getChildren().addAll(lblLogin, txtLogin, txtSenha, btnEntrar);
		panel.setBody(pane);
	}

	public void listeners() {
		btnEntrar.setOnAction(entrar -> {
			if (txtLogin.getText().isEmpty()) {
				try {
					new ErrorApp(Strings.semLogin).start(new Stage());
				} catch (Exception entrar1) {
					entrar1.printStackTrace();
				}
				return;
			}

			if (txtSenha.getText().isEmpty()) {
				try {
					new ErrorApp(Strings.semSenha).start(new Stage());
				} catch (Exception entrar1) {
					entrar1.printStackTrace();
				}
				return;
			}

			if (!txtSenha.getText().equals("admin") && !txtSenha.getText().equals("123")) {
				try {
					new ErrorApp(Strings.senhaIncorreta).start(new Stage());
				} catch (Exception entrar2) {
					entrar2.printStackTrace();
				}
				return;
			}

			try {
				new MenuApp().start(new Stage());
				LoginApp.stage.close();
			} catch (Exception entrar3) {
				entrar3.printStackTrace();
			}

		});

	}

}