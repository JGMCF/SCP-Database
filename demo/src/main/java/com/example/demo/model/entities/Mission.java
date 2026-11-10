package com.example.demo.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.example.demo.model.enums.StatusType;
import jakarta.persistence.*;

@Entity
@Table(name = "mission")
public class Mission {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long missionId;

    @Column(name = "mission_date", nullable = false)
    private LocalDate missionDate = LocalDate.now();

    @Column(name = "location_latitude", precision = 11, scale = 8)
    private BigDecimal locationLatitude;

    @Column(name = "location_longitude", precision = 11, scale = 8)
    private BigDecimal locationLongitude;

    @Enumerated(EnumType.STRING)
    @Column(name = "mission_status", nullable = false, columnDefinition = "status_t")
    private StatusType missionStatus;

    @Column(name = "total_casualties")
    private int totalCasualties;

    @Column(name = "description", length = 400)
    private String description;

    // Construtor vazio obrigatório pelo JPA
    public Mission() {}

    // Construtor com parâmetros úteis
    public Mission(LocalDate missionDate, BigDecimal locationLatitude, BigDecimal locationLongitude, StatusType missionStatus, int totalCasualties, String description) {
        this.missionDate = missionDate;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.missionStatus = missionStatus;
        this.totalCasualties = totalCasualties;
        this.description = description;
    }

    // Getters e Setters
    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public LocalDate getMissionDate() {
        return missionDate;
    }

    public void setMissionDate(LocalDate missionDate) {
        this.missionDate = missionDate;
    }

    public BigDecimal getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(BigDecimal locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public BigDecimal getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(BigDecimal locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public StatusType getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(StatusType missionStatus) {
        this.missionStatus = missionStatus;
    }

    public int getTotalCasualties() {
        return totalCasualties;
    }

    public void setTotalCasualties(int totalCasualties) {
        this.totalCasualties = totalCasualties;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}