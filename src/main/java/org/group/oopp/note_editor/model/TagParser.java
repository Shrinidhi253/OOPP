package org.group.oopp.note_editor.model;

import org.group.oopp.note_editor.model.Tag;
import org.group.oopp.note_editor.model.TextSegment;


import java.util.ArrayList;
import java.util.Optional;

// This class is a singleton since it's designed to be stateless, only really being a container for the Parse method.
public class TagParser
{
    // This is an interface packet between the TagParser and the TextModel, DO NOT CHANGE.
    // The reason why this is called FullParseResult and not just ParseResult is because partial parses might be added later
    public static class FullParseResult
    {
        public ArrayList<Tag> tags;
        public ArrayList<TextSegment> segments;

        public FullParseResult()
        {
            this.tags = new ArrayList<Tag>();
            this.segments = new ArrayList<TextSegment>();
        }
    }

    private static TagParser self = null;

    private TagParser()
    {
    }

    public static TagParser init()
    {
        if (self == null) 
        {
            self = new TagParser();
        }
        return self;
    }

    // Return: length of space character string
    private static Optional<TextSegment> ParseSpaceCharacters(int startPtr, final String text)
    {
        int ptr = startPtr;
        while (ptr < text.length())
        {
            if (!Character.isWhitespace(text.charAt(ptr)))
            {
                break;
            }
            ptr++;
        }
        if (ptr == startPtr) 
        {
            return Optional.empty();
        } else 
        {
            return Optional.of(new SpaceSegment(text.substring(startPtr, ptr + 1)));
        }
    }

    // TODO(TeYo): add specialized parsing for special tags, such as DUE
    private static Optional<TextSegment> ParseTag(int startPtr, final String text)
    {
        int ptr = startPtr;
        StringBuilder sb = new StringBuilder();

        while (ptr < text.length())
        {
            char ch = text.charAt(ptr);
            if (!Character.isUpperCase(ch))
            {
                break;
            }
            sb.append(ch);
            ptr++;
        }
        String str = sb.toString();
        Optional<Tag> maybeTag = Tag.StringToTag(str);
        if (maybeTag.isPresent())
        {
            return Optional.of(new TagSegment(maybeTag.get(), str));
        } else
        {
            return Optional.empty();
        }
    }
    
    private static Optional<TextSegment> ParseWord(int startPtr, final String text)
    {
        int ptr = startPtr;
        while (ptr < text.length())
        {
            if (Character.isWhitespace(text.charAt(ptr)))
            {
                break;
            }
            ptr++;
        }
        if (ptr == startPtr)
        {
            return Optional.empty();
        } else
        {
            return Optional.of(new WordSegment(text.substring(startPtr, ptr)));
        }
    }

    // TODO(TeYo): Add custom exceptions for the tag parser
    private static TextSegment ParseAny(int startPtr, final String text) throws Exception
    {
        Optional<TextSegment> result = ParseSpaceCharacters(startPtr, text);
        if (result.isPresent())
        {
            return result.get();
        }
        result = ParseTag(startPtr, text);
        if (result.isPresent())
        {
            return result.get();
        }
        result = ParseWord(startPtr, text);
        if (result.isPresent())
        {
            return result.get();
        }

        throw new Exception("TagParser: Impossible to reach exception.");
    }

    public static FullParseResult Parse(final String text)
    {
        FullParseResult result = new FullParseResult();

        int ptr = 0;
        while (ptr < text.length())
        {
            TextSegment segment = null;
            // TODO(TeYo): figure out exactly what to do with this shit
            try 
            { 
                segment = ParseAny(ptr, text);
            } catch (Exception e) {};
            Optional<Tag> maybeTag = segment.getTag();
            if (maybeTag.isPresent())
            {
                result.tags.add(maybeTag.get());
            }
            result.segments.add(segment);
            ptr += segment.getLength();
        }

        return result;
    }
}
