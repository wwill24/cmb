package h5;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityShare;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.ShareApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x4.a;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f15373a = Uri.parse("mailto:");

    /* renamed from: b  reason: collision with root package name */
    private static Intent f15374b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<String> f15375c = Arrays.asList(new String[]{ShareApp.WHATSAPP.toString(), ShareApp.KAKAOTALK.toString(), ShareApp.WECHAT.toString(), ShareApp.LINE.toString(), ShareApp.GMAIL.toString(), ShareApp.FACEBOOK.toString(), ShareApp.TWEET.toString(), ShareApp.HANGOUTS.toString(), ShareApp.KIK.toString(), ShareApp.SNAPCHAT.toString(), ShareApp.TANGO_CHAT.toString(), ShareApp.VIBER.toString(), ShareApp.SLACK.toString(), ShareApp.COPY_TO_CLIPBOARD.toString()});

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, String> f15376d;

    /* renamed from: e  reason: collision with root package name */
    public static final List<String> f15377e = d();

    static {
        HashMap hashMap = new HashMap();
        f15376d = hashMap;
        ShareApp shareApp = ShareApp.MESSENGER;
        hashMap.put(shareApp.toString(), shareApp.getNameSpace());
    }

    public static void a(String str, CharSequence charSequence, int i10, String str2, Map<String, ResolveInfo> map, Activity activity, int i11, String str3) {
        l(str, charSequence, i10, a.f18540d, str2, map, activity, i11, str3);
    }

    private static void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("invite app channel", str);
        hashMap.put("user id", Bakery.w().g().getProfileId());
        Bakery.w().z().j("clicked app invite", hashMap);
    }

    public static List<String> c() {
        return new ArrayList(Arrays.asList(new String[]{ShareApp.MESSENGER.toString(), ShareApp.WHATSAPP.toString(), ShareApp.KAKAOTALK.toString(), ShareApp.WECHAT.toString(), ShareApp.LINE.toString(), ShareApp.SMS.toString(), ShareApp.GMAIL.toString(), ShareApp.FACEBOOK.toString(), ShareApp.TWEET.toString(), ShareApp.HANGOUTS.toString(), ShareApp.KIK.toString(), ShareApp.SNAPCHAT.toString(), ShareApp.TANGO_CHAT.toString(), ShareApp.VIBER.toString(), ShareApp.SLACK.toString(), ShareApp.COPY_TO_CLIPBOARD.toString()}));
    }

    public static List<String> d() {
        return new ArrayList(Arrays.asList(new String[]{ShareApp.SMS.toString(), ShareApp.GMAIL.toString(), ShareApp.COPY_TO_CLIPBOARD.toString()}));
    }

    public static Intent e() {
        Intent intent = new Intent("android.intent.action.SEND");
        f15374b = intent;
        intent.setType("text/plain");
        return f15374b;
    }

    public static Intent f(int i10) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setData(f15373a);
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", "");
        if (i10 > 0) {
            intent.putExtra("android.intent.extra.SUBJECT", Bakery.w().getResources().getString(i10));
        }
        return intent;
    }

    private static String g(String str, String str2) {
        int indexOf = str2.indexOf(Bakery.w().getResources().getString(R.string.give_ten_give_email_body_link_text));
        if (indexOf > 0) {
            return str2.substring(0, indexOf) + str + "\n\n" + str2.substring(indexOf);
        }
        return str2 + "\n\n" + str;
    }

    private static Intent h(ResolveInfo resolveInfo, String str, CharSequence charSequence, int i10, String str2, String str3) {
        Intent e10 = e();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        e10.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
        if (!resolveInfo.loadLabel(Bakery.w().getPackageManager()).toString().toLowerCase().equals(ShareApp.GMAIL.toString()) || TextUtils.isEmpty(charSequence)) {
            if (!TextUtils.isEmpty(str3)) {
                str2 = str3;
            }
            e10.putExtra("android.intent.extra.TEXT", g(str2, str));
        } else {
            e10.putExtra("android.intent.extra.TEXT", charSequence);
            Intent f10 = f(i10);
            e10.setData(f10.getData());
            e10.setType(f10.getType());
            e10.putExtras(f10);
        }
        e10.setFlags(268435456);
        return e10;
    }

    public static void i(Activity activity, String str) {
        j(activity, str, (Bundle) null);
    }

    public static void j(Activity activity, String str, Bundle bundle) {
        int i10;
        int i11;
        Intent intent = new Intent(activity, ActivityShare.class);
        intent.putExtra("source", str);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        int parseInt = Integer.parseInt(Bakery.w().g().getProfileId());
        int i12 = 0;
        if (!str.equals(ModelDeeplinkData.VALUE_PAGE_DISCOVER)) {
            i10 = parseInt % 3;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            i12 = R.string.invite_subject0;
            i11 = R.string.invite_message0;
        } else if (i10 == 1) {
            i12 = R.string.invite_subject1;
            i11 = R.string.invite_message1;
        } else if (i10 != 2) {
            i11 = 0;
        } else {
            i12 = R.string.invite_subject2;
            i11 = R.string.invite_message2;
        }
        intent.putExtra(Extra.EMAIL_SUBJECT_ID, i12);
        intent.putExtra("message", activity.getString(i11));
        intent.putExtra(Extra.EMAIL_HTML_TEXT, activity.getString(i11));
        lc.a.c(activity, intent);
    }

    private static void l(String str, CharSequence charSequence, int i10, String str2, String str3, Map<String, ResolveInfo> map, Activity activity, int i11, String str4) {
        if (i11 != 0) {
            activity.startActivityForResult(h(map.get(str3), str, charSequence, i10, str2, str4), i11);
        } else {
            activity.startActivity(h(map.get(str3), str, charSequence, i10, str2, str4));
        }
        b(str3);
    }

    public void k(Activity activity, String str) {
        i(activity, str);
    }
}
