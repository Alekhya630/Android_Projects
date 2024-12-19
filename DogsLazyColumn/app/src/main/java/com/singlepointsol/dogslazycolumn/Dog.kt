package com.singlepointsol.dogslazycolumn

data class Dog(val dogImage: Int, val dogBreed: String, val dogDetails: String)

fun getAllDogImages(): ArrayList<Dog> {
    return arrayListOf(
        Dog(R.drawable._maltese, "Maltese", "It is related to the bichon"),
        Dog(R.drawable.havanese, "Havanese", "National dog of Cuba"),
        Dog(R.drawable.pomeranian, "Pomeranian", "Region in northwest Poland"),
        Dog(R.drawable.nylabone, "Nylabone", "National dog of Cuba"),
        Dog(R.drawable.danspetcare, "Danspetcare", "National dog of Cuba"),
        Dog(R.drawable._maltese, "Maltese", "It is related to the bichon"),
        Dog(R.drawable.havanese, "Havanese", "National dog of Cuba"),
        Dog(R.drawable.pomeranian, "Pomeranian", "Region in northwest Poland"),
        Dog(R.drawable.nylabone, "Nylabone", "National dog of Cuba"),
        Dog(R.drawable.danspetcare, "Danspetcare", "National dog of Cuba")
    )
}
