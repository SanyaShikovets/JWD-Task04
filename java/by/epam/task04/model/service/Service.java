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

    public List<Sentence> outputIncrementListOfSentences(Text text){
        SentenceIncrementByCountWord sentenceIncrementByCountWord = new SentenceIncrementByCountWord();
        List<Sentence> sortSentences = new ArrayList<>(sentenceIncrementByCountWord.getIncrementListOfSentences(text));
        return sortSentences;
    }

    public List<Word> outputListOfWordsThatOnlyInFirstSentence(Text text){
        WordsOFFirstSentenceWhichNotInOtherSentences wordsOFFirstSentenceWhichNotInOtherSentences = new WordsOFFirstSentenceWhichNotInOtherSentences();
        List<Word> foundWords = new ArrayList<>(wordsOFFirstSentenceWhichNotInOtherSentences.getFoundWords(text));
        return foundWords;
    }

    public int outputAmountSentencesWithRepeatWords(Text text){
        AmountSentencesWithRepeatWords amountSentencesWithRepeatWords = new AmountSentencesWithRepeatWords();
        int amount = amountSentencesWithRepeatWords.getAmountSentences(text);
        return amount;
    }

    public Set<Word> outputWordsGivenLengthInInterrogativeSentences(Text text, int givenLength){
        SearchWordGivenLengthInInterrogativeSentences searchWordGivenLengthInInterrogativeSentences = new SearchWordGivenLengthInInterrogativeSentences();
        Set<Word> words = searchWordGivenLengthInInterrogativeSentences.getFoundWords(text, givenLength);
        return words;
    }

    public List<Sentence> outputChangedTextFirstAndLastWords(Text text){
        ChangePlaceFirstAndLastWordInSentences changePlaceFirstAndLastWordInSentences = new ChangePlaceFirstAndLastWordInSentences();
        changePlaceFirstAndLastWordInSentences.changePlace(text);
        return text.getSentences();
    }
}
