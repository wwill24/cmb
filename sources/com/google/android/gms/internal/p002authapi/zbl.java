package com.google.android.gms.internal.p002authapi;

import android.app.PendingIntent;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.p;
import vd.a;
import xd.b;

/* renamed from: com.google.android.gms.internal.auth-api.zbl  reason: invalid package */
public final class zbl implements b {
    public final f<Status> delete(d dVar, Credential credential) {
        p.l(dVar, "client must not be null");
        p.l(credential, "credential must not be null");
        return dVar.h(new zbi(this, dVar, credential));
    }

    public final f<Status> disableAutoSignIn(d dVar) {
        p.l(dVar, "client must not be null");
        return dVar.h(new zbj(this, dVar));
    }

    public final PendingIntent getHintPickerIntent(d dVar, HintRequest hintRequest) {
        p.l(dVar, "client must not be null");
        p.l(hintRequest, "request must not be null");
        a.C0509a zba = ((zbo) dVar.j(a.f42084g)).zba();
        return zbn.zba(dVar.k(), zba, hintRequest, zba.d());
    }

    public final f<Object> request(d dVar, CredentialRequest credentialRequest) {
        p.l(dVar, "client must not be null");
        p.l(credentialRequest, "request must not be null");
        return dVar.g(new zbg(this, dVar, credentialRequest));
    }

    public final f<Status> save(d dVar, Credential credential) {
        p.l(dVar, "client must not be null");
        p.l(credential, "credential must not be null");
        return dVar.h(new zbh(this, dVar, credential));
    }
}
