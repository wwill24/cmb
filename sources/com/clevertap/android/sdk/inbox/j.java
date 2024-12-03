package com.clevertap.android.sdk.inbox;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import i4.u;

class j extends e {
    private final Button K;
    private final Button L;
    private final Button M;
    private final TextView N;
    private final TextView O;
    private final TextView P;

    j(@NonNull View view) {
        super(view);
        view.setTag(this);
        this.P = (TextView) view.findViewById(u.messageTitle);
        this.N = (TextView) view.findViewById(u.messageText);
        this.O = (TextView) view.findViewById(u.timestamp);
        this.K = (Button) view.findViewById(u.cta_button_1);
        this.L = (Button) view.findViewById(u.cta_button_2);
        this.M = (Button) view.findViewById(u.cta_button_3);
        this.f10533y = (ImageView) view.findViewById(u.media_image);
        this.C = (RelativeLayout) view.findViewById(u.simple_message_relative_layout);
        this.f10532x = (FrameLayout) view.findViewById(u.simple_message_frame_layout);
        this.f10534z = (ImageView) view.findViewById(u.square_media_image);
        this.D = (RelativeLayout) view.findViewById(u.click_relative_layout);
        this.f10530v = (LinearLayout) view.findViewById(u.cta_linear_layout);
        this.f10531w = (LinearLayout) view.findViewById(u.body_linear_layout);
        this.B = (FrameLayout) view.findViewById(u.simple_progress_frame_layout);
        this.A = (RelativeLayout) view.findViewById(u.media_layout);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:45|46|47|48|49) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:52|53|54|55|56) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:99|100|101|102|103) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:61|(1:63)(1:64)|65|66|67|68) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:83|84|85|86|87|114|(0)(0)|121|(0)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:90|91|92|93|94|114|(0)(0)|121|(0)(0)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:102:0x05fe */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0336 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x03a5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x042b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:86:0x0516 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0585 */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x069b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x06aa  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x06d7  */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x04c7 A[Catch:{ NoClassDefFoundError -> 0x068b }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x03a5=Splitter:B:55:0x03a5, B:93:0x0585=Splitter:B:93:0x0585, B:48:0x0336=Splitter:B:48:0x0336, B:86:0x0516=Splitter:B:86:0x0516, B:67:0x042b=Splitter:B:67:0x042b, B:102:0x05fe=Splitter:B:102:0x05fe} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Y(com.clevertap.android.sdk.inbox.CTInboxMessage r20, com.clevertap.android.sdk.inbox.g r21, int r22) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r2 = "l"
            super.Y(r20, r21, r22)
            com.clevertap.android.sdk.inbox.g r10 = r19.b0()
            java.util.ArrayList r0 = r20.e()
            r11 = 0
            java.lang.Object r0 = r0.get(r11)
            r12 = r0
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r12 = (com.clevertap.android.sdk.inbox.CTInboxMessageContent) r12
            android.widget.TextView r0 = r1.P
            java.lang.String r3 = r12.q()
            r0.setText(r3)
            android.widget.TextView r0 = r1.P
            java.lang.String r3 = r12.r()
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setTextColor(r3)
            android.widget.TextView r0 = r1.N
            java.lang.String r3 = r12.n()
            r0.setText(r3)
            android.widget.TextView r0 = r1.N
            java.lang.String r3 = r12.o()
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setTextColor(r3)
            android.widget.LinearLayout r0 = r1.f10531w
            java.lang.String r3 = r20.a()
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setBackgroundColor(r3)
            long r3 = r20.d()
            java.lang.String r0 = r1.X(r3)
            android.widget.TextView r3 = r1.O
            r3.setText(r0)
            android.widget.TextView r0 = r1.O
            java.lang.String r3 = r12.r()
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setTextColor(r3)
            boolean r0 = r20.k()
            r13 = 8
            if (r0 == 0) goto L_0x0078
            android.widget.ImageView r0 = r1.J
            r0.setVisibility(r13)
            goto L_0x007d
        L_0x0078:
            android.widget.ImageView r0 = r1.J
            r0.setVisibility(r11)
        L_0x007d:
            android.widget.FrameLayout r0 = r1.f10532x
            r0.setVisibility(r13)
            org.json.a r0 = r12.k()
            r14 = 1
            r15 = 2
            if (r0 == 0) goto L_0x027f
            android.widget.LinearLayout r3 = r1.f10530v
            r3.setVisibility(r11)
            int r3 = r0.o()
            if (r3 == r14) goto L_0x0212
            if (r3 == r15) goto L_0x017b
            r4 = 3
            if (r3 == r4) goto L_0x009c
            goto L_0x027c
        L_0x009c:
            org.json.b r7 = r0.j(r11)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.K     // Catch:{ JSONException -> 0x0263 }
            r3.setVisibility(r11)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.K     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.i(r7)     // Catch:{ JSONException -> 0x0263 }
            r3.setText(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.K     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.f(r7)     // Catch:{ JSONException -> 0x0263 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x0263 }
            r3.setTextColor(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.K     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.e(r7)     // Catch:{ JSONException -> 0x0263 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x0263 }
            r3.setBackgroundColor(r4)     // Catch:{ JSONException -> 0x0263 }
            org.json.b r9 = r0.j(r14)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0263 }
            r3.setVisibility(r11)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.i(r9)     // Catch:{ JSONException -> 0x0263 }
            r3.setText(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.f(r9)     // Catch:{ JSONException -> 0x0263 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x0263 }
            r3.setTextColor(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.e(r9)     // Catch:{ JSONException -> 0x0263 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x0263 }
            r3.setBackgroundColor(r4)     // Catch:{ JSONException -> 0x0263 }
            org.json.b r0 = r0.j(r15)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.M     // Catch:{ JSONException -> 0x0263 }
            r3.setVisibility(r11)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.M     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.i(r0)     // Catch:{ JSONException -> 0x0263 }
            r3.setText(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.M     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.f(r0)     // Catch:{ JSONException -> 0x0263 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x0263 }
            r3.setTextColor(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.M     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.e(r0)     // Catch:{ JSONException -> 0x0263 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x0263 }
            r3.setBackgroundColor(r4)     // Catch:{ JSONException -> 0x0263 }
            if (r10 == 0) goto L_0x027c
            android.widget.Button r8 = r1.K     // Catch:{ JSONException -> 0x0263 }
            com.clevertap.android.sdk.inbox.f r6 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0263 }
            java.lang.CharSequence r3 = r8.getText()     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r16 = r3.toString()     // Catch:{ JSONException -> 0x0263 }
            r17 = 0
            r3 = r6
            r4 = r22
            r5 = r20
            r15 = r6
            r6 = r16
            r13 = r8
            r8 = r10
            r18 = r9
            r9 = r17
            r3.<init>((int) r4, (com.clevertap.android.sdk.inbox.CTInboxMessage) r5, (java.lang.String) r6, (org.json.b) r7, (com.clevertap.android.sdk.inbox.g) r8, (boolean) r9)     // Catch:{ JSONException -> 0x0263 }
            r13.setOnClickListener(r15)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r13 = r1.L     // Catch:{ JSONException -> 0x0263 }
            com.clevertap.android.sdk.inbox.f r15 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0263 }
            java.lang.CharSequence r3 = r13.getText()     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r6 = r3.toString()     // Catch:{ JSONException -> 0x0263 }
            r9 = 0
            r3 = r15
            r4 = r22
            r5 = r20
            r7 = r18
            r8 = r10
            r3.<init>((int) r4, (com.clevertap.android.sdk.inbox.CTInboxMessage) r5, (java.lang.String) r6, (org.json.b) r7, (com.clevertap.android.sdk.inbox.g) r8, (boolean) r9)     // Catch:{ JSONException -> 0x0263 }
            r13.setOnClickListener(r15)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r13 = r1.M     // Catch:{ JSONException -> 0x0263 }
            com.clevertap.android.sdk.inbox.f r15 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0263 }
            java.lang.CharSequence r3 = r13.getText()     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r6 = r3.toString()     // Catch:{ JSONException -> 0x0263 }
            r9 = 0
            r3 = r15
            r4 = r22
            r5 = r20
            r7 = r0
            r8 = r10
            r3.<init>((int) r4, (com.clevertap.android.sdk.inbox.CTInboxMessage) r5, (java.lang.String) r6, (org.json.b) r7, (com.clevertap.android.sdk.inbox.g) r8, (boolean) r9)     // Catch:{ JSONException -> 0x0263 }
            r13.setOnClickListener(r15)     // Catch:{ JSONException -> 0x0263 }
            goto L_0x027c
        L_0x017b:
            org.json.b r7 = r0.j(r11)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.K     // Catch:{ JSONException -> 0x0263 }
            r3.setVisibility(r11)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.K     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.i(r7)     // Catch:{ JSONException -> 0x0263 }
            r3.setText(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.K     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.f(r7)     // Catch:{ JSONException -> 0x0263 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x0263 }
            r3.setTextColor(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.K     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.e(r7)     // Catch:{ JSONException -> 0x0263 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x0263 }
            r3.setBackgroundColor(r4)     // Catch:{ JSONException -> 0x0263 }
            org.json.b r0 = r0.j(r14)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0263 }
            r3.setVisibility(r11)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.i(r0)     // Catch:{ JSONException -> 0x0263 }
            r3.setText(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.f(r0)     // Catch:{ JSONException -> 0x0263 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x0263 }
            r3.setTextColor(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r4 = r12.e(r0)     // Catch:{ JSONException -> 0x0263 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x0263 }
            r3.setBackgroundColor(r4)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.K     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r4 = r1.L     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r5 = r1.M     // Catch:{ JSONException -> 0x0263 }
            r1.c0(r3, r4, r5)     // Catch:{ JSONException -> 0x0263 }
            if (r10 == 0) goto L_0x027c
            android.widget.Button r13 = r1.K     // Catch:{ JSONException -> 0x0263 }
            com.clevertap.android.sdk.inbox.f r15 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0263 }
            java.lang.CharSequence r3 = r13.getText()     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r6 = r3.toString()     // Catch:{ JSONException -> 0x0263 }
            r9 = 0
            r3 = r15
            r4 = r22
            r5 = r20
            r8 = r10
            r3.<init>((int) r4, (com.clevertap.android.sdk.inbox.CTInboxMessage) r5, (java.lang.String) r6, (org.json.b) r7, (com.clevertap.android.sdk.inbox.g) r8, (boolean) r9)     // Catch:{ JSONException -> 0x0263 }
            r13.setOnClickListener(r15)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r13 = r1.L     // Catch:{ JSONException -> 0x0263 }
            com.clevertap.android.sdk.inbox.f r15 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0263 }
            java.lang.CharSequence r3 = r13.getText()     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r6 = r3.toString()     // Catch:{ JSONException -> 0x0263 }
            r9 = 0
            r3 = r15
            r4 = r22
            r5 = r20
            r7 = r0
            r8 = r10
            r3.<init>((int) r4, (com.clevertap.android.sdk.inbox.CTInboxMessage) r5, (java.lang.String) r6, (org.json.b) r7, (com.clevertap.android.sdk.inbox.g) r8, (boolean) r9)     // Catch:{ JSONException -> 0x0263 }
            r13.setOnClickListener(r15)     // Catch:{ JSONException -> 0x0263 }
            goto L_0x027c
        L_0x0212:
            org.json.b r7 = r0.j(r11)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r0 = r1.K     // Catch:{ JSONException -> 0x0263 }
            r0.setVisibility(r11)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r0 = r1.K     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r3 = r12.i(r7)     // Catch:{ JSONException -> 0x0263 }
            r0.setText(r3)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r0 = r1.K     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r3 = r12.f(r7)     // Catch:{ JSONException -> 0x0263 }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x0263 }
            r0.setTextColor(r3)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r0 = r1.K     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r3 = r12.e(r7)     // Catch:{ JSONException -> 0x0263 }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x0263 }
            r0.setBackgroundColor(r3)     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r0 = r1.K     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0263 }
            android.widget.Button r4 = r1.M     // Catch:{ JSONException -> 0x0263 }
            r1.d0(r0, r3, r4)     // Catch:{ JSONException -> 0x0263 }
            if (r10 == 0) goto L_0x027c
            android.widget.Button r0 = r1.K     // Catch:{ JSONException -> 0x0263 }
            com.clevertap.android.sdk.inbox.f r13 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0263 }
            java.lang.CharSequence r3 = r0.getText()     // Catch:{ JSONException -> 0x0263 }
            java.lang.String r6 = r3.toString()     // Catch:{ JSONException -> 0x0263 }
            r9 = 0
            r3 = r13
            r4 = r22
            r5 = r20
            r8 = r10
            r3.<init>((int) r4, (com.clevertap.android.sdk.inbox.CTInboxMessage) r5, (java.lang.String) r6, (org.json.b) r7, (com.clevertap.android.sdk.inbox.g) r8, (boolean) r9)     // Catch:{ JSONException -> 0x0263 }
            r0.setOnClickListener(r13)     // Catch:{ JSONException -> 0x0263 }
            goto L_0x027c
        L_0x0263:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error parsing CTA JSON - "
            r3.append(r4)
            java.lang.String r0 = r0.getLocalizedMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.clevertap.android.sdk.p.a(r0)
        L_0x027c:
            r3 = 8
            goto L_0x0286
        L_0x027f:
            android.widget.LinearLayout r0 = r1.f10530v
            r3 = 8
            r0.setVisibility(r3)
        L_0x0286:
            android.widget.ImageView r0 = r1.f10533y
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r1.f10533y
            java.lang.String r4 = r20.a()
            int r4 = android.graphics.Color.parseColor(r4)
            r0.setBackgroundColor(r4)
            android.widget.ImageView r0 = r1.f10534z
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r1.f10534z
            java.lang.String r4 = r20.a()
            int r4 = android.graphics.Color.parseColor(r4)
            r0.setBackgroundColor(r4)
            android.widget.RelativeLayout r0 = r1.A
            r0.setVisibility(r3)
            android.widget.FrameLayout r0 = r1.B
            r0.setVisibility(r3)
            java.lang.String r0 = r20.g()     // Catch:{ NoClassDefFoundError -> 0x068b }
            int r3 = r0.hashCode()     // Catch:{ NoClassDefFoundError -> 0x068b }
            r4 = 108(0x6c, float:1.51E-43)
            r5 = -1
            if (r3 == r4) goto L_0x02d0
            r4 = 112(0x70, float:1.57E-43)
            if (r3 == r4) goto L_0x02c6
            goto L_0x02d8
        L_0x02c6:
            java.lang.String r3 = "p"
            boolean r0 = r0.equals(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == 0) goto L_0x02d8
            r0 = r14
            goto L_0x02d9
        L_0x02d0:
            boolean r0 = r0.equals(r2)     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == 0) goto L_0x02d8
            r0 = r11
            goto L_0x02d9
        L_0x02d8:
            r0 = r5
        L_0x02d9:
            java.lang.String r3 = "ct_audio"
            java.lang.String r4 = "ct_video_1"
            java.lang.String r6 = "CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info"
            java.lang.String r7 = "ct_image"
            if (r0 == 0) goto L_0x04c7
            if (r0 == r14) goto L_0x02e7
            goto L_0x0690
        L_0x02e7:
            boolean r0 = r12.w()     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == 0) goto L_0x0352
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x0336 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x0336 }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x0336 }
            java.lang.String r3 = r12.m()     // Catch:{ NoSuchMethodError -> 0x0336 }
            com.bumptech.glide.g r0 = r0.u(r3)     // Catch:{ NoSuchMethodError -> 0x0336 }
            b4.c r3 = new b4.c     // Catch:{ NoSuchMethodError -> 0x0336 }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x0336 }
            android.content.Context r4 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x0336 }
            int r4 = i4.x.r(r4, r7)     // Catch:{ NoSuchMethodError -> 0x0336 }
            com.bumptech.glide.request.a r3 = r3.X(r4)     // Catch:{ NoSuchMethodError -> 0x0336 }
            b4.c r3 = (b4.c) r3     // Catch:{ NoSuchMethodError -> 0x0336 }
            android.content.Context r4 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x0336 }
            int r4 = i4.x.r(r4, r7)     // Catch:{ NoSuchMethodError -> 0x0336 }
            com.bumptech.glide.request.a r3 = r3.i(r4)     // Catch:{ NoSuchMethodError -> 0x0336 }
            com.bumptech.glide.g r0 = r0.a(r3)     // Catch:{ NoSuchMethodError -> 0x0336 }
            android.widget.ImageView r3 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x0336 }
            r0.x0(r3)     // Catch:{ NoSuchMethodError -> 0x0336 }
            goto L_0x0690
        L_0x0336:
            com.clevertap.android.sdk.p.a(r6)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            java.lang.String r3 = r12.m()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r0.u(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r3 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0690
        L_0x0352:
            boolean r0 = r12.u()     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == 0) goto L_0x03c5
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x03a5 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x03a5 }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x03a5 }
            com.bumptech.glide.g r0 = r0.o()     // Catch:{ NoSuchMethodError -> 0x03a5 }
            java.lang.String r3 = r12.m()     // Catch:{ NoSuchMethodError -> 0x03a5 }
            com.bumptech.glide.g r0 = r0.C0(r3)     // Catch:{ NoSuchMethodError -> 0x03a5 }
            b4.c r3 = new b4.c     // Catch:{ NoSuchMethodError -> 0x03a5 }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x03a5 }
            android.content.Context r4 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x03a5 }
            int r4 = i4.x.r(r4, r7)     // Catch:{ NoSuchMethodError -> 0x03a5 }
            com.bumptech.glide.request.a r3 = r3.X(r4)     // Catch:{ NoSuchMethodError -> 0x03a5 }
            b4.c r3 = (b4.c) r3     // Catch:{ NoSuchMethodError -> 0x03a5 }
            android.content.Context r4 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x03a5 }
            int r4 = i4.x.r(r4, r7)     // Catch:{ NoSuchMethodError -> 0x03a5 }
            com.bumptech.glide.request.a r3 = r3.i(r4)     // Catch:{ NoSuchMethodError -> 0x03a5 }
            com.bumptech.glide.g r0 = r0.a(r3)     // Catch:{ NoSuchMethodError -> 0x03a5 }
            android.widget.ImageView r3 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x03a5 }
            r0.x0(r3)     // Catch:{ NoSuchMethodError -> 0x03a5 }
            goto L_0x0690
        L_0x03a5:
            com.clevertap.android.sdk.p.a(r6)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r0.o()     // Catch:{ NoClassDefFoundError -> 0x068b }
            java.lang.String r3 = r12.m()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r0.C0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r3 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0690
        L_0x03c5:
            boolean r0 = r12.x()     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == 0) goto L_0x0486
            java.lang.String r0 = r12.p()     // Catch:{ NoClassDefFoundError -> 0x068b }
            boolean r0 = r0.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 != 0) goto L_0x0447
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            int r0 = com.clevertap.android.sdk.inbox.CTInboxActivity.f10465h     // Catch:{ NoClassDefFoundError -> 0x068b }
            r3 = 2
            if (r0 != r3) goto L_0x03ec
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x03f3
        L_0x03ec:
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
        L_0x03f3:
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x042b }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x042b }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x042b }
            java.lang.String r3 = r12.p()     // Catch:{ NoSuchMethodError -> 0x042b }
            com.bumptech.glide.g r0 = r0.u(r3)     // Catch:{ NoSuchMethodError -> 0x042b }
            b4.c r3 = new b4.c     // Catch:{ NoSuchMethodError -> 0x042b }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x042b }
            android.content.Context r5 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x042b }
            int r5 = i4.x.r(r5, r4)     // Catch:{ NoSuchMethodError -> 0x042b }
            com.bumptech.glide.request.a r3 = r3.X(r5)     // Catch:{ NoSuchMethodError -> 0x042b }
            b4.c r3 = (b4.c) r3     // Catch:{ NoSuchMethodError -> 0x042b }
            android.content.Context r5 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x042b }
            int r4 = i4.x.r(r5, r4)     // Catch:{ NoSuchMethodError -> 0x042b }
            com.bumptech.glide.request.a r3 = r3.i(r4)     // Catch:{ NoSuchMethodError -> 0x042b }
            com.bumptech.glide.g r0 = r0.a(r3)     // Catch:{ NoSuchMethodError -> 0x042b }
            android.widget.ImageView r3 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x042b }
            r0.x0(r3)     // Catch:{ NoSuchMethodError -> 0x042b }
            goto L_0x0690
        L_0x042b:
            com.clevertap.android.sdk.p.a(r6)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            java.lang.String r3 = r12.p()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r0.u(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r3 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0690
        L_0x0447:
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            int r0 = com.clevertap.android.sdk.inbox.CTInboxActivity.f10465h     // Catch:{ NoClassDefFoundError -> 0x068b }
            r3 = 2
            if (r0 != r3) goto L_0x045e
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0465
        L_0x045e:
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
        L_0x0465:
            android.content.Context r0 = r1.f10529u     // Catch:{ NoClassDefFoundError -> 0x068b }
            int r0 = i4.x.r(r0, r4)     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == r5) goto L_0x0690
            android.widget.ImageView r3 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.h r3 = com.bumptech.glide.c.t(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r3.t(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r3 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0690
        L_0x0486:
            boolean r0 = r12.t()     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == 0) goto L_0x0690
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r4)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            int r4 = r19.Z()     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setBackgroundColor(r4)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r0 = r1.f10529u     // Catch:{ NoClassDefFoundError -> 0x068b }
            int r0 = i4.x.r(r0, r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == r5) goto L_0x0690
            android.widget.ImageView r3 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.h r3 = com.bumptech.glide.c.t(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r3.t(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r3 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0690
        L_0x04c7:
            boolean r0 = r12.w()     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == 0) goto L_0x0532
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x0516 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x0516 }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x0516 }
            java.lang.String r3 = r12.m()     // Catch:{ NoSuchMethodError -> 0x0516 }
            com.bumptech.glide.g r0 = r0.u(r3)     // Catch:{ NoSuchMethodError -> 0x0516 }
            b4.c r3 = new b4.c     // Catch:{ NoSuchMethodError -> 0x0516 }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x0516 }
            android.content.Context r4 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x0516 }
            int r4 = i4.x.r(r4, r7)     // Catch:{ NoSuchMethodError -> 0x0516 }
            com.bumptech.glide.request.a r3 = r3.X(r4)     // Catch:{ NoSuchMethodError -> 0x0516 }
            b4.c r3 = (b4.c) r3     // Catch:{ NoSuchMethodError -> 0x0516 }
            android.content.Context r4 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x0516 }
            int r4 = i4.x.r(r4, r7)     // Catch:{ NoSuchMethodError -> 0x0516 }
            com.bumptech.glide.request.a r3 = r3.i(r4)     // Catch:{ NoSuchMethodError -> 0x0516 }
            com.bumptech.glide.g r0 = r0.a(r3)     // Catch:{ NoSuchMethodError -> 0x0516 }
            android.widget.ImageView r3 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x0516 }
            r0.x0(r3)     // Catch:{ NoSuchMethodError -> 0x0516 }
            goto L_0x0690
        L_0x0516:
            com.clevertap.android.sdk.p.a(r6)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            java.lang.String r3 = r12.m()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r0.u(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r3 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0690
        L_0x0532:
            boolean r0 = r12.u()     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == 0) goto L_0x05a5
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x0585 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x0585 }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x0585 }
            com.bumptech.glide.g r0 = r0.o()     // Catch:{ NoSuchMethodError -> 0x0585 }
            java.lang.String r3 = r12.m()     // Catch:{ NoSuchMethodError -> 0x0585 }
            com.bumptech.glide.g r0 = r0.C0(r3)     // Catch:{ NoSuchMethodError -> 0x0585 }
            b4.c r3 = new b4.c     // Catch:{ NoSuchMethodError -> 0x0585 }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x0585 }
            android.content.Context r4 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x0585 }
            int r4 = i4.x.r(r4, r7)     // Catch:{ NoSuchMethodError -> 0x0585 }
            com.bumptech.glide.request.a r3 = r3.X(r4)     // Catch:{ NoSuchMethodError -> 0x0585 }
            b4.c r3 = (b4.c) r3     // Catch:{ NoSuchMethodError -> 0x0585 }
            android.content.Context r4 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x0585 }
            int r4 = i4.x.r(r4, r7)     // Catch:{ NoSuchMethodError -> 0x0585 }
            com.bumptech.glide.request.a r3 = r3.i(r4)     // Catch:{ NoSuchMethodError -> 0x0585 }
            com.bumptech.glide.g r0 = r0.a(r3)     // Catch:{ NoSuchMethodError -> 0x0585 }
            android.widget.ImageView r3 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x0585 }
            r0.x0(r3)     // Catch:{ NoSuchMethodError -> 0x0585 }
            goto L_0x0690
        L_0x0585:
            com.clevertap.android.sdk.p.a(r6)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r0.o()     // Catch:{ NoClassDefFoundError -> 0x068b }
            java.lang.String r3 = r12.m()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r0.C0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r3 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0690
        L_0x05a5:
            boolean r0 = r12.x()     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == 0) goto L_0x064b
            java.lang.String r0 = r12.p()     // Catch:{ NoClassDefFoundError -> 0x068b }
            boolean r0 = r0.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 != 0) goto L_0x061a
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x05fe }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x05fe }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x05fe }
            java.lang.String r3 = r12.p()     // Catch:{ NoSuchMethodError -> 0x05fe }
            com.bumptech.glide.g r0 = r0.u(r3)     // Catch:{ NoSuchMethodError -> 0x05fe }
            b4.c r3 = new b4.c     // Catch:{ NoSuchMethodError -> 0x05fe }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x05fe }
            android.content.Context r5 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x05fe }
            int r5 = i4.x.r(r5, r4)     // Catch:{ NoSuchMethodError -> 0x05fe }
            com.bumptech.glide.request.a r3 = r3.X(r5)     // Catch:{ NoSuchMethodError -> 0x05fe }
            b4.c r3 = (b4.c) r3     // Catch:{ NoSuchMethodError -> 0x05fe }
            android.content.Context r5 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x05fe }
            int r4 = i4.x.r(r5, r4)     // Catch:{ NoSuchMethodError -> 0x05fe }
            com.bumptech.glide.request.a r3 = r3.i(r4)     // Catch:{ NoSuchMethodError -> 0x05fe }
            com.bumptech.glide.g r0 = r0.a(r3)     // Catch:{ NoSuchMethodError -> 0x05fe }
            android.widget.ImageView r3 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x05fe }
            r0.x0(r3)     // Catch:{ NoSuchMethodError -> 0x05fe }
            goto L_0x0690
        L_0x05fe:
            com.clevertap.android.sdk.p.a(r6)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            java.lang.String r3 = r12.p()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r0.u(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r3 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0690
        L_0x061a:
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r0 = r1.f10529u     // Catch:{ NoClassDefFoundError -> 0x068b }
            int r0 = i4.x.r(r0, r4)     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == r5) goto L_0x0690
            android.widget.ImageView r3 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.h r3 = com.bumptech.glide.c.t(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r3.t(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r3 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0690
        L_0x064b:
            boolean r0 = r12.t()     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == 0) goto L_0x0690
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setVisibility(r11)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setScaleType(r4)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            int r4 = r19.Z()     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.setBackgroundColor(r4)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r0 = r1.f10529u     // Catch:{ NoClassDefFoundError -> 0x068b }
            int r0 = i4.x.r(r0, r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            if (r0 == r5) goto L_0x0690
            android.widget.ImageView r3 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.h r3 = com.bumptech.glide.c.t(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            com.bumptech.glide.g r0 = r3.t(r0)     // Catch:{ NoClassDefFoundError -> 0x068b }
            android.widget.ImageView r3 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x068b }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x068b }
            goto L_0x0690
        L_0x068b:
            java.lang.String r0 = "CleverTap SDK requires Glide dependency. Please refer CleverTap Documentation for more info"
            com.clevertap.android.sdk.p.a(r0)
        L_0x0690:
            android.content.Context r0 = r1.f10529u
            android.content.res.Resources r0 = r0.getResources()
            int r3 = com.clevertap.android.sdk.inbox.CTInboxActivity.f10465h
            r4 = 2
            if (r3 != r4) goto L_0x06aa
            android.util.DisplayMetrics r2 = r0.getDisplayMetrics()
            int r2 = r2.heightPixels
            int r2 = r2 / r4
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            int r0 = r0 / r4
            goto L_0x06c4
        L_0x06aa:
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            java.lang.String r3 = r20.g()
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x06c3
            float r2 = (float) r0
            r3 = 1058013184(0x3f100000, float:0.5625)
            float r2 = r2 * r3
            int r2 = java.lang.Math.round(r2)
            goto L_0x06c4
        L_0x06c3:
            r2 = r0
        L_0x06c4:
            android.widget.FrameLayout r3 = r1.B
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r4.<init>(r0, r2)
            r3.setLayoutParams(r4)
            r2 = r20
            r4 = r22
            r1.f0(r2, r4)
            if (r10 == 0) goto L_0x06ea
            android.widget.RelativeLayout r0 = r1.D
            com.clevertap.android.sdk.inbox.f r11 = new com.clevertap.android.sdk.inbox.f
            r6 = 0
            r7 = 0
            r9 = 1
            r3 = r11
            r4 = r22
            r5 = r20
            r8 = r10
            r3.<init>((int) r4, (com.clevertap.android.sdk.inbox.CTInboxMessage) r5, (java.lang.String) r6, (org.json.b) r7, (com.clevertap.android.sdk.inbox.g) r8, (boolean) r9)
            r0.setOnClickListener(r11)
        L_0x06ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.j.Y(com.clevertap.android.sdk.inbox.CTInboxMessage, com.clevertap.android.sdk.inbox.g, int):void");
    }
}
