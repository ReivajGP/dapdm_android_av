package com.rgp.firstpractice.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rgp.firstpractice.R
import com.rgp.firstpractice.databinding.SongElementBinding
import com.rgp.firstpractice.model.Song
import com.rgp.firstpractice.view.activities.LyricsCatalogActivity

class SongsAdapter(private val context: Context, private val songs: ArrayList<Song>): RecyclerView.Adapter<SongsAdapter.ViewHolder>() {
    class ViewHolder(view: SongElementBinding): RecyclerView.ViewHolder(view.root) {
        val ivAlbum = view.ivAlbum
        val tvSong = view.tvSong
        val tvArtist = view.tvArtist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SongElementBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(songs[position].album)
            .placeholder(R.drawable.ic_album)
            .into(holder.ivAlbum)

        holder.tvSong.text = songs[position].song
        holder.tvArtist.text = songs[position].artist

        holder.itemView.setOnClickListener {
            if(context is LyricsCatalogActivity) context.songSelected(songs[position])
        }
    }

    override fun getItemCount(): Int = songs.size
}