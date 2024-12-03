package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class b1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final b1 f14779c = new b1();

    private b1() {
        super(59, 60);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `user_MERGE_TABLE` (`profile_id` TEXT NOT NULL, `appsFlyerId` TEXT, `emailAddress` TEXT, `is_eligible_for_free_trial` INTEGER NOT NULL, `registeredDate` TEXT, `beans` INTEGER NOT NULL, `birthDay` TEXT, `matchRegion` TEXT, `onHold` INTEGER NOT NULL, `deactivateReason` TEXT, `dateReactivated` TEXT, `location` TEXT, `viewedCoachMarks` TEXT NOT NULL, `referralCode` TEXT, `badgeCount` INTEGER NOT NULL, `appLaunchStreak` INTEGER NOT NULL, `hasPrioritizedLikes` INTEGER NOT NULL, `hasActiveBoost` INTEGER NOT NULL, `boostReportId` TEXT, `numRisingBagels` INTEGER NOT NULL, `lastName` TEXT, `zipCode` TEXT, `usesMetric` INTEGER NOT NULL, `ageFrom` INTEGER, `ageTo` INTEGER, `ethnicity` TEXT, `gender` TEXT, `religion` TEXT, `maxDistanceMiles` INTEGER NOT NULL, `maxDistanceKm` INTEGER NOT NULL, `heightFeetFrom` INTEGER, `heightFeetTo` INTEGER, `heightInchFrom` INTEGER, `heightInchTo` INTEGER, `heightCmFrom` INTEGER, `heightCmTo` INTEGER, `first_icebreaker` TEXT NOT NULL, `second_icebreaker` TEXT NOT NULL, `third_icebreaker` TEXT NOT NULL, PRIMARY KEY(`profile_id`))");
        iVar.D("INSERT INTO `user_MERGE_TABLE` (`profile_id`,`appsFlyerId`,`emailAddress`,`is_eligible_for_free_trial`,`registeredDate`,`beans`,`birthDay`,`matchRegion`,`onHold`,`deactivateReason`,`dateReactivated`,`location`,`viewedCoachMarks`,`referralCode`,`badgeCount`,`appLaunchStreak`,`hasPrioritizedLikes`,`hasActiveBoost`,`boostReportId`,`numRisingBagels`,`lastName`,`zipCode`,`usesMetric`,`ageFrom`,`ageTo`,`ethnicity`,`gender`,`religion`,`maxDistanceMiles`,`maxDistanceKm`,`heightFeetFrom`,`heightFeetTo`,`heightInchFrom`,`heightInchTo`,`heightCmFrom`,`heightCmTo`,`first_icebreaker`,`second_icebreaker`,`third_icebreaker`) SELECT `user`.`profile_id`,`user`.`appsFlyerId`,`user`.`emailAddress`,`user`.`is_eligible_for_free_trial`,`user`.`registeredDate`,`user`.`beans`,`user`.`birthDay`,`user`.`matchRegion`,`user`.`onHold`,`user`.`deactivateReason`,`user`.`dateReactivated`,`user`.`location`,`user`.`viewedCoachMarks`,`user`.`referralCode`,`user`.`badgeCount`,`user`.`appLaunchStreak`,`user`.`hasPrioritizedLikes`,`user`.`hasActiveBoost`,`user`.`boostReportId`,`user`.`numRisingBagels`,`user`.`lastName`,`user`.`zipCode`,`user`.`usesMetric`,`user`.`ageFrom`,`user`.`ageTo`,`user`.`ethnicity`,`user`.`gender`,`user`.`religion`,`user`.`maxDistanceMiles`,`user`.`maxDistanceKm`,`user`.`heightFeetFrom`,`user`.`heightFeetTo`,`user`.`heightInchFrom`,`user`.`heightInchTo`,`user`.`heightCmFrom`,`user`.`heightCmTo`,`user`.`first_icebreaker`,`user`.`second_icebreaker`,`user`.`third_icebreaker` FROM `user`");
        iVar.D("DROP TABLE IF EXISTS `user`");
        iVar.D("ALTER TABLE `user_MERGE_TABLE` RENAME TO `user`");
    }
}
