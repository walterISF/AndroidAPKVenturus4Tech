package br.org.venturus.venturus4tech;
import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * Created by vntlab on 05/02/18.
 */

public class SocketMananger
{
    private io.socket.client.Socket mSocket = null;
    private static SocketMananger mInstance;

    public static SocketMananger getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new SocketMananger();
        }
        return mInstance;
    }

    private SocketMananger()
    {
        try
        {
            mSocket = IO.socket("http://172.24.30.53:3000/");
        }
        catch (URISyntaxException e) {
            mSocket = null;
        }
    }

    public Socket getSocket() { return mSocket; }
}
