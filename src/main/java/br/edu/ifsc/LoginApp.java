package br.edu.ifsc;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application {

	private AnchorPane pane;
	private Panel panel;
	private TextField txtLogin;
	private PasswordField txtSenha;
	private Button btnEntrar;
	private Label lblLogin;
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
		panel.getStyleClass().add("panel-primary");
		stage.setScene(scene);
		stage.setTitle(Strings.appLogin);
		stage.setResizable(false);
		stage.show();
		layout();
		LoginApp.stage = stage;
	}

	private void layout() {
		lblLogin.setLayoutX((pane.getWidth() - lblLogin.getWidth()) / 2);
		lblLogin.setLayoutY(40);
		txtLogin.setLayoutX((pane.getWidth() - txtLogin.getWidth()) / 2);
		txtLogin.setLayoutY(100);
		txtSenha.setLayoutX((pane.getWidth() - txtSenha.getWidth()) / 2);
		txtSenha.setLayoutY(140);
		btnEntrar.setLayoutX((pane.getWidth() - btnEntrar.getWidth()) / 2);
		btnEntrar.setLayoutY(180);

	}

	private void components() {
		pane = new AnchorPane();
		panel = new Panel("Transportadora NewWay");
		pane.setPrefSize(400, 300);
		txtLogin = new TextField();
		txtSenha = new PasswordField();
		lblLogin = new Label(Strings.lblLogin);
		txtLogin.setPromptText(Strings.txtLogin);
		txtSenha.setPromptText(Strings.txtSenha);
		btnEntrar = new Button(Strings.btnEntrar);
		lblLogin.getStyleClass().setAll("strong");
		btnEntrar.getStyleClass().setAll("btn", "btn-danger");
		pane.getChildren().addAll(lblLogin, txtLogin, txtSenha, btnEntrar);
		panel.setBody(pane);
	}

	private void listeners() {
		btnEntrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (txtLogin.getText().isEmpty()) {
					try {
						new Error(Strings.loginError).start(new Stage());

					} catch (Exception e) {
						e.printStackTrace();
					}
					return;
				}

				if (!txtSenha.getText().equals("admin")) {
					try {
						new Error(Strings.passwordError).start(new Stage());
					} catch (Exception e) {
						e.printStackTrace();
					}
					return;
				}

				try {
					new MenuApp().start(new Stage());
					LoginApp.stage.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}

}