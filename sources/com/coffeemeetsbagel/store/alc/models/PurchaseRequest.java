package com.coffeemeetsbagel.store.alc.models;

import lg.c;

public class PurchaseRequest {
    @c("bagel_id")
    private String bagelId;
    @c("discover_search_result_id")
    private String discoverSearchResultId;
    @c("expected_price")
    private final long expectedPrice;
    @c("give_ten_id")
    private String giveTenId;
    @c("item_count")
    private final int itemCount;
    @c("item_name")
    private final String itemName;
    @c("profile_id")
    private String profileId;
    private Integer source;
    @c("video_id")
    private String videoId;

    public PurchaseRequest(String str, long j10, int i10) {
        this.itemName = str;
        this.expectedPrice = j10;
        this.itemCount = i10;
    }

    public long getExpectedPrice() {
        return this.expectedPrice;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setBagelId(String str) {
        this.bagelId = str;
    }

    public void setDiscoverSearchResultId(String str) {
        this.discoverSearchResultId = str;
    }

    public void setGiveTenId(String str) {
        this.giveTenId = str;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public void setSource(Integer num) {
        this.source = num;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }
}
