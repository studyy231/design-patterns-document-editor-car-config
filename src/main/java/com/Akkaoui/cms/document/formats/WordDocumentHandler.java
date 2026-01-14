package com.Akkaoui.cms.document.formats;

import com.Akkaoui.cms.document.Document;
import com.Akkaoui.cms.document.spi.DocumentHandler;

import java.nio.charset.StandardCharsets;

public final class WordDocumentHandler implements DocumentHandler {

    @Override
    public String formatKey() {
        return "word";
    }

    @Override
    public byte[] save(Document doc) {
        // Demo serialization (NOT a real .docx)
        String payload = "WORD\nTITLE:" + doc.title() + "\n" + doc.content();
        return payload.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String render(Document doc) {
        return "[Word Preview]\n" + doc.title() + "\n" + doc.content();
    }
}
