package logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.logging.Logger;

public class Log {

    private static Logger loggerInstance;

    private static Logger getLogger() {
        if (Objects.isNull(loggerInstance)) {
            loggerInstance = LoggerFactory.getLogger("Test logger");
        }
        return loggerInstance;
    }

    public static void info(String message) {
        getLogger().info(message);
    }

    public static void warn(String message, Throwable cause) {
        getLogger().warn(message, cause);
    }

    public static void error(String message) {
        getLogger().error(message);
    }
}
