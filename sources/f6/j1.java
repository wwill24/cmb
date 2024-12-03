package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class j1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final j1 f14811c = new j1();

    private j1() {
        super(66, 67);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `LikesYouGroupCardCrossRef` (`id` TEXT NOT NULL, `profile_id` TEXT NOT NULL, PRIMARY KEY(`id`, `profile_id`))");
        iVar.D("CREATE INDEX IF NOT EXISTS `index_LikesYouGroupCardCrossRef_id_profile_id` ON `LikesYouGroupCardCrossRef` (`id`, `profile_id`)");
        iVar.D("CREATE TABLE IF NOT EXISTS `LikesYouGroupPaywallCardCrossRef` (`id` TEXT NOT NULL, `profile_id` TEXT NOT NULL, PRIMARY KEY(`id`, `profile_id`))");
        iVar.D("CREATE INDEX IF NOT EXISTS `index_LikesYouGroupPaywallCardCrossRef_id_profile_id` ON `LikesYouGroupPaywallCardCrossRef` (`id`, `profile_id`)");
        iVar.D("CREATE TABLE IF NOT EXISTS `likes_you_group_MERGE_TABLE` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `count` INTEGER NOT NULL, `group_ordinal` INTEGER NOT NULL, `ordered_profile_ids` TEXT NOT NULL, `max_display_count` INTEGER, `contextual_recommendation_icon` TEXT, `contextual_recommendation_text` TEXT, `contextual_recommendation_desc` TEXT, `empty_state_action` TEXT, `empty_state_cta_text` TEXT, `empty_state_description` TEXT, `empty_state_image_url` TEXT, `empty_state_title_text` TEXT, PRIMARY KEY(`id`))");
        iVar.D("INSERT INTO `likes_you_group_MERGE_TABLE` (`id`,`name`,`count`,`group_ordinal`,`ordered_profile_ids`,`max_display_count`,`contextual_recommendation_icon`,`contextual_recommendation_text`,`contextual_recommendation_desc`,`empty_state_action`,`empty_state_cta_text`,`empty_state_description`,`empty_state_image_url`,`empty_state_title_text`) SELECT `likes_you_group`.`id`,`likes_you_group`.`name`,`likes_you_group`.`count`,`likes_you_group`.`group_ordinal`,`likes_you_group`.`ordered_profile_ids`,`likes_you_group`.`max_display_count`,`likes_you_group`.`contextual_recommendation_icon`,`likes_you_group`.`contextual_recommendation_text`,`likes_you_group`.`contextual_recommendation_desc`,`likes_you_group`.`empty_state_action`,`likes_you_group`.`empty_state_cta_text`,`likes_you_group`.`empty_state_description`,`likes_you_group`.`empty_state_image_url`,`likes_you_group`.`empty_state_title_text` FROM `likes_you_group`");
        iVar.D("DROP TABLE IF EXISTS `likes_you_group`");
        iVar.D("ALTER TABLE `likes_you_group_MERGE_TABLE` RENAME TO `likes_you_group`");
    }
}
