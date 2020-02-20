package com.goldendevs.testapplication.repoCallback

import com.goldendevs.testapplication.model.DataResponse

interface MovieRepoCallback {
    interface OnMovieRepoCallback {
        fun onSuccess(dataResponse: DataResponse)
        fun onFail(errMessage: String)
    }
}