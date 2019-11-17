package me.reim.roomwordsample.infrastructure

import androidx.lifecycle.LiveData
import me.reim.roomwordsample.models.Word
import me.reim.roomwordsample.models.WordRepository

class WordRepositoryImpl(private val wordDao: WordDao) : WordRepository {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    override val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    override suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
