package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.a0;
import androidx.camera.core.impl.b0;
import androidx.camera.core.impl.w;
import androidx.camera.core.r;
import androidx.camera.core.v1;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.q0;

public final class v implements w {

    /* renamed from: a  reason: collision with root package name */
    private final b0 f1994a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f1995b;

    /* renamed from: c  reason: collision with root package name */
    private final q0 f1996c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f1997d;

    /* renamed from: e  reason: collision with root package name */
    private final v1 f1998e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, i0> f1999f = new HashMap();

    public v(@NonNull Context context, @NonNull b0 b0Var, r rVar) throws InitializationException {
        this.f1994a = b0Var;
        this.f1995b = new a0(1);
        this.f1996c = q0.b(context, b0Var.c());
        this.f1998e = v1.b(context);
        this.f1997d = d(i1.b(this, rVar));
    }

    private List<String> d(@NonNull List<String> list) throws InitializationException {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (next.equals("0") || next.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                arrayList.add(next);
            } else if (g(next)) {
                arrayList.add(next);
            } else {
                v1.a("Camera2CameraFactory", "Camera " + next + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
            }
        }
        return arrayList;
    }

    private boolean g(@NonNull String str) throws InitializationException {
        if ("robolectric".equals(Build.FINGERPRINT)) {
            return true;
        }
        try {
            int[] iArr = (int[]) this.f1996c.c(str).a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i10 : iArr) {
                    if (i10 == 0) {
                        return true;
                    }
                }
            }
            return false;
        } catch (CameraAccessExceptionCompat e10) {
            throw new InitializationException(k1.a(e10));
        }
    }

    @NonNull
    public CameraInternal a(@NonNull String str) throws CameraUnavailableException {
        if (this.f1997d.contains(str)) {
            return new Camera2CameraImpl(this.f1996c, str, e(str), this.f1995b, this.f1994a.b(), this.f1994a.c(), this.f1998e);
        }
        throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
    }

    @NonNull
    public Set<String> b() {
        return new LinkedHashSet(this.f1997d);
    }

    /* access modifiers changed from: package-private */
    public i0 e(@NonNull String str) throws CameraUnavailableException {
        try {
            i0 i0Var = this.f1999f.get(str);
            if (i0Var != null) {
                return i0Var;
            }
            i0 i0Var2 = new i0(str, this.f1996c);
            this.f1999f.put(str, i0Var2);
            return i0Var2;
        } catch (CameraAccessExceptionCompat e10) {
            throw k1.a(e10);
        }
    }

    @NonNull
    /* renamed from: f */
    public q0 c() {
        return this.f1996c;
    }
}
