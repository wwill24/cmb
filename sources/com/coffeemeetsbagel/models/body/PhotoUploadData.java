package com.coffeemeetsbagel.models.body;

import java.util.Objects;
import lg.c;

public class PhotoUploadData {
    private final String caption;
    @c("photo_id")
    private final String photoId;
    private final int position;

    public PhotoUploadData(String str, String str2, int i10) {
        this.photoId = str;
        this.caption = str2;
        this.position = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PhotoUploadData photoUploadData = (PhotoUploadData) obj;
        if (this.position != photoUploadData.position || !Objects.equals(this.photoId, photoUploadData.photoId) || !Objects.equals(this.caption, photoUploadData.caption)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.photoId, this.caption, Integer.valueOf(this.position)});
    }
}
