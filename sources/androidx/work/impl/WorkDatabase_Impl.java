package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.room.j0;
import androidx.room.m;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import g2.a0;
import g2.b;
import g2.c;
import g2.e;
import g2.f;
import g2.g;
import g2.h;
import g2.j;
import g2.k;
import g2.o;
import g2.p;
import g2.r;
import g2.s;
import g2.v;
import g2.w;
import g2.z;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import q1.e;
import t1.i;
import t1.j;

public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: q  reason: collision with root package name */
    private volatile v f7408q;

    /* renamed from: r  reason: collision with root package name */
    private volatile b f7409r;

    /* renamed from: s  reason: collision with root package name */
    private volatile z f7410s;

    /* renamed from: t  reason: collision with root package name */
    private volatile j f7411t;

    /* renamed from: u  reason: collision with root package name */
    private volatile o f7412u;

    /* renamed from: v  reason: collision with root package name */
    private volatile r f7413v;

    /* renamed from: w  reason: collision with root package name */
    private volatile e f7414w;

    class a extends j0.b {
        a(int i10) {
            super(i10);
        }

        public void a(i iVar) {
            iVar.D("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            iVar.D("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            iVar.D("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            iVar.D("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            iVar.D("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5181942b9ebc31ce68dacb56c16fd79f')");
        }

        public void b(i iVar) {
            iVar.D("DROP TABLE IF EXISTS `Dependency`");
            iVar.D("DROP TABLE IF EXISTS `WorkSpec`");
            iVar.D("DROP TABLE IF EXISTS `WorkTag`");
            iVar.D("DROP TABLE IF EXISTS `SystemIdInfo`");
            iVar.D("DROP TABLE IF EXISTS `WorkName`");
            iVar.D("DROP TABLE IF EXISTS `WorkProgress`");
            iVar.D("DROP TABLE IF EXISTS `Preference`");
            if (WorkDatabase_Impl.this.f6763h != null) {
                int size = WorkDatabase_Impl.this.f6763h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) WorkDatabase_Impl.this.f6763h.get(i10)).b(iVar);
                }
            }
        }

        public void c(i iVar) {
            if (WorkDatabase_Impl.this.f6763h != null) {
                int size = WorkDatabase_Impl.this.f6763h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) WorkDatabase_Impl.this.f6763h.get(i10)).a(iVar);
                }
            }
        }

        public void d(i iVar) {
            i unused = WorkDatabase_Impl.this.f6756a = iVar;
            iVar.D("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.w(iVar);
            if (WorkDatabase_Impl.this.f6763h != null) {
                int size = WorkDatabase_Impl.this.f6763h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) WorkDatabase_Impl.this.f6763h.get(i10)).c(iVar);
                }
            }
        }

        public void e(i iVar) {
        }

        public void f(i iVar) {
            q1.b.a(iVar);
        }

        public j0.c g(i iVar) {
            i iVar2 = iVar;
            HashMap hashMap = new HashMap(2);
            hashMap.put("work_spec_id", new e.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
            hashMap.put("prerequisite_id", new e.a("prerequisite_id", "TEXT", true, 2, (String) null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            hashSet.add(new e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new e.C0192e("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
            hashSet2.add(new e.C0192e("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"ASC"})));
            q1.e eVar = new q1.e("Dependency", hashMap, hashSet, hashSet2);
            q1.e a10 = q1.e.a(iVar2, "Dependency");
            if (!eVar.equals(a10)) {
                return new j0.c(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + eVar + "\n Found:\n" + a10);
            }
            HashMap hashMap2 = new HashMap(27);
            hashMap2.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap2.put("state", new e.a("state", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("worker_class_name", new e.a("worker_class_name", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("input_merger_class_name", new e.a("input_merger_class_name", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("input", new e.a("input", "BLOB", true, 0, (String) null, 1));
            hashMap2.put("output", new e.a("output", "BLOB", true, 0, (String) null, 1));
            hashMap2.put("initial_delay", new e.a("initial_delay", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("interval_duration", new e.a("interval_duration", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("flex_duration", new e.a("flex_duration", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("run_attempt_count", new e.a("run_attempt_count", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("backoff_policy", new e.a("backoff_policy", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("backoff_delay_duration", new e.a("backoff_delay_duration", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("last_enqueue_time", new e.a("last_enqueue_time", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("minimum_retention_duration", new e.a("minimum_retention_duration", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("schedule_requested_at", new e.a("schedule_requested_at", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("run_in_foreground", new e.a("run_in_foreground", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("out_of_quota_policy", new e.a("out_of_quota_policy", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("period_count", new e.a("period_count", "INTEGER", true, 0, "0", 1));
            hashMap2.put("generation", new e.a("generation", "INTEGER", true, 0, "0", 1));
            hashMap2.put("required_network_type", new e.a("required_network_type", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("requires_charging", new e.a("requires_charging", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("requires_device_idle", new e.a("requires_device_idle", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("requires_battery_not_low", new e.a("requires_battery_not_low", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("requires_storage_not_low", new e.a("requires_storage_not_low", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("trigger_content_update_delay", new e.a("trigger_content_update_delay", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("trigger_max_content_delay", new e.a("trigger_max_content_delay", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("content_uri_triggers", new e.a("content_uri_triggers", "BLOB", true, 0, (String) null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new e.C0192e("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"}), Arrays.asList(new String[]{"ASC"})));
            hashSet4.add(new e.C0192e("index_WorkSpec_last_enqueue_time", false, Arrays.asList(new String[]{"last_enqueue_time"}), Arrays.asList(new String[]{"ASC"})));
            q1.e eVar2 = new q1.e("WorkSpec", hashMap2, hashSet3, hashSet4);
            q1.e a11 = q1.e.a(iVar2, "WorkSpec");
            if (!eVar2.equals(a11)) {
                return new j0.c(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + eVar2 + "\n Found:\n" + a11);
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("tag", new e.a("tag", "TEXT", true, 1, (String) null, 1));
            hashMap3.put("work_spec_id", new e.a("work_spec_id", "TEXT", true, 2, (String) null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new e.C0192e("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
            q1.e eVar3 = new q1.e("WorkTag", hashMap3, hashSet5, hashSet6);
            q1.e a12 = q1.e.a(iVar2, "WorkTag");
            if (!eVar3.equals(a12)) {
                return new j0.c(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + eVar3 + "\n Found:\n" + a12);
            }
            HashMap hashMap4 = new HashMap(3);
            hashMap4.put("work_spec_id", new e.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
            hashMap4.put("generation", new e.a("generation", "INTEGER", true, 2, "0", 1));
            hashMap4.put("system_id", new e.a("system_id", "INTEGER", true, 0, (String) null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            q1.e eVar4 = new q1.e("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
            q1.e a13 = q1.e.a(iVar2, "SystemIdInfo");
            if (!eVar4.equals(a13)) {
                return new j0.c(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + eVar4 + "\n Found:\n" + a13);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("name", new e.a("name", "TEXT", true, 1, (String) null, 1));
            hashMap5.put("work_spec_id", new e.a("work_spec_id", "TEXT", true, 2, (String) null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new e.C0192e("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
            q1.e eVar5 = new q1.e("WorkName", hashMap5, hashSet8, hashSet9);
            q1.e a14 = q1.e.a(iVar2, "WorkName");
            if (!eVar5.equals(a14)) {
                return new j0.c(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + eVar5 + "\n Found:\n" + a14);
            }
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put("work_spec_id", new e.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
            hashMap6.put("progress", new e.a("progress", "BLOB", true, 0, (String) null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            q1.e eVar6 = new q1.e("WorkProgress", hashMap6, hashSet10, new HashSet(0));
            q1.e a15 = q1.e.a(iVar2, "WorkProgress");
            if (!eVar6.equals(a15)) {
                return new j0.c(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + eVar6 + "\n Found:\n" + a15);
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put(SDKConstants.PARAM_KEY, new e.a(SDKConstants.PARAM_KEY, "TEXT", true, 1, (String) null, 1));
            hashMap7.put("long_value", new e.a("long_value", "INTEGER", false, 0, (String) null, 1));
            q1.e eVar7 = new q1.e("Preference", hashMap7, new HashSet(0), new HashSet(0));
            q1.e a16 = q1.e.a(iVar2, "Preference");
            if (eVar7.equals(a16)) {
                return new j0.c(true, (String) null);
            }
            return new j0.c(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + eVar7 + "\n Found:\n" + a16);
        }
    }

    public b F() {
        b bVar;
        if (this.f7409r != null) {
            return this.f7409r;
        }
        synchronized (this) {
            if (this.f7409r == null) {
                this.f7409r = new c(this);
            }
            bVar = this.f7409r;
        }
        return bVar;
    }

    public g2.e G() {
        g2.e eVar;
        if (this.f7414w != null) {
            return this.f7414w;
        }
        synchronized (this) {
            if (this.f7414w == null) {
                this.f7414w = new f(this);
            }
            eVar = this.f7414w;
        }
        return eVar;
    }

    public j H() {
        j jVar;
        if (this.f7411t != null) {
            return this.f7411t;
        }
        synchronized (this) {
            if (this.f7411t == null) {
                this.f7411t = new k(this);
            }
            jVar = this.f7411t;
        }
        return jVar;
    }

    public o I() {
        o oVar;
        if (this.f7412u != null) {
            return this.f7412u;
        }
        synchronized (this) {
            if (this.f7412u == null) {
                this.f7412u = new p(this);
            }
            oVar = this.f7412u;
        }
        return oVar;
    }

    public r J() {
        r rVar;
        if (this.f7413v != null) {
            return this.f7413v;
        }
        synchronized (this) {
            if (this.f7413v == null) {
                this.f7413v = new s(this);
            }
            rVar = this.f7413v;
        }
        return rVar;
    }

    public v K() {
        v vVar;
        if (this.f7408q != null) {
            return this.f7408q;
        }
        synchronized (this) {
            if (this.f7408q == null) {
                this.f7408q = new w(this);
            }
            vVar = this.f7408q;
        }
        return vVar;
    }

    public z L() {
        z zVar;
        if (this.f7410s != null) {
            return this.f7410s;
        }
        synchronized (this) {
            if (this.f7410s == null) {
                this.f7410s = new a0(this);
            }
            zVar = this.f7410s;
        }
        return zVar;
    }

    /* access modifiers changed from: protected */
    public m h() {
        return new m(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    /* access modifiers changed from: protected */
    public t1.j i(androidx.room.e eVar) {
        return eVar.f6831c.a(j.b.a(eVar.f6829a).d(eVar.f6830b).c(new j0(eVar, new a(16), "5181942b9ebc31ce68dacb56c16fd79f", "ae2044fb577e65ee8bb576ca48a2f06e")).b());
    }

    public List<p1.b> k(@NonNull Map<Class<? extends p1.a>, p1.a> map) {
        return Arrays.asList(new p1.b[]{new c0(), new d0()});
    }

    public Set<Class<? extends p1.a>> p() {
        return new HashSet();
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> q() {
        HashMap hashMap = new HashMap();
        hashMap.put(v.class, w.v());
        hashMap.put(b.class, c.e());
        hashMap.put(z.class, a0.d());
        hashMap.put(g2.j.class, k.h());
        hashMap.put(o.class, p.c());
        hashMap.put(r.class, s.c());
        hashMap.put(g2.e.class, f.c());
        hashMap.put(g.class, h.a());
        return hashMap;
    }
}
