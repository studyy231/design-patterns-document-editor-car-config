package com.Akkaoui.cms.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarBuilderTest {

    @Test
    void buildsValidCar() {
        var car = new CarBuilder()
                .model("BMW M3")
                .engine(EngineType.V8)
                .transmission(Transmission.AUTOMATIC)
                .addInterior("GPS")
                .build();

        assertEquals("BMW M3", car.model());
        assertEquals(EngineType.V8, car.engine());
        assertEquals(Transmission.AUTOMATIC, car.transmission());
        assertTrue(car.interior().contains("GPS"));
    }

    @Test
    void missingModelThrows() {
        var b = new CarBuilder()
                .engine(EngineType.V6)
                .transmission(Transmission.MANUAL);

        assertThrows(IllegalStateException.class, b::build);
    }

    @Test
    void missingEngineThrows() {
        var b = new CarBuilder()
                .model("X")
                .transmission(Transmission.MANUAL);

        assertThrows(IllegalStateException.class, b::build);
    }

    @Test
    void missingTransmissionThrows() {
        var b = new CarBuilder()
                .model("X")
                .engine(EngineType.V6);

        assertThrows(IllegalStateException.class, b::build);
    }
}
