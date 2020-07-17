package com.example.android.hilt.feature.savedstate.ui.widget

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Filter

class DropdownSelectAdapter<T>(
    context: Context,
    resource: Int,
    objects: List<T>
) : ArrayAdapter<T>(
    context,
    resource,
    objects
) {
    private val filter = KNoFilter()
    val items: List<T> = objects

    override fun getFilter(): Filter {
        return filter
    }

    inner class KNoFilter : Filter() {
        override fun performFiltering(p0: CharSequence?): FilterResults {
            val result = FilterResults()
            result.values = items
            result.count = items.size
            return result
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            notifyDataSetChanged()
        }
    }
}
