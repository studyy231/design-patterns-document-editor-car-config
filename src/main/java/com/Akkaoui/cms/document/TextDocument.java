package com.Akkaoui.cms.document;

import java.util.Objects;

public record TextDocument(String title, String content) implements Document {
    public TextDocument {
        Objects.requireNonNull(title, "title");
        Objects.requireNonNull(content, "content");
    }
}
