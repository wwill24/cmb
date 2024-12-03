package i4;

import com.coffeemeetsbagel.models.util.DateUtils;
import com.leanplum.migration.MigrationConstants;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public interface h {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f15488a = new SimpleDateFormat(DateUtils.DATE_PATTERN_NUMBERS_SLASHES_DEFAULT, Locale.US);

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f15489b = {"Notification Clicked", "Notification Viewed", "Geocluster Entered", "Geocluster Exited"};

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<String> f15490c = new HashSet<>(Arrays.asList(new String[]{MigrationConstants.IDENTITY, "Email"}));

    /* renamed from: d  reason: collision with root package name */
    public static final HashSet<String> f15491d = new HashSet<>(Arrays.asList(new String[]{MigrationConstants.IDENTITY, "Email", "Phone"}));

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f15492e = new String[0];
}
