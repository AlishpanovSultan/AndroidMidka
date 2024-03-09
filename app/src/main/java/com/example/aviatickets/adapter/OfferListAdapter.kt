package com.example.aviatickets.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aviatickets.R
import com.example.aviatickets.databinding.ItemOfferBinding
import com.example.aviatickets.model.OfferDiffCallback
import com.example.aviatickets.model.entity.Offer

class OfferListAdapter : ListAdapter<Offer, OfferListAdapter.ViewHolder>(OfferDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemOfferBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)) // Use getItem to access the item at a given position
    }

    inner class ViewHolder(
        private val binding: ItemOfferBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(offer: Offer) {
            val flight = offer.flight

            with(binding) {
//                Glide
//                    .with(root.context)
//                    .load("https://logosandtypes.com/wp-content/uploads/2020/06/air-astana.svg")
//                    .placeholder(R.drawable.baseline_airplane_ticket_24)
//                     .into(airlineImage)

                departureTime.text = flight.departure_time_info
                arrivalTime.text = flight.arrival_time_info
                route.text = context.getString(
                    R.string.route_fmt,
                    flight.departure_location.code,
                    flight.arrival_location.code
                )
                duration.text = context.getString(
                    R.string.time_fmt,
                    getTimeFormat(flight.duration).first.toString(),
                    getTimeFormat(flight.duration).second.toString()
                )
                direct.text = context.getString(R.string.direct)
                price.text = context.getString(R.string.price_fmt, offer.price.toString())
            }
        }

        private fun getTimeFormat(minutes: Int): Pair<Int, Int> = Pair(
            first = minutes / 60,
            second = minutes % 60
        )

    }
}
