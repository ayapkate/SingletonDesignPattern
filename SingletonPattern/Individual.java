public class Individual {
    private String name;
    private int queueNumber;

    public Individual(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    // Added toString for easy printing
    @Override
    public String toString() {
        return "[" + queueNumber + "] " + name;
    }
}