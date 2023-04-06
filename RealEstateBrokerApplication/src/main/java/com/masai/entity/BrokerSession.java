

package com.masai.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BrokerSession {
	@Id
	@Column(unique = true)
	private Integer brokerId;
	private String uuid;
	private LocalDateTime localDateTime;

}
