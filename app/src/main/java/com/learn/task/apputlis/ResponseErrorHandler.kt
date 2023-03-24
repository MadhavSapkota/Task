package com.learn.task.apputlis

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

object ResponseErrorHandler {

    fun handleErrorResponse(e: Throwable): String {

        return when (e) {
            is HttpException -> {
                parseHTTPError(e.response()!!.errorBody())
            }

            is SocketTimeoutException -> {
                ApiConstants.TIME_OUT
            }

            is IOException -> {
                ApiConstants.SERVERERROR
            }
            else -> ApiConstants.SERVERERROR
        }
    }

    fun parseHTTPError(responseBody: ResponseBody?): String {
        try {
            val jsonObject=JSONObject(responseBody!!.string())
            try {
                val error=jsonObject.getJSONArray("message")
                return error[0].toString()
            } catch (ex: Exception) {

                try {
                    val error=jsonObject.getString("message")
                    return error.toString()
                } catch (ex: Exception) {

                    try {
                        val error=jsonObject.getString("detail")
                        return error.toString()
                    } catch (ex: Exception) {
                    }
                }
            }
        } catch (ex: Exception) {
            responseBody!!.close()
            return ""
        }
        responseBody.close()
        return ""
    }
}