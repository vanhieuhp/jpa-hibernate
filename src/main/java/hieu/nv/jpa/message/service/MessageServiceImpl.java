package hieu.nv.jpa.message.service;

import hieu.nv.jpa.message.dto.MessageDto;
import hieu.nv.jpa.message.entity.Message;
import hieu.nv.jpa.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    @Transactional
    public Message createMessage(MessageDto message) {
        Message entity = new Message();
        entity.setPayload(message.getPayload());
        messageRepository.save(entity);
        return entity;
    }

    @Transactional(readOnly = true)
    @Override
    public Message getMessageById(String id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<MessageDto> getAllMessages() {
        return messageRepository.findAll().stream()
                .map(entity -> new MessageDto(entity.getId(), entity.getPayload()))
                .toList();
    }
}
