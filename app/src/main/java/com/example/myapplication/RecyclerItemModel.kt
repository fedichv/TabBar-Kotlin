package com.example.myapplication

open class RecyclerItemModel

class HeaderItemModel(val title: String): RecyclerItemModel()

class FollowItemModel(val image: Int, val name: String, val button: String): RecyclerItemModel()

class LikesItemModel(val image: Int, val name: String, val image2: Int): RecyclerItemModel()

