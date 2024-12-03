package wb;

import android.content.Context;
import android.text.TextUtils;
import com.coffeemeetsbagel.models.RewardPrice;
import com.coffeemeetsbagel.store.domain.VariantUnits;
import com.coffeemeetsbagel.store.r0;
import fa.a;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static NumberFormat f42115a = NumberFormat.getNumberInstance();

    public static BigDecimal a(RewardPrice rewardPrice, int i10, RewardPrice rewardPrice2, int i11) {
        if (!(rewardPrice2 == null || i11 == 0)) {
            BigDecimal valueOf = BigDecimal.valueOf(Double.parseDouble(rewardPrice.getPriceMicros()) / ((double) i10));
            BigDecimal valueOf2 = BigDecimal.valueOf(Double.parseDouble(rewardPrice2.getPriceMicros()) / ((double) i11));
            if (!(valueOf == null || valueOf2 == null)) {
                BigDecimal valueOf3 = BigDecimal.valueOf(100);
                return valueOf3.subtract(valueOf.divide(valueOf2, 2, RoundingMode.UP).multiply(valueOf3)).setScale(0, RoundingMode.UP);
            }
        }
        return null;
    }

    public static String b(RewardPrice rewardPrice) {
        if (TextUtils.isEmpty(rewardPrice.getPriceMicros())) {
            a.i(new Throwable("No micros associated with RewardType"));
            return null;
        }
        BigDecimal scale = BigDecimal.valueOf(Double.valueOf(rewardPrice.getPriceMicros()).doubleValue() / 1000000.0d).setScale(0, RoundingMode.UP);
        f42115a.setMaximumFractionDigits(0);
        return Currency.getInstance(rewardPrice.getCurrencyCode()).getSymbol() + f42115a.format(scale);
    }

    public static String c(RewardPrice rewardPrice, int i10, boolean z10) {
        BigDecimal bigDecimal;
        double doubleValue = Double.valueOf(rewardPrice.getPriceMicros()).doubleValue() / 1000000.0d;
        if (z10) {
            bigDecimal = BigDecimal.valueOf(doubleValue * ((double) i10) * 4.0d);
        } else {
            bigDecimal = BigDecimal.valueOf(doubleValue * ((double) i10));
        }
        return d(bigDecimal, rewardPrice.getCurrencyCode());
    }

    public static String d(BigDecimal bigDecimal, String str) {
        BigDecimal scale = bigDecimal.setScale(0, RoundingMode.UP);
        f42115a.setMaximumFractionDigits(0);
        return Currency.getInstance(str).getSymbol() + f42115a.format(scale);
    }

    public static String e(RewardPrice rewardPrice, int i10) {
        if (TextUtils.isEmpty(rewardPrice.getPriceMicros())) {
            return null;
        }
        BigDecimal f10 = f(rewardPrice.getPriceMicros(), i10);
        f42115a.setMaximumFractionDigits(0);
        return Currency.getInstance(rewardPrice.getCurrencyCode()).getSymbol() + f42115a.format(f10);
    }

    public static BigDecimal f(String str, int i10) {
        if (str == null) {
            return null;
        }
        return BigDecimal.valueOf((Double.valueOf(str).doubleValue() / 1000000.0d) / ((double) i10)).setScale(0, RoundingMode.UP);
    }

    public static String g(Context context, String str) {
        if (TextUtils.equals(str.toLowerCase(), "month") || TextUtils.equals(str.toLowerCase(), "mo")) {
            return context.getString(r0.month_abbreviation);
        }
        return "";
    }

    public static String h(RewardPrice rewardPrice, int i10, String str) {
        double d10;
        double d11;
        if (TextUtils.isEmpty(rewardPrice.getPriceMicros())) {
            return null;
        }
        if (str.equals(VariantUnits.WEEK.b())) {
            d11 = Double.parseDouble(rewardPrice.getPriceMicros()) / 1000000.0d;
            d10 = (double) i10;
        } else {
            d11 = (Double.parseDouble(rewardPrice.getPriceMicros()) / 1000000.0d) / ((double) i10);
            d10 = 4.0d;
        }
        BigDecimal scale = BigDecimal.valueOf(d11 / d10).setScale(0, RoundingMode.UP);
        f42115a.setMaximumFractionDigits(0);
        return Currency.getInstance(rewardPrice.getCurrencyCode()).getSymbol() + f42115a.format(scale);
    }
}
