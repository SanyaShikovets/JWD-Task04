package by.epam.task04.model.service.task05;

import by.epam.task04.model.entity.Sentence;
import by.epam.task04.model.entity.Text;
import by.epam.task04.model.entity.Word;

import java.util.List;

public class ChangePlaceFirstAndLastWordInSentences {

    public void changePlace(Text text) {
        List<Sentence> sentences = text.getSentences();
        List<Word> words;
        Word wordBuffer;
        int lastElementOfList;
        for (Sentence sentence : sentences) {
            words = sentence.getWords();
            wordBuffer = words.get(0);
            lastElementOfList = words.size() - 1;
            words.set(0, words.get(lastElementOfList));
            words.set(lastElementOfList, wordBuffer);
        }
    }
}
