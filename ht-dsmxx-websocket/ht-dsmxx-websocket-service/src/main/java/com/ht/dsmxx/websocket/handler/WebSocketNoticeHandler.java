package com.ht.dsmxx.websocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhou on 2018/10/24.
 */
public class WebSocketNoticeHandler extends TextWebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketNoticeHandler.class);

    //在线用户列表
    private static final Map<Integer, WebSocketSession> users;

    static {
        users = new HashMap<>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("开始建立连接");
        Integer userId = getUserId(session);
        if (userId != null) {
            WebSocketSession webSocketSession = users.get(userId);
            if (webSocketSession == null) {//之前未连接过
                LOGGER.info("用户：" + userId + ",成功建立连接");
            } else {//之前已经连接过
                LOGGER.info("用户：" + userId + ",已存在连接");
            }
            users.put(userId, session);
        } else {
            LOGGER.info("用户：" + userId + "不存在,建立连接失败");
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        WebSocketMessage textMessage = new TextMessage("server:" + message);
        try {
            session.sendMessage(textMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送信息给指定用户
     *
     * @param userId
     * @param message
     * @return
     */
    public boolean sendMessageToUser(Integer userId, TextMessage message) {
        if (users.get(userId) == null) return false;
        WebSocketSession session = users.get(userId);
        System.out.println("sendMessage:" + session);
        if (!session.isOpen()) return false;
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 广播信息
     *
     * @param message
     * @return
     */
    public boolean sendMessageToAllUsers(TextMessage message) {
        boolean allSendSuccess = true;
        Set<Integer> clientIds = users.keySet();
        WebSocketSession session = null;
        for (Integer clientId : clientIds) {
            try {
                session = users.get(clientId);
                if (session.isOpen()) {
                    session.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                allSendSuccess = false;
            }
        }

        return allSendSuccess;
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        System.out.println("连接出错");
        users.remove(getUserId(session));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("连接已关闭：" + status);
        users.remove(getUserId(session));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 获取用户标识
     *
     * @param session
     * @return
     */
    private Integer getUserId(WebSocketSession session) {
        try {
            String[] str = session.getUri().getQuery().split("=");
            Integer userId = null;
            if (str.length > 0) {
                userId = Integer.valueOf(str[1]);
            }
            return userId;
        } catch (Exception e) {
            return null;
        }
    }

    public Map<Integer, WebSocketSession> getConnectUsers() {
        return users;
    }
}
