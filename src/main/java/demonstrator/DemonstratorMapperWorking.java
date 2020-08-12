package demonstrator;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface DemonstratorMapperWorking {

    DemonstratorTarget toTarget(DemonstratorSource source);

    void updateTarget(@MappingTarget DemonstratorTarget target, DemonstratorSource source);

    DemonstratorTargetEmbedded toTargetEmbedded(DemonstratorSourceEmbedded gender);
}
