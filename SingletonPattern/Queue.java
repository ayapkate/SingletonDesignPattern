import java.util.ArrayList;

public class Queue {
    private static Queue instance;
    private int queueNumber;
    private ArrayList<Individual> waitingLine;

    private Queue() {
        this.queueNumber = 0;
        this.waitingLine = new ArrayList<>();
    }

    public static synchronized Queue getInstance() {
        if (instance == null) {
            instance = new Queue();
        }
        return instance;
    }

    public synchronized int getNextQueueNumber() {
        queueNumber++;
        return queueNumber;
    }

    // assigns number to the person and adds them to the waiting line
    public synchronized void enQueue(Individual individual) {
        int newNumber = getNextQueueNumber();
        individual.setQueueNumber(newNumber);
        waitingLine.add(individual);
    }

    //Checks if empty before processing
    public synchronized Individual process() {
        if (waitingLine.isEmpty()) {
            return null;
        }
        return waitingLine.remove(0); // Removes and returns the first person
    }

    public synchronized void resetQueueNumber(int newNumber) {
        this.queueNumber = newNumber;
        this.waitingLine.clear();
    }

    public void displayQueue(ArrayList<HelpDesk> helpDesks) {
        System.out.println("\n[--- Current Status ---]");
        for (HelpDesk helpDesk : helpDesks) {
            System.out.println(helpDesk.getName() + ": " + helpDesk.getCurrentServing());
        }

        System.out.println("\n\t..Queue..");
        if (waitingLine.isEmpty()) {
            System.out.println("\t(No one in line)");
        } else {
            for (Individual individual : waitingLine) {
                System.out.println("\t" + individual.toString());
            }
        }
        System.out.println();
    }

    public ArrayList<Individual> getQueue() {
        return waitingLine;
    }
}