package com.automacaosuprema.systembackend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sensor_data")
public class SensorData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sensor_value")
    private String sensorValue;

    @Column(name = "sensor_gross_value")
    private String sensorGrossValue;

    private String createdAt;

    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    public SensorData() {
    }

    public SensorData(Long id, String sensorValue, String sensorGrossValue, String createdAt, String updatedAt) {
        this.id = id;
        this.sensorValue = sensorValue;
        this.sensorGrossValue = sensorGrossValue;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(String sensorValue) {
        this.sensorValue = sensorValue;
    }

    public String getSensorGrossValue() {
        return sensorGrossValue;
    }

    public void setSensorGrossValue(String sensorGrossValue) {
        this.sensorGrossValue = sensorGrossValue;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Sensor getSensor() {
        return sensor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SensorData other = (SensorData) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
