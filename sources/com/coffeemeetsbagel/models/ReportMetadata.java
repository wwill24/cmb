package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.Date;
import java.util.List;
import lg.c;

public class ReportMetadata {
    public static final String ID_TIPS = "4";
    @c("action_types")
    private List<String> mActionTypes;
    @c("component_types")
    private List<String> mComponentTypes;
    private int mIconId;
    @c("icon")
    private String mIconUrl;
    @c("id")
    private String mId;
    @c("object_types")
    private List<String> mObjectTypes;
    @c("order")
    private int mOrder;
    @c("shown")
    private boolean mShown;
    @c("title")
    private String mTitle;
    @c("updated_date")
    private String mUpdatedDateString;

    public ReportMetadata(String str, int i10, String str2, int i11) {
        this.mId = str;
        this.mIconId = i10;
        this.mTitle = str2;
        this.mOrder = i11;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReportMetadata) && this.mId.equals(((ReportMetadata) obj).getId());
    }

    public List<String> getActionTypes() {
        return this.mActionTypes;
    }

    public List<String> getComponentTypes() {
        return this.mComponentTypes;
    }

    public int getIconId() {
        return this.mIconId;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public String getId() {
        return this.mId;
    }

    public List<String> getObjectTypes() {
        return this.mObjectTypes;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public Date getUpdatedDate() {
        return DateUtils.getDate(this.mUpdatedDateString);
    }

    public String getUpdatedDateString() {
        return this.mUpdatedDateString;
    }

    public boolean isShown() {
        return this.mShown;
    }

    public void setActionTypes(List<String> list) {
        this.mActionTypes = list;
    }

    public void setComponentTypes(List<String> list) {
        this.mComponentTypes = list;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setObjectTypes(List<String> list) {
        this.mObjectTypes = list;
    }

    public void setOrder(int i10) {
        this.mOrder = i10;
    }

    public void setShown(boolean z10) {
        this.mShown = z10;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setUpdatedDateString(String str) {
        this.mUpdatedDateString = str;
    }

    public ReportMetadata(String str, String str2, String str3, int i10) {
        this.mId = str;
        this.mIconUrl = str2;
        this.mTitle = str3;
        this.mOrder = i10;
    }

    public ReportMetadata() {
    }
}
