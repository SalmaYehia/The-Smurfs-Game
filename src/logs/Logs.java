package logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {

    static final Logger logger = LogManager.getLogger(Logs.class);

    public static void log(String msg, String level) {
        switch (level) {
        case "info":
            logger.info(msg);
            break;
        case "debug":
            logger.debug(msg);
            break;
        case "error":
            logger.error(msg);
            break;
        case "fatal":
            logger.fatal(msg);
            break;
        case "warn":
            logger.warn(msg);
            break;
        default:
            break;
        }
    }
}
