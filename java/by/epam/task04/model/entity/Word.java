package by.epam.task04.model.entity;

import lombok.*;

import java.io.Serializable;

@Data
public class Word implements Serializable {

    @NonNull
    private String contentWord;

    public int getLength() {
        return contentWord.length();
    }
}

