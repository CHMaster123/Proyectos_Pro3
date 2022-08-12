package Try_logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logs {


    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.debug("pongo aqui este mensaje para los logs");
        logger.error("pongo aqui este mensaje para los logs");
        logger.info("pongo aqui este mensaje para los logs");
    }
}
