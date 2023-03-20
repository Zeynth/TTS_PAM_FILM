package edu.uksw.fti.pam.film.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreName(private val context: Context){
    // to make sure there is only one instance
    companion object{
        private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("NameInput")
        val Firstname_KEY = stringPreferencesKey("first_name")
        val Lastname_KEY = stringPreferencesKey("last_name")
    }

    // untuk mendapatkan data firstname
    val getFName: Flow<String?> = context.dataStore.data
        .map{ preferences ->
            preferences[Firstname_KEY] ?: ""
        }

    // untuk menyimpan data first name
    suspend fun saveFName(fname: String){
        context.dataStore.edit { preferences ->
            preferences[Firstname_KEY] = fname
        }
    }

    // untuk mendapatkan data first name
    val getLName: Flow<String?> = context.dataStore.data
        .map{ preferences ->
            preferences[Lastname_KEY] ?: ""
        }


    // untuk menyimpan data last name
    suspend fun saveLName(lname: String) {
        context.dataStore.edit{ preferences ->
            preferences[Lastname_KEY] = lname
        }
    }
}