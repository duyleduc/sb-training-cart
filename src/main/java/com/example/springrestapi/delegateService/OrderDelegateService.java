package com.example.springrestapi.delegateService;

import org.springframework.stereotype.Service;

import com.example.springrestapi.asyncAction.ActionKeys;
import com.example.springrestapi.asyncAction.RunnableStore;
import com.example.springrestapi.delegateService.interfaces.DelegateService;
import com.example.springrestapi.messages.QueueMessage;

@Service("orderDelegateService")
public class OrderDelegateService implements DelegateService {

    @Override
    public void receiveAction(String actionType, String domain, QueueMessage message) throws Exception {
        switch (actionType) {
            case "reduceQuantity":
                RunnableStore.runAction(ActionKeys.saveOrderDetail);
                break;
            case "error":
                handleError(domain, message);
                break;
        }

    }

    @Override
    public void handleError(String reason, QueueMessage message) throws Exception {
        RunnableStore.log();

        System.out.println("---------");
        switch (reason) {
            case "reduceQuantityItemNotFound":
                RunnableStore.removeAction(ActionKeys.saveOrderDetail + message.getMessageId());
                break;
        }
        System.out.println(reason + "  " + message.getMessageId());
        RunnableStore.log();
    }

}
