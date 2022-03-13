package com.speakiv.socialservice.repository;

import com.speakiv.socialservice.model.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Long> {
    Language findLanguageByLanguageCode(String languageCode);
}
