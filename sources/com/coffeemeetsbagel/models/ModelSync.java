package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.responses.ResponseGiveTakes;
import com.coffeemeetsbagel.models.responses.ResponseRisingGiveTakes;
import com.coffeemeetsbagel.models.responses.ResponseStickers;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lg.c;

public class ModelSync implements Serializable {
    private List<Bagel> bagels;
    @c("report_meta")
    private Map<String, Boolean> features;
    private List<GiveTake> mGiveTakes;
    private ResponseGiveTakes mResponseGiveTakes;
    private Map<String, Price> mapPrices;
    private NetworkProfile myProfile;
    private List<Price> priceList;
    private List<NetworkProfile> profiles;
    private ResponseRisingGiveTakes responseRisingGiveTakes;
    private List<RisingGiveTake> risingGiveTakes;
    private List<StickerNetwork> stickers;

    public ModelSync() {
        if (this.profiles == null) {
            this.profiles = new ArrayList();
        }
    }

    private void refreshPriceList() {
        this.priceList = new ArrayList();
        Map<String, Price> map = this.mapPrices;
        if (map != null) {
            for (String next : map.keySet()) {
                Price price = this.mapPrices.get(next);
                price.setName(next);
                this.priceList.add(price);
            }
        }
    }

    public List<Bagel> getBagels() {
        return this.bagels;
    }

    public Map<String, Boolean> getFeatures() {
        return this.features;
    }

    public List<GiveTake> getGiveTakes() {
        return this.mGiveTakes;
    }

    public Map<String, Price> getMapPrices() {
        return this.mapPrices;
    }

    public NetworkProfile getMyProfile() {
        return this.myProfile;
    }

    public List<Price> getPriceList() {
        return this.priceList;
    }

    public List<NetworkProfile> getProfiles() {
        return this.profiles;
    }

    public ResponseGiveTakes getResponseGiveTakes() {
        return this.mResponseGiveTakes;
    }

    public ResponseRisingGiveTakes getResponseRisingGiveTakes() {
        return this.responseRisingGiveTakes;
    }

    public List<RisingGiveTake> getRisingGiveTakes() {
        return this.risingGiveTakes;
    }

    public List<StickerNetwork> getStickers() {
        return this.stickers;
    }

    public void processFeatures(Map<String, Boolean> map) {
        this.features = map;
    }

    public void processMapPrices(Map<String, Price> map) {
        this.mapPrices = map;
        refreshPriceList();
    }

    public void processMyOwnProfile(NetworkProfile networkProfile) {
        if (networkProfile != null) {
            this.profiles.add(networkProfile);
        }
        this.myProfile = networkProfile;
    }

    public void processResponseGiveTakes(ResponseGiveTakes responseGiveTakes) {
        if (responseGiveTakes != null) {
            this.mResponseGiveTakes = responseGiveTakes;
            List<GiveTake> results = responseGiveTakes.getResults();
            this.mGiveTakes = results;
            if (!CollectionUtils.isEmpty((List) results)) {
                for (GiveTake next : this.mGiveTakes) {
                    if (next.getProfile() != null) {
                        this.profiles.add(next.getProfile());
                    }
                }
            }
        }
    }

    public void processResponseRisingGiveTakes(ResponseRisingGiveTakes responseRisingGiveTakes2) {
        if (responseRisingGiveTakes2 != null) {
            this.responseRisingGiveTakes = responseRisingGiveTakes2;
            List<RisingGiveTake> results = responseRisingGiveTakes2.getResults();
            this.risingGiveTakes = results;
            if (!CollectionUtils.isEmpty((List) results)) {
                for (RisingGiveTake next : this.risingGiveTakes) {
                    if (next.getProfile() != null) {
                        this.profiles.add(next.getProfile());
                    }
                }
            }
        }
    }

    public void processStickers(ResponseStickers responseStickers) {
        if (responseStickers != null) {
            this.stickers = responseStickers.getStickers();
        }
    }

    public void setBagels(List<Bagel> list) {
        this.bagels = list;
    }

    public void setFeatures(Map<String, Boolean> map) {
        this.features = map;
    }

    public void setGiveTakes(List<GiveTake> list) {
        this.mGiveTakes = list;
    }

    public void setPriceList(List<Price> list) {
        this.priceList = list;
    }

    public void setProfiles(List<NetworkProfile> list) {
        this.profiles = list;
    }
}
