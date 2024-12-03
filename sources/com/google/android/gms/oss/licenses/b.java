package com.google.android.gms.oss.licenses;

import android.content.Context;
import androidx.loader.content.a;
import com.google.android.gms.internal.oss_licenses.zza;
import com.google.android.gms.internal.oss_licenses.zzc;
import java.util.List;

final class b extends a<List<zza>> {

    /* renamed from: p  reason: collision with root package name */
    private List<zza> f40532p;

    b(Context context) {
        super(context.getApplicationContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public final void f(List<zza> list) {
        this.f40532p = list;
        super.f(list);
    }

    public final /* synthetic */ Object B() {
        return zzc.zza(i());
    }

    /* access modifiers changed from: protected */
    public final void p() {
        List<zza> list = this.f40532p;
        if (list != null) {
            f(list);
        } else {
            h();
        }
    }

    /* access modifiers changed from: protected */
    public final void q() {
        b();
    }
}
