import java.util.ArrayList;

public class QueueMonitoring {
    public static void main(String[] args) {
        Queue queue = Queue.getInstance();

        HelpDesk desk1 = new HelpDesk("Help Desk 1");
        HelpDesk desk2 = new HelpDesk("Help Desk 2");
        HelpDesk desk3 = new HelpDesk("Help Desk 3");
        
        ArrayList<HelpDesk> helpDesks = new ArrayList<>();
        helpDesks.add(desk1);
        helpDesks.add(desk2);
        helpDesks.add(desk3);

        queue.enQueue(new Individual("John Doe"));
        queue.enQueue(new Individual("Jane Smith"));   
        queue.enQueue(new Individual("Alice Johnson"));
        queue.enQueue(new Individual("Bob Brown"));
        queue.enQueue(new Individual("Charlie Davis")); 
        queue.enQueue(new Individual("Diana Evans"));
        
        System.out.println("--- Pag-IBIG Office Centralized Queuing System ---\n");
        
        helpDesks.get(0).serveNextPerson();
        helpDesks.get(1).serveNextPerson();
        helpDesks.get(2).serveNextPerson();
   
        queue.displayQueue(helpDesks);

        helpDesks.get(0).clearStation();
        helpDesks.get(1).clearStation();
        helpDesks.get(2).clearStation();

        queue.displayQueue(helpDesks);

        helpDesks.get(0).serveNextPerson();
        helpDesks.get(1).serveNextPerson();
        helpDesks.get(2).serveNextPerson();
        
        queue.displayQueue(helpDesks); 
    }
}