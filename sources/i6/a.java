package i6;

import com.facebook.appevents.UserDataStore;
import j6.b;
import kotlin.jvm.internal.j;
import t1.i;

public final class a {
    public final void a(i iVar, int i10, int i11) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
    }

    public final String b() {
        return "`photos`.`id`";
    }

    public final void c(i iVar, int i10, int i11) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        iVar.D("CREATE TABLE IF NOT EXISTS `matches_MERGE_TABLE` (`id` TEXT NOT NULL, `action` INTEGER NOT NULL, `end_at` TEXT NOT NULL, `is_blocked` INTEGER NOT NULL, `is_rising` INTEGER NOT NULL, `message` TEXT, `profile_id` TEXT NOT NULL, `show_order` INTEGER, `start_at` TEXT NOT NULL, `type` TEXT NOT NULL, `woo_count` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`profile_id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        iVar.D("INSERT INTO `matches_MERGE_TABLE` (`id`, `action`, `end_at`, `is_blocked`, `is_rising`, `message`, `profile_id`, `show_order`, `start_at`, `type`, `woo_count`) SELECT `matches`.`id`, `matches`.`action`, `matches`.`end_at`, `matches`.`is_blocked`, `matches`.`is_rising`, `matches`.`message`, `matches`.`profile_id`, `matches`.`show_order`, `matches`.`start_at`, `matches`.`type`, `matches`.`woo_count`FROM `matches`");
        iVar.D("DROP TABLE IF EXISTS `matches`");
        iVar.D("ALTER TABLE `matches_MERGE_TABLE` RENAME TO `matches`");
        iVar.D("CREATE UNIQUE INDEX `index_matches_profile_id_type_action` ON `matches` (`profile_id`, `type`, `action`)");
        iVar.D("CREATE  INDEX `index_matches_type_action` ON `matches` (`type`, `action`)");
    }

    public final void d(i iVar, int i10, int i11) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        iVar.D("CREATE TABLE IF NOT EXISTS `answers_MERGE_TABLE` (`question_id` TEXT NOT NULL, `option_ids` TEXT, `text_value` TEXT, PRIMARY KEY(`question_id`))");
        iVar.D("INSERT INTO `answers_MERGE_TABLE` (`question_id`, `option_ids`, `text_value`) SELECT `answers`.`question_id`, `answers`.`option_ids`, `answers`.`text_value` FROM `answers`");
        iVar.D("DROP TABLE IF EXISTS `answers`");
        iVar.D("ALTER TABLE `answers_MERGE_TABLE` RENAME to `answers`");
    }

    public final void e(i iVar, int i10, int i11) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        iVar.D("DROP TABLE IF EXISTS `answers`");
        iVar.D("CREATE TABLE IF NOT EXISTS `answers` (`option_id` TEXT NOT NULL, `profile_id` TEXT NOT NULL, `question_id` TEXT NOT NULL, `text_value` TEXT NOT NULL, PRIMARY KEY(`question_id`, `option_id`, `profile_id`, `text_value`))");
    }

    public final void f(i iVar, int i10, int i11) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        iVar.D("CREATE TABLE IF NOT EXISTS `answers_MERGE_TABLE` (`option_id` TEXT NOT NULL, `profile_id` TEXT NOT NULL, `question_id` TEXT NOT NULL, `text_value` TEXT NOT NULL, PRIMARY KEY(`option_id`, `profile_id`, `question_id`))");
        iVar.D("INSERT INTO `answers_MERGE_TABLE` ( `option_id`, `profile_id`, `question_id`, `text_value`) SELECT `answers`.`option_id`, `answers`.`profile_id`, `answers`.`question_id`, `answers`.`text_value`FROM `answers`");
        iVar.D("DROP TABLE IF EXISTS `answers`");
        iVar.D("ALTER TABLE `answers_MERGE_TABLE` RENAME to `answers`");
    }

    public final void g(i iVar, int i10, int i11) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        iVar.D("CREATE TABLE IF NOT EXISTS `subs_MERGE_TABLE` (`auto_renew` INTEGER NOT NULL, `benefits` TEXT NOT NULL, `expiry_date` TEXT, `sku` TEXT NOT NULL, `start_date` TEXT NOT NULL, `subscription_state` INTEGER, PRIMARY KEY(`sku`))");
        iVar.D("INSERT INTO `subs_MERGE_TABLE` ( `auto_renew`, `benefits`, `expiry_date`, `sku`, `start_date`, `subscription_state`) SELECT `active_subscription`.`auto_renew`, `active_subscription`.`benefits`, `active_subscription`.`expiry_date`, `active_subscription`.`sku`, `active_subscription`.`start_date`, `active_subscription`.`subscription_state`FROM `active_subscription`");
        iVar.D("DROP TABLE IF EXISTS `active_subscription`");
        iVar.D("ALTER TABLE `subs_MERGE_TABLE` RENAME to `active_subscription`");
    }

    public final void h(i iVar, int i10, int i11) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        iVar.D("CREATE TABLE IF NOT EXISTS `user_MERGE_TABLE` (\n`profile_id` TEXT NOT NULL,\n`appsFlyerId` TEXT,\n`emailAddress` TEXT,\n`is_eligible_for_free_trial` INTEGER NOT NULL,\n`registeredDate` TEXT,\n`beans` INTEGER NOT NULL,\n`birthDay` TEXT,\n`matchRegion` TEXT,\n`onHold` INTEGER NOT NULL,\n`deactivateReason` TEXT,\n`dateReactivated` TEXT,\n`location` TEXT,\n`latitude` REAL,\n`longitude` REAL,\n`viewedCoachMarks` TEXT NOT NULL,\n`referralCode` TEXT,\n`badgeCount` INTEGER NOT NULL,\n`appLaunchStreak` INTEGER NOT NULL,\n`hasPrioritizedLikes` INTEGER NOT NULL,\n`hasActiveBoost` INTEGER NOT NULL,\n`boostReportId` TEXT,\n`numRisingBagels` INTEGER NOT NULL,\n`lastName` TEXT,\n`zipCode` TEXT,\n`ageFrom` INTEGER,\n`ageTo` INTEGER,\n`ethnicity` TEXT,\n`gender` TEXT,\n`religion` TEXT,\n`maxDistanceMiles` INTEGER NOT NULL,\n`maxDistanceKm` INTEGER NOT NULL,\n`heightFeetFrom` INTEGER,\n`heightFeetTo` INTEGER,\n`heightInchFrom` INTEGER,\n`heightInchTo` INTEGER,\n`heightCmFrom` INTEGER,\n`heightCmTo` INTEGER,\n`first_icebreaker` TEXT NOT NULL,\n`second_icebreaker` TEXT NOT NULL,\n`third_icebreaker` TEXT NOT NULL,\nPRIMARY KEY(`profile_id`))\n");
        iVar.D("INSERT INTO `user_MERGE_TABLE` (`profile_id`,`appsFlyerId`,`emailAddress`,`is_eligible_for_free_trial`,`registeredDate`,`beans`,`birthDay`,`matchRegion`,`onHold`,`deactivateReason`,`dateReactivated`,`location`,`latitude`,`longitude`,`viewedCoachMarks`,`referralCode`,`badgeCount`,`appLaunchStreak`,`hasPrioritizedLikes`,`hasActiveBoost`,`boostReportId`,`numRisingBagels`,`lastName`,`zipCode`,`ageFrom`,`ageTo`,`ethnicity`,`gender`,`religion`,`heightFeetFrom`,`heightFeetTo`,`heightInchFrom`,`heightInchTo`,`heightCmFrom`,`heightCmTo`,`first_icebreaker`,`second_icebreaker`,`third_icebreaker`,`maxDistanceMiles`,`maxDistanceKm`) SELECT `user`.`profile_id`,`user`.`appsFlyerId`,`user`.`emailAddress`,`user`.`is_eligible_for_free_trial`,`user`.`registeredDate`,`user`.`beans`,`user`.`birthDay`,`user`.`matchRegion`,`user`.`onHold`,`user`.`deactivateReason`,`user`.`dateReactivated`,`user`.`location`,`user`.`latitude`,`user`.`longitude`,`user`.`viewedCoachMarks`,`user`.`referralCode`,`user`.`badgeCount`,`user`.`appLaunchStreak`,`user`.`hasPrioritizedLikes`,`user`.`hasActiveBoost`,`user`.`boostReportId`,`user`.`numRisingBagels`,`user`.`lastName`,`user`.`zipCode`,`user`.`ageFrom`,`user`.`ageTo`,`user`.`ethnicity`,`user`.`gender`,`user`.`religion`,`user`.`heightFeetFrom`,`user`.`heightFeetTo`,`user`.`heightInchFrom`,`user`.`heightInchTo`,`user`.`heightCmFrom`,`user`.`heightCmTo`,`user`.`first_icebreaker`,`user`.`second_icebreaker`,`user`.`third_icebreaker`,IFNULL(`user`.`maxDistanceMiles`, 0),IFNULL(`user`.`maxDistanceKm`, 0) FROM `user`");
        iVar.D("DROP TABLE IF EXISTS `user`");
        iVar.D("ALTER TABLE `user_MERGE_TABLE` RENAME TO `user`");
    }

    public final void i(i iVar, int i10, int i11) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        new b().a(iVar, "dynamic_label_values");
        iVar.D("CREATE TABLE IF NOT EXISTS `dynamic_label_values` (`profile_id` TEXT NOT NULL, `label` TEXT NOT NULL, `show_order` INTEGER NOT NULL, `value` TEXT NOT NULL, PRIMARY KEY(`profile_id`, `label`), FOREIGN KEY(`profile_id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        iVar.D("CREATE  INDEX `index_dynamic_label_values_profile_id` ON `dynamic_label_values` (`profile_id`)");
    }
}
