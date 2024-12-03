package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.a;
import i4.u;
import i4.v;

public class n extends b {

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            n.this.B0((Bundle) null);
            n.this.getActivity().finish();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(v.inapp_cover_image, viewGroup, false);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(u.inapp_cover_image_frame_layout);
        frameLayout.setBackgroundColor(Color.parseColor(this.f10385e.d()));
        ImageView imageView = (ImageView) ((RelativeLayout) frameLayout.findViewById(u.cover_image_relative_layout)).findViewById(u.cover_image);
        if (this.f10385e.q(this.f10384d) != null) {
            CTInAppNotification cTInAppNotification = this.f10385e;
            if (cTInAppNotification.p(cTInAppNotification.q(this.f10384d)) != null) {
                CTInAppNotification cTInAppNotification2 = this.f10385e;
                imageView.setImageBitmap(cTInAppNotification2.p(cTInAppNotification2.q(this.f10384d)));
                imageView.setTag(0);
                imageView.setOnClickListener(new a.C0118a());
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
