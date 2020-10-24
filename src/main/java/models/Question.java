package models;

import lombok.Data;

import java.util.List;

@Data
public class Question {

    private Long id;

    private String question;

    private String clarification;

    private String type;

    private String query;

    private List<Step> steps;

    private List<String> links;
}
