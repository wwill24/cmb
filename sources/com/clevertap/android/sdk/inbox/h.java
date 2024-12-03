package com.clevertap.android.sdk.inbox;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.clevertap.android.sdk.p;
import i4.v;
import java.util.ArrayList;

class h extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    private g f10559d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CTInboxMessage> f10560e;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10561a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.clevertap.android.sdk.inbox.CTInboxMessageType[] r0 = com.clevertap.android.sdk.inbox.CTInboxMessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10561a = r0
                com.clevertap.android.sdk.inbox.CTInboxMessageType r1 = com.clevertap.android.sdk.inbox.CTInboxMessageType.SimpleMessage     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10561a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.clevertap.android.sdk.inbox.CTInboxMessageType r1 = com.clevertap.android.sdk.inbox.CTInboxMessageType.IconMessage     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10561a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.clevertap.android.sdk.inbox.CTInboxMessageType r1 = com.clevertap.android.sdk.inbox.CTInboxMessageType.CarouselMessage     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10561a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.clevertap.android.sdk.inbox.CTInboxMessageType r1 = com.clevertap.android.sdk.inbox.CTInboxMessageType.CarouselImageMessage     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.h.a.<clinit>():void");
        }
    }

    h(ArrayList<CTInboxMessage> arrayList, g gVar) {
        p.o("CTInboxMessageAdapter: messages=" + arrayList);
        this.f10560e = arrayList;
        this.f10559d = gVar;
    }

    /* renamed from: G */
    public e x(@NonNull ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            return new j(LayoutInflater.from(viewGroup.getContext()).inflate(v.inbox_simple_message_layout, viewGroup, false));
        }
        if (i10 == 1) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(v.inbox_icon_message_layout, viewGroup, false));
        }
        if (i10 == 2) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(v.inbox_carousel_text_layout, viewGroup, false));
        }
        if (i10 != 3) {
            return null;
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(v.inbox_carousel_layout, viewGroup, false));
    }

    public int g() {
        return this.f10560e.size();
    }

    public int i(int i10) {
        int i11 = a.f10561a[this.f10560e.get(i10).i().ordinal()];
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 1;
        }
        if (i11 != 3) {
            return i11 != 4 ? -1 : 3;
        }
        return 2;
    }

    public void v(@NonNull RecyclerView.d0 d0Var, int i10) {
        ((e) d0Var).Y(this.f10560e.get(i10), this.f10559d, i10);
    }
}
