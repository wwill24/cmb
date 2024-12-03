package vb;

import com.coffeemeetsbagel.models.RewardPrice;
import com.mparticle.kits.MPSideloadedKit;
import fa.a;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f42062a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42063b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42064c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42065d;

    /* renamed from: e  reason: collision with root package name */
    private final String f42066e;

    /* renamed from: f  reason: collision with root package name */
    private final String f42067f;

    /* renamed from: g  reason: collision with root package name */
    private final String f42068g;

    /* renamed from: h  reason: collision with root package name */
    private final long f42069h;

    /* renamed from: i  reason: collision with root package name */
    private final RewardPrice f42070i;

    public d(String str, int i10, String str2, String str3, String str4, String str5, String str6, long j10, RewardPrice rewardPrice) {
        j.g(str2, "unit");
        j.g(str4, "sku");
        j.g(str5, "bundleId");
        this.f42062a = str;
        this.f42063b = i10;
        this.f42064c = str2;
        this.f42065d = str3;
        this.f42066e = str4;
        this.f42067f = str5;
        this.f42068g = str6;
        this.f42069h = j10;
        this.f42070i = rewardPrice;
    }

    public final String a() {
        return this.f42062a;
    }

    public final BigDecimal b() {
        boolean z10;
        RewardPrice rewardPrice = this.f42070i;
        if (rewardPrice != null) {
            if (rewardPrice.getPriceMicros().length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && this.f42063b > 0) {
                BigDecimal scale = BigDecimal.valueOf((Double.valueOf(this.f42070i.getPriceMicros()).doubleValue() / ((double) MPSideloadedKit.MIN_SIDELOADED_KIT)) / ((double) this.f42063b)).setScale(0, RoundingMode.UP);
                j.f(scale, "valueOf(monthlyCost).setScale(0, RoundingMode.UP)");
                return scale;
            }
        }
        BigDecimal bigDecimal = BigDecimal.ZERO;
        j.f(bigDecimal, "ZERO");
        return bigDecimal;
    }

    public final String c() {
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(0);
        StringBuilder sb2 = new StringBuilder();
        RewardPrice rewardPrice = this.f42070i;
        j.d(rewardPrice);
        sb2.append(Currency.getInstance(rewardPrice.getCurrencyCode()).getSymbol());
        sb2.append(numberInstance.format(b()));
        return sb2.toString();
    }

    public final int d() {
        return this.f42063b;
    }

    public final RewardPrice e() {
        return this.f42070i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return j.b(this.f42062a, dVar.f42062a) && this.f42063b == dVar.f42063b && j.b(this.f42064c, dVar.f42064c) && j.b(this.f42065d, dVar.f42065d) && j.b(this.f42066e, dVar.f42066e) && j.b(this.f42067f, dVar.f42067f) && j.b(this.f42068g, dVar.f42068g) && this.f42069h == dVar.f42069h && j.b(this.f42070i, dVar.f42070i);
    }

    public final long f() {
        long currentTimeMillis = this.f42069h - System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            return currentTimeMillis;
        }
        a.C0491a aVar = a.f40771d;
        aVar.a("SubscriptionVariant", "getSaleTimeRemaining() " + currentTimeMillis);
        return 0;
    }

    public final String g() {
        return this.f42065d;
    }

    public final String h() {
        return this.f42066e;
    }

    public int hashCode() {
        String str = this.f42062a;
        int i10 = 0;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.f42063b)) * 31) + this.f42064c.hashCode()) * 31;
        String str2 = this.f42065d;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f42066e.hashCode()) * 31) + this.f42067f.hashCode()) * 31;
        String str3 = this.f42068g;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + Long.hashCode(this.f42069h)) * 31;
        RewardPrice rewardPrice = this.f42070i;
        if (rewardPrice != null) {
            i10 = rewardPrice.hashCode();
        }
        return hashCode3 + i10;
    }

    public final String i() {
        return this.f42064c;
    }

    public final BigDecimal j() {
        boolean z10;
        RewardPrice rewardPrice = this.f42070i;
        if (rewardPrice != null) {
            if (rewardPrice.getPriceMicros().length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && this.f42063b > 0) {
                BigDecimal scale = BigDecimal.valueOf(((Double.valueOf(this.f42070i.getPriceMicros()).doubleValue() / ((double) MPSideloadedKit.MIN_SIDELOADED_KIT)) / ((double) this.f42063b)) / ((double) 4)).setScale(0, RoundingMode.UP);
                j.f(scale, "valueOf(monthlyCost).setScale(0, RoundingMode.UP)");
                return scale;
            }
        }
        BigDecimal bigDecimal = BigDecimal.ZERO;
        j.f(bigDecimal, "ZERO");
        return bigDecimal;
    }

    public final boolean k() {
        return l() && this.f42068g != null;
    }

    public final boolean l() {
        return j.b("popular", this.f42062a);
    }

    public String toString() {
        return "SubscriptionVariant(marketingType=" + this.f42062a + ", numberOfUnits=" + this.f42063b + ", unit=" + this.f42064c + ", savingsComparisonSku=" + this.f42065d + ", sku=" + this.f42066e + ", bundleId=" + this.f42067f + ", saleSkuType=" + this.f42068g + ", saleEndTimeLocal=" + this.f42069h + ", rewardPrice=" + this.f42070i + PropertyUtils.MAPPED_DELIM2;
    }
}
