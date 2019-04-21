package com.an2t.mnsapp.auth.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.an2t.mnsapp.auth.LoginRes
import com.an2t.mnsapp.auth.User
import com.an2t.mnsapp.network.RetrofitClient
import com.an2t.mnsapp.network.ServiceAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class LoginVM : ViewModel() {

    val l_res = MutableLiveData<LoginRes?>()

    var _s: ServiceAPI
    internal var _cD : CompositeDisposable

    init {
        var _r = RetrofitClient.instance
        _s = _r.create(ServiceAPI::class.java)
        _cD = CompositeDisposable()

    }

    fun callLogin(u: User) {
        _cD.add(_s.login(u)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                {res ->
                    when (res.code()) {
                        200 -> {
                            print(res.body())
                        }
                        else -> {

                        }
                    }
                }, {e ->
                    print(e)
                })
//            .subscribe ({ p -> displayData(p)}, {e ->
//                print(e)
//            })

        )
    }

    private fun displayData(p: LoginRes?) {
        l_res.value = p
    }

    override fun onCleared() {
        if(!_cD.isDisposed){
            _cD.dispose()
        }
        super.onCleared()
    }
}