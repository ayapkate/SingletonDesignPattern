public class HelpDesk {
    private String name;
    private String currentServing;

    public HelpDesk(String name) {
        this.name = name;
        this.currentServing = "Waiting..";
    }

    public String getName() {
        return name;
    }

    public String getCurrentServing() {
        return currentServing;
    }

    public void serveNextPerson() {
        Individual nextPerson = Queue.getInstance().process();
        if (nextPerson != null) {
            this.currentServing = nextPerson.getName();
        } else {
            this.currentServing = "Waiting..";
        }
    }

    public void clearStation() {
        this.currentServing = "Waiting..";
    }

    public void resetQueue(int newNumber) {
        Queue.getInstance().resetQueueNumber(newNumber);
    }
    

    
}