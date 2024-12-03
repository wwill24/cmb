package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class t0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final t0 f14840c = new t0();

    private t0() {
        super(51, 52);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `profiles_MERGE_TABLE` (`id` TEXT NOT NULL, `age` INTEGER NOT NULL, `city` TEXT NOT NULL, `country` TEXT NOT NULL, `employer` TEXT NOT NULL, `ethnicities` TEXT NOT NULL, `first_name` TEXT NOT NULL, `gender` TEXT NOT NULL, `last_name` TEXT NOT NULL, `occupation` TEXT NOT NULL, `religion` TEXT, `state` TEXT NOT NULL, `school` TEXT, `degree_id` TEXT, `height_cm` INTEGER, `height_feet` INTEGER, `height_inches` INTEGER, `secondary_school` TEXT, `secondary_degree_id` TEXT, PRIMARY KEY(`id`))");
        iVar.D("INSERT INTO `profiles_MERGE_TABLE` (`id`,`age`,`city`,`country`,`employer`,`ethnicities`,`first_name`,`gender`,`last_name`,`occupation`,`religion`,`state`,`school`,`degree_id`,`height_cm`,`height_feet`,`height_inches`,`secondary_school`,`secondary_degree_id`) SELECT `profiles`.`id`,`profiles`.`age`,`profiles`.`city`,`profiles`.`country`,`profiles`.`employer`,`profiles`.`ethnicities`,`profiles`.`first_name`,`profiles`.`gender`,`profiles`.`last_name`,`profiles`.`occupation`,`profiles`.`religion`,`profiles`.`state`,`profiles`.`school`,`profiles`.`degree_id`,`profiles`.`height_cm`,`profiles`.`height_feet`,`profiles`.`height_inches`,`profiles`.`secondary_school`,`profiles`.`secondary_degree_id` FROM `profiles`");
        iVar.D("DROP TABLE IF EXISTS `profiles`");
        iVar.D("ALTER TABLE `profiles_MERGE_TABLE` RENAME TO `profiles`");
        iVar.D("CREATE TABLE IF NOT EXISTS `user_MERGE_TABLE` (`profile_id` TEXT NOT NULL, `appsFlyerId` TEXT, `emailAddress` TEXT, `is_eligible_for_free_trial` INTEGER NOT NULL, `registeredDate` TEXT NOT NULL, `beans` INTEGER NOT NULL, `birthDay` TEXT, `matchRegion` TEXT NOT NULL, `onHold` INTEGER NOT NULL, `deactivateReason` TEXT, `dateReactivated` TEXT, `location` TEXT, `latitude` REAL, `longitude` REAL, `viewedCoachMarks` TEXT NOT NULL, `referralCode` TEXT, `badgeCount` INTEGER NOT NULL, `appLaunchStreak` INTEGER NOT NULL, `hasPrioritizedLikes` INTEGER NOT NULL, `hasActiveBoost` INTEGER NOT NULL, `boostReportId` TEXT, `numRisingBagels` INTEGER NOT NULL, `lastName` TEXT, `zipCode` TEXT, `ageFrom` INTEGER, `ageTo` INTEGER, `ethnicity` TEXT, `gender` TEXT, `religion` TEXT, `maxDistanceMiles` INTEGER, `maxDistanceKm` INTEGER, `heightFeetFrom` INTEGER, `heightFeetTo` INTEGER, `heightInchFrom` INTEGER, `heightInchTo` INTEGER, `heightCmFrom` INTEGER, `heightCmTo` INTEGER, `first_icebreaker` TEXT NOT NULL, `second_icebreaker` TEXT NOT NULL, `third_icebreaker` TEXT NOT NULL, PRIMARY KEY(`profile_id`))");
        iVar.D("INSERT INTO `user_MERGE_TABLE` (`profile_id`,`appsFlyerId`,`emailAddress`,`is_eligible_for_free_trial`,`registeredDate`,`beans`,`birthDay`,`matchRegion`,`onHold`,`deactivateReason`,`dateReactivated`,`location`,`latitude`,`longitude`,`viewedCoachMarks`,`referralCode`,`badgeCount`,`appLaunchStreak`,`hasPrioritizedLikes`,`hasActiveBoost`,`boostReportId`,`numRisingBagels`,`lastName`,`zipCode`,`ageFrom`,`ageTo`,`ethnicity`,`gender`,`religion`,`maxDistanceMiles`,`maxDistanceKm`,`heightFeetFrom`,`heightFeetTo`,`heightInchFrom`,`heightInchTo`,`heightCmFrom`,`heightCmTo`,`first_icebreaker`,`second_icebreaker`,`third_icebreaker`) SELECT `user`.`profile_id`,`user`.`appsFlyerId`,`user`.`emailAddress`,`user`.`is_eligible_for_free_trial`,`user`.`registeredDate`,0,NULL,'',0,NULL,NULL,NULL,NULL,NULL,'',NULL,0,0,0,0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','' FROM `user`");
        iVar.D("DROP TABLE IF EXISTS `user`");
        iVar.D("ALTER TABLE `user_MERGE_TABLE` RENAME TO `user`");
    }
}
