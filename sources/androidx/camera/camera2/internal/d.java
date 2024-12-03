package androidx.camera.camera2.internal;

import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.l;
import androidx.camera.core.impl.m;
import androidx.camera.core.v1;
import o.c0;
import q.e;
import q.g;
import r.c;

public class d implements l {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1709a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1710b;

    /* renamed from: c  reason: collision with root package name */
    private final c f1711c;

    public d(@NonNull String str, @NonNull c0 c0Var) {
        boolean z10;
        int i10;
        try {
            i10 = Integer.parseInt(str);
            z10 = true;
        } catch (NumberFormatException unused) {
            v1.l("Camera2CamcorderProfileProvider", "Camera id is not an integer: " + str + ", unable to create CamcorderProfileProvider");
            z10 = false;
            i10 = -1;
        }
        this.f1709a = z10;
        this.f1710b = i10;
        this.f1711c = new c((e) g.a(str, c0Var).b(e.class));
    }

    private m b(int i10) {
        CamcorderProfile camcorderProfile;
        try {
            camcorderProfile = CamcorderProfile.get(this.f1710b, i10);
        } catch (RuntimeException e10) {
            v1.m("Camera2CamcorderProfileProvider", "Unable to get CamcorderProfile by quality: " + i10, e10);
            camcorderProfile = null;
        }
        if (camcorderProfile != null) {
            return m.a(camcorderProfile);
        }
        return null;
    }

    public boolean a(int i10) {
        if (!this.f1709a || !CamcorderProfile.hasProfile(this.f1710b, i10)) {
            return false;
        }
        if (!this.f1711c.a()) {
            return true;
        }
        return this.f1711c.b(b(i10));
    }

    public m get(int i10) {
        if (!this.f1709a || !CamcorderProfile.hasProfile(this.f1710b, i10)) {
            return null;
        }
        m b10 = b(i10);
        if (!this.f1711c.b(b10)) {
            return null;
        }
        return b10;
    }
}
