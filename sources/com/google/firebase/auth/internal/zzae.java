package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import com.google.firebase.auth.zze;
import fe.a;
import java.util.ArrayList;
import java.util.List;

public final class zzae extends MultiFactorResolver {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
    private final List zza;
    private final zzag zzb;
    private final String zzc;
    /* access modifiers changed from: private */
    public final zze zzd;
    private final zzx zze;
    private final List zzf;

    public zzae(List list, zzag zzag, String str, zze zze2, zzx zzx, List list2) {
        this.zza = (List) p.k(list);
        this.zzb = (zzag) p.k(zzag);
        this.zzc = p.g(str);
        this.zzd = zze2;
        this.zze = zzx;
        this.zzf = (List) p.k(list2);
    }

    public final FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc));
    }

    public final List<MultiFactorInfo> getHints() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo add : this.zza) {
            arrayList.add(add);
        }
        for (TotpMultiFactorInfo add2 : this.zzf) {
            arrayList.add(add2);
        }
        return arrayList;
    }

    public final MultiFactorSession getSession() {
        return this.zzb;
    }

    public final Task<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion) {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc)).zzj(multiFactorAssertion, this.zzb, this.zze).continueWithTask(new zzad(this));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        List list = this.zza;
        int a10 = a.a(parcel);
        a.G(parcel, 1, list, false);
        a.A(parcel, 2, this.zzb, i10, false);
        a.C(parcel, 3, this.zzc, false);
        a.A(parcel, 4, this.zzd, i10, false);
        a.A(parcel, 5, this.zze, i10, false);
        a.G(parcel, 6, this.zzf, false);
        a.b(parcel, a10);
    }
}
