package program.GUI;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.application.Application;

public class GUITesting extends Application {
    public static void main(String args[]) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        stage.setTitle("Unova Location Data Parser");
        gridPane.add(GUIFactory.gameVersionLabel(), 0, 0);
        gridPane.add(GUIFactory.gameVersionDropdown(), 0, 1);
        gridPane.add(GUIFactory.encounterTypeLabel(), 1, 0);
        gridPane.add(GUIFactory.encounterTypeDropdown(), 1, 1);
        gridPane.add(GUIFactory.modifierLabel(), 2, 0);
        gridPane.add(GUIFactory.modifierDropdown(), 2, 1);

        Scene scene = new Scene(gridPane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
