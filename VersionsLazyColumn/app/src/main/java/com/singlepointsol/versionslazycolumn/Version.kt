package com.singlepointsol.versionslazycolumn


data class Version(val versionImage:Int,val versionName:String,val versionDetails: String)
fun getAllVersions(): ArrayList<Version>{

    return arrayListOf(
        Version(R.drawable.fb,"FaceBook","Chat with facebook friends"),
        Version(R.drawable.lin,"Linkedin","One of the best portal for checking jobs"),
        Version(R.drawable.amazon,"Amazon","To book any product"),
        Version(R.drawable.whatsapp,"Whatsapp","To Chat with friends"),
        Version(R.drawable.twitter,"Twitter","To post anything"),
        Version(R.drawable.youtube,"Whatsapp","To watch songs"),
        Version(R.drawable.pintrest,"Whatsapp","To get ideas for searched items"),
        Version(R.drawable.telegram,"Whatsapp","To get movie links"),
        Version(R.drawable.whatsapp,"Whatsapp","To Chat with friends")







    )
}
