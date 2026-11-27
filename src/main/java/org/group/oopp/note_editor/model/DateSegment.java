package org.group.oopp.note_editor.model;

import java.util.Optional;

// TODO(TeYo): add an actual date representation within this type
public class DateSegment extends TextSegment
{
    public DateSegment(final String text)
    {
        super(text);
    }
    
    public Optional<Tag> getTag()
    {
        return Optional.empty();
    }
}

