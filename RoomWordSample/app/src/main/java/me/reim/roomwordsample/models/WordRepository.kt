package me.reim.roomwordsample.models

import androidx.lifecycle.LiveData

interface WordRepository {
    val allWords: LiveData<List<Word>>;
    suspend fun insert(word: Word)
}