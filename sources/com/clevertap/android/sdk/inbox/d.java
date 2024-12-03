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

class d extends e {
    private final RelativeLayout K;
    private final Button L;
    private final Button M;
    private final Button N;
    private final LinearLayout O;
    private final ImageView P;
    private final TextView Q;
    private final TextView R;
    private final TextView S;

    d(@NonNull View view) {
        super(view);
        view.setTag(this);
        this.Q = (TextView) view.findViewById(u.messageTitle);
        this.R = (TextView) view.findViewById(u.messageText);
        this.f10533y = (ImageView) view.findViewById(u.media_image);
        this.P = (ImageView) view.findViewById(u.image_icon);
        this.S = (TextView) view.findViewById(u.timestamp);
        this.L = (Button) view.findViewById(u.cta_button_1);
        this.M = (Button) view.findViewById(u.cta_button_2);
        this.N = (Button) view.findViewById(u.cta_button_3);
        this.f10532x = (FrameLayout) view.findViewById(u.icon_message_frame_layout);
        this.f10534z = (ImageView) view.findViewById(u.square_media_image);
        this.K = (RelativeLayout) view.findViewById(u.click_relative_layout);
        this.O = (LinearLayout) view.findViewById(u.cta_linear_layout);
        this.B = (FrameLayout) view.findViewById(u.icon_progress_frame_layout);
        this.A = (RelativeLayout) view.findViewById(u.media_layout);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:100|101|102|103|104|126|(0)(0)|133|134|135|(0)(0)|(0)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:93|94|95|96|97|126|(0)(0)|133|134|135|(0)(0)|(0)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:109|110|111|112|113) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:137|138|139|140|141) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:53|54|55|56|57) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:60|61|62|63|64) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:69|70|(2:72|73)(1:74)|75|76|77|78) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x05b5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:112:0x062f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:140:0x074d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0356 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x03c5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x044f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:96:0x0545 */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x06cc  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x06db  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0710 A[Catch:{ NoClassDefFoundError -> 0x076e }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0768 A[Catch:{ NoClassDefFoundError -> 0x076e }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0773  */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x02e3 A[Catch:{ NoClassDefFoundError -> 0x06be }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x02f2 A[Catch:{ NoClassDefFoundError -> 0x06be }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x04f4 A[Catch:{ NoClassDefFoundError -> 0x06bf }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:63:0x03c5=Splitter:B:63:0x03c5, B:56:0x0356=Splitter:B:56:0x0356} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:96:0x0545=Splitter:B:96:0x0545, B:103:0x05b5=Splitter:B:103:0x05b5, B:77:0x044f=Splitter:B:77:0x044f, B:112:0x062f=Splitter:B:112:0x062f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Y(com.clevertap.android.sdk.inbox.CTInboxMessage r21, com.clevertap.android.sdk.inbox.g r22, int r23) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r2 = "l"
            java.lang.String r3 = "CleverTap SDK requires Glide dependency. Please refer CleverTap Documentation for more info"
            java.lang.String r4 = "CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info"
            java.lang.String r5 = "ct_image"
            super.Y(r21, r22, r23)
            com.clevertap.android.sdk.inbox.g r13 = r20.b0()
            java.util.ArrayList r0 = r21.e()
            r14 = 0
            java.lang.Object r0 = r0.get(r14)
            r15 = r0
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r15 = (com.clevertap.android.sdk.inbox.CTInboxMessageContent) r15
            android.widget.TextView r0 = r1.Q
            java.lang.String r6 = r15.q()
            r0.setText(r6)
            android.widget.TextView r0 = r1.Q
            java.lang.String r6 = r15.r()
            int r6 = android.graphics.Color.parseColor(r6)
            r0.setTextColor(r6)
            android.widget.TextView r0 = r1.R
            java.lang.String r6 = r15.n()
            r0.setText(r6)
            android.widget.TextView r0 = r1.R
            java.lang.String r6 = r15.o()
            int r6 = android.graphics.Color.parseColor(r6)
            r0.setTextColor(r6)
            android.widget.RelativeLayout r0 = r1.K
            java.lang.String r6 = r21.a()
            int r6 = android.graphics.Color.parseColor(r6)
            r0.setBackgroundColor(r6)
            long r6 = r21.d()
            java.lang.String r0 = r1.X(r6)
            android.widget.TextView r6 = r1.S
            r6.setText(r0)
            android.widget.TextView r0 = r1.S
            java.lang.String r6 = r15.r()
            int r6 = android.graphics.Color.parseColor(r6)
            r0.setTextColor(r6)
            boolean r0 = r21.k()
            r12 = 8
            if (r0 == 0) goto L_0x007e
            android.widget.ImageView r0 = r1.J
            r0.setVisibility(r12)
            goto L_0x0083
        L_0x007e:
            android.widget.ImageView r0 = r1.J
            r0.setVisibility(r14)
        L_0x0083:
            android.widget.FrameLayout r0 = r1.f10532x
            r0.setVisibility(r12)
            org.json.a r0 = r15.k()
            r11 = 1
            r10 = 2
            if (r0 == 0) goto L_0x029f
            android.widget.LinearLayout r6 = r1.O
            r6.setVisibility(r14)
            int r6 = r0.o()
            if (r6 == r11) goto L_0x022f
            if (r6 == r10) goto L_0x0193
            r7 = 3
            if (r6 == r7) goto L_0x00a4
        L_0x00a0:
            r16 = r3
            goto L_0x029c
        L_0x00a4:
            org.json.b r9 = r0.j(r14)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.L     // Catch:{ JSONException -> 0x018e }
            r6.setVisibility(r14)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.L     // Catch:{ JSONException -> 0x018e }
            java.lang.String r7 = r15.i(r9)     // Catch:{ JSONException -> 0x018e }
            r6.setText(r7)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.L     // Catch:{ JSONException -> 0x018e }
            java.lang.String r7 = r15.f(r9)     // Catch:{ JSONException -> 0x018e }
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ JSONException -> 0x018e }
            r6.setTextColor(r7)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.L     // Catch:{ JSONException -> 0x018e }
            java.lang.String r7 = r15.e(r9)     // Catch:{ JSONException -> 0x018e }
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ JSONException -> 0x018e }
            r6.setBackgroundColor(r7)     // Catch:{ JSONException -> 0x018e }
            org.json.b r8 = r0.j(r11)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.M     // Catch:{ JSONException -> 0x018e }
            r6.setVisibility(r14)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.M     // Catch:{ JSONException -> 0x018e }
            java.lang.String r7 = r15.i(r8)     // Catch:{ JSONException -> 0x018e }
            r6.setText(r7)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.M     // Catch:{ JSONException -> 0x018e }
            java.lang.String r7 = r15.f(r8)     // Catch:{ JSONException -> 0x018e }
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ JSONException -> 0x018e }
            r6.setTextColor(r7)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.M     // Catch:{ JSONException -> 0x018e }
            java.lang.String r7 = r15.e(r8)     // Catch:{ JSONException -> 0x018e }
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ JSONException -> 0x018e }
            r6.setBackgroundColor(r7)     // Catch:{ JSONException -> 0x018e }
            org.json.b r0 = r0.j(r10)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.N     // Catch:{ JSONException -> 0x018e }
            r6.setVisibility(r14)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.N     // Catch:{ JSONException -> 0x018e }
            java.lang.String r7 = r15.i(r0)     // Catch:{ JSONException -> 0x018e }
            r6.setText(r7)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.N     // Catch:{ JSONException -> 0x018e }
            java.lang.String r7 = r15.f(r0)     // Catch:{ JSONException -> 0x018e }
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ JSONException -> 0x018e }
            r6.setTextColor(r7)     // Catch:{ JSONException -> 0x018e }
            android.widget.Button r6 = r1.N     // Catch:{ JSONException -> 0x018e }
            java.lang.String r7 = r15.e(r0)     // Catch:{ JSONException -> 0x018e }
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ JSONException -> 0x018e }
            r6.setBackgroundColor(r7)     // Catch:{ JSONException -> 0x018e }
            if (r13 == 0) goto L_0x00a0
            android.widget.Button r7 = r1.L     // Catch:{ JSONException -> 0x018e }
            com.clevertap.android.sdk.inbox.f r6 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x018e }
            java.lang.CharSequence r16 = r7.getText()     // Catch:{ JSONException -> 0x018e }
            java.lang.String r16 = r16.toString()     // Catch:{ JSONException -> 0x018e }
            r17 = 0
            r22 = r6
            r14 = r7
            r7 = r23
            r18 = r8
            r8 = r21
            r19 = r9
            r9 = r16
            r10 = r19
            r16 = r3
            r3 = r11
            r11 = r13
            r12 = r17
            r6.<init>((int) r7, (com.clevertap.android.sdk.inbox.CTInboxMessage) r8, (java.lang.String) r9, (org.json.b) r10, (com.clevertap.android.sdk.inbox.g) r11, (boolean) r12)     // Catch:{ JSONException -> 0x0283 }
            r14.setOnClickListener(r6)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r14 = r1.M     // Catch:{ JSONException -> 0x0283 }
            com.clevertap.android.sdk.inbox.f r12 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0283 }
            java.lang.CharSequence r6 = r14.getText()     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r9 = r6.toString()     // Catch:{ JSONException -> 0x0283 }
            r17 = 0
            r6 = r12
            r7 = r23
            r8 = r21
            r10 = r18
            r11 = r13
            r3 = r12
            r12 = r17
            r6.<init>((int) r7, (com.clevertap.android.sdk.inbox.CTInboxMessage) r8, (java.lang.String) r9, (org.json.b) r10, (com.clevertap.android.sdk.inbox.g) r11, (boolean) r12)     // Catch:{ JSONException -> 0x0283 }
            r14.setOnClickListener(r3)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.N     // Catch:{ JSONException -> 0x0283 }
            com.clevertap.android.sdk.inbox.f r14 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0283 }
            java.lang.CharSequence r6 = r3.getText()     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r9 = r6.toString()     // Catch:{ JSONException -> 0x0283 }
            r12 = 0
            r6 = r14
            r7 = r23
            r8 = r21
            r10 = r0
            r11 = r13
            r6.<init>((int) r7, (com.clevertap.android.sdk.inbox.CTInboxMessage) r8, (java.lang.String) r9, (org.json.b) r10, (com.clevertap.android.sdk.inbox.g) r11, (boolean) r12)     // Catch:{ JSONException -> 0x0283 }
            r3.setOnClickListener(r14)     // Catch:{ JSONException -> 0x0283 }
            goto L_0x029c
        L_0x018e:
            r0 = move-exception
            r16 = r3
            goto L_0x0284
        L_0x0193:
            r16 = r3
            r3 = r14
            org.json.b r10 = r0.j(r3)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r6 = r1.L     // Catch:{ JSONException -> 0x0283 }
            r6.setVisibility(r3)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r6 = r15.i(r10)     // Catch:{ JSONException -> 0x0283 }
            r3.setText(r6)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r6 = r15.f(r10)     // Catch:{ JSONException -> 0x0283 }
            int r6 = android.graphics.Color.parseColor(r6)     // Catch:{ JSONException -> 0x0283 }
            r3.setTextColor(r6)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r6 = r15.e(r10)     // Catch:{ JSONException -> 0x0283 }
            int r6 = android.graphics.Color.parseColor(r6)     // Catch:{ JSONException -> 0x0283 }
            r3.setBackgroundColor(r6)     // Catch:{ JSONException -> 0x0283 }
            r3 = 1
            org.json.b r0 = r0.j(r3)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.M     // Catch:{ JSONException -> 0x0283 }
            r6 = 0
            r3.setVisibility(r6)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.M     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r6 = r15.i(r0)     // Catch:{ JSONException -> 0x0283 }
            r3.setText(r6)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.M     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r6 = r15.f(r0)     // Catch:{ JSONException -> 0x0283 }
            int r6 = android.graphics.Color.parseColor(r6)     // Catch:{ JSONException -> 0x0283 }
            r3.setTextColor(r6)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.M     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r6 = r15.e(r0)     // Catch:{ JSONException -> 0x0283 }
            int r6 = android.graphics.Color.parseColor(r6)     // Catch:{ JSONException -> 0x0283 }
            r3.setBackgroundColor(r6)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r6 = r1.M     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r7 = r1.N     // Catch:{ JSONException -> 0x0283 }
            r1.c0(r3, r6, r7)     // Catch:{ JSONException -> 0x0283 }
            if (r13 == 0) goto L_0x029c
            android.widget.Button r3 = r1.L     // Catch:{ JSONException -> 0x0283 }
            com.clevertap.android.sdk.inbox.f r14 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0283 }
            java.lang.CharSequence r6 = r3.getText()     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r9 = r6.toString()     // Catch:{ JSONException -> 0x0283 }
            r12 = 0
            r6 = r14
            r7 = r23
            r8 = r21
            r11 = r13
            r6.<init>((int) r7, (com.clevertap.android.sdk.inbox.CTInboxMessage) r8, (java.lang.String) r9, (org.json.b) r10, (com.clevertap.android.sdk.inbox.g) r11, (boolean) r12)     // Catch:{ JSONException -> 0x0283 }
            r3.setOnClickListener(r14)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.M     // Catch:{ JSONException -> 0x0283 }
            com.clevertap.android.sdk.inbox.f r14 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0283 }
            java.lang.CharSequence r6 = r3.getText()     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r9 = r6.toString()     // Catch:{ JSONException -> 0x0283 }
            r12 = 0
            r6 = r14
            r7 = r23
            r8 = r21
            r10 = r0
            r11 = r13
            r6.<init>((int) r7, (com.clevertap.android.sdk.inbox.CTInboxMessage) r8, (java.lang.String) r9, (org.json.b) r10, (com.clevertap.android.sdk.inbox.g) r11, (boolean) r12)     // Catch:{ JSONException -> 0x0283 }
            r3.setOnClickListener(r14)     // Catch:{ JSONException -> 0x0283 }
            goto L_0x029c
        L_0x022f:
            r16 = r3
            r3 = r14
            org.json.b r10 = r0.j(r3)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r0 = r1.L     // Catch:{ JSONException -> 0x0283 }
            r0.setVisibility(r3)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r0 = r1.L     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r3 = r15.i(r10)     // Catch:{ JSONException -> 0x0283 }
            r0.setText(r3)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r0 = r1.L     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r3 = r15.f(r10)     // Catch:{ JSONException -> 0x0283 }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x0283 }
            r0.setTextColor(r3)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r0 = r1.L     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r3 = r15.e(r10)     // Catch:{ JSONException -> 0x0283 }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x0283 }
            r0.setBackgroundColor(r3)     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r0 = r1.L     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r3 = r1.M     // Catch:{ JSONException -> 0x0283 }
            android.widget.Button r6 = r1.N     // Catch:{ JSONException -> 0x0283 }
            r1.d0(r0, r3, r6)     // Catch:{ JSONException -> 0x0283 }
            if (r13 == 0) goto L_0x029c
            android.widget.Button r0 = r1.L     // Catch:{ JSONException -> 0x0283 }
            com.clevertap.android.sdk.inbox.f r3 = new com.clevertap.android.sdk.inbox.f     // Catch:{ JSONException -> 0x0283 }
            java.lang.CharSequence r6 = r0.getText()     // Catch:{ JSONException -> 0x0283 }
            java.lang.String r9 = r6.toString()     // Catch:{ JSONException -> 0x0283 }
            r12 = 0
            r6 = r3
            r7 = r23
            r8 = r21
            r11 = r13
            r6.<init>((int) r7, (com.clevertap.android.sdk.inbox.CTInboxMessage) r8, (java.lang.String) r9, (org.json.b) r10, (com.clevertap.android.sdk.inbox.g) r11, (boolean) r12)     // Catch:{ JSONException -> 0x0283 }
            r0.setOnClickListener(r3)     // Catch:{ JSONException -> 0x0283 }
            goto L_0x029c
        L_0x0283:
            r0 = move-exception
        L_0x0284:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Error parsing CTA JSON - "
            r3.append(r6)
            java.lang.String r0 = r0.getLocalizedMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.clevertap.android.sdk.p.a(r0)
        L_0x029c:
            r3 = 8
            goto L_0x02a8
        L_0x029f:
            r16 = r3
            android.widget.LinearLayout r0 = r1.O
            r3 = 8
            r0.setVisibility(r3)
        L_0x02a8:
            android.widget.ImageView r0 = r1.f10533y
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r1.f10533y
            java.lang.String r6 = r21.a()
            int r6 = android.graphics.Color.parseColor(r6)
            r0.setBackgroundColor(r6)
            android.widget.ImageView r0 = r1.f10534z
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r1.f10534z
            java.lang.String r6 = r21.a()
            int r6 = android.graphics.Color.parseColor(r6)
            r0.setBackgroundColor(r6)
            android.widget.RelativeLayout r0 = r1.A
            r0.setVisibility(r3)
            android.widget.FrameLayout r0 = r1.B
            r0.setVisibility(r3)
            java.lang.String r0 = r21.g()     // Catch:{ NoClassDefFoundError -> 0x06be }
            int r6 = r0.hashCode()     // Catch:{ NoClassDefFoundError -> 0x06be }
            r7 = 108(0x6c, float:1.51E-43)
            r11 = -1
            if (r6 == r7) goto L_0x02f2
            r7 = 112(0x70, float:1.57E-43)
            if (r6 == r7) goto L_0x02e8
            goto L_0x02fa
        L_0x02e8:
            java.lang.String r6 = "p"
            boolean r0 = r0.equals(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            if (r0 == 0) goto L_0x02fa
            r0 = 1
            goto L_0x02fb
        L_0x02f2:
            boolean r0 = r0.equals(r2)     // Catch:{ NoClassDefFoundError -> 0x06be }
            if (r0 == 0) goto L_0x02fa
            r0 = 0
            goto L_0x02fb
        L_0x02fa:
            r0 = r11
        L_0x02fb:
            java.lang.String r6 = "ct_audio"
            java.lang.String r7 = "ct_video_1"
            if (r0 == 0) goto L_0x04f4
            r8 = 1
            if (r0 == r8) goto L_0x0307
        L_0x0304:
            r8 = 2
            goto L_0x06c2
        L_0x0307:
            boolean r0 = r15.w()     // Catch:{ NoClassDefFoundError -> 0x06be }
            if (r0 == 0) goto L_0x0371
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x06be }
            r6 = 0
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06be }
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x06be }
            r0.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x0356 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x0356 }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x0356 }
            java.lang.String r6 = r15.m()     // Catch:{ NoSuchMethodError -> 0x0356 }
            com.bumptech.glide.g r0 = r0.u(r6)     // Catch:{ NoSuchMethodError -> 0x0356 }
            b4.c r6 = new b4.c     // Catch:{ NoSuchMethodError -> 0x0356 }
            r6.<init>()     // Catch:{ NoSuchMethodError -> 0x0356 }
            android.content.Context r7 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x0356 }
            int r7 = i4.x.r(r7, r5)     // Catch:{ NoSuchMethodError -> 0x0356 }
            com.bumptech.glide.request.a r6 = r6.X(r7)     // Catch:{ NoSuchMethodError -> 0x0356 }
            b4.c r6 = (b4.c) r6     // Catch:{ NoSuchMethodError -> 0x0356 }
            android.content.Context r7 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x0356 }
            int r7 = i4.x.r(r7, r5)     // Catch:{ NoSuchMethodError -> 0x0356 }
            com.bumptech.glide.request.a r6 = r6.i(r7)     // Catch:{ NoSuchMethodError -> 0x0356 }
            com.bumptech.glide.g r0 = r0.a(r6)     // Catch:{ NoSuchMethodError -> 0x0356 }
            android.widget.ImageView r6 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x0356 }
            r0.x0(r6)     // Catch:{ NoSuchMethodError -> 0x0356 }
            goto L_0x0304
        L_0x0356:
            com.clevertap.android.sdk.p.a(r4)     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x06be }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x06be }
            java.lang.String r6 = r15.m()     // Catch:{ NoClassDefFoundError -> 0x06be }
            com.bumptech.glide.g r0 = r0.u(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView r6 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06be }
            r0.x0(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            goto L_0x0304
        L_0x0371:
            boolean r0 = r15.u()     // Catch:{ NoClassDefFoundError -> 0x06be }
            if (r0 == 0) goto L_0x03e5
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x06be }
            r6 = 0
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06be }
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x06be }
            r0.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x03c5 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x03c5 }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x03c5 }
            com.bumptech.glide.g r0 = r0.o()     // Catch:{ NoSuchMethodError -> 0x03c5 }
            java.lang.String r6 = r15.m()     // Catch:{ NoSuchMethodError -> 0x03c5 }
            com.bumptech.glide.g r0 = r0.C0(r6)     // Catch:{ NoSuchMethodError -> 0x03c5 }
            b4.c r6 = new b4.c     // Catch:{ NoSuchMethodError -> 0x03c5 }
            r6.<init>()     // Catch:{ NoSuchMethodError -> 0x03c5 }
            android.content.Context r7 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x03c5 }
            int r7 = i4.x.r(r7, r5)     // Catch:{ NoSuchMethodError -> 0x03c5 }
            com.bumptech.glide.request.a r6 = r6.X(r7)     // Catch:{ NoSuchMethodError -> 0x03c5 }
            b4.c r6 = (b4.c) r6     // Catch:{ NoSuchMethodError -> 0x03c5 }
            android.content.Context r7 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x03c5 }
            int r7 = i4.x.r(r7, r5)     // Catch:{ NoSuchMethodError -> 0x03c5 }
            com.bumptech.glide.request.a r6 = r6.i(r7)     // Catch:{ NoSuchMethodError -> 0x03c5 }
            com.bumptech.glide.g r0 = r0.a(r6)     // Catch:{ NoSuchMethodError -> 0x03c5 }
            android.widget.ImageView r6 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x03c5 }
            r0.x0(r6)     // Catch:{ NoSuchMethodError -> 0x03c5 }
            goto L_0x0304
        L_0x03c5:
            com.clevertap.android.sdk.p.a(r4)     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x06be }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x06be }
            com.bumptech.glide.g r0 = r0.o()     // Catch:{ NoClassDefFoundError -> 0x06be }
            java.lang.String r6 = r15.m()     // Catch:{ NoClassDefFoundError -> 0x06be }
            com.bumptech.glide.g r0 = r0.C0(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            android.widget.ImageView r6 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06be }
            r0.x0(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            goto L_0x0304
        L_0x03e5:
            boolean r0 = r15.x()     // Catch:{ NoClassDefFoundError -> 0x06be }
            if (r0 == 0) goto L_0x04b1
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x06be }
            r6 = 0
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            java.lang.String r0 = r15.p()     // Catch:{ NoClassDefFoundError -> 0x06be }
            boolean r0 = r0.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x06be }
            if (r0 != 0) goto L_0x0468
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06be }
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06be }
            int r0 = com.clevertap.android.sdk.inbox.CTInboxActivity.f10465h     // Catch:{ NoClassDefFoundError -> 0x06be }
            r8 = 2
            if (r0 != r8) goto L_0x040d
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            goto L_0x0414
        L_0x040d:
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
        L_0x0414:
            com.clevertap.android.sdk.p.a(r4)     // Catch:{ NoSuchMethodError -> 0x044f }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x044f }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x044f }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x044f }
            java.lang.String r6 = r15.p()     // Catch:{ NoSuchMethodError -> 0x044f }
            com.bumptech.glide.g r0 = r0.u(r6)     // Catch:{ NoSuchMethodError -> 0x044f }
            b4.c r6 = new b4.c     // Catch:{ NoSuchMethodError -> 0x044f }
            r6.<init>()     // Catch:{ NoSuchMethodError -> 0x044f }
            android.content.Context r9 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x044f }
            int r9 = i4.x.r(r9, r7)     // Catch:{ NoSuchMethodError -> 0x044f }
            com.bumptech.glide.request.a r6 = r6.X(r9)     // Catch:{ NoSuchMethodError -> 0x044f }
            b4.c r6 = (b4.c) r6     // Catch:{ NoSuchMethodError -> 0x044f }
            android.content.Context r9 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x044f }
            int r7 = i4.x.r(r9, r7)     // Catch:{ NoSuchMethodError -> 0x044f }
            com.bumptech.glide.request.a r6 = r6.i(r7)     // Catch:{ NoSuchMethodError -> 0x044f }
            com.bumptech.glide.g r0 = r0.a(r6)     // Catch:{ NoSuchMethodError -> 0x044f }
            android.widget.ImageView r6 = r1.f10534z     // Catch:{ NoSuchMethodError -> 0x044f }
            r0.x0(r6)     // Catch:{ NoSuchMethodError -> 0x044f }
            goto L_0x06c2
        L_0x044f:
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            java.lang.String r6 = r15.p()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.g r0 = r0.u(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r6 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.x0(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            goto L_0x06c2
        L_0x0468:
            r8 = 2
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r6 = 0
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            int r0 = com.clevertap.android.sdk.inbox.CTInboxActivity.f10465h     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 != r8) goto L_0x0480
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            goto L_0x0487
        L_0x0480:
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
        L_0x0487:
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            int r6 = r20.Z()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setBackgroundColor(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r0 = r1.f10529u     // Catch:{ NoClassDefFoundError -> 0x06bf }
            int r0 = i4.x.r(r0, r7)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 == r11) goto L_0x06c2
            android.widget.ImageView r6 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r6 = r6.getContext()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.h r6 = com.bumptech.glide.c.t(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.g r0 = r6.t(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r6 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.x0(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            goto L_0x06c2
        L_0x04b1:
            r8 = 2
            boolean r0 = r15.t()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 == 0) goto L_0x06c2
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r7 = 0
            r0.setVisibility(r7)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setVisibility(r7)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView$ScaleType r7 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setScaleType(r7)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            int r7 = r20.Z()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setBackgroundColor(r7)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r0 = r1.f10529u     // Catch:{ NoClassDefFoundError -> 0x06bf }
            int r0 = i4.x.r(r0, r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 == r11) goto L_0x06c2
            android.widget.ImageView r6 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r6 = r6.getContext()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.h r6 = com.bumptech.glide.c.t(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.g r0 = r6.t(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r6 = r1.f10534z     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.x0(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            goto L_0x06c2
        L_0x04f4:
            r8 = 2
            boolean r0 = r15.w()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 == 0) goto L_0x0561
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r6 = 0
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x0545 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x0545 }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x0545 }
            java.lang.String r6 = r15.m()     // Catch:{ NoSuchMethodError -> 0x0545 }
            com.bumptech.glide.g r0 = r0.u(r6)     // Catch:{ NoSuchMethodError -> 0x0545 }
            b4.c r6 = new b4.c     // Catch:{ NoSuchMethodError -> 0x0545 }
            r6.<init>()     // Catch:{ NoSuchMethodError -> 0x0545 }
            android.content.Context r7 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x0545 }
            int r7 = i4.x.r(r7, r5)     // Catch:{ NoSuchMethodError -> 0x0545 }
            com.bumptech.glide.request.a r6 = r6.X(r7)     // Catch:{ NoSuchMethodError -> 0x0545 }
            b4.c r6 = (b4.c) r6     // Catch:{ NoSuchMethodError -> 0x0545 }
            android.content.Context r7 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x0545 }
            int r7 = i4.x.r(r7, r5)     // Catch:{ NoSuchMethodError -> 0x0545 }
            com.bumptech.glide.request.a r6 = r6.i(r7)     // Catch:{ NoSuchMethodError -> 0x0545 }
            com.bumptech.glide.g r0 = r0.a(r6)     // Catch:{ NoSuchMethodError -> 0x0545 }
            android.widget.ImageView r6 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x0545 }
            r0.x0(r6)     // Catch:{ NoSuchMethodError -> 0x0545 }
            goto L_0x06c2
        L_0x0545:
            com.clevertap.android.sdk.p.a(r4)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            java.lang.String r6 = r15.m()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.g r0 = r0.u(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r6 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.x0(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            goto L_0x06c2
        L_0x0561:
            boolean r0 = r15.u()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 == 0) goto L_0x05d5
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r6 = 0
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x05b5 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x05b5 }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x05b5 }
            com.bumptech.glide.g r0 = r0.o()     // Catch:{ NoSuchMethodError -> 0x05b5 }
            java.lang.String r6 = r15.m()     // Catch:{ NoSuchMethodError -> 0x05b5 }
            com.bumptech.glide.g r0 = r0.C0(r6)     // Catch:{ NoSuchMethodError -> 0x05b5 }
            b4.c r6 = new b4.c     // Catch:{ NoSuchMethodError -> 0x05b5 }
            r6.<init>()     // Catch:{ NoSuchMethodError -> 0x05b5 }
            android.content.Context r7 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x05b5 }
            int r7 = i4.x.r(r7, r5)     // Catch:{ NoSuchMethodError -> 0x05b5 }
            com.bumptech.glide.request.a r6 = r6.X(r7)     // Catch:{ NoSuchMethodError -> 0x05b5 }
            b4.c r6 = (b4.c) r6     // Catch:{ NoSuchMethodError -> 0x05b5 }
            android.content.Context r7 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x05b5 }
            int r7 = i4.x.r(r7, r5)     // Catch:{ NoSuchMethodError -> 0x05b5 }
            com.bumptech.glide.request.a r6 = r6.i(r7)     // Catch:{ NoSuchMethodError -> 0x05b5 }
            com.bumptech.glide.g r0 = r0.a(r6)     // Catch:{ NoSuchMethodError -> 0x05b5 }
            android.widget.ImageView r6 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x05b5 }
            r0.x0(r6)     // Catch:{ NoSuchMethodError -> 0x05b5 }
            goto L_0x06c2
        L_0x05b5:
            com.clevertap.android.sdk.p.a(r4)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.g r0 = r0.o()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            java.lang.String r6 = r15.m()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.g r0 = r0.C0(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r6 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.x0(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            goto L_0x06c2
        L_0x05d5:
            boolean r0 = r15.x()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 == 0) goto L_0x067d
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r6 = 0
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            java.lang.String r0 = r15.p()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            boolean r0 = r0.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 != 0) goto L_0x064b
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x062f }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x062f }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x062f }
            java.lang.String r6 = r15.p()     // Catch:{ NoSuchMethodError -> 0x062f }
            com.bumptech.glide.g r0 = r0.u(r6)     // Catch:{ NoSuchMethodError -> 0x062f }
            b4.c r6 = new b4.c     // Catch:{ NoSuchMethodError -> 0x062f }
            r6.<init>()     // Catch:{ NoSuchMethodError -> 0x062f }
            android.content.Context r9 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x062f }
            int r9 = i4.x.r(r9, r7)     // Catch:{ NoSuchMethodError -> 0x062f }
            com.bumptech.glide.request.a r6 = r6.X(r9)     // Catch:{ NoSuchMethodError -> 0x062f }
            b4.c r6 = (b4.c) r6     // Catch:{ NoSuchMethodError -> 0x062f }
            android.content.Context r9 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x062f }
            int r7 = i4.x.r(r9, r7)     // Catch:{ NoSuchMethodError -> 0x062f }
            com.bumptech.glide.request.a r6 = r6.i(r7)     // Catch:{ NoSuchMethodError -> 0x062f }
            com.bumptech.glide.g r0 = r0.a(r6)     // Catch:{ NoSuchMethodError -> 0x062f }
            android.widget.ImageView r6 = r1.f10533y     // Catch:{ NoSuchMethodError -> 0x062f }
            r0.x0(r6)     // Catch:{ NoSuchMethodError -> 0x062f }
            goto L_0x06c2
        L_0x062f:
            com.clevertap.android.sdk.p.a(r4)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            java.lang.String r6 = r15.p()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.g r0 = r0.u(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r6 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.x0(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            goto L_0x06c2
        L_0x064b:
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r6 = 0
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setVisibility(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r0 = r1.f10529u     // Catch:{ NoClassDefFoundError -> 0x06bf }
            int r0 = i4.x.r(r0, r7)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 == r11) goto L_0x06c2
            android.widget.ImageView r6 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r6 = r6.getContext()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.h r6 = com.bumptech.glide.c.t(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.g r0 = r6.t(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r6 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.x0(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            goto L_0x06c2
        L_0x067d:
            boolean r0 = r15.t()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 == 0) goto L_0x06c2
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r7 = 0
            r0.setVisibility(r7)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setVisibility(r7)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView$ScaleType r7 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setScaleType(r7)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r0 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            int r7 = r20.Z()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.setBackgroundColor(r7)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r0 = r1.f10529u     // Catch:{ NoClassDefFoundError -> 0x06bf }
            int r0 = i4.x.r(r0, r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            if (r0 == r11) goto L_0x06c2
            android.widget.ImageView r6 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.content.Context r6 = r6.getContext()     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.h r6 = com.bumptech.glide.c.t(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            com.bumptech.glide.g r0 = r6.t(r0)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            android.widget.ImageView r6 = r1.f10533y     // Catch:{ NoClassDefFoundError -> 0x06bf }
            r0.x0(r6)     // Catch:{ NoClassDefFoundError -> 0x06bf }
            goto L_0x06c2
        L_0x06be:
            r8 = 2
        L_0x06bf:
            com.clevertap.android.sdk.p.a(r16)
        L_0x06c2:
            android.content.Context r0 = r1.f10529u
            android.content.res.Resources r0 = r0.getResources()
            int r6 = com.clevertap.android.sdk.inbox.CTInboxActivity.f10465h
            if (r6 != r8) goto L_0x06db
            android.util.DisplayMetrics r2 = r0.getDisplayMetrics()
            int r2 = r2.heightPixels
            int r2 = r2 / r8
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            int r0 = r0 / r8
            goto L_0x06f5
        L_0x06db:
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            java.lang.String r6 = r21.g()
            boolean r2 = r6.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x06f4
            float r2 = (float) r0
            r6 = 1058013184(0x3f100000, float:0.5625)
            float r2 = r2 * r6
            int r2 = java.lang.Math.round(r2)
            goto L_0x06f5
        L_0x06f4:
            r2 = r0
        L_0x06f5:
            android.widget.FrameLayout r6 = r1.B
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            r7.<init>(r0, r2)
            r6.setLayoutParams(r7)
            r2 = r21
            r7 = r23
            r1.f0(r2, r7)
            java.lang.String r0 = r15.d()     // Catch:{ NoClassDefFoundError -> 0x076e }
            boolean r0 = r0.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x076e }
            if (r0 != 0) goto L_0x0768
            android.widget.ImageView r0 = r1.P     // Catch:{ NoClassDefFoundError -> 0x076e }
            r3 = 0
            r0.setVisibility(r3)     // Catch:{ NoClassDefFoundError -> 0x076e }
            android.widget.ImageView r0 = r1.P     // Catch:{ NoSuchMethodError -> 0x074d }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x074d }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoSuchMethodError -> 0x074d }
            java.lang.String r3 = r15.d()     // Catch:{ NoSuchMethodError -> 0x074d }
            com.bumptech.glide.g r0 = r0.u(r3)     // Catch:{ NoSuchMethodError -> 0x074d }
            b4.c r3 = new b4.c     // Catch:{ NoSuchMethodError -> 0x074d }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x074d }
            android.content.Context r6 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x074d }
            int r6 = i4.x.r(r6, r5)     // Catch:{ NoSuchMethodError -> 0x074d }
            com.bumptech.glide.request.a r3 = r3.X(r6)     // Catch:{ NoSuchMethodError -> 0x074d }
            b4.c r3 = (b4.c) r3     // Catch:{ NoSuchMethodError -> 0x074d }
            android.content.Context r6 = r1.f10529u     // Catch:{ NoSuchMethodError -> 0x074d }
            int r5 = i4.x.r(r6, r5)     // Catch:{ NoSuchMethodError -> 0x074d }
            com.bumptech.glide.request.a r3 = r3.i(r5)     // Catch:{ NoSuchMethodError -> 0x074d }
            com.bumptech.glide.g r0 = r0.a(r3)     // Catch:{ NoSuchMethodError -> 0x074d }
            android.widget.ImageView r3 = r1.P     // Catch:{ NoSuchMethodError -> 0x074d }
            r0.x0(r3)     // Catch:{ NoSuchMethodError -> 0x074d }
            goto L_0x0771
        L_0x074d:
            com.clevertap.android.sdk.p.a(r4)     // Catch:{ NoClassDefFoundError -> 0x076e }
            android.widget.ImageView r0 = r1.P     // Catch:{ NoClassDefFoundError -> 0x076e }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x076e }
            com.bumptech.glide.h r0 = com.bumptech.glide.c.t(r0)     // Catch:{ NoClassDefFoundError -> 0x076e }
            java.lang.String r3 = r15.d()     // Catch:{ NoClassDefFoundError -> 0x076e }
            com.bumptech.glide.g r0 = r0.u(r3)     // Catch:{ NoClassDefFoundError -> 0x076e }
            android.widget.ImageView r3 = r1.P     // Catch:{ NoClassDefFoundError -> 0x076e }
            r0.x0(r3)     // Catch:{ NoClassDefFoundError -> 0x076e }
            goto L_0x0771
        L_0x0768:
            android.widget.ImageView r0 = r1.P     // Catch:{ NoClassDefFoundError -> 0x076e }
            r0.setVisibility(r3)     // Catch:{ NoClassDefFoundError -> 0x076e }
            goto L_0x0771
        L_0x076e:
            com.clevertap.android.sdk.p.a(r16)
        L_0x0771:
            if (r13 == 0) goto L_0x0786
            android.widget.RelativeLayout r0 = r1.K
            com.clevertap.android.sdk.inbox.f r3 = new com.clevertap.android.sdk.inbox.f
            r9 = 0
            r10 = 0
            r12 = 1
            r6 = r3
            r7 = r23
            r8 = r21
            r11 = r13
            r6.<init>((int) r7, (com.clevertap.android.sdk.inbox.CTInboxMessage) r8, (java.lang.String) r9, (org.json.b) r10, (com.clevertap.android.sdk.inbox.g) r11, (boolean) r12)
            r0.setOnClickListener(r3)
        L_0x0786:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.d.Y(com.clevertap.android.sdk.inbox.CTInboxMessage, com.clevertap.android.sdk.inbox.g, int):void");
    }
}
