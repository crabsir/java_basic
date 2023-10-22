package logging;

import java.util.logging.*;

public class ConfigureLogging {

    private static void configureLogging() {

        final Logger LOGGER_A = Logger.getLogger("org.stepic.java.logging.ClassA");
        LOGGER_A.setLevel(Level.ALL);

        final Logger LOGGER_B = Logger.getLogger("org.stepic.java.logging.ClassB");
        LOGGER_B.setLevel(Level.WARNING);

        final Handler HANDLER_STEPIC = new ConsoleHandler();
        HANDLER_STEPIC.setLevel(Level.ALL);
        HANDLER_STEPIC.setFormatter(new XMLFormatter());

        final Logger LOGGER_STEPIC = Logger.getLogger("org.stepic.java");
        LOGGER_STEPIC.setLevel(Level.ALL);
        LOGGER_STEPIC.setUseParentHandlers(false);
        LOGGER_STEPIC.addHandler(HANDLER_STEPIC);

    }

}
