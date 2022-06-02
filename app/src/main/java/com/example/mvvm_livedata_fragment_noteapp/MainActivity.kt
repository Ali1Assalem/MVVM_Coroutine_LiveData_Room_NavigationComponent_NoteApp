package com.example.mvvm_livedata_fragment_noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_livedata_fragment_noteapp.DB.NoteDatabase
import com.example.mvvm_livedata_fragment_noteapp.Repository.NoteRepository
import com.example.mvvm_livedata_fragment_noteapp.ViewModel.NoteViewModel
import com.example.mvvm_livedata_fragment_noteapp.ViewModel.NoteViewModelProviderFactory
import com.example.mvvm_livedata_fragment_noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setUpViewModel()
    }



    private fun setUpViewModel(){
        val noteRepository = NoteRepository(
            NoteDatabase(this)
        )

        val viewModelProviderFactory =
            NoteViewModelProviderFactory(
                application,
                noteRepository
            )

        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        ).get(NoteViewModel::class.java)
    }



}