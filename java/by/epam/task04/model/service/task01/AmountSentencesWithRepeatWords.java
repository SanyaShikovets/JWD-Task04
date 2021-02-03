package by.epam.task04.model.service.task01;

import by.epam.task04.model.entity.Sentence;
import by.epam.task04.model.entity.Text;
import by.epam.task04.model.entity.Word;

public class AmountSentencesWithRepeatWords {

    private int count = 0;

    public boolean isWordHasRepeat(Word searchWord, Sentence sentence) {
        int amount = 0;
        for (Word word : sentence.getWords()) {
            if (word.equals(searchWord))
                amount++;
        }
        return amount > 1;
    }

    public int getAmountSentences(Text text){
        for(Sentence sentence : text.getSentences()){
            for(Word word : sentence.getWords()){
                if(isWordHasRepeat(word, sentence)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
