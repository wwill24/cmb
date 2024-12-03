package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import java.util.Set;

public abstract class ConfigUpdate {
    @NonNull
    public static ConfigUpdate create(@NonNull Set<String> set) {
        return new AutoValue_ConfigUpdate(set);
    }

    @NonNull
    public abstract Set<String> getUpdatedKeys();
}
