package by.epam.task04.model.parser;

import by.epam.task04.model.entity.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    public Sentence splittingToWordsAndPunctuationMarks(Sentence sentence) {
        ArrayList<Word> words = new ArrayList<>();
        Pattern patternWords = Pattern.compile("[A-z|А-я]+");
        Matcher matcherWords = patternWords.matcher(sentence.getContent());
        while (matcherWords.find()) {
            words.add(new Word(matcherWords.group()));
        }
        sentence.setWords(words);

        ArrayList<PunctuationMark> punctuationMarks = new ArrayList<>();
        Pattern patternPunctuationMarks = Pattern.compile("[.,!?:;-]");
        Matcher matcherPunctuationMarks = patternPunctuationMarks.matcher(sentence.getContent());
        while (matcherPunctuationMarks.find()) {
            punctuationMarks.add(new PunctuationMark(matcherPunctuationMarks.group()));
        }
        sentence.setPunctuationMarks(punctuationMarks);
        return sentence;
    }
}
