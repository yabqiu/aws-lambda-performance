package lambda;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;
import com.amazonaws.services.kinesis.model.PutRecordResult;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;

public class KinesisProducer {
    public static void main(String[] args) {
        String kinesisStream = "yanbin-test-stream";

        AmazonKinesis kinesis = AmazonKinesisClientBuilder.standard().withCredentials(new
            ProfileCredentialsProvider("saml")).build();

        for (int i = 0; i < 10; i++) {
            PutRecordResult result = kinesis.putRecord(kinesisStream, ByteBuffer.wrap(
                (i + ", time: " + LocalDateTime.now()).getBytes()), "key");
            System.out.println("ShardId: " + result.getShardId() + ", #Seq: " + result.getSequenceNumber());
        }
    }
}
