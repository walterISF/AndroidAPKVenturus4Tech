package br.org.venturus.venturus4tech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                if(!txtNome.getText().toString().equals(""))
                    openChatActivity(txtNome.getText().toString());
                else
                    Toast.makeText(MainActivity.this, "Preencha o campo texto", Toast.LENGTH_LONG).show();
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
