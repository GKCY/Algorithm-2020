package concurrent.example;

public class test {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over");
    }
}
