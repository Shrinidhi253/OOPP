package org.group.oopp.note_editor.model;

import org.group.oopp.note_editor.model.Tag;

import java.util.Optional;

public abstract class TextSegment
{
    protected String text;
    
    protected TextSegment(final String text)
    {
        this.text = text;
    }

    // Returns a Tag if one is associated with the segment type
    public abstract Optional<Tag> getTag();

    // Returns the text contained within the segment
    public String getText()
    {
        return text;
    }

    public int getLength()
    {
        return text.length();
    }
}
