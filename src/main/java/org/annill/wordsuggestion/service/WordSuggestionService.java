package org.annill.wordsuggestion.service;

import lombok.AllArgsConstructor;
import org.annill.wordsuggestion.converter.WordSuggestionConvertor;
import org.annill.wordsuggestion.dto.WordSuggestionDto;
import org.annill.wordsuggestion.entity.WordSuggestion;
import org.annill.wordsuggestion.repository.WordSuggestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WordSuggestionService {
    private WordSuggestionRepository wordSuggestionRepository;
    private WordSuggestionConvertor wordSuggestionConvertor;

    public void addWord(String phrase, String translation) {
        if (getWord(phrase) != null) {
            return;
        }
        WordSuggestion wordSuggestion = new WordSuggestion(phrase, translation);
        wordSuggestionRepository.save(wordSuggestion);
    }

    public WordSuggestionDto getWord(String word) {
        return wordSuggestionRepository.findFirstByPhrase(word)
                .map(wordSuggestionConvertor::convert)
                .orElse(null);
    }

    public List<WordSuggestionDto> getWords(String word) {
        return wordSuggestionRepository.findByPhrase(word)
                .stream()
                .map(wordSuggestionConvertor::convert).toList();
    }
}
