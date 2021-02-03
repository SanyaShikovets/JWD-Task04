package by.epam.task04.model.comparator;

import by.epam.task04.model.entity.Sentence;
import by.epam.task04.model.entity.Word;

import java.util.Comparator;

public class SentenceComparator implements Comparator<Sentence> {

    private int countWordsInSentence(Sentence sentence) {
        int count = 0;
        if (sentence != null) {
            for (Word word : sentence.getWords()) {
                if (word != null) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int compare(Sentence o1, Sentence o2) {
        if (countWordsInSentence(o1) < countWordsInSentence(o2)) {
            return -1;
        } else if (countWordsInSentence(o1) == countWordsInSentence(o2)) {
            return 0;
        } else {
            return 1;
        }
    }
}
