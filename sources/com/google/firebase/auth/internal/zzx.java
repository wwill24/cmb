package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzahb;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zze;
import fe.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzx extends FirebaseUser {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    private zzahb zza;
    private zzt zzb;
    private final String zzc;
    private String zzd;
    private List zze;
    private List zzf;
    private String zzg;
    private Boolean zzh;
    private zzz zzi;
    private boolean zzj;
    private zze zzk;
    private zzbd zzl;

    public zzx(FirebaseApp firebaseApp, List list) {
        p.k(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = "2";
        zzc(list);
    }

    public static FirebaseUser zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzx zzx = new zzx(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzx) {
            zzx zzx2 = (zzx) firebaseUser;
            zzx.zzg = zzx2.zzg;
            zzx.zzd = zzx2.zzd;
            zzx.zzi = zzx2.zzi;
        } else {
            zzx.zzi = null;
        }
        if (firebaseUser.zzd() != null) {
            zzx.zzh(firebaseUser.zzd());
        }
        if (!firebaseUser.isAnonymous()) {
            zzx.zzm();
        }
        return zzx;
    }

    public final String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    public final String getEmail() {
        return this.zzb.getEmail();
    }

    public final FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    public final /* synthetic */ MultiFactor getMultiFactor() {
        return new zzac(this);
    }

    public final String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    public final Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    @NonNull
    public final List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    @NonNull
    public final String getProviderId() {
        return this.zzb.getProviderId();
    }

    public final String getTenantId() {
        Map map;
        zzahb zzahb = this.zza;
        if (zzahb == null || zzahb.zze() == null || (map = (Map) zzba.zza(zzahb.zze()).getClaims().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @NonNull
    public final String getUid() {
        return this.zzb.getUid();
    }

    public final boolean isAnonymous() {
        String str;
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzahb zzahb = this.zza;
            if (zzahb != null) {
                str = zzba.zza(zzahb.zze()).getSignInProvider();
            } else {
                str = "";
            }
            boolean z10 = false;
            if (this.zze.size() <= 1 && (str == null || !str.equals("custom"))) {
                z10 = true;
            }
            this.zzh = Boolean.valueOf(z10);
        }
        return this.zzh.booleanValue();
    }

    public final boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, this.zza, i10, false);
        a.A(parcel, 2, this.zzb, i10, false);
        a.C(parcel, 3, this.zzc, false);
        a.C(parcel, 4, this.zzd, false);
        a.G(parcel, 5, this.zze, false);
        a.E(parcel, 6, this.zzf, false);
        a.C(parcel, 7, this.zzg, false);
        a.i(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        a.A(parcel, 9, this.zzi, i10, false);
        a.g(parcel, 10, this.zzj);
        a.A(parcel, 11, this.zzk, i10, false);
        a.A(parcel, 12, this.zzl, i10, false);
        a.b(parcel, a10);
    }

    @NonNull
    public final FirebaseApp zza() {
        return FirebaseApp.getInstance(this.zzc);
    }

    public final /* bridge */ /* synthetic */ FirebaseUser zzb() {
        zzm();
        return this;
    }

    @NonNull
    public final synchronized FirebaseUser zzc(List list) {
        p.k(list);
        this.zze = new ArrayList(list.size());
        this.zzf = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            UserInfo userInfo = (UserInfo) list.get(i10);
            if (userInfo.getProviderId().equals("firebase")) {
                this.zzb = (zzt) userInfo;
            } else {
                this.zzf.add(userInfo.getProviderId());
            }
            this.zze.add((zzt) userInfo);
        }
        if (this.zzb == null) {
            this.zzb = (zzt) this.zze.get(0);
        }
        return this;
    }

    @NonNull
    public final zzahb zzd() {
        return this.zza;
    }

    @NonNull
    public final String zze() {
        return this.zza.zze();
    }

    @NonNull
    public final String zzf() {
        return this.zza.zzh();
    }

    public final List zzg() {
        return this.zzf;
    }

    public final void zzh(zzahb zzahb) {
        this.zza = (zzahb) p.k(zzahb);
    }

    public final void zzi(List list) {
        Parcelable.Creator<zzbd> creator = zzbd.CREATOR;
        zzbd zzbd = null;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
                if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                    arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
                } else if (multiFactorInfo instanceof TotpMultiFactorInfo) {
                    arrayList2.add((TotpMultiFactorInfo) multiFactorInfo);
                }
            }
            zzbd = new zzbd(arrayList, arrayList2);
        }
        this.zzl = zzbd;
    }

    public final zze zzj() {
        return this.zzk;
    }

    public final zzx zzl(String str) {
        this.zzg = str;
        return this;
    }

    public final zzx zzm() {
        this.zzh = Boolean.FALSE;
        return this;
    }

    public final List zzn() {
        zzbd zzbd = this.zzl;
        if (zzbd != null) {
            return zzbd.zza();
        }
        return new ArrayList();
    }

    public final List zzo() {
        return this.zze;
    }

    public final void zzp(zze zze2) {
        this.zzk = zze2;
    }

    public final void zzq(boolean z10) {
        this.zzj = z10;
    }

    public final void zzr(zzz zzz) {
        this.zzi = zzz;
    }

    public final boolean zzs() {
        return this.zzj;
    }

    zzx(zzahb zzahb, zzt zzt, String str, String str2, List list, List list2, String str3, Boolean bool, zzz zzz, boolean z10, zze zze2, zzbd zzbd) {
        this.zza = zzahb;
        this.zzb = zzt;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzz;
        this.zzj = z10;
        this.zzk = zze2;
        this.zzl = zzbd;
    }
}
