package f5;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import h5.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smackx.mam.element.MamElements;
import v9.a;

public class l extends RecyclerView.Adapter<a> {

    /* renamed from: d  reason: collision with root package name */
    private final String f14760d;

    /* renamed from: e  reason: collision with root package name */
    private Activity f14761e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, ResolveInfo> f14762f;

    /* renamed from: g  reason: collision with root package name */
    private PackageManager f14763g;

    /* renamed from: h  reason: collision with root package name */
    private List<String> f14764h;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f14765j;

    /* renamed from: k  reason: collision with root package name */
    private String f14766k;

    /* renamed from: l  reason: collision with root package name */
    private String f14767l;

    /* renamed from: m  reason: collision with root package name */
    private int f14768m;

    /* renamed from: n  reason: collision with root package name */
    private int f14769n;

    public l(Activity activity, Map<String, ResolveInfo> map, List<String> list, String str, CharSequence charSequence, int i10, String str2, int i11, String str3) {
        this.f14761e = activity;
        this.f14762f = map;
        this.f14763g = activity.getPackageManager();
        this.f14764h = list;
        this.f14766k = str;
        this.f14765j = charSequence;
        this.f14767l = str2;
        this.f14768m = i10;
        this.f14769n = i11;
        this.f14760d = str3;
    }

    private int I() {
        return Math.min(this.f14764h.size(), 9);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(View view) {
        N();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(a aVar, View view) {
        String str;
        if (!TextUtils.isEmpty(this.f14767l)) {
            str = this.f14767l;
        } else {
            str = this.f14761e.getString(R.string.invite_body_text);
        }
        m.a(str, this.f14765j, this.f14768m, this.f14764h.get(aVar.q()), this.f14762f, this.f14761e, this.f14769n, this.f14760d);
        HashMap hashMap = new HashMap();
        hashMap.put("source", this.f14766k);
        if (this.f14769n == 9000) {
            Bakery.w().z().j("Give Composer", hashMap);
            hashMap.put(MamElements.MamResultExtension.ELEMENT, "clicked_an_app");
            return;
        }
        Bakery.w().z().j("Invite Composer", hashMap);
        hashMap.put(MamElements.MamResultExtension.ELEMENT, "clicked");
    }

    private void M(String str) {
        String str2 = this.f14761e.getString(R.string.invite_body_text) + " " + str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("#invite link= ");
        sb2.append(str2);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        this.f14761e.startActivity(intent);
    }

    private void N() {
        M(x4.a.f18540d);
    }

    public boolean J(int i10) {
        return I() == i10;
    }

    /* renamed from: O */
    public void v(@NonNull a aVar, int i10) {
        ResolveInfo resolveInfo;
        if (J(i10)) {
            aVar.f6302a.setOnClickListener(new j(this));
        } else if (i10 < this.f14764h.size() && (resolveInfo = this.f14762f.get(this.f14764h.get(i10))) != null) {
            aVar.W().setImageDrawable(resolveInfo.loadIcon(this.f14763g));
            aVar.V().setText(String.valueOf(resolveInfo.loadLabel(this.f14763g)));
            ((LinearLayout) aVar.W().getParent()).setOnClickListener(new k(this, aVar));
        }
    }

    @NonNull
    /* renamed from: P */
    public a x(@NonNull ViewGroup viewGroup, int i10) {
        if (i10 == 1) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.partial_share_with_footer_dls, viewGroup, false));
        }
        if (i10 == 2) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.share_recycler_grid_item_dls, viewGroup, false));
        }
        throw new UnsupportedOperationException("Unknown viewType=" + i10);
    }

    public int g() {
        return I() + 1;
    }

    public int i(int i10) {
        return J(i10) ? 1 : 2;
    }
}
