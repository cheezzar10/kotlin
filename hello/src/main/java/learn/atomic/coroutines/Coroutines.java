package learn.atomic.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

import static java.lang.System.out;

public class Coroutines {
    public static <T> void resumeCoroutineAfterDelay(Continuation<T> continuation, long delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);

                out.println("resuming");
                continuation.resumeWith(Unit.INSTANCE);
            } catch (InterruptedException intrEx) {
                out.println("interrupted");
            }
        }).start();
    }
}
