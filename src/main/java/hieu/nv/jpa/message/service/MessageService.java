package hieu.nv.jpa.message.service;

import hieu.nv.jpa.message.dto.MessageDto;
import hieu.nv.jpa.message.entity.Message;

public interface MessageService {

    Message createMessage(MessageDto message);

    Message getMessageById(String id);

    Iterable<MessageDto> getAllMessages();
}
