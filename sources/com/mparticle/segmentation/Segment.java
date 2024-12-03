package com.mparticle.segmentation;

import androidx.annotation.NonNull;
import java.util.Arrays;
import org.json.JSONException;
import org.json.a;

public class Segment {
    String[] endpoints;

    /* renamed from: id  reason: collision with root package name */
    int f22635id;
    String name;

    public Segment(int i10, @NonNull String str, @NonNull String str2) {
        this.f22635id = i10;
        this.name = str;
        try {
            a aVar = new a(str2);
            this.endpoints = new String[aVar.o()];
            for (int i11 = 0; i11 < aVar.o(); i11++) {
                this.endpoints[i11] = aVar.n(i11);
            }
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public String[] getEndpoints() {
        String[] strArr = this.endpoints;
        return strArr != null ? strArr : new String[0];
    }

    public int getId() {
        return this.f22635id;
    }

    public String getName() {
        return this.name;
    }

    @NonNull
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Segment ID:  ");
        sb2.append(this.f22635id);
        sb2.append(", Name: ");
        sb2.append(this.name);
        sb2.append(", Endpoints: ");
        String[] strArr = this.endpoints;
        if (strArr == null || strArr.length <= 0) {
            str = "None specified.";
        } else {
            str = Arrays.toString(strArr);
        }
        sb2.append(str);
        return sb2.toString();
    }
}
