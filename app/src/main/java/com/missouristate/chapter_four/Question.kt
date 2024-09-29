package com.missouristate.chapter_four

import androidx.annotation.StringRes

data class Question (@StringRes val textResId:Int, val answer: Boolean)
