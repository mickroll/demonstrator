package com.example.reproducer.model;

import java.util.UUID;
import java.sql.Types;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import org.hibernate.annotations.JdbcTypeCode;

@Embeddable
public record PersonId(
        @Column(name = "id", updatable = false, nullable = false, columnDefinition = "CHAR(36)") // explicit name, so we can omit AttributeOverrides
        @Basic
        @JdbcTypeCode(Types.CHAR)
        UUID id
        ) {
}
