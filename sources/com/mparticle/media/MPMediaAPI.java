package com.mparticle.media;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;

public class MPMediaAPI {
    private AtomicBoolean mAudioPlaying;
    private final MediaCallbacks mCallbacks;
    private final Context mContext;

    private MPMediaAPI() {
        this.mAudioPlaying = new AtomicBoolean(false);
        this.mContext = null;
        this.mCallbacks = null;
    }

    public boolean getAudioPlaying() {
        return this.mAudioPlaying.get();
    }

    public void setAudioPlaying(boolean z10) {
        this.mAudioPlaying.set(z10);
        if (z10) {
            this.mCallbacks.onAudioPlaying();
        } else {
            this.mCallbacks.onAudioStopped();
        }
    }

    public MPMediaAPI(Context context, @NonNull MediaCallbacks mediaCallbacks) {
        this.mAudioPlaying = new AtomicBoolean(false);
        this.mContext = context;
        this.mCallbacks = mediaCallbacks;
    }
}
