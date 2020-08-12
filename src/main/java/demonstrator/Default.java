/*
 * Created on 12.08.2020
 *
 * Copyright(c) 1995 - 2020 T-Systems Multimedia Solutions GmbH
 * Riesaer Str. 5, 01129 Dresden
 * All rights reserved.
 */
package demonstrator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.CONSTRUCTOR)
public @interface Default {
}