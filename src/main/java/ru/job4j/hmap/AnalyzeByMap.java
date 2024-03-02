package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int amount = 0;
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                amount++;
            }
        }
        score /= amount;
        return score;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> scores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int amount = 0;
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                amount++;
            }
            score /= amount;
            scores.add(new Label(pupil.name(), score));
        }
        return scores;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        /*Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int amount = temp.getOrDefault(subject.name(), 0);
                temp.put(subject.name(), subject.score() + amount);
            }
        }
        List<Label> subjectScore = new ArrayList<>();
        for (String subject : temp.keySet()) {
            subjectScore.add(new Label(subject, temp.get(subject) / pupils.size()));
        }
        return subjectScore;*/
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
              temp.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> subjectScore = new ArrayList<>();
        temp.forEach((subject, score) -> subjectScore.add(new Label(subject, score / pupils.size())));
        return subjectScore;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> students = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                students.add(new Label(pupil.name(), score));
            }
        }
        students.sort(Comparator.naturalOrder());
        return students.get(students.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        /*Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = temp.getOrDefault(subject.name(), 0);
                temp.put(subject.name(), score + subject.score());
            }
        }
        List<Label> subjectScore = new ArrayList<>();
        for (String subject : temp.keySet()) {
            subjectScore.add(new Label(subject, temp.get(subject)));
        }
        subjectScore.sort(Comparator.naturalOrder());
        return subjectScore.get(subjectScore.size() - 1);*/
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil :pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> subjectScore = new ArrayList<>();
        for (String subject : temp.keySet()) {
            subjectScore.add(new Label(subject, temp.get(subject)));
        }
        subjectScore.sort(Comparator.naturalOrder());
        return subjectScore.get(subjectScore.size() - 1);
    }
}
