package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXDecorator;
import br.edu.ifsc.function.Function;
import br.edu.ifsc.strings.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginApp extends Application implements Function {

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
		panel.setStyle("-fx-background-color: #ECEFF1;");
		lblLogin.setLayoutX((pane.getWidth() - lblLogin.getWidth()) / 2);
		lblLogin.setLayoutY(30);
		txtLogin.setLayoutX((pane.getWidth() - txtLogin.getWidth()) / 2);
		txtLogin.setLayoutY(90);
		txtSenha.setLayoutX((pane.getWidth() - txtSenha.getWidth()) / 2);
		txtSenha.setLayoutY(130);
		btnEntrar.setLayoutX(180);
		btnEntrar.setLayoutY(180);
		btnEntrar.setButtonType(ButtonType.RAISED);
		btnEntrar.setStyle("-fx-background-color: #B71C1C; -fx-cursor: hand");
		btnEntrar.setTextFill(Color.WHITE);
		btnEntrar.setPrefSize(100, 40);
		lblLogin.getStyleClass().add("b");
	}

	public void components() {
		pane = new AnchorPane();
		txtLogin = new TextField();
		txtSenha = new PasswordField();
		panel = new Panel(Strings.lblTransportadora);
		lblLogin = new Label(Strings.lblLogin);
		txtLogin.setPromptText(Strings.txtLogin);
		txtSenha.setPromptText(Strings.txtSenha);
		btnEntrar = new JFXButton(Strings.btnEntrar);
		lblLogin.setFont(Font.font(14));
		pane.getChildren().addAll(lblLogin, txtLogin, txtSenha, btnEntrar);
		panel.setBody(pane);
	}

	public void listeners() {
		btnEntrar.setOnAction(e -> {
			System.out.println(Strings.logEntrar);
		});

		txtLogin.setOnKeyPressed(k -> {
			final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
			if (ENTER.match(k)) {
				txtSenha.requestFocus();
			}
		});

		btnEntrar.setOnMouseClicked(entrar -> {
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