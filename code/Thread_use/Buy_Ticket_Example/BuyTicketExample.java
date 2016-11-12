package Thread_use.Buy_Ticket_Example;
/**
 * Created by john on 2016/7/2.
 * a simple class
 */
public class BuyTicketExample {
    private int ticket=100;
    public synchronized void sale(int num){
        if(num<ticket){
            System.out.println("buy"+num+"ticket");
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                //do something
            }
            ticket=ticket-num;
        }
        else{
            System.out.println("The ticket is not enrich "+num);
        }
        System.out.println("Remain "+ticket+" ticket");
    }
    public static void main(String[]args){
        BuyTicketExample zzy=new BuyTicketExample();

        Thread thread1=new Thread(){
            public void run() {
                zzy.sale(50);
            }
        };thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                zzy.sale(70);
            }
        }).start();
    }
}
