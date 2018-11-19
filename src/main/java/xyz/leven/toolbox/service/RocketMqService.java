package xyz.leven.toolbox.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class RocketMqService {
    public static final String TOPIC = "myTopic";

    private static DefaultMQProducer producer;
    static {
        try {
            producer = new DefaultMQProducer("myGroup");
            producer.setInstanceName("myInstance23");
            producer.setNamesrvAddr("111.230.139.218:9876");
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }


    public void sendOrderMsg() throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        String[] tags=new String[]{"tagA","tagB","tagC","tagD","tagE"};
        int count=0;
        while (count++<100){
            int orderId = count % 10;
            Message msg = new Message(TOPIC, tags[count % tags.length], "KEY" + count,
                    ("Hello RocketMQ " + count).getBytes(RemotingHelper.DEFAULT_CHARSET));

            SendResult  sendResult=producer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id=(Integer) arg;

                    return mqs.get(id%mqs.size());
                }
            },orderId);
            System.out.println(sendResult.toString());
        }

    }

    public void send() throws Exception {
        int count = 100;
        while (count-- > 0) {
            Message msg = new Message(TOPIC, "myTag", ("hello world" + count).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult rst = producer.send(msg);
            log.info("返回结果{}", rst);

        }
    }


    public void sendAsyn() throws RemotingException, MQClientException, InterruptedException, UnsupportedEncodingException {
        int total = 100;
        while (total-- > 0) {

            producer.send(new Message(TOPIC, "myTag", UUID.randomUUID().toString(), ("婷婷PANG"+total ).getBytes( RemotingHelper.DEFAULT_CHARSET)), new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("成功啦");
                }

                @Override
                public void onException(Throwable e) {
                    System.out.println("异常啦");
                }
            });

        }
    }

    public void sendOneWay() throws RemotingException, MQClientException, InterruptedException, UnsupportedEncodingException {
        int total = 100;
        while (total-- > 0) {

            producer.sendOneway(new Message(TOPIC, "myTag", UUID.randomUUID().toString(), ("婷婷PANG"+total ).getBytes( RemotingHelper.DEFAULT_CHARSET)));

        }
    }

    public void sendDelayMsg() throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        int totalCount=100;
        while (totalCount-->0){
            Message msg=new Message("myTopic",("msg"+totalCount).getBytes(RemotingHelper.DEFAULT_CHARSET));

            msg.setDelayTimeLevel(3);
            SendResult sendResult=producer.send(msg);
            System.out.println(sendResult);
        }

    }

}
