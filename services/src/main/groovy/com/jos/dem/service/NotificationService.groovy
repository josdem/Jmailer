package com.jos.dem.service

import com.jos.dem.bean.mail.EmailBean

interface NotificationService {

  void sendNotification(EmailBean bean)

}
