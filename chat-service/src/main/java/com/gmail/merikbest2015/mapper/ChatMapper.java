package com.gmail.merikbest2015.mapper;

import com.gmail.merikbest2015.dto.HeaderResponse;
import com.gmail.merikbest2015.dto.UserResponse;
import com.gmail.merikbest2015.dto.request.ChatMessageRequest;
import com.gmail.merikbest2015.dto.request.MessageWithTweetRequest;
import com.gmail.merikbest2015.dto.response.ChatMessageResponse;
import com.gmail.merikbest2015.dto.response.ChatResponse;
import com.gmail.merikbest2015.dto.response.UserChatResponse;
import com.gmail.merikbest2015.model.ChatMessage;
import com.gmail.merikbest2015.repository.projection.ChatMessageProjection;
import com.gmail.merikbest2015.repository.projection.ChatProjection;
import com.gmail.merikbest2015.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ChatMapper {

    private final BasicMapper basicMapper;
    private final ChatService chatService;

    public ChatResponse getChatById(Long chatId) {
        ChatProjection chat = chatService.getChatById(chatId);
        return basicMapper.convertToResponse(chat, ChatResponse.class);
    }

    public List<ChatResponse> getUserChats() {
        List<ChatProjection> chats = chatService.getUserChats();
        return basicMapper.convertToResponseList(chats, ChatResponse.class);
    }

    public ChatResponse createChat(Long userId) {
        ChatProjection chat = chatService.createChat(userId);
        return basicMapper.convertToResponse(chat, ChatResponse.class);
    }

    public List<ChatMessageResponse> getChatMessages(Long chatId) {
        List<ChatMessageProjection> chatMessages = chatService.getChatMessages(chatId);
        return basicMapper.convertToResponseList(chatMessages, ChatMessageResponse.class);
    }

    public Long readChatMessages(Long chatId) {
        return chatService.readChatMessages(chatId);
    }

    public ChatMessageResponse addMessage(ChatMessageRequest chatMessageRequest) {
        Map<String, Object> messageMap = chatService.addMessage(
                basicMapper.convertToResponse(chatMessageRequest, ChatMessage.class), chatMessageRequest.getChatId());
        return getChatMessageResponse(messageMap);
    }

    public ChatMessageResponse addMessageWithTweet(MessageWithTweetRequest request) {
        Map<String, Object> messageMap = chatService.addMessageWithTweet(request.getText(), request.getTweetId(),
                request.getUsersIds());
        return getChatMessageResponse(messageMap);
    }

    public String leaveFromConversation(Long participantId, Long chatId) {
        return chatService.leaveFromConversation(participantId, chatId);
    }

    public UserResponse getParticipant(Long participantId, Long chatId) {
        return chatService.getParticipant(participantId, chatId);
    }

    public HeaderResponse<UserChatResponse> searchParticipantsByUsername(String username, Pageable pageable) {
        return chatService.searchUsersByUsername(username, pageable);
    }

    private ChatMessageResponse getChatMessageResponse(Map<String, Object> messageMap) {
        ChatMessageProjection chatMessageProjection = (ChatMessageProjection) messageMap.get("message");
        ChatMessageResponse message = basicMapper.convertToResponse(chatMessageProjection, ChatMessageResponse.class);
        message.setChatParticipantsIds((List<Long>) messageMap.get("chatParticipantsIds"));
        return message;
    }
}
