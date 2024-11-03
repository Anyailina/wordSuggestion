package org.annill.wordsuggestion.repository;

import org.annill.wordsuggestion.entity.WordSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WordSuggestionRepository extends JpaRepository<WordSuggestion, Long> {

    List<WordSuggestion> findByPhrase(String phrase);

    Optional<WordSuggestion> findFirstByPhrase(String phrase);
}
