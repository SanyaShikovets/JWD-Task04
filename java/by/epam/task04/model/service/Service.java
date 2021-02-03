package by.epam.task04.model.service;

import by.epam.task04.model.entity.Sentence;
import by.epam.task04.model.entity.Text;
import by.epam.task04.model.entity.Word;
import by.epam.task04.model.service.task01.AmountSentencesWithRepeatWords;
import by.epam.task04.model.service.task02.SentenceIncrementByCountWord;
import by.epam.task04.model.service.task03.WordsOFFirstSentenceWhichNotInOtherSentences;
import by.epam.task04.model.service.task04.SearchWordGivenLengthInInterrogativeSentences;
import by.epam.task04.model.service.task05.ChangePlaceFirstAndLastWordInSentences;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Service {

    public void outputIncrementListOfSentences(Text text){
        SentenceIncrementByCountWord sentenceIncrementByCountWord = new SentenceIncrementByCountWord();
        ArrayList<Sentence> sortSentences = new ArrayList<>(sentenceIncrementByCountWord.getIncrementListOfSentences(text));
        for(Sentence sentence : sortSentences){
            System.out.println(sentence);
        }
    }

    public void outputListOfWordsThatOnlyInFirstSentence(Text text){
        WordsOFFirstSentenceWhichNotInOtherSentences wordsOFFirstSentenceWhichNotInOtherSentences = new WordsOFFirstSentenceWhichNotInOtherSentences();
        List<Word> foundWords = new ArrayList<>(wordsOFFirstSentenceWhichNotInOtherSentences.getFoundWords(text));
        for(Word word : foundWords){
            System.out.println(word);
        }
    }

    public void outputAmountSentencesWithRepeatWords(Text text){
        AmountSentencesWithRepeatWords amountSentencesWithRepeatWords = new AmountSentencesWithRepeatWords();
        int amount = amountSentencesWithRepeatWords.getAmountSentences(text);
        System.out.println(amount);
    }

    public void outputWordsGivenLengthInInterrogativeSentences(Text text, int givenLength){
        SearchWordGivenLengthInInterrogativeSentences searchWordGivenLengthInInterrogativeSentences = new SearchWordGivenLengthInInterrogativeSentences();
        Set<Word> words = searchWordGivenLengthInInterrogativeSentences.getFoundWords(text, givenLength);
        for(Word word : words){
            System.out.println(word);
        }
    }

    public void outputChangedTextFirstAndLastWords(Text text){
        ChangePlaceFirstAndLastWordInSentences changePlaceFirstAndLastWordInSentences = new ChangePlaceFirstAndLastWordInSentences();
        changePlaceFirstAndLastWordInSentences.changePlace(text);
        for(Sentence sentence : text.getSentences()){
            System.out.println(sentence);
        }
    }
}
