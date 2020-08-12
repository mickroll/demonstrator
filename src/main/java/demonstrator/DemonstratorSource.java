package demonstrator;

public class DemonstratorSource {
    private DemonstratorSourceEmbedded embedded;

    public DemonstratorSource() {
    }

    @Default
    public DemonstratorSource(final DemonstratorSourceEmbedded embedded) {
        this.embedded = embedded;
    }

    public DemonstratorSourceEmbedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(final DemonstratorSourceEmbedded embedded) {
        this.embedded = embedded;
    }
}
