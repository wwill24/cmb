package y6;

import android.content.Context;
import com.coffeemeetsbagel.R;

public class n {
    public static String a(float f10) {
        return Integer.toString((int) (f10 * 100.0f));
    }

    public static String b(Context context, float f10) {
        int c10 = c(f10);
        int d10 = d(f10);
        if (c10 == 0) {
            return context.getResources().getString(R.string.activity_reports_minutes_timestamp, new Object[]{Integer.valueOf(d10)});
        } else if (c10 > 12) {
            return context.getResources().getString(R.string.activity_reports_12_hr_max);
        } else {
            return context.getResources().getString(R.string.activity_reports_hour_minutes_timestamp, new Object[]{Integer.valueOf(c10), Integer.valueOf(d10)});
        }
    }

    public static int c(float f10) {
        return ((int) f10) / 3600;
    }

    private static int d(float f10) {
        return ((int) (f10 % 3600.0f)) / 60;
    }
}
