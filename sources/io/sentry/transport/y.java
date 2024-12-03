package io.sentry.transport;

import com.coffeemeetsbagel.models.util.DateUtils;
import com.facebook.internal.security.CertificateUtil;
import com.mparticle.kits.AppsFlyerKit;
import io.sentry.DataCategory;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.clientreport.DiscardReason;
import io.sentry.hints.g;
import io.sentry.hints.l;
import io.sentry.n3;
import io.sentry.util.i;
import io.sentry.util.p;
import io.sentry.w;
import io.sentry.w2;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smack.packet.Session;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private final o f31679a;

    /* renamed from: b  reason: collision with root package name */
    private final SentryOptions f31680b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<DataCategory, Date> f31681c;

    public y(o oVar, SentryOptions sentryOptions) {
        this.f31681c = new ConcurrentHashMap();
        this.f31679a = oVar;
        this.f31680b = sentryOptions;
    }

    private void c(DataCategory dataCategory, Date date) {
        Date date2 = this.f31681c.get(dataCategory);
        if (date2 == null || date.after(date2)) {
            this.f31681c.put(dataCategory, date);
        }
    }

    private DataCategory e(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1963501277:
                if (str.equals("attachment")) {
                    c10 = 0;
                    break;
                }
                break;
            case 96891546:
                if (str.equals("event")) {
                    c10 = 1;
                    break;
                }
                break;
            case 1984987798:
                if (str.equals(Session.ELEMENT)) {
                    c10 = 2;
                    break;
                }
                break;
            case 2141246174:
                if (str.equals("transaction")) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return DataCategory.Attachment;
            case 1:
                return DataCategory.Error;
            case 2:
                return DataCategory.Session;
            case 3:
                return DataCategory.Transaction;
            default:
                return DataCategory.Unknown;
        }
    }

    private boolean f(String str) {
        Date date;
        DataCategory e10 = e(str);
        Date date2 = new Date(this.f31679a.getCurrentTimeMillis());
        Date date3 = this.f31681c.get(DataCategory.All);
        if (date3 != null && !date2.after(date3)) {
            return true;
        }
        if (!DataCategory.Unknown.equals(e10) && (date = this.f31681c.get(e10)) != null) {
            return !date2.after(date);
        }
        return false;
    }

    private static void i(w wVar, boolean z10) {
        i.n(wVar, l.class, new w());
        i.n(wVar, g.class, new x(z10));
    }

    private long j(String str) {
        if (str != null) {
            try {
                return (long) (Double.parseDouble(str) * 1000.0d);
            } catch (NumberFormatException unused) {
            }
        }
        return DateUtils.MILLIS_IN_MINUTE;
    }

    public w2 d(w2 w2Var, w wVar) {
        ArrayList arrayList = null;
        for (n3 next : w2Var.c()) {
            if (f(next.x().b().getItemType())) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
                this.f31680b.getClientReportRecorder().c(DiscardReason.RATELIMIT_BACKOFF, next);
            }
        }
        if (arrayList == null) {
            return w2Var;
        }
        this.f31680b.getLogger().c(SentryLevel.INFO, "%d items will be dropped due rate limiting.", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        for (n3 next2 : w2Var.c()) {
            if (!arrayList.contains(next2)) {
                arrayList2.add(next2);
            }
        }
        if (!arrayList2.isEmpty()) {
            return new w2(w2Var.b(), arrayList2);
        }
        this.f31680b.getLogger().c(SentryLevel.INFO, "Envelope discarded due all items rate limited.", new Object[0]);
        i(wVar, false);
        return null;
    }

    public void k(String str, String str2, int i10) {
        String str3 = str;
        if (str3 != null) {
            int i11 = -1;
            String[] split = str3.split(AppsFlyerKit.COMMA, -1);
            int length = split.length;
            int i12 = 0;
            while (i12 < length) {
                String[] split2 = split[i12].replace(" ", "").split(CertificateUtil.DELIMITER, i11);
                if (split2.length > 0) {
                    long j10 = j(split2[0]);
                    if (split2.length > 1) {
                        String str4 = split2[1];
                        Date date = new Date(this.f31679a.getCurrentTimeMillis() + j10);
                        if (str4 == null || str4.isEmpty()) {
                            c(DataCategory.All, date);
                        } else {
                            for (String str5 : str4.split(";", i11)) {
                                DataCategory dataCategory = DataCategory.Unknown;
                                try {
                                    String b10 = p.b(str5);
                                    if (b10 != null) {
                                        dataCategory = DataCategory.valueOf(b10);
                                    } else {
                                        this.f31680b.getLogger().c(SentryLevel.ERROR, "Couldn't capitalize: %s", str5);
                                    }
                                } catch (IllegalArgumentException e10) {
                                    this.f31680b.getLogger().a(SentryLevel.INFO, e10, "Unknown category: %s", str5);
                                }
                                if (!DataCategory.Unknown.equals(dataCategory)) {
                                    c(dataCategory, date);
                                }
                            }
                        }
                    }
                }
                i12++;
                i11 = -1;
            }
        } else if (i10 == 429) {
            c(DataCategory.All, new Date(this.f31679a.getCurrentTimeMillis() + j(str2)));
        }
    }

    public y(SentryOptions sentryOptions) {
        this(m.a(), sentryOptions);
    }
}
