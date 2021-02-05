package by.epam.task04.model.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class PunctuationMark implements Serializable {

    @NonNull
    private String punctuationMark;
}
