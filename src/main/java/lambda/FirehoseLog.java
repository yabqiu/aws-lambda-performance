package lambda;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehoseClientBuilder;
import com.amazonaws.services.kinesisfirehose.model.PutRecordRequest;
import com.amazonaws.services.kinesisfirehose.model.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

public class FirehoseLog {

    private static final Logger logger = LoggerFactory.getLogger(FirehoseLog.class);

    public static void main(String[] args) {
        AmazonKinesisFirehose firehoseClient = AmazonKinesisFirehoseClientBuilder.standard().withCredentials(new
                ProfileCredentialsProvider("saml")).build();

        PutRecordRequest putRecordRequest = new PutRecordRequest();
        putRecordRequest.setDeliveryStreamName("yanbin-dilivery-stream");

        String data = "hello" + "\n";

        Record record = new Record();
        record.setData(ByteBuffer.wrap(data.getBytes()));
        putRecordRequest.setRecord(record);

        firehoseClient.putRecord(putRecordRequest);

    }
}
