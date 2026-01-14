package com.Akkaoui.cms.app;

import com.Akkaoui.cms.document.Editor;
import com.Akkaoui.cms.document.TextDocument;
import com.Akkaoui.cms.document.spi.ServiceLoaderDocumentFactory;

public final class Main {
    public static void main(String[] args) {
        var editor = new Editor(new ServiceLoaderDocumentFactory());
        var doc = new TextDocument("Test Title", "Hello from content");

        System.out.println(editor.preview(doc, "html"));
        System.out.println(editor.preview(doc, "pdf"));
        System.out.println(editor.preview(doc, "word"));
    }
}
