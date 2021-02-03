package by.epam.task04.model.service.task03;

import by.epam.task04.model.entity.Sentence;
import by.epam.task04.model.entity.Text;
import by.epam.task04.model.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class WordsOFFirstSentenceWhichNotInOtherSentences {

    private List<Word> foundWords;

    public WordsOFFirstSentenceWhichNotInOtherSentences(){
        foundWords = new ArrayList<>();
    }

    public boolean isWordHasInSentences(List<Sentence> sentences, Word searchWord){
        for(int i = 1; i < sentences.size(); i++) {
            for (Word word : sentences.get(i).getWords()) {
                if (word.equals(searchWord))
                    return false;
            }
        }
        return true;
    }

    public List<Word> getFoundWords(Text text){
        List<Sentence> sentences = text.getSentences();
        for(Word searchWord : sentences.get(0).getWords()){
            if(isWordHasInSentences(sentences, searchWord))
                foundWords.add(searchWord);
        }
        return foundWords;
    }
}
