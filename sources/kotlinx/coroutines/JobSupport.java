package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.s1;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0005¢\u0001k´\u0001B\u0012\u0012\u0007\u0010±\u0001\u001a\u00020\u0015¢\u0006\u0006\b²\u0001\u0010³\u0001J#\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u00020\u0010*\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b!\u0010\u001eJ\u0019\u0010#\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b#\u0010$J1\u0010*\u001a\u00020)2\u0018\u0010'\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00100%j\u0002`&2\u0006\u0010(\u001a\u00020\u0015H\u0002¢\u0006\u0004\b*\u0010+J'\u0010.\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020)H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u000200H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020)H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0015H\u0002¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b=\u0010:J\u0019\u0010>\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0006\u001a\u00020\u0013H\u0002¢\u0006\u0004\b>\u0010?J\u001f\u0010@\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b@\u0010AJ%\u0010B\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bB\u0010CJ#\u0010D\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010\u0006\u001a\u00020\u0013H\u0002¢\u0006\u0004\bG\u0010HJ*\u0010J\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010I\u001a\u00020F2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\bJ\u0010KJ)\u0010M\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010L\u001a\u00020F2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bM\u0010NJ\u0015\u0010P\u001a\u0004\u0018\u00010F*\u00020OH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010S\u001a\u00020R2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bS\u0010TJ\u0015\u0010U\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\bU\u00108J\u0019\u0010W\u001a\u00020\u00102\b\u0010V\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\bW\u0010XJ\r\u0010Y\u001a\u00020\u0015¢\u0006\u0004\bY\u00106J\u000f\u0010Z\u001a\u00020\u0010H\u0014¢\u0006\u0004\bZ\u0010[J\u0011\u0010^\u001a\u00060\\j\u0002`]¢\u0006\u0004\b^\u0010_J#\u0010a\u001a\u00060\\j\u0002`]*\u00020\u000b2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010RH\u0004¢\u0006\u0004\ba\u0010bJ'\u0010d\u001a\u00020c2\u0018\u0010'\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00100%j\u0002`&¢\u0006\u0004\bd\u0010eJ7\u0010g\u001a\u00020c2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010f\u001a\u00020\u00152\u0018\u0010'\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00100%j\u0002`&¢\u0006\u0004\bg\u0010hJ\u0013\u0010i\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0004\bi\u00108J\u0017\u0010j\u001a\u00020\u00102\u0006\u0010-\u001a\u00020)H\u0000¢\u0006\u0004\bj\u00104J\u001f\u0010k\u001a\u00020\u00102\u000e\u0010\u001c\u001a\n\u0018\u00010\\j\u0004\u0018\u0001`]H\u0016¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020RH\u0014¢\u0006\u0004\bm\u0010nJ\u0017\u0010o\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\bo\u0010pJ\u0015\u0010r\u001a\u00020\u00102\u0006\u0010q\u001a\u00020\u0003¢\u0006\u0004\br\u0010sJ\u0017\u0010t\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\bt\u0010 J\u0017\u0010u\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bu\u0010 J\u0019\u0010v\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\bv\u0010wJ\u0013\u0010x\u001a\u00060\\j\u0002`]H\u0016¢\u0006\u0004\bx\u0010_J\u0019\u0010y\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\by\u0010wJ\u001b\u0010z\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\bz\u0010:J\u0015\u0010|\u001a\u00020{2\u0006\u0010I\u001a\u00020\u0002¢\u0006\u0004\b|\u0010}J\u0017\u0010\u001a\u00020\u00102\u0006\u0010~\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\u0010pJ\u001b\u0010\u0001\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0005\b\u0001\u0010pJ\u0019\u0010\u0001\u001a\u00020\u00152\u0006\u0010~\u001a\u00020\u000bH\u0014¢\u0006\u0005\b\u0001\u0010 J\u001c\u0010\u0001\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020RH\u0016¢\u0006\u0005\b\u0001\u0010nJ\u0011\u0010\u0001\u001a\u00020RH\u0007¢\u0006\u0005\b\u0001\u0010nJ\u0011\u0010\u0001\u001a\u00020RH\u0010¢\u0006\u0005\b\u0001\u0010nJ\u0012\u0010\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0006\b\u0001\u0010\u0001J\u0014\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u00108JY\u0010\u0001\u001a\u00020\u0010\"\u0005\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010.2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00012%\u0010\u0001\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JY\u0010\u0001\u001a\u00020\u0010\"\u0005\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010.2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00012%\u0010\u0001\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u00048BX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010<R\u0019\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u00018F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R.\u0010 \u0001\u001a\u0004\u0018\u00010{2\t\u0010\u0001\u001a\u0004\u0018\u00010{8@@@X\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048@X\u0004¢\u0006\b\u001a\u0006\b¡\u0001\u0010\u0001R\u0016\u0010£\u0001\u001a\u00020\u00158VX\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u00106R\u0013\u0010¥\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b¤\u0001\u00106R\u0013\u0010¦\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b¦\u0001\u00106R\u0016\u0010¨\u0001\u001a\u00020\u00158PX\u0004¢\u0006\u0007\u001a\u0005\b§\u0001\u00106R\u001b\u0010¬\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010©\u00018F¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0016\u0010®\u0001\u001a\u00020\u00158TX\u0004¢\u0006\u0007\u001a\u0005\b­\u0001\u00106R\u0016\u0010°\u0001\u001a\u00020\u00158PX\u0004¢\u0006\u0007\u001a\u0005\b¯\u0001\u00106\u0002\u0004\n\u0002\b\u0019¨\u0006µ\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/v;", "Lkotlinx/coroutines/g2;", "", "Lkotlinx/coroutines/JobSupport$c;", "state", "proposedUpdate", "h0", "(Lkotlinx/coroutines/JobSupport$c;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", "l0", "(Lkotlinx/coroutines/JobSupport$c;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "", "S", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/n1;", "update", "", "Z0", "(Lkotlinx/coroutines/n1;Ljava/lang/Object;)Z", "d0", "(Lkotlinx/coroutines/n1;Ljava/lang/Object;)V", "Lkotlinx/coroutines/d2;", "list", "cause", "J0", "(Lkotlinx/coroutines/d2;Ljava/lang/Throwable;)V", "a0", "(Ljava/lang/Throwable;)Z", "K0", "", "U0", "(Ljava/lang/Object;)I", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "Lkotlinx/coroutines/y1;", "G0", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/y1;", "expect", "node", "R", "(Ljava/lang/Object;Lkotlinx/coroutines/d2;Lkotlinx/coroutines/y1;)Z", "Lkotlinx/coroutines/c1;", "O0", "(Lkotlinx/coroutines/c1;)V", "P0", "(Lkotlinx/coroutines/y1;)V", "B0", "()Z", "C0", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Z", "(Ljava/lang/Object;)Ljava/lang/Object;", "g0", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "D0", "o0", "(Lkotlinx/coroutines/n1;)Lkotlinx/coroutines/d2;", "a1", "(Lkotlinx/coroutines/n1;Ljava/lang/Throwable;)Z", "b1", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "c1", "(Lkotlinx/coroutines/n1;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/u;", "i0", "(Lkotlinx/coroutines/n1;)Lkotlinx/coroutines/u;", "child", "d1", "(Lkotlinx/coroutines/JobSupport$c;Lkotlinx/coroutines/u;Ljava/lang/Object;)Z", "lastChild", "f0", "(Lkotlinx/coroutines/JobSupport$c;Lkotlinx/coroutines/u;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "I0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/u;", "", "V0", "(Ljava/lang/Object;)Ljava/lang/String;", "V", "parent", "w0", "(Lkotlinx/coroutines/s1;)V", "start", "N0", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "n", "()Ljava/util/concurrent/CancellationException;", "message", "W0", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/z0;", "y", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/z0;", "invokeImmediately", "m", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/z0;", "r0", "R0", "b", "(Ljava/util/concurrent/CancellationException;)V", "b0", "()Ljava/lang/String;", "Y", "(Ljava/lang/Throwable;)V", "parentJob", "x", "(Lkotlinx/coroutines/g2;)V", "c0", "W", "X", "(Ljava/lang/Object;)Z", "N", "E0", "F0", "Lkotlinx/coroutines/t;", "A0", "(Lkotlinx/coroutines/v;)Lkotlinx/coroutines/t;", "exception", "t0", "L0", "s0", "M0", "(Ljava/lang/Object;)V", "T", "toString", "Y0", "H0", "l", "()Ljava/lang/Throwable;", "j0", "()Ljava/lang/Object;", "U", "Lkotlinx/coroutines/selects/d;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "block", "Q0", "(Lkotlinx/coroutines/selects/d;Lkotlin/jvm/functions/Function2;)V", "S0", "k0", "exceptionOrNull", "Lkotlin/coroutines/CoroutineContext$a;", "getKey", "()Lkotlin/coroutines/CoroutineContext$a;", "key", "value", "p0", "()Lkotlinx/coroutines/t;", "T0", "(Lkotlinx/coroutines/t;)V", "parentHandle", "q0", "a", "isActive", "y0", "isCompleted", "isCancelled", "n0", "onCancelComplete", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "z0", "isScopedCoroutine", "m0", "handlesException", "active", "<init>", "(Z)V", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class JobSupport implements s1, v, g2 {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32257a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/JobSupport$a;", "T", "Lkotlinx/coroutines/o;", "Lkotlinx/coroutines/s1;", "parent", "", "u", "", "G", "Lkotlinx/coroutines/JobSupport;", "j", "Lkotlinx/coroutines/JobSupport;", "job", "Lkotlin/coroutines/c;", "delegate", "<init>", "(Lkotlin/coroutines/c;Lkotlinx/coroutines/JobSupport;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class a<T> extends o<T> {

        /* renamed from: j  reason: collision with root package name */
        private final JobSupport f32258j;

        public a(kotlin.coroutines.c<? super T> cVar, JobSupport jobSupport) {
            super(cVar, 1);
            this.f32258j = jobSupport;
        }

        /* access modifiers changed from: protected */
        public String G() {
            return "AwaitContinuation";
        }

        public Throwable u(s1 s1Var) {
            Throwable e10;
            Object q02 = this.f32258j.q0();
            if ((q02 instanceof c) && (e10 = ((c) q02).e()) != null) {
                return e10;
            }
            if (q02 instanceof b0) {
                return ((b0) q02).f32285a;
            }
            return s1Var.n();
        }
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/JobSupport$b;", "Lkotlinx/coroutines/y1;", "", "cause", "", "X", "Lkotlinx/coroutines/JobSupport;", "e", "Lkotlinx/coroutines/JobSupport;", "parent", "Lkotlinx/coroutines/JobSupport$c;", "f", "Lkotlinx/coroutines/JobSupport$c;", "state", "Lkotlinx/coroutines/u;", "g", "Lkotlinx/coroutines/u;", "child", "", "h", "Ljava/lang/Object;", "proposedUpdate", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$c;Lkotlinx/coroutines/u;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class b extends y1 {

        /* renamed from: e  reason: collision with root package name */
        private final JobSupport f32259e;

        /* renamed from: f  reason: collision with root package name */
        private final c f32260f;

        /* renamed from: g  reason: collision with root package name */
        private final u f32261g;

        /* renamed from: h  reason: collision with root package name */
        private final Object f32262h;

        public b(JobSupport jobSupport, c cVar, u uVar, Object obj) {
            this.f32259e = jobSupport;
            this.f32260f = cVar;
            this.f32261g = uVar;
            this.f32262h = obj;
        }

        public void X(Throwable th2) {
            this.f32259e.f0(this.f32260f, this.f32261g, this.f32262h);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            X((Throwable) obj);
            return Unit.f32013a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010%\u001a\u00020 \u0012\b\u0010)\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b/\u00100J\u001f\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u00018B@BX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020 8F@FX\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u0010R\u0011\u0010+\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b*\u0010\"R\u0011\u0010-\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b,\u0010\"R\u0014\u0010.\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\"¨\u00061"}, d2 = {"Lkotlinx/coroutines/JobSupport$c;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/n1;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "c", "()Ljava/util/ArrayList;", "proposedException", "", "j", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "", "b", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/d2;", "a", "Lkotlinx/coroutines/d2;", "f", "()Lkotlinx/coroutines/d2;", "list", "value", "d", "()Ljava/lang/Object;", "l", "(Ljava/lang/Object;)V", "exceptionsHolder", "", "h", "()Z", "k", "(Z)V", "isCompleting", "e", "()Ljava/lang/Throwable;", "m", "rootCause", "i", "isSealed", "g", "isCancelling", "isActive", "<init>", "(Lkotlinx/coroutines/d2;ZLjava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class c implements n1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: a  reason: collision with root package name */
        private final d2 f32263a;

        public c(d2 d2Var, boolean z10, Throwable th2) {
            this.f32263a = d2Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th2;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        public boolean a() {
            return e() == null;
        }

        public final void b(Throwable th2) {
            Throwable e10 = e();
            if (e10 == null) {
                m(th2);
            } else if (th2 != e10) {
                Object d10 = d();
                if (d10 == null) {
                    l(th2);
                } else if (d10 instanceof Throwable) {
                    if (th2 != d10) {
                        ArrayList<Throwable> c10 = c();
                        c10.add(d10);
                        c10.add(th2);
                        l(c10);
                    }
                } else if (d10 instanceof ArrayList) {
                    ((ArrayList) d10).add(th2);
                } else {
                    throw new IllegalStateException(("State is " + d10).toString());
                }
            }
        }

        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public d2 f() {
            return this.f32263a;
        }

        public final boolean g() {
            return e() != null;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
        public final boolean h() {
            return this._isCompleting;
        }

        public final boolean i() {
            return d() == z1.f32745e;
        }

        public final List<Throwable> j(Throwable th2) {
            ArrayList<Throwable> arrayList;
            Object d10 = d();
            if (d10 == null) {
                arrayList = c();
            } else if (d10 instanceof Throwable) {
                ArrayList<Throwable> c10 = c();
                c10.add(d10);
                arrayList = c10;
            } else if (d10 instanceof ArrayList) {
                arrayList = (ArrayList) d10;
            } else {
                throw new IllegalStateException(("State is " + d10).toString());
            }
            Throwable e10 = e();
            if (e10 != null) {
                arrayList.add(0, e10);
            }
            if (th2 != null && !j.b(th2, e10)) {
                arrayList.add(th2);
            }
            l(z1.f32745e);
            return arrayList;
        }

        public final void k(boolean z10) {
            this._isCompleting = z10 ? 1 : 0;
        }

        public final void m(Throwable th2) {
            this._rootCause = th2;
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + f() + PropertyUtils.INDEXED_DELIM2;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/JobSupport$d", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class d extends LockFreeLinkedListNode.b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JobSupport f32264d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f32265e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(LockFreeLinkedListNode lockFreeLinkedListNode, JobSupport jobSupport, Object obj) {
            super(lockFreeLinkedListNode);
            this.f32264d = jobSupport;
            this.f32265e = obj;
        }

        /* renamed from: k */
        public Object i(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f32264d.q0() == this.f32265e) {
                return null;
            }
            return q.a();
        }
    }

    public JobSupport(boolean z10) {
        c1 c1Var;
        if (z10) {
            c1Var = z1.f32747g;
        } else {
            c1Var = z1.f32746f;
        }
        this._state = c1Var;
        this._parentHandle = null;
    }

    private final boolean B0() {
        Object q02;
        do {
            q02 = q0();
            if (!(q02 instanceof n1)) {
                return false;
            }
        } while (U0(q02) < 0);
        return true;
    }

    private final Object C0(kotlin.coroutines.c<? super Unit> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.y();
        q.a(oVar, y(new j2(oVar)));
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        if (v10 == b.d()) {
            return v10;
        }
        return Unit.f32013a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        J0(((kotlinx.coroutines.JobSupport.c) r2).f(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        return kotlinx.coroutines.z1.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object D0(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.q0()
            boolean r3 = r2 instanceof kotlinx.coroutines.JobSupport.c
            if (r3 == 0) goto L_0x0051
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.JobSupport$c r3 = (kotlinx.coroutines.JobSupport.c) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.i()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x001a
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.z1.f32744d     // Catch:{ all -> 0x004e }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r3 = r2
            kotlinx.coroutines.JobSupport$c r3 = (kotlinx.coroutines.JobSupport.c) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.g()     // Catch:{ all -> 0x004e }
            if (r7 != 0) goto L_0x0025
            if (r3 != 0) goto L_0x0031
        L_0x0025:
            if (r1 != 0) goto L_0x002b
            java.lang.Throwable r1 = r6.g0(r7)     // Catch:{ all -> 0x004e }
        L_0x002b:
            r7 = r2
            kotlinx.coroutines.JobSupport$c r7 = (kotlinx.coroutines.JobSupport.c) r7     // Catch:{ all -> 0x004e }
            r7.b(r1)     // Catch:{ all -> 0x004e }
        L_0x0031:
            r7 = r2
            kotlinx.coroutines.JobSupport$c r7 = (kotlinx.coroutines.JobSupport.c) r7     // Catch:{ all -> 0x004e }
            java.lang.Throwable r7 = r7.e()     // Catch:{ all -> 0x004e }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003d
            r0 = r7
        L_0x003d:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0049
            kotlinx.coroutines.JobSupport$c r2 = (kotlinx.coroutines.JobSupport.c) r2
            kotlinx.coroutines.d2 r7 = r2.f()
            r6.J0(r7, r0)
        L_0x0049:
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.z1.f32741a
            return r7
        L_0x004e:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L_0x0051:
            boolean r3 = r2 instanceof kotlinx.coroutines.n1
            if (r3 == 0) goto L_0x00a2
            if (r1 != 0) goto L_0x005b
            java.lang.Throwable r1 = r6.g0(r7)
        L_0x005b:
            r3 = r2
            kotlinx.coroutines.n1 r3 = (kotlinx.coroutines.n1) r3
            boolean r4 = r3.a()
            if (r4 == 0) goto L_0x006f
            boolean r2 = r6.a1(r3, r1)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.z1.f32741a
            return r7
        L_0x006f:
            kotlinx.coroutines.b0 r3 = new kotlinx.coroutines.b0
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.b1(r2, r3)
            kotlinx.coroutines.internal.f0 r4 = kotlinx.coroutines.z1.f32741a
            if (r3 == r4) goto L_0x0087
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.z1.f32743c
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0087:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot happen in "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a2:
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.z1.f32744d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.D0(java.lang.Object):java.lang.Object");
    }

    private final y1 G0(Function1<? super Throwable, Unit> function1, boolean z10) {
        y1 y1Var = null;
        if (z10) {
            if (function1 instanceof t1) {
                y1Var = (t1) function1;
            }
            if (y1Var == null) {
                y1Var = new q1(function1);
            }
        } else {
            if (function1 instanceof y1) {
                y1Var = (y1) function1;
            }
            if (y1Var == null) {
                y1Var = new r1(function1);
            }
        }
        y1Var.Z(this);
        return y1Var;
    }

    private final u I0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.R()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.O();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.N();
            if (!lockFreeLinkedListNode.R()) {
                if (lockFreeLinkedListNode instanceof u) {
                    return (u) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof d2) {
                    return null;
                }
            }
        }
    }

    private final void J0(d2 d2Var, Throwable th2) {
        L0(th2);
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) d2Var.L(); !j.b(lockFreeLinkedListNode, d2Var); lockFreeLinkedListNode = lockFreeLinkedListNode.N()) {
            if (lockFreeLinkedListNode instanceof t1) {
                y1 y1Var = (y1) lockFreeLinkedListNode;
                try {
                    y1Var.X(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        b.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + y1Var + " for " + this, th3);
                        Unit unit = Unit.f32013a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            t0(completionHandlerException);
        }
        a0(th2);
    }

    private final void K0(d2 d2Var, Throwable th2) {
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) d2Var.L(); !j.b(lockFreeLinkedListNode, d2Var); lockFreeLinkedListNode = lockFreeLinkedListNode.N()) {
            if (lockFreeLinkedListNode instanceof y1) {
                y1 y1Var = (y1) lockFreeLinkedListNode;
                try {
                    y1Var.X(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        b.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + y1Var + " for " + this, th3);
                        Unit unit = Unit.f32013a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            t0(completionHandlerException);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlinx.coroutines.m1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void O0(kotlinx.coroutines.c1 r3) {
        /*
            r2 = this;
            kotlinx.coroutines.d2 r0 = new kotlinx.coroutines.d2
            r0.<init>()
            boolean r1 = r3.a()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            kotlinx.coroutines.m1 r1 = new kotlinx.coroutines.m1
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f32257a
            androidx.concurrent.futures.a.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.O0(kotlinx.coroutines.c1):void");
    }

    private final void P0(y1 y1Var) {
        y1Var.H(new d2());
        androidx.concurrent.futures.a.a(f32257a, this, y1Var, y1Var.N());
    }

    private final boolean R(Object obj, d2 d2Var, y1 y1Var) {
        int W;
        d dVar = new d(y1Var, this, obj);
        do {
            W = d2Var.O().W(y1Var, d2Var, dVar);
            if (W == 1) {
                return true;
            }
        } while (W != 2);
        return false;
    }

    private final void S(Throwable th2, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            for (Throwable th3 : list) {
                if (th3 != th2 && th3 != th2 && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                    b.a(th2, th3);
                }
            }
        }
    }

    private final int U0(Object obj) {
        if (obj instanceof c1) {
            if (((c1) obj).a()) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(f32257a, this, obj, z1.f32747g)) {
                return -1;
            }
            N0();
            return 1;
        } else if (!(obj instanceof m1)) {
            return 0;
        } else {
            if (!androidx.concurrent.futures.a.a(f32257a, this, obj, ((m1) obj).f())) {
                return -1;
            }
            N0();
            return 1;
        }
    }

    private final Object V(kotlin.coroutines.c<Object> cVar) {
        a aVar = new a(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), this);
        aVar.y();
        q.a(aVar, y(new i2(aVar)));
        Object v10 = aVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        return v10;
    }

    private final String V0(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.g()) {
                return "Cancelling";
            }
            if (cVar.h()) {
                return "Completing";
            }
            return "Active";
        } else if (obj instanceof n1) {
            if (((n1) obj).a()) {
                return "Active";
            }
            return "New";
        } else if (obj instanceof b0) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        } else {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        }
    }

    public static /* synthetic */ CancellationException X0(JobSupport jobSupport, Throwable th2, String str, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                str = null;
            }
            return jobSupport.W0(th2, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final Object Z(Object obj) {
        Object b12;
        do {
            Object q02 = q0();
            if (!(q02 instanceof n1) || ((q02 instanceof c) && ((c) q02).h())) {
                return z1.f32741a;
            }
            b12 = b1(q02, new b0(g0(obj), false, 2, (DefaultConstructorMarker) null));
        } while (b12 == z1.f32743c);
        return b12;
    }

    private final boolean Z0(n1 n1Var, Object obj) {
        if (!androidx.concurrent.futures.a.a(f32257a, this, n1Var, z1.g(obj))) {
            return false;
        }
        L0((Throwable) null);
        M0(obj);
        d0(n1Var, obj);
        return true;
    }

    private final boolean a0(Throwable th2) {
        if (z0()) {
            return true;
        }
        boolean z10 = th2 instanceof CancellationException;
        t p02 = p0();
        if (p02 == null || p02 == e2.f32353a) {
            return z10;
        }
        if (p02.e(th2) || z10) {
            return true;
        }
        return false;
    }

    private final boolean a1(n1 n1Var, Throwable th2) {
        d2 o02 = o0(n1Var);
        if (o02 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(f32257a, this, n1Var, new c(o02, false, th2))) {
            return false;
        }
        J0(o02, th2);
        return true;
    }

    private final Object b1(Object obj, Object obj2) {
        if (!(obj instanceof n1)) {
            return z1.f32741a;
        }
        if ((!(obj instanceof c1) && !(obj instanceof y1)) || (obj instanceof u) || (obj2 instanceof b0)) {
            return c1((n1) obj, obj2);
        }
        if (Z0((n1) obj, obj2)) {
            return obj2;
        }
        return z1.f32743c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        r3 = (java.lang.Throwable) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0071, code lost:
        if (r2 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0073, code lost:
        J0(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0076, code lost:
        r9 = i0(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007a, code lost:
        if (r9 == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0080, code lost:
        if (d1(r1, r9, r10) == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0084, code lost:
        return kotlinx.coroutines.z1.f32742b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0089, code lost:
        return h0(r1, r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object c1(kotlinx.coroutines.n1 r9, java.lang.Object r10) {
        /*
            r8 = this;
            kotlinx.coroutines.d2 r0 = r8.o0(r9)
            if (r0 != 0) goto L_0x000b
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.z1.f32743c
            return r9
        L_0x000b:
            boolean r1 = r9 instanceof kotlinx.coroutines.JobSupport.c
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r9
            kotlinx.coroutines.JobSupport$c r1 = (kotlinx.coroutines.JobSupport.c) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            kotlinx.coroutines.JobSupport$c r1 = new kotlinx.coroutines.JobSupport$c
            r1.<init>(r0, r3, r2)
        L_0x001d:
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            monitor-enter(r1)
            boolean r5 = r1.h()     // Catch:{ all -> 0x008a }
            if (r5 == 0) goto L_0x002f
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.z1.f32741a     // Catch:{ all -> 0x008a }
            monitor-exit(r1)
            return r9
        L_0x002f:
            r5 = 1
            r1.k(r5)     // Catch:{ all -> 0x008a }
            if (r1 == r9) goto L_0x0043
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = f32257a     // Catch:{ all -> 0x008a }
            boolean r6 = androidx.concurrent.futures.a.a(r6, r8, r9, r1)     // Catch:{ all -> 0x008a }
            if (r6 != 0) goto L_0x0043
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.z1.f32743c     // Catch:{ all -> 0x008a }
            monitor-exit(r1)
            return r9
        L_0x0043:
            boolean r6 = r1.g()     // Catch:{ all -> 0x008a }
            boolean r7 = r10 instanceof kotlinx.coroutines.b0     // Catch:{ all -> 0x008a }
            if (r7 == 0) goto L_0x004f
            r7 = r10
            kotlinx.coroutines.b0 r7 = (kotlinx.coroutines.b0) r7     // Catch:{ all -> 0x008a }
            goto L_0x0050
        L_0x004f:
            r7 = r2
        L_0x0050:
            if (r7 == 0) goto L_0x0057
            java.lang.Throwable r7 = r7.f32285a     // Catch:{ all -> 0x008a }
            r1.b(r7)     // Catch:{ all -> 0x008a }
        L_0x0057:
            java.lang.Throwable r7 = r1.e()     // Catch:{ all -> 0x008a }
            if (r6 != 0) goto L_0x005e
            r3 = r5
        L_0x005e:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x008a }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x0069
            r2 = r7
        L_0x0069:
            r4.element = r2     // Catch:{ all -> 0x008a }
            kotlin.Unit r3 = kotlin.Unit.f32013a     // Catch:{ all -> 0x008a }
            monitor-exit(r1)
            r3 = r2
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            if (r2 == 0) goto L_0x0076
            r8.J0(r0, r2)
        L_0x0076:
            kotlinx.coroutines.u r9 = r8.i0(r9)
            if (r9 == 0) goto L_0x0085
            boolean r9 = r8.d1(r1, r9, r10)
            if (r9 == 0) goto L_0x0085
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.z1.f32742b
            return r9
        L_0x0085:
            java.lang.Object r9 = r8.h0(r1, r10)
            return r9
        L_0x008a:
            r9 = move-exception
            monitor-exit(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.c1(kotlinx.coroutines.n1, java.lang.Object):java.lang.Object");
    }

    private final void d0(n1 n1Var, Object obj) {
        b0 b0Var;
        t p02 = p0();
        if (p02 != null) {
            p02.dispose();
            T0(e2.f32353a);
        }
        Throwable th2 = null;
        if (obj instanceof b0) {
            b0Var = (b0) obj;
        } else {
            b0Var = null;
        }
        if (b0Var != null) {
            th2 = b0Var.f32285a;
        }
        if (n1Var instanceof y1) {
            try {
                ((y1) n1Var).X(th2);
            } catch (Throwable th3) {
                t0(new CompletionHandlerException("Exception in completion handler " + n1Var + " for " + this, th3));
            }
        } else {
            d2 f10 = n1Var.f();
            if (f10 != null) {
                K0(f10, th2);
            }
        }
    }

    private final boolean d1(c cVar, u uVar, Object obj) {
        while (s1.a.d(uVar.f32727e, false, false, new b(this, cVar, uVar, obj), 1, (Object) null) == e2.f32353a) {
            uVar = I0(uVar);
            if (uVar == null) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void f0(c cVar, u uVar, Object obj) {
        u I0 = I0(uVar);
        if (I0 == null || !d1(cVar, I0, obj)) {
            T(h0(cVar, obj));
        }
    }

    private final Throwable g0(Object obj) {
        boolean z10;
        if (obj == null) {
            z10 = true;
        } else {
            z10 = obj instanceof Throwable;
        }
        if (z10) {
            Throwable th2 = (Throwable) obj;
            if (th2 == null) {
                return new JobCancellationException(b0(), (Throwable) null, this);
            }
            return th2;
        } else if (obj != null) {
            return ((g2) obj).N();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    private final Object h0(c cVar, Object obj) {
        b0 b0Var;
        Throwable th2;
        boolean g10;
        Throwable l02;
        if (obj instanceof b0) {
            b0Var = (b0) obj;
        } else {
            b0Var = null;
        }
        if (b0Var != null) {
            th2 = b0Var.f32285a;
        } else {
            th2 = null;
        }
        synchronized (cVar) {
            g10 = cVar.g();
            List<Throwable> j10 = cVar.j(th2);
            l02 = l0(cVar, j10);
            if (l02 != null) {
                S(l02, j10);
            }
        }
        boolean z10 = false;
        if (!(l02 == null || l02 == th2)) {
            obj = new b0(l02, false, 2, (DefaultConstructorMarker) null);
        }
        if (l02 != null) {
            if (a0(l02) || s0(l02)) {
                z10 = true;
            }
            if (z10) {
                if (obj != null) {
                    ((b0) obj).b();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
            }
        }
        if (!g10) {
            L0(l02);
        }
        M0(obj);
        androidx.concurrent.futures.a.a(f32257a, this, cVar, z1.g(obj));
        d0(cVar, obj);
        return obj;
    }

    private final u i0(n1 n1Var) {
        u uVar = n1Var instanceof u ? (u) n1Var : null;
        if (uVar != null) {
            return uVar;
        }
        d2 f10 = n1Var.f();
        if (f10 != null) {
            return I0(f10);
        }
        return null;
    }

    private final Throwable k0(Object obj) {
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        if (b0Var != null) {
            return b0Var.f32285a;
        }
        return null;
    }

    private final Throwable l0(c cVar, List<? extends Throwable> list) {
        T t10;
        boolean z10;
        T t11 = null;
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t10 = null;
                    break;
                }
                t10 = it.next();
                if (!(((Throwable) t10) instanceof CancellationException)) {
                    break;
                }
            }
            Throwable th2 = (Throwable) t10;
            if (th2 != null) {
                return th2;
            }
            Throwable th3 = (Throwable) list.get(0);
            if (th3 instanceof TimeoutCancellationException) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    Throwable th4 = (Throwable) next;
                    if (th4 == th3 || !(th4 instanceof TimeoutCancellationException)) {
                        z10 = false;
                        continue;
                    } else {
                        z10 = true;
                        continue;
                    }
                    if (z10) {
                        t11 = next;
                        break;
                    }
                }
                Throwable th5 = (Throwable) t11;
                if (th5 != null) {
                    return th5;
                }
            }
            return th3;
        } else if (cVar.g()) {
            return new JobCancellationException(b0(), (Throwable) null, this);
        } else {
            return null;
        }
    }

    private final d2 o0(n1 n1Var) {
        d2 f10 = n1Var.f();
        if (f10 != null) {
            return f10;
        }
        if (n1Var instanceof c1) {
            return new d2();
        }
        if (n1Var instanceof y1) {
            P0((y1) n1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + n1Var).toString());
    }

    public final t A0(v vVar) {
        return (t) s1.a.d(this, true, false, new u(vVar), 2, (Object) null);
    }

    public final boolean E0(Object obj) {
        Object b12;
        do {
            b12 = b1(q0(), obj);
            if (b12 == z1.f32741a) {
                return false;
            }
            if (b12 == z1.f32742b) {
                return true;
            }
        } while (b12 == z1.f32743c);
        T(b12);
        return true;
    }

    public final Object F0(Object obj) {
        Object b12;
        do {
            b12 = b1(q0(), obj);
            if (b12 == z1.f32741a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, k0(obj));
            }
        } while (b12 == z1.f32743c);
        return b12;
    }

    public String H0() {
        return m0.a(this);
    }

    /* access modifiers changed from: protected */
    public void L0(Throwable th2) {
    }

    /* access modifiers changed from: protected */
    public void M0(Object obj) {
    }

    public CancellationException N() {
        Throwable th2;
        Object q02 = q0();
        CancellationException cancellationException = null;
        if (q02 instanceof c) {
            th2 = ((c) q02).e();
        } else if (q02 instanceof b0) {
            th2 = ((b0) q02).f32285a;
        } else if (!(q02 instanceof n1)) {
            th2 = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + q02).toString());
        }
        if (th2 instanceof CancellationException) {
            cancellationException = (CancellationException) th2;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + V0(q02), th2, this);
    }

    /* access modifiers changed from: protected */
    public void N0() {
    }

    public final <T, R> void Q0(kotlinx.coroutines.selects.d<? super R> dVar, Function2<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2) {
        Object q02;
        do {
            q02 = q0();
            if (!dVar.h()) {
                if (!(q02 instanceof n1)) {
                    if (!dVar.n()) {
                        return;
                    }
                    if (q02 instanceof b0) {
                        dVar.u(((b0) q02).f32285a);
                        return;
                    } else {
                        zk.b.c(function2, z1.h(q02), dVar.s());
                        return;
                    }
                }
            } else {
                return;
            }
        } while (U0(q02) != 0);
        dVar.k(y(new l2(dVar, function2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void R0(kotlinx.coroutines.y1 r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.q0()
            boolean r1 = r0 instanceof kotlinx.coroutines.y1
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f32257a
            kotlinx.coroutines.c1 r2 = kotlinx.coroutines.z1.f32747g
            boolean r0 = androidx.concurrent.futures.a.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.n1
            if (r1 == 0) goto L_0x0027
            kotlinx.coroutines.n1 r0 = (kotlinx.coroutines.n1) r0
            kotlinx.coroutines.d2 r0 = r0.f()
            if (r0 == 0) goto L_0x0027
            r4.S()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.R0(kotlinx.coroutines.y1):void");
    }

    public final <T, R> void S0(kotlinx.coroutines.selects.d<? super R> dVar, Function2<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2) {
        Object q02 = q0();
        if (q02 instanceof b0) {
            dVar.u(((b0) q02).f32285a);
            return;
        }
        zk.a.e(function2, z1.h(q02), dVar.s(), (Function1) null, 4, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void T(Object obj) {
    }

    public final void T0(t tVar) {
        this._parentHandle = tVar;
    }

    public final Object U(kotlin.coroutines.c<Object> cVar) {
        Object q02;
        do {
            q02 = q0();
            if (!(q02 instanceof n1)) {
                if (!(q02 instanceof b0)) {
                    return z1.h(q02);
                }
                throw ((b0) q02).f32285a;
            }
        } while (U0(q02) < 0);
        return V(cVar);
    }

    public final boolean W(Throwable th2) {
        return X(th2);
    }

    /* access modifiers changed from: protected */
    public final CancellationException W0(Throwable th2, String str) {
        CancellationException cancellationException;
        if (th2 instanceof CancellationException) {
            cancellationException = (CancellationException) th2;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = b0();
            }
            cancellationException = new JobCancellationException(str, th2, this);
        }
        return cancellationException;
    }

    public final boolean X(Object obj) {
        Object a10 = z1.f32741a;
        if (n0() && (a10 = Z(obj)) == z1.f32742b) {
            return true;
        }
        if (a10 == z1.f32741a) {
            a10 = D0(obj);
        }
        if (a10 == z1.f32741a || a10 == z1.f32742b) {
            return true;
        }
        if (a10 == z1.f32744d) {
            return false;
        }
        T(a10);
        return true;
    }

    public void Y(Throwable th2) {
        X(th2);
    }

    public final String Y0() {
        return H0() + '{' + V0(q0()) + '}';
    }

    public boolean a() {
        Object q02 = q0();
        if (!(q02 instanceof n1) || !((n1) q02).a()) {
            return false;
        }
        return true;
    }

    public void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(b0(), (Throwable) null, this);
        }
        Y(cancellationException);
    }

    /* access modifiers changed from: protected */
    public String b0() {
        return "Job was cancelled";
    }

    public <E extends CoroutineContext.Element> E c(CoroutineContext.a<E> aVar) {
        return s1.a.c(this, aVar);
    }

    public boolean c0(Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        if (!X(th2) || !m0()) {
            return false;
        }
        return true;
    }

    public CoroutineContext e0(CoroutineContext coroutineContext) {
        return s1.a.f(this, coroutineContext);
    }

    public final Sequence<s1> getChildren() {
        return j.b(new JobSupport$children$1(this, (kotlin.coroutines.c<? super JobSupport$children$1>) null));
    }

    public final CoroutineContext.a<?> getKey() {
        return s1.f32618v;
    }

    public final boolean isCancelled() {
        Object q02 = q0();
        if ((q02 instanceof b0) || ((q02 instanceof c) && ((c) q02).g())) {
            return true;
        }
        return false;
    }

    public final Object j0() {
        Object q02 = q0();
        if (!(!(q02 instanceof n1))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(q02 instanceof b0)) {
            return z1.h(q02);
        } else {
            throw ((b0) q02).f32285a;
        }
    }

    public final Throwable l() {
        Object q02 = q0();
        if (!(q02 instanceof n1)) {
            return k0(q02);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final z0 m(boolean z10, boolean z11, Function1<? super Throwable, Unit> function1) {
        b0 b0Var;
        y1 G0 = G0(function1, z10);
        while (true) {
            Object q02 = q0();
            if (q02 instanceof c1) {
                c1 c1Var = (c1) q02;
                if (!c1Var.a()) {
                    O0(c1Var);
                } else if (androidx.concurrent.futures.a.a(f32257a, this, q02, G0)) {
                    return G0;
                }
            } else {
                Throwable th2 = null;
                if (q02 instanceof n1) {
                    d2 f10 = ((n1) q02).f();
                    if (f10 != null) {
                        z0 z0Var = e2.f32353a;
                        if (z10 && (q02 instanceof c)) {
                            synchronized (q02) {
                                th2 = ((c) q02).e();
                                if (th2 == null || ((function1 instanceof u) && !((c) q02).h())) {
                                    if (R(q02, f10, G0)) {
                                        if (th2 == null) {
                                            return G0;
                                        }
                                        z0Var = G0;
                                    }
                                }
                                Unit unit = Unit.f32013a;
                            }
                        }
                        if (th2 != null) {
                            if (z11) {
                                function1.invoke(th2);
                            }
                            return z0Var;
                        } else if (R(q02, f10, G0)) {
                            return G0;
                        }
                    } else if (q02 != null) {
                        P0((y1) q02);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                } else {
                    if (z11) {
                        if (q02 instanceof b0) {
                            b0Var = (b0) q02;
                        } else {
                            b0Var = null;
                        }
                        if (b0Var != null) {
                            th2 = b0Var.f32285a;
                        }
                        function1.invoke(th2);
                    }
                    return e2.f32353a;
                }
            }
        }
    }

    public boolean m0() {
        return true;
    }

    public final CancellationException n() {
        Object q02 = q0();
        if (q02 instanceof c) {
            Throwable e10 = ((c) q02).e();
            if (e10 != null) {
                CancellationException W0 = W0(e10, m0.a(this) + " is cancelling");
                if (W0 != null) {
                    return W0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (q02 instanceof n1) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (q02 instanceof b0) {
            return X0(this, ((b0) q02).f32285a, (String) null, 1, (Object) null);
        } else {
            return new JobCancellationException(m0.a(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public boolean n0() {
        return false;
    }

    public final t p0() {
        return (t) this._parentHandle;
    }

    public final Object q0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof y)) {
                return obj;
            }
            ((y) obj).c(this);
        }
    }

    public final Object r0(kotlin.coroutines.c<? super Unit> cVar) {
        if (!B0()) {
            v1.i(cVar.getContext());
            return Unit.f32013a;
        }
        Object C0 = C0(cVar);
        if (C0 == b.d()) {
            return C0;
        }
        return Unit.f32013a;
    }

    /* access modifiers changed from: protected */
    public boolean s0(Throwable th2) {
        return false;
    }

    public final boolean start() {
        int U0;
        do {
            U0 = U0(q0());
            if (U0 == 0) {
                return false;
            }
        } while (U0 != 1);
        return true;
    }

    public void t0(Throwable th2) {
        throw th2;
    }

    public String toString() {
        return Y0() + '@' + m0.b(this);
    }

    public CoroutineContext u0(CoroutineContext.a<?> aVar) {
        return s1.a.e(this, aVar);
    }

    public <R> R v0(R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return s1.a.b(this, r10, function2);
    }

    /* access modifiers changed from: protected */
    public final void w0(s1 s1Var) {
        if (s1Var == null) {
            T0(e2.f32353a);
            return;
        }
        s1Var.start();
        t A0 = s1Var.A0(this);
        T0(A0);
        if (y0()) {
            A0.dispose();
            T0(e2.f32353a);
        }
    }

    public final void x(g2 g2Var) {
        X(g2Var);
    }

    public final z0 y(Function1<? super Throwable, Unit> function1) {
        return m(false, true, function1);
    }

    public final boolean y0() {
        return !(q0() instanceof n1);
    }

    /* access modifiers changed from: protected */
    public boolean z0() {
        return false;
    }
}
