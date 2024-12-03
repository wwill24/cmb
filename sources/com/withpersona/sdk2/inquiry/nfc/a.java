package com.withpersona.sdk2.inquiry.nfc;

import android.content.Context;
import android.nfc.NfcAdapter;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27071a = new a();

    private a() {
    }

    public final Class<?> a() {
        try {
            return Class.forName("com.withpersona.sdk2.inquiry.nfc.impl.PassportNfcReaderActivity");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final boolean b(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (c() && NfcAdapter.getDefaultAdapter(context) != null) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        return a() != null;
    }
}
