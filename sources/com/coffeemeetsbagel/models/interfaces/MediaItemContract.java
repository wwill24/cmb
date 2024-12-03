package com.coffeemeetsbagel.models.interfaces;

import com.coffeemeetsbagel.models.enums.MediaItemType;

public interface MediaItemContract {

    public interface Listener {
        void onPhotoClicked();
    }

    public interface MediaItem {
        MediaItemType getType();

        String getUrl();
    }

    public interface ViewPager {

        public interface Listener {
            void onPhotoClicked();
        }
    }
}
