package com.Akkaoui.cms.document.formats;

import com.Akkaoui.cms.document.Document;
import com.Akkaoui.cms.document.spi.DocumentHandler;

import java.nio.charset.StandardCharsets;

public final class HtmlDocumentHandler implements DocumentHandler {

    @Override
    public String formatKey() {
        return "html";
    }

    @Override
    public byte[] save(Document doc) {
        String html =
                "<html><head><title>" + escape(doc.title()) + "</title></head>" +
                        "<body><h1>" + escape(doc.title()) + "</h1><p>" +
                        escape(doc.content()) +
                        "</p></body></html>";
        return html.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String render(Document doc) {
        return new String(save(doc), StandardCharsets.UTF_8);
    }

    private String escape(String s) {
        return s.replace("&","&amp;")
                .replace("<","&lt;")
                .replace(">","&gt;");
    }
}
