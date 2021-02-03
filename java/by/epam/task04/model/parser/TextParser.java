package by.epam.task04.model.parser;

import by.epam.task04.model.entity.CodeBlocks;
import by.epam.task04.model.entity.Sentence;
import by.epam.task04.model.entity.Text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    public Text splittingToSentencesAndCodeBlocks(String text) {
        Text obj = new Text();
        ArrayList<Sentence> sentences = new ArrayList<>();
        Pattern patternSentence = Pattern.compile("[А-Я|A-Z][^.!?]+[.!?]");
        Matcher matcherSentence = patternSentence.matcher(text);
        while (matcherSentence.find()) {
            sentences.add(new Sentence(matcherSentence.group()));
        }
        obj.setSentences(sentences);

        ArrayList<CodeBlocks> codeBlocks = new ArrayList<>();
        Pattern patternCodeBlocks = Pattern.compile("<code>.+<code>");
        Matcher matcherCodeBlocks = patternCodeBlocks.matcher(text);
        while (matcherCodeBlocks.find()) {
            codeBlocks.add(new CodeBlocks(matcherCodeBlocks.group()));
        }
        obj.setCodeBlocks(codeBlocks);
        return obj;
    }
}
