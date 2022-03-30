package com.headfirst.pacmanface;

public class SimpleChatStarter {
    public static void main(String[] args) {
        VerySimpleChatServer server = new VerySimpleChatServer();
        server.go();

        SimpleChatClient client = new SimpleChatClient();
        client.setUpGui();
    }
}
