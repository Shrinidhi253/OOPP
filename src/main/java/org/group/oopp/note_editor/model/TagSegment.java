package org.group.oopp.note_editor.model;

import java.util.Optional;

public class TagSegment extends TextSegment
{
    private Tag tag;

    public TagSegment(Tag tag, final String text)
    {
        super(text);
        this.tag = tag;
    }
    
    public Optional<Tag> getTag()
    {
        return Optional.of(tag);
    }
}
