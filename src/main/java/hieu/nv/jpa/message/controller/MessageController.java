package hieu.nv.jpa.message.controller;

import hieu.nv.jpa.message.dto.MessageDto;
import hieu.nv.jpa.message.entity.Message;
import hieu.nv.jpa.message.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody @Valid MessageDto message) {
        return ResponseEntity.ok(messageService.createMessage(message));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable String id) {
        return ResponseEntity.ok(messageService.getMessageById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<MessageDto>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }
}
