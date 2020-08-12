package demonstrator;

import java.util.HashMap;
import java.util.Map;

public class DemonstratorSourceEmbedded {

    private String version;

    private Map<String, String> metadata = new HashMap<>();

    public DemonstratorSourceEmbedded() {
    }

    @Default
    public DemonstratorSourceEmbedded(final String version, final Map<String, String> metadata) {
        this.version = version;
        this.metadata = metadata;
    }

    public String getVersion() {
        return version;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }
}
