package demonstrator;

public class DemonstratorTarget {
    private DemonstratorTargetEmbedded embedded;

    public DemonstratorTarget() {
    }

    @Default
    public DemonstratorTarget(DemonstratorTargetEmbedded embedded) {
        this.embedded = embedded;
    }

    public DemonstratorTargetEmbedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(DemonstratorTargetEmbedded embedded) {
        this.embedded = embedded;
    }
}
