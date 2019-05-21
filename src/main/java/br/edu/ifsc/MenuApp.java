package br.edu.ifsc;

import org.kordamp.bootstrapfx.scene.layout.Panel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MenuApp extends Application {

	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Panel panel = new Panel(Strings.lblSubFrase);

		Menu m1 = new Menu(Strings.menuCadastro);
		Menu m2 = new Menu(Strings.menuTransporte);
		Menu m3 = new Menu(Strings.menuFrete);
		Menu m4 = new Menu(Strings.menuSaida);
		Menu m5 = new Menu(Strings.menuRelatorio);
		Menu m6 = new Menu(Strings.menuMapa);
		Menu m7 = new Menu(Strings.menuExit);
		Menu m = new Menu("                  ");

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(m1, m2, m3, m4, m5, m6, m, m7);

		MenuItem sub1 = new MenuItem(Strings.sub1);
		MenuItem sub2 = new MenuItem(Strings.sub2);
		MenuItem sub3 = new MenuItem(Strings.sub3);
		MenuItem sub4 = new MenuItem(Strings.sub4);
		MenuItem sub5 = new MenuItem(Strings.sub5);
		MenuItem sub6 = new MenuItem(Strings.sub6);
		MenuItem sub7 = new MenuItem(Strings.sub7);
		MenuItem sub8 = new MenuItem(Strings.sub8);
		MenuItem sub9 = new MenuItem(Strings.sub9);
		MenuItem sub10 = new MenuItem(Strings.sub10);
		MenuItem sub11 = new MenuItem(Strings.sub11);
		MenuItem sub12 = new MenuItem(Strings.sub12);
		MenuItem sub13 = new MenuItem(Strings.sub13);
		MenuItem sub14 = new MenuItem(Strings.sub14);
		MenuItem sub15 = new MenuItem(Strings.sub15);
		MenuItem sub16 = new MenuItem(Strings.sub16);
		MenuItem sub17 = new MenuItem(Strings.sub17);
		MenuItem sub18 = new MenuItem(Strings.sub18);
		MenuItem sub19 = new MenuItem(Strings.sub19);
		MenuItem sub20 = new MenuItem(Strings.sub20);

		m1.getItems().addAll(sub1, sub2, sub3);
		m2.getItems().addAll(sub4, sub5, sub6, sub7, sub8);
		m4.getItems().addAll(sub9, sub10, sub11, sub12, sub13, sub14);
		m5.getItems().addAll(sub17, sub18, sub19, sub20);
		m7.getItems().addAll(sub15, sub16);

		Scene scene = new Scene(panel, 600, 450);
		scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
		menuBar.getStyleClass().addAll("split-menu-btn", "btn-info");
		panel.setLeft(menuBar);
		panel.getStyleClass().addAll("b", "panel-primary");
		Image appIcon = new Image(getClass().getResourceAsStream("truck.png"));
		stage.getIcons().add(appIcon);
		stage.setScene(scene);
		stage.setTitle(Strings.appMenu);
		stage.setResizable(false);
		stage.show();
		MenuApp.stage = stage;

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
	}
}
