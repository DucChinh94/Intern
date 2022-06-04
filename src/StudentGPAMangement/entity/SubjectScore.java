package StudentGPAMangement.entity;

public class SubjectScore {
    private Subject subject;
    private float score;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "subject=" + subject +
                ", score=" + score +
                '}';
    }
}
