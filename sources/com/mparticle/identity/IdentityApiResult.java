package com.mparticle.identity;

import androidx.annotation.NonNull;

public final class IdentityApiResult {
    private final MParticleUser previousUser;
    private final MParticleUser user;

    public IdentityApiResult(@NonNull MParticleUser mParticleUser, MParticleUser mParticleUser2) {
        this.user = mParticleUser;
        this.previousUser = mParticleUser2;
    }

    public MParticleUser getPreviousUser() {
        return this.previousUser;
    }

    @NonNull
    public MParticleUser getUser() {
        return this.user;
    }
}
