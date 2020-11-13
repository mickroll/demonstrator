package org.example;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface ExampleMapper {
  ExampleTarget create(ExampleSourceVO source, ExampleMember member);

  void update(@MappingTarget ExampleTarget target, ExampleSourceVO source, ExampleMember member);

  @Mapping(target = "member", source = "member")
  void updateWithExplicitMapping(@MappingTarget ExampleTarget target, ExampleSourceVO source, ExampleMember member);

  @Mapping(target = "member", source = "member", defaultExpression = "java(null)")
  void updateWithDefaultExpression(@MappingTarget ExampleTarget target, ExampleSourceVO source, ExampleMember member);
}
