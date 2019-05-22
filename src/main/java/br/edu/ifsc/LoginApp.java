package br.edu.ifsc;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import br.edu.ifsc.strings.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application implements ControlaApp{

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
		panel.getStyleClass().addAll("b", "panel-primary");
		stage.setScene(scene);
		stage.setTitle(Strings.appLogin);
		stage.setResizable(true);
		stage.show();
		LoginApp.stage = stage;
		layout();

	}

	public void layout() {
		lblLogin.setLayoutX((pane.getWidth() - lblLogin.getWidth()) / 2);
		lblLogin.setLayoutY(40);
		txtLogin.setLayoutX((pane.getWidth() - txtLogin.getWidth()) / 2);
		txtLogin.setLayoutY(100);
		txtSenha.setLayoutX((pane.getWidth() - txtSenha.getWidth()) / 2);
		txtSenha.setLayoutY(140);
		btnEntrar.setLayoutX((pane.getWidth() - btnEntrar.getWidth()) / 2);
		btnEntrar.setLayoutY(180);
		Image appIcon = new Image(getClass().getResourceAsStream("truck.png"));
		stage.getIcons().add(appIcon);
	}

	public void components() {
		pane = new AnchorPane();
		panel = new Panel(Strings.lblTransportadora);
		panel.setPrefSize(500, 400);
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