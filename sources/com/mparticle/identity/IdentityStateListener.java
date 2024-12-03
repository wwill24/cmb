package com.mparticle.identity;

import androidx.annotation.NonNull;

public interface IdentityStateListener {
    void onUserIdentified(@NonNull MParticleUser mParticleUser, MParticleUser mParticleUser2);
}
