package by.epam.task04.model.service.task02;

import by.epam.task04.model.comparator.SentenceComparator;
import by.epam.task04.model.entity.Sentence;
import by.epam.task04.model.entity.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SentenceIncrementByCountWord {

    private List<Sentence> sortSentences;

    public SentenceIncrementByCountWord(){
        sortSentences = new ArrayList<>();
    }

    public List<Sentence> getIncrementListOfSentences(Text text) {
        sortSentences = text.getSentences();
        Comparator<Sentence> comparator = new SentenceComparator();
        Collections.sort(sortSentences, comparator);
        return sortSentences;
    }
}
