package org.group.oopp.note_editor.model;

import org.group.oopp.note_editor.model.TagParser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TagParserTest
{
    @DisplayName("Single Word Tag Parse Test")
    @ParameterizedTest(name = "The sting {0} was not parsed correctly")
    @ValueSource(strings = {"TODO"})
    void SingleWordTagParse(String text)
    {
        TagParser.init();
        TagParser.FullParseResult result = TagParser.Parse(text);
        assertEquals(1, result.tags.size());
        assertEquals(1, result.segments.size());
        assertTrue(result.segments.get(0).getText().equals(text));
        assertTrue(result.segments.get(0).getTag().isPresent());
    }

    @DisplayName("Simple Note Example Parsing Test")
    @Test
    void SimpleNoteExampleParsingTest()
    {
        String text = "TODO This is the main body of note 1";
        TagParser.FullParseResult result = TagParser.Parse(text);
        assertEquals(1, result.tags.size());
        assertTrue(result.tags.get(0) == Tag.TODO);
        
        StringBuilder sb = new StringBuilder();
        for (TextSegment seg : result.segments)
        {
            sb.append(seg.getText());
        }
        assertTrue(sb.toString().equals(text));
    }
}
