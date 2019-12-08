package com.example.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.ServiceBusQueueTrigger;

/**
 * Azure Functions with ServiceBus Trigger.
 */
public class ServiceBusFunction {

    /**
     * ServiceBusをトリガーにする
     * @param message
     * @param context
     */
    @FunctionName("servicebus-trigger")
    public void run(
            @ServiceBusQueueTrigger(name = "message",queueName = "funcqueue", connection="SERVICE_BUS_CONNECTIONSTRING") String message,
            final ExecutionContext context) {
        context.getLogger().info("ServiceBusTrigger start.");
        context.getLogger().info(message);
    }
}
