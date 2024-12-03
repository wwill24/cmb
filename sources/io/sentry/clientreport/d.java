package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.g;
import io.sentry.n3;
import io.sentry.w2;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final g f31172a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final SentryOptions f31173b;

    public d(SentryOptions sentryOptions) {
        this.f31173b = sentryOptions;
    }

    private DataCategory e(SentryItemType sentryItemType) {
        if (SentryItemType.Event.equals(sentryItemType)) {
            return DataCategory.Error;
        }
        if (SentryItemType.Session.equals(sentryItemType)) {
            return DataCategory.Session;
        }
        if (SentryItemType.Transaction.equals(sentryItemType)) {
            return DataCategory.Transaction;
        }
        if (SentryItemType.UserFeedback.equals(sentryItemType)) {
            return DataCategory.UserReport;
        }
        if (SentryItemType.Attachment.equals(sentryItemType)) {
            return DataCategory.Attachment;
        }
        return DataCategory.Default;
    }

    private void f(String str, String str2, Long l10) {
        this.f31172a.a(new c(str, str2), l10);
    }

    private void h(b bVar) {
        if (bVar != null) {
            for (e next : bVar.a()) {
                f(next.c(), next.a(), next.b());
            }
        }
    }

    public void a(DiscardReason discardReason, DataCategory dataCategory) {
        try {
            f(discardReason.getReason(), dataCategory.getCategory(), 1L);
        } catch (Throwable th2) {
            this.f31173b.getLogger().a(SentryLevel.ERROR, th2, "Unable to record lost event.", new Object[0]);
        }
    }

    public void b(DiscardReason discardReason, w2 w2Var) {
        if (w2Var != null) {
            try {
                for (n3 c10 : w2Var.c()) {
                    c(discardReason, c10);
                }
            } catch (Throwable th2) {
                this.f31173b.getLogger().a(SentryLevel.ERROR, th2, "Unable to record lost envelope.", new Object[0]);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(io.sentry.clientreport.DiscardReason r4, io.sentry.n3 r5) {
        /*
            r3 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            io.sentry.o3 r1 = r5.x()     // Catch:{ all -> 0x0048 }
            io.sentry.SentryItemType r1 = r1.b()     // Catch:{ all -> 0x0048 }
            io.sentry.SentryItemType r2 = io.sentry.SentryItemType.ClientReport     // Catch:{ all -> 0x0048 }
            boolean r2 = r2.equals(r1)     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0032
            io.sentry.SentryOptions r4 = r3.f31173b     // Catch:{ Exception -> 0x0022 }
            io.sentry.l0 r4 = r4.getSerializer()     // Catch:{ Exception -> 0x0022 }
            io.sentry.clientreport.b r4 = r5.v(r4)     // Catch:{ Exception -> 0x0022 }
            r3.h(r4)     // Catch:{ Exception -> 0x0022 }
            goto L_0x0058
        L_0x0022:
            io.sentry.SentryOptions r4 = r3.f31173b     // Catch:{ all -> 0x0048 }
            io.sentry.h0 r4 = r4.getLogger()     // Catch:{ all -> 0x0048 }
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = "Unable to restore counts from previous client report."
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0048 }
            r4.c(r5, r1, r2)     // Catch:{ all -> 0x0048 }
            goto L_0x0058
        L_0x0032:
            java.lang.String r4 = r4.getReason()     // Catch:{ all -> 0x0048 }
            io.sentry.DataCategory r5 = r3.e(r1)     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = r5.getCategory()     // Catch:{ all -> 0x0048 }
            r1 = 1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0048 }
            r3.f(r4, r5, r1)     // Catch:{ all -> 0x0048 }
            goto L_0x0058
        L_0x0048:
            r4 = move-exception
            io.sentry.SentryOptions r5 = r3.f31173b
            io.sentry.h0 r5 = r5.getLogger()
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "Unable to record lost envelope item."
            r5.a(r1, r4, r2, r0)
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.clientreport.d.c(io.sentry.clientreport.DiscardReason, io.sentry.n3):void");
    }

    public w2 d(w2 w2Var) {
        b g10 = g();
        if (g10 == null) {
            return w2Var;
        }
        try {
            this.f31173b.getLogger().c(SentryLevel.DEBUG, "Attaching client report to envelope.", new Object[0]);
            ArrayList arrayList = new ArrayList();
            for (n3 add : w2Var.c()) {
                arrayList.add(add);
            }
            arrayList.add(n3.r(this.f31173b.getSerializer(), g10));
            return new w2(w2Var.b(), arrayList);
        } catch (Throwable th2) {
            this.f31173b.getLogger().a(SentryLevel.ERROR, th2, "Unable to attach client report to envelope.", new Object[0]);
            return w2Var;
        }
    }

    /* access modifiers changed from: package-private */
    public b g() {
        Date c10 = g.c();
        List<e> b10 = this.f31172a.b();
        if (b10.isEmpty()) {
            return null;
        }
        return new b(c10, b10);
    }
}
