package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.m;

public interface l {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3328a = m.f2566a;

    @NonNull
    MediaFormat a() throws InvalidConfigException;

    @NonNull
    String b();

    @NonNull
    Timebase c();
}
