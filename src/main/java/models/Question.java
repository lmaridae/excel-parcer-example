package models;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Question {

    private UUID id;

    private String question;

    private String clarification;

    private String type;

    private String query;

    private List<Step> steps;

    private List<String> links;
}
