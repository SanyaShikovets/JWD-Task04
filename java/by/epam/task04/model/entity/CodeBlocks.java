package by.epam.task04.model.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class CodeBlocks implements Serializable {

    @NonNull
    private String content;
}
