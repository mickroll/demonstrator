package org.example;

import org.immutables.value.Value;

@Value.Style(get = { "get*", "is*" }, init = "set*", allParameters = true, validationMethod = Value.Style.ValidationMethod.NONE)
public @interface DataClassStyle {
}
