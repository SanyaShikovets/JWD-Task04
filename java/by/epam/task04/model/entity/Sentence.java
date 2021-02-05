package by.epam.task04.model.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Sentence implements Serializable {

    @NonNull
    private String content;

    private List<Word> words = new ArrayList<Word>();
    private List<PunctuationMark> punctuationMarks = new ArrayList<PunctuationMark>();

}
