package com.speakiv.socialservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="languages")
public class Language {
    @Id
    private Long id;
    private String languageName;
    private String languageCode;
}
