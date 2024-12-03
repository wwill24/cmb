package com.coffeemeetsbagel.models.interfaces;

public interface UpgradeContract {

    public interface Manager {

        public interface UpgradeListener {
            void hardUpgradeDetected();

            void softUpgradeDetected();
        }

        void addUpgradeListener(UpgradeListener upgradeListener);

        void removeUpgradeListener(UpgradeListener upgradeListener);
    }
}
