package com.Akkaoui.cms.document;

import com.Akkaoui.cms.document.spi.ServiceLoaderDocumentFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorTest {

    @Test
    void previewHtmlContainsHtmlTag() {
        var editor = new Editor(new ServiceLoaderDocumentFactory());
        var doc = new TextDocument("T", "C");

        String html = editor.preview(doc, "html");

        assertTrue(html.contains("<html>"));
        assertTrue(html.contains("T"));
        assertTrue(html.contains("C"));
    }

    @Test
    void unsupportedFormatThrows() {
        var editor = new Editor(new ServiceLoaderDocumentFactory());
        var doc = new TextDocument("T", "C");

        assertThrows(IllegalArgumentException.class, () -> editor.preview(doc, "xlsx"));
    }
}
