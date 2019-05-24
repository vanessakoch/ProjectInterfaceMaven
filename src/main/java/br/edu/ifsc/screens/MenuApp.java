package br.edu.ifsc.screens;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import com.jfoenix.controls.JFXDecorator;
import br.edu.ifsc.function.Function;
import br.edu.ifsc.strings.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuApp extends Application implements Function {

	private MenuItem sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10, sub11, sub12, sub13, sub14, sub15,
			sub16, sub17, sub18, sub19, sub20;
	private MenuBar menuBar;
	private Menu m1, m2, m3, m4, m5, m6, m7;
	private Panel panel;
	private AnchorPane pane;
	private static Stage stage;
	private JFXDecorator decorator;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		components();
		listeners();
		decorator = new JFXDecorator(stage, panel);
		Scene scene = new Scene(decorator, 800, 550);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		panel.getStyleClass().addAll("b", "panel-primary");
		stage.setScene(scene);
		stage.show();
		MenuApp.stage = stage;
		layout();

	}

	public void layout() {
		decorator.setCustomMaximize(true);
		menuBar.setStyle("-fx-background-color: #1A237E; -fx-cursor: hand; -fx-base: #263238;");
		menuBar.getStyleClass().addAll("btn", "btn-group-vertical");
		menuBar.setLayoutX(0);
		menuBar.setLayoutY(30);
		menuBar.setPrefSize(1400, 50);
		panel.setStyle("-fx-background-color: #ECEFF1;");
	}

	public void components() {
		panel = new Panel(Strings.lblTransportadora);
		m1 = new Menu(Strings.menuCadastro);
		m2 = new Menu(Strings.menuTransporte);
		m3 = new Menu(Strings.menuFrete);
		m4 = new Menu(Strings.menuSaida);
		m5 = new Menu(Strings.menuRelatorio);
		m6 = new Menu(Strings.menuMapa);
		m7 = new Menu(Strings.menuExit);

		menuBar = new MenuBar();
		menuBar.getMenus().addAll(m1, m2, m3, m4, m5, m6, m7);
		menuBar.setPrefSize(300, 50);
		sub1 = new MenuItem(Strings.sub1);
		sub2 = new MenuItem(Strings.sub2);
		sub3 = new MenuItem(Strings.sub3);
		sub4 = new MenuItem(Strings.sub4);
		sub5 = new MenuItem(Strings.sub5);
		sub6 = new MenuItem(Strings.sub6);
		sub7 = new MenuItem(Strings.sub7);
		sub8 = new MenuItem(Strings.sub8);
		sub9 = new MenuItem(Strings.sub9);
		sub10 = new MenuItem(Strings.sub10);
		sub11 = new MenuItem(Strings.sub11);
		sub12 = new MenuItem(Strings.sub12);
		sub13 = new MenuItem(Strings.sub13);
		sub14 = new MenuItem(Strings.sub14);
		sub15 = new MenuItem(Strings.sub15);
		sub16 = new MenuItem(Strings.sub16);
		sub17 = new MenuItem(Strings.sub17);
		sub18 = new MenuItem(Strings.sub18);
		sub19 = new MenuItem(Strings.sub19);
		sub20 = new MenuItem(Strings.sub20);
		m1.getItems().addAll(sub1, sub2, sub3);
		m2.getItems().addAll(sub4, sub5, sub6, sub7, sub8);
		m4.getItems().addAll(sub9, sub10, sub11, sub12, sub13, sub14);
		m5.getItems().addAll(sub17, sub18, sub19, sub20);
		m7.getItems().addAll(sub15, sub16);
		pane = new AnchorPane();
		pane.getChildren().add(menuBar);
		panel.setBody(pane);

	}

	public void listeners() {
		sub16.setOnAction(e -> stage.close());

		sub15.setOnAction(login -> {
			try {
				new LoginApp().start(new Stage());
				MenuApp.stage.close();
			} catch (Exception login1) {
				login1.printStackTrace();
			}

		});

		sub9.setOnAction(cte -> {
			try {
				new CTeApp().start(new Stage());
				MenuApp.stage.close();
			} catch (Exception cte1) {
				cte1.printStackTrace();
			}

		});

		sub1.setOnAction(cad -> {
			try {
				new MotoristaApp().start(new Stage());
				MenuApp.stage.close();
			} catch (Exception cad1) {
				cad1.printStackTrace();
			}

		});
		sub2.setOnAction(cad -> {
			try {
				new VeiculoApp().start(new Stage());
				MenuApp.stage.close();
			} catch (Exception cad1) {
				cad1.printStackTrace();
			}

		});

		sub10.setOnAction(ger -> {
			try {
				new GerenciaCteApp().start(new Stage());
				MenuApp.stage.close();
			} catch (Exception ger1) {
				ger1.printStackTrace();
			}

		});

		sub12.setOnAction(mdfe -> {
			try {
				new ManifestoApp().start(new Stage());
				MenuApp.stage.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		sub13.setOnAction(mdfe -> {
			try {
				new GerenciaMdfeApp().start(new Stage());
				MenuApp.stage.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}

}
