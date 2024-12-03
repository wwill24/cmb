package h2;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import g2.d;
import t1.i;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private final WorkDatabase f15290a;

    public o(@NonNull WorkDatabase workDatabase) {
        this.f15290a = workDatabase;
    }

    public static void c(@NonNull Context context, @NonNull i iVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j10 = 0;
            long j11 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
            if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                j10 = 1;
            }
            iVar.beginTransaction();
            try {
                iVar.a0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j11)});
                iVar.a0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j10)});
                sharedPreferences.edit().clear().apply();
                iVar.setTransactionSuccessful();
            } finally {
                iVar.endTransaction();
            }
        }
    }

    public long a() {
        Long b10 = this.f15290a.G().b("last_force_stop_ms");
        if (b10 != null) {
            return b10.longValue();
        }
        return 0;
    }

    public boolean b() {
        Long b10 = this.f15290a.G().b("reschedule_needed");
        if (b10 == null || b10.longValue() != 1) {
            return false;
        }
        return true;
    }

    public void d(long j10) {
        this.f15290a.G().a(new d("last_force_stop_ms", Long.valueOf(j10)));
    }

    public void e(boolean z10) {
        this.f15290a.G().a(new d("reschedule_needed", z10));
    }
}
