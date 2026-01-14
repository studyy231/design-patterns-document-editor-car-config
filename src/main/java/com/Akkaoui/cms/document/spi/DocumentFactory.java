package com.Akkaoui.cms.document.spi;

public interface DocumentFactory {
    DocumentHandler handlerFor(String formatKey);
}
