package src.Node.Data;

public enum AgeStage {
    BABY("Bayi"),
    TEEN("Remaja"),
    ADULT("Dewasa");

    private final String stageName;

    AgeStage(String stageName) {
        this.stageName = stageName;
    }

    @Override
    public String toString() {
        return stageName;
    }
}

