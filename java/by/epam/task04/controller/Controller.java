package by.epam.task04.controller;

import by.epam.task04.model.entity.Sentence;
import by.epam.task04.model.entity.Text;
import by.epam.task04.model.entity.Word;
import by.epam.task04.model.parser.SentenceParser;
import by.epam.task04.model.parser.TextParser;
import by.epam.task04.model.service.Service;

import java.util.List;
import java.util.Set;

public class Controller {

    private Text text;
    private Service service;

    public Controller() {
        TextParser textParser = new TextParser();
        SentenceParser sentenceParser = new SentenceParser();
        DataReader dataReader = new DataReader();
        service = new Service();
        text = textParser.splittingToSentencesAndCodeBlocks(dataReader.read());
        for (Sentence sentence : text.getSentences()) {
            sentence = sentenceParser.splittingToWordsAndPunctuationMarks(sentence);
        }
    }

    public List<Sentence> getIncrementListOfSentences() {
        return service.outputIncrementListOfSentences(text);
    }

    public List<Word> getListOfWordsThatOnlyInFirstSentence() {
        return service.outputListOfWordsThatOnlyInFirstSentence(text);
    }

    public int getAmountSentencesWithRepeatWords() {
        return service.outputAmountSentencesWithRepeatWords(text);
    }

    public Set<Word> getWordsGivenLengthInInterrogativeSentences(int length) {
        return service.outputWordsGivenLengthInInterrogativeSentences(text, length);
    }

    public List<Sentence> getChangedTextFirstAndLastWords() {
        return service.outputChangedTextFirstAndLastWords(text);
    }
}
