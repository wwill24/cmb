package com.google.firebase.perf.injection.components;

import androidx.annotation.NonNull;
import com.google.firebase.perf.FirebasePerformance;

public interface FirebasePerformanceComponent {
    @NonNull
    FirebasePerformance getFirebasePerformance();
}
