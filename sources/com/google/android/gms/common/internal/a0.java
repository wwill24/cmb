package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.g;
import androidx.core.os.f;
import com.google.android.gms.common.GooglePlayServicesUtil;
import de.b;
import java.util.Locale;
import me.j;
import oe.d;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static final g f38961a = new g();

    /* renamed from: b  reason: collision with root package name */
    private static Locale f38962b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return d.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                return packageName;
            }
            return str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(b.common_google_play_services_notification_channel_name);
    }

    @NonNull
    public static String c(Context context, int i10) {
        Resources resources = context.getResources();
        if (i10 == 1) {
            return resources.getString(b.common_google_play_services_install_button);
        }
        if (i10 == 2) {
            return resources.getString(b.common_google_play_services_update_button);
        }
        if (i10 != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(b.common_google_play_services_enable_button);
    }

    @NonNull
    public static String d(Context context, int i10) {
        Resources resources = context.getResources();
        String a10 = a(context);
        if (i10 == 1) {
            return resources.getString(b.common_google_play_services_install_text, new Object[]{a10});
        } else if (i10 != 2) {
            if (i10 == 3) {
                return resources.getString(b.common_google_play_services_enable_text, new Object[]{a10});
            } else if (i10 == 5) {
                return h(context, "common_google_play_services_invalid_account_text", a10);
            } else {
                if (i10 == 7) {
                    return h(context, "common_google_play_services_network_error_text", a10);
                }
                if (i10 == 9) {
                    return resources.getString(b.common_google_play_services_unsupported_text, new Object[]{a10});
                } else if (i10 == 20) {
                    return h(context, "common_google_play_services_restricted_profile_text", a10);
                } else {
                    switch (i10) {
                        case 16:
                            return h(context, "common_google_play_services_api_unavailable_text", a10);
                        case 17:
                            return h(context, "common_google_play_services_sign_in_failed_text", a10);
                        case 18:
                            return resources.getString(b.common_google_play_services_updating_text, new Object[]{a10});
                        default:
                            return resources.getString(com.google.android.gms.common.g.common_google_play_services_unknown_issue, new Object[]{a10});
                    }
                }
            }
        } else if (j.e(context)) {
            return resources.getString(b.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(b.common_google_play_services_update_text, new Object[]{a10});
        }
    }

    @NonNull
    public static String e(Context context, int i10) {
        if (i10 == 6 || i10 == 19) {
            return h(context, "common_google_play_services_resolution_required_text", a(context));
        }
        return d(context, i10);
    }

    @NonNull
    public static String f(Context context, int i10) {
        String str;
        if (i10 == 6) {
            str = i(context, "common_google_play_services_resolution_required_title");
        } else {
            str = g(context, i10);
        }
        if (str == null) {
            return context.getResources().getString(b.common_google_play_services_notification_ticker);
        }
        return str;
    }

    public static String g(Context context, int i10) {
        Resources resources = context.getResources();
        switch (i10) {
            case 1:
                return resources.getString(b.common_google_play_services_install_title);
            case 2:
                return resources.getString(b.common_google_play_services_update_title);
            case 3:
                return resources.getString(b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                return i(context, "common_google_play_services_invalid_account_title");
            case 7:
                return i(context, "common_google_play_services_network_error_title");
            case 8:
            case 9:
            case 10:
            case 11:
            case 16:
                return null;
            case 17:
                return i(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                return i(context, "common_google_play_services_restricted_profile_title");
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected error code ");
                sb2.append(i10);
                return null;
        }
    }

    private static String h(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String i10 = i(context, str);
        if (i10 == null) {
            i10 = resources.getString(com.google.android.gms.common.g.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, i10, new Object[]{str2});
    }

    private static String i(Context context, String str) {
        g gVar = f38961a;
        synchronized (gVar) {
            Locale c10 = f.a(context.getResources().getConfiguration()).c(0);
            if (!c10.equals(f38962b)) {
                gVar.clear();
                f38962b = c10;
            }
            String str2 = (String) gVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Missing resource: ");
                sb2.append(str);
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Got empty resource: ");
                sb3.append(str);
                return null;
            }
            gVar.put(str, string);
            return string;
        }
    }
}
