package demonstrator;

import org.assertj.core.api.WithAssertions;
import org.assertj.core.util.Maps;
import org.junit.Test;

public class DemonstratorTest implements WithAssertions {

    private static final DemonstratorSourceEmbedded SOURCE_EMBEDDED = new DemonstratorSourceEmbedded("1", Maps.newHashMap("key", "value"));
    private static final DemonstratorSource SOURCE = new DemonstratorSource(SOURCE_EMBEDDED);

    private static final DemonstratorSourceEmbedded UPDATE_SOURCE_EMBEDDED = new DemonstratorSourceEmbedded("2", Maps.newHashMap("key", "new value"));
    private static final DemonstratorSource UPDATE_SOURCE = new DemonstratorSource(UPDATE_SOURCE_EMBEDDED);

    @Test
    public void testCreate_MapperWithExplicitEmbeddedMapping() {
        final DemonstratorMapperWorking mapper = new DemonstratorMapperWorkingImpl();

        final DemonstratorTarget target = mapper.toTarget(SOURCE);

        assertThat(target.getEmbedded()).isNotNull();
        assertThat(target.getEmbedded().getMetadata()).isEqualTo(SOURCE_EMBEDDED.getMetadata());
        assertThat(target.getEmbedded().getVersion()).isEqualTo(SOURCE_EMBEDDED.getVersion());
    }

    @Test
    public void testCreate_MapperWithImplicitEmbeddedMapping() {
        final DemonstratorMapperBroken mapper = new DemonstratorMapperBrokenImpl();

        final DemonstratorTarget target = mapper.toTarget(SOURCE);

        assertThat(target.getEmbedded()).isNotNull();
        assertThat(target.getEmbedded().getMetadata()).isEqualTo(SOURCE_EMBEDDED.getMetadata());
        assertThat(target.getEmbedded().getVersion()).isEqualTo(SOURCE_EMBEDDED.getVersion());
    }

    @Test
    public void testUpdate_MapperWithExplicitEmbeddedMapping() {
        final DemonstratorMapperWorking mapper = new DemonstratorMapperWorkingImpl();
        final DemonstratorTarget target = mapper.toTarget(SOURCE);

        mapper.updateTarget(target, UPDATE_SOURCE);

        assertThat(target.getEmbedded()).isNotNull();
        assertThat(target.getEmbedded().getMetadata()).isEqualTo(UPDATE_SOURCE_EMBEDDED.getMetadata());
        assertThat(target.getEmbedded().getVersion()).isEqualTo(UPDATE_SOURCE_EMBEDDED.getVersion());
    }

    @Test // fails with mapstruct 1.4.0.Beta3
    public void testUpdate_MapperWithImplicitEmbeddedMapping() {
        final DemonstratorMapperBroken mapper = new DemonstratorMapperBrokenImpl();
        final DemonstratorTarget target = mapper.toTarget(SOURCE);

        mapper.updateTarget(target, UPDATE_SOURCE);

        assertThat(target.getEmbedded()).isNotNull();
        assertThat(target.getEmbedded().getMetadata()).isEqualTo(UPDATE_SOURCE_EMBEDDED.getMetadata());
        assertThat(target.getEmbedded().getVersion()).isEqualTo(UPDATE_SOURCE_EMBEDDED.getVersion());
    }
}
