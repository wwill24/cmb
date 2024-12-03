package h2;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;
import com.mparticle.identity.IdentityHttpResponse;
import g2.d;
import kotlin.Metadata;
import t1.i;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000¨\u0006\r"}, d2 = {"Landroidx/work/impl/WorkDatabase;", "", "key", "", "d", "value", "", "e", "Landroid/content/Context;", "context", "Lt1/i;", "sqLiteDatabase", "c", "work-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class j {
    public static final void c(Context context, i iVar) {
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(iVar, "sqLiteDatabase");
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i10 = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i11 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            iVar.beginTransaction();
            try {
                iVar.a0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i10)});
                iVar.a0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i11)});
                sharedPreferences.edit().clear().apply();
                iVar.setTransactionSuccessful();
            } finally {
                iVar.endTransaction();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final int d(WorkDatabase workDatabase, String str) {
        int i10;
        Long b10 = workDatabase.G().b(str);
        int i11 = 0;
        if (b10 != null) {
            i10 = (int) b10.longValue();
        } else {
            i10 = 0;
        }
        if (i10 != Integer.MAX_VALUE) {
            i11 = i10 + 1;
        }
        e(workDatabase, str, i11);
        return i10;
    }

    /* access modifiers changed from: private */
    public static final void e(WorkDatabase workDatabase, String str, int i10) {
        workDatabase.G().a(new d(str, Long.valueOf((long) i10)));
    }
}
