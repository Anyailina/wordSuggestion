package org.annill.wordsuggestion.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.annill.wordsuggestion.controller.WordSuggestionController;
import org.annill.wordsuggestion.utils.Utils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {
    private final WordSuggestionController wordSuggestionController;
    private final Utils utils;
    private final String topicName = "addWord";
    private final String groupId = "word";

    @KafkaListener(topics = topicName, groupId = groupId)
    public void listen(String stringJson) throws JsonProcessingException {
        WordTranslation wordTranslation = utils.getObjectMapper().readValue(stringJson, WordTranslation.class);
        wordSuggestionController.addWord(wordTranslation.getWord(), wordTranslation.getTranslation());
    }
}
