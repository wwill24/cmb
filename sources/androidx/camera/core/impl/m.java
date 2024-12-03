package androidx.camera.core.impl;

import android.media.CamcorderProfile;
import androidx.annotation.NonNull;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public static int f2566a = -1;

    @NonNull
    public static m a(@NonNull CamcorderProfile camcorderProfile) {
        return new c(camcorderProfile.duration, camcorderProfile.quality, camcorderProfile.fileFormat, camcorderProfile.videoCodec, camcorderProfile.videoBitRate, camcorderProfile.videoFrameRate, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, camcorderProfile.audioCodec, camcorderProfile.audioBitRate, camcorderProfile.audioSampleRate, camcorderProfile.audioChannels);
    }

    public abstract int b();

    public abstract int c();

    public abstract int d();

    public String e() {
        switch (d()) {
            case 1:
                return "audio/3gpp";
            case 2:
                return "audio/amr-wb";
            case 3:
            case 4:
            case 5:
                return "audio/mp4a-latm";
            case 6:
                return "audio/vorbis";
            case 7:
                return "audio/opus";
            default:
                return null;
        }
    }

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public int j() {
        int d10 = d();
        if (d10 == 3) {
            return 2;
        }
        if (d10 == 4) {
            return 5;
        }
        if (d10 != 5) {
            return f2566a;
        }
        return 39;
    }

    public abstract int k();

    public abstract int l();

    public String m() {
        int l10 = l();
        if (l10 == 1) {
            return "video/3gpp";
        }
        if (l10 == 2) {
            return "video/avc";
        }
        if (l10 == 3) {
            return "video/mp4v-es";
        }
        if (l10 == 4) {
            return "video/x-vnd.on2.vp8";
        }
        if (l10 != 5) {
            return null;
        }
        return "video/hevc";
    }

    public abstract int n();

    public abstract int o();

    public abstract int p();
}
