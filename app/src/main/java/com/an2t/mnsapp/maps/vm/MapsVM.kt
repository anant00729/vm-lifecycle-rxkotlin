package com.an2t.mnsapp.maps.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.an2t.mnsapp.auth.User
import com.an2t.mnsapp.maps.MapsReq
import com.an2t.mnsapp.maps.MapsRes
import com.an2t.mnsapp.network.RetrofitClient
import com.an2t.mnsapp.network.ServiceAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MapsVM : ViewModel() {

    val m_res = MutableLiveData<MapsRes?>()

    var _s: ServiceAPI
    internal var _cD : CompositeDisposable

    init {
        var _r = RetrofitClient.instance
        _s = _r.create(ServiceAPI::class.java)
        _cD = CompositeDisposable()

    }

    fun callMaps(u: Int) {
        val r = MapsReq(u)

        _cD.add(_s.getMaps(r)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { p -> displayData(p) }
        )
    }

    private fun displayData(p: MapsRes?) {
        m_res.value = p
    }

    override fun onCleared() {
        if(!_cD.isDisposed){
            _cD.dispose()
        }
        super.onCleared()
    }
}