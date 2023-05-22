package com.hnam.alphaindex

import `in`.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    var mRecyclerView: IndexFastScrollRecyclerView? = null

    // getAlphabetFullData() - full data, getAlphabetNotFullData() - not full data
    private val mData by lazy { DataHelper.getAlphabetFullData() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.fast_scroller_recycler)
        initialiseUI()
    }


    private fun initialiseUI() {
        mRecyclerView?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerViewAdapter(mData)
            setIndexTextSize(12)
            setIndexBarCornerRadius(0)
            setIndexBarTransparentValue(0.4.toFloat())
            setPreviewPadding(0)
            setPreviewTextSize(60)
            setPreviewTransparentValue(0.6f)
            setIndexBarVisibility(true)
            setIndexBarStrokeVisibility(true)
            setIndexBarStrokeWidth(1)
            setIndexBarHighLightTextVisibility(true)
        }
        Objects.requireNonNull<RecyclerView.LayoutManager>(mRecyclerView?.layoutManager)
            .scrollToPosition(0)
    }
}