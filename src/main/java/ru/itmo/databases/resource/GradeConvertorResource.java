package ru.itmo.databases.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.databases.service.GradeService;

@RestController
@RequestMapping("/api/grade")
public class GradeConvertorResource {
    private final GradeService gradeService;

    public GradeConvertorResource(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping("/convertPoints")
    public ScoreRequest convertScoreToGrade(@RequestBody ScoreRequest score) {
        // assuming that max points is from 0 to 100
        return gradeService.updateScoreObject(score);
    }
}