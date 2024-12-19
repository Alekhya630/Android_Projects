package com.singlepointsol.sociallazycolumn

data class Social(val socialImage: Int, val socialName: String, val socialDetails: String)

fun getAllSocialImages(): ArrayList<Social> {
    return arrayListOf(
        Social(R.drawable._maltese, "Maltese", "It is related to the bichon"),
        Social(R.drawable.havanese, "Havanse", "National dog of cuba"),
        Social(R.drawable.pomeranian, "Pomeranian", "Region in northwest poland"),
        Social(R.drawable.nylabone, "Nylabone", "National dog of cuba"),
        Social(R.drawable.danspetcare, "Danspetcare", "National dog of cuba")
    )
}
