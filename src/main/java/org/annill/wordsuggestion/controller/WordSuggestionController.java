package org.annill.wordsuggestion.controller;

import lombok.AllArgsConstructor;
import org.annill.wordsuggestion.dto.WordSuggestionDto;
import org.annill.wordsuggestion.service.WordSuggestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WordSuggestionController {
    private WordSuggestionService wordSuggestionService;

    public void addWord(String phrase,String translation) {
         wordSuggestionService.addWord(phrase,translation);
    }

    @PostMapping
    @RequestMapping("/words")
    public List<WordSuggestionDto> getWords(@RequestBody  WordSuggestionDto wordSuggestionDto) {
        return wordSuggestionService.getWords(wordSuggestionDto.getPhrase());
    }
}
