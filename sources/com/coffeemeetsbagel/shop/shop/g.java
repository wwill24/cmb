package com.coffeemeetsbagel.shop.shop;

import android.text.TextUtils;
import com.coffeemeetsbagel.models.enums.RewardType;
import com.mparticle.kits.MPSideloadedKit;
import fa.a;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import kotlin.jvm.internal.j;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f36534a = new g();

    private g() {
    }

    private final NumberFormat a(String str) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        if (currencyInstance instanceof DecimalFormat) {
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormat().getDecimalFormatSymbols();
            decimalFormatSymbols.setCurrency(Currency.getInstance(str));
            DecimalFormat decimalFormat = (DecimalFormat) currencyInstance;
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            decimalFormat.setMaximumFractionDigits(0);
        }
        j.f(currencyInstance, "format");
        return currencyInstance;
    }

    private final int e(int i10) {
        return ((i10 / 1) + 1) * 1;
    }

    private final int f(String str) {
        if (!TextUtils.isEmpty(str)) {
            return BigDecimal.valueOf(Double.parseDouble(str) / ((double) MPSideloadedKit.MIN_SIDELOADED_KIT)).setScale(0, RoundingMode.UP).intValue();
        }
        a.f40771d.f(new Throwable("Can't get rounded up price from empty price micro."));
        return 0;
    }

    public final String b(long j10, long j11) {
        if (j10 <= 0) {
            return "0%";
        }
        int e10 = e((int) ((((float) (j10 - j11)) / ((float) j10)) * ((float) 100)));
        return e10 + "%";
    }

    public final String c(String str, String str2) {
        j.g(str, "currencyCode");
        j.g(str2, "priceMicro");
        String format2 = a(str).format(Integer.valueOf(f(str2)));
        j.f(format2, "numberFormat.format(getRoundedUpPrice(priceMicro))");
        return format2;
    }

    public final long d(RewardType rewardType) {
        j.g(rewardType, "rewardType");
        String micros = rewardType.getMicros();
        j.f(micros, "rewardType.micros");
        return Long.parseLong(micros) / ((long) rewardType.getRewardAmount());
    }
}
