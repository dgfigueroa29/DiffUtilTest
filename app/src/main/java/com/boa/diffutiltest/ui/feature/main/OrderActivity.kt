package com.boa.diffutiltest.ui.feature.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.boa.diffutiltest.R
import com.boa.diffutiltest.datasource.DataSource
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.content_order.*

class OrderActivity : AppCompatActivity() {
    private val orderAdapter = OrderAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        setSupportActionBar(toolbar)
        initList()

        fab.setOnClickListener { view ->
            orderAdapter.setData(DataSource.drinks, false)
            Snackbar.make(view, getString(R.string.adding), Snackbar.LENGTH_SHORT)
                .setAction(getString(R.string.loading), null).show()
        }
    }

    private fun initList() {
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.itemAnimator = DefaultItemAnimator()
        rvList.adapter = orderAdapter
        orderAdapter.setData(DataSource.stuff, true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear -> {
                initList()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
