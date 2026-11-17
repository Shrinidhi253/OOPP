package org.group.oopp.note_editor;

import static com.raylib.Raylib.*;

import org.group.oopp.note_editor.controller.Controller;
import org.group.oopp.note_editor.model.Model;
import org.group.oopp.note_editor.view.View;

public class Main {
  private static final int SCREEN_WIDTH = 800;
  private static final int SCREEN_HEIGHT = 450;
  private static final int FRAMES_PER_SECOND = 60;
  private static final String TITLE = "Group22";

  public static void main(String[] args) {
    InitWindow(SCREEN_WIDTH, SCREEN_HEIGHT, TITLE);
    SetTargetFPS(FRAMES_PER_SECOND);

    Model model = new Model();
    View view = new View(model);
    Controller controller = new Controller(model);

    while (!WindowShouldClose()) {
      model.update(GetFrameTime());
      view.update();
      controller.update();
    }

    CloseWindow();
  }
}
