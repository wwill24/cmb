package j$.time.format;

import com.leanplum.internal.Constants;
import com.mparticle.kits.AppsFlyerKit;
import j$.time.e;
import j$.time.temporal.m;
import j$.time.temporal.q;
import j$.time.temporal.u;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

final class t implements C0529g {

    /* renamed from: a  reason: collision with root package name */
    private char f42669a;

    /* renamed from: b  reason: collision with root package name */
    private int f42670b;

    t(char c10, int i10) {
        this.f42669a = c10;
        this.f42670b = i10;
    }

    private k a(Locale locale) {
        m mVar;
        q qVar = u.f42758h;
        Objects.requireNonNull(locale, Constants.Keys.LOCALE);
        Calendar instance = Calendar.getInstance(new Locale(locale.getLanguage(), locale.getCountry()));
        u g10 = u.g(e.SUNDAY.o((long) (instance.getFirstDayOfWeek() - 1)), instance.getMinimalDaysInFirstWeek());
        char c10 = this.f42669a;
        int i10 = 1;
        if (c10 == 'W') {
            mVar = g10.i();
        } else if (c10 == 'Y') {
            m h10 = g10.h();
            int i11 = this.f42670b;
            if (i11 == 2) {
                return new q(h10, q.f42661i, 0);
            }
            if (i11 >= 4) {
                i10 = 5;
            }
            return new k(h10, i11, 19, i10, -1);
        } else if (c10 == 'c' || c10 == 'e') {
            mVar = g10.d();
        } else if (c10 == 'w') {
            mVar = g10.j();
        } else {
            throw new IllegalStateException("unreachable");
        }
        if (this.f42670b == 2) {
            i10 = 2;
        }
        return new k(mVar, i10, 2, 4);
    }

    public final boolean b(A a10, StringBuilder sb2) {
        return a(a10.c()).b(a10, sb2);
    }

    public final int d(x xVar, CharSequence charSequence, int i10) {
        return a(xVar.i()).d(xVar, charSequence, i10);
    }

    public final String toString() {
        String str;
        String b10;
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("Localized(");
        char c10 = this.f42669a;
        if (c10 == 'Y') {
            int i10 = this.f42670b;
            int i11 = 1;
            if (i10 == 1) {
                b10 = "WeekBasedYear";
            } else if (i10 == 2) {
                b10 = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
            } else {
                sb2.append("WeekBasedYear,");
                sb2.append(this.f42670b);
                sb2.append(AppsFlyerKit.COMMA);
                sb2.append(19);
                sb2.append(AppsFlyerKit.COMMA);
                if (this.f42670b >= 4) {
                    i11 = 5;
                }
                b10 = G.b(i11);
            }
            sb2.append(b10);
        } else {
            if (c10 == 'W') {
                str = "WeekOfMonth";
            } else if (c10 == 'c' || c10 == 'e') {
                str = "DayOfWeek";
            } else {
                if (c10 == 'w') {
                    str = "WeekOfWeekBasedYear";
                }
                sb2.append(AppsFlyerKit.COMMA);
                sb2.append(this.f42670b);
            }
            sb2.append(str);
            sb2.append(AppsFlyerKit.COMMA);
            sb2.append(this.f42670b);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
