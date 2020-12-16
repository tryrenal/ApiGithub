package com.renaldysabdo.apigithub.data.source

import androidx.paging.PagingSource
import com.renaldysabdo.apigithub.data.response.UserResponse
import com.renaldysabdo.apigithub.data.service.ApiService
import retrofit2.HttpException
import java.io.IOException

private const val INDEX = 1

class GithubPagingSource (private val service: ApiService, private val name: String) : PagingSource<Int, UserResponse>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserResponse> {
        val position = params.key ?: INDEX
        return try {
          val response = service.searchUser(page = position, name = name)
          val repos = response.items
          LoadResult.Page(
              data = repos,
              prevKey = if (position == INDEX) null else position,
              nextKey = if (repos.isEmpty()) null else position + 1
          )
        } catch (e: IOException){
            return LoadResult.Error(e)
        } catch (e: HttpException){
            return  LoadResult.Error(e)
        }
    }
}