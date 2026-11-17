package org.group.oopp.note_editor.view;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import org.group.oopp.note_editor.model.Model;
import org.group.oopp.note_editor.model.Model.Position;
import org.group.oopp.note_editor.model.Model.Size;

public class View {
  private final Model model;

  public View(Model model) {
    this.model = model;
  }

  public void update() {
    draw();
  }

  private void draw() {
    BeginDrawing();
    ClearBackground(RAYWHITE);
    Position position = model.getPosition();
    Size size = model.getSize();
    DrawRectangle((int) position.x(), (int) position.y(), size.width(), size.height(), MAROON);
    EndDrawing();
  }
}
