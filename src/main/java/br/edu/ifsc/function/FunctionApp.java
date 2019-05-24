package br.edu.ifsc.function;

import javafx.stage.Stage;

public interface FunctionApp {

	public void start(Stage stage) throws Exception;

	public void components();

	public void listeners();

	public void layout();

}
