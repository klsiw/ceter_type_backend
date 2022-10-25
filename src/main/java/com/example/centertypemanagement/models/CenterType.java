package com.example.centertypemanagement.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="center_type")
public class CenterType {

    @Id
    @Column(name="center_type_id")
    private Integer centerTypeId;

    @Size(max=250)
    @Column(name="center_type_name", length = 250)
    private String centerTypeName;

}
