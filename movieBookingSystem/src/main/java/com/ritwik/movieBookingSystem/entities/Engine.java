package com.ritwik.movieBookingSystem.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Engine {

    @Id
    private int engineId;
    private String engineName;
    @OneToOne(mappedBy = "engine")
    private Car car;

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineId=" + engineId +
                ", engineName='" + engineName + '\'' +
                '}';
    }
}
