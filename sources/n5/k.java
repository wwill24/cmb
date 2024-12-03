package n5;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.AnimatorListenerStub;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.CmbMessage;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.enums.MessageStatus;
import com.coffeemeetsbagel.models.enums.MessageType;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import w9.b;

public class k extends BaseAdapter {

    /* renamed from: t  reason: collision with root package name */
    private static final float[] f16532t = {0.0f, 1.0f};

    /* renamed from: w  reason: collision with root package name */
    private static final float[] f16533w = {1.0f, 0.0f};

    /* renamed from: a  reason: collision with root package name */
    private final com.coffeemeetsbagel.image_loader.b f16534a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f16535b;

    /* renamed from: c  reason: collision with root package name */
    private Bagel f16536c;

    /* renamed from: d  reason: collision with root package name */
    private Context f16537d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16538e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16539f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CmbMessage f16540g;

    /* renamed from: h  reason: collision with root package name */
    private List<Resource> f16541h;

    /* renamed from: j  reason: collision with root package name */
    private k7.g f16542j;

    /* renamed from: k  reason: collision with root package name */
    private int f16543k = ((int) (((float) Resources.getSystem().getDisplayMetrics().widthPixels) * 0.6f));

    /* renamed from: l  reason: collision with root package name */
    private List<CmbMessage> f16544l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private k7.c f16545m;

    /* renamed from: n  reason: collision with root package name */
    private String f16546n;

    /* renamed from: p  reason: collision with root package name */
    private String f16547p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public CmbMessage f16548q;

    class a extends AnimatorListenerStub {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f16549a;

        a(ImageView imageView) {
            this.f16549a = imageView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16549a.setTag((Object) null);
            k kVar = k.this;
            kVar.f16540g = kVar.f16548q;
            ImageView k10 = k.this.f16539f;
            ImageView imageView = this.f16549a;
            if (k10 != imageView) {
                imageView.setVisibility(8);
            }
        }
    }

    class b extends AnimatorListenerStub {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f16551a;

        b(ImageView imageView) {
            this.f16551a = imageView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16551a.setScaleX(1.0f);
            this.f16551a.setScaleY(1.0f);
            this.f16551a.setTag((Object) null);
            ImageView k10 = k.this.f16539f;
            ImageView imageView = this.f16551a;
            if (k10 != imageView) {
                imageView.setVisibility(8);
            }
        }
    }

    private static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16553a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ImageView f16554b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CmbTextView f16555c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CmbTextView f16556d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public CmbTextView f16557e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f16558f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public RelativeLayout f16559g;

        private c() {
        }
    }

    private static class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16560a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public CmbTextView f16561b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CmbTextView f16562c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CmbTextView f16563d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public CmbTextView f16564e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public RelativeLayout f16565f;

        private d() {
        }
    }

    private static class e {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16566a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ImageView f16567b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CmbTextView f16568c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CmbTextView f16569d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f16570e;

        private e() {
        }
    }

    private static class f {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16571a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public CmbTextView f16572b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CmbTextView f16573c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CmbTextView f16574d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public View f16575e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public View f16576f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public View f16577g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f16578h;

        private f() {
        }
    }

    static class g {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public CmbTextView f16579a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public CmbTextView f16580b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CmbTextView f16581c;

        g() {
        }
    }

    k(Context context, com.coffeemeetsbagel.image_loader.b bVar, Bagel bagel, String str, String str2, k7.g gVar, k7.c cVar) {
        this.f16534a = bVar;
        this.f16546n = str;
        this.f16547p = str2;
        this.f16542j = gVar;
        this.f16545m = cVar;
        this.f16537d = context;
        this.f16536c = bagel;
        this.f16535b = LayoutInflater.from(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(d dVar, View view) {
        dVar.f16565f.setOnClickListener((View.OnClickListener) null);
        dVar.f16565f.setEnabled(false);
        dVar.f16562c.setText(R.string.sending);
        dVar.f16562c.setTextColor(this.f16537d.getResources().getColor(R.color.gray));
        for (CmbMessage next : this.f16544l) {
            if (next.getStatus() == MessageStatus.NOT_SENT) {
                this.f16545m.e0(next);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(View view) {
        this.f16545m.O();
    }

    private void C(ImageView imageView, NetworkProfile networkProfile) {
        q5.f.e(imageView);
        if (networkProfile == null) {
            fa.a.i(new IllegalStateException("profile null in load avatar"));
        }
        if (networkProfile == null || networkProfile.getProfilePhoto() == null || TextUtils.isEmpty(networkProfile.getProfilePhoto().getUrl())) {
            com.coffeemeetsbagel.image_loader.b bVar = this.f16534a;
            Context context = this.f16537d;
            com.coffeemeetsbagel.image_loader.b bVar2 = bVar;
            Context context2 = context;
            ImageView imageView2 = imageView;
            bVar2.a(context2, R.drawable.icon_profile_placeholder, imageView2, (ImageLoaderContract.b) null, Arrays.asList(new b.c[]{b.c.f18331a}), (Function0<Unit>) null, (Function1<? super Bitmap, Unit>) null);
            return;
        }
        String url = networkProfile.getProfilePhoto().getUrl();
        ImageView imageView3 = imageView;
        this.f16534a.b(this.f16537d, url, imageView3, Integer.valueOf(R.drawable.icon_profile_placeholder), (Integer) null, new ImageLoaderContract.b(190, 190), Arrays.asList(new w9.b[]{b.c.f18331a, b.a.f18329a}), Collections.emptyMap(), (Function0<Unit>) null, (Function1<? super Bitmap, Unit>) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
    }

    private void D(ImageView imageView, ProgressBar progressBar, String str) {
        ProgressBar progressBar2 = progressBar;
        if (!TextUtils.isEmpty(str)) {
            imageView.getLayoutParams().width = this.f16543k;
            progressBar.getLayoutParams().width = this.f16543k;
            progressBar2.setVisibility(0);
            com.coffeemeetsbagel.image_loader.b bVar = this.f16534a;
            Context context = this.f16537d;
            Integer valueOf = Integer.valueOf(R.drawable.image_placeholder);
            int i10 = this.f16543k;
            bVar.b(context, str, imageView, (Integer) null, valueOf, new ImageLoaderContract.b(i10, i10), Arrays.asList(new b.i[]{new b.i((int) TypedValue.applyDimension(1, (float) this.f16537d.getResources().getInteger(R.integer.chat_media_image_corner_radius), this.f16537d.getResources().getDisplayMetrics()), 0, this.f16543k)}), Collections.emptyMap(), new f(progressBar2), new g(this, progressBar2, imageView, str), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
        }
    }

    private void E(ImageView imageView, ProgressBar progressBar, String str) {
        ImageView imageView2 = imageView;
        ProgressBar progressBar2 = progressBar;
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            int applyDimension = (int) TypedValue.applyDimension(1, 150.0f, this.f16537d.getResources().getDisplayMetrics());
            imageView.getLayoutParams().width = applyDimension;
            progressBar.getLayoutParams().width = applyDimension;
            imageView.getLayoutParams().height = applyDimension;
            imageView2.setTag(str2);
            progressBar2.setVisibility(0);
            this.f16534a.b(this.f16537d, str, imageView, (Integer) null, Integer.valueOf(R.drawable.sticker_placeholder), (ImageLoaderContract.b) null, Arrays.asList(new b.i[]{new b.i((int) TypedValue.applyDimension(1, (float) this.f16537d.getResources().getInteger(R.integer.chat_media_image_corner_radius), this.f16537d.getResources().getDisplayMetrics()), 0, this.f16543k)}), Collections.emptyMap(), new h(imageView2, str2, progressBar2), new i(imageView2, str2, progressBar2), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
        }
    }

    private void G(TextView textView, CmbMessage cmbMessage, int i10) {
        String dateSent = cmbMessage.getDateSent();
        textView.setVisibility(0);
        String r10 = r(dateSent);
        if (i10 > 0) {
            String dateSent2 = this.f16544l.get(i10 - 1).getDateSent();
            Date localDate = DateUtils.getLocalDate(cmbMessage.getDateSent(), DateUtils.DATE_WITH_TIME_PATTERN);
            Date localDate2 = DateUtils.getLocalDate(dateSent2, DateUtils.DATE_WITH_TIME_PATTERN);
            Calendar instance = Calendar.getInstance();
            instance.setTime(localDate);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(localDate2);
            if (instance2.get(5) == instance.get(5)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        } else {
            textView.setVisibility(0);
        }
        textView.setText(r10);
    }

    private void H(TextView textView, CmbMessage cmbMessage) {
        String q10 = q(cmbMessage.getDateSent());
        if (cmbMessage.isPrivate()) {
            String string = this.f16537d.getResources().getString(R.string.only_visible_to_me);
            textView.setText(this.f16537d.getString(R.string.date_below_format, new Object[]{string, q10}));
        } else {
            textView.setText(q10);
        }
        textView.setTextColor(this.f16537d.getResources().getColor(R.color.gray));
    }

    private void K(CmbTextView cmbTextView, int i10) {
        if (!this.f16538e && i10 == getCount() - 1 && cmbTextView != null) {
            cmbTextView.setVisibility(0);
            cmbTextView.setOnClickListener(new e(this));
            this.f16545m.l();
        } else if (cmbTextView != null) {
            cmbTextView.setVisibility(8);
        }
    }

    private View L(View view, ViewGroup viewGroup, int i10, boolean z10) {
        CmbMessage cmbMessage = this.f16544l.get(i10);
        boolean z11 = false;
        if (view == null || view.getTag() == null) {
            view = this.f16535b.inflate(R.layout.row_view_media_from_me_dls, viewGroup, false);
            c cVar = new c();
            cVar.f16555c = (CmbTextView) view.findViewById(R.id.textView_date);
            cVar.f16556d = (CmbTextView) view.findViewById(R.id.textView_date_message);
            cVar.f16559g = (RelativeLayout) view.findViewById(R.id.relativeLayout_message_container);
            cVar.f16554b = (ImageView) view.findViewById(R.id.imageView_message);
            cVar.f16558f = (ProgressBar) view.findViewById(R.id.media_progress_bar);
            cVar.f16553a = (ImageView) view.findViewById(R.id.imageView_avatar);
            cVar.f16557e = (CmbTextView) view.findViewById(R.id.check_read_status);
            view.setTag(cVar);
        }
        c cVar2 = (c) view.getTag();
        H(cVar2.f16556d, cmbMessage);
        G(cVar2.f16555c, cmbMessage, i10);
        MessageStatus status = cmbMessage.getStatus();
        RelativeLayout b10 = cVar2.f16559g;
        MessageStatus messageStatus = MessageStatus.NOT_SENT;
        if (status == messageStatus) {
            z11 = true;
        }
        b10.setEnabled(z11);
        if (status == MessageStatus.SENDING) {
            cVar2.f16556d.setText(R.string.sending);
        } else if (status == messageStatus) {
            cVar2.f16556d.setText(R.string.message_failed);
            cVar2.f16556d.setTextColor(this.f16537d.getResources().getColor(R.color.error_color));
            cVar2.f16559g.setOnClickListener(new d(this, cVar2));
        }
        P(cmbMessage, cVar2.f16553a);
        K(cVar2.f16557e, i10);
        if (z10) {
            E(cVar2.f16554b, cVar2.f16558f, cmbMessage.getImageUrl());
        } else {
            D(cVar2.f16554b, cVar2.f16558f, cmbMessage.getImageUrl());
        }
        return view;
    }

    private View M(View view, ViewGroup viewGroup, int i10, boolean z10) {
        CmbMessage cmbMessage = this.f16544l.get(i10);
        if (view == null || view.getTag() == null) {
            view = this.f16535b.inflate(R.layout.row_view_media_from_other_dls, viewGroup, false);
            e eVar = new e();
            eVar.f16568c = (CmbTextView) view.findViewById(R.id.textView_date);
            eVar.f16569d = (CmbTextView) view.findViewById(R.id.textView_date_message);
            eVar.f16566a = (ImageView) view.findViewById(R.id.imageView_avatar_other);
            eVar.f16567b = (ImageView) view.findViewById(R.id.imageView_message);
            eVar.f16570e = (ProgressBar) view.findViewById(R.id.media_progress_bar);
            view.setTag(eVar);
        }
        e eVar2 = (e) view.getTag();
        H(eVar2.f16569d, cmbMessage);
        G(eVar2.f16568c, cmbMessage, i10);
        C(eVar2.f16566a, this.f16536c.getProfile());
        eVar2.f16566a.setOnClickListener(new a(this));
        if (z10) {
            E(eVar2.f16567b, eVar2.f16570e, cmbMessage.getImageUrl());
        } else {
            D(eVar2.f16567b, eVar2.f16570e, cmbMessage.getImageUrl());
        }
        view.setEnabled(false);
        view.setOnClickListener((View.OnClickListener) null);
        return view;
    }

    private View N(View view, ViewGroup viewGroup, int i10) {
        return O(view, viewGroup, i10, (String) null);
    }

    private View O(View view, ViewGroup viewGroup, int i10, String str) {
        CmbMessage cmbMessage = this.f16544l.get(i10);
        if (view == null || view.getTag() == null) {
            view = this.f16535b.inflate(R.layout.row_view_message_nudge_dls, viewGroup, false);
            g gVar = new g();
            gVar.f16579a = (CmbTextView) view.findViewById(R.id.textView_message);
            gVar.f16581c = (CmbTextView) view.findViewById(R.id.textView_date_message);
            gVar.f16580b = (CmbTextView) view.findViewById(R.id.textView_date);
            view.setTag(gVar);
        }
        g gVar2 = (g) view.getTag();
        if (str != null) {
            gVar2.f16579a.setText(str);
        } else {
            gVar2.f16579a.setText(cmbMessage.getText());
        }
        gVar2.f16581c.setVisibility(0);
        G(gVar2.f16580b, cmbMessage, i10);
        H(gVar2.f16581c, cmbMessage);
        view.setEnabled(false);
        view.setOnClickListener((View.OnClickListener) null);
        return view;
    }

    private void P(CmbMessage cmbMessage, ImageView imageView) {
        boolean z10;
        if (!this.f16538e) {
            imageView.setVisibility(8);
        } else if (this.f16548q == cmbMessage) {
            boolean z11 = true;
            if (this.f16539f == imageView) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (imageView.getVisibility() == 0) {
                z11 = false;
            }
            this.f16539f = imageView;
            imageView.setVisibility(0);
            C(imageView, this.f16536c.getProfile());
            if (z11 && !z10 && this.f16539f.getTag() == null && this.f16540g != cmbMessage) {
                this.f16539f.setTag(Boolean.TRUE);
                ImageView imageView2 = this.f16539f;
                p(imageView2, new a(imageView2)).start();
            }
        } else {
            if (this.f16539f == imageView) {
                this.f16539f = null;
            }
            if (imageView.getVisibility() == 0 && this.f16540g == cmbMessage) {
                imageView.setTag(Boolean.TRUE);
                o(imageView, new b(imageView)).start();
            } else if (imageView.getTag() == null) {
                imageView.setVisibility(8);
            }
        }
    }

    private View Q(View view, ViewGroup viewGroup, int i10) {
        CmbMessage cmbMessage = this.f16544l.get(i10);
        boolean z10 = false;
        if (view == null || view.getTag() == null) {
            if (view != null) {
                IllegalStateException illegalStateException = new IllegalStateException("convertView was created, but has no tag");
                String simpleName = k.class.getSimpleName();
                fa.a.g(simpleName, "textMessageFromMe, #" + i10, illegalStateException);
            }
            view = this.f16535b.inflate(R.layout.row_view_message_from_me_dls, viewGroup, false);
            d dVar = new d();
            dVar.f16561b = (CmbTextView) view.findViewById(R.id.textView_date);
            dVar.f16562c = (CmbTextView) view.findViewById(R.id.textView_date_message);
            dVar.f16565f = (RelativeLayout) view.findViewById(R.id.relativeLayout_message_container);
            dVar.f16563d = (CmbTextView) view.findViewById(R.id.textView_message);
            dVar.f16560a = (ImageView) view.findViewById(R.id.imageView_avatar);
            dVar.f16564e = (CmbTextView) view.findViewById(R.id.check_read_status);
            dVar.f16563d.getBackground().setColorFilter(androidx.core.content.a.getColor(this.f16537d, R.color.main_color), PorterDuff.Mode.SRC_ATOP);
            view.setTag(dVar);
        }
        d dVar2 = (d) view.getTag();
        H(dVar2.f16562c, cmbMessage);
        G(dVar2.f16561b, cmbMessage, i10);
        MessageStatus status = cmbMessage.getStatus();
        RelativeLayout b10 = dVar2.f16565f;
        MessageStatus messageStatus = MessageStatus.NOT_SENT;
        if (status == messageStatus) {
            z10 = true;
        }
        b10.setEnabled(z10);
        if (status == MessageStatus.SENDING) {
            dVar2.f16562c.setText(R.string.sending);
        } else if (status == messageStatus) {
            dVar2.f16562c.setText(R.string.message_failed);
            dVar2.f16562c.setTextColor(this.f16537d.getResources().getColor(R.color.error_color));
            dVar2.f16565f.setOnClickListener(new b(this, dVar2));
        }
        P(cmbMessage, dVar2.f16560a);
        K(dVar2.f16564e, i10);
        dVar2.f16563d.setText(cmbMessage.getText());
        return view;
    }

    private View R(View view, ViewGroup viewGroup, int i10) {
        CmbMessage cmbMessage = this.f16544l.get(i10);
        if (view == null || view.getTag() == null) {
            view = this.f16535b.inflate(R.layout.row_view_message_from_other_dls, viewGroup, false);
            f fVar = new f();
            fVar.f16578h = (LinearLayout) view.findViewById(R.id.linearLayout_message);
            fVar.f16572b = (CmbTextView) view.findViewById(R.id.textView_date);
            fVar.f16573c = (CmbTextView) view.findViewById(R.id.textView_date_message);
            fVar.f16571a = (ImageView) view.findViewById(R.id.imageView_avatar_other);
            fVar.f16574d = (CmbTextView) view.findViewById(R.id.textView_message);
            fVar.f16575e = view.findViewById(R.id.live_typing_circle_1);
            fVar.f16576f = view.findViewById(R.id.live_typing_circle_2);
            fVar.f16577g = view.findViewById(R.id.live_typing_circle_3);
            view.setTag(fVar);
        }
        f fVar2 = (f) view.getTag();
        C(fVar2.f16571a, this.f16536c.getProfile());
        fVar2.f16571a.setOnClickListener(new c(this));
        fVar2.f16574d.setVisibility(0);
        fVar2.f16575e.setVisibility(8);
        fVar2.f16576f.setVisibility(8);
        fVar2.f16577g.setVisibility(8);
        H(fVar2.f16573c, cmbMessage);
        G(fVar2.f16572b, cmbMessage, i10);
        fVar2.f16574d.setText(cmbMessage.getText());
        fVar2.f16578h.getBackground().setColorFilter(androidx.core.content.a.getColor(this.f16537d, R.color.light_gray), PorterDuff.Mode.SRC_ATOP);
        view.setEnabled(false);
        view.setOnClickListener((View.OnClickListener) null);
        return view;
    }

    private AnimatorSet o(ImageView imageView, Animator.AnimatorListener animatorListener) {
        float[] fArr = f16533w;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(100);
        animatorSet.addListener(animatorListener);
        return animatorSet;
    }

    private AnimatorSet p(ImageView imageView, Animator.AnimatorListener animatorListener) {
        float[] fArr = f16532t;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(100);
        animatorSet.addListener(animatorListener);
        return animatorSet;
    }

    private String q(String str) {
        long timeElapsed = DateUtils.getTimeElapsed(str);
        if (timeElapsed < DateUtils.MILLIS_IN_MINUTE) {
            return this.f16537d.getString(R.string.now);
        }
        if (timeElapsed >= DateUtils.MILLIS_IN_HOUR) {
            return DateUtils.getFormattedLocalDate(str, DateUtils.DATE_WITH_TIME_PATTERN, DateUtils.TIME_PATTERN_NO_SECONDS);
        }
        int i10 = (int) (timeElapsed / DateUtils.MILLIS_IN_MINUTE);
        return this.f16537d.getResources().getQuantityString(R.plurals.num_minutes, i10, new Object[]{Integer.valueOf(i10)});
    }

    private String r(String str) {
        return DateUtils.getFormattedLocalDate(str, DateUtils.DATE_WITH_TIME_PATTERN, DateUtils.DATE_PATTERN_FRIENDLY_SHORT_MONTH);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(String str, View view) {
        this.f16542j.w(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit u(ProgressBar progressBar, ImageView imageView, String str, Bitmap bitmap) {
        progressBar.setVisibility(8);
        imageView.setOnClickListener(new j(this, str));
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit v(ImageView imageView, String str, ProgressBar progressBar) {
        if (!imageView.getTag().equals(str)) {
            return null;
        }
        progressBar.setVisibility(8);
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit w(ImageView imageView, String str, ProgressBar progressBar, Bitmap bitmap) {
        if (!imageView.getTag().equals(str)) {
            return null;
        }
        progressBar.setVisibility(8);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        this.f16545m.A();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(c cVar, View view) {
        cVar.f16559g.setOnClickListener((View.OnClickListener) null);
        cVar.f16559g.setEnabled(false);
        cVar.f16556d.setText(R.string.sending);
        cVar.f16556d.setTextColor(this.f16537d.getResources().getColor(R.color.gray));
        for (CmbMessage next : this.f16544l) {
            if (next.getStatus() == MessageStatus.NOT_SENT) {
                this.f16545m.e0(next);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        this.f16545m.O();
    }

    /* access modifiers changed from: package-private */
    public void F() {
        ArrayList arrayList = new ArrayList();
        for (CmbMessage next : this.f16544l) {
            if (next.getStatus() != MessageStatus.NOT_SENT) {
                arrayList.add(next);
            }
        }
        this.f16544l = arrayList;
        notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public void I(List<CmbMessage> list, CmbMessage cmbMessage) {
        this.f16544l = list;
        this.f16548q = cmbMessage;
    }

    /* access modifiers changed from: package-private */
    public void J(List<Resource> list) {
        this.f16541h = list;
    }

    /* access modifiers changed from: package-private */
    public void S(boolean z10) {
        this.f16538e = z10;
    }

    public int getCount() {
        return this.f16544l.size();
    }

    public Object getItem(int i10) {
        if (i10 >= this.f16544l.size()) {
            return null;
        }
        return this.f16544l.get(i10);
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public int getItemViewType(int i10) {
        MessageType messageType;
        CmbMessage cmbMessage = this.f16544l.get(i10);
        MessageType messageType2 = cmbMessage.getMessageType();
        if (messageType2 != MessageType.UNRECOGNIZED && (messageType2 == (messageType = MessageType.IMAGE) || messageType2 == MessageType.STICKER || messageType2 == MessageType.CHAT || messageType2 == MessageType.NONE)) {
            if (cmbMessage.isFromMe(this.f16546n)) {
                if (messageType2 == messageType) {
                    return 2;
                }
                if (messageType2 == MessageType.STICKER) {
                    return 5;
                }
                return 0;
            } else if (cmbMessage.isFromOther(this.f16547p)) {
                if (messageType2 == messageType) {
                    return 3;
                }
                if (messageType2 == MessageType.STICKER) {
                    return 6;
                }
                return 1;
            }
        }
        return 4;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        CmbMessage cmbMessage = this.f16544l.get(i10);
        MessageType messageType = cmbMessage.getMessageType();
        switch (getItemViewType(i10)) {
            case 0:
                return Q(view, viewGroup, i10);
            case 1:
                return R(view, viewGroup, i10);
            case 2:
                return L(view, viewGroup, i10, false);
            case 3:
                return M(view, viewGroup, i10, false);
            case 4:
                String str = null;
                List<Resource> list = this.f16541h;
                if (list != null) {
                    Iterator<Resource> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Resource next = it.next();
                            if (next.getKey().equals(cmbMessage.getTypeName())) {
                                str = next.getValue();
                            }
                        }
                    }
                }
                if (messageType == MessageType.UNRECOGNIZED) {
                    return O(view, viewGroup, i10, str);
                }
                return N(view, viewGroup, i10);
            case 5:
                return L(view, viewGroup, i10, true);
            case 6:
                return M(view, viewGroup, i10, true);
            default:
                return view;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    /* access modifiers changed from: package-private */
    public void n(CmbMessage cmbMessage) {
        this.f16544l.add(cmbMessage);
        notifyDataSetChanged();
    }
}
