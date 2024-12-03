package com.coffeemeetsbagel.feature.chatlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.feature.chatlist.ConnectionHolder;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.dto.MatchContract;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import com.mparticle.identity.IdentityHttpResponse;
import io.reactivex.BackpressureStrategy;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;
import q5.f;
import qj.h;
import w9.b;

public final class c1 extends ArrayAdapter<ConnectionHolder> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f12902f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private List<ConnectionHolder> f12903a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private PublishSubject<Integer> f12904b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12905c;

    /* renamed from: d  reason: collision with root package name */
    private Set<Integer> f12906d;

    /* renamed from: e  reason: collision with root package name */
    private final k f12907e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12908a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.coffeemeetsbagel.feature.chatlist.ConnectionHolder$ConnectionHolderType[] r0 = com.coffeemeetsbagel.feature.chatlist.ConnectionHolder.ConnectionHolderType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.feature.chatlist.ConnectionHolder$ConnectionHolderType r1 = com.coffeemeetsbagel.feature.chatlist.ConnectionHolder.ConnectionHolderType.UPSELL_LIKES_YOU     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.feature.chatlist.ConnectionHolder$ConnectionHolderType r1 = com.coffeemeetsbagel.feature.chatlist.ConnectionHolder.ConnectionHolderType.INACTIVE_HEADER     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.feature.chatlist.ConnectionHolder$ConnectionHolderType r1 = com.coffeemeetsbagel.feature.chatlist.ConnectionHolder.ConnectionHolderType.ACTIVE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.feature.chatlist.ConnectionHolder$ConnectionHolderType r1 = com.coffeemeetsbagel.feature.chatlist.ConnectionHolder.ConnectionHolderType.INACTIVE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.coffeemeetsbagel.feature.chatlist.ConnectionHolder$ConnectionHolderType r1 = com.coffeemeetsbagel.feature.chatlist.ConnectionHolder.ConnectionHolderType.UPSELL_LIKES_YOU_V2     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f12908a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.chatlist.c1.b.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c1(Context context, int i10) {
        super(context, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        PublishSubject<Integer> C0 = PublishSubject.C0();
        j.f(C0, "create<Int>()");
        this.f12904b = C0;
        this.f12906d = new HashSet();
        this.f12907e = new k();
    }

    private final void c(ViewGroup viewGroup, ConnectionRowView connectionRowView, int i10) {
        PurchaseAttribution purchaseAttribution;
        ConnectionHolder connectionHolder = this.f12903a.get(i10);
        Object tag = connectionRowView.getTag();
        j.e(tag, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.chatlist.ConnectionViewHolder");
        p0 p0Var = (p0) tag;
        p0Var.f12968c.setText(connectionHolder.d());
        m(this, p0Var, i10, false, 4, (Object) null);
        MatchContract g10 = connectionHolder.g();
        if (g10 != null) {
            purchaseAttribution = g10.getPurchaseAttribution();
        } else {
            purchaseAttribution = null;
        }
        r(p0Var, purchaseAttribution);
        p(viewGroup, p0Var, i10);
    }

    private final void d(ConnectionExpiredHeaderView connectionExpiredHeaderView, int i10) {
        String str;
        TextView textView = (TextView) connectionExpiredHeaderView.findViewById(R.id.connection_header);
        if (b.f12908a[this.f12903a.get(i10).i().ordinal()] == 2) {
            str = getContext().getString(R.string.expired);
        } else {
            str = "";
        }
        textView.setText(str);
    }

    private final void e(ViewGroup viewGroup, View view, int i10) {
        Drawable drawable;
        Object tag = view.getTag();
        j.e(tag, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.chatlist.ConnectionViewHolder");
        p0 p0Var = (p0) tag;
        p0Var.f12968c.setText(getContext().getText(R.string.chat_upsell_v2_title));
        p0Var.f12969d.setText(getContext().getText(R.string.chat_upsell_v2_description));
        l(p0Var, i10, true);
        Drawable drawable2 = androidx.core.content.a.getDrawable(p0Var.f12970e.getContext(), R.drawable.like);
        if (drawable2 != null) {
            drawable = drawable2.mutate();
        } else {
            drawable = null;
        }
        p0Var.f12967b.setImageDrawable(drawable);
        p0Var.f12967b.setVisibility(0);
        s(viewGroup, p0Var, false);
    }

    private final void f(View view, int i10) {
        Integer f10 = this.f12903a.get(i10).f();
        Object tag = view.getTag();
        j.e(tag, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.chatlist.UpsellRowViewHolder");
        d1 d1Var = (d1) tag;
        d1Var.d().setText(t9.a.chatListLikesYouUpsellMessage);
        d1Var.c().setText(t9.a.chatListLikesYouUpsellCta);
        d1Var.a().setImageResource(R.drawable.blur_fake_photo);
        if (f10 == null) {
            return;
        }
        if (f10.intValue() >= 100) {
            d1Var.b().setText("99+");
        } else {
            d1Var.b().setText(f10.toString());
        }
    }

    private final void l(p0 p0Var, int i10, boolean z10) {
        List list;
        p0 p0Var2 = p0Var;
        int i11 = i10;
        if (this.f12903a.get(i11).i() == ConnectionHolder.ConnectionHolderType.INACTIVE) {
            p0Var2.f12966a.setAlpha(0.5f);
        } else {
            p0Var2.f12966a.setAlpha(1.0f);
        }
        ConnectionHolder connectionHolder = this.f12903a.get(i11);
        if (this.f12905c && this.f12906d.contains(Integer.valueOf(i10))) {
            p0Var2.f12966a.setAlpha(1.0f);
            p0Var2.f12966a.setImageDrawable(this.f12907e.a(getContext(), R.color.main_color, R.drawable.circle_light_gray, R.dimen.spacer_2, R.dimen.spacer_1));
        } else if (connectionHolder.e() != null) {
            if (z10) {
                list = q.m(b.g.f18337a, b.c.f18331a, b.a.f18329a);
            } else {
                list = q.m(b.c.f18331a, b.a.f18329a);
            }
            com.coffeemeetsbagel.image_loader.b bVar = com.coffeemeetsbagel.image_loader.b.f13967a;
            Context context = getContext();
            j.f(context, IdentityHttpResponse.CONTEXT);
            String e10 = connectionHolder.e();
            ImageView imageView = p0Var2.f12966a;
            Integer valueOf = Integer.valueOf(R.drawable.icon_profile_placeholder);
            ImageLoaderContract.b bVar2 = new ImageLoaderContract.b(190, 190);
            Map emptyMap = Collections.emptyMap();
            j.f(emptyMap, "emptyMap()");
            bVar.b(context, e10, imageView, valueOf, (Integer) null, bVar2, list, emptyMap, (Function0<Unit>) null, (Function1<? super Bitmap, Unit>) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
        } else {
            com.coffeemeetsbagel.image_loader.b bVar3 = com.coffeemeetsbagel.image_loader.b.f13967a;
            Context context2 = getContext();
            j.f(context2, IdentityHttpResponse.CONTEXT);
            bVar3.a(context2, R.drawable.icon_profile_placeholder, p0Var2.f12966a, (ImageLoaderContract.b) null, p.e(b.c.f18331a), (Function0<Unit>) null, (Function1<? super Bitmap, Unit>) null);
        }
        p0Var2.f12966a.setOnClickListener(new b1(this, i11));
    }

    static /* synthetic */ void m(c1 c1Var, p0 p0Var, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        c1Var.l(p0Var, i10, z10);
    }

    /* access modifiers changed from: private */
    public static final void n(c1 c1Var, int i10, View view) {
        j.g(c1Var, "this$0");
        c1Var.f12904b.d(Integer.valueOf(i10));
    }

    private final void p(ViewGroup viewGroup, p0 p0Var, int i10) {
        String str;
        int i11;
        String str2;
        String str3;
        ConnectionHolder connectionHolder = this.f12903a.get(i10);
        CmbTextView cmbTextView = p0Var.f12969d;
        ConnectionDetails c10 = connectionHolder.c();
        if (c10 == null || (str = c10.getLastMessageText()) == null) {
            str = "";
        }
        cmbTextView.setText(str);
        ConnectionDetails c11 = connectionHolder.c();
        if (c11 != null) {
            i11 = c11.getUnreadMessageCount();
        } else {
            i11 = 0;
        }
        p0Var.f12968c.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.dark_gray));
        p0Var.f12969d.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.dark_gray));
        if (i11 <= 0 || connectionHolder.i() == ConnectionHolder.ConnectionHolderType.INACTIVE) {
            p0Var.f12968c.setTypeface(f.b(getContext(), R.string.font_regular));
            p0Var.f12969d.setTypeface(f.b(getContext(), R.string.font_regular));
        } else {
            p0Var.f12968c.setTypeface(f.b(getContext(), R.string.font_medium));
            p0Var.f12969d.setTypeface(f.b(getContext(), R.string.font_medium));
        }
        if (connectionHolder.i() == ConnectionHolder.ConnectionHolderType.INACTIVE) {
            p0Var.f12968c.setAlpha(0.5f);
            p0Var.f12969d.setAlpha(0.5f);
        } else {
            p0Var.f12968c.setAlpha(1.0f);
            p0Var.f12969d.setAlpha(1.0f);
        }
        if (connectionHolder.h() > 0) {
            s(viewGroup, p0Var, true);
            return;
        }
        if (i11 > 0) {
            ConnectionDetails c12 = connectionHolder.c();
            if (c12 != null) {
                str2 = c12.getLastSenderProfileId();
            } else {
                str2 = null;
            }
            MatchContract g10 = connectionHolder.g();
            if (g10 != null) {
                str3 = g10.getProfileId();
            } else {
                str3 = null;
            }
            if (r.u(str2, str3, false, 2, (Object) null) && connectionHolder.i() == ConnectionHolder.ConnectionHolderType.ACTIVE) {
                s(viewGroup, p0Var, false);
                return;
            }
        }
        p0Var.f12970e.removeAllViews();
        p0Var.f12970e.setVisibility(8);
    }

    private final void r(p0 p0Var, PurchaseAttribution purchaseAttribution) {
        Drawable drawable;
        if (purchaseAttribution != null) {
            Context context = p0Var.f12970e.getContext();
            Drawable drawable2 = androidx.core.content.a.getDrawable(context, purchaseAttribution.getDrawableId());
            if (drawable2 != null) {
                drawable = drawable2.mutate();
            } else {
                drawable = null;
            }
            int color = androidx.core.content.a.getColor(context, purchaseAttribution.getColorId());
            if (drawable != null) {
                drawable.setTint(color);
            }
            p0Var.f12967b.setImageDrawable(drawable);
            p0Var.f12967b.setVisibility(0);
            return;
        }
        p0Var.f12967b.setVisibility(8);
    }

    private final void s(ViewGroup viewGroup, p0 p0Var, boolean z10) {
        View view;
        if (z10) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.message_failed_pill_view, viewGroup, false);
        } else {
            view = LayoutInflater.from(getContext()).inflate(R.layout.your_move_view_dls, viewGroup, false);
        }
        p0Var.f12970e.removeAllViews();
        p0Var.f12970e.addView(view);
        p0Var.f12970e.setVisibility(0);
    }

    public final h<Integer> b() {
        h<Integer> v02 = this.f12904b.P().v0(BackpressureStrategy.BUFFER);
        j.f(v02, "avatarPublishSubject.hid…kpressureStrategy.BUFFER)");
        return v02;
    }

    public final MatchContract g(int i10) {
        if (i10 >= this.f12903a.size()) {
            return null;
        }
        return this.f12903a.get(i10).g();
    }

    public int getCount() {
        return this.f12903a.size();
    }

    public int getItemViewType(int i10) {
        int i11 = b.f12908a[this.f12903a.get(i10).i().ordinal()];
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 2;
        }
        if (i11 == 3 || i11 == 4) {
            return 3;
        }
        if (i11 == 5) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        ConnectionExpiredHeaderView connectionExpiredHeaderView;
        ConnectionRowView connectionRowView;
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        int itemViewType = getItemViewType(i10);
        Object obj = null;
        if (itemViewType == 0) {
            if (view != null) {
                obj = view.getTag();
            }
            if (!(obj instanceof d1)) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.row_likes_you_upsell, viewGroup, false);
                j.f(view, "inflatedView");
                view.setTag(new d1(view));
            }
            j.f(view, "view");
            f(view, i10);
            return view;
        } else if (itemViewType == 1) {
            if (view != null) {
                obj = view.getTag();
            }
            if (!(obj instanceof ConnectionRowView)) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.row_view_connection_dls, viewGroup, false);
                view.setTag(new p0(view));
            }
            j.f(view, "view");
            e(viewGroup, view, i10);
            return view;
        } else if (itemViewType == 2) {
            if (view instanceof ConnectionExpiredHeaderView) {
                connectionExpiredHeaderView = (ConnectionExpiredHeaderView) view;
            } else {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.row_view_connection_header_dls, viewGroup, false);
                j.f(inflate, "from(context)\n          …eader_dls, parent, false)");
                inflate.setTag(new o0());
                connectionExpiredHeaderView = (ConnectionExpiredHeaderView) inflate;
            }
            d(connectionExpiredHeaderView, i10);
            return connectionExpiredHeaderView;
        } else if (itemViewType != 3) {
            return new View(getContext());
        } else {
            if (view instanceof ConnectionRowView) {
                connectionRowView = (ConnectionRowView) view;
            } else {
                View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.row_view_connection_dls, viewGroup, false);
                inflate2.setTag(new p0(inflate2));
                j.e(inflate2, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.chatlist.ConnectionRowView");
                connectionRowView = (ConnectionRowView) inflate2;
            }
            c(viewGroup, connectionRowView, i10);
            return connectionRowView;
        }
    }

    public int getViewTypeCount() {
        return 4;
    }

    public final boolean h(int i10) {
        if (i10 < this.f12903a.size() && this.f12903a.get(i10).i() != ConnectionHolder.ConnectionHolderType.INACTIVE_HEADER) {
            return true;
        }
        return false;
    }

    public final boolean i(int i10) {
        return this.f12903a.get(i10).i() == ConnectionHolder.ConnectionHolderType.INACTIVE;
    }

    public final boolean j(int i10) {
        if (this.f12903a.get(i10).i() == ConnectionHolder.ConnectionHolderType.UPSELL_LIKES_YOU || this.f12903a.get(i10).i() == ConnectionHolder.ConnectionHolderType.UPSELL_LIKES_YOU_V2) {
            return true;
        }
        return false;
    }

    public final void k(boolean z10) {
        this.f12905c = z10;
    }

    public final void o(Set<Integer> set) {
        j.g(set, "checkedPositions");
        this.f12906d = set;
    }

    public final void q(List<ConnectionHolder> list) {
        j.g(list, "data");
        this.f12903a = list;
    }

    public final int t() {
        int i10 = 0;
        for (ConnectionHolder i11 : this.f12903a) {
            if (i11.i() == ConnectionHolder.ConnectionHolderType.ACTIVE) {
                i10++;
            }
        }
        return i10;
    }
}
