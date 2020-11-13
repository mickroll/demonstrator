package org.example;

import java.time.LocalDate;
import org.immutables.value.Value;

@Value.Immutable
@DataClassStyle
public interface ExampleSourceVO {

  LocalDate getBirthday();
}
