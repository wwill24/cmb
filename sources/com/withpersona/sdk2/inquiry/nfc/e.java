package com.withpersona.sdk2.inquiry.nfc;

import com.withpersona.sdk2.inquiry.launchers.u;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;

public final class e {
    public static final u<PassportNfcReaderConfig, PassportNfcReaderOutput> b() {
        return new u<>(new b(), new d());
    }

    /* access modifiers changed from: private */
    public static final void c(PassportNfcReaderOutput passportNfcReaderOutput) {
        j.g(passportNfcReaderOutput, MamElements.MamResultExtension.ELEMENT);
        new g().b(passportNfcReaderOutput);
    }
}
