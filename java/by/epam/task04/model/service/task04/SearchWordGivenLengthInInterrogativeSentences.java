package by.epam.task04.model.service.task04;

import by.epam.task04.model.entity.PunctuationMark;
import by.epam.task04.model.entity.Sentence;
import by.epam.task04.model.entity.Text;
import by.epam.task04.model.entity.Word;

import java.util.HashSet;
import java.util.Set;

public class SearchWordGivenLengthInInterrogativeSentences {

    private final String QUESTION_MARK = "?";
    private Set<Word> foundWords;

    public SearchWordGivenLengthInInterrogativeSentences(){
        foundWords = new HashSet<>();
    }

    public void addWordsGivenLength(Sentence sentence, int givenLength){
        for(Word word : sentence.getWords()){
            if(word.getLength() == givenLength){
                foundWords.add(word);
            }
        }
    }

    public Set<Word> getFoundWords(Text text, int givenLength){
        for(Sentence sentence : text.getSentences()){
            for(PunctuationMark punctuationMark : sentence.getPunctuationMarks()){
                if(punctuationMark.equals(new PunctuationMark(QUESTION_MARK))){
                    addWordsGivenLength(sentence, givenLength);
                }
            }
        }
        return foundWords;
    }
}
