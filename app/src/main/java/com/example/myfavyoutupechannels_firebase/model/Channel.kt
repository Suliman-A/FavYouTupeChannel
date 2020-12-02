package com.example.myfavyoutupechannels_firebase.model

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable


@IgnoreExtraProperties
class Channel(var id: String? = "", var title: String? = "", var link: String? = "", var rank: Int? = 0, var reason: String? = ""):
    Serializable {
    override fun toString(): String {
        return "Name of Channel: $title \n\n"+
                "LINK: $link \n\n"+
                "RANKING: $rank \n\n"+
                "I like this YouTupe channel because $reason\n\n"
    }
}
