package com.mparticle.commerce;

import androidx.annotation.NonNull;
import com.mparticle.internal.MPUtility;
import org.json.JSONException;
import org.json.b;

public class Promotion {
    @NonNull
    public static final String CLICK = "click";
    @NonNull
    public static final String VIEW = "view";
    private String mCreative = null;
    private String mId = null;
    private String mName = null;
    private String mPosition = null;

    public Promotion() {
    }

    public String getCreative() {
        return this.mCreative;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getPosition() {
        return this.mPosition;
    }

    @NonNull
    public Promotion setCreative(String str) {
        this.mCreative = str;
        return this;
    }

    @NonNull
    public Promotion setId(String str) {
        this.mId = str;
        return this;
    }

    @NonNull
    public Promotion setName(String str) {
        this.mName = str;
        return this;
    }

    @NonNull
    public Promotion setPosition(String str) {
        this.mPosition = str;
        return this;
    }

    @NonNull
    public String toString() {
        b bVar = new b();
        try {
            if (!MPUtility.isEmpty((CharSequence) getId())) {
                bVar.put("id", (Object) getId());
            }
            if (!MPUtility.isEmpty((CharSequence) getName())) {
                bVar.put("nm", (Object) getName());
            }
            if (!MPUtility.isEmpty((CharSequence) getCreative())) {
                bVar.put("cr", (Object) getCreative());
            }
            if (!MPUtility.isEmpty((CharSequence) getPosition())) {
                bVar.put("ps", (Object) getPosition());
            }
        } catch (JSONException unused) {
        }
        return bVar.toString();
    }

    public Promotion(@NonNull Promotion promotion) {
        if (promotion != null) {
            this.mCreative = promotion.getCreative();
            this.mId = promotion.getId();
            this.mName = promotion.getName();
            this.mPosition = promotion.getPosition();
        }
    }
}
