package com.Akkaoui.cms.car;

import java.util.Set;

public final class Car {

    private final String model;
    private final EngineType engine;
    private final Transmission transmission;
    private final Set<String> interior;
    private final Set<String> exterior;
    private final Set<String> safety;

    public Car(
            String model,
            EngineType engine,
            Transmission transmission,
            Set<String> interior,
            Set<String> exterior,
            Set<String> safety
    ) {
        this.model = model;
        this.engine = engine;
        this.transmission = transmission;
        this.interior = Set.copyOf(interior);
        this.exterior = Set.copyOf(exterior);
        this.safety = Set.copyOf(safety);
    }

    public String model() { return model; }
    public EngineType engine() { return engine; }
    public Transmission transmission() { return transmission; }
    public Set<String> interior() { return interior; }
    public Set<String> exterior() { return exterior; }
    public Set<String> safety() { return safety; }
}
