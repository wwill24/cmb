package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ActivityTransitionRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new c0();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<ActivityTransition> f39465e = new b0();

    /* renamed from: a  reason: collision with root package name */
    private final List f39466a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39467b;

    /* renamed from: c  reason: collision with root package name */
    private final List f39468c;

    /* renamed from: d  reason: collision with root package name */
    private String f39469d;

    public ActivityTransitionRequest(@NonNull List list, String str, List list2, String str2) {
        boolean z10;
        List list3;
        p.l(list, "transitions can't be null");
        if (list.size() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.b(z10, "transitions can't be empty.");
        p.k(list);
        TreeSet treeSet = new TreeSet(f39465e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ActivityTransition activityTransition = (ActivityTransition) it.next();
            p.b(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", new Object[]{activityTransition}));
        }
        this.f39466a = Collections.unmodifiableList(list);
        this.f39467b = str;
        if (list2 == null) {
            list3 = Collections.emptyList();
        } else {
            list3 = Collections.unmodifiableList(list2);
        }
        this.f39468c = list3;
        this.f39469d = str2;
    }

    @NonNull
    public final ActivityTransitionRequest S(String str) {
        this.f39469d = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (!n.b(this.f39466a, activityTransitionRequest.f39466a) || !n.b(this.f39467b, activityTransitionRequest.f39467b) || !n.b(this.f39469d, activityTransitionRequest.f39469d) || !n.b(this.f39468c, activityTransitionRequest.f39468c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11;
        int hashCode = this.f39466a.hashCode() * 31;
        String str = this.f39467b;
        int i12 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i13 = (hashCode + i10) * 31;
        List list = this.f39468c;
        if (list != null) {
            i11 = list.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i13 + i11) * 31;
        String str2 = this.f39469d;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i14 + i12;
    }

    @NonNull
    public String toString() {
        String valueOf = String.valueOf(this.f39466a);
        String str = this.f39467b;
        String valueOf2 = String.valueOf(this.f39468c);
        String str2 = this.f39469d;
        return "ActivityTransitionRequest [mTransitions=" + valueOf + ", mTag='" + str + "', mClients=" + valueOf2 + ", mAttributionTag=" + str2 + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        p.k(parcel);
        int a10 = a.a(parcel);
        a.G(parcel, 1, this.f39466a, false);
        a.C(parcel, 2, this.f39467b, false);
        a.G(parcel, 3, this.f39468c, false);
        a.C(parcel, 4, this.f39469d, false);
        a.b(parcel, a10);
    }
}
