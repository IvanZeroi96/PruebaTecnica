package com.ivan.garcia.pruebatecnica.view.home

import UsersData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivan.garcia.pruebatecnica.R
import kotlinx.android.synthetic.main.card_user.view.*

class ListAdapter(val userClick: (String) -> Unit): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    var usersList: List<UsersData> = emptyList()

    fun setData(list: List<UsersData>){
        usersList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_user, parent,false))
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = usersList[position]
        holder.itemView.nameText.text = user.nombre.toUpperCase() + " " + user.apellidoPaterno.toUpperCase() + " " + user.apellidoMaterno.toUpperCase()
        holder.itemView.ageText.text = "Edad: " + user.edad.toString()
        holder.itemView.emailText.text = "Email: " + user.email
        holder.itemView.dateText.text = "Fecha Nacimiento: " + user.fechaNacimiento
        holder.itemView.userImageView.setImageResource(R.mipmap.ic_user)

        /*if(user.datos != null){
            if(user.datos.imagen != null){
                holder.itemView.userImageView.setImageResource(R.mipmap.ic_user)
            }else{
                try {
                    val image = decodeImageBase64(user.datos.imagen)
                    if(image != null){
                        holder.itemView.userImageView.setImageBitmap(image)
                    }else{
                        holder.itemView.userImageView.setImageResource(R.mipmap.ic_user)
                    }
                }catch (e: Exception){
                    holder.itemView.userImageView.setImageResource(R.mipmap.ic_user)
                }
            }
        }else{
            holder.itemView.userImageView.setImageResource(R.mipmap.ic_user)
        }*/
    }

    fun updateData(list: List<UsersData>){
        this.usersList = list
        notifyDataSetChanged()
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}