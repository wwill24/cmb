package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class k extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final k f14812c = new k();

    private k() {
        super(1, 2);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `profiles` (`id` TEXT NOT NULL, `age` INTEGER NOT NULL, `appreciate_in_date` TEXT NOT NULL, `country` TEXT NOT NULL, `employer` TEXT NOT NULL, `ethnicity` TEXT, `first_name` TEXT NOT NULL, `gender` TEXT NOT NULL, `height_cm` INTEGER NOT NULL, `i_am` TEXT NOT NULL, `interested_in` TEXT NOT NULL, `last_name` TEXT NOT NULL, `location` TEXT NOT NULL, `occupation` TEXT NOT NULL, `religion` TEXT, `has_logged_in_recently` INTEGER, `overall_chat_activity` REAL, `chat_initiation_level` REAL, `avg_response_time` REAL, `expiration_date` TEXT, `school` TEXT, `degree_id` TEXT, `first_icebreaker` TEXT NOT NULL, `second_icebreaker` TEXT NOT NULL, `third_icebreaker` TEXT NOT NULL, `secondary_school` TEXT, `secondary_degree_id` TEXT, PRIMARY KEY(`id`))");
        w1.f14850a.b().a(iVar, 1, 2);
    }
}
