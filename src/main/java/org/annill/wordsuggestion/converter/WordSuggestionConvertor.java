package org.annill.wordsuggestion.converter;

import org.annill.wordsuggestion.dto.WordSuggestionDto;
import org.annill.wordsuggestion.entity.WordSuggestion;
import org.springframework.stereotype.Component;

@Component
public class WordSuggestionConvertor {

    public WordSuggestionDto convert(WordSuggestion wordSuggestion) {
        return new WordSuggestionDto(wordSuggestion.getPhrase(), wordSuggestion.getTranslation());
    }

    public WordSuggestion convert(WordSuggestionDto wordSuggestionDto) {
        return new WordSuggestion(wordSuggestionDto.getPhrase(), wordSuggestionDto.getTranslation());
    }
}
