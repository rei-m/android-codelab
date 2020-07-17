package com.example.android.hilt.feature.savedstate.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SavedStateFirstViewModel(private val handle: SavedStateHandle) : ViewModel() {



    companion object {
        private const val KEY_ATTR = "attr"
    }
}