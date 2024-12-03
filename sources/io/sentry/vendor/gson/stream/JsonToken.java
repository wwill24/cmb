package io.sentry.vendor.gson.stream;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public enum JsonToken {
    BEGIN_ARRAY,
    END_ARRAY,
    BEGIN_OBJECT,
    END_OBJECT,
    NAME,
    STRING,
    NUMBER,
    BOOLEAN,
    NULL,
    END_DOCUMENT
}
