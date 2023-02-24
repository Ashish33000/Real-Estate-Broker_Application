package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerCurrentSession {
    @Id
    @Column(unique = true)
    private Integer customerId;

    private String cid;

    private LocalDateTime time;
}