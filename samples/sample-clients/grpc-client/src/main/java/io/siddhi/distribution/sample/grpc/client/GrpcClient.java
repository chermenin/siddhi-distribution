/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.siddhi.distribution.sample.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.log4j.Logger;
import org.wso2.grpc.Event;
import org.wso2.grpc.EventServiceGrpc;

/**
 * This is a sample gRpc client to publish events to gRpc endpoint.
 */
public class GrpcClient {
    private static final Logger log = Logger.getLogger(GrpcClient.class);

    /**
     * Main method to start the test client.
     *
     * @param args no args need to be provided
     */
    public static void main(String[] args) throws InterruptedException {
        String port = args[0];
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:" + port).usePlaintext().build();
        Event.Builder requestBuilder = Event.newBuilder();
        int noOfEventsToSend = !args[1].isEmpty() ? Integer.parseInt(args[1]) : -1;
        boolean sendEventsContinuously = noOfEventsToSend == -1;
        int sentEvents = 0;

        while (sendEventsContinuously || sentEvents != noOfEventsToSend) {
            String json = "{ \"message\": \"Request " + (sentEvents + 1) + "\"}";
            requestBuilder.setPayload(json);
            requestBuilder.putHeaders("stream.id", "FooStream");
            Event sequenceCallRequest = requestBuilder.build();
            EventServiceGrpc.EventServiceBlockingStub blockingStub = EventServiceGrpc.newBlockingStub(channel);
            Event response = blockingStub.process(sequenceCallRequest);
            log.info(response);
            Thread.sleep(1000);
            sentEvents++;
        }
    }
}
