package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 350, 250);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			Label zrodlo = new Label("ródlo:");
			TextField txt1 = new TextField();
			txt1.setLayoutX(10);
			txt1.setLayoutY(0);
			Button kopiuj = new Button("Kopiuj");
			Label odczyt = new Label("Wynik operacji:");
			TextField txt2 = new TextField();
			txt2.setLayoutX(0);
			txt2.setLayoutY(0);
			Button wykonaj = new Button("Wykonaj");
			VBox left_VBox = new VBox(10);
			left_VBox.getChildren().addAll(zrodlo, txt1, kopiuj, odczyt, txt2, wykonaj);

			Label operacja = new Label("Operacja");
			RadioButton kodowanie = new RadioButton("kodowanie");
			RadioButton dekodowanie = new RadioButton("dekodowanie");
			ToggleGroup tgroup = new ToggleGroup();
			kodowanie.setToggleGroup(tgroup);
			dekodowanie.setToggleGroup(tgroup);
			VBox right_VBox = new VBox(10);
			right_VBox.getChildren().addAll(operacja, kodowanie, dekodowanie);

			wykonaj.setOnAction(event -> {
				if (kodowanie.isSelected()) {
					txt2.setText(RLE.encode(txt1.getText()));
				}
				if (dekodowanie.isSelected()) {
					txt2.setText(RLE.decode(txt1.getText()));
				}
			});

			kopiuj.setOnAction(event ->{
				txt1.setText(txt2.getText());
				txt2.clear();
			});

			root.setRight(right_VBox);
			root.setLeft(left_VBox);
			primaryStage.setTitle("Zadanie domowe");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
