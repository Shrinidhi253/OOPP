package org.group.oopp.note_editor.model;

import java.util.Optional;

public class SpaceSegment extends TextSegment
{
    public SpaceSegment(final String text)
    {
        super(text);
    }
    
    public Optional<Tag> getTag()
    {
        return Optional.empty();
    }
}
