/* (C)2026 */
package org.group.oopp.note_editor.persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {

    public void saveFile(Path path, String text) throws IOException {
        Files.writeString(path, text, StandardCharsets.UTF_8);
    }

    public String loadFile(Path path) throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }
}
