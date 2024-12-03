package com.mparticle;

import androidx.annotation.NonNull;
import com.mparticle.identity.TaskFailureListener;
import com.mparticle.identity.TaskSuccessListener;

public abstract class MParticleTask<MParticleTaskResult> {
    @NonNull
    public abstract MParticleTask<MParticleTaskResult> addFailureListener(@NonNull TaskFailureListener taskFailureListener);

    @NonNull
    public abstract MParticleTask<MParticleTaskResult> addSuccessListener(@NonNull TaskSuccessListener taskSuccessListener);

    public abstract MParticleTaskResult getResult();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();
}
