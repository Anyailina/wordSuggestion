package org.annill.wordsuggestion.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.annill.wordsuggestion.controller.WordSuggestionController;
import org.annill.wordsuggestion.dto.WordSuggestionDto;
import org.annill.wordsuggestion.entity.WordSuggestion;
import org.annill.wordsuggestion.utils.Utils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {
    private final WordSuggestionController wordSuggestionController;
    private final String topicName = "addWord";
    private final String groupId = "word";

    @KafkaListener(topics = topicName, groupId = groupId)
    public void listen( WordTranslation wordTranslation) {
       wordSuggestionController.addWord(wordTranslation.getWord(), wordTranslation.getTranslation());
    }
}
