package com.Akkaoui.cms.document.spi;

import com.Akkaoui.cms.document.Document;

public interface DocumentHandler {
    String formatKey();            // "pdf", "word", "html"
    byte[] save(Document doc);     // serialization
    String render(Document doc);   // preview/display
}
