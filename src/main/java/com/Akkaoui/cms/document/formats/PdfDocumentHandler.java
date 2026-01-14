package com.Akkaoui.cms.document.formats;

import com.Akkaoui.cms.document.Document;
import com.Akkaoui.cms.document.spi.DocumentHandler;

import java.nio.charset.StandardCharsets;

public final class PdfDocumentHandler implements DocumentHandler {

    @Override
    public String formatKey() {
        return "pdf";
    }

    @Override
    public byte[] save(Document doc) {
        // Demo serialization (NOT a real PDF)
        String payload = "PDF\nTITLE:" + doc.title() + "\n" + doc.content();
        return payload.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String render(Document doc) {
        return "[PDF Preview]\n" + doc.title() + "\n" + doc.content();
    }
}
