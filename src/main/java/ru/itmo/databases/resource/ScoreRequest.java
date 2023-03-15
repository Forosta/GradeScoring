package ru.itmo.databases.resource;


import lombok.Data;

@Data
public class ScoreRequest {
    Integer score;
    String grade;
}
