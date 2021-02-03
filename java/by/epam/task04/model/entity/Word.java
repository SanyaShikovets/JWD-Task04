package by.epam.task04.model.entity;

import lombok.*;

@Data
public class Word {

    @NonNull
    private String contentWord;

    public int getLength() {
        return contentWord.length();
    }
}

