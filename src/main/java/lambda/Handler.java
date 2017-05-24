package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Handler implements RequestHandler<KinesisEvent, String> {

	private static final Logger logger = LoggerFactory.getLogger(Handler.class);

	@Override
	public String handleRequest(KinesisEvent event, Context context) {
	    logger.info("Received messages: " + event.getRecords().size());
	    event.getRecords().forEach(record -> {
	    	logger.info("Get message content: " + new String(record.getKinesis().getData().array()));
		});

	    throw new RuntimeException("test");
	}
}
