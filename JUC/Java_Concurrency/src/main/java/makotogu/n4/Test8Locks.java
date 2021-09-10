package makotogu.n4;

import lombok.extern.slf4j.Slf4j;

import static makotogu.n2.util.Sleeper.sleep;

@Slf4j(topic = "c.Test8Lock")
public class Test8Locks {
    public static void main(String[] args) {
        Number n1 = new Number();
        Number n2 = new Number();
        new Thread(() -> {
            log.debug("begin");
            n1.a();
        }).start();
        new Thread(() -> {
            log.debug("begin");
            n2.b();
        }).start();
//        new Thread(() -> {
//            log.debug("begin");
//            n1.c();
//        }).start();
    }
}

/**
 * 第一种的Number类 锁方法，同一个对象this
 */
/*@Slf4j(topic = "c.Number")
class Number {
    public synchronized void a() {
        log.debug("1");
    }
    public synchronized void b() {
        log.debug("2");
    }
}*/

/**
 * 和第一种相比多了一个sleep方法
 * sleep不解除锁
 */
/*
@Slf4j(topic = "c.Number2")
class Number {
    public synchronized void a() {
        sleep(1);
        log.debug("1");
    }
    public synchronized void b() {
        log.debug("2");
    }
}
*/

/**
 * 增加一个 c方法 不加锁
 * 没有互斥效果，并行执行
 * 1不可能最先 有1s的sleep
 */
/*
@Slf4j(topic = "c.Number3")
class Number {
    public synchronized void a() {
        sleep(1);
        log.debug("1");
    }
    public synchronized void b() {
        log.debug("2");
    }
    public void c() {
        log.debug("3");
    }
}*/

/**
 * main方法改动有两个对象 n1调用a n2调用b
 * 不是同一个对象，所以不会互斥，2总是先于1打印
 */
/*@Slf4j(topic = "c.Number4")
class Number {
    public synchronized void a() {
        sleep(1);
        log.debug("1");
    }
    public synchronized void b() {
        log.debug("2");
    }
}*/

/**
 * 一个静态锁，一个普通方法的锁，对象不同
 * 打印情况和4一样
 */
/*
@Slf4j(topic = "c.Number5")
class Number {
    public synchronized static void a() {
        sleep(1);
        log.debug("1");
    }
    public synchronized void b() {
        log.debug("2");
    }
}*/

/**
 * 两个都是static情况
 * 和情况2一样打印
 */
/*
@Slf4j(topic = "c.Number6")
class Number {
    public synchronized static void a() {
        sleep(1);
        log.debug("1");
    }
    public synchronized static void b() {
        log.debug("2");
    }
}*/

/**
 * 使用n1和n2调用方法
 */
/*@Slf4j(topic = "c.Number7")
class Number {
    public synchronized void a() {
        sleep(1);
        log.debug("1");
    }
    public synchronized static void b() {
        log.debug("2");
    }
}*/

/**
 * n1 n2调用静态 走Number.class
 */
@Slf4j(topic = "c.Number8")
class Number {
    public synchronized static void a() {
        sleep(1);
        log.debug("1");
    }
    public synchronized static void b() {
        log.debug("2");
    }
}