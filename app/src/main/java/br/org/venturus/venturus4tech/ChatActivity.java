package br.org.venturus.venturus4tech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Bundle bundle = getIntent().getExtras();
        TextView retorno = findViewById(R.id.txtRetorno);
        if(!bundle.isEmpty())
            retorno.setText(bundle.getString("name"));
    }
}