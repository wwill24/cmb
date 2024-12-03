package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.a;
import i4.u;
import i4.v;
import java.util.ArrayList;

public class m extends d {

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            m.this.B0((Bundle) null);
            m.this.getActivity().finish();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        View inflate = layoutInflater.inflate(v.inapp_cover, viewGroup, false);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(u.inapp_cover_frame_layout);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(u.cover_relative_layout);
        relativeLayout.setBackgroundColor(Color.parseColor(this.f10385e.d()));
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(u.cover_linear_layout);
        Button button = (Button) linearLayout.findViewById(u.cover_button1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout.findViewById(u.cover_button2);
        arrayList.add(button2);
        ImageView imageView = (ImageView) relativeLayout.findViewById(u.backgroundImage);
        if (this.f10385e.q(this.f10384d) != null) {
            CTInAppNotification cTInAppNotification = this.f10385e;
            if (cTInAppNotification.p(cTInAppNotification.q(this.f10384d)) != null) {
                CTInAppNotification cTInAppNotification2 = this.f10385e;
                imageView.setImageBitmap(cTInAppNotification2.p(cTInAppNotification2.q(this.f10384d)));
                imageView.setTag(0);
                imageView.setOnClickListener(new a.C0118a());
            }
        }
        TextView textView = (TextView) relativeLayout.findViewById(u.cover_title);
        textView.setText(this.f10385e.B());
        textView.setTextColor(Color.parseColor(this.f10385e.D()));
        TextView textView2 = (TextView) relativeLayout.findViewById(u.cover_message);
        textView2.setText(this.f10385e.w());
        textView2.setTextColor(Color.parseColor(this.f10385e.x()));
        ArrayList<CTInAppNotificationButton> g10 = this.f10385e.g();
        if (g10.size() == 1) {
            int i10 = this.f10384d;
            if (i10 == 2) {
                button.setVisibility(8);
            } else if (i10 == 1) {
                button.setVisibility(4);
            }
            V0(button2, g10.get(0), 0);
        } else if (!g10.isEmpty()) {
            for (int i11 = 0; i11 < g10.size(); i11++) {
                if (i11 < 2) {
                    V0((Button) arrayList.get(i11), g10.get(i11), i11);
                }
            }
        }
        CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        closeImageView.setOnClickListener(new a());
        if (!this.f10385e.O()) {
            closeImageView.setVisibility(8);
        } else {
            closeImageView.setVisibility(0);
        }
        return inflate;
    }
}
