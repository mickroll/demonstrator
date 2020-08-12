package demonstrator;

import java.util.HashMap;
import java.util.Map;

public class DemonstratorTargetEmbedded {

    private String version;

    private Map<String, String> metadata = new HashMap<>();

    public DemonstratorTargetEmbedded() {
    }

    @Default
    public DemonstratorTargetEmbedded(String version, Map<String, String> metadata) {
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
