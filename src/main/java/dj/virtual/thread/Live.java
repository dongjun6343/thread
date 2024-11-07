package dj.virtual.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Live {

    private static final Runnable runnable = new Runnable() {

        @Override
        public void run() {
            log.info("1) run. thread: {}", Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("2) run. thread: {}", Thread.currentThread());
        }
    };

    public static void main(String[] args) throws InterruptedException {
        // 일반 쓰레드 사용
        // new Thread(runnable).start();

        // log
        //16:04:40.793 [Thread-0] INFO dj.virtual.thread.Live -- 1) run. thread: Thread[#20,Thread-0,5,main]
        //16:04:41.796 [Thread-0] INFO dj.virtual.thread.Live -- 2) run. thread: Thread[#20,Thread-0,5,main]

        Thread myVirtual = Thread.ofVirtual().name("myVirtual").start(runnable);

        // [정리] virtual thread는 데몬쓰레드다.
        myVirtual.join();
        // log => ForkJoinPool(데몬쓰레드) -> 자바는 데몬쓰레드만 있으면 죽는다. -> join 사용
        //16:06:00.395 [myVirtual] INFO dj.virtual.thread.Live -- 1) run. thread: VirtualThread[#20,myVirtual]/runnable@ForkJoinPool-1-worker-1
        //16:06:01.399 [myVirtual] INFO dj.virtual.thread.Live -- 2) run. thread: VirtualThread[#20,myVirtual]/runnable@ForkJoinPool-1-worker-1
    }

}
