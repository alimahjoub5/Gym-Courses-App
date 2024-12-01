package com.alimahjoub.GYMAPP.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.Duration;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    private String description;

    private Duration duration; // Durée au format d'intervalle (ex. 1 heure)

    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    private User trainer;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    // Constructeurs, Getters et Setters

    public Course() {}

    public Course(String courseName, String description, Duration duration, User trainer, LocalDateTime startTime, LocalDateTime endTime) {
        this.courseName = courseName;
        this.description = description;
        this.duration = duration;
        this.trainer = trainer;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public Duration getDuration() {
        return duration;
    }

    public User getTrainer() {
        return trainer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
