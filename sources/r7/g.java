package r7;

import android.content.Context;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.enums.Ethnicity;
import com.coffeemeetsbagel.models.enums.Religion;
import com.coffeemeetsbagel.models.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class g {
    public static String a(Context context, int i10, int i11) {
        return String.valueOf(i10) + context.getString(R.string.range_separator) + String.valueOf(i11);
    }

    public static String b(Context context, boolean z10, int i10, int i11) {
        Height height = new Height(i10);
        Height height2 = new Height(i11);
        if (z10) {
            return height.toStringMetric(Bakery.w()) + context.getString(R.string.range_separator) + height2.toStringMetric(Bakery.w());
        }
        return height.toStringImperial() + context.getString(R.string.range_separator) + height2.toStringImperial();
    }

    public static String c(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String[] stringArray = context.getResources().getStringArray(R.array.ethnicity);
        for (String index : list) {
            arrayList.add(stringArray[Ethnicity.getIndex(index)]);
        }
        return StringUtils.join(arrayList);
    }

    public static String d(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String[] stringArray = context.getResources().getStringArray(R.array.religion);
        for (String index : list) {
            arrayList.add(stringArray[Religion.getIndex(index)]);
        }
        return StringUtils.join(arrayList);
    }

    public static String e(Context context, boolean z10, int i10) {
        if (z10) {
            return context.getResources().getQuantityString(R.plurals.x_kms, i10, new Object[]{Integer.valueOf(i10)});
        }
        return context.getResources().getQuantityString(R.plurals.x_miles, i10, new Object[]{Integer.valueOf(i10)});
    }
}
