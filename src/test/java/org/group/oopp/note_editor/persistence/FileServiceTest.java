/* (C)2026 */
package org.group.oopp.note_editor.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileServiceTest {

    @Test
    void savesAndLoadsNotes(@TempDir Path directory) throws IOException {
        FileService service = new FileService();
        Path file = directory.resolve("notes.txt");
        String text = "TODO Köp mjölk\nDUE 2026/12/01\n";

        service.saveFile(file, text);

        assertEquals(text, Files.readString(file));
        assertEquals(text, service.loadFile(file));
    }

    @Test
    void savesAndLoadsEmptyText(@TempDir Path directory) throws IOException {
        FileService service = new FileService();
        Path file = directory.resolve("empty.txt");

        service.saveFile(file, "");

        assertEquals("", service.loadFile(file));
    }

    @Test
    void replacesExistingContent(@TempDir Path directory) throws IOException {
        FileService service = new FileService();
        Path file = directory.resolve("notes.txt");

        service.saveFile(file, "Old meeting notes");
        service.saveFile(file, "New notes");

        assertEquals("New notes", Files.readString(file));
    }

    @Test
    void throwsWhenFileDoesNotExist(@TempDir Path directory) {
        FileService service = new FileService();
        Path file = directory.resolve("missing.txt");

        assertThrows(IOException.class, () -> service.loadFile(file));
    }
}
