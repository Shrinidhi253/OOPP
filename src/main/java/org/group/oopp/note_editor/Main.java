package org.group.oopp.note_editor;
import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws IOException {
    Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("/org/group/oopp/note_editor/view/TextArea.FXML"))
    );

    Scene scene = new Scene(root);

    stage.setTitle("Text Editor");
    stage.setScene(scene);
    stage.setMaximized(true); //Opens the text window full screen. Also keeps the title bar and task bar.
    stage.show();
  }
}
