package com.gmail.merikbest2015.service;

import com.gmail.merikbest2015.dto.response.notification.NotificationListResponse;

public interface ListsClientService {

    NotificationListResponse getNotificationList(Long listId);
}
