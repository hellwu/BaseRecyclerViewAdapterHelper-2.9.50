package com.chad.baserecyclerviewadapterhelper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.flyco.tablayout.SlidingTabLayout
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MyTestActivity : AppCompatActivity() {

    var titles: Array<String> = arrayOf("My devices", "All devices")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_test)
        var stl = findViewById<SlidingTabLayout>(R.id.voice_detail_choose)
        var viewpager = findViewById<ViewPager>(R.id.voice_detail_view_pager)
        var fragments: java.util.ArrayList<Fragment> = java.util.ArrayList()
        fragments.add(BlankFragment.newInstance("My devices", "My devices data"))
        fragments.add(BlankFragment.newInstance("All devices", "All devices"))



        Observable.just("ddd").delay(3500, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
            it?.let {
                titles = arrayOf("My devices", "All devices", "New Line")
                fragments.add(BlankFragment.newInstance("New Line", "New Line"))
                stl.setViewPager(viewpager!!, titles, this, fragments)
            }
        }, {

        }, {

        })
    }
}



