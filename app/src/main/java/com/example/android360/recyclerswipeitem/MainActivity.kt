package com.example.android360.recyclerswipeitem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.widget.LinearLayout

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val user = arrayListOf<User>()

        user.add(User("Rajat", 1, R.drawable.simple1))
        user.add(User("Trupal", 2, R.drawable.simple2))
        user.add(User("Sagar", 3, R.drawable.simple3))
        user.add(User("Shiv", 4, R.drawable.simple4))
        user.add(User("Krunal", 5, R.drawable.simple5))
        user.add(User("Rubby", 6, R.drawable.simple6))
        user.add(User("Tirth", 7, R.drawable.simple7))
        user.add(User("Nilesh", 8, R.drawable.simple8))
        user.add(User("Nisha", 9, R.drawable.girl))
        user.add(User("Sagar", 10, R.drawable.simple10))


        val adapter = MainAdapter(this, user,0,ItemTouchHelper.LEFT or(ItemTouchHelper.RIGHT))
        recyclerview.adapter = adapter


        val simpleCallback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                if (direction == ItemTouchHelper.LEFT) {

                adapter.remove(viewHolder)

                    Toast.makeText(this@MainActivity," Item is Removed From list", Toast.LENGTH_LONG).show()



                }
                if (direction==ItemTouchHelper.RIGHT){

                    adapter.remove(viewHolder)

                    Toast.makeText(this@MainActivity,"Item is Removed From list", Toast.LENGTH_LONG).show()
                }


            }
        }


        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(recyclerview)


    }




}