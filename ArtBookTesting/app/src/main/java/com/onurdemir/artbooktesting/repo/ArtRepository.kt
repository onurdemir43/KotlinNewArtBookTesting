package com.onurdemir.artbooktesting.repo

import  androidx.lifecycle.LiveData
import com.onurdemir.artbooktesting.api.RetrofitAPI
import com.onurdemir.artbooktesting.model.ImageResponse
import com.onurdemir.artbooktesting.roomd.Art
import com.onurdemir.artbooktesting.roomd.ArtDao
import com.onurdemir.artbooktesting.util.Resource
import javax.inject.Inject


class ArtRepository @Inject constructor (
    private val artDao : ArtDao,
    private val retrofitApi : RetrofitAPI) : ArtRepositoryInterface {

    override suspend fun insertArt(art: Art) {
        artDao.insertArt(art)
    }

    override suspend fun deleteArt(art: Art) {
        artDao.deleteArt(art)
    }

    override fun getArt(): LiveData<List<Art>> {
        return artDao.observeArts()
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return try {
            val response = retrofitApi.imageSearch(imageString)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error3",null)
            } else {
                Resource.error("Error4",null)
            }
        } catch (e: Exception) {
            Resource.error("No data!",null)
        }
    }


}

/*
class ArtRepository @Inject constructor(private val artDao: ArtDao, private val retrofitAPI: RetrofitAPI) : ArtRepositoryInterface {
    override suspend fun insertArt(art: Art) {
        artDao.insertArt(art)
    }

    override suspend fun deleteArt(art: Art) {
        artDao.deleteArt(art)
    }

    override fun getArt(): LiveData<List<Art>> {
        return artDao.observeArts()
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return try {
            val response = retrofitAPI.imageSearch(imageString)
            if (response.isSuccessful) {
                response.body().let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)
            } else {
                Resource.error("Error",null)
            }
        } catch (e: Exception) {
            Resource.error("No Data!",null)
        }
    }
}

 */