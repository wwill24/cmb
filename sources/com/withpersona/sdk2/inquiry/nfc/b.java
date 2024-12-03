package com.withpersona.sdk2.inquiry.nfc;

import android.content.Context;
import android.content.Intent;
import c.a;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput;
import kotlin.jvm.internal.j;

public final class b extends a<PassportNfcReaderConfig, PassportNfcReaderOutput> {
    /* renamed from: a */
    public Intent createIntent(Context context, PassportNfcReaderConfig passportNfcReaderConfig) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(passportNfcReaderConfig, "input");
        Intent intent = new Intent(context, a.f27071a.a());
        intent.putExtra("EXTRA_NFC_READER_CONFIG", passportNfcReaderConfig);
        return intent;
    }

    /* renamed from: b */
    public PassportNfcReaderOutput parseResult(int i10, Intent intent) {
        PassportNfcReaderOutput passportNfcReaderOutput;
        if (intent != null) {
            passportNfcReaderOutput = (PassportNfcReaderOutput) intent.getParcelableExtra("EXTRA_RESULT");
        } else {
            passportNfcReaderOutput = null;
        }
        if (passportNfcReaderOutput == null) {
            return new PassportNfcReaderOutput.Error("Unable to extract output from result intent.", PassportNfcReaderOutput.ErrorType.Unknown);
        }
        return passportNfcReaderOutput;
    }
}
