package models;

import lombok.Data;

import java.util.UUID;

@Data
public class Step {

    private UUID id;

    private String value;
}
