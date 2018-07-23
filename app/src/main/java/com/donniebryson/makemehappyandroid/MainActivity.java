package com.donniebryson.makemehappyandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;



public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private String workspace_id;
    private String conversation_username;
    private String conversation_password;
    private com.ibm.watson.developer_cloud.conversation.v1.model.Context context = null;
    private Conversation service = new Conversation(Conversation.VERSION_DATE_2017_05_26);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        conversation_username = mContext.getString(R.string.conversation_username);
        conversation_password = mContext.getString(R.string.conversation_password);
        workspace_id = mContext.getString(R.string.workspace_id);
        service.setUsernameAndPassword(conversation_username, conversation_password);
        ImageView myImg = findViewById(R.id.imgReaction);
        myImg.setBackgroundResource(R.drawable.unknown);

    }

    public void sendWatsonMessage(View v) {
        TextView txt = findViewById(R.id.editOpinion);
        ImageView myImg = findViewById(R.id.imgReaction);
        String r = txt.getText().toString();
        int x = checkOpinion(r);
        myImg.setBackgroundResource(x);
        txt.setText("");
    }

    private int checkOpinion(String myOpinion ) {
        int x = R.drawable.unknown;

        if ( myOpinion.equalsIgnoreCase("I don't like you") ) {
            return R.drawable.sad;
        } else if ( myOpinion.equalsIgnoreCase("I like you") ) {
            return R.drawable.happy;
        } else {
            return x;
        }
        /* Watson logic is all short-circuited because this is being used momentarily
        as a demo of my Java / Android skills
         */

//        String myInput = (String)txt.getText();
//        String myInput = "I love you";
//        InputData input = new InputData.Builder(myInput).build();
//        MessageOptions options = new MessageOptions.Builder(workspace_id).input(input).context(context).build();
//        MessageResponse response = service.message(options).execute();


    }
}
