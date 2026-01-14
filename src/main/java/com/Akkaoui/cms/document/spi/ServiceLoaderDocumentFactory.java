package com.Akkaoui.cms.document.spi;

import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public final class ServiceLoaderDocumentFactory implements DocumentFactory {

    private final Map<String, DocumentHandler> handlers;

    public ServiceLoaderDocumentFactory() {
        this.handlers = ServiceLoader.load(DocumentHandler.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toUnmodifiableMap(
                        h -> h.formatKey().toLowerCase(),
                        h -> h
                ));
    }

    @Override
    public DocumentHandler handlerFor(String formatKey) {
        if (formatKey == null || formatKey.isBlank()) {
            throw new IllegalArgumentException("formatKey cannot be blank");
        }

        var key = formatKey.toLowerCase();
        var handler = handlers.get(key);

        if (handler == null) {
            throw new IllegalArgumentException("Unsupported format: " + formatKey);
        }

        return handler;
    }
}
