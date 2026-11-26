package org.group.oopp.note_editor.model;

import java.util.Optional;
import java.util.HashMap;


public enum Tag
{
    // TODO(TeYo): actually properly implement custom tags
    TODO("TODO"), DUE("DUE"), CUSTOM("");

    private static HashMap<String, Tag> stringToTagMap;
    private final String stringRepr;

    static {
        stringToTagMap = new HashMap<>();
        AddTagRepr("TODO", TODO);
        AddTagRepr("DUE", DUE);
    }

    private static void AddTagRepr(String str, Tag tag)
    {
        stringToTagMap.put(str, tag);
    }
 
    public static Optional<Tag> StringToTag(final String str)
    {
        return Optional.ofNullable(stringToTagMap.get(str));
    }
 
    private Tag(final String stringRepr)
    {
        this.stringRepr = stringRepr;
    }

    public int index()
    {
        return this.ordinal();
    }

    // The string representation of the tag, this is how the tag is actually written within a note
    public Optional<String> getStringRepr()
    {
        return (stringRepr == "") ? Optional.empty() : Optional.of(stringRepr);
    }
}
