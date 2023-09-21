package com.onurdemir.artbooktesting.repo

import androidx.lifecycle.LiveData
import com.onurdemir.artbooktesting.model.ImageResponse
import com.onurdemir.artbooktesting.roomd.Art
import com.onurdemir.artbooktesting.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art : Art)

    suspend fun deleteArt(art: Art)

    fun getArt() : LiveData<List<Art>>

    suspend fun searchImage(imageString : String) : Resource<ImageResponse>

}

/*
interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt() : LiveData<List<Art>>

    suspend fun searchImage(imageString : String) : Resource<ImageResponse>

}

 */