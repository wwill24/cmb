package com.withpersona.sdk2.inquiry.nfc;

import android.content.Context;
import androidx.activity.result.c;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.j;
import java.util.Date;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.d;

public final class ScanNfcWorker implements j<PassportNfcReaderOutput> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c<PassportNfcReaderConfig> f27058b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f27059c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f27060d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Date f27061e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Date f27062f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final PassportNfcScanReadyPage f27063g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final PassportNfcScanCompletePage f27064h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final PassportNfcStrings f27065i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Integer f27066j;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c<PassportNfcReaderConfig> f27067a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f27068b;

        public a(c<PassportNfcReaderConfig> cVar, Context context) {
            kotlin.jvm.internal.j.g(cVar, "passportNfcReaderLauncher");
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            this.f27067a = cVar;
            this.f27068b = context;
        }

        public final ScanNfcWorker a(String str, Date date, Date date2, PassportNfcScanReadyPage passportNfcScanReadyPage, PassportNfcScanCompletePage passportNfcScanCompletePage, PassportNfcStrings passportNfcStrings, Integer num) {
            kotlin.jvm.internal.j.g(str, "passportNumber");
            kotlin.jvm.internal.j.g(date, "dateOfBirth");
            kotlin.jvm.internal.j.g(date2, "expirationDate");
            PassportNfcScanReadyPage passportNfcScanReadyPage2 = passportNfcScanReadyPage;
            kotlin.jvm.internal.j.g(passportNfcScanReadyPage2, "scanReadyPage");
            PassportNfcScanCompletePage passportNfcScanCompletePage2 = passportNfcScanCompletePage;
            kotlin.jvm.internal.j.g(passportNfcScanCompletePage2, "scanCompletePage");
            PassportNfcStrings passportNfcStrings2 = passportNfcStrings;
            kotlin.jvm.internal.j.g(passportNfcStrings2, "passportNfcStrings");
            return new ScanNfcWorker(this.f27067a, this.f27068b, str, date, date2, passportNfcScanReadyPage2, passportNfcScanCompletePage2, passportNfcStrings2, num);
        }
    }

    public ScanNfcWorker(c<PassportNfcReaderConfig> cVar, Context context, String str, Date date, Date date2, PassportNfcScanReadyPage passportNfcScanReadyPage, PassportNfcScanCompletePage passportNfcScanCompletePage, PassportNfcStrings passportNfcStrings, Integer num) {
        kotlin.jvm.internal.j.g(cVar, "passportNfcReaderLauncher");
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(str, "passportNumber");
        kotlin.jvm.internal.j.g(date, "dateOfBirth");
        kotlin.jvm.internal.j.g(date2, "expirationDate");
        kotlin.jvm.internal.j.g(passportNfcScanReadyPage, "scanReadyPage");
        kotlin.jvm.internal.j.g(passportNfcScanCompletePage, "scanCompletePage");
        kotlin.jvm.internal.j.g(passportNfcStrings, "passportNfcStrings");
        this.f27058b = cVar;
        this.f27059c = context;
        this.f27060d = str;
        this.f27061e = date;
        this.f27062f = date2;
        this.f27063g = passportNfcScanReadyPage;
        this.f27064h = passportNfcScanCompletePage;
        this.f27065i = passportNfcStrings;
        this.f27066j = num;
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        return jVar instanceof ScanNfcWorker;
    }

    public b<PassportNfcReaderOutput> run() {
        return d.v(new ScanNfcWorker$run$1(this, (kotlin.coroutines.c<? super ScanNfcWorker$run$1>) null));
    }
}
