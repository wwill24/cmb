package com.coffeemeetsbagel.models;

public class StickerNetwork implements Model {
    private String description;
    private String imageUrl;
    private String name;

    public StickerNetwork(String str, String str2, String str3) {
        this.imageUrl = str;
        this.name = str2;
        this.description = str3;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Sticker stickerDtoImpl() {
        return new Sticker(getImageUrl(), getName(), getDescription());
    }
}
