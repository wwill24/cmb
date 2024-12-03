package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.integrity.internal.b0;
import com.google.android.play.integrity.internal.h;
import com.google.android.play.integrity.internal.n;
import com.google.android.play.integrity.internal.z;
import java.util.ArrayList;

final class t {

    /* renamed from: a  reason: collision with root package name */
    final z f20501a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final n f20502b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20503c;

    t(Context context, n nVar) {
        this.f20503c = context.getPackageName();
        this.f20502b = nVar;
        if (!b0.a(context)) {
            nVar.b("Phonesky is not installed.", new Object[0]);
            this.f20501a = null;
            return;
        }
        this.f20501a = new z(context, nVar, "IntegrityService", u.f20504a, q.f20492a, (com.google.android.play.integrity.internal.t) null, (byte[]) null);
    }

    static /* bridge */ /* synthetic */ Bundle a(t tVar, byte[] bArr, Long l10) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", tVar.f20503c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 1);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l10 != null) {
            bundle.putLong("cloud.prj", l10.longValue());
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.add(h.c(3, System.currentTimeMillis()));
        ArrayList arrayList2 = new ArrayList();
        for (h b10 : arrayList) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("event_type", 3);
            bundle2.putLong("event_timestamp", b10.b());
            arrayList2.add(bundle2);
        }
        bundle.putParcelableArrayList("event_timestamps", new ArrayList(arrayList2));
        return bundle;
    }

    public final Task b(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f20501a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, (Throwable) null));
        }
        try {
            byte[] decode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long cloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            this.f20502b.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f20501a.p(new r(this, taskCompletionSource, decode, cloudProjectNumber, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e10) {
            return Tasks.forException(new IntegrityServiceException(-13, e10));
        }
    }
}
