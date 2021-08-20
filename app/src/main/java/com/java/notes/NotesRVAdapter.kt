package com.java.notes


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener : INotesRVAdapter) : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

     private val allNotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView : TextView = itemView.findViewById(R.id.text)
        val delete : ImageView = itemView.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : NoteViewHolder {
        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notes,parent,false))
        viewHolder.delete.setOnClickListener {
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
       return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    fun updateList(newList : List<Note>) {
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }

    interface INotesRVAdapter {
        fun onItemClicked(note : Note)
    }
}