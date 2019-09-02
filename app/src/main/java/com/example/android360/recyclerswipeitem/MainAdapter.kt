package com.example.android360.recyclerswipeitem

import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainAdapter(private val context: Context, private val user: ArrayList<User>, val dragDirs: Int, val swipeDirs: Int) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


   private var removePosition : Int= 0
    private var removeItem: String = ""


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(context).inflate(R.layout.list_data,parent,false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
            return user.count()

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val users:User = user[position]
        holder.textName.text = users.name
        holder.textId.text = users.id.toString()
        holder.img.setImageResource(users.images)

        holder.view.setOnClickListener {

            Toast.makeText(context,"You Clicked At ${users.name} and ${users.id}", Toast.LENGTH_LONG).show()


            val intent = Intent(context,FullUserDetail::class.java)
            intent.putExtra("name",users.name)
            intent.putExtra("id",users.id.toString())
            intent.putExtra("image",users.images)
            context.startActivity(intent)
        }

    }

       fun remove(viewHolder: RecyclerView.ViewHolder){

         removePosition = viewHolder.adapterPosition
           removeItem = user[viewHolder.adapterPosition].toString()


           user.removeAt(viewHolder.adapterPosition)
           notifyItemRemoved(viewHolder.adapterPosition)



     }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val textName: TextView = view.findViewById(R.id.textviewName)
        val textId: TextView = view.findViewById(R.id.textviewId)
        val img: ImageView = view.findViewById(R.id.imageview)

        }

    }
