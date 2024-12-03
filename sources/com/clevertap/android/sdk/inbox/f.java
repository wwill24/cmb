package com.clevertap.android.sdk.inbox;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
import org.json.b;

class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private b f10540a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10541b;

    /* renamed from: c  reason: collision with root package name */
    private final g f10542c;

    /* renamed from: d  reason: collision with root package name */
    private final CTInboxMessage f10543d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10544e;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager f10545f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10546g;

    f(int i10, CTInboxMessage cTInboxMessage, String str, b bVar, g gVar, boolean z10) {
        this.f10544e = i10;
        this.f10543d = cTInboxMessage;
        this.f10541b = str;
        this.f10542c = gVar;
        this.f10540a = bVar;
        this.f10546g = z10;
    }

    private void a(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData newPlainText = ClipData.newPlainText(this.f10541b, this.f10543d.e().get(0).g(this.f10540a));
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(newPlainText);
            Toast.makeText(context, "Text Copied to Clipboard", 0).show();
        }
    }

    private HashMap<String, String> b(CTInboxMessage cTInboxMessage) {
        if (cTInboxMessage == null || cTInboxMessage.e() == null || cTInboxMessage.e().get(0) == null || !"kv".equalsIgnoreCase(cTInboxMessage.e().get(0).l(this.f10540a))) {
            return null;
        }
        return cTInboxMessage.e().get(0).h(this.f10540a);
    }

    public void onClick(View view) {
        ViewPager viewPager = this.f10545f;
        if (viewPager != null) {
            g gVar = this.f10542c;
            if (gVar != null) {
                gVar.G0(this.f10544e, viewPager.getCurrentItem(), this.f10546g);
            }
        } else if (this.f10541b == null || this.f10540a == null) {
            g gVar2 = this.f10542c;
            if (gVar2 != null) {
                gVar2.F0(this.f10544e, (String) null, (b) null, (HashMap<String, String>) null, this.f10546g);
            }
        } else if (this.f10542c != null) {
            if (this.f10543d.e().get(0).l(this.f10540a).equalsIgnoreCase("copy") && this.f10542c.getActivity() != null) {
                a(this.f10542c.getActivity());
            }
            this.f10542c.F0(this.f10544e, this.f10541b, this.f10540a, b(this.f10543d), this.f10546g);
        }
    }

    f(int i10, CTInboxMessage cTInboxMessage, String str, g gVar, ViewPager viewPager, boolean z10) {
        this.f10544e = i10;
        this.f10543d = cTInboxMessage;
        this.f10541b = str;
        this.f10542c = gVar;
        this.f10545f = viewPager;
        this.f10546g = z10;
    }
}
