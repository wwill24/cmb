package androidx.work.impl;

import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import p1.b;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Landroidx/work/impl/i;", "Lp1/b;", "Lt1/i;", "db", "", "a", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class i extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final i f7569c = new i();

    private i() {
        super(1, 2);
    }

    public void a(t1.i iVar) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        iVar.D("\n    CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id`\n    INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`)\n    REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )\n    ");
        iVar.D("\n    INSERT INTO SystemIdInfo(work_spec_id, system_id)\n    SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo\n    ");
        iVar.D("DROP TABLE IF EXISTS alarmInfo");
        iVar.D("\n                INSERT OR IGNORE INTO worktag(tag, work_spec_id)\n                SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec\n                ");
    }
}
