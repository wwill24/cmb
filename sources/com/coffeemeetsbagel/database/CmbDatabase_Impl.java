package com.coffeemeetsbagel.database;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.room.j0;
import androidx.room.m;
import com.coffeemeetsbagel.database.daos.ActionCardRoomDao;
import com.coffeemeetsbagel.database.daos.ActiveSubscriptionRoomDao;
import com.coffeemeetsbagel.database.daos.CapabilityRoomDao;
import com.coffeemeetsbagel.database.daos.ConnectionDetailsRoomDao;
import com.coffeemeetsbagel.database.daos.MatchContextRoomDao;
import com.coffeemeetsbagel.database.daos.PendingMessageRoomDao;
import com.coffeemeetsbagel.database.daos.ProfileRoomDao;
import com.coffeemeetsbagel.database.daos.ResourceRoomDao;
import com.coffeemeetsbagel.database.daos.StickerRoomDao;
import com.coffeemeetsbagel.database.daos.SubscriptionBundleRoomDao;
import com.coffeemeetsbagel.database.daos.a0;
import com.coffeemeetsbagel.database.daos.a1;
import com.coffeemeetsbagel.database.daos.b0;
import com.coffeemeetsbagel.database.daos.b1;
import com.coffeemeetsbagel.database.daos.c0;
import com.coffeemeetsbagel.database.daos.c1;
import com.coffeemeetsbagel.database.daos.d0;
import com.coffeemeetsbagel.database.daos.d1;
import com.coffeemeetsbagel.database.daos.e0;
import com.coffeemeetsbagel.database.daos.e1;
import com.coffeemeetsbagel.database.daos.f1;
import com.coffeemeetsbagel.database.daos.g;
import com.coffeemeetsbagel.database.daos.h;
import com.coffeemeetsbagel.database.daos.j;
import com.coffeemeetsbagel.database.daos.k;
import com.coffeemeetsbagel.database.daos.k0;
import com.coffeemeetsbagel.database.daos.l0;
import com.coffeemeetsbagel.database.daos.n;
import com.coffeemeetsbagel.database.daos.n0;
import com.coffeemeetsbagel.database.daos.o0;
import com.coffeemeetsbagel.database.daos.p0;
import com.coffeemeetsbagel.database.daos.r0;
import com.coffeemeetsbagel.database.daos.s;
import com.coffeemeetsbagel.database.daos.u;
import com.coffeemeetsbagel.database.daos.v;
import com.coffeemeetsbagel.database.daos.w;
import com.coffeemeetsbagel.database.daos.x;
import com.coffeemeetsbagel.database.daos.y;
import com.coffeemeetsbagel.database.daos.y0;
import com.coffeemeetsbagel.likes_you.LikesYouGroupRoomDao;
import com.coffeemeetsbagel.likes_you.d;
import com.coffeemeetsbagel.likes_you.o;
import com.coffeemeetsbagel.likes_you.p;
import com.coffeemeetsbagel.likes_you.q;
import com.coffeemeetsbagel.likes_you.r;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.qna.QuestionDaoV2Impl;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.leanplum.internal.Constants;
import eb.b;
import eb.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;
import q1.e;
import t1.i;
import t1.j;

public final class CmbDatabase_Impl extends CmbDatabase {
    private volatile a1 A;
    private volatile n B;
    private volatile ActiveSubscriptionRoomDao C;
    private volatile CapabilityRoomDao D;
    private volatile StickerRoomDao E;
    private volatile SubscriptionBundleRoomDao F;
    private volatile QuestionDaoV2Impl G;
    private volatile ResourceRoomDao H;
    private volatile d0 I;
    private volatile b J;
    private volatile ConnectionDetailsRoomDao K;
    private volatile d L;
    private volatile LikesYouGroupRoomDao M;
    private volatile o N;
    private volatile q O;
    private volatile c1 P;
    private volatile o0 Q;

    /* renamed from: q  reason: collision with root package name */
    private volatile ProfileRoomDao f11594q;

    /* renamed from: r  reason: collision with root package name */
    private volatile e1 f11595r;

    /* renamed from: s  reason: collision with root package name */
    private volatile b0 f11596s;

    /* renamed from: t  reason: collision with root package name */
    private volatile h f11597t;

    /* renamed from: u  reason: collision with root package name */
    private volatile v f11598u;

    /* renamed from: v  reason: collision with root package name */
    private volatile MatchContextRoomDao f11599v;

    /* renamed from: w  reason: collision with root package name */
    private volatile k0 f11600w;

    /* renamed from: x  reason: collision with root package name */
    private volatile j f11601x;

    /* renamed from: y  reason: collision with root package name */
    private volatile PendingMessageRoomDao f11602y;

    /* renamed from: z  reason: collision with root package name */
    private volatile ActionCardRoomDao f11603z;

    class a extends j0.b {
        a(int i10) {
            super(i10);
        }

        public void a(i iVar) {
            iVar.D("CREATE TABLE IF NOT EXISTS `profiles` (`id` TEXT NOT NULL, `age` INTEGER NOT NULL, `city` TEXT NOT NULL, `country` TEXT NOT NULL, `employer` TEXT NOT NULL, `ethnicities` TEXT NOT NULL, `first_name` TEXT NOT NULL, `gender` TEXT NOT NULL, `last_name` TEXT NOT NULL, `occupation` TEXT NOT NULL, `religion` TEXT, `state` TEXT NOT NULL, `school` TEXT, `degree_id` TEXT, `height_cm` INTEGER, `height_feet` INTEGER, `height_inches` INTEGER, `secondary_school` TEXT, `secondary_degree_id` TEXT, PRIMARY KEY(`id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `user` (`profile_id` TEXT NOT NULL, `appsFlyerId` TEXT, `emailAddress` TEXT, `is_eligible_for_free_trial` INTEGER NOT NULL, `registeredDate` TEXT, `beans` INTEGER NOT NULL, `birthDay` TEXT, `matchRegion` TEXT, `onHold` INTEGER NOT NULL, `deactivateReason` TEXT, `dateReactivated` TEXT, `location` TEXT, `viewedCoachMarks` TEXT NOT NULL, `referralCode` TEXT, `badgeCount` INTEGER NOT NULL, `appLaunchStreak` INTEGER NOT NULL, `hasPrioritizedLikes` INTEGER NOT NULL, `hasActiveBoost` INTEGER NOT NULL, `boostReportId` TEXT, `numRisingBagels` INTEGER NOT NULL, `lastName` TEXT, `zipCode` TEXT, `usesMetric` INTEGER NOT NULL, `ageFrom` INTEGER, `ageTo` INTEGER, `ethnicity` TEXT, `gender` TEXT, `religion` TEXT, `maxDistanceMiles` INTEGER NOT NULL, `maxDistanceKm` INTEGER NOT NULL, `heightFeetFrom` INTEGER, `heightFeetTo` INTEGER, `heightInchFrom` INTEGER, `heightInchTo` INTEGER, `heightCmFrom` INTEGER, `heightCmTo` INTEGER, `first_icebreaker` TEXT NOT NULL, `second_icebreaker` TEXT NOT NULL, `third_icebreaker` TEXT NOT NULL, PRIMARY KEY(`profile_id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `photos` (`photoId` TEXT NOT NULL, `caption` TEXT, `position` INTEGER NOT NULL, `profile_id` TEXT NOT NULL, `url` TEXT NOT NULL, PRIMARY KEY(`photoId`), FOREIGN KEY(`profile_id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_photos_profile_id` ON `photos` (`profile_id`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `activity_reports` (`profile_id` TEXT NOT NULL, `has_logged_in_recently` INTEGER, `overall_chat_activity` REAL, `chat_initiation_level` REAL, `avg_response_time` REAL, `expiration_date` TEXT NOT NULL, PRIMARY KEY(`profile_id`), FOREIGN KEY(`profile_id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_activity_reports_profile_id` ON `activity_reports` (`profile_id`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `matches` (`id` TEXT NOT NULL, `action` INTEGER NOT NULL, `end_at` TEXT NOT NULL, `is_blocked` INTEGER NOT NULL, `is_rising` INTEGER NOT NULL, `like_comment` TEXT, `message` TEXT, `profile_id` TEXT NOT NULL, `rising_count` INTEGER NOT NULL, `show_order` INTEGER, `start_at` TEXT NOT NULL, `type` TEXT NOT NULL, `woo_count` INTEGER NOT NULL, `woo_seen_count` INTEGER NOT NULL, `purchase_attribution` INTEGER, `match_to_me` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`profile_id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            iVar.D("CREATE UNIQUE INDEX IF NOT EXISTS `index_matches_profile_id_type_action` ON `matches` (`profile_id`, `type`, `action`)");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_matches_type_action` ON `matches` (`type`, `action`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `match_context` (`match_id` TEXT NOT NULL, `icon` TEXT, `title` TEXT, `body` TEXT, PRIMARY KEY(`match_id`))");
            iVar.D("CREATE UNIQUE INDEX IF NOT EXISTS `index_match_context_match_id` ON `match_context` (`match_id`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `questions` (`id` TEXT NOT NULL, `group` TEXT NOT NULL, `placeholder` TEXT, `type` TEXT NOT NULL, `label` TEXT NOT NULL, `text` TEXT NOT NULL, `name` TEXT NOT NULL, `max_options` INTEGER, PRIMARY KEY(`id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `question_groups` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `maxAllowed` INTEGER, `max_sub_options` INTEGER, PRIMARY KEY(`id`))");
            iVar.D("CREATE UNIQUE INDEX IF NOT EXISTS `index_question_groups_name` ON `question_groups` (`name`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `options` (`id` TEXT NOT NULL, `question_id` TEXT NOT NULL, `title` TEXT NOT NULL, `name` TEXT, PRIMARY KEY(`id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `answers` (`answer_id` TEXT NOT NULL, `option_id` TEXT NOT NULL, `profile_id` TEXT NOT NULL, `question_id` TEXT NOT NULL, `text_value` TEXT NOT NULL, `integer_value` INTEGER, `float_value` REAL, `max_value` REAL, `min_value` REAL, `location` TEXT, `is_dealbreaker` INTEGER, `json_type` TEXT, PRIMARY KEY(`option_id`, `profile_id`, `question_id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `pending_messages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `bagel_id` TEXT NOT NULL, `status` TEXT NOT NULL, `text` TEXT NOT NULL, `time_sent` TEXT, `type` TEXT NOT NULL)");
            iVar.D("CREATE TABLE IF NOT EXISTS `action_card` (`id` TEXT NOT NULL, `action` TEXT NOT NULL, `action_text` TEXT NOT NULL, `header_text` TEXT NOT NULL, `image_url` TEXT NOT NULL, `message_text` TEXT NOT NULL, PRIMARY KEY(`id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `subscription_benefits` (`key` TEXT NOT NULL, `cached_at` INTEGER NOT NULL, `deep_link_tags` TEXT NOT NULL, `description` TEXT NOT NULL, `icon_url` TEXT NOT NULL, `image_url` TEXT NOT NULL, `title` TEXT NOT NULL, `small_title_display` TEXT, PRIMARY KEY(`key`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `active_subscription` (`auto_renew` INTEGER NOT NULL, `benefits` TEXT NOT NULL, `expiry_date` TEXT, `sku` TEXT NOT NULL, `start_date` TEXT NOT NULL, `bundle_id` TEXT NOT NULL DEFAULT '', `subscription_state` INTEGER, `tier` INTEGER NOT NULL DEFAULT 0, `purchase_token` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`sku`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `subscription_variants` (`bundle_id` TEXT NOT NULL DEFAULT '', `marketing_type` TEXT, `number_of_units` INTEGER NOT NULL, `unit` TEXT NOT NULL, `savings_comparison_sku` TEXT, `sale_full_price_comparison_sku` TEXT, `sale_sku_type` TEXT, `sale_start_time` INTEGER NOT NULL, `sale_end_time` INTEGER NOT NULL, `sku` TEXT NOT NULL, PRIMARY KEY(`sku`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `capability` (`capability` TEXT NOT NULL, `enabled` INTEGER NOT NULL, PRIMARY KEY(`capability`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `stickers` (`name` TEXT NOT NULL, `description` TEXT NOT NULL, `image_url` TEXT NOT NULL, PRIMARY KEY(`image_url`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `subscription_bundles` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `tier` INTEGER NOT NULL, `intents` TEXT NOT NULL, `benefit_keys` TEXT NOT NULL, `variant_skus` TEXT NOT NULL, PRIMARY KEY(`id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `prices` (`name` TEXT NOT NULL, `beans` INTEGER NOT NULL, `free_item_count` INTEGER NOT NULL, `image_url` TEXT NOT NULL, `tint_color` TEXT NOT NULL, `is_unlimited` INTEGER NOT NULL, PRIMARY KEY(`name`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `resources` (`resource_key` TEXT NOT NULL, `resource_value` TEXT NOT NULL, `resource_list_name` TEXT NOT NULL, PRIMARY KEY(`resource_key`, `resource_list_name`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `schools` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL)");
            iVar.D("CREATE UNIQUE INDEX IF NOT EXISTS `index_schools_name` ON `schools` (`name`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `connection_details` (`profileId` TEXT NOT NULL, `unreadMessageCount` INTEGER NOT NULL, `lastMessageText` TEXT, `lastMessageDate` TEXT, `pairReadReceiptDate` TEXT, `lastSenderProfileId` TEXT, `lastMessageReadTimestamp` TEXT, PRIMARY KEY(`profileId`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `likes_you_group` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `count` INTEGER NOT NULL, `group_ordinal` INTEGER NOT NULL, `ordered_profile_ids` TEXT NOT NULL, `max_display_count` INTEGER, `contextual_recommendation_icon` TEXT, `contextual_recommendation_text` TEXT, `contextual_recommendation_desc` TEXT, `empty_state_action` TEXT, `empty_state_cta_text` TEXT, `empty_state_description` TEXT, `empty_state_image_url` TEXT, `empty_state_title_text` TEXT, PRIMARY KEY(`id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `likes_you_card` (`profile_id` TEXT NOT NULL, `group_ids` TEXT NOT NULL, `age` INTEGER NOT NULL, `bagel_id` TEXT NOT NULL, `city` TEXT, `education` TEXT, `occupation` TEXT, `pair_like_comment` TEXT, `image_url` TEXT, `purchase_attribution` INTEGER, PRIMARY KEY(`profile_id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `likes_you_paywall_card` (`profile_id` TEXT NOT NULL, `image_url` TEXT NOT NULL, `purchase_attribution` INTEGER, PRIMARY KEY(`profile_id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `LikesYouGroupCardCrossRef` (`id` TEXT NOT NULL, `profile_id` TEXT NOT NULL, PRIMARY KEY(`id`, `profile_id`))");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_LikesYouGroupCardCrossRef_id_profile_id` ON `LikesYouGroupCardCrossRef` (`id`, `profile_id`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `LikesYouGroupPaywallCardCrossRef` (`id` TEXT NOT NULL, `profile_id` TEXT NOT NULL, PRIMARY KEY(`id`, `profile_id`))");
            iVar.D("CREATE INDEX IF NOT EXISTS `index_LikesYouGroupPaywallCardCrossRef_id_profile_id` ON `LikesYouGroupPaywallCardCrossRef` (`id`, `profile_id`)");
            iVar.D("CREATE TABLE IF NOT EXISTS `suggested_limits` (`id` INTEGER NOT NULL, `remaining_likes` INTEGER, `remaining_views` INTEGER, `num_bagels_required_for_upsell` INTEGER, PRIMARY KEY(`id`))");
            iVar.D("CREATE TABLE IF NOT EXISTS `retry_calls` (`internalTag` TEXT NOT NULL, `payloadObject` TEXT NOT NULL, `lastTimeTried` INTEGER NOT NULL, `timesTriedSoFar` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
            iVar.D("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            iVar.D("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c1b65a11a5096aa5d1ad98085831dd1c')");
        }

        public void b(i iVar) {
            iVar.D("DROP TABLE IF EXISTS `profiles`");
            iVar.D("DROP TABLE IF EXISTS `user`");
            iVar.D("DROP TABLE IF EXISTS `photos`");
            iVar.D("DROP TABLE IF EXISTS `activity_reports`");
            iVar.D("DROP TABLE IF EXISTS `matches`");
            iVar.D("DROP TABLE IF EXISTS `match_context`");
            iVar.D("DROP TABLE IF EXISTS `questions`");
            iVar.D("DROP TABLE IF EXISTS `question_groups`");
            iVar.D("DROP TABLE IF EXISTS `options`");
            iVar.D("DROP TABLE IF EXISTS `answers`");
            iVar.D("DROP TABLE IF EXISTS `pending_messages`");
            iVar.D("DROP TABLE IF EXISTS `action_card`");
            iVar.D("DROP TABLE IF EXISTS `subscription_benefits`");
            iVar.D("DROP TABLE IF EXISTS `active_subscription`");
            iVar.D("DROP TABLE IF EXISTS `subscription_variants`");
            iVar.D("DROP TABLE IF EXISTS `capability`");
            iVar.D("DROP TABLE IF EXISTS `stickers`");
            iVar.D("DROP TABLE IF EXISTS `subscription_bundles`");
            iVar.D("DROP TABLE IF EXISTS `prices`");
            iVar.D("DROP TABLE IF EXISTS `resources`");
            iVar.D("DROP TABLE IF EXISTS `schools`");
            iVar.D("DROP TABLE IF EXISTS `connection_details`");
            iVar.D("DROP TABLE IF EXISTS `likes_you_group`");
            iVar.D("DROP TABLE IF EXISTS `likes_you_card`");
            iVar.D("DROP TABLE IF EXISTS `likes_you_paywall_card`");
            iVar.D("DROP TABLE IF EXISTS `LikesYouGroupCardCrossRef`");
            iVar.D("DROP TABLE IF EXISTS `LikesYouGroupPaywallCardCrossRef`");
            iVar.D("DROP TABLE IF EXISTS `suggested_limits`");
            iVar.D("DROP TABLE IF EXISTS `retry_calls`");
            if (CmbDatabase_Impl.this.f6763h != null) {
                int size = CmbDatabase_Impl.this.f6763h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) CmbDatabase_Impl.this.f6763h.get(i10)).b(iVar);
                }
            }
        }

        public void c(i iVar) {
            if (CmbDatabase_Impl.this.f6763h != null) {
                int size = CmbDatabase_Impl.this.f6763h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) CmbDatabase_Impl.this.f6763h.get(i10)).a(iVar);
                }
            }
        }

        public void d(i iVar) {
            i unused = CmbDatabase_Impl.this.f6756a = iVar;
            iVar.D("PRAGMA foreign_keys = ON");
            CmbDatabase_Impl.this.w(iVar);
            if (CmbDatabase_Impl.this.f6763h != null) {
                int size = CmbDatabase_Impl.this.f6763h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) CmbDatabase_Impl.this.f6763h.get(i10)).c(iVar);
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
            HashMap hashMap = new HashMap(19);
            hashMap.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap.put("age", new e.a("age", "INTEGER", true, 0, (String) null, 1));
            hashMap.put(Constants.Keys.CITY, new e.a(Constants.Keys.CITY, "TEXT", true, 0, (String) null, 1));
            hashMap.put("country", new e.a("country", "TEXT", true, 0, (String) null, 1));
            hashMap.put(ProfileConstants.Field.USER_EMPLOYER, new e.a(ProfileConstants.Field.USER_EMPLOYER, "TEXT", true, 0, (String) null, 1));
            hashMap.put("ethnicities", new e.a("ethnicities", "TEXT", true, 0, (String) null, 1));
            hashMap.put("first_name", new e.a("first_name", "TEXT", true, 0, (String) null, 1));
            hashMap.put(ProfileConstants.Field.GENDER, new e.a(ProfileConstants.Field.GENDER, "TEXT", true, 0, (String) null, 1));
            hashMap.put("last_name", new e.a("last_name", "TEXT", true, 0, (String) null, 1));
            hashMap.put(ProfileConstants.Field.USER_OCCUPATION, new e.a(ProfileConstants.Field.USER_OCCUPATION, "TEXT", true, 0, (String) null, 1));
            hashMap.put(ProfileConstants.Field.RELIGION, new e.a(ProfileConstants.Field.RELIGION, "TEXT", false, 0, (String) null, 1));
            hashMap.put("state", new e.a("state", "TEXT", true, 0, (String) null, 1));
            hashMap.put("school", new e.a("school", "TEXT", false, 0, (String) null, 1));
            hashMap.put("degree_id", new e.a("degree_id", "TEXT", false, 0, (String) null, 1));
            hashMap.put(ProfileConstants.Field.HEIGHT_CM, new e.a(ProfileConstants.Field.HEIGHT_CM, "INTEGER", false, 0, (String) null, 1));
            hashMap.put(ProfileConstants.Field.HEIGHT_FEET, new e.a(ProfileConstants.Field.HEIGHT_FEET, "INTEGER", false, 0, (String) null, 1));
            hashMap.put(ProfileConstants.Field.HEIGHT_INCHES, new e.a(ProfileConstants.Field.HEIGHT_INCHES, "INTEGER", false, 0, (String) null, 1));
            hashMap.put("secondary_school", new e.a("secondary_school", "TEXT", false, 0, (String) null, 1));
            hashMap.put("secondary_degree_id", new e.a("secondary_degree_id", "TEXT", false, 0, (String) null, 1));
            e eVar = new e("profiles", hashMap, new HashSet(0), new HashSet(0));
            e a10 = e.a(iVar2, "profiles");
            if (!eVar.equals(a10)) {
                return new j0.c(false, "profiles(com.coffeemeetsbagel.models.entities.ProfileEntity).\n Expected:\n" + eVar + "\n Found:\n" + a10);
            }
            HashMap hashMap2 = new HashMap(39);
            hashMap2.put(Extra.PROFILE_ID, new e.a(Extra.PROFILE_ID, "TEXT", true, 1, (String) null, 1));
            hashMap2.put("appsFlyerId", new e.a("appsFlyerId", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("emailAddress", new e.a("emailAddress", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("is_eligible_for_free_trial", new e.a("is_eligible_for_free_trial", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("registeredDate", new e.a("registeredDate", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("beans", new e.a("beans", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("birthDay", new e.a("birthDay", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("matchRegion", new e.a("matchRegion", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("onHold", new e.a("onHold", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("deactivateReason", new e.a("deactivateReason", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("dateReactivated", new e.a("dateReactivated", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("location", new e.a("location", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("viewedCoachMarks", new e.a("viewedCoachMarks", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("referralCode", new e.a("referralCode", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("badgeCount", new e.a("badgeCount", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("appLaunchStreak", new e.a("appLaunchStreak", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("hasPrioritizedLikes", new e.a("hasPrioritizedLikes", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("hasActiveBoost", new e.a("hasActiveBoost", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("boostReportId", new e.a("boostReportId", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("numRisingBagels", new e.a("numRisingBagels", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("lastName", new e.a("lastName", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("zipCode", new e.a("zipCode", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("usesMetric", new e.a("usesMetric", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("ageFrom", new e.a("ageFrom", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("ageTo", new e.a("ageTo", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("ethnicity", new e.a("ethnicity", "TEXT", false, 0, (String) null, 1));
            hashMap2.put(ProfileConstants.Field.GENDER, new e.a(ProfileConstants.Field.GENDER, "TEXT", false, 0, (String) null, 1));
            hashMap2.put(ProfileConstants.Field.RELIGION, new e.a(ProfileConstants.Field.RELIGION, "TEXT", false, 0, (String) null, 1));
            hashMap2.put("maxDistanceMiles", new e.a("maxDistanceMiles", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("maxDistanceKm", new e.a("maxDistanceKm", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("heightFeetFrom", new e.a("heightFeetFrom", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("heightFeetTo", new e.a("heightFeetTo", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("heightInchFrom", new e.a("heightInchFrom", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("heightInchTo", new e.a("heightInchTo", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("heightCmFrom", new e.a("heightCmFrom", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("heightCmTo", new e.a("heightCmTo", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("first_icebreaker", new e.a("first_icebreaker", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("second_icebreaker", new e.a("second_icebreaker", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("third_icebreaker", new e.a("third_icebreaker", "TEXT", true, 0, (String) null, 1));
            e eVar2 = new e("user", hashMap2, new HashSet(0), new HashSet(0));
            e a11 = e.a(iVar2, "user");
            if (!eVar2.equals(a11)) {
                return new j0.c(false, "user(com.coffeemeetsbagel.myprofile.UserEntity).\n Expected:\n" + eVar2 + "\n Found:\n" + a11);
            }
            HashMap hashMap3 = new HashMap(5);
            hashMap3.put("photoId", new e.a("photoId", "TEXT", true, 1, (String) null, 1));
            hashMap3.put("caption", new e.a("caption", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("position", new e.a("position", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put(Extra.PROFILE_ID, new e.a(Extra.PROFILE_ID, "TEXT", true, 0, (String) null, 1));
            hashMap3.put("url", new e.a("url", "TEXT", true, 0, (String) null, 1));
            HashSet hashSet = new HashSet(1);
            hashSet.add(new e.c("profiles", "CASCADE", "NO ACTION", Arrays.asList(new String[]{Extra.PROFILE_ID}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new e.C0192e("index_photos_profile_id", false, Arrays.asList(new String[]{Extra.PROFILE_ID}), Arrays.asList(new String[]{"ASC"})));
            e eVar3 = new e("photos", hashMap3, hashSet, hashSet2);
            e a12 = e.a(iVar2, "photos");
            if (!eVar3.equals(a12)) {
                return new j0.c(false, "photos(com.coffeemeetsbagel.models.entities.PhotoEntity).\n Expected:\n" + eVar3 + "\n Found:\n" + a12);
            }
            HashMap hashMap4 = new HashMap(6);
            hashMap4.put(Extra.PROFILE_ID, new e.a(Extra.PROFILE_ID, "TEXT", true, 1, (String) null, 1));
            hashMap4.put("has_logged_in_recently", new e.a("has_logged_in_recently", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("overall_chat_activity", new e.a("overall_chat_activity", "REAL", false, 0, (String) null, 1));
            hashMap4.put("chat_initiation_level", new e.a("chat_initiation_level", "REAL", false, 0, (String) null, 1));
            hashMap4.put("avg_response_time", new e.a("avg_response_time", "REAL", false, 0, (String) null, 1));
            hashMap4.put("expiration_date", new e.a("expiration_date", "TEXT", true, 0, (String) null, 1));
            HashSet hashSet3 = new HashSet(1);
            hashSet3.add(new e.c("profiles", "CASCADE", "NO ACTION", Arrays.asList(new String[]{Extra.PROFILE_ID}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet4 = new HashSet(1);
            hashSet4.add(new e.C0192e("index_activity_reports_profile_id", false, Arrays.asList(new String[]{Extra.PROFILE_ID}), Arrays.asList(new String[]{"ASC"})));
            e eVar4 = new e("activity_reports", hashMap4, hashSet3, hashSet4);
            e a13 = e.a(iVar2, "activity_reports");
            if (!eVar4.equals(a13)) {
                return new j0.c(false, "activity_reports(com.coffeemeetsbagel.models.entities.ActivityReportEntity).\n Expected:\n" + eVar4 + "\n Found:\n" + a13);
            }
            HashMap hashMap5 = new HashMap(16);
            hashMap5.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap5.put("action", new e.a("action", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("end_at", new e.a("end_at", "TEXT", true, 0, (String) null, 1));
            hashMap5.put("is_blocked", new e.a("is_blocked", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("is_rising", new e.a("is_rising", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("like_comment", new e.a("like_comment", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("message", new e.a("message", "TEXT", false, 0, (String) null, 1));
            hashMap5.put(Extra.PROFILE_ID, new e.a(Extra.PROFILE_ID, "TEXT", true, 0, (String) null, 1));
            hashMap5.put("rising_count", new e.a("rising_count", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("show_order", new e.a("show_order", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("start_at", new e.a("start_at", "TEXT", true, 0, (String) null, 1));
            hashMap5.put("type", new e.a("type", "TEXT", true, 0, (String) null, 1));
            hashMap5.put("woo_count", new e.a("woo_count", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("woo_seen_count", new e.a("woo_seen_count", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("purchase_attribution", new e.a("purchase_attribution", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("match_to_me", new e.a("match_to_me", "TEXT", true, 0, (String) null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new e.c("profiles", "CASCADE", "NO ACTION", Arrays.asList(new String[]{Extra.PROFILE_ID}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet6 = new HashSet(2);
            List asList = Arrays.asList(new String[]{Extra.PROFILE_ID, "type", "action"});
            Object obj = "purchase_attribution";
            List asList2 = Arrays.asList(new String[]{"ASC", "ASC", "ASC"});
            Object obj2 = ProfileConstants.Field.USER_OCCUPATION;
            Object obj3 = Constants.Keys.CITY;
            hashSet6.add(new e.C0192e("index_matches_profile_id_type_action", true, asList, asList2));
            hashSet6.add(new e.C0192e("index_matches_type_action", false, Arrays.asList(new String[]{"type", "action"}), Arrays.asList(new String[]{"ASC", "ASC"})));
            e eVar5 = new e("matches", hashMap5, hashSet5, hashSet6);
            e a14 = e.a(iVar2, "matches");
            if (!eVar5.equals(a14)) {
                return new j0.c(false, "matches(com.coffeemeetsbagel.models.entities.MatchEntity).\n Expected:\n" + eVar5 + "\n Found:\n" + a14);
            }
            HashMap hashMap6 = new HashMap(4);
            hashMap6.put("match_id", new e.a("match_id", "TEXT", true, 1, (String) null, 1));
            hashMap6.put(SoftwareInfoForm.ICON, new e.a(SoftwareInfoForm.ICON, "TEXT", false, 0, (String) null, 1));
            hashMap6.put("title", new e.a("title", "TEXT", false, 0, (String) null, 1));
            hashMap6.put("body", new e.a("body", "TEXT", false, 0, (String) null, 1));
            HashSet hashSet7 = new HashSet(0);
            HashSet hashSet8 = new HashSet(1);
            Object obj4 = "age";
            hashSet8.add(new e.C0192e("index_match_context_match_id", true, Arrays.asList(new String[]{"match_id"}), Arrays.asList(new String[]{"ASC"})));
            e eVar6 = new e("match_context", hashMap6, hashSet7, hashSet8);
            e a15 = e.a(iVar2, "match_context");
            if (!eVar6.equals(a15)) {
                return new j0.c(false, "match_context(com.coffeemeetsbagel.models.entities.MatchContextEntity).\n Expected:\n" + eVar6 + "\n Found:\n" + a15);
            }
            HashMap hashMap7 = new HashMap(8);
            hashMap7.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap7.put("group", new e.a("group", "TEXT", true, 0, (String) null, 1));
            hashMap7.put("placeholder", new e.a("placeholder", "TEXT", false, 0, (String) null, 1));
            hashMap7.put("type", new e.a("type", "TEXT", true, 0, (String) null, 1));
            hashMap7.put("label", new e.a("label", "TEXT", true, 0, (String) null, 1));
            hashMap7.put("text", new e.a("text", "TEXT", true, 0, (String) null, 1));
            hashMap7.put("name", new e.a("name", "TEXT", true, 0, (String) null, 1));
            hashMap7.put("max_options", new e.a("max_options", "INTEGER", false, 0, (String) null, 1));
            e eVar7 = new e(ProfileConstants.Field.QUESTIONS, hashMap7, new HashSet(0), new HashSet(0));
            e a16 = e.a(iVar2, ProfileConstants.Field.QUESTIONS);
            if (!eVar7.equals(a16)) {
                return new j0.c(false, "questions(com.coffeemeetsbagel.qna.data.db.QuestionEntity).\n Expected:\n" + eVar7 + "\n Found:\n" + a16);
            }
            HashMap hashMap8 = new HashMap(4);
            hashMap8.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap8.put("name", new e.a("name", "TEXT", true, 0, (String) null, 1));
            hashMap8.put("maxAllowed", new e.a("maxAllowed", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("max_sub_options", new e.a("max_sub_options", "INTEGER", false, 0, (String) null, 1));
            HashSet hashSet9 = new HashSet(0);
            HashSet hashSet10 = new HashSet(1);
            String str = "ASC";
            hashSet10.add(new e.C0192e("index_question_groups_name", true, Arrays.asList(new String[]{"name"}), Arrays.asList(new String[]{"ASC"})));
            e eVar8 = new e("question_groups", hashMap8, hashSet9, hashSet10);
            e a17 = e.a(iVar2, "question_groups");
            if (!eVar8.equals(a17)) {
                return new j0.c(false, "question_groups(com.coffeemeetsbagel.qna.data.db.QuestionGroupEntity).\n Expected:\n" + eVar8 + "\n Found:\n" + a17);
            }
            HashMap hashMap9 = new HashMap(4);
            hashMap9.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap9.put("question_id", new e.a("question_id", "TEXT", true, 0, (String) null, 1));
            hashMap9.put("title", new e.a("title", "TEXT", true, 0, (String) null, 1));
            hashMap9.put("name", new e.a("name", "TEXT", false, 0, (String) null, 1));
            e eVar9 = new e(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, hashMap9, new HashSet(0), new HashSet(0));
            e a18 = e.a(iVar2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            if (!eVar9.equals(a18)) {
                return new j0.c(false, "options(com.coffeemeetsbagel.qna.data.db.OptionEntity).\n Expected:\n" + eVar9 + "\n Found:\n" + a18);
            }
            HashMap hashMap10 = new HashMap(12);
            hashMap10.put("answer_id", new e.a("answer_id", "TEXT", true, 0, (String) null, 1));
            hashMap10.put("option_id", new e.a("option_id", "TEXT", true, 1, (String) null, 1));
            hashMap10.put(Extra.PROFILE_ID, new e.a(Extra.PROFILE_ID, "TEXT", true, 2, (String) null, 1));
            hashMap10.put("question_id", new e.a("question_id", "TEXT", true, 3, (String) null, 1));
            hashMap10.put("text_value", new e.a("text_value", "TEXT", true, 0, (String) null, 1));
            hashMap10.put("integer_value", new e.a("integer_value", "INTEGER", false, 0, (String) null, 1));
            hashMap10.put("float_value", new e.a("float_value", "REAL", false, 0, (String) null, 1));
            hashMap10.put("max_value", new e.a("max_value", "REAL", false, 0, (String) null, 1));
            hashMap10.put("min_value", new e.a("min_value", "REAL", false, 0, (String) null, 1));
            hashMap10.put("location", new e.a("location", "TEXT", false, 0, (String) null, 1));
            hashMap10.put("is_dealbreaker", new e.a("is_dealbreaker", "INTEGER", false, 0, (String) null, 1));
            hashMap10.put("json_type", new e.a("json_type", "TEXT", false, 0, (String) null, 1));
            e eVar10 = new e("answers", hashMap10, new HashSet(0), new HashSet(0));
            e a19 = e.a(iVar2, "answers");
            if (!eVar10.equals(a19)) {
                return new j0.c(false, "answers(com.coffeemeetsbagel.qna.data.db.AnswerEntity).\n Expected:\n" + eVar10 + "\n Found:\n" + a19);
            }
            HashMap hashMap11 = new HashMap(6);
            hashMap11.put("id", new e.a("id", "INTEGER", false, 1, (String) null, 1));
            hashMap11.put(Extra.BAGEL_ID, new e.a(Extra.BAGEL_ID, "TEXT", true, 0, (String) null, 1));
            hashMap11.put("status", new e.a("status", "TEXT", true, 0, (String) null, 1));
            hashMap11.put("text", new e.a("text", "TEXT", true, 0, (String) null, 1));
            hashMap11.put("time_sent", new e.a("time_sent", "TEXT", false, 0, (String) null, 1));
            hashMap11.put("type", new e.a("type", "TEXT", true, 0, (String) null, 1));
            e eVar11 = new e("pending_messages", hashMap11, new HashSet(0), new HashSet(0));
            e a20 = e.a(iVar2, "pending_messages");
            if (!eVar11.equals(a20)) {
                return new j0.c(false, "pending_messages(com.coffeemeetsbagel.models.entities.PendingMessageEntity).\n Expected:\n" + eVar11 + "\n Found:\n" + a20);
            }
            HashMap hashMap12 = new HashMap(6);
            hashMap12.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap12.put("action", new e.a("action", "TEXT", true, 0, (String) null, 1));
            hashMap12.put("action_text", new e.a("action_text", "TEXT", true, 0, (String) null, 1));
            hashMap12.put("header_text", new e.a("header_text", "TEXT", true, 0, (String) null, 1));
            hashMap12.put("image_url", new e.a("image_url", "TEXT", true, 0, (String) null, 1));
            hashMap12.put("message_text", new e.a("message_text", "TEXT", true, 0, (String) null, 1));
            e eVar12 = new e("action_card", hashMap12, new HashSet(0), new HashSet(0));
            e a21 = e.a(iVar2, "action_card");
            if (!eVar12.equals(a21)) {
                return new j0.c(false, "action_card(com.coffeemeetsbagel.models.entities.ActionCardEntity).\n Expected:\n" + eVar12 + "\n Found:\n" + a21);
            }
            HashMap hashMap13 = new HashMap(8);
            hashMap13.put(SDKConstants.PARAM_KEY, new e.a(SDKConstants.PARAM_KEY, "TEXT", true, 1, (String) null, 1));
            hashMap13.put("cached_at", new e.a("cached_at", "INTEGER", true, 0, (String) null, 1));
            hashMap13.put("deep_link_tags", new e.a("deep_link_tags", "TEXT", true, 0, (String) null, 1));
            hashMap13.put("description", new e.a("description", "TEXT", true, 0, (String) null, 1));
            hashMap13.put("icon_url", new e.a("icon_url", "TEXT", true, 0, (String) null, 1));
            hashMap13.put("image_url", new e.a("image_url", "TEXT", true, 0, (String) null, 1));
            hashMap13.put("title", new e.a("title", "TEXT", true, 0, (String) null, 1));
            hashMap13.put("small_title_display", new e.a("small_title_display", "TEXT", false, 0, (String) null, 1));
            e eVar13 = new e("subscription_benefits", hashMap13, new HashSet(0), new HashSet(0));
            e a22 = e.a(iVar2, "subscription_benefits");
            if (!eVar13.equals(a22)) {
                return new j0.c(false, "subscription_benefits(com.coffeemeetsbagel.models.entities.BenefitEntity).\n Expected:\n" + eVar13 + "\n Found:\n" + a22);
            }
            HashMap hashMap14 = new HashMap(9);
            hashMap14.put("auto_renew", new e.a("auto_renew", "INTEGER", true, 0, (String) null, 1));
            hashMap14.put("benefits", new e.a("benefits", "TEXT", true, 0, (String) null, 1));
            hashMap14.put("expiry_date", new e.a("expiry_date", "TEXT", false, 0, (String) null, 1));
            hashMap14.put("sku", new e.a("sku", "TEXT", true, 1, (String) null, 1));
            hashMap14.put(FirebaseAnalytics.Param.START_DATE, new e.a(FirebaseAnalytics.Param.START_DATE, "TEXT", true, 0, (String) null, 1));
            hashMap14.put("bundle_id", new e.a("bundle_id", "TEXT", true, 0, "''", 1));
            hashMap14.put("subscription_state", new e.a("subscription_state", "INTEGER", false, 0, (String) null, 1));
            hashMap14.put("tier", new e.a("tier", "INTEGER", true, 0, "0", 1));
            hashMap14.put("purchase_token", new e.a("purchase_token", "TEXT", true, 0, "''", 1));
            e eVar14 = new e("active_subscription", hashMap14, new HashSet(0), new HashSet(0));
            e a23 = e.a(iVar2, "active_subscription");
            if (!eVar14.equals(a23)) {
                return new j0.c(false, "active_subscription(com.coffeemeetsbagel.models.entities.ActiveSubscriptionEntity).\n Expected:\n" + eVar14 + "\n Found:\n" + a23);
            }
            HashMap hashMap15 = new HashMap(10);
            hashMap15.put("bundle_id", new e.a("bundle_id", "TEXT", true, 0, "''", 1));
            hashMap15.put("marketing_type", new e.a("marketing_type", "TEXT", false, 0, (String) null, 1));
            hashMap15.put("number_of_units", new e.a("number_of_units", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("unit", new e.a("unit", "TEXT", true, 0, (String) null, 1));
            hashMap15.put("savings_comparison_sku", new e.a("savings_comparison_sku", "TEXT", false, 0, (String) null, 1));
            hashMap15.put("sale_full_price_comparison_sku", new e.a("sale_full_price_comparison_sku", "TEXT", false, 0, (String) null, 1));
            hashMap15.put("sale_sku_type", new e.a("sale_sku_type", "TEXT", false, 0, (String) null, 1));
            hashMap15.put("sale_start_time", new e.a("sale_start_time", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("sale_end_time", new e.a("sale_end_time", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("sku", new e.a("sku", "TEXT", true, 1, (String) null, 1));
            e eVar15 = new e("subscription_variants", hashMap15, new HashSet(0), new HashSet(0));
            e a24 = e.a(iVar2, "subscription_variants");
            if (!eVar15.equals(a24)) {
                return new j0.c(false, "subscription_variants(com.coffeemeetsbagel.models.entities.SubscriptionEntity).\n Expected:\n" + eVar15 + "\n Found:\n" + a24);
            }
            HashMap hashMap16 = new HashMap(2);
            hashMap16.put("capability", new e.a("capability", "TEXT", true, 1, (String) null, 1));
            hashMap16.put(StreamManagement.Enabled.ELEMENT, new e.a(StreamManagement.Enabled.ELEMENT, "INTEGER", true, 0, (String) null, 1));
            e eVar16 = new e("capability", hashMap16, new HashSet(0), new HashSet(0));
            e a25 = e.a(iVar2, "capability");
            if (!eVar16.equals(a25)) {
                return new j0.c(false, "capability(com.coffeemeetsbagel.models.entities.CapabilityEntity).\n Expected:\n" + eVar16 + "\n Found:\n" + a25);
            }
            HashMap hashMap17 = new HashMap(3);
            hashMap17.put("name", new e.a("name", "TEXT", true, 0, (String) null, 1));
            hashMap17.put("description", new e.a("description", "TEXT", true, 0, (String) null, 1));
            hashMap17.put("image_url", new e.a("image_url", "TEXT", true, 1, (String) null, 1));
            e eVar17 = new e("stickers", hashMap17, new HashSet(0), new HashSet(0));
            e a26 = e.a(iVar2, "stickers");
            if (!eVar17.equals(a26)) {
                return new j0.c(false, "stickers(com.coffeemeetsbagel.models.entities.StickerEntity).\n Expected:\n" + eVar17 + "\n Found:\n" + a26);
            }
            HashMap hashMap18 = new HashMap(6);
            hashMap18.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap18.put("name", new e.a("name", "TEXT", true, 0, (String) null, 1));
            hashMap18.put("tier", new e.a("tier", "INTEGER", true, 0, (String) null, 1));
            hashMap18.put("intents", new e.a("intents", "TEXT", true, 0, (String) null, 1));
            hashMap18.put("benefit_keys", new e.a("benefit_keys", "TEXT", true, 0, (String) null, 1));
            hashMap18.put("variant_skus", new e.a("variant_skus", "TEXT", true, 0, (String) null, 1));
            e eVar18 = new e("subscription_bundles", hashMap18, new HashSet(0), new HashSet(0));
            e a27 = e.a(iVar2, "subscription_bundles");
            if (!eVar18.equals(a27)) {
                return new j0.c(false, "subscription_bundles(com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity).\n Expected:\n" + eVar18 + "\n Found:\n" + a27);
            }
            HashMap hashMap19 = new HashMap(6);
            hashMap19.put("name", new e.a("name", "TEXT", true, 1, (String) null, 1));
            hashMap19.put("beans", new e.a("beans", "INTEGER", true, 0, (String) null, 1));
            hashMap19.put("free_item_count", new e.a("free_item_count", "INTEGER", true, 0, (String) null, 1));
            hashMap19.put("image_url", new e.a("image_url", "TEXT", true, 0, (String) null, 1));
            hashMap19.put("tint_color", new e.a("tint_color", "TEXT", true, 0, (String) null, 1));
            hashMap19.put("is_unlimited", new e.a("is_unlimited", "INTEGER", true, 0, (String) null, 1));
            e eVar19 = new e("prices", hashMap19, new HashSet(0), new HashSet(0));
            e a28 = e.a(iVar2, "prices");
            if (!eVar19.equals(a28)) {
                return new j0.c(false, "prices(com.coffeemeetsbagel.models.entities.PriceEntity).\n Expected:\n" + eVar19 + "\n Found:\n" + a28);
            }
            HashMap hashMap20 = new HashMap(3);
            hashMap20.put("resource_key", new e.a("resource_key", "TEXT", true, 1, (String) null, 1));
            hashMap20.put("resource_value", new e.a("resource_value", "TEXT", true, 0, (String) null, 1));
            hashMap20.put("resource_list_name", new e.a("resource_list_name", "TEXT", true, 2, (String) null, 1));
            e eVar20 = new e("resources", hashMap20, new HashSet(0), new HashSet(0));
            e a29 = e.a(iVar2, "resources");
            if (!eVar20.equals(a29)) {
                return new j0.c(false, "resources(com.coffeemeetsbagel.models.entities.ResourceEntity).\n Expected:\n" + eVar20 + "\n Found:\n" + a29);
            }
            HashMap hashMap21 = new HashMap(2);
            hashMap21.put("id", new e.a("id", "INTEGER", true, 1, (String) null, 1));
            hashMap21.put("name", new e.a("name", "TEXT", true, 0, (String) null, 1));
            HashSet hashSet11 = new HashSet(0);
            HashSet hashSet12 = new HashSet(1);
            hashSet12.add(new e.C0192e("index_schools_name", true, Arrays.asList(new String[]{"name"}), Arrays.asList(new String[]{str})));
            e eVar21 = new e("schools", hashMap21, hashSet11, hashSet12);
            e a30 = e.a(iVar2, "schools");
            if (!eVar21.equals(a30)) {
                return new j0.c(false, "schools(com.coffeemeetsbagel.school.db.SchoolEntity).\n Expected:\n" + eVar21 + "\n Found:\n" + a30);
            }
            HashMap hashMap22 = new HashMap(7);
            hashMap22.put("profileId", new e.a("profileId", "TEXT", true, 1, (String) null, 1));
            hashMap22.put("unreadMessageCount", new e.a("unreadMessageCount", "INTEGER", true, 0, (String) null, 1));
            hashMap22.put("lastMessageText", new e.a("lastMessageText", "TEXT", false, 0, (String) null, 1));
            hashMap22.put("lastMessageDate", new e.a("lastMessageDate", "TEXT", false, 0, (String) null, 1));
            hashMap22.put("pairReadReceiptDate", new e.a("pairReadReceiptDate", "TEXT", false, 0, (String) null, 1));
            hashMap22.put("lastSenderProfileId", new e.a("lastSenderProfileId", "TEXT", false, 0, (String) null, 1));
            hashMap22.put("lastMessageReadTimestamp", new e.a("lastMessageReadTimestamp", "TEXT", false, 0, (String) null, 1));
            e eVar22 = new e("connection_details", hashMap22, new HashSet(0), new HashSet(0));
            e a31 = e.a(iVar2, "connection_details");
            if (!eVar22.equals(a31)) {
                return new j0.c(false, "connection_details(com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity).\n Expected:\n" + eVar22 + "\n Found:\n" + a31);
            }
            HashMap hashMap23 = new HashMap(14);
            hashMap23.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap23.put("name", new e.a("name", "TEXT", true, 0, (String) null, 1));
            hashMap23.put("count", new e.a("count", "INTEGER", true, 0, (String) null, 1));
            hashMap23.put("group_ordinal", new e.a("group_ordinal", "INTEGER", true, 0, (String) null, 1));
            hashMap23.put("ordered_profile_ids", new e.a("ordered_profile_ids", "TEXT", true, 0, (String) null, 1));
            hashMap23.put("max_display_count", new e.a("max_display_count", "INTEGER", false, 0, (String) null, 1));
            hashMap23.put("contextual_recommendation_icon", new e.a("contextual_recommendation_icon", "TEXT", false, 0, (String) null, 1));
            hashMap23.put("contextual_recommendation_text", new e.a("contextual_recommendation_text", "TEXT", false, 0, (String) null, 1));
            hashMap23.put("contextual_recommendation_desc", new e.a("contextual_recommendation_desc", "TEXT", false, 0, (String) null, 1));
            hashMap23.put("empty_state_action", new e.a("empty_state_action", "TEXT", false, 0, (String) null, 1));
            hashMap23.put("empty_state_cta_text", new e.a("empty_state_cta_text", "TEXT", false, 0, (String) null, 1));
            hashMap23.put("empty_state_description", new e.a("empty_state_description", "TEXT", false, 0, (String) null, 1));
            hashMap23.put("empty_state_image_url", new e.a("empty_state_image_url", "TEXT", false, 0, (String) null, 1));
            hashMap23.put("empty_state_title_text", new e.a("empty_state_title_text", "TEXT", false, 0, (String) null, 1));
            e eVar23 = new e("likes_you_group", hashMap23, new HashSet(0), new HashSet(0));
            e a32 = e.a(iVar2, "likes_you_group");
            if (!eVar23.equals(a32)) {
                return new j0.c(false, "likes_you_group(com.coffeemeetsbagel.models.entities.LikesYouGroupEntity).\n Expected:\n" + eVar23 + "\n Found:\n" + a32);
            }
            HashMap hashMap24 = new HashMap(10);
            hashMap24.put(Extra.PROFILE_ID, new e.a(Extra.PROFILE_ID, "TEXT", true, 1, (String) null, 1));
            hashMap24.put("group_ids", new e.a("group_ids", "TEXT", true, 0, (String) null, 1));
            hashMap24.put(obj4, new e.a("age", "INTEGER", true, 0, (String) null, 1));
            hashMap24.put(Extra.BAGEL_ID, new e.a(Extra.BAGEL_ID, "TEXT", true, 0, (String) null, 1));
            hashMap24.put(obj3, new e.a(Constants.Keys.CITY, "TEXT", false, 0, (String) null, 1));
            hashMap24.put("education", new e.a("education", "TEXT", false, 0, (String) null, 1));
            hashMap24.put(obj2, new e.a(ProfileConstants.Field.USER_OCCUPATION, "TEXT", false, 0, (String) null, 1));
            hashMap24.put("pair_like_comment", new e.a("pair_like_comment", "TEXT", false, 0, (String) null, 1));
            hashMap24.put("image_url", new e.a("image_url", "TEXT", false, 0, (String) null, 1));
            Object obj5 = obj;
            hashMap24.put(obj5, new e.a("purchase_attribution", "INTEGER", false, 0, (String) null, 1));
            e eVar24 = new e("likes_you_card", hashMap24, new HashSet(0), new HashSet(0));
            e a33 = e.a(iVar2, "likes_you_card");
            if (!eVar24.equals(a33)) {
                return new j0.c(false, "likes_you_card(com.coffeemeetsbagel.models.entities.LikesYouCardEntity).\n Expected:\n" + eVar24 + "\n Found:\n" + a33);
            }
            HashMap hashMap25 = new HashMap(3);
            hashMap25.put(Extra.PROFILE_ID, new e.a(Extra.PROFILE_ID, "TEXT", true, 1, (String) null, 1));
            hashMap25.put("image_url", new e.a("image_url", "TEXT", true, 0, (String) null, 1));
            hashMap25.put(obj5, new e.a("purchase_attribution", "INTEGER", false, 0, (String) null, 1));
            e eVar25 = new e("likes_you_paywall_card", hashMap25, new HashSet(0), new HashSet(0));
            e a34 = e.a(iVar2, "likes_you_paywall_card");
            if (!eVar25.equals(a34)) {
                return new j0.c(false, "likes_you_paywall_card(com.coffeemeetsbagel.models.entities.LikesYouPaywallCard).\n Expected:\n" + eVar25 + "\n Found:\n" + a34);
            }
            HashMap hashMap26 = new HashMap(2);
            hashMap26.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap26.put(Extra.PROFILE_ID, new e.a(Extra.PROFILE_ID, "TEXT", true, 2, (String) null, 1));
            HashSet hashSet13 = new HashSet(0);
            HashSet hashSet14 = new HashSet(1);
            String str2 = str;
            hashSet14.add(new e.C0192e("index_LikesYouGroupCardCrossRef_id_profile_id", false, Arrays.asList(new String[]{"id", Extra.PROFILE_ID}), Arrays.asList(new String[]{str2, str2})));
            e eVar26 = new e("LikesYouGroupCardCrossRef", hashMap26, hashSet13, hashSet14);
            e a35 = e.a(iVar2, "LikesYouGroupCardCrossRef");
            if (!eVar26.equals(a35)) {
                return new j0.c(false, "LikesYouGroupCardCrossRef(com.coffeemeetsbagel.likesyou.db.LikesYouGroupCardCrossRef).\n Expected:\n" + eVar26 + "\n Found:\n" + a35);
            }
            HashMap hashMap27 = new HashMap(2);
            hashMap27.put("id", new e.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap27.put(Extra.PROFILE_ID, new e.a(Extra.PROFILE_ID, "TEXT", true, 2, (String) null, 1));
            HashSet hashSet15 = new HashSet(0);
            HashSet hashSet16 = new HashSet(1);
            hashSet16.add(new e.C0192e("index_LikesYouGroupPaywallCardCrossRef_id_profile_id", false, Arrays.asList(new String[]{"id", Extra.PROFILE_ID}), Arrays.asList(new String[]{str2, str2})));
            e eVar27 = new e("LikesYouGroupPaywallCardCrossRef", hashMap27, hashSet15, hashSet16);
            e a36 = e.a(iVar2, "LikesYouGroupPaywallCardCrossRef");
            if (!eVar27.equals(a36)) {
                return new j0.c(false, "LikesYouGroupPaywallCardCrossRef(com.coffeemeetsbagel.likesyou.db.LikesYouGroupPaywallCardCrossRef).\n Expected:\n" + eVar27 + "\n Found:\n" + a36);
            }
            HashMap hashMap28 = new HashMap(4);
            hashMap28.put("id", new e.a("id", "INTEGER", true, 1, (String) null, 1));
            hashMap28.put("remaining_likes", new e.a("remaining_likes", "INTEGER", false, 0, (String) null, 1));
            hashMap28.put("remaining_views", new e.a("remaining_views", "INTEGER", false, 0, (String) null, 1));
            hashMap28.put("num_bagels_required_for_upsell", new e.a("num_bagels_required_for_upsell", "INTEGER", false, 0, (String) null, 1));
            e eVar28 = new e("suggested_limits", hashMap28, new HashSet(0), new HashSet(0));
            e a37 = e.a(iVar2, "suggested_limits");
            if (!eVar28.equals(a37)) {
                return new j0.c(false, "suggested_limits(com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity).\n Expected:\n" + eVar28 + "\n Found:\n" + a37);
            }
            HashMap hashMap29 = new HashMap(5);
            hashMap29.put("internalTag", new e.a("internalTag", "TEXT", true, 0, (String) null, 1));
            hashMap29.put("payloadObject", new e.a("payloadObject", "TEXT", true, 0, (String) null, 1));
            hashMap29.put("lastTimeTried", new e.a("lastTimeTried", "INTEGER", true, 0, (String) null, 1));
            hashMap29.put("timesTriedSoFar", new e.a("timesTriedSoFar", "INTEGER", true, 0, (String) null, 1));
            hashMap29.put("id", new e.a("id", "INTEGER", true, 1, (String) null, 1));
            e eVar29 = new e("retry_calls", hashMap29, new HashSet(0), new HashSet(0));
            e a38 = e.a(iVar2, "retry_calls");
            if (eVar29.equals(a38)) {
                return new j0.c(true, (String) null);
            }
            return new j0.c(false, "retry_calls(com.coffeemeetsbagel.models.entities.RetryCallEntity).\n Expected:\n" + eVar29 + "\n Found:\n" + a38);
        }
    }

    public ActionCardRoomDao E() {
        ActionCardRoomDao actionCardRoomDao;
        if (this.f11603z != null) {
            return this.f11603z;
        }
        synchronized (this) {
            if (this.f11603z == null) {
                this.f11603z = new com.coffeemeetsbagel.database.daos.d(this);
            }
            actionCardRoomDao = this.f11603z;
        }
        return actionCardRoomDao;
    }

    public ActiveSubscriptionRoomDao F() {
        ActiveSubscriptionRoomDao activeSubscriptionRoomDao;
        if (this.C != null) {
            return this.C;
        }
        synchronized (this) {
            if (this.C == null) {
                this.C = new g(this);
            }
            activeSubscriptionRoomDao = this.C;
        }
        return activeSubscriptionRoomDao;
    }

    public h G() {
        h hVar;
        if (this.f11597t != null) {
            return this.f11597t;
        }
        synchronized (this) {
            if (this.f11597t == null) {
                this.f11597t = new com.coffeemeetsbagel.database.daos.i(this);
            }
            hVar = this.f11597t;
        }
        return hVar;
    }

    public j H() {
        j jVar;
        if (this.f11601x != null) {
            return this.f11601x;
        }
        synchronized (this) {
            if (this.f11601x == null) {
                this.f11601x = new k(this);
            }
            jVar = this.f11601x;
        }
        return jVar;
    }

    public n I() {
        n nVar;
        if (this.B != null) {
            return this.B;
        }
        synchronized (this) {
            if (this.B == null) {
                this.B = new com.coffeemeetsbagel.database.daos.o(this);
            }
            nVar = this.B;
        }
        return nVar;
    }

    public CapabilityRoomDao J() {
        CapabilityRoomDao capabilityRoomDao;
        if (this.D != null) {
            return this.D;
        }
        synchronized (this) {
            if (this.D == null) {
                this.D = new com.coffeemeetsbagel.database.daos.q(this);
            }
            capabilityRoomDao = this.D;
        }
        return capabilityRoomDao;
    }

    public ConnectionDetailsRoomDao K() {
        ConnectionDetailsRoomDao connectionDetailsRoomDao;
        if (this.K != null) {
            return this.K;
        }
        synchronized (this) {
            if (this.K == null) {
                this.K = new s(this);
            }
            connectionDetailsRoomDao = this.K;
        }
        return connectionDetailsRoomDao;
    }

    public d L() {
        d dVar;
        if (this.L != null) {
            return this.L;
        }
        synchronized (this) {
            if (this.L == null) {
                this.L = new com.coffeemeetsbagel.likes_you.e(this);
            }
            dVar = this.L;
        }
        return dVar;
    }

    public q M() {
        q qVar;
        if (this.O != null) {
            return this.O;
        }
        synchronized (this) {
            if (this.O == null) {
                this.O = new r(this);
            }
            qVar = this.O;
        }
        return qVar;
    }

    public LikesYouGroupRoomDao N() {
        LikesYouGroupRoomDao likesYouGroupRoomDao;
        if (this.M != null) {
            return this.M;
        }
        synchronized (this) {
            if (this.M == null) {
                this.M = new com.coffeemeetsbagel.likes_you.k(this);
            }
            likesYouGroupRoomDao = this.M;
        }
        return likesYouGroupRoomDao;
    }

    public o O() {
        o oVar;
        if (this.N != null) {
            return this.N;
        }
        synchronized (this) {
            if (this.N == null) {
                this.N = new p(this);
            }
            oVar = this.N;
        }
        return oVar;
    }

    public MatchContextRoomDao P() {
        MatchContextRoomDao matchContextRoomDao;
        if (this.f11599v != null) {
            return this.f11599v;
        }
        synchronized (this) {
            if (this.f11599v == null) {
                this.f11599v = new u(this);
            }
            matchContextRoomDao = this.f11599v;
        }
        return matchContextRoomDao;
    }

    public v Q() {
        v vVar;
        if (this.f11598u != null) {
            return this.f11598u;
        }
        synchronized (this) {
            if (this.f11598u == null) {
                this.f11598u = new w(this);
            }
            vVar = this.f11598u;
        }
        return vVar;
    }

    public PendingMessageRoomDao R() {
        PendingMessageRoomDao pendingMessageRoomDao;
        if (this.f11602y != null) {
            return this.f11602y;
        }
        synchronized (this) {
            if (this.f11602y == null) {
                this.f11602y = new a0(this);
            }
            pendingMessageRoomDao = this.f11602y;
        }
        return pendingMessageRoomDao;
    }

    public b0 S() {
        b0 b0Var;
        if (this.f11596s != null) {
            return this.f11596s;
        }
        synchronized (this) {
            if (this.f11596s == null) {
                this.f11596s = new c0(this);
            }
            b0Var = this.f11596s;
        }
        return b0Var;
    }

    public d0 T() {
        d0 d0Var;
        if (this.I != null) {
            return this.I;
        }
        synchronized (this) {
            if (this.I == null) {
                this.I = new e0(this);
            }
            d0Var = this.I;
        }
        return d0Var;
    }

    public ProfileRoomDao U() {
        ProfileRoomDao profileRoomDao;
        if (this.f11594q != null) {
            return this.f11594q;
        }
        synchronized (this) {
            if (this.f11594q == null) {
                this.f11594q = new com.coffeemeetsbagel.database.daos.j0(this);
            }
            profileRoomDao = this.f11594q;
        }
        return profileRoomDao;
    }

    public QuestionDaoV2Impl V() {
        QuestionDaoV2Impl questionDaoV2Impl;
        if (this.G != null) {
            return this.G;
        }
        synchronized (this) {
            if (this.G == null) {
                this.G = new com.coffeemeetsbagel.qna.v(this);
            }
            questionDaoV2Impl = this.G;
        }
        return questionDaoV2Impl;
    }

    public k0 W() {
        k0 k0Var;
        if (this.f11600w != null) {
            return this.f11600w;
        }
        synchronized (this) {
            if (this.f11600w == null) {
                this.f11600w = new l0(this);
            }
            k0Var = this.f11600w;
        }
        return k0Var;
    }

    public ResourceRoomDao X() {
        ResourceRoomDao resourceRoomDao;
        if (this.H != null) {
            return this.H;
        }
        synchronized (this) {
            if (this.H == null) {
                this.H = new n0(this);
            }
            resourceRoomDao = this.H;
        }
        return resourceRoomDao;
    }

    public o0 Y() {
        o0 o0Var;
        if (this.Q != null) {
            return this.Q;
        }
        synchronized (this) {
            if (this.Q == null) {
                this.Q = new p0(this);
            }
            o0Var = this.Q;
        }
        return o0Var;
    }

    public b Z() {
        b bVar;
        if (this.J != null) {
            return this.J;
        }
        synchronized (this) {
            if (this.J == null) {
                this.J = new c(this);
            }
            bVar = this.J;
        }
        return bVar;
    }

    public StickerRoomDao a0() {
        StickerRoomDao stickerRoomDao;
        if (this.E != null) {
            return this.E;
        }
        synchronized (this) {
            if (this.E == null) {
                this.E = new r0(this);
            }
            stickerRoomDao = this.E;
        }
        return stickerRoomDao;
    }

    public SubscriptionBundleRoomDao b0() {
        SubscriptionBundleRoomDao subscriptionBundleRoomDao;
        if (this.F != null) {
            return this.F;
        }
        synchronized (this) {
            if (this.F == null) {
                this.F = new y0(this);
            }
            subscriptionBundleRoomDao = this.F;
        }
        return subscriptionBundleRoomDao;
    }

    public a1 c0() {
        a1 a1Var;
        if (this.A != null) {
            return this.A;
        }
        synchronized (this) {
            if (this.A == null) {
                this.A = new b1(this);
            }
            a1Var = this.A;
        }
        return a1Var;
    }

    public c1 d0() {
        c1 c1Var;
        if (this.P != null) {
            return this.P;
        }
        synchronized (this) {
            if (this.P == null) {
                this.P = new d1(this);
            }
            c1Var = this.P;
        }
        return c1Var;
    }

    public e1 e0() {
        e1 e1Var;
        if (this.f11595r != null) {
            return this.f11595r;
        }
        synchronized (this) {
            if (this.f11595r == null) {
                this.f11595r = new f1(this);
            }
            e1Var = this.f11595r;
        }
        return e1Var;
    }

    public void f() {
        super.c();
        i n12 = super.n().n1();
        try {
            super.e();
            n12.D("PRAGMA defer_foreign_keys = TRUE");
            n12.D("DELETE FROM `profiles`");
            n12.D("DELETE FROM `user`");
            n12.D("DELETE FROM `photos`");
            n12.D("DELETE FROM `activity_reports`");
            n12.D("DELETE FROM `matches`");
            n12.D("DELETE FROM `match_context`");
            n12.D("DELETE FROM `questions`");
            n12.D("DELETE FROM `question_groups`");
            n12.D("DELETE FROM `options`");
            n12.D("DELETE FROM `answers`");
            n12.D("DELETE FROM `pending_messages`");
            n12.D("DELETE FROM `action_card`");
            n12.D("DELETE FROM `subscription_benefits`");
            n12.D("DELETE FROM `active_subscription`");
            n12.D("DELETE FROM `subscription_variants`");
            n12.D("DELETE FROM `capability`");
            n12.D("DELETE FROM `stickers`");
            n12.D("DELETE FROM `subscription_bundles`");
            n12.D("DELETE FROM `prices`");
            n12.D("DELETE FROM `resources`");
            n12.D("DELETE FROM `schools`");
            n12.D("DELETE FROM `connection_details`");
            n12.D("DELETE FROM `likes_you_group`");
            n12.D("DELETE FROM `likes_you_card`");
            n12.D("DELETE FROM `likes_you_paywall_card`");
            n12.D("DELETE FROM `LikesYouGroupCardCrossRef`");
            n12.D("DELETE FROM `LikesYouGroupPaywallCardCrossRef`");
            n12.D("DELETE FROM `suggested_limits`");
            n12.D("DELETE FROM `retry_calls`");
            super.C();
        } finally {
            super.j();
            n12.q1("PRAGMA wal_checkpoint(FULL)").close();
            if (!n12.E1()) {
                n12.D("VACUUM");
            }
        }
    }

    /* access modifiers changed from: protected */
    public m h() {
        return new m(this, new HashMap(0), new HashMap(0), "profiles", "user", "photos", "activity_reports", "matches", "match_context", ProfileConstants.Field.QUESTIONS, "question_groups", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "answers", "pending_messages", "action_card", "subscription_benefits", "active_subscription", "subscription_variants", "capability", "stickers", "subscription_bundles", "prices", "resources", "schools", "connection_details", "likes_you_group", "likes_you_card", "likes_you_paywall_card", "LikesYouGroupCardCrossRef", "LikesYouGroupPaywallCardCrossRef", "suggested_limits", "retry_calls");
    }

    /* access modifiers changed from: protected */
    public t1.j i(androidx.room.e eVar) {
        return eVar.f6831c.a(j.b.a(eVar.f6829a).d(eVar.f6830b).c(new j0(eVar, new a(75), "c1b65a11a5096aa5d1ad98085831dd1c", "53e8d8653883ea6f28f5a5e1908ad2e3")).b());
    }

    public List<p1.b> k(@NonNull Map<Class<? extends p1.a>, p1.a> map) {
        return Arrays.asList(new p1.b[0]);
    }

    public Set<Class<? extends p1.a>> p() {
        return new HashSet();
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> q() {
        HashMap hashMap = new HashMap();
        hashMap.put(ProfileRoomDao.class, com.coffeemeetsbagel.database.daos.j0.G());
        hashMap.put(e1.class, f1.v());
        hashMap.put(b0.class, c0.z());
        hashMap.put(h.class, com.coffeemeetsbagel.database.daos.i.f());
        hashMap.put(v.class, w.E());
        hashMap.put(MatchContextRoomDao.class, u.t());
        hashMap.put(k0.class, l0.w());
        hashMap.put(x.class, y.a());
        hashMap.put(com.coffeemeetsbagel.database.daos.j.class, k.g());
        hashMap.put(PendingMessageRoomDao.class, a0.H());
        hashMap.put(ActionCardRoomDao.class, com.coffeemeetsbagel.database.daos.d.y());
        hashMap.put(a1.class, b1.w());
        hashMap.put(n.class, com.coffeemeetsbagel.database.daos.o.y());
        hashMap.put(ActiveSubscriptionRoomDao.class, g.B());
        hashMap.put(CapabilityRoomDao.class, com.coffeemeetsbagel.database.daos.q.w());
        hashMap.put(StickerRoomDao.class, r0.v());
        hashMap.put(SubscriptionBundleRoomDao.class, y0.P());
        hashMap.put(QuestionDaoV2Impl.class, com.coffeemeetsbagel.qna.v.U());
        hashMap.put(ResourceRoomDao.class, n0.u());
        hashMap.put(d0.class, e0.n());
        hashMap.put(b.class, c.i());
        hashMap.put(ConnectionDetailsRoomDao.class, s.C());
        hashMap.put(d.class, com.coffeemeetsbagel.likes_you.e.z());
        hashMap.put(LikesYouGroupRoomDao.class, com.coffeemeetsbagel.likes_you.k.F());
        hashMap.put(o.class, p.n());
        hashMap.put(q.class, r.k());
        hashMap.put(c1.class, d1.u());
        hashMap.put(o0.class, p0.g());
        return hashMap;
    }
}
