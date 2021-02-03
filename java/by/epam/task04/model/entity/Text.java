package by.epam.task04.model.entity;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Text {

    @NonNull
    private List<Sentence> sentences = new ArrayList<>();

    @NonNull
    private List<CodeBlocks> codeBlocks = new ArrayList<>();
}
