package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class y0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final y0 f14857c = new y0();

    private y0() {
        super(56, 57);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `photos_MERGE_TABLE` (`photoId` TEXT NOT NULL, `caption` TEXT, `position` INTEGER NOT NULL, `profile_id` TEXT NOT NULL, `url` TEXT NOT NULL, PRIMARY KEY(`photoId`), FOREIGN KEY(`profile_id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        String b10 = w1.f14850a.b().b();
        iVar.D("INSERT INTO `photos_MERGE_TABLE` (`caption`,`position`,`profile_id`,`url`,`photoId`) SELECT `photos`.`caption`,`photos`.`position`,`photos`.`profile_id`,`photos`.`url`," + b10 + " FROM `photos`");
        iVar.D("DROP TABLE IF EXISTS `photos`");
        iVar.D("ALTER TABLE `photos_MERGE_TABLE` RENAME TO `photos`");
        iVar.D("CREATE INDEX IF NOT EXISTS `index_photos_profile_id` ON `photos` (`profile_id`)");
    }
}
