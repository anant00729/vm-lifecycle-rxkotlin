package com.an2t.mnsapp.network

import com.an2t.mnsapp.auth.LoginRes
import com.an2t.mnsapp.auth.User
import com.an2t.mnsapp.maps.MapsReq
import com.an2t.mnsapp.maps.MapsRes
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ServiceAPI {

    @POST("auth/login")
    fun login(@Body user : User) : Observable<Response<LoginRes>>

    @POST("map/get_teamlocation")
    fun getMaps(@Body req : MapsReq) : Observable<MapsRes>

}
