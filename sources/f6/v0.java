package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class v0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final v0 f14846c = new v0();

    private v0() {
        super(53, 54);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `likes_you_group` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `count` INTEGER NOT NULL, `group_ordinal` INTEGER NOT NULL, `ordered_profile_ids` TEXT NOT NULL, `max_display_count` INTEGER, `contextual_recommendation_icon` TEXT, `contextual_recommendation_text` TEXT, `contextual_recommendation_desc` TEXT, `empty_state_action` TEXT, `empty_state_cta_text` TEXT, `empty_state_description` TEXT, `empty_state_image_url` TEXT, PRIMARY KEY(`id`))");
        iVar.D("CREATE TABLE IF NOT EXISTS `likes_you_card` (`profile_id` TEXT NOT NULL, `group_ids` TEXT NOT NULL, `age` INTEGER NOT NULL, `bagel_id` TEXT NOT NULL, `city` TEXT, `education` TEXT, `occupation` TEXT, `image_url` TEXT, `purchase_attribution` INTEGER, PRIMARY KEY(`profile_id`))");
    }
}
