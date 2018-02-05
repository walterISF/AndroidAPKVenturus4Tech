package br.org.venturus.venturus4tech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ChatAdapter mChatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Bundle bundle = getIntent().getExtras();


        TextView mText = findViewById(R.id.nickname);
        mText.setText(bundle.get("name").toString());

        mRecyclerView = findViewById(R.id.recycler_view_chat);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        mChatAdapter = new ChatAdapter();
        mRecyclerView.setAdapter(mChatAdapter);
    }
}
