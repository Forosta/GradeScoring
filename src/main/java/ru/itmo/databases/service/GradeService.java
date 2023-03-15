package ru.itmo.databases.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import ru.itmo.databases.model.Grade;
import ru.itmo.databases.resource.ScoreRequest;

public class GradeService {

    private final KieContainer kieContainer;

    public GradeService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public ScoreRequest updateScoreObject(ScoreRequest scoreRequest) {
        Grade grade = getGrade(scoreRequest);

        scoreRequest.setGrade(grade.getGradePoints());

        return scoreRequest;
    }

    private Grade getGrade(ScoreRequest scoreRequest) {
        Grade grade = new Grade();

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal(Grade.class.getSimpleName(), grade);
        kieSession.insert(scoreRequest);
        kieSession.fireAllRules();
        kieSession.dispose();

        return grade;
    }
}