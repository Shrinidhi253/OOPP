package org.group.oopp.note_editor.model;

import java.util.Optional;

public class WordSegment extends TextSegment
{
    public WordSegment(final String text)
    {
        super(text);
    }
    
    public Optional<Tag> getTag()
    {
        return Optional.empty();
    }
}

