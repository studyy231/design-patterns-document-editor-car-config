package com.Akkaoui.cms.app;

import com.Akkaoui.cms.document.Editor;
import com.Akkaoui.cms.document.TextDocument;
import com.Akkaoui.cms.document.spi.ServiceLoaderDocumentFactory;
import com.Akkaoui.cms.car.CarBuilder;
import com.Akkaoui.cms.car.EngineType;
import com.Akkaoui.cms.car.Transmission;

public final class Main {

    public static void main(String[] args) {

        // ===== Assignment 1: Document Editor =====
        var editor = new Editor(new ServiceLoaderDocumentFactory());
        var doc = new TextDocument("Test Title", "Hello from content");

        System.out.println(editor.preview(doc, "html"));
        System.out.println(editor.preview(doc, "pdf"));
        System.out.println(editor.preview(doc, "word"));

        // ===== Assignment 2: Car Configuration (Builder) =====
        var car = new CarBuilder()
                .model("BMW M3")
                .engine(EngineType.V8)
                .transmission(Transmission.AUTOMATIC)
                .addInterior("Leather seats")
                .addInterior("GPS")
                .addExterior("Black color")
                .addSafety("Airbags")
                .build();

        System.out.println(
                "Configured car: "
                        + car.model() + ", "
                        + car.engine() + ", "
                        + car.transmission()
        );
    }
}
