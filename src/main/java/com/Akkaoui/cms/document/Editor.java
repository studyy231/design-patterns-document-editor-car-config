package com.Akkaoui.cms.document;

import com.Akkaoui.cms.document.spi.DocumentFactory;

public final class Editor {
    private final DocumentFactory factory;

    public Editor(DocumentFactory factory) {
        this.factory = factory;
    }

    public byte[] saveAs(Document doc, String formatKey) {
        return factory.handlerFor(formatKey).save(doc);
    }

    public String preview(Document doc, String formatKey) {
        return factory.handlerFor(formatKey).render(doc);
    }
}
