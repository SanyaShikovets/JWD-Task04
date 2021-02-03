package by.epam.task04.controller;

import by.epam.task04.model.entity.CodeBlocks;
import by.epam.task04.model.entity.Sentence;
import by.epam.task04.model.entity.Text;
import by.epam.task04.model.entity.Word;
import by.epam.task04.model.parser.SentenceParser;
import by.epam.task04.model.parser.TextParser;
import by.epam.task04.model.service.Service;

import java.util.ArrayList;

public class Controller {

    public static void main(String[] args) {
        TextParser textParser = new TextParser();
        SentenceParser sentenceParser = new SentenceParser();

        DataReader dataReader = new DataReader();

        Text text = textParser.splittingToSentencesAndCodeBlocks(dataReader.read());

        for(Sentence sentence : text.getSentences()) {
            sentence = sentenceParser.splittingToWordsAndPunctuationMarks(sentence);
        }

        Service service = new Service();
        //service.outputIncrementListOfSentences(text);
        //service.outputListOfWordsThatOnlyInFirstSentence(text);
        //service.outputAmountSentencesWithRepeatWords(text);
        //service.outputWordsGivenLengthInInterrogativeSentences(text, 2);
        service.outputChangedTextFirstAndLastWords(text);
    }
}
