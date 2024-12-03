package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.NonNull;
import androidx.core.view.k0;

class i {
    private static int a(Fragment fragment, boolean z10, boolean z11) {
        if (z11) {
            if (z10) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        } else if (z10) {
            return fragment.getEnterAnim();
        } else {
            return fragment.getExitAnim();
        }
    }

    static a b(@NonNull Context context, @NonNull Fragment fragment, boolean z10, boolean z11) {
        int nextTransition = fragment.getNextTransition();
        int a10 = a(fragment, z10, z11);
        boolean z12 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i10 = h1.b.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i10) != null) {
                fragment.mContainer.setTag(i10, (Object) null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z10, a10);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z10, a10);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (a10 == 0 && nextTransition != 0) {
            a10 = d(context, nextTransition, z10);
        }
        if (a10 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(a10));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, a10);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z12 = true;
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            }
            if (!z12) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, a10);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e11) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a10);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    } else {
                        throw e11;
                    }
                }
            }
        }
        return null;
    }

    private static int c(@NonNull Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{i10});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(@NonNull Context context, int i10, boolean z10) {
        if (i10 != 4097) {
            if (i10 != 8194) {
                if (i10 != 8197) {
                    if (i10 != 4099) {
                        if (i10 != 4100) {
                            return -1;
                        }
                        if (z10) {
                            return c(context, 16842936);
                        }
                        return c(context, 16842937);
                    } else if (z10) {
                        return h1.a.fragment_fade_enter;
                    } else {
                        return h1.a.fragment_fade_exit;
                    }
                } else if (z10) {
                    return c(context, 16842938);
                } else {
                    return c(context, 16842939);
                }
            } else if (z10) {
                return h1.a.fragment_close_enter;
            } else {
                return h1.a.fragment_close_exit;
            }
        } else if (z10) {
            return h1.a.fragment_open_enter;
        } else {
            return h1.a.fragment_open_exit;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f5852a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f5853b;

        a(Animation animation) {
            this.f5852a = animation;
            this.f5853b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f5852a = null;
            this.f5853b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    static class b extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f5854a;

        /* renamed from: b  reason: collision with root package name */
        private final View f5855b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5856c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5857d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5858e = true;

        b(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
            super(false);
            this.f5854a = viewGroup;
            this.f5855b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j10, @NonNull Transformation transformation) {
            this.f5858e = true;
            if (this.f5856c) {
                return !this.f5857d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f5856c = true;
                k0.a(this.f5854a, this);
            }
            return true;
        }

        public void run() {
            if (this.f5856c || !this.f5858e) {
                this.f5854a.endViewTransition(this.f5855b);
                this.f5857d = true;
                return;
            }
            this.f5858e = false;
            this.f5854a.post(this);
        }

        public boolean getTransformation(long j10, @NonNull Transformation transformation, float f10) {
            this.f5858e = true;
            if (this.f5856c) {
                return !this.f5857d;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f5856c = true;
                k0.a(this.f5854a, this);
            }
            return true;
        }
    }
}
