package Projects;

import java.util.*;

class Channel {
    List<Subscriber> subs = new ArrayList<>();
    String videotitle;
    void subscribe(Subscriber sub) {
        subs.add(sub);
    }


    void unsubscribe(Subscriber sub) {
        subs.remove(sub);
    }

    void upload(String videoTitle) {
        this.videotitle = videoTitle;
        notifySubscribers();
    }

    void notifySubscribers() {
        for(Subscriber sub : subs) {
            sub.update();
        }
    }

}

class Subscriber {
    String name;
    Channel worldAffairs = new Channel();
    Subscriber(String name ){
        this.name = name;
    }

    void subscribeChannel(Channel ch) {
        worldAffairs = ch;
    }

    void update() {
        System.out.println("Hello : "+ name + ", video uploaded:  "+ worldAffairs.videotitle);
    }
}


public class YouTube {
    public static void main(String[] args) {
        Channel ch = new Channel();

        Subscriber sub1 = new Subscriber("Pratap");
        Subscriber sub2 = new Subscriber("Vedant");
        Subscriber sub3 = new Subscriber("Mahesh");
        Subscriber sub4 = new Subscriber("Parth");
        Subscriber sub5 = new Subscriber("Ayush");

        ch.subscribe(sub1);
        ch.subscribe(sub2);
        ch.subscribe(sub3);
        ch.subscribe(sub4);
        ch.subscribe(sub5);

        sub1.subscribeChannel(ch);
        sub2.subscribeChannel(ch);
        sub3.subscribeChannel(ch);
        sub4.subscribeChannel(ch);
        sub5.subscribeChannel(ch);

        // ch.unsubscribe(sub1);

        ch.upload("India - Pakistan Relation");



    }
}
