package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Collections;
import java.util.List;

public class ActivityTransitionResult extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new d0();

    /* renamed from: a  reason: collision with root package name */
    private final List f39470a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f39471b;

    public ActivityTransitionResult(@NonNull List<ActivityTransitionEvent> list) {
        this.f39471b = null;
        p.l(list, "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i10 = 1; i10 < list.size(); i10++) {
                p.a(list.get(i10).Y() >= list.get(i10 + -1).Y());
            }
        }
        this.f39470a = Collections.unmodifiableList(list);
    }

    @NonNull
    public List<ActivityTransitionEvent> S() {
        return this.f39470a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f39470a.equals(((ActivityTransitionResult) obj).f39470a);
    }

    public int hashCode() {
        return this.f39470a.hashCode();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        p.k(parcel);
        int a10 = a.a(parcel);
        a.G(parcel, 1, S(), false);
        a.j(parcel, 2, this.f39471b, false);
        a.b(parcel, a10);
    }

    public ActivityTransitionResult(@NonNull List list, Bundle bundle) {
        this(list);
        this.f39471b = bundle;
    }
}
