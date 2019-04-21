package com.an2t.mnsapp.maps

data class MapsRes(
    val LocationList: List<Location>,
    val Message: String,
    val Status: Boolean,
    val Type: String
)


data class MapsReq(
    val type: Int
)


