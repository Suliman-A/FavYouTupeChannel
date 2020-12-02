package com.example.myfavyoutupechannels_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myfavyoutupechannels_firebase.handlers.ChannelHandler
import com.example.myfavyoutupechannels_firebase.model.Channel

class UpdateChannelActivity : AppCompatActivity() {
    lateinit var editButton: Button
    lateinit var titleEt: EditText
    lateinit var linkEt: EditText
    lateinit var rankEt: EditText
    lateinit var reasonEt: EditText
    lateinit var channelHandler: ChannelHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_channel)

        var channelItems: Channel = intent.getSerializableExtra("data") as Channel

        titleEt = findViewById(R.id.titleEt)
        linkEt = findViewById(R.id.linkEt)
        rankEt = findViewById(R.id.rankEt)
        reasonEt = findViewById(R.id.et_Reason_edit)
        editButton = findViewById(R.id.editButton)
        channelHandler = ChannelHandler()

        titleEt.setText(channelItems.title)
        linkEt.setText(channelItems.link)
        rankEt.setText(channelItems.rank.toString())
        reasonEt.setText(channelItems.reason)

        editButton.setOnClickListener {
            val title = titleEt.text.toString()
            val link = linkEt.text.toString()
            val rank = rankEt.text.toString().toInt()
            val reason = reasonEt.text.toString()

            val channel = Channel(id = channelItems.id, title = title, link = link, rank = rank, reason = reason)

            if(titleEt.text.toString().isNotEmpty() && linkEt.text.toString().isNotEmpty() && rankEt.text.toString().isNotEmpty() && reasonEt.text.toString().isNotEmpty()){
                channelHandler.update(channel)
                Toast.makeText(applicationContext, "YouTupe channel updated successfully", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        }

    }

}