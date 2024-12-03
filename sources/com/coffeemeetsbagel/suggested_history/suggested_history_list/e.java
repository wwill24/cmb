package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.q;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.BagelAction;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import org.jivesoftware.smack.packet.Message;
import w9.b;
import zb.c;

public final class e extends q<Bagel, a> {

    /* renamed from: h  reason: collision with root package name */
    public static final b f37158h = new b((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private final ImageLoaderContract f37159f;

    /* renamed from: g  reason: collision with root package name */
    private final p f37160g;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final c f37161u;

        /* renamed from: v  reason: collision with root package name */
        private final ImageLoaderContract f37162v;

        /* renamed from: w  reason: collision with root package name */
        private final String f37163w = "SuggestedHistoryListAdapter.ViewHolder";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, ImageLoaderContract imageLoaderContract) {
            super(cVar.getRoot());
            j.g(cVar, "binding");
            j.g(imageLoaderContract, "imageLoader");
            this.f37161u = cVar;
            this.f37162v = imageLoaderContract;
        }

        public final void V(Bagel bagel) {
            Integer num;
            String str;
            String str2;
            boolean z10;
            List<String> list;
            boolean z11;
            String str3;
            List<NetworkPhoto> photos;
            NetworkPhoto networkPhoto;
            String str4;
            List<String> listSchools;
            String str5;
            j.g(bagel, Extra.BAGEL);
            TextView textView = this.f37161u.f42239c;
            o oVar = o.f32141a;
            Object[] objArr = new Object[2];
            NetworkProfile profile = bagel.getProfile();
            if (profile != null) {
                num = Integer.valueOf(profile.getAge());
            } else {
                num = null;
            }
            objArr[0] = num;
            NetworkProfile profile2 = bagel.getProfile();
            if (profile2 != null) {
                str = profile2.getCity();
            } else {
                str = null;
            }
            boolean z12 = true;
            objArr[1] = str;
            String format2 = String.format("%s, %s", Arrays.copyOf(objArr, 2));
            j.f(format2, "format(format, *args)");
            textView.setText(format2);
            NetworkProfile profile3 = bagel.getProfile();
            if (profile3 != null) {
                str2 = profile3.getOccupation();
            } else {
                str2 = null;
            }
            if (str2 == null || str2.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f37161u.f42241e.setVisibility(8);
            } else {
                this.f37161u.f42241e.setVisibility(0);
                TextView textView2 = this.f37161u.f42241e;
                NetworkProfile profile4 = bagel.getProfile();
                if (profile4 != null) {
                    str5 = profile4.getOccupation();
                } else {
                    str5 = null;
                }
                textView2.setText(str5);
            }
            NetworkProfile profile5 = bagel.getProfile();
            if (profile5 != null) {
                list = profile5.getListSchools();
            } else {
                list = null;
            }
            if (list == null || list.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.f37161u.f42241e.setVisibility(8);
            } else {
                this.f37161u.f42240d.setVisibility(0);
                TextView textView3 = this.f37161u.f42240d;
                NetworkProfile profile6 = bagel.getProfile();
                if (profile6 == null || (listSchools = profile6.getListSchools()) == null) {
                    str4 = null;
                } else {
                    str4 = (String) CollectionsKt___CollectionsKt.P(listSchools);
                }
                textView3.setText(str4);
            }
            NetworkProfile profile7 = bagel.getProfile();
            if (profile7 == null || (photos = profile7.getPhotos()) == null || (networkPhoto = (NetworkPhoto) CollectionsKt___CollectionsKt.P(photos)) == null) {
                str3 = null;
            } else {
                str3 = networkPhoto.getUrl();
            }
            if (!(str3 == null || str3.length() == 0)) {
                z12 = false;
            }
            if (!z12) {
                ImageLoaderContract imageLoaderContract = this.f37162v;
                Context context = this.f6302a.getContext();
                ImageView imageView = this.f37161u.f42238b;
                List n10 = q.n(b.a.f18329a);
                j.f(context, IdentityHttpResponse.CONTEXT);
                ImageLoaderContract.a.a(imageLoaderContract, context, str3, imageView, (Integer) null, Integer.valueOf(R.drawable.ic_avatar_placeholder), (ImageLoaderContract.b) null, n10, (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 4008, (Object) null);
            } else {
                this.f37161u.f42238b.setImageResource(R.drawable.ic_avatar_placeholder);
            }
            if (bagel.isConnected()) {
                this.f37161u.f42243g.setImageResource(R.drawable.connected_stamp);
            } else if (bagel.getAction() == BagelAction.LIKE.getId()) {
                Integer purchaseAttributionValue = bagel.getPurchaseAttributionValue();
                int purchaseAttributionInteger = PurchaseAttribution.PAID_LIKE.getPurchaseAttributionInteger();
                if (purchaseAttributionValue != null && purchaseAttributionValue.intValue() == purchaseAttributionInteger) {
                    this.f37161u.f42243g.setImageResource(R.drawable.paid_like_stamp);
                } else {
                    this.f37161u.f42243g.setImageResource(R.drawable.liked_stamp);
                }
            } else if (bagel.getAction() == BagelAction.PASS.getId()) {
                this.f37161u.f42243g.setImageResource(R.drawable.passed_stamp);
            } else {
                this.f37161u.f42243g.setImageDrawable((Drawable) null);
                fa.a.f40771d.c(this.f37163w, "", new IllegalArgumentException("Unexpected action " + bagel.getAction() + " for match with profile id " + bagel.getProfileId()));
            }
        }
    }

    public static final class b extends h.f<Bagel> {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: d */
        public boolean a(Bagel bagel, Bagel bagel2) {
            j.g(bagel, "oldItem");
            j.g(bagel2, "newItem");
            return j.b(bagel, bagel2);
        }

        /* renamed from: e */
        public boolean b(Bagel bagel, Bagel bagel2) {
            j.g(bagel, "oldItem");
            j.g(bagel2, "newItem");
            return j.b(bagel.getId(), bagel2.getId());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ImageLoaderContract imageLoaderContract, p pVar) {
        super(f37158h);
        j.g(imageLoaderContract, "imageLoader");
        j.g(pVar, "listener");
        this.f37159f = imageLoaderContract;
        this.f37160g = pVar;
    }

    /* access modifiers changed from: private */
    public static final void N(e eVar, Bagel bagel, View view) {
        j.g(eVar, "this$0");
        p pVar = eVar.f37160g;
        j.f(bagel, "item");
        pVar.n(bagel);
    }

    /* renamed from: M */
    public void v(a aVar, int i10) {
        j.g(aVar, "holder");
        Bagel bagel = (Bagel) H(i10);
        aVar.f6302a.setOnClickListener(new d(this, bagel));
        j.f(bagel, "item");
        aVar.V(bagel);
    }

    /* renamed from: O */
    public a x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        c c10 = c.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        j.f(c10, "inflate(\n               …      false\n            )");
        return new a(c10, this.f37159f);
    }
}
