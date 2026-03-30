package com.tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "applicants")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPosting job;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String resume_link;

    // getters & setters
    public int getId() { return id; }

    public JobPosting getJob() { return job; }
    public void setJob(JobPosting job) { this.job = job; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getResume_link() { return resume_link; }
    public void setResume_link(String resume_link) { this.resume_link = resume_link; }
}