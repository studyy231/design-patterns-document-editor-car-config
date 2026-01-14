package com.Akkaoui.cms.car;


import java.util.HashSet;
import java.util.Set;

public final class CarBuilder {

    private String model;
    private EngineType engine;
    private Transmission transmission;
    private final Set<String> interior = new HashSet<>();
    private final Set<String> exterior = new HashSet<>();
    private final Set<String> safety = new HashSet<>();

    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder engine(EngineType engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder transmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarBuilder addInterior(String feature) {
        interior.add(feature);
        return this;
    }

    public CarBuilder addExterior(String feature) {
        exterior.add(feature);
        return this;
    }

    public CarBuilder addSafety(String feature) {
        safety.add(feature);
        return this;
    }

    public Car build() {
        if (model == null || model.isBlank()) {
            throw new IllegalStateException("Model is required");
        }
        if (engine == null) {
            throw new IllegalStateException("Engine is required");
        }
        if (transmission == null) {
            throw new IllegalStateException("Transmission is required");
        }

        return new Car(model, engine, transmission, interior, exterior, safety);
    }
}
