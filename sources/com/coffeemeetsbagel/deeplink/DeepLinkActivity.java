package com.coffeemeetsbagel.deeplink;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.c;
import com.coffeemeetsbagel.activities.ActivityProfileEdit;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import java.util.ArrayList;

public class DeepLinkActivity extends c {

    public interface a {
        void a(DeepLinkActivity deepLinkActivity);
    }

    public interface b {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Class<ShopComponentActivity> cls = ShopComponentActivity.class;
        super.onCreate(bundle);
        a.a().b(Bakery.j()).a().a(this);
        Uri data = getIntent().getData();
        ArrayList<Intent> arrayList = new ArrayList<>();
        if (data != null) {
            if (!"item".equals(data.getHost()) || !ModelDeeplinkData.VALUE_PAGE_BEAN_SHOP.equals(data.getScheme())) {
                if (ModelDeeplinkData.CMB_AUTHORITY.equals(data.getScheme())) {
                    String host = data.getHost();
                    host.hashCode();
                    char c10 = 65535;
                    switch (host.hashCode()) {
                        case -989034367:
                            if (host.equals("photos")) {
                                c10 = 0;
                                break;
                            }
                            break;
                        case -309210225:
                            if (host.equals("prompts")) {
                                c10 = 1;
                                break;
                            }
                            break;
                        case 3242771:
                            if (host.equals("item")) {
                                c10 = 2;
                                break;
                            }
                            break;
                        case 3529462:
                            if (host.equals("shop")) {
                                c10 = 3;
                                break;
                            }
                            break;
                        case 502611593:
                            if (host.equals("interests")) {
                                c10 = 4;
                                break;
                            }
                            break;
                    }
                    switch (c10) {
                        case 0:
                            Intent Y1 = ActivityProfileEdit.Y1(this, "FRAGMENT_INDEX_PHOTOS", (ProfileCategory) null, false);
                            Y1.setAction("android.intent.action.VIEW");
                            Y1.setData(data);
                            arrayList.add(Y1);
                            break;
                        case 1:
                            Intent Y12 = ActivityProfileEdit.Y1(this, "FRAGMENT_INDEX_PROMPTS", (ProfileCategory) null, false);
                            Y12.setAction("android.intent.action.VIEW");
                            Y12.setData(data);
                            arrayList.add(Y12);
                            break;
                        case 2:
                        case 3:
                            Intent intent = new Intent(this, cls);
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(data);
                            arrayList.add(intent);
                            break;
                        case 4:
                            Intent Y13 = ActivityProfileEdit.Y1(this, "FRAGMENT_INDEX_DETAILS", (ProfileCategory) null, false);
                            Y13.setAction("android.intent.action.VIEW");
                            Y13.setData(data);
                            arrayList.add(Y13);
                            break;
                    }
                }
            } else {
                Intent intent2 = new Intent(this, cls);
                intent2.setAction("android.intent.action.VIEW");
                intent2.setData(data);
                arrayList.add(intent2);
            }
        }
        if (arrayList.isEmpty()) {
            fa.a.i(new IllegalArgumentException("Deep-link '" + data + "' is not supported"));
        }
        TaskStackBuilder create = TaskStackBuilder.create(this);
        create.addNextIntentWithParentStack(new Intent(this, ActivityMain.class));
        for (Intent addNextIntentWithParentStack : arrayList) {
            create.addNextIntentWithParentStack(addNextIntentWithParentStack);
        }
        create.startActivities();
        finish();
    }
}
