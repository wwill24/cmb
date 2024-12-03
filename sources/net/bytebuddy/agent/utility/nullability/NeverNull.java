package net.bytebuddy.agent.utility.nullability;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NeverNull {

    @Documented
    @Target({ElementType.PACKAGE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ByDefault {
    }
}
