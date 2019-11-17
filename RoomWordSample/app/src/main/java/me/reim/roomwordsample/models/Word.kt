package me.reim.roomwordsample.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)

/**

@Entity(tableName = "word_table")
class Word {
  @PrimaryKey(autoGenerate = true)
  private int id;

  @NonNull
  private String word;
  //..other fields, getters, setters
}

 **/