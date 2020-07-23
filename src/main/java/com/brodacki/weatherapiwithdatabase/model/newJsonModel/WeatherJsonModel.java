package com.brodacki.weatherapiwithdatabase.model.newJsonModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weataher")
public class WeatherJsonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer pressure;

    private Integer temp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "WeatherJsonModel{" +
                "id=" + id +
                ", pressure=" + pressure +
                ", temp=" + temp +
                ", createdAt=" + createdAt +
                '}';
    }
}

