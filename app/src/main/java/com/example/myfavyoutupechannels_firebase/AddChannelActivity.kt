package com.example.myfavyoutupechannels_firebase

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myfavyoutupechannels_firebase.handlers.ChannelHandler
import com.example.myfavyoutupechannels_firebase.model.Channel

class AddChannelActivity : AppCompatActivity() {
    lateinit var addButton: Button
    lateinit var addTitleEt: EditText
    lateinit var addLinkEt: EditText
    lateinit var addRankEt: EditText
    lateinit var addReason: EditText
    lateinit var channelHandler: ChannelHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_channel)

        addTitleEt = findViewById(R.id.addTitleEt)
        addLinkEt = findViewById(R.id.addLinkEt)
        addRankEt = findViewById(R.id.addRankEt)
        addReason = findViewById(R.id.addReason)
        addButton = findViewById(R.id.addButton)
        channelHandler = ChannelHandler()

        addButton.setOnClickListener {
            val title = addTitleEt.text.toString()
            val link = addLinkEt.text.toString()
            val rank = addRankEt.text.toString().toInt()
            val reason = addReason.text.toString()

            val channel = Channel(title = title, link = link, rank =  rank, reason = reason)

            if(addTitleEt.text.toString().isNotEmpty() && addLinkEt.text.toString().isNotEmpty() && addRankEt.text.toString().isNotEmpty() && addReason.text.toString().isNotEmpty()){
                channelHandler.create(channel)
                Toast.makeText(applicationContext, "YouTupe Channel added successfully", Toast.LENGTH_SHORT).show()
                clearFields()
            }
            else {
                Toast.makeText(applicationContext, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun clearFields(){
        addTitleEt.text.clear()
        addLinkEt.text.clear()
        addRankEt.text.clear()
        addReason.text.clear()
    }
}