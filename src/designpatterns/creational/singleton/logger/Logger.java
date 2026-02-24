package designpatterns.creational.singleton.logger;

/*
    Implement Logger Class
    Problem: Implement a singleton Logger that supports log levels.
    Only messages at or above the configured minimum level should be written.

    Requirements:
    - Log levels: DEBUG, INFO, WARN, ERROR (in increasing severity)
    - setLevel(level) sets the minimum log level
    - debug(msg), info(msg), warn(msg), error(msg) log at the respective level
    - Messages below the minimum level are silently discarded
    - Output format: [LEVEL] message
    - Thread-safe
 */

public enum Logger {
    INSTANCE;
    public enum Level {DEBUG, INFO, WARN, ERROR};

    public static Logger getInstance(){return INSTANCE;}

    private Level minLevel = Level.INFO;

    public void setLevel(Level level) {
        this.minLevel = level;
    }

    private void log(Level level, String message) {
        if (level.ordinal() >= minLevel.ordinal()) {
            System.out.println("[" + level + "] " + message);
        }
    }

    public void debug(String msg) { log(Level.DEBUG, msg); }
    public void info(String msg)  { log(Level.INFO, msg); }
    public void warn(String msg)  { log(Level.WARN, msg); }
    public void error(String msg) { log(Level.ERROR, msg); }

    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        System.out.println("Same instance: " + (l1 == l2));
        l1.setLevel(Logger.Level.WARN);
        l1.debug("Starting up");
        l1.info("Server listening on port 8080");
        l1.warn("Connection pool running low");
        l1.error("Failed to connect to database");
    }
}
