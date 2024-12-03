package com.mparticle.identity;

import androidx.annotation.NonNull;

@Deprecated
public interface UserAliasHandler {
    void onUserAlias(@NonNull MParticleUser mParticleUser, @NonNull MParticleUser mParticleUser2);
}
