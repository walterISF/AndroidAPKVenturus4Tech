package br.org.venturus.venturus4tech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {

    EditText txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnClick);

        txtNome = findViewById(R.id.txtNome);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nickname = txtNome.getText().toString();
                if(!TextUtils.isEmpty(nickname))
                {
                    SocketMananger.getInstance().getSocket().once(Socket.EVENT_CONNECT, new Emitter.Listener() {
                        @Override
                        public void call(Object... args)
                        {
                            openChatActivity(nickname);
                        }
                    });

                    SocketMananger.getInstance().getSocket().once(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
                        @Override
                        public void call(final Object... args) {

                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run()
                                {
                                    final String message = ((Exception)args[0]).getCause().getLocalizedMessage();
                                    Log.d("VNT", message);
                                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });

                    SocketMananger.getInstance().getSocket().connect();

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Preencha o campo texto", Toast.LENGTH_LONG).show();
                    Log.d("VNT", "nickname vazio");

                }
            }
        });
    }

    private void openChatActivity(String nickname)
    {
        Intent i = new Intent(MainActivity.this, ChatActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", nickname);
        i.putExtras(bundle);
        startActivity(i);
    }
}
