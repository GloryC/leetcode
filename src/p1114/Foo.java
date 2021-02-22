package p1114;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @author Glory
 * @date 2019/10/15 9:16
 */
public class Foo {

    public void one() { print("one"); }
    public void two() { print("two"); }
    public void three() { print("three"); }

    volatile int count = 1;

    public void first(Runnable printFirst) throws InterruptedException {


        printFirst.run();
        count++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (count!=2){
            
        }

        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
