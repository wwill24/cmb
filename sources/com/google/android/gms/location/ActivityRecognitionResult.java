package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.lang.reflect.Array;
import java.util.List;

public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    List f39455a;

    /* renamed from: b  reason: collision with root package name */
    long f39456b;

    /* renamed from: c  reason: collision with root package name */
    long f39457c;

    /* renamed from: d  reason: collision with root package name */
    int f39458d;

    /* renamed from: e  reason: collision with root package name */
    Bundle f39459e;

    public ActivityRecognitionResult(@NonNull List list, long j10, long j11, int i10, Bundle bundle) {
        boolean z10;
        boolean z11 = true;
        if (list == null || list.size() <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        p.b(z10, "Must have at least 1 detected activity");
        p.b((j10 <= 0 || j11 <= 0) ? false : z11, "Must set times");
        this.f39455a = list;
        this.f39456b = j10;
        this.f39457c = j11;
        this.f39458d = i10;
        this.f39459e = bundle;
    }

    private static boolean S(Bundle bundle, Bundle bundle2) {
        int length;
        if (bundle == null) {
            if (bundle2 == null) {
                return true;
            }
            return false;
        } else if (bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        } else {
            for (String next : bundle.keySet()) {
                if (!bundle2.containsKey(next)) {
                    return false;
                }
                Object obj = bundle.get(next);
                Object obj2 = bundle2.get(next);
                if (obj == null) {
                    if (obj2 != null) {
                        return false;
                    }
                } else if (obj instanceof Bundle) {
                    if (!S(bundle.getBundle(next), bundle2.getBundle(next))) {
                        return false;
                    }
                } else if (obj.getClass().isArray()) {
                    if (obj2 != null && obj2.getClass().isArray() && (length = Array.getLength(obj)) == Array.getLength(obj2)) {
                        int i10 = 0;
                        while (i10 < length) {
                            if (n.b(Array.get(obj, i10), Array.get(obj2, i10))) {
                                i10++;
                            }
                        }
                        continue;
                    }
                    return false;
                } else if (!obj.equals(obj2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (this.f39456b == activityRecognitionResult.f39456b && this.f39457c == activityRecognitionResult.f39457c && this.f39458d == activityRecognitionResult.f39458d && n.b(this.f39455a, activityRecognitionResult.f39455a) && S(this.f39459e, activityRecognitionResult.f39459e)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return n.c(Long.valueOf(this.f39456b), Long.valueOf(this.f39457c), Integer.valueOf(this.f39458d), this.f39455a, this.f39459e);
    }

    @NonNull
    public String toString() {
        String valueOf = String.valueOf(this.f39455a);
        long j10 = this.f39456b;
        long j11 = this.f39457c;
        return "ActivityRecognitionResult [probableActivities=" + valueOf + ", timeMillis=" + j10 + ", elapsedRealtimeMillis=" + j11 + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.G(parcel, 1, this.f39455a, false);
        a.v(parcel, 2, this.f39456b);
        a.v(parcel, 3, this.f39457c);
        a.s(parcel, 4, this.f39458d);
        a.j(parcel, 5, this.f39459e, false);
        a.b(parcel, a10);
    }
}
