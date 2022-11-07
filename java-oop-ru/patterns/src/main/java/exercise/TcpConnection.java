package exercise;

import exercise.connections.Connection;

import java.util.List;
import java.util.ArrayList;

// BEGIN
class TcpConnection implements Connection {

    String ip;
    int port;

    String state="";

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String getCurrentState() {

        return state;
    }

    @Override
    public void connect() {
        if (state.equals("connected"))
            System.out.println("Error. Try to connect when connection already established");
        else
            state = "connected";
    }

    @Override
    public void disconnect() {
        if (state.equals("disconnected"))
            System.out.println("Error. Try to disconnect when connection disconnected");
        else
            state = "disconnected";
    }

    @Override
    public void write(String a) {
        if (state.equals("disconnected"))
            System.out.println("Error. Try to write to disconnected connection");

    }
}
// END
